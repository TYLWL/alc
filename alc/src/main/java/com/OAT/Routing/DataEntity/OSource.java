package com.OAT.Routing.DataEntity;

import java.util.HashSet;
import java.util.Hashtable;

public class OSource extends OLocation {
    private String SourceID;
    private String Description;

    private HashSet<String> sourceAttrIDs;
    private Hashtable<String,String> sourceAttrValue;
    public OSource(String regionID, double latitude, double longitude, String sourceID) {
        super(regionID, latitude, longitude);
        SourceID = sourceID;
    }

    public OSource(String regionID, double latitude, double longitude, String sourceID, String description) {
        super(regionID, latitude, longitude);
        SourceID = sourceID;
        Description = description;
    }

    public void addSourceAttribute(String attribute){
        sourceAttrIDs.add(attribute);
    }


    @Override
    public String toString() {
        return "OSource{" +
                "SourceID='" + SourceID + '\'' +
                ", Description='" + Description + '\'' +
                ", sourceAttrIDs=" + sourceAttrIDs +
                ", sourceAttrValue=" + sourceAttrValue +
                '}';
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
