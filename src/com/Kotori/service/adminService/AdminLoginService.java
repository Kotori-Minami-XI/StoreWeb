package com.Kotori.service.adminService;

import com.Kotori.dao.AdminDao.AdminDao;
import com.Kotori.domain.Admin;
import java.sql.SQLException;

/***
 * @Class: AdminLoginService
 * @Brief: Login Service for admin login request
 * @Paras: None
 *
 */
public class AdminLoginService {
    public int validateAdmin(String adminName, String pwd) throws SQLException {
        AdminDao dao = new AdminDao();
        Admin admin = dao.queryAdmin(adminName);

        if (admin == null){
            return 2; // Admin not found
        }
        if (pwd.equals(admin.getPwd())){
            return 0; // Admin found, pwd correct
        }
        else{
            return 1; // Admin found, pwd incorrect
        }
    }
}
