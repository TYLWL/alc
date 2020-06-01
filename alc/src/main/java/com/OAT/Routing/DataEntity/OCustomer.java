package com.OAT.Routing.DataEntity;

import java.util.HashSet;
import java.util.Hashtable;

public class OCustomer extends OLocation {
    private String CustomerID;
    private HashSet<String> customerAttrIDs;
    private Hashtable<String,String> customerAttrValue;
    private String Description;

    public OCustomer(String regionID, double latitude, double longitude, String customerID) {
        super(regionID, latitude, longitude);
        CustomerID = customerID;
    }

    public OCustomer(String regionID, double latitude, double longitude, String customerID, String description) {
        super(regionID, latitude, longitude);
        CustomerID = customerID;
        Description = description;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
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
