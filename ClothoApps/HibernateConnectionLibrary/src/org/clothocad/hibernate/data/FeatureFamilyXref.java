package org.clothocad.hibernate.data;
// Generated Oct 12, 2010 7:14:51 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * FeatureFamilyXref generated by hbm2java
 */
public class FeatureFamilyXref  implements java.io.Serializable {


     private FeatureFamilyXrefId id;
     private FeatureTable featureTable;
     private FamilyTable familyTable;
     private Date dateCreated;
     private Date lastModified;

    public FeatureFamilyXref() {
    }

	
    public FeatureFamilyXref(FeatureFamilyXrefId id, FeatureTable featureTable, FamilyTable familyTable) {
        this.id = id;
        this.featureTable = featureTable;
        this.familyTable = familyTable;
    }
    public FeatureFamilyXref(FeatureFamilyXrefId id, FeatureTable featureTable, FamilyTable familyTable, Date dateCreated, Date lastModified) {
       this.id = id;
       this.featureTable = featureTable;
       this.familyTable = familyTable;
       this.dateCreated = dateCreated;
       this.lastModified = lastModified;
    }
   
    public FeatureFamilyXrefId getId() {
        return this.id;
    }
    
    public void setId(FeatureFamilyXrefId id) {
        this.id = id;
    }
    public FeatureTable getFeatureTable() {
        return this.featureTable;
    }
    
    public void setFeatureTable(FeatureTable featureTable) {
        this.featureTable = featureTable;
    }
    public FamilyTable getFamilyTable() {
        return this.familyTable;
    }
    
    public void setFamilyTable(FamilyTable familyTable) {
        this.familyTable = familyTable;
    }
    public Date getDateCreated() {
        return this.dateCreated;
    }
    
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Date getLastModified() {
        return this.lastModified;
    }
    
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }




}

