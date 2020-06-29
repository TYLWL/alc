package com.OAT.Routing.DataEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;

public class OSource extends OLocation {
    private String SourceID;
    private String Description;

    private Hashtable<String,String> sourceAttrData = new Hashtable<>();
    private Hashtable<HashMap<String,String>,Integer > SourceAvailQuantity = new Hashtable<>();

    public OSource(String regionID, double latitude, double longitude, String sourceID) {
        super(regionID, latitude, longitude);
        SourceID = sourceID;
    }

    public OSource(String regionID, double latitude, double longitude, String sourceID, String description) {
        super(regionID, latitude, longitude);
        SourceID = sourceID;
        Description = description;
    }
    public Hashtable toMap(String date,String product) {
        Hashtable hashMap = new Hashtable();
        System.out.println(date+product);
        System.out.println(getQuantity(date, product));
        hashMap.put("SourceID",SourceID);
        hashMap.put("Date",date);
        hashMap.put("ProductID",product);
        if( getQuantity(date, product) != null){
            hashMap.put("AvailableQuantity",getQuantity(date, product));
        }
        hashMap.put("Latitude",this.getLatitude());
        hashMap.put("Longitude",this.getLongitude());
        hashMap.put("RegionID",this.getRegionID());
        if(Description !=null) {
            hashMap.put("Description", Description);
        }
        return hashMap;
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

    public void setSourceAvailableQuantity(HashMap<String,String> map,Integer data)
    {
        SourceAvailQuantity.put(map, data);
    }

    public Hashtable<HashMap<String,String>,Integer > getSourceAvailableQuantity() {
        if(SourceAvailQuantity == null){
            return null;
        }
        return SourceAvailQuantity;
    }
    public Integer getQuantity(String date,String productID){
        HashMap<String,String> t = new HashMap<>();
        t.put(date, productID);
        Integer quantity = SourceAvailQuantity.get(t);
        String s;
        try {
            s = quantity.toString();

        } catch (Exception e){
            System.out.println("坏了");
            return null;
        }
        if (s.equals("")) {
            System.out.println("11开始");
            return SourceAvailQuantity.get(t);
        }
        return null;
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
