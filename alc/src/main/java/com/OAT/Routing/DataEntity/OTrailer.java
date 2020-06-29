package com.OAT.Routing.DataEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;

public class OTrailer {
    private String TrailerID;
    private String ProductID;
    private Hashtable<String,String> trailerAttrData = new Hashtable<>();
    private ODepot homeDepot;

    private HashMap<Date, Boolean> isTrailerAvailOnDay = new HashMap<>();
    private HashMap<Date,Hashtable<String, String>> dailyAttributeData = new HashMap<>();
    private String Description;

    public OTrailer(String trailerID) {
        TrailerID = trailerID;
    }

    public OTrailer(String trailerID, String productID, String description) {
        TrailerID = trailerID;
        ProductID = productID;
        Description = description;

    }

    @Override
    public String toString() {
        return "OTrailer{" +
                "TrailerID='" + TrailerID + '\'' +
                ", ProductID='" + ProductID + '\'' +
                ", trailerAttrData=" + trailerAttrData +
                ", homeDepot=" + homeDepot +
                ", isTrailerAvailOnDay=" + isTrailerAvailOnDay +
                ", dailyAttributeData=" + dailyAttributeData +
                ", Description='" + Description + '\'' +
                '}';
    }

    public void setTrailerAvailOnDay(Date date, Boolean isAvail) {
        this.isTrailerAvailOnDay.put(date,isAvail);
    }

    public HashMap<Date, Boolean> getIsTrailerAvailOnDay() {
        return isTrailerAvailOnDay;
    }

    public HashMap<Date, Hashtable<String, String>> getDailyAttributeData() {
        return dailyAttributeData;
    }

    public String getDailyAttributeData(Date date,String attribute){
        return dailyAttributeData.get(date).get(attribute);
    }
    public void setDailyAttributeData(Date date, Hashtable<String, String> dailyData) {
        this.dailyAttributeData.put(date, dailyData);
    }

    public void addTrailerAttrData(String attribute, String data){
        trailerAttrData.put(attribute, data);
    }

    public ODepot getHomeDepot() {
        return homeDepot;
    }

    public void setHomeDepot(ODepot homeDepot) {
        this.homeDepot = homeDepot;
    }

    public String getTrailerAttrData(String attribute) {
        return trailerAttrData.get(attribute);
    }

    public String getTrailerID() {
        return TrailerID;
    }

    public void setTrailerID(String trailerID) {
        TrailerID = trailerID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
