package com.OAT.Routing.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlConnection {
    private Statement statement;
    private Connection conn;
    private PreparedStatement ps;
    public SqlConnection() throws Exception{
        conn = JDBCUtils.getConnection();
        statement = conn.createStatement();
        conn.setAutoCommit(false); //设置手动提交
    }
    public ResultSet getObject(String sql){
        try {
            return statement.executeQuery(sql);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public int insertObject(String sql){
        System.out.println(sql);
        try {
            return statement.executeUpdate(sql);
        }catch (Exception e){
            System.out.println("这是sql内的错误");
            e.printStackTrace();
        }
        return 0;
    }
    public void insertObject()throws Exception{
        conn.commit();
        conn.close();
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
