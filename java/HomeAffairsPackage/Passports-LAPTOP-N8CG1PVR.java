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
public class Passports {
    private String appointmentID;
    private Image IDNumber;
    
    //instantiates the fields
    public Passports(String appID, Image pID) {
        appointmentID = appID;
        IDNumber = pID;
    }
    
    //returns the appointmentID
    public String getAppointmentID() {
        return appointmentID;
    }
    
    //returns the IDNumber
    public Image getIDNumber() {
        return IDNumber;
    }
    
    //edits the appointmentID field
    public void setAppointmentDateTime(String app) {
        appointmentID = app;
    }
    
    //edits the IDNumber field
    public void setIDNumber(Image p) {
        IDNumber = p;
    }
}
