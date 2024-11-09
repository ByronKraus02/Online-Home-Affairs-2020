/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeAffairsPackage;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author byronkraus
 */
public class UnabridgedBirthCertificatesManager {
    //instantiates the field
    private DatabaseManager dbm;
    private UnabridgedBirthCertificates[] ubcArr = new 
            UnabridgedBirthCertificates [100];
    private int size = 0;
    private String error;
    
    //default constructor method
    public UnabridgedBirthCertificatesManager() {
        try {
            ResultSet rs = dbm.queryDatabase("SELECT appointment_ID"
                    + "FROM tblUnabridgedBirthCertificate");
            Image ts = (Image)(dbm.queryDatabase("SELECT parentidnumber "
                    + "FROM tblSmartID"));

            while (!(rs.next())) {
                ubcArr[size] = new UnabridgedBirthCertificates(rs.getString(1)
                        , ts);
                size++;
            }
        } catch (SQLException ex) {//changes to the error screen
            error = "Unable to retrieve from tblUnaBridgedBirthCertificate";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }
    
    //adds an UnabridgedBirthCertificate to the array and access database
    public void addUnabridgedBirthCertificate(String appID, 
            Image pID) {
        ubcArr[size] = new UnabridgedBirthCertificates(appID, pID);
        size++;
        try {
            ResultSet rs = dbm.queryDatabase("INSERT INTO "
                    + "tblUnabridgedBirthCertificate(appointment_ID, "
                    + "parentidnumber) VALUES(" + "'appID'" + "','" 
                    + "','" + "'pID'" + ")");
            
        } catch (SQLException ex) {//changes to the error screen
            error = "Unable to insert into tblUnaBridgedBirthCertificate";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }
    
    //retrieves an UnabridgedBirthCertificate with the corresponding 
    //appoinmentID
    public UnabridgedBirthCertificates 
        getUnabridgedBirthCertificate(String id) {
            
        UnabridgedBirthCertificates test = null;
        for (int i = 0; i < size; i++) {
            if (ubcArr[i].getAppointmentID().equals(id)) {
                test = ubcArr[i];
            }
        }
        return test;
    }
    
    //removes an UnabridgedBirthCertificate from the database and from the array
    public void deleteFromDatabase(String id) {
       for (int i = 0; i < size; i++) {
            if (ubcArr[i].getAppointmentID().equals(id)) {
                shiftLeft(i);
            }
        }
        try {
            ResultSet rs = dbm.queryDatabase("DELETE *  FROM "
                    + "tblUnabridgedBirthCertificate WHERE" + "'appoinment_ID'" 
                    + "=" + "'id'");
        } catch (SQLException ex) {//changes to the error screen
            error = "Unable to delete from tblUnaBridgedBirthCertificate";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }

    //removes the UnabridgedBirthCertificate from the array
    public void shiftLeft(int i) {
        for (int j = i; j < size; j++) {
            ubcArr[j] = ubcArr[j + 1];
        }
        ubcArr[size] = null;
        size--;
    }
    
    //returns a 2D array with all past UnabridgedBirthCertifcate
    public String[][] getPastUnabridgedBirthCertificate() {
        String[][] temp = new String[5][100];
        try {
            ResultSet rs = dbm.queryDatabase("SELECT idnumber, firstname, "
                    + "middlename, surname FROM tblApplicant WHERE "
                    + "tblUnabridgedBirthCertificate.appointment_ID = "
                    + "tblAppointment.appointment_ID AND "
                    + "tblAppointment.applicant_ID = "
                    + "tblApplicant.applicant_ID");
            
            ResultSet ss = dbm.queryDatabase("SELECT appointmentdatetime FROM "
                    + "tblAppointment WHERE "
                    + "tblUnabridgedBirthCertificate.appointment_ID = "
                    + "tblAppointment.appointment_ID");
            
            int i = 0;
            while (rs.next() && ss.next()) {
                temp[i][0] = rs.getString(1);
                temp[i][1] = rs.getString(2);
                temp[i][2] = rs.getString(3);
                temp[i][3] = rs.getString(4);
                temp[i][4] = ss.getString(5);
                i++;
            }
        } catch (SQLException ex) {//changes to the error screen
            error = "Unable to retrieve from tblApplicant or tblAppointment";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
        return temp;
    }
}
