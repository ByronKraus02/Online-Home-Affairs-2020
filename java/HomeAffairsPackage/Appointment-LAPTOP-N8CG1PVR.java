/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeAffairsPackage;

/**
 *
 * @author byronkraus
 */
public class Appointment {

    //instantiates fields
    private String applicantID;
    private String category;
    private String appointmentDateTime;

    //paramterised constructor For Appointment
    public Appointment(String app, String cat, String ADT) {
        applicantID = app;
        category = cat;
        appointmentDateTime = ADT;
    }
    
    public String getID() {
        return applicantID;
    } 
    public String getCategory() {
        if (category.equalsIgnoreCase("1")) {
            return "UnaBridgedBirthCertificate";
        } else {
            if(category.equalsIgnoreCase("2")) {
                return "Passport";
            } else {
                if(category.equalsIgnoreCase("3")) {
                    return "SmartID";
                }
            }
        }
        return "No booking";
    }
    
    //returns category number
    public String getNumberCategory() {
        return category;
    }

    //retrieves appointment date and time
    public String getAppointmentDateTime() {
        return appointmentDateTime;
    }

    //sets the appoinment date and time
    public void setAppointmentDateTime(String d) {
        appointmentDateTime = d;
    }
    
    public String getAppointmentTime() {
        String test = appointmentDateTime.substring(11);
        return test;
    }
    
    public String getAppointmentDate() {
        String test = appointmentDateTime.substring(0, 12);
        return test;
    }
}
