package com.Kotori.servlet.AdminServlet;

import com.Kotori.service.adminService.AdminRemoveService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AdminRemoveServlet")
public class AdminRemoveServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String aid = req.getParameter("aid");

            AdminRemoveService removeService = new AdminRemoveService();
            int serviceCode = removeService.removeAdmin(aid);
            switch (serviceCode) {
                case 0:
                    req.setAttribute("RemoveStatus", "删除失败");
                    break;
                case 1:
                    req.setAttribute("RemoveStatus", "已经成功删除管理员");

                    // Remove succeed and reload current admin list
                    resp.sendRedirect(req.getContextPath() + "/adminModule/account.jsp");
                    break;
                default:
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
