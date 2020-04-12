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
    public Admin queryAdminByName(String adminName) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "SELECT * FROM admin_table WHERE adminName=?";
        return qr.query(sql,new BeanHandler<Admin>(Admin.class), adminName);
    }

    /***
     *
     * @param aid
     * @return Admin
     * @throws SQLException
     */
    public Admin queryAdminById(String aid) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "SELECT * FROM admin_table WHERE aid=?";
        return qr.query(sql,new BeanHandler<Admin>(Admin.class), aid);
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

    /***
     *
     * @param  aid
     * @return serviceCode
     * @throws SQLException
     */
    public int removeAdmin(String aid) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "DELETE FROM admin_table WHERE aid=?";
        return qr.execute(sql, aid);
    }

    /***
     *
     * @param adminName
     * @param pwd
     * @return serviceCode
     * @throws Exception
     */
    public int addAdmin(String adminName, String pwd) throws Exception {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "INSERT INTO admin_table (adminName,pwd) value (?,?)";
        return qr.execute(sql, adminName, pwd);
    }

    /***
     *
     * @param aid
     * @param newPwd
     * @return serviceCode
     * @throws SQLException
     */
    public int updatePwd(String aid, String newPwd) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "UPDATE admin_table SET pwd=? WHERE aid=?";
        return qr.execute(sql, newPwd, aid);
    }
}
