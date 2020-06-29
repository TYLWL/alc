package com.OAT.Routing.DataEntity;

public class ORoute {
    private String Date;
    private String ProductID;
    private String RegionID;
    private String TrailerID;
    private Integer sequence;
    private String VisitID;
    private Double quantity;


    public ORoute(String date, String productID, String regionID, String trailerID, Integer sequence, String visitID, Double quantity) {
        Date = date;
        ProductID = productID;
        RegionID = regionID;
        TrailerID = trailerID;
        this.sequence = sequence;
        VisitID = visitID;
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return
                "Date='" + Date +
                "', ProductID='" + ProductID +
                "', RegionID='" + RegionID +
                "', TrailerID='" + TrailerID +
                "', sequence=" + sequence +
                "', VisitID='" + VisitID +
                "', quantity=" + quantity;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getRegionID() {
        return RegionID;
    }

    public void setRegionID(String regionID) {
        RegionID = regionID;
    }

    public String getTrailerID() {
        return TrailerID;
    }

    public void setTrailerID(String trailerID) {
        TrailerID = trailerID;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getVisitID() {
        return VisitID;
    }

    public void setVisitID(String visitID) {
        VisitID = visitID;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
