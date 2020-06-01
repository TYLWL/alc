package com.OAT.Routing.test;


import com.OAT.Routing.DataAccess.*;
import com.OAT.Routing.sql.SqlConnection;

import java.sql.ResultSet;

public class Test {
    public static void main(String[] args) throws Exception{
        DBReader dbReader = new DBReader();
        dbReader.setSources();
        DataContainer container = null;
        container = dbReader.readData();
        System.out.println(container.getSource("ASU_BH").toString());

    }
}
