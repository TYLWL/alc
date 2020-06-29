package com.OAT.Routing.DataAccess;

import com.OAT.Routing.DataEntity.*;
import com.OAT.Routing.DataEntity.OAttributeTypes;

import java.util.ArrayList;
import java.util.List;

public class DataContainer {
    private List<DailyOrder> dailyOrders = new ArrayList<>();
    private List<OCustomer> customers = new ArrayList<>();
    private List<ODepot> depots = new ArrayList<>();
    private List<ODistrict> districts = new ArrayList<>();
    private List<ODriver> drivers = new ArrayList<>();
    private List<OEmissionStandard> emissionStandards = new ArrayList<>();
    private List<OProduct> products = new ArrayList<>();
    private List<OProductGrade> productGrades = new ArrayList<>();
    private List<OProductSpec> productSpecs = new ArrayList<>();
    private List<ORegion> regions = new ArrayList<>();
    private List<OSource> sources = new ArrayList<>();
    private List<OTrailer> trailers = new ArrayList<>();
    private List<ORoute> routes = new ArrayList<>();

    private OAttributeTypes trailerAttributeType =  new OAttributeTypes();
    private OAttributeTypes sourceAttributeType =  new OAttributeTypes();
    private OAttributeTypes customerAttributeType =  new OAttributeTypes();


    public DataContainer(){
    }

    //OProduct

    public List<OProduct> getProducts() {
        return products;
    }

    public OProduct getProduct(String productID){
        for (OProduct o: products){
            if(o.getProductID().equals(productID)){
                return o;
            }
        }
        return null;
    }
    public void addProduct(OProduct product){
        if(getProduct(product.getProductID()) ==null){
            products.add(product);
        }
    }

    //DailyOrder
    public List<DailyOrder> getDailyOrderList(){
        return dailyOrders;
    }
    public DailyOrder getDailyOrder(String dailyOrderID){
        for (DailyOrder o: dailyOrders){
            if(o.getOrderID().equals(dailyOrderID)){
                return o;
            }
        }
        return null;
    }
    public void addDailyOrder(DailyOrder dailyOrder) {
        if(getDailyOrder(dailyOrder.getOrderID()) ==null){
            dailyOrders.add(dailyOrder);
        }
    }

    //OLocation
    //保留

    //OCustomer
    public List<OCustomer> getCustomerList(){
        return customers;
    }
    public OCustomer getCustomer(String customerID){
        for(OCustomer o:customers){
            if(o.getCustomerID().equals(customerID)){
                return o;
            }
        }
        return null;
    }
    public void addCustomer(OCustomer customer){
        if(getCustomer(customer.getCustomerID()) == null){
            customers.add(customer);
        }
    }

    public void addCustomerAttributeType(String attribute,String type) {
        this.customerAttributeType.addType(attribute,type);
    }

    //depot

    public List<ODepot> getDepots() {
        return depots;
    }

    public ODepot getDepot(String depotID){
        for(ODepot o:depots){
            if(depotID.equals(o.getDepotID())){
                return o;
            }
        }
        return null;
    }
    public void addDepot(ODepot depot){
        if(getDepot(depot.getDepotID())  == null){
            depots.add(depot);
        }
    }
    //ODistrict
    public ODistrict getDistrict(String districtID){
        for(ODistrict o:districts){
            if(districtID.equals(o.getDistrictID())){
                return o;
            }
        }
        return null;
    }
    public void addDistrict(ODistrict district){
        if(getDistrict(district.getDistrictID()) ==null){
            districts.add(district);
        }
    }

    //ODriver
    public ODriver getDricer(String personnelID){
        for(ODriver o:drivers){
            if(personnelID.equals(o.getPersonnelID())){
                return o;
            }
        }
        return null;
    }
    public void addDriver(ODriver driver){
        if(getDricer(driver.getPersonnelID()) ==null ){
            drivers.add(driver);
        }
    }

    //OEmissionStandard

    public List<OEmissionStandard> getEmissionStandards() {
        return emissionStandards;
    }

    public OEmissionStandard getEmissionStandard(String emissionStandardID){
        for (OEmissionStandard o:emissionStandards){
            if(emissionStandardID.equals(o.getEmissionStandardID())){
                return o;
            }
        }
        return null;
    }
    public void addEmissionStandard(OEmissionStandard emissionStandard){
        if(getEmissionStandard(emissionStandard.getEmissionStandardID()) ==null){
            emissionStandards.add(emissionStandard);
        }
    }

    //ProductGrade
    public OProductGrade getProductGrade(String productGradeID){
        for(OProductGrade o:productGrades){
            if(o.getProductGradeID().equals(productGradeID)){
                return o;
            }
        }
        return null;
    }
    public void addProductGrade(OProductGrade productGrade){
        if(getProductGrade(productGrade.getProductGradeID() )== null){
            productGrades.add(productGrade);
        }
    }

    //OProductSpec
    public OProductSpec getProductSpec(String productSpecID){
        for(OProductSpec o:productSpecs){
            if(o.getProductSpecID().equals(productSpecID)){
                return o;
            }
        }
        return null;
    }
    public void addProductSpec(OProductSpec productSpec){
        if(getProductSpec(productSpec.getProductSpecID()) == null){
            productSpecs.add(productSpec);
        }
    }

    //ORegion
    public List<ORegion> getRegions() {
        return regions;
    }

    public ORegion getRegion(String regionID){
        for (ORegion o:regions){
            if(regionID.equals(o.getRegionID())){
                return o;
            }
        }
        return null;
    }
    public void addRegion(ORegion region){
        if(getRegion(region.getRegionID()) == null){
            regions.add(region);
        }
    }

    //ORoute
    public List<ORoute> getRoutes() {
        return routes;
    }
    public ORoute getRoute(String trailerID,String date,String visitID,Integer sequence){
        for (ORoute o:routes){
            if(o.getTrailerID().equals(trailerID) && o.getDate().equals(date) && o.getVisitID().equals(visitID)&& o.getSequence() == sequence){
                return o;
            }
        }
        return null;
    }
    public List<ORoute> getRouteLine(String trailerID) {
        List<ORoute> route = new ArrayList<>();
        for (ORoute o:routes){
            if(o.getTrailerID().equals(trailerID)){
                route.add(o);
            }
        }
        return route;
    }

    public void addRoute(ORoute route) {
        if(getRoute(route.getTrailerID(),route.getDate(),route.getVisitID(),route.getSequence()) == null){
            routes.add(route);
        }
    }
    //OSource
    public List<OSource> getSourceList(){
        return sources;
    }
    public OSource getSource(String sourceID) {
        for (OSource o:sources){
            if(o.getSourceID().equals(sourceID)){
                return o;
            }
        }
        return null;
    }

    public void addSource(OSource source) {
        if(getSource(source.getSourceID()) == null){
            sources.add(source);
        }
    }
    public void addSourceAttributeType(String attributeId, String type){
        sourceAttributeType.addType(attributeId,  type);
    }

    //OTrailer

    public List<OTrailer> getTrailerList() {
        return trailers;
    }

    public OTrailer getTrailer(String trailerID) {
        for(OTrailer o:trailers){
            if(o.getTrailerID() != null){
                return o;
            }
        }
        return null;
    }
    public void addTrailer(OTrailer trailer){
        if(getTrailer(trailer.getTrailerID()) == null){
            trailers.add(trailer);
        }
    }
    public void addTrailerAttributeType(String attributeId,String type){
        trailerAttributeType.addType(attributeId, type);
    }
}
