package com.OAT.Routing.DataEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;

public class OTrailer {
    private String TrailerID;
    private String ProductID;
    private Hashtable<String,String> trailerAttrData;
    private ODepot homeDepot;

    private Hashtable<Date, Boolean> isTrailerAvailOnDay = new Hashtable<>();
    private Hashtable<Date,HashMap<String, String>> dailyAttribute = new Hashtable<>();
    private String Description;

    public OTrailer(String trailerID) {
        TrailerID = trailerID;
    }

    public OTrailer(String trailerID, String productID, String description) {
        TrailerID = trailerID;
        ProductID = productID;
        Description = description;
        trailerAttrData = new Hashtable<>();
    }

    @Override
    public String toString() {
        return "OTrailer{" +
                "TrailerID='" + TrailerID + '\'' +
                ", ProductID='" + ProductID + '\'' +
                ", trailerAttrData=" + trailerAttrData +
                ", Description='" + Description + '\'' +
                '}';
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
