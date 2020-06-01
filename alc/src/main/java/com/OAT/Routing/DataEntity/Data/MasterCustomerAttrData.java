package com.OAT.Routing.DataEntity.Data;

import com.OAT.Routing.DataEntity.Attribute.CustomerAttribute;

public class MasterCustomerAttrData extends CustomerAttribute {
    private String data;

    public MasterCustomerAttrData(String customerAttrID, String type, String description, String data) {
        super(customerAttrID, type, description);
        this.data = data;
    }
}
