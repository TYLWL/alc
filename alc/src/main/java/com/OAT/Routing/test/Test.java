package com.OAT.Routing.test;


import com.OAT.Routing.DataAccess.*;

import java.text.SimpleDateFormat;

public class Test {
    public static void main(String[] args) throws Exception{
        DataContext  context = new DataContext(new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-01"),new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-30"));
        System.out.println("main:"+context.getDataContainer().getSource("ASU_BH").toString());
    }
}
