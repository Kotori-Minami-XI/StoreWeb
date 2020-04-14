package com.Kotori.service.adminService;

import com.Kotori.dao.AdminDao.AdminDao;
import com.Kotori.domain.Admin;

import java.sql.SQLException;

public class AdminUpdatePwdService {
    public int updatePwd(String adminName, String oldPwd, String newPwd) throws SQLException {
        AdminDao dao = new AdminDao();

        // Get the current pwd from Data Base
        Admin admin = dao.queryAdminByName(adminName);

        assert (null != admin);
        if (admin.getPwd().equals(oldPwd)) {
            return dao.updatePwd(admin.getAid().toString(), newPwd); // Password correct and update pwd
        } else {
            return 0; // Password incorrect
        }
    }
}
