package com.Kotori.servlet.AdminServlet;

import com.Kotori.service.adminService.AdminUpdatePwdService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminUpdatePwdServlet")
public class AdminUpdatePwdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String aid = req.getParameter("aid");
            String oldPwd = req.getParameter("oldPwd");
            String newPwd = req.getParameter("newPwd");

            AdminUpdatePwdService updatePwdService = new AdminUpdatePwdService();
            int serviceCode = updatePwdService.updatePwd(aid, oldPwd, newPwd);

            switch (serviceCode){
                case 0:
                    req.setAttribute("UpdatePwdStatus","管理员密码更新失败");
                    break;
                case 1:
                    req.setAttribute("UpdatePwdStatus","管理员密码更新成功");
                    break;
                default:
                    throw new Exception("密码更新时发生异常");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            req.getRequestDispatcher("/AdminQueryServlet").forward(req, resp);
        }
    }
}
