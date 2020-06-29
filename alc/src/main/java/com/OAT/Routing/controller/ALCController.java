package com.OAT.Routing.controller;

import com.OAT.Routing.DataAccess.DBWrite;
import com.OAT.Routing.DataAccess.DataContext;
import com.OAT.Routing.DataEntity.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.regex.Pattern;


@Controller
public class ALCController {
    private static DataContext dataContext = new DataContext();
    private static DBWrite dbWrite;


    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public  HashMap<String,String> login(@RequestBody User user,HttpServletRequest request)throws Exception{
        //@RequsetBody User是用来获取登录页面提交的账号和密码信息的
        //HttpServletRequest request用来设置session

        System.out.println("hello:"+user.toString());
        dataContext.setUser(user);
        String result = dataContext.getUser();//判断用户是否存在
        HashMap<String,String>  map = new HashMap<>();
        map.put("result",result);
        if(result.equals("yes")){//如果账号密码验证正确，则设置session值
            request.getSession().setAttribute("user",user);
        }
        return map;//返回验证结果
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value = "/orderMap",method = RequestMethod.POST)
    @ResponseBody
    public List<HashMap> getOrderList(@RequestBody HashMap<String,String> dataMap){
        //dataMap用于接收前端传过来的数据，以HashMap类型存储

        // 获取前端选择的要求
        String date = dataMap.get("date");
        String region = dataMap.get("region");
        String product = dataMap.get("product");
        dataContext.initDataContent(date,date);
        List<DailyOrder> orderList = dataContext.getDataContainer().getDailyOrderList();
        List<HashMap> orderPoint = new ArrayList<>();
        for (DailyOrder order:orderList){
            //判断是否符合选择的要求
            if(!order.getCustomer().getRegionID().equals(region) && !region.equals("") && order.getProductID().equals(product) ){
               continue;
            }
            HashMap<String,String> point = new HashMap<>();
            point.putAll(order.toMap());
            //将订单放入List中存储
            orderPoint.add(point);
        }
        //返回符合订单
        return orderPoint;
    }

    //与上面的订单相同
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value = "/sourceMap",method =RequestMethod.POST)
    @ResponseBody
    public List<Hashtable> getSourceList(@RequestBody HashMap<String,String> dataMap){
        String date = dataMap.get("date");
        String region = dataMap.get("region");
        String product = dataMap.get("product");
        dataContext.initDataContent(date,date);
        List<OSource> sourceList = dataContext.getDataContainer().getSourceList();
        List<Hashtable> sourcePoint = new ArrayList<>();
        for (OSource source:sourceList){
            if(!source.getRegionID().equals(region) && !region.equals("") && source.getQuantity(date,product) == null){
                continue;
            }
            Hashtable point = new Hashtable<>();
            point.putAll(source.toMap(date,product));
            sourcePoint.add(point);
        }
        System.out.println(sourcePoint);
        return sourcePoint;
    }

    //返回前端可以选择的要求，product和region
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping("/getOption")
    @ResponseBody
    public Hashtable getOptionList(){
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
        }
        Hashtable hall = new Hashtable();
        hall.put("region",regions);
        hall.put("product",products);
        hall.put("depot",depots);
        //返回数据
        return hall;
    }

    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value = "/getRoute",method = RequestMethod.GET)
    public @ResponseBody Hashtable<String, Hashtable> getRoute(){

        //这是正则表达式，判断visitID是属于哪一类的
        String depotRegular = "Depot_.*";
        String ASURegular = "ASU_.*";
        List<ORoute> routes = dataContext.getDataContainer().getRoutes();

        Hashtable<String,Hashtable> routeLines = new Hashtable<>();
        for(ORoute o:routes){
            System.out.println(o);
            // 存放一个trailer的所有路径，如[{1,第一个点信息},{2,第二个点信息}]
            Hashtable indexTable = new Hashtable();

            //存放trailer目标点的信息
            Hashtable pointTable = new Hashtable();

            //存放目标坐标点
            Hashtable point = new Hashtable();
            String visitID = o.getVisitID();

            //判断目标是ASU、Depot或者order
            if(Pattern.matches(depotRegular,visitID)){
                ODepot depot = dataContext.getDataContainer().getDepot(visitID);
                point.put("Longitude",depot.getLongitude());
                point.put("Latitude",depot.getLatitude());
                pointTable.put("visitID","Depot："+depot.getDepotID());
            }
            else if(Pattern.matches(ASURegular,visitID)){
                OSource source = dataContext.getDataContainer().getSource(visitID);
                point.put("Longitude",source.getLongitude());
                point.put("Latitude",source.getLatitude());
                pointTable.put("visitID","ASU："+source.getSourceID());
            }
            else {
                DailyOrder order = dataContext.getDataContainer().getDailyOrder(visitID);
                point.put("Longitude",order.getCustomer().getLongitude());
                point.put("Latitude",order.getCustomer().getLatitude());
                pointTable.put("visitID","订单："+order.getOrderID());
            }
            pointTable.put("coordinate",point);
            pointTable.put("product",o.getProductID());
            pointTable.put("region",o.getRegionID());
            pointTable.put("date",o.getDate());

            // 判断路径中trailer是否存在，
            // 如果不存在，新建一个trailer route存放trailer的路径
            // 如果存在，则把上面设置好的目标点存进响应trailer的路径中
            if(routeLines.get(o.getTrailerID()) == null){
                indexTable.put(o.getSequence(),pointTable);
                routeLines.put(o.getTrailerID(),indexTable);
            }
            else {
                routeLines.get(o.getTrailerID()).put(o.getSequence(),pointTable);
            }
        }
        //返回所有路径
        return routeLines;
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
        public @ResponseBody String uploadFile(@RequestBody String fileList)throws Exception{
        JSONObject reqJson=JSONObject.parseObject(fileList);
        String type=reqJson.getString("type");
        String excel =reqJson.getString("fileList");//json型集合
        JSONArray data =JSONObject.parseArray(excel);
        System.out.println("type:"+type);
        dbWrite = new DBWrite();
        Iterator<Object> iterator =data.iterator();
        Integer i = 0;
        Object object = null;
        while (iterator.hasNext()){
            i++;
            JSONObject json =(JSONObject)iterator.next();
            switch (type){
                case "route":
                    object = new ORoute(json.getString("Date"),json.getString("ProductID"),json.getString("RegionID"),json.getString("TrailerID"),json.getInteger("sequence"),json.getString("VisitID"),json.getDouble("quantity"));
                    break;
                case "product":
                    object = new OProduct(json.getString("ProductID"),json.getString("Description"));
                    break;
                case "productGrade":
                    object = new OProductGrade(json.getString("ProductID"),json.getString("ProductGradeID"),json.getString("Description"));
                    break;
                case "region":
                    object = new ORegion(json.getString("RegionID"),json.getString("Description"));
                    break;
                case "productSpec":
                    object = new OProductSpec(json.getString("ProductID"),json.getString("ProductSpecID"),json.getString("ProductSpecType"),json.getString("Description"));
                    break;
                case "emissionStandard":
                    object = new OEmissionStandard(json.getString("EmissionStandardID"),json.getString("Description"));
                    break;
                default:return "error";

            }
            int b = 0;
            try{
                if(dbWrite.saveObject(type,object)>0){
                    System.out.println("第"+i+"行插入成功");
                }
                else {
                    return "line"+i+",insert failed";
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return "yes";
    }

    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping("/index")
    public String index(Model model){
        return "index";
    }

}