package com.OAT.Routing.DataEntity;

import java.util.Hashtable;

public class ORegion {
    private String RegionID;
    private String Description;
    public ORegion(){
    }
    public ORegion(String regionID) {
        RegionID = regionID;
    }

    public ORegion(String regionID, String description) {
        RegionID = regionID;
        Description = description;
    }
    public Hashtable toMap(){
        Hashtable h = new Hashtable();
        h.put("RegionID",RegionID);
        if(this.Description != null){
            h.put("Description",Description);
        }
        return h;
    }
    public String getRegionID() {
        return RegionID;
    }

    public void setRegionID(String regionID) {
        RegionID = regionID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
