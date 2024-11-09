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
public class SmartIDManager {
    //instantiates the fields
    private DatabaseManager dbm;
    private SmartIDs[] sArr = new SmartIDs [100];
    private int size = 0;
    private String error;
    
    //constructor method for smartIDs
    public SmartIDManager() {
        try {
            //retrieves from access database
            ResultSet rs = dbm.queryDatabase("SELECT appointment_ID, staff_ID "
                    + "FROM tblSmartID");
            Image ts = (Image)(dbm.queryDatabase("SELECT passport FROM "
                    + "tblSmartID"));
            Image us = (Image)(dbm.queryDatabase("SELECT parentidnumber FROM "
                    + "tblSmartID"));
            Image ss = (Image) (dbm.queryDatabase("SELECT birthcertificate FROM "
                    + "tblSmartID"));
            Image vs = (Image) (dbm.queryDatabase("SELECT proofofresidence FROM "
                    + "tblSmartID"));

            //inputs the database data into the array
            while (!(rs.next())) {
                sArr[size] = new SmartIDs(rs.getString(1), rs.getString(2), ts, 
                        us, ss, vs);
                size++;
            }
        } catch (SQLException ex) {//changes to error screen
            error = "Unable to retrieve from tblSmartID";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }
    
    //adds a smartID object who is a first time applicant to the array and to 
    //access
    public void addSmartID(String appID, String sID, Image p, Image pID, 
            Image b, Image POR) {
        
        sArr[size] = new SmartIDs(appID, sID, p, pID, b, POR);
        size++;
        try {
            ResultSet rs = dbm.queryDatabase("INSERT INTO tblSmartID"
                    + "(appointment_ID, staff_ID, passport, parentidnumber, "
                    + "birthcertificate, proofofresidence) VALUES(" + "'appID'" 
                    + "','" + "'sID'" + "','" + "'p'" + "'pID'" + "'b'" + "'POR'" 
                    + ")");
            
        } catch (SQLException ex) {//changes to error screen
            error = "Unable to insert into tblSmartID";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }
    
    //adds a smartID object who isn't a first time applicant to the array and to access
    public void addSmartID(String appID, String sID, Image p, Image b, 
            Image POR) {
        
        sArr[size] = new SmartIDs(appID, sID, p, null, b, POR);
        size++;
        try {
            ResultSet rs = dbm.queryDatabase("INSERT INTO "
                    + "tblSmartID(appointment_ID, staff_ID, passport, "
                    + "parentidnumber, birthcertificate, proofofresidence) "
                    + "VALUES(" + "'appID'" + "','" + "'sID'" + "','" + "'p'" 
                    + "" + "'b'" + "'POR'" + ")");
            
        } catch (SQLException ex) {//changes to error screen
            error = "Unable to insert into tblSmartID";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }
    
    //finds a smartID booking with the corresponding appointment ID
    public SmartIDs getSmartID(String id) {
       SmartIDs test = null;
        for (int i = 0; i < size; i++) {
            if (sArr[i].getAppointmentID().equals(id)) {
                test = sArr[i];
            }
        }
        return test;
    }
    
    //removes the SmartID from access and the array
    public void deleteFromDatabase(String id) {
        for (int i = 0; i < size; i++) {
            if (sArr[i].getAppointmentID().equals(id)) {
                shiftLeft(i);
            }
        }
        try {
            ResultSet rs = dbm.queryDatabase("DELETE *  FROM tblSmartID WHERE" 
                    + "'appoinment_ID'" + "=" + "'id'");
            
        } catch (SQLException ex) {//changes to error screen
            error = "Unable to delete from tblSmartID";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }

    //removes the selected SmartID from the array
    public void shiftLeft(int i) {
        for (int j = i; j < size; j++) {
            sArr[j] = sArr[j + 1];
        }
        sArr[size] = null;
        size--;
    }
    
    //returns all the past SmartID applicants in a user-friendly manner
    public String[][] getPastEmployeeHiredArray() {
        String[][] temp = new String[5][100];
        try {
            ResultSet rs = dbm.queryDatabase("SELECT idnumber, firstname, "
                    + "middlename, surname FROM tblApplicant WHERE "
                    + "tblSmartID.appointment_ID = tblAppointment.appointment_ID "
                    + "AND tblAppointment.applicant_ID = "
                    + "tblApplicant.applicant_ID");
            ResultSet ss = dbm.queryDatabase("SELECT appointmentdatetime FROM "
                    + "tblAppointment WHERE tblSmartID.appointment_ID = "
                    + "tblAppointment.appointment_ID");
            int i = 0;
            while (rs.next() && ss.next()) {//inserts into the 2D array
                temp[i][0] = rs.getString(1);
                temp[i][1] = rs.getString(2);
                temp[i][2] = rs.getString(3);
                temp[i][3] = rs.getString(4);
                temp[i][4] = ss.getString(5);
                i++;
            }
        } catch (SQLException ex) {//changes to error screen
            error = "Unable to retrieve from tblApplicant or tblAppointment";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
        return temp;
    }
}
