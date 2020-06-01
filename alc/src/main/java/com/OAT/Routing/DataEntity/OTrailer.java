package com.OAT.Routing.DataEntity;

public class OTrailer extends ODepot {
    private String TrailerID;
    private String ProductID;
    private String Description;

    public OTrailer(String regionID, double latitude, double longitude, String depotID, String trailerID) {
        super(regionID, latitude, longitude, depotID);
        TrailerID = trailerID;
    }

    public OTrailer(String regionID, double latitude, double longitude, String depotID, String trailerID, String productID, String description) {
        super(regionID, latitude, longitude, depotID);
        TrailerID = trailerID;
        ProductID = productID;
        Description = description;
    }

    public String getTrailerID() {
        return TrailerID;
    }

    public void setTrailerID(String trailerID) {
        TrailerID = trailerID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
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
