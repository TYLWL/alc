package com.OAT.Routing.test;


import com.OAT.Routing.DataAccess.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception{
        DataContext  context = new DataContext("2020-04-01","2020-04-30");
        System.out.println("main:"+context.getDataContainer().getTrailer("C76217").toString());
        System.out.println(context.getDataContainer().getSource("ASU_BH").toString());

    }
}
