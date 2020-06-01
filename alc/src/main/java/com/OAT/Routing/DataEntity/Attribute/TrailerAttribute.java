package com.OAT.Routing.DataEntity.Attribute;

import com.OAT.Routing.DataEntity.OTrailer;

public class TrailerAttribute extends OTrailer {
    private String TrailerAttrID;
    private String Type;
    private String Description;

    public TrailerAttribute(String regionID, double latitude, double longitude, String depotID, String trailerID, String trailerAttrID) {
        super(regionID, latitude, longitude, depotID, trailerID);
        TrailerAttrID = trailerAttrID;
    }

    public TrailerAttribute(String regionID, double latitude, double longitude, String depotID, String trailerID, String trailerAttrID, String type, String description) {
        super(regionID, latitude, longitude, depotID, trailerID);
        TrailerAttrID = trailerAttrID;
        Type = type;
        Description = description;
    }
}
