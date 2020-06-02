package com.OAT.Routing.DataAccess;

import com.OAT.Routing.DataEntity.*;
import com.OAT.Routing.DataEntity.Attribute.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataContainer {
    private List<DailyOrder> dailyOrders = new ArrayList<DailyOrder>();
    private List<DailySource> dailySources = new ArrayList<DailySource>();
    private List<OCustomer> customers = new ArrayList<OCustomer>();
    private List<ODepot> depots = new ArrayList<ODepot>();
    private List<ODistrict> districts = new ArrayList<ODistrict>();
    private List<ODriver> drivers = new ArrayList<ODriver>();
    private List<OEmissionStandard> emissionStandards = new ArrayList<OEmissionStandard>();
    private List<OProduct> products = new ArrayList<OProduct>();
    private List<OProductGrade> productGrades = new ArrayList<OProductGrade>();
    private List<OProductSpec> productSpecs = new ArrayList<OProductSpec>();
    private List<ORegion> regions = new ArrayList<ORegion>();
    private List<OSource> sources = new ArrayList<OSource>();
    private List<OTrailer> trailers = new ArrayList<OTrailer>();

    
    private OAttribueTypes trailerAttributeType =  new OAttribueTypes();
    private OAttribueTypes sourceAttributeType =  new OAttribueTypes();
    private OAttribueTypes customerAttributeType =  new OAttribueTypes();
    
    
    
    private Date startDay;
    private Date endDay;

    public DataContainer(){
    }

    public void setDate(Date startDay,Date endDay){
        this.startDay = startDay;
        this.endDay = endDay;
    }

    //OProduct
    public OProduct getProduct(String productID){
        for (OProduct o: products){
            if(o.getProductID().equals(productID)){
                return o;
            }
        }
        return null;
    }
    public void addProduct(OProduct product){
        if(getProduct(product.getProductID()) !=null){
            products.add(product);
        }
    }

    //DailyOrder
    public DailyOrder getDailyOrder(String dailyOrderID){
        for (DailyOrder o: dailyOrders){
            if(o.getOrderID().equals(dailyOrderID)){
                return o;
            }
        }
        return null;
    }
    public void addDailyOrder(DailyOrder dailyOrder) {
        if(getDailyOrder(dailyOrder.getOrderID()) !=null){
            dailyOrders.add(dailyOrder);
        }
    }

    //DailySource
    public DailySource getDailySource(String dailySourceID) {
        for (DailySource o: dailySources){
            if(o.getSourceID().equals(dailySourceID)){
                return o;
            }
        }
        return null;
    }
    
    public void addDailySource(DailySource dailySource) {
        if(getDailySource(dailySource.getSourceID()) != null){
            dailySources.add(dailySource);
        }
    }
    
    //OLocation
    //ä¿�ç•™
    
    //OCustomer
    public OCustomer getCustomer(String customerID){
        for(OCustomer o:customers){
            if(o.getCustomerID().equals(customerID)){
                return o;
            }
        }
        return null;
    }
    public void addCustomer(OCustomer customer){
        if(getCustomer(customer.getCustomerID()) != null){
            customers.add(customer);
        }
    }
    
    //depot
    public ODepot getDepot(String depotID){
        for(ODepot o:depots){
            if(depotID.equals(o.getDepotID())){
                return o;
            }
        }
        return null;
    }
    public void addDepot(ODepot depot){
        if(getDepot(depot.getDepotID())  != null){
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
        if(getDistrict(district.getDistrictID()) !=null){
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
        if(getDricer(driver.getPersonnelID()) !=null ){
            drivers.add(driver);
        }
    }

    //OEmissionStandard
    public OEmissionStandard getEmissionStandard(String emissionStandardID){
        for (OEmissionStandard o:emissionStandards){
            if(emissionStandardID.equals(o.getEmissionStandardID())){
                return o;
            }
        }
        return null;
    }
    public void addEmissionStandard(OEmissionStandard emissionStandard){
        if(getEmissionStandard(emissionStandard.getEmissionStandardID()) !=null){
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
        if(getProductGrade(productGrade.getProductGradeID() )!= null){
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
        if(getProductSpec(productSpec.getProductSpecID()) != null){
            productSpecs.add(productSpec);
        }
    }

    //ORegion
    public ORegion getRegion(String regionID){
        for (ORegion o:regions){
            if(regionID.equals(o.getRegionID())){
                return o;
            }
        }
        return null;
    }
    public void addRegion(ORegion region){
        if(getRegion(region.getRegionID()) != null){
            regions.add(region);
        }
    }

    //OSource
    public OSource getSource(String sourceID) {
        for(OSource o:sources){
            if(o.getSourceID().equals(sourceID)){
                return o;
            }
        }
        return null;
    }

    public void addSource(OSource source) {
        if(getSource(source.getSourceID()) != null){
            sources.add(source);
        }
    }

    //OTrailer
    public OTrailer getTrailer(String trailerID) {
        for(OTrailer o:trailers){
            if(o.getTrailerID() != null){
                return o;
            }
        }
        return null;
    }
    public void addTrailer(OTrailer trailer){
        if(getTrailer(trailer.getTrailerID()) != null){
            trailers.add(trailer);
        }
    }
}
