package com.OAT.Routing.DataEntity;

import java.sql.Date;

public class DailyOrder{
    private String OrderID;
    private String ProductID;
    private Date Date;
    private double EstimatedDropSize;
    private String DeliveryType;
    private boolean IsFirstDelivery;
    private String SpecialTimeStart;
    private String SpecialTimeEnd;
    private Boolean IsSoftTime;
    private Boolean IsFTFD;
    private Boolean IsSoftFTFD;
    private String Description;
    private OCustomer customer;

    public DailyOrder(String orderID, String productID, java.sql.Date date, double estimatedDropSize, String deliveryType, boolean isFirstDelivery, String specialTimeStart, String specialTimeEnd, Boolean isSoftTime, Boolean isFTFD, Boolean isSoftFTFD, String description, OCustomer customer) {
        OrderID = orderID;
        ProductID = productID;
        Date = date;
        EstimatedDropSize = estimatedDropSize;
        DeliveryType = deliveryType;
        IsFirstDelivery = isFirstDelivery;
        SpecialTimeStart = specialTimeStart;
        SpecialTimeEnd = specialTimeEnd;
        IsSoftTime = isSoftTime;
        IsFTFD = isFTFD;
        IsSoftFTFD = isSoftFTFD;
        Description = description;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "DailyOrder{" +
                "OrderID='" + OrderID + '\'' +
                ", ProductID='" + ProductID + '\'' +
                ", Date=" + Date +
                ", EstimatedDropSize=" + EstimatedDropSize +
                ", DeliveryType='" + DeliveryType + '\'' +
                ", IsFirstDelivery=" + IsFirstDelivery +
                ", SpecialTimeStart='" + SpecialTimeStart + '\'' +
                ", SpecialTimeEnd='" + SpecialTimeEnd + '\'' +
                ", IsSoftTime=" + IsSoftTime +
                ", IsFTFD=" + IsFTFD +
                ", IsSoftFTFD=" + IsSoftFTFD +
                ", Description='" + Description + '\'' +
                ", customer=" + customer +
                '}';
    }

    public OCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(OCustomer customer) {
        this.customer = customer;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public double getEstimatedDropSize() {
        return EstimatedDropSize;
    }

    public void setEstimatedDropSize(double estimatedDropSize) {
        EstimatedDropSize = estimatedDropSize;
    }

    public String getDeliveryType() {
        return DeliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        DeliveryType = deliveryType;
    }

    public boolean isFirstDelivery() {
        return IsFirstDelivery;
    }

    public void setFirstDelivery(boolean firstDelivery) {
        IsFirstDelivery = firstDelivery;
    }

    public String getSpecialTimeStart() {
        return SpecialTimeStart;
    }

    public void setSpecialTimeStart(String specialTimeStart) {
        SpecialTimeStart = specialTimeStart;
    }

    public String getSpecialTimeEnd() {
        return SpecialTimeEnd;
    }

    public void setSpecialTimeEnd(String specialTimeEnd) {
        SpecialTimeEnd = specialTimeEnd;
    }

    public Boolean getSoftTime() {
        return IsSoftTime;
    }

    public void setSoftTime(Boolean softTime) {
        IsSoftTime = softTime;
    }

    public Boolean getFTFD() {
        return IsFTFD;
    }

    public void setFTFD(Boolean FTFD) {
        IsFTFD = FTFD;
    }

    public Boolean getSoftFTFD() {
        return IsSoftFTFD;
    }

    public void setSoftFTFD(Boolean softFTFD) {
        IsSoftFTFD = softFTFD;
    }


    public String getDescription() {
        return Description;
    }


    public void setDescription(String description) {
        Description = description;
    }
}
