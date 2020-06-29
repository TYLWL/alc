package com.OAT.Routing.test;


import com.OAT.Routing.DataAccess.*;
import com.OAT.Routing.DataEntity.ORoute;
import com.OAT.Routing.DataEntity.User;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Pattern;


public class Test {



    public static void main(String[] args) throws Exception{
        ArrayList a = new ArrayList();
        Hashtable b = new Hashtable();
        b.put("hello",45);
        b.put("hellll",55);
        a.add(b);
        a.add("hello");
        a.add("kkkkk");
        System.out.println(a);
    }
}
