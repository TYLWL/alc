package com.OAT.Routing.controller;

import com.OAT.Routing.DataAccess.DBReader;
import com.OAT.Routing.DataAccess.DataContainer;
import com.OAT.Routing.DataAccess.DataContext;
import com.OAT.Routing.DataEntity.*;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;


@Controller
public class LoginController {
    private DataContext dataContext = new DataContext();


    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping("/login")
    public @ResponseBody HashMap<String,String> login(@RequestBody User user,HttpServletRequest request)throws Exception{
        System.out.println("hello:"+user.toString());
        dataContext.setUser(user);
        String result = dataContext.getUser();
        System.out.println("result:"+result);
        HashMap<String,String>  map = new HashMap<>();
        map.put("result",result);
        if(result.equals("yes")){
            request.getSession().setAttribute("user",user);
        }
        return map;
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping("/orderMap")
    public @ResponseBody List<HashMap> getOrderList(@RequestBody HashMap<String,String> dataMap){
        String date = dataMap.get("date");
        String region = dataMap.get("region");
        String product = dataMap.get("product");
        System.out.println("date+"+date);
        System.out.println("region+"+region);
        System.out.println("product+"+product);
        dataContext.initDataContent(date,date);
        List<DailyOrder> orderList = dataContext.getDataContainer().getDailyOrderList();
        List<HashMap> orderPoint = new ArrayList<>();
        for (DailyOrder order:orderList){
            if(!order.getCustomer().getRegionID().equals(region) && !region.equals("") && order.getProductID().equals(product) ){
               continue;
            }
            HashMap<String,String> point = new HashMap<>();
            point.putAll(order.toMap());
            orderPoint.add(point);
        }
        System.out.println(orderPoint);
        return orderPoint;
    }

    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping("/sourceMap")
    public @ResponseBody List<Hashtable> getSourceList(@RequestBody HashMap<String,String> dataMap){
        String date = dataMap.get("date");
        String region = dataMap.get("region");
        String product = dataMap.get("product");
        System.out.println("region+"+region);
        System.out.println("product+"+product);
        dataContext.initDataContent(date,date);
        List<OSource> sourceList = dataContext.getDataContainer().getSourceList();

        List<Hashtable> sourcePoint = new ArrayList<>();
        for (OSource source:sourceList){

            if(!source.getRegionID().equals(region) && !region.equals("") && source.getQuantity(date,product)==null){
                continue;
            }
            Hashtable point = new Hashtable<>();
            point.putAll(source.toMap());
            point.putAll(source.getSourceAvailableQuantity());
            sourcePoint.add(point);
        }

        return sourcePoint;
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping("/getOption")
    public @ResponseBody Hashtable getOptionList(){
        dataContext.initDataContent("2020-01-01","2020-12-31");
        List<ORegion> regionList = dataContext.getDataContainer().getRegions();
        List<OProduct> productList = dataContext.getDataContainer().getProducts();
        List<ODepot> depotList = dataContext.getDataContainer().getDepots();

        List<Hashtable> regions = new ArrayList<>();
        List<Hashtable> depots = new ArrayList<>();
        List<Hashtable> products = new ArrayList<>();
        for(OProduct o:productList){
            Hashtable hp = new Hashtable();
            hp.putAll(o.toMap());
            products.add(hp);
        }
        for(ORegion o:regionList){
            Hashtable hr = new Hashtable();
            hr.putAll(o.toMap());
            regions.add(hr);
        }
        for(ODepot o:depotList){
            Hashtable hd = new Hashtable();
            hd.putAll(o.toMap());
            depots.add(hd);
            System.out.println(o.toString());
        }
        Hashtable hall = new Hashtable();
        hall.put("region",regions);
        hall.put("product",products);
        hall.put("depot",depots);
        System.out.println(hall);
        return hall;
    }

    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping("/index")
    public String index(Model model){
        OProduct product = new OProduct("NI","氮气");
        Gson gson = new Gson();
        String json = gson.toJson(product);
        System.out.println(json);
        return "index";
    }



    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping("/get")
    public @ResponseBody String get(){
        OProduct product = new OProduct("NI","氮气");
        Gson gson = new Gson();
        String json = gson.toJson(product);
        System.out.println(json);
        return json;
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @PostMapping("/post")
    public String post(@RequestBody Testbb test){
        String cname = test.getCname();
        String age = test.getAge();
        System.out.println(cname+",hello,"+age);
        return "index";
    }
}
class Testbb{
    String cname;
    String age;
    Testbb(){

    }
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}