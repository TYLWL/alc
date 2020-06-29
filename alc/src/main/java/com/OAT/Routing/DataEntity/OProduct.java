package com.OAT.Routing.DataEntity;

import com.OAT.Routing.DataAccess.DataContainer;
import com.sun.org.apache.regexp.internal.RE;

import java.util.HashSet;
import java.util.Hashtable;

public class OProduct {
    private String ProductID;
    private String Description;
    private HashSet<String> productAttrIDs;
    private Hashtable<String,String> productAttrValue;

    public OProduct(){
    }

    public Hashtable toMap(){
        Hashtable h = new Hashtable();
        h.put("ProductID",ProductID);
        if(this.Description != null) {
            h.put("Description", Description);
        }
        return h;
    }

    public OProduct(String productID) {
        ProductID = productID;
    }

    public OProduct(String productID, String description) {
        ProductID = productID;
        Description = description;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
