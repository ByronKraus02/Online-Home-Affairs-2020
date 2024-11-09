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
public class PassportManager {

    private DatabaseManager dbm;//instantiates DatabaseManager class
    private Passports[] pArr = new Passports[100];//instantiates array of type
    //Passports
    private int size = 0;//instantiates array counter
    private String error;//instantiates the error String

    public PassportManager() {//default constructor method
        try {
            //retrieves from Access database and creates Applicant
            ResultSet rs = dbm.queryDatabase("SELECT appointment_ID "
                    + "FROM tblPassport");
            Image ss = (Image) (dbm.queryDatabase("SELECT idnumber "
                    + "FROM tblPassport"));
            while (!(rs.next())) {
                pArr[size] = new Passports(rs.getString(1), ss);
                size++;
            }
        } catch (SQLException ex) {//sends error message
            error = "Unable to retrieve data from tblPassport";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }

    //adds a passport booking to access and the array
    public void addPassport(String appID, Image pID) {
        pArr[size] = new Passports(appID, pID);
        size++;
        try {
            ResultSet rs = dbm.queryDatabase("INSERT INTO "
                    + "tblPassport(appointment_ID, idnumber) "
                    + "VALUES(" + "'appID'" + "','" 
                    + "'pID'" + ")");
        } catch (SQLException ex) {//sends error message
            error = "Unable to add a passport booking to tblPassport";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }

    //finds the passport details with the appointment ID
    public Passports getPassport(String id) {
        Passports test = null;
        for (int i = 0; i < size; i++) {
            if (pArr[i].getAppointmentID().equals(id)) {
                test = pArr[i];
            }
        }
        return test;
    }

    //removes the passport booking from access and the array
    public void deleteFromDatabase(String id) {
        for (int i = 0; i < size; i++) {
            if (pArr[i].getAppointmentID().equals(id)) {
                shiftLeft(i);
            }
        }
        try {
            ResultSet rs = dbm.queryDatabase("DELETE *  FROM tblPassport "
                    + "WHERE appoinment_ID = id");
        } catch (SQLException ex) {//sends error message
            error = "Unable to delete from tblPassport";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }

    //removes the passport booking which was selected, from the array
    public void shiftLeft(int i) {
        for (int j = i; j < size; j++) {
            pArr[j] = pArr[j + 1];
        }
        pArr[size] = null;
        size--;
    }

    //recieves all past users who booked a passport renewal and returns it in a
    //user friendly manner
    public String[][] getPastPassport() {
        String[][] temp = new String[5][100];
        try {
            ResultSet rs = dbm.queryDatabase("SELECT idnumber, firstname, "
                    + "middlename, surname FROM tblApplicant WHERE "
                    + "tblPassport.appointment_ID = "
                    + "tblAppointment.appointment_ID AND "
                    + "tblAppointment.applicant_ID = tblApplicant.applicant_ID");
            
            ResultSet ss = dbm.queryDatabase("SELECT appointmentdatetime FROM "
                    + "tblAppointment WHERE tblPassport.appointment_ID = "
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
        } catch (SQLException ex) {
            error = "Unable to retrieve from tblApplicant or tblApppointment";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
        return temp;
    }
}
