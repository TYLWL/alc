package com.OAT.Routing.DataEntity;

import java.util.Hashtable;

public class OCustomer extends OLocation {
    private String CustomerID;
    private Hashtable<String,String> customerAttrData = new Hashtable<>();
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


    public String getCustomerAttrData(String attribute) {
        return customerAttrData.get(attribute);
    }

    public void addCustomerAttrData(String attribute, String data) {
        this.customerAttrData.put(attribute, data);
    }

    @Override
    public String toString() {
        return "OCustomer{" +
                "CustomerID='" + CustomerID + '\'' +
                ", customerAttrValue=" + customerAttrData +
                ", Description='" + Description + '\'' +
                '}';
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
