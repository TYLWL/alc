package com.OAT.Routing.DataEntity.Data;

import com.OAT.Routing.DataEntity.Attribute.SourceAttribute;

public class SourceAttrData extends SourceAttribute {
    private String data;

    public SourceAttrData(String regionID, double latitude, double longitude, String sourceID, String productID, String sourceAttrID, String data) {
        super(regionID, latitude, longitude, sourceID, productID, sourceAttrID);
        this.data = data;
    }
}
