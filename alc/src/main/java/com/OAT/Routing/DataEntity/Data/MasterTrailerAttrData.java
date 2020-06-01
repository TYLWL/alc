package com.OAT.Routing.DataEntity.Data;

import com.OAT.Routing.DataEntity.Attribute.TrailerAttribute;

public class MasterTrailerAttrData extends TrailerAttribute {
    private String data;

    public MasterTrailerAttrData(String regionID, double latitude, double longitude, String depotID, String trailerID, String trailerAttrID, String data) {
        super(regionID, latitude, longitude, depotID, trailerID, trailerAttrID);
        this.data = data;
    }
}
