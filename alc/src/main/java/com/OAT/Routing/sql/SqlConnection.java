package com.OAT.Routing.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlConnection {
    Statement statement;
    public SqlConnection() throws Exception{
        Connection conn = JDBCUtils.getConnection();
        statement = conn.createStatement();
    }
    public ResultSet getObject(String sql) throws Exception{
        System.out.println(sql);
        try {
            return statement.executeQuery(sql);
        }catch (Exception e){
            return null;
        }

    }
}
