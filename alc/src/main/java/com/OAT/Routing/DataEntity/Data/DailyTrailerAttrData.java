package com.OAT.Routing.DataEntity.Data;

import com.OAT.Routing.DataEntity.Attribute.TrailerAttribute;

public class DailyTrailerAttrData extends TrailerAttribute {
    private String data;

    public DailyTrailerAttrData(String regionID, double latitude, double longitude, String depotID, String trailerID, String trailerAttrID, String data) {
        super(regionID, latitude, longitude, depotID, trailerID, trailerAttrID);
        this.data = data;
    }
}
