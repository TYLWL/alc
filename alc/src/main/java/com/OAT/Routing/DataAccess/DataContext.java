package com.OAT.Routing.DataAccess;

public class DataContext {
    private static DataContainer dataContainer;
    public DataContext(){
    }
    public void createDataContainer()throws Exception{
        DBReader dbReader = new DBReader();
        dataContainer = dbReader.readData();
    }
}
