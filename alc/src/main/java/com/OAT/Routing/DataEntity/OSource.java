package com.OAT.Routing.DataEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;

public class OSource extends OLocation {
    private String SourceID;
    private String Description;

    private Hashtable<String,String> sourceAttrData = new Hashtable<>();
    private Hashtable<HashMap<Date,String>,Integer > SourceAvailQuantity = new Hashtable<>();

    public OSource(String regionID, double latitude, double longitude, String sourceID) {
        super(regionID, latitude, longitude);
        SourceID = sourceID;
    }

    public OSource(String regionID, double latitude, double longitude, String sourceID, String description) {
        super(regionID, latitude, longitude);
        SourceID = sourceID;
        Description = description;
    }


    @Override
    public String toString() {
        return "OSource{" +
                "SourceID='" + SourceID + '\'' +
                ", Description='" + Description + '\'' +
                ", sourceAttrData=" + sourceAttrData +
                ", SourceAvailQuantity=" + SourceAvailQuantity +
                '}';
    }

    public void setSourceAvailableQuantity(HashMap<Date,String> map,Integer data)
    {
        SourceAvailQuantity.put(map, data);
    }

    public Hashtable<HashMap<Date,String>,Integer > getSourceAvailableQuantity() {
        if(SourceAvailQuantity == null){
            return null;
        }
        return SourceAvailQuantity;
    }
    public Integer getQuantity(Date date,String productID){
        HashMap<Date,String> t = new HashMap<>();
        t.put(date, productID);
        return SourceAvailQuantity.get(t);
    }

    public void addSourceAttrData(String productId, String attributeId, String data){
        this.sourceAttrData.put(productId+"/"+attributeId, data);
    }

    public String getSourceAttrData(String productId,String attributeId) {
        return sourceAttrData.get(productId+"/"+attributeId);
    }

    public String getSourceID() {
        return SourceID;
    }

    public void setSourceID(String sourceID) {
        SourceID = sourceID;
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
