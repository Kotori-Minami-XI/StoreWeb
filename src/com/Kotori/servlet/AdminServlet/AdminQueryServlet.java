package com.Kotori.servlet.AdminServlet;


import com.Kotori.domain.Admin;
import com.Kotori.service.adminService.AdminQueryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/AdminQueryServlet")
public class AdminQueryServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Obtain all admins from DB and store them in request field
            AdminQueryService service = new AdminQueryService();
            List<Admin> adminList = service.queryAllAdmin();
            req.setAttribute("adminList", adminList);

            req.getRequestDispatcher("/adminModule/account.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
