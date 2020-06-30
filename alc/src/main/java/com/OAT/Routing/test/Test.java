package com.OAT.Routing.test;


import com.OAT.Routing.DataAccess.*;
import com.OAT.Routing.DataEntity.ORoute;
import com.OAT.Routing.DataEntity.User;
import com.OAT.Routing.sql.SqlConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Pattern;


public class Test {



    public static void main(String[] args) throws Exception{
    	SqlConnection sqlConnection = new SqlConnection();
        ResultSet rs = sqlConnection.getObject("select * from product");
        while (rs.next()){
            System.out.println(rs.getString("ProductID"));
        }
    }
}
