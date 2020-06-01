package com.OAT.Routing.DataEntity;

import java.util.HashSet;

public class OEmissionStandard {
    private String EmissionStandardID;
    private String Description;
    private HashSet<OEmissionStandard> emissionStandard;

    public OEmissionStandard(String emissionStandardID,  String description) {
        EmissionStandardID = emissionStandardID;
        Description = description;
    }

    public void setEmissionStandard(OEmissionStandard e) {
        emissionStandard.add(e);
    }
    public boolean isCompatible(OEmissionStandard e){
        return emissionStandard.contains(e);
    }

    public String getEmissionStandardID() {
        return EmissionStandardID;
    }

    public void setEmissionStandardID(String emissionStandardID) {
        EmissionStandardID = emissionStandardID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
