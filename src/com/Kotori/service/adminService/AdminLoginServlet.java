package com.Kotori.service.adminService;

import com.Kotori.dao.AdminDao;
import com.Kotori.domain.Admin;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;


/***
 * @Class: adminLoginServlet
 * @Brief: Retrieve admin info from DaoAdmin and validate admin
 * @Paras: None
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("--------------------service-----------------------------");

        AdminDao dao = new AdminDao();
        Admin admin = dao.getAdmin();

        req.getRequestDispatcher("/adminModule/admin_index.jsp").forward(req,res);
    }
}



