package com.OAT.Routing.DataAccess;

import com.OAT.Routing.sql.SqlConnection;

public class DataContext {
    
	private static DataContainer dataContainer;
    private static SqlConnection sqlConnection;
    
    public DataContext(){
    	
    	try
    	{
    	   dataContainer =  new DataContainer();
    	   sqlConnection = new SqlConnection();
    	   createDataContainer();
    	   
    	}catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
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
