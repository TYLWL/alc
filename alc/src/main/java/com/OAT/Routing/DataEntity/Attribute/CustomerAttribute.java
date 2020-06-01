package com.OAT.Routing.DataEntity.Attribute;


public class CustomerAttribute  {
    private String CustomerAttrID;
    private String Type;
    private String Description;

    public CustomerAttribute(String customerAttrID, String type, String description) {
        CustomerAttrID = customerAttrID;
        Type = type;
        Description = description;
    }

    @Override

    public String toString() {
        return "CustomerAttribute{" +
                "CustomerAttrID='" + CustomerAttrID + '\'' +
                ", Type='" + Type + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }

    public String getCustomerAttrID() {
        return CustomerAttrID;
    }

    public void setCustomerAttrID(String customerAttrID) {
        CustomerAttrID = customerAttrID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
