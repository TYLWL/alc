package com.OAT.Routing.DataAccess;

import com.OAT.Routing.DataEntity.User;
import com.OAT.Routing.sql.SqlConnection;

import java.sql.ResultSet;
import java.util.*;
public class DataContext {

    private static DataContainer dataContainer;
    private static SqlConnection sqlConnection;
    private String _startDay;
    private String _endDay;
    private User user = new User();

    public DataContext() {
        try{
            sqlConnection = new SqlConnection();
            dataContainer =  new DataContainer();
            createDataContainer();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void  initDataContent(String start, String end){
        try
        {
            _startDay = start;
            _endDay = end;
            dataContainer =  new DataContainer();
            sqlConnection = new SqlConnection();
            createDataContainer();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void setUser(User user){
        this.user = user;
    }
    public String getUser()throws Exception{
        ResultSet rs = sqlConnection.getObject("select * from master_user where username = '" + this.user.getUsername() +"'");
        if(!rs.next()){
            return "no user,please input right user";
        }
        String username = rs.getString("username");
        String password = rs.getString("password");
        System.out.println("real password"+password);
        if(this.user.getPassword().equals(password)){
            return "yes";
        }
        else {
            return "password error";
        }
    }
    public String getStartDay()
    {
        return _startDay;
    }

    public String getEndDay()
    {
        return _endDay;
    }
    public void createDataContainer()throws Exception{
        DBReader dbReader = new DBReader(this);
        dbReader.readData();
    }
    public void createDailyDataContainer()throws Exception{
        DBReader dbReader = new DBReader(this);
        dbReader.readDailyData();
    }



    public DataContainer getDataContainer()
    {
        return dataContainer;
    }

    public SqlConnection getSqlConnection() {
        return sqlConnection;
    }
}