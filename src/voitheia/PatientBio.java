/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voitheia;

/**
 *
 * @author the.devils.advocate
 */
public class PatientBio {
    String name = "";
    String gender = "";
    String age = "";
    Boolean isAlchoholic = false;
    Boolean isDruggy = false;
    Boolean isFamilyHistoryMental = false;
    Boolean isPregnant = false;
    Boolean isTraumatised = false;

    public PatientBio() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Boolean getIsAlchoholic() {
        return isAlchoholic;
    }

    public void setIsAlchoholic(Boolean isAlchoholic) {
        this.isAlchoholic = isAlchoholic;
    }

    public Boolean getIsDruggy() {
        return isDruggy;
    }

    public void setIsDruggy(Boolean isDruggy) {
        this.isDruggy = isDruggy;
    }

    public Boolean getIsFamilyHistoryMental() {
        return isFamilyHistoryMental;
    }

    public void setIsFamilyHistoryMental(Boolean isFamilyHistoryMental) {
        this.isFamilyHistoryMental = isFamilyHistoryMental;
    }

    public Boolean getIsPregnant() {
        return isPregnant;
    }

    public void setIsPregnant(Boolean isPregnant) {
        this.isPregnant = isPregnant;
    }

    public Boolean getIsTraumatised() {
        return isTraumatised;
    }

    public void setIsTraumatised(Boolean isTraumatised) {
        this.isTraumatised = isTraumatised;
    }
    
    
}
