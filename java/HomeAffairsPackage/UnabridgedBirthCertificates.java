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
public class UnabridgedBirthCertificates {
    //instantiates the fields
    private String staffID;
    private String appointmentID;
    private Image parentIDNumber;
    
    //parameterised constructor method
    public UnabridgedBirthCertificates(String appID, String sID, Image pID) {
        appointmentID = appID;
        staffID = sID;
        parentIDNumber = pID;
    }
    
    //returns the appointmentID field
    public String getAppointmentID() {
        return appointmentID;
    }
    
    //returns the staffID field
    public String getStaffID() {
        return staffID;
    }
    
    //returns the parentIDNumber field
    public Image getParentIDNumber() {
        return parentIDNumber;
    }
    
    //edits the appointmentID field
    public void setappointmentID(String app) {
        appointmentID = app;
    }
    
    //edits the staffID field
    public void setStaffID(String s) {
        staffID = s;
    }
    
    //edits the parentIDNumber field
    public void setParentIDNumber(Image p) {
        parentIDNumber = p;
    }
}
