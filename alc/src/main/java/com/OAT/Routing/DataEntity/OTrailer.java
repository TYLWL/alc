package com.OAT.Routing.DataEntity;
import java.util.*;

public class OTrailer  {
    private String TrailerID;
    private String ProductID;
    private String Description;
    
    private ODepot _homeDepot;
    
    private HashMap<Date, Boolean> _isTrailerAvailOnDay = new HashMap();
    private HashMap<String, String> _attribute = new HashMap();
    private HashMap<Date,HashMap<String, String>> _dailyAttribute = new HashMap();
    

    public OTrailer(String regionID, double latitude, double longitude, String depotID, String trailerID) {
        super(regionID, latitude, longitude, depotID);
        TrailerID = trailerID;
    }

    public OTrailer(String regionID, double latitude, double longitude, String depotID, String trailerID, String productID, String description) {
        super(regionID, latitude, longitude, depotID);
        TrailerID = trailerID;
        ProductID = productID;
        Description = description;
    }
    
    public void setTailerAvailability(Date day, Boolean isAvail)
    {
    	_isTrailerAvailOnDay.put(day, isAvail);
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

    @Override
    public String getDescription() {
        return Description;
    }

    @Override
    public void setDescription(String description) {
        Description = description;
    }
}
