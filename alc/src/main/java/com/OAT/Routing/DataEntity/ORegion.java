package com.OAT.Routing.DataEntity;

public abstract class ORegion {
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
