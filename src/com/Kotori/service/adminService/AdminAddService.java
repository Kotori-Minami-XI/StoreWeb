package com.Kotori.service.adminService;

import com.Kotori.dao.AdminDao.AdminDao;

import java.sql.SQLException;

public class AdminAddService {
    public int addAdmin(String adminName, String pwd) throws Exception {
        AdminDao dao = new AdminDao();
        return dao.addAdmin(adminName, pwd);
    }
}
