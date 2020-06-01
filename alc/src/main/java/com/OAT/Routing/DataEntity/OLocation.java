package com.OAT.Routing.DataEntity;

public abstract class OLocation extends ORegion {
    private double Latitude;
    private double Longitude;

    public OLocation(String regionID, double latitude, double longitude) {
        super(regionID);
        Latitude = latitude;
        Longitude = longitude;
    }

}
