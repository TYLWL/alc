package com.OAT.Routing.DataEntity;

import java.util.HashSet;

public class OProductGrade extends OProduct {
    private String ProductGradeID;
    private String Description;
    private HashSet<OProductGrade> productGradeCompatibilities;

    public void setProductGradeCompatibilities(OProductGrade p) {
        productGradeCompatibilities.add(p);
    }
    public boolean isCovered(OProductGrade p){
        return productGradeCompatibilities.contains(p);
    }


    public OProductGrade(String productID, String productGradeID) {
        super(productID);
        ProductGradeID = productGradeID;
    }

    public OProductGrade(String productID, String productGradeID, String description) {
        super(productID);
        ProductGradeID = productGradeID;
        Description = description;
    }

    public String getProductGradeID() {
        return ProductGradeID;
    }

    public void setProductGradeID(String productGradeID) {
        ProductGradeID = productGradeID;
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
