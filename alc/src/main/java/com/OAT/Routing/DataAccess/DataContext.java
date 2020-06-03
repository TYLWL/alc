package com.OAT.Routing.DataAccess;

import com.OAT.Routing.sql.SqlConnection;
import java.util.*;
public class DataContext {

    private static DataContainer dataContainer;
    private static SqlConnection sqlConnection;
    private String _startDay;
    private String _endDay;


    public DataContext(String start, String end){

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



    public DataContainer getDataContainer()
    {
        return dataContainer;
    }

    public SqlConnection getSqlConnection() {
        return sqlConnection;
    }
}