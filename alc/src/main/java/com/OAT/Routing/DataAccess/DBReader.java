package com.OAT.Routing.DataAccess;

import com.OAT.Routing.DataEntity.*;

import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class DBReader {

	private static DataContext _dataContext;

    public DBReader() {
    }

    public DBReader(DataContext dataContext) {
    	_dataContext =dataContext;
    }
    public void readData()throws Exception{
        //setUsers();
        setRegions();
        setRoutes();
        setDepots();
        setDistricts();
        setProducts();
        setProductGrades();
        setProductGradeCompatibility();
        setProductSpecs();
        setProductSpecCompatibility();
        setEmissionStandards();
        setEmissionCompatibility();
        setDrivers();

    }
    public void readDailyData()throws Exception{

        setCustomers();
        setCustomerAttributeType();
        setCustomerAttrData();
        setSources();
        setDailySource();
        setSourceAttributeType();
        setSourceAttrData();
        setTrailers();
        setTrailerAttributeType();
        setTrailerAttrData();
        setDailyTrailer();
        setDailyOrders();
        setRoutes();
    }

    //简单示例
    //product
    public void setProducts()throws Exception{
        //数据库查询，返回ResultSet结果
        ResultSet products = _dataContext.getSqlConnection().getObject("select * from product");
        //开始遍历所有查询结果，创建响应实例，存入container中
        while (products.next()){
            OProduct product = new OProduct(products.getString("ProductID"),products.getString("Description"));
            _dataContext.getDataContainer().addProduct(product);
        }
    }


    //dailyOrder
    public void setDailyOrders()throws Exception{
        ResultSet orders = _dataContext.getSqlConnection().getObject("select * from daily_order where Date <= '" +_dataContext.getEndDay() + "' and Date >= '" +_dataContext.getStartDay() +"'");

        while (orders.next()){
            OCustomer customer = _dataContext.getDataContainer().getCustomer(orders.getString("CustomerID"));
            DailyOrder order = new DailyOrder(orders.getString("OrderID"),orders.getString("ProductID"),orders.getString("Date"),orders.getDouble("EstimatedDropSize"),orders.getString("DeliveryType"),orders.getBoolean("IsFirstDelivery"),orders.getString("SpecialTimeStart"),orders.getString("SpecialTimeEnd"),orders.getBoolean("IsSoftTime"),orders.getBoolean("IsFTFD"),orders.getBoolean("IsSoftFTFD"),orders.getString("Description"),customer);
            _dataContext.getDataContainer().addDailyOrder(order);
        }
        orders.close();
    }

    //customer
    public void setCustomers() throws Exception{
        ResultSet customers = _dataContext.getSqlConnection().getObject("select * from master_customer");
        while (customers.next()){
            OCustomer customer = new OCustomer(customers.getString("RegionID"), customers.getDouble("Latitude"),customers.getDouble("Longitude"),customers.getString("CustomerID"),customers.getString("Description"));
            _dataContext.getDataContainer().addCustomer(customer);
        }
        customers.close();
    }

    public void setCustomerAttributeType()throws Exception{
        ResultSet customerAttrs = _dataContext.getSqlConnection().getObject("select * from customerattribute");
        while (customerAttrs.next()){
            _dataContext.getDataContainer().addCustomerAttributeType(customerAttrs.getString("CustomerAttrID"),customerAttrs.getString("Type"));
        }
        customerAttrs.close();
    }
    public void setCustomerAttrData()throws Exception{
        List<OCustomer> customerList = _dataContext.getDataContainer().getCustomerList();
        for(OCustomer customer:customerList){
            ResultSet customerAttrData = _dataContext.getSqlConnection().getObject("select * from customerattrdata where CustomerID = '"+ customer.getCustomerID() +"'");
            while (customerAttrData.next()){
                customer.addCustomerAttrData(customerAttrData.getString("CustomerAttrID"),customerAttrData.getString("data"));
            }
            customerAttrData.close();
        }
    }


    //depot
    public void setDepots()throws Exception {
        ResultSet depots = _dataContext.getSqlConnection().getObject("select * from master_depot");
        while (depots.next()){
            ODepot depot = new ODepot(depots.getString("RegionID"), depots.getDouble("Latitude"),depots.getDouble("Longitude"),depots.getString("DepotID"),depots.getInt("MaxTrailers"),depots.getString("Description"));
            _dataContext.getDataContainer().addDepot(depot);
        }
        depots.close();
    }


    //ODistrict
    public void setDistricts()throws Exception {
        ResultSet districts = _dataContext.getSqlConnection().getObject("select * from master_district");
            while (districts.next()){
            ODistrict district = new ODistrict(districts.getString("RegionID"), districts.getString("DistrictID"),districts.getString("Prefecture"),districts.getString("County"),districts.getString("ERStart"),districts.getString("EREnd"),districts.getString("NMStart"),districts.getString("NMEnd"),districts.getBoolean("HasHolidayRestriction"),districts.getString("PermittedTrailersID").split(","),districts.getString("Description"));
            _dataContext.getDataContainer().addDistrict(district);
        }
        districts.close();
    }

    //ODriver
    public void setDrivers()throws Exception {
        ResultSet drivers = _dataContext.getSqlConnection().getObject("select * from master_driver");
        while (drivers.next()){
            ODepot depot = _dataContext.getDataContainer().getDepot(drivers.getString("DepotID"));

            ODriver driver = new ODriver(depot.getRegionID(),0,0,drivers.getString("DepotID"), drivers.getString("PersonnelID"),drivers.getString("Name"),drivers.getString("DedicatedTrailerID"),drivers.getString("DedicatedProductID"),drivers.getBoolean("IsMedicalLoxCertified"),drivers.getBoolean("IsOnlyRigid"),drivers.getString("Description"));
            _dataContext.getDataContainer().addDriver(driver);
        }
        drivers.close();
    }

    //OEmissionStandard
    public void setEmissionStandards()throws Exception {
        ResultSet emissionStandards = _dataContext.getSqlConnection().getObject("select * from master_emissionstandard");
        while (emissionStandards.next()){
            OEmissionStandard emissionStandard = new OEmissionStandard(emissionStandards.getString("EmissionStandardID"), emissionStandards.getString("Description")) {};
            _dataContext.getDataContainer().addEmissionStandard(emissionStandard);
        }
        emissionStandards.close();
    }
    public void setEmissionCompatibility()throws Exception{
        ResultSet emissionCompatible = _dataContext.getSqlConnection().getObject("select * from emissioncompatibility");
        while (emissionCompatible.next()){
            _dataContext.getDataContainer().getEmissionStandard(emissionCompatible.getString("EmissionStandardID1")).setEmissionStandard(_dataContext.getDataContainer().getEmissionStandard(emissionCompatible.getString("EmissionStandardID2")));
        }
        emissionCompatible.close();
    }
    //ProductGrade
    public void setProductGrades() throws Exception{
        ResultSet productGrades = _dataContext.getSqlConnection().getObject("select * from productgrade");
        while (productGrades.next()){
            OProductGrade productGrade = new OProductGrade(productGrades.getString("ProductID"), productGrades.getString("ProductGradeID"),productGrades.getString("Description"));
            _dataContext.getDataContainer().addProductGrade(productGrade);
        }
        productGrades.close();
    }
    public void setProductGradeCompatibility()throws Exception{
        ResultSet gradeCompatible = _dataContext.getSqlConnection().getObject("select * from productgradecompatibility");
        while (gradeCompatible.next()){
            _dataContext.getDataContainer().getProductGrade(gradeCompatible.getString("ProductGradeID1")).setProductGradeCompatibilities(_dataContext.getDataContainer().getProductGrade(gradeCompatible.getString("ProductGradeID2")));
        }
        gradeCompatible.close();
    }
    //OProductSpec
    public void setProductSpecs()throws Exception {
        ResultSet productSpecs = _dataContext.getSqlConnection().getObject("select * from productspec");
        while (productSpecs.next()){
            OProductSpec productSpec = new OProductSpec(productSpecs.getString("ProductID"), productSpecs.getString("ProductSpecID"),productSpecs.getString("ProductSpecType"),productSpecs.getString("Description"));
            _dataContext.getDataContainer().addProductSpec(productSpec);
        }
        productSpecs.close();
    }
    public void setProductSpecCompatibility()throws Exception{
        ResultSet specCompatible = _dataContext.getSqlConnection().getObject("select * from productspeccompatibility");
        while (specCompatible.next()){
            _dataContext.getDataContainer().getProductSpec(specCompatible.getString("ProductSpecID1")).setProductSpecCompatibilities(_dataContext.getDataContainer().getProductSpec(specCompatible.getString("ProductSpecID2")));
        }
        specCompatible.close();
    }
    //ORegion
    public void setRegions() throws Exception{
        ResultSet regions = _dataContext.getSqlConnection().getObject("select * from region");
        while (regions.next()){
            ORegion region = new ORegion(regions.getString("RegionID"), regions.getString("Description")) {};

            _dataContext.getDataContainer().addRegion(region);
        }
        regions.close();
    }

    //ORoute
    public void setRoutes() throws Exception{
        ResultSet routes = _dataContext.getSqlConnection().getObject("select * from route");
        while (routes.next()){
            ORoute route = new ORoute(routes.getString("Date"), routes.getString("ProductID"),routes.getString("RegionID"),routes.getString("TrailerID"),routes.getInt("sequence"),routes.getString("VisitID"),routes.getDouble("quantity"));
            _dataContext.getDataContainer().addRoute(route);
        }
        routes.close();
    }


    //OSource
    public void setSources() throws Exception{

        ResultSet sources = _dataContext.getSqlConnection().getObject("select * from master_source");
        while (sources.next()){
            OSource source = new OSource(sources.getString("RegionID"),sources.getDouble("Latitude"),sources.getDouble("Longitude"),sources.getString("SourceID"),sources.getString("Description")) {};

            _dataContext.getDataContainer().addSource(source);
        }
        sources.close();
    }
    public void setSourceAttributeType()throws Exception{
        ResultSet sourceAttrs = _dataContext.getSqlConnection().getObject("select * from sourceattribute");
        while (sourceAttrs.next()){
            _dataContext.getDataContainer().addTrailerAttributeType(sourceAttrs.getString("SourceAttrID"),sourceAttrs.getString("Type"));
        }
        sourceAttrs.close();
    }
    public void setSourceAttrData()throws Exception{
        List<OSource> sourceList = _dataContext.getDataContainer().getSourceList();
        for(OSource source:sourceList){
            ResultSet sourceAttrData = _dataContext.getSqlConnection().getObject("select * from sourceattrdata where SourceID = '"+ source.getSourceID() +"'");
            while (sourceAttrData.next()){
                source.addSourceAttrData(sourceAttrData.getString("ProductID"),sourceAttrData.getString("SourceAttrID"),sourceAttrData.getString("data"));
            }
            sourceAttrData.close();
        }
    }

    //dailySource
    public void setDailySource()throws Exception{
        ResultSet dailySources = _dataContext.getSqlConnection().getObject("select * from daily_source where Date <= '" + _dataContext.getEndDay() + "' and Date >= '" + _dataContext.getStartDay() +"'");
        while (dailySources.next()){
            Date date = dailySources.getDate("Date");
            HashMap<String,String> data = new HashMap<>();
            data.put(dailySources.getString("Date"),dailySources.getString("ProductID"));
            _dataContext.getDataContainer().getSource(dailySources.getString("SourceID")).setSourceAvailableQuantity(data,dailySources.getInt("AvailableQuantity"));

        }
        dailySources.close();
    }

    //OTrailer
    public void setTrailers()throws Exception{
        ResultSet trailers = _dataContext.getSqlConnection().getObject("select * from master_trailer");
        while (trailers.next()){
            OTrailer trailer = new OTrailer(trailers.getString("TrailerID"),trailers.getString("ProductID"),trailers.getString("Description"));
            trailer.setHomeDepot(_dataContext.getDataContainer().getDepot(trailers.getString("DepotID")));
            _dataContext.getDataContainer().addTrailer(trailer);
        }
        trailers.close();
    }
    public void setTrailerAttributeType()throws Exception{
        ResultSet trailerAttrs = _dataContext.getSqlConnection().getObject("select * from trailerattribute");
        while (trailerAttrs.next()){
            _dataContext.getDataContainer().addTrailerAttributeType(trailerAttrs.getString("TrailerAttrID"),trailerAttrs.getString("Type"));
        }
        trailerAttrs.close();
    }
    public void setTrailerAttrData() throws Exception{
        List<OTrailer> trailerList = _dataContext.getDataContainer().getTrailerList();
        for(OTrailer trailer:trailerList){
            ResultSet trailerAttrData = _dataContext.getSqlConnection().getObject("select * from trailerattrdata where TrailerID = '"+ trailer.getTrailerID() +"'");
            while (trailerAttrData.next()){
                trailer.addTrailerAttrData(trailerAttrData.getString("TrailerAttrID"),trailerAttrData.getString("data"));
            }
            trailerAttrData.close();
        }
    }

    //dailyTrailer
    public void setDailyTrailer()throws Exception{
        ResultSet dailyTrailers = _dataContext.getSqlConnection().getObject("select * from daily_trailer where Date <= '" + _dataContext.getEndDay() + "' and Date >= '" + _dataContext.getStartDay() +"'");
        while (dailyTrailers.next()){
            Date date = dailyTrailers.getDate("Date");
            _dataContext.getDataContainer().getTrailer(dailyTrailers.getString("TrailerID")).setTrailerAvailOnDay(date,dailyTrailers.getBoolean("IsAvailable"));

            Hashtable<String,String> data = new Hashtable<>();
            data.put("OvernightProductASU",dailyTrailers.getString("OvernightProductASU"));

            if(dailyTrailers.getString("SpecialStartTime") == null){
                data.put("SpecialStartTime","");
            }else {
                data.put("SpecialStartTime",dailyTrailers.getString("SpecialStartTime"));
            }

            _dataContext.getDataContainer().getTrailer(dailyTrailers.getString("TrailerID")).setDailyAttributeData(date,data);


        }
        dailyTrailers.close();
    }
}
