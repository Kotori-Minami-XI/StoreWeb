package com.Kotori.servlet.AdminServlet;

import com.Kotori.service.adminService.AdminLoginService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * @Class: adminLoginServlet
 * @Brief: Retrieve admin info from DaoAdmin and validate admin
 * @Paras: None
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String adminName = req.getParameter("username");
            String pwd = req.getParameter("password");

            AdminLoginService loginService = new AdminLoginService();
            int serviceCode = loginService.validateAdmin(adminName, pwd);

            // Save username in case of a failed Login
            req.setAttribute("lastUsername", adminName);

            switch (serviceCode) {
                case 0:
                    req.getSession().setAttribute("username", adminName);

                    // Override JSESSIONID so that the cookie with JSESSIONID persists on browser side
                    String sessionId = req.getSession().getId();
                    Cookie cookie = new Cookie("JSESSIONID", sessionId);
                    cookie.setMaxAge(24 * 60 * 60); // Cookie will expire time (seconds)
                    resp.addCookie(cookie);
                    System.out.println("sessionId:" + sessionId);

                    // Login succeed and continue to obtain admin list by AdminQueryServlet
                    resp.sendRedirect(req.getContextPath() + "/adminModule/account.jsp");
                    break;
                case 1:
                    req.getSession().setAttribute("error","密码错误");
                    req.getRequestDispatcher("/adminModule/admin_login.jsp").forward(req, resp);
                    break;
                case 2:
                    req.getSession().setAttribute("error","用户不存在");
                    req.getRequestDispatcher("/adminModule/admin_login.jsp").forward(req, resp);
                    break;
                default:
                    throw new Exception( "登录异常！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



