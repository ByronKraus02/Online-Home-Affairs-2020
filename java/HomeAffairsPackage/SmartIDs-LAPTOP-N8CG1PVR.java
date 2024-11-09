/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeAffairsPackage;

import java.awt.Image;

/**
 *
 * @author byronkraus
 */
public class SmartIDs {
    //instantiates classes
    private String appointmentID;
    private Image passport, parentIDNumber, birthCertificate, proofOfResidence;
    
    //parameterised constructor method
    public SmartIDs(String appID, Image p, Image pID, Image b, 
            Image POR) {
        //assigns values to a field
        appointmentID = appID;
        passport = p;
        parentIDNumber = pID;
        birthCertificate = b;
        proofOfResidence = POR;
        
    }
    
    //returns the AppointmentID field
    public String getAppointmentID() {
        return appointmentID;
    }
    
    //returns the passport field
    public Image getPassport() {
        return passport;
    }
    
    //returns the parentIDNumber field
    public Image getParentIDNumber() {
        return parentIDNumber;
    }
    
    //returns the birthcertificate field
    public Image getBirthCertificate() {
        return birthCertificate;
    }
    
    //returns the proofOfResidence field
    public Image getProofOfResidence() {
        return proofOfResidence;
    }
    
    //edits the appointmentDateTime field
    public void setAppointmentDateTime(String app) {
        appointmentID = app;
    }
    
    //edits the passport field
    public void setPassport(Image p) {
        passport = p;
    }
    
    //edits the parentIDNumber field
    public void setParentIDNumber(Image pID) {
        parentIDNumber = pID;
    }
    
    //edits the birthCertificate field
    public void setBirthCertificate(Image b) {
        birthCertificate = b;
    }
    
    //edits the proofOfResidence field
    public void setProofOfResidence(Image POR) {
        proofOfResidence = POR;
    }
 
}
