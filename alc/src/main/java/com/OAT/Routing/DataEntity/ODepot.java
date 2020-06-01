package com.OAT.Routing.DataEntity;

public class ODepot extends OLocation {
    private String DepotID;
    private int MaxTrailers;
    private String Description;

    public ODepot(String regionID, double latitude, double longitude, String depotID) {
        super(regionID, latitude, longitude);
        DepotID = depotID;
    }

    public ODepot(String regionID, double latitude, double longitude, String depotID, int maxTrailers, String description) {
        super(regionID, latitude, longitude);
        DepotID = depotID;
        MaxTrailers = maxTrailers;
        Description = description;
    }

    public String getDepotID() {
        return DepotID;
    }

    public void setDepotID(String depotID) {
        DepotID = depotID;
    }

    public int getMaxTrailers() {
        return MaxTrailers;
    }

    public void setMaxTrailers(int maxTrailers) {
        MaxTrailers = maxTrailers;
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
