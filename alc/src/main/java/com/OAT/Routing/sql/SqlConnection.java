package com.OAT.Routing.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlConnection {
    private Statement statement;
    public SqlConnection() throws Exception{
        Connection conn = JDBCUtils.getConnection();
        statement = conn.createStatement();
    }
    public ResultSet getObject(String sql){
        try {
            return statement.executeQuery(sql);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
