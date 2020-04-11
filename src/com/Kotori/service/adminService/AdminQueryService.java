package com.Kotori.service.adminService;

import com.Kotori.dao.AdminDao.AdminDao;
import com.Kotori.domain.Admin;

import java.sql.SQLException;
import java.util.List;

public class AdminQueryService {
    public List<Admin> queryAllAdmin() throws SQLException {
        AdminDao dao = new AdminDao();
        return dao.queryAllAdmin();
    }
}
