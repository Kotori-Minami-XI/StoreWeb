package com.Kotori.servlet.AdminServlet;


import com.Kotori.service.adminService.AdminAddService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminAddServlet")
public class AdminAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String adminName = req.getParameter("adminName");
            String pwd = req.getParameter("pwd");
            AdminAddService addService = new AdminAddService();

            int serviceCode = addService.addAdmin(adminName, pwd);
            switch (serviceCode){
                case 1:
                    //req.setAttribute("AddStatus","管理员添加成功！");
                    req.getSession().setAttribute("AddStatus", "管理员添加成功！");
                    break;
                default:
                    throw new Exception("添加异常");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            resp.sendRedirect(req.getContextPath() + "/adminModule/account.jsp");
        }
    }
}
