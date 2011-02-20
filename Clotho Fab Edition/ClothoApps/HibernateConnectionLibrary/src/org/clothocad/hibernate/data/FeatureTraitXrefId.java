package org.clothocad.hibernate.data;
// Generated Oct 12, 2010 7:14:51 PM by Hibernate Tools 3.2.1.GA



/**
 * FeatureTraitXrefId generated by hbm2java
 */
public class FeatureTraitXrefId  implements java.io.Serializable {


     private String featureId;
     private String traitId;

    public FeatureTraitXrefId() {
    }

    public FeatureTraitXrefId(String featureId, String traitId) {
       this.featureId = featureId;
       this.traitId = traitId;
    }
   
    public String getFeatureId() {
        return this.featureId;
    }
    
    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }
    public String getTraitId() {
        return this.traitId;
    }
    
    public void setTraitId(String traitId) {
        this.traitId = traitId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FeatureTraitXrefId) ) return false;
		 FeatureTraitXrefId castOther = ( FeatureTraitXrefId ) other; 
         
		 return ( (this.getFeatureId()==castOther.getFeatureId()) || ( this.getFeatureId()!=null && castOther.getFeatureId()!=null && this.getFeatureId().equals(castOther.getFeatureId()) ) )
 && ( (this.getTraitId()==castOther.getTraitId()) || ( this.getTraitId()!=null && castOther.getTraitId()!=null && this.getTraitId().equals(castOther.getTraitId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFeatureId() == null ? 0 : this.getFeatureId().hashCode() );
         result = 37 * result + ( getTraitId() == null ? 0 : this.getTraitId().hashCode() );
         return result;
   }   


}

