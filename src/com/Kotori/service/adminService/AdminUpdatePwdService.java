package com.Kotori.service.adminService;

import com.Kotori.dao.AdminDao.AdminDao;
import com.Kotori.domain.Admin;

import java.sql.SQLException;

public class AdminUpdatePwdService {
    public int updatePwd(String aid, String oldPwd, String newPwd) throws SQLException {
        AdminDao dao = new AdminDao();

        // Get the current pwd from Data Base
        Admin admin = dao.queryAdminById(aid);

        if (null != admin && admin.getPwd() == oldPwd) {
            return dao.updatePwd(aid, newPwd); // Password correct and update pwd
        } else {
            return 0; // Password incorrect
        }
    }
}
