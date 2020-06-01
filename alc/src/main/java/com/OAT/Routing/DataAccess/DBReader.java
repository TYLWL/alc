package com.OAT.Routing.DataAccess;

import com.OAT.Routing.DataEntity.*;
import com.OAT.Routing.sql.SqlConnection;

import java.sql.ResultSet;

public class DBReader {
    private static SqlConnection sqlConnection;
    private static DataContainer dataContainer;

    //product
    public void setProducts()throws Exception{
        ResultSet products = sqlConnection.getObject("select * from product");
        while (products.next()){
            OProduct product = new OProduct(products.getString("ProductID"),products.getString("Description"));
            dataContainer.addProduct(product);
        }
    }
    //dailySource
    //dailyOrder

    //customer
    public void setCustomers() throws Exception{
        ResultSet customers = sqlConnection.getObject("select * from master_customer");
        while (customers.next()){
            OCustomer customer = new OCustomer(customers.getString("RegionID"), customers.getDouble("Latitude"),customers.getDouble("Longitude"),customers.getString("CustomerID"),customers.getString("Description"));
            dataContainer.addCustomer(customer);
        }
    }

    //depot
    public void setoDepots()throws Exception {
        ResultSet depots = sqlConnection.getObject("select * from master_depot");
        while (depots.next()){
            ODepot depot = new ODepot(depots.getString("RegionID"), depots.getDouble("Latitude"),depots.getDouble("Longitude"),depots.getString("DepotID"),depots.getInt("MaxTrailers"),depots.getString("Description"));
            dataContainer.addDepot(depot);
        }
    }


    //ODistrict
    public void setDistricts()throws Exception {
        ResultSet districts = sqlConnection.getObject("select * from master_district");
            while (districts.next()){
            ODistrict district = new ODistrict(districts.getString("RegionID"), districts.getString("DistrictID"),districts.getString("Prefecture"),districts.getString("County"),districts.getString("ERStart"),districts.getString("EREnd"),districts.getString("NMStart"),districts.getString("NMEnd"),districts.getBoolean("HasHolidayRestriction"),districts.getString("PermittedTrailersID").split(","),districts.getString("Description"));
            dataContainer.addDistrict(district);
        }
    }

    //ODriver
    public void setDrivers()throws Exception {
        ResultSet drivers = sqlConnection.getObject("select * from master_driver");
        while (drivers.next()){
            ResultSet depot = sqlConnection.getObject("select RegionID from master_depot where DepotID = " + drivers.getString("DepotID"));
            depot.next();
            ODriver driver = new ODriver(depot.getString("RegionID"),0,0,drivers.getString("DepotID"), drivers.getString("PersonnelID"),drivers.getString("Name"),drivers.getString("DedicatedTrailerID"),drivers.getString("DedicatedProductID"),drivers.getBoolean("IsMeddicalLoxCertified"),drivers.getBoolean("IsOnlyRigid"),drivers.getString("Description"));
            dataContainer.addDriver(driver);
        }
    }


//    //OEmissionStandard
//    public void setemissionStandards()throws Exception {
//        ResultSet rs = sqlConnection.getObject("*","master_emissionstandard","");
//        while (rs.next()){
//            OEmissionStandard emissionStandard = new OEmissionStandard(rs.getString("EmissionStandardID"), rs.getString("Description")) {};
//            ResultSet compatible = sqlConnection.getObject("*","emissioncompatibility","EmissionStandardID1 = "+rs.getString(1));
//            while (compatible.next()){
//                if (compatible.getBoolean("IsCovered")){
//                    ResultSet compatibleEmission = sqlConnection.getObject("*","master_emissionstandard","EmissionStandardID = "+compatible.getString(2));
//                    compatibleEmission.next();
//                    OEmissionStandard oe = new OEmissionStandard(compatibleEmission.getString("EmissionStandard"),compatibleEmission.getString("Description"));
//                    emissionStandard.setEmissionStandard(oe);
//                }
//            }
//            emissionStandards.add(emissionStandard);
//        }
//    }
//    //ProductGrade
//    public void setproductGrades() throws Exception{
//        ResultSet rs = sqlConnection.getObject("*","productgrade","");
//        while (rs.next()){
//            OProductGrade productGrade = new OProductGrade(rs.getString(2), rs.getString(1),rs.getString(3)) {};
//            ResultSet compatible = sqlConnection.getObject("*","productgradecompatibility","ProductGradeID = "+productGrade.getProductGradeID());
//            while(compatible.next()){
//                if(compatible.getBoolean("IsCovered")){
//                    ResultSet compatibleGrade = sqlConnection.getObject("*","productgrade","ProductGradeID = "+compatible.getString("ProductGradeID2"));
//                    compatibleGrade.next();
//                    OProductGrade grade = new OProductGrade(compatibleGrade.getString("ProductID"), compatibleGrade.getString("ProductGradeID"),compatibleGrade.getString("Description"));
//                    productGrade.setProductGradeCompatibilities(grade);
//                }
//            }
//            productGrades.add(productGrade);
//        }
//    }
//    //OProductSpec
//    public void setproductSpecs()throws Exception {
//        ResultSet rs = sqlConnection.getObject("*","productspec","");
//        while (rs.next()){
//            OProductSpec productSpec = new OProductSpec(rs.getString("ProductID"), rs.getString("ProductSpecID"),rs.getString("ProductSpecType"),rs.getString("Description")) {};
//            ResultSet compatible = sqlConnection.getObject("*","productspeccompatibility","ProductSpecID = "+productSpec.getProductSpecID());
//            while(compatible.next()){
//                if(compatible.getBoolean("IsCovered")){
//                    ResultSet compatibleSpec = sqlConnection.getObject("*","productspec","ProductSpecID = "+compatible.getString("ProductSpecID2"));
//                    compatibleSpec.next();
//                    OProductSpec spec = new OProductSpec(compatibleSpec.getString("ProductID"), compatibleSpec.getString("ProductSpecID"),compatibleSpec.getString("ProductSpecType"),compatibleSpec.getString("Description"));
//                    productSpec.setProductSpecCompatibilities(spec);
//                }
//            }
//            productSpecs.add(productSpec);
//        }
//    }

    //ORegion
    public void setRegions() throws Exception{
        ResultSet regions = sqlConnection.getObject("select * from region");
        while (regions.next()){
            ORegion region = new ORegion(regions.getString("RegionID"), regions.getString("Description")) {};
            dataContainer.addRegion(region);
        }
    }

    //OSource
    public void setSources() throws Exception{
        ResultSet sources = sqlConnection.getObject("select * from master_source");
        System.out.println(sources);
        ResultSet sourceAttr = sqlConnection.getObject("select * from sourceattribute");
        while (sources.next()){
            OSource source = new OSource(sources.getString("RegionID"),sources.getDouble("Latitude"),sources.getDouble("Longitude"), sources.getString("Description")) {};
            sources.close();
            while (sourceAttr.next()){
                source.addSourceAttribute(sourceAttr.getString("SourceAttrID"));
            }
            dataContainer.addSource(source);
        }
    }




    public DataContainer readData()throws Exception{
        setProducts();
        return dataContainer;
    }
    public DBReader()throws Exception{
        sqlConnection = new SqlConnection();
    }
}
