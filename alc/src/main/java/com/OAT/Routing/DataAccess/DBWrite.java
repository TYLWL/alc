package com.OAT.Routing.DataAccess;

import com.OAT.Routing.DataEntity.*;
import com.OAT.Routing.sql.SqlConnection;

import java.sql.PreparedStatement;
import java.util.List;

public class DBWrite {
    private static SqlConnection sqlConnection;
    private static PreparedStatement ps;

    public DBWrite()throws Exception
    {
        sqlConnection = new SqlConnection();
    }

    public int saveObject(String type,Object object){
        switch (type){
            case "product":return saveProduct((OProduct)object);
            case "productGrade":return saveProductGrade((OProductGrade)object);
            case "region":return saveRegion((ORegion)object);
            case "productSpec":return saveProductSpec((OProductSpec)object);
            case "emissionStandard":return saveOEmissionStandard((OEmissionStandard)object);
            default:return 0;
        }
    }
    private int saveProduct(OProduct product){
        String sql = "insert into product(ProductID,Description) values('"+
                product.getProductID()+"','"+product.getDescription()+"')";
        return sqlConnection.insertObject(sql);
    }
    private int saveProductGrade(OProductGrade productGrade){
        String sql = "insert into productgrade(ProductGradeID,ProductID,Description) values('"+
                productGrade.getProductGradeID()+"','"+productGrade.getProductID()+"','"+productGrade.getDescription()+"')";
        return sqlConnection.insertObject(sql);
    }
    private int saveProductSpec(OProductSpec productSpec){
        String sql = "insert into productspec(ProductSpecID,ProductID,ProductSpecType,Description) values('"+
                productSpec.getProductSpecID()+"','"+productSpec.getProductID()+"','"+productSpec.getProductSpecType()+"','"+productSpec.getDescription()+"')";
        return sqlConnection.insertObject(sql);
    }
    private int saveRegion(ORegion region){
        String sql = "insert into region(RegionID,Description) values('"+
                region.getRegionID()+"','"+region.getDescription()+"')";
        return sqlConnection.insertObject(sql);
    }

    private int saveOEmissionStandard(OEmissionStandard emissionStandard){
        String sql = "insert into master_emissionstandard(EmissionStandardID,Description) values('"+
                emissionStandard.getEmissionStandardID()+"','"+emissionStandard.getDescription()+"')";
        return sqlConnection.insertObject(sql);
    }
    public void saveRoute(List<ORoute> routeList)throws Exception{
//        String sql = "insert into route(Date,ProductID,RegionID,TrailerID,sequence,VisitID,quantity) values('"+
//                route.getDate()+"','"+route.getProductID()+"','"+route.getRegionID()+"','"+
//                route.getTrailerID()+"','"+route.getSequence()+"',"+route.getVisitID()+","+
//                route.getQuantity()+")";
        ps = sqlConnection.getConn().prepareStatement("insert into route(Date,ProductID,RegionID,TrailerID,sequence,VisitID,quantity) values(?,?,?,?,?,?,?)");
        for(ORoute route:routeList){
            ps.setString(1,route.getDate());
            ps.setString(2,route.getProductID());
            ps.setString(3,route.getRegionID());
            ps.setString(4,route.getTrailerID());
            ps.setInt(5,route.getSequence());
            ps.setString(6,route.getVisitID());
            ps.setDouble(7,route.getQuantity());
            ps.addBatch();
        }
        ps.executeBatch();
        sqlConnection.insertObject();
    }
}
