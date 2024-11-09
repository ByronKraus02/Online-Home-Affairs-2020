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
    private Applicant applicant;
    private Category category;
    private String appointmentDateTime;

    //paramterised constructor For Appointment
    public Appointment(Applicant app, Category cat, String ADT) {
        applicant = app;
        category = cat;
        appointmentDateTime = ADT;
    }

    //retrieves applicants ID
    public String getApplicantID() {
        return applicant.getID();
    }

    //retrieves category name
    public String getCategoryName() {
        return category.getCategoryName();
    }

    //retrieves appointment date and time
    public String getAppointmentDateTime() {
        return appointmentDateTime;
    }

    //sets the appoinment date and time
    public void setAppointmentDateTime(String d) {
        appointmentDateTime = d;
    }
}
