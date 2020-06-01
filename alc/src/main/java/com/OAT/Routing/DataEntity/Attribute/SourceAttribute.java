package com.OAT.Routing.DataEntity.Attribute;

import com.OAT.Routing.DataEntity.DailySource;

public class SourceAttribute extends DailySource {
    private String SourceAttrID;
    private String Type;
    private String Description;

    public SourceAttribute(String regionID, double latitude, double longitude, String sourceID, String productID, String sourceAttrID) {
        super(regionID, latitude, longitude, sourceID, productID);
        SourceAttrID = sourceAttrID;
    }

    public SourceAttribute(String regionID, double latitude, double longitude, String sourceID, String productID, String sourceAttrID, String type, String description) {
        super(regionID, latitude, longitude, sourceID, productID);
        SourceAttrID = sourceAttrID;
        Type = type;
        Description = description;
    }
}
