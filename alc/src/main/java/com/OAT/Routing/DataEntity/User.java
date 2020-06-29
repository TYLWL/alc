package com.OAT.Routing.DataEntity;

import com.OAT.Routing.sql.SqlConnection;

import java.sql.ResultSet;

public class User {
    private String username;
    private String password;
    private SqlConnection sqlConnection;

    public User() {
    }

    public User(String username, String password) throws Exception{
        this.username = username;
        this.password = password;
        sqlConnection = new SqlConnection();
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
