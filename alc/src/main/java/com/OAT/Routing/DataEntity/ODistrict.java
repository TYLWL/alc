package com.OAT.Routing.DataEntity;

public class ODistrict extends ORegion {
    private String DistrictID;
    private String Prefecture;
    private String county;
    private String ERStart;
    private String EREnd;
    private String NMStart;
    private String NMEnd;
    private boolean HasHolidayRestriction;
    private String[] PermittedTrailersID;//List<OTrailer>
    private String Description;

    public ODistrict(String regionID, String districtID, String prefecture, String county, String ERStart, String EREnd, String NMStart, String NMEnd, boolean hasHolidayRestriction, String[] permittedTrailersID, String description) {
        super(regionID);
        DistrictID = districtID;
        Prefecture = prefecture;
        this.county = county;
        this.ERStart = ERStart;
        this.EREnd = EREnd;
        this.NMStart = NMStart;
        this.NMEnd = NMEnd;
        HasHolidayRestriction = hasHolidayRestriction;
        PermittedTrailersID = permittedTrailersID;
        Description = description;
    }

    public String getDistrictID() {
        return DistrictID;
    }

    public void setDistrictID(String districtID) {
        DistrictID = districtID;
    }

    public String getPrefecture() {
        return Prefecture;
    }

    public void setPrefecture(String prefecture) {
        Prefecture = prefecture;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getERStart() {
        return ERStart;
    }

    public void setERStart(String ERStart) {
        this.ERStart = ERStart;
    }

    public String getEREnd() {
        return EREnd;
    }

    public void setEREnd(String EREnd) {
        this.EREnd = EREnd;
    }

    public String getNMStart() {
        return NMStart;
    }

    public void setNMStart(String NMStart) {
        this.NMStart = NMStart;
    }

    public String getNMEnd() {
        return NMEnd;
    }

    public void setNMEnd(String NMEnd) {
        this.NMEnd = NMEnd;
    }

    public boolean getHolidayRestriction() {
        return HasHolidayRestriction;
    }

    public void setHolidayRestriction(boolean hasHolidayRestriction) {
        HasHolidayRestriction = hasHolidayRestriction;
    }

    public String[] getPermittedTrailersID() {
        return PermittedTrailersID;
    }

    public void setPermittedTrailersID(String[] permittedTrailersID) {
        PermittedTrailersID = permittedTrailersID;
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
