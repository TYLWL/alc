package com.OAT.Routing.DataEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;

public class DailySource extends OSource {
    private String ProductID;
    private Date Date;
    private double AvailableQuality;
    private String Description;

    public DailySource(String regionID, double latitude, double longitude, String sourceID, String productID) {
        super(regionID, latitude, longitude, sourceID);
        ProductID = productID;
    }

    public DailySource(String regionID, double latitude, double longitude, String sourceID, String productID, java.util.Date date, double availableQuality, String description) {
        super(regionID, latitude, longitude, sourceID);
        ProductID = productID;
        Date = date;
        AvailableQuality = availableQuality;
        Description = description;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public double getAvailableQuality() {
        return AvailableQuality;
    }

    public void setAvailableQuality(double availableQuality) {
        AvailableQuality = availableQuality;
    }

    @Override
    public String getDescription() {
        return Description;
    }

    @Override
    public void setDescription(String description) {
        Description = description;
    }
}
