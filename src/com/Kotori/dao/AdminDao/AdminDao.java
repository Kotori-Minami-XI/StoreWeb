package com.Kotori.dao.AdminDao;

import com.Kotori.domain.Admin;
import com.Kotori.jdbc.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminDao {
    /***
     *
     * @param adminName
     * @return Admin
     * @throws SQLException
     */
    public Admin queryAdmin(String adminName) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "SELECT * FROM admin_table WHERE adminName=?";
        return qr.query(sql,new BeanHandler<Admin>(Admin.class), adminName);
    }

    /***
     *
     * @return List<Admin>
     * @throws SQLException
     */
    public List<Admin> queryAllAdmin() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "SELECT * FROM admin_table";
        return qr.query(sql, new BeanListHandler<Admin>(Admin.class));
    }

}
