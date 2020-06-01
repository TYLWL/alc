package com.OAT.Routing.DataEntity;

import java.util.HashSet;

public class OProductSpec extends OProduct {
    private String ProductSpecID;
    private String ProductSpecType;
    private String Description;
    private HashSet<OProductSpec> productSpecCompatibilities;
    public void setProductSpecCompatibilities(OProductSpec p) {
        productSpecCompatibilities.add(p);
    }
    public boolean isCovered(OProductSpec p){
        return productSpecCompatibilities.contains(p);
    }

    public OProductSpec(String productID, String productSpecID) {
        super(productID);
        ProductSpecID = productSpecID;
    }

    public OProductSpec(String productID, String productSpecID, String productSpecType, String description) {
        super(productID);
        ProductSpecID = productSpecID;
        ProductSpecType = productSpecType;
        Description = description;
    }

    public String getProductSpecID() {
        return ProductSpecID;
    }

    public void setProductSpecID(String productSpecID) {
        ProductSpecID = productSpecID;
    }

    @Override
    public String getDescription() {
        return Description;
    }

    @Override
    public void setDescription(String description) {
        Description = description;
    }

    public String getProductSpecType() {
        return ProductSpecType;
    }

    public void setProductSpecType(String productSpecType) {
        ProductSpecType = productSpecType;
    }
}
