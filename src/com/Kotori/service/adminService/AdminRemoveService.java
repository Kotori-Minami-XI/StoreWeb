package com.Kotori.service.adminService;

import com.Kotori.dao.AdminDao.AdminDao;

import javax.servlet.jsp.PageContext;
import java.sql.SQLException;

public class AdminRemoveService {
    public int removeAdmin(String name) throws SQLException {
        AdminDao dao = new AdminDao();
        return dao.removeAdmin(name);
    }
}
