package com.OAT.Routing.DataEntity;

public class ODriver extends ODepot {
    private String PersonnelID;
    private String Name;
    private String DedicatedTrailerID;
    private String DedicatedProductID;
    private boolean IsMedicalLoxCertified;
    private boolean IsOnlyRigid;
    private String Description;

    public ODriver(String regionID, double latitude, double longitude, String depotID, String personnelID, String name, String dedicatedTrailerID, String dedicatedProductID, boolean isMedicalLoxCertified, boolean isOnlyRigid, String description) {
        super(regionID, latitude, longitude, depotID);
        PersonnelID = personnelID;
        Name = name;
        DedicatedTrailerID = dedicatedTrailerID;
        DedicatedProductID = dedicatedProductID;
        IsMedicalLoxCertified = isMedicalLoxCertified;
        IsOnlyRigid = isOnlyRigid;
        Description = description;
    }

    public String getPersonnelID() {
        return PersonnelID;
    }

    public void setPersonnelID(String personnelID) {
        PersonnelID = personnelID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDedicatedTrailerID() {
        return DedicatedTrailerID;
    }

    public void setDedicatedTrailerID(String dedicatedTrailerID) {
        DedicatedTrailerID = dedicatedTrailerID;
    }

    public String getDedicatedProductID() {
        return DedicatedProductID;
    }

    public void setDedicatedProductID(String dedicatedProductID) {
        DedicatedProductID = dedicatedProductID;
    }

    public boolean isMedicalLoxCertified() {
        return IsMedicalLoxCertified;
    }

    public void setMedicalLoxCertified(boolean medicalLoxCertified) {
        IsMedicalLoxCertified = medicalLoxCertified;
    }

    public boolean isOnlyRigid() {
        return IsOnlyRigid;
    }

    public void setOnlyRigid(boolean onlyRigid) {
        IsOnlyRigid = onlyRigid;
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
