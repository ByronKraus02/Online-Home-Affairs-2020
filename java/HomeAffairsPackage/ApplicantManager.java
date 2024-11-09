/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeAffairsPackage;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author byronkraus
 */
public class ApplicantManager {

    private DatabaseManager dbm;//instantiates DatabaseManager class
    private Applicant[] applicantArr = new Applicant[100];//instantiates array of
    //type Applicant
    private int size = 0;//instantiates array counter
    private String error;//instantiates error string

    public ApplicantManager() {//default constructor method
        try {
            //retrieves from Access database and creates Applicant
            ResultSet rs = dbm.queryDatabase("SELECT * FROM tblApplicant");
            while (!(rs.next())) {
                applicantArr[size] = new Applicant(rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8));
                size++;
            }
        } catch (SQLException ex) {//sends error message
            error = "Unable to retrieve information from tblApplicant";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }

    //adds a new applicant to database and array with retrieved fields
    public void addApplicant(String cID, String fName, String mName, String sName,
            String DOB, String cNumber, String email, String pass) {

        applicantArr[size] = new Applicant(cID, fName, mName, sName, DOB, cNumber,
                email, pass);
        size++;
        try {
            ResultSet rs = dbm.queryDatabase("INSERT INTO tblApplicant(firstname"
                    + ", middlename, surname, idnumber, dateofbirth, cellno, "
                    + "email, password) VALUES(" + "'cID'" + "','" + "'fName'"
                    + "','" + "'mName'" + "','" + "'sName'" + "','" + "'DOB'"
                    + "','" + "'cNumber'" + "','" + "'email'" + "','" + "'pass'"
                    + ")");

        } catch (SQLException ex) {
            error = "Unable to insert into tblApplicant";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }

    //returns applicant with matching ID
    public Applicant getApplicant(String id) {
        Applicant test = null;
        for (int i = 0; i < size; i++) {
            if (applicantArr[i].getID().equals(id)) {
                test = applicantArr[i];
            }
        }
        return test;
    }

    //checks to see if ID is in array and it's position
    public int checkApplicantID(String id) {
        int test = -1;
        for (int i = 0; i < size; i++) {
            if (applicantArr[i].getID().equals(id)) {
                test = i;
            }
        }
        return test;
    }

    //checks to see if password is in array and it's position
    public boolean checkApplicantPassword(int pos, String password) {
        boolean test = false;
        if (applicantArr[pos].getPassword().equals(password)) {
            test = true;
        }
        return test;
    }

    public boolean checkApplicantName(int pos, String name) {
        boolean check = false;
        if (applicantArr[pos].getFirstName().equals(name)) {
            check = true;
        }
        return check;
    }

    //deletes Applicant from database and array where ID is equal
    public void deleteFromDatabase(String id) {
        for (int i = 0; i < size; i++) {
            if (applicantArr[i].getID().equals(id)) {
                shiftLeft(i);
            }
        }
        try {
            ResultSet rs = dbm.queryDatabase("DELETE *  FROM tblApplicant "
                    + "WHERE idnumber = id");
        } catch (SQLException ex) {
            error = "Unable to delete from tblApplicant";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }

    //removes Applicant at a chosen position from array
    public void shiftLeft(int i) {
        for (int j = i; j < size; j++) {
            applicantArr[j] = applicantArr[j + 1];
        }
        applicantArr[size] = null;
        size--;
    }

    //updates database with new data
    public void setName(String name, String id) {
        try {
            ResultSet rs = dbm.queryDatabase("UPDATE tblApplicant SET firstname "
                    + "= " + "'name'" + "WHERE idnumber = " + "'id'");
        } catch (SQLException e) {
            error = "Unable to update firstname in tblApplicant";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }

    //updates database with new data
    public void setMiddleName(String middleName, String id) {
        try {
            ResultSet rs = dbm.queryDatabase("UPDATE tblApplicant SET middlename "
                    + "= " + "'middleName'" + "WHERE idnumber = " + "'id'");
        } catch (SQLException e) {
            error = "Unable to update middlename in tblApplicant";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }

    //updates database with new data
    public void setSurname(String surname, String id) {
        try {
            ResultSet rs = dbm.queryDatabase("UPDATE tblApplicant SET surname "
                    + "= " + "'surname'" + "WHERE idnumber = " + "'id'");
        } catch (SQLException e) {
            error = "Unable to update surname in tblApplicant";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }

    //updates database with new data
    public void setEmail(String email, String id) {
        try {
            ResultSet rs = dbm.queryDatabase("UPDATE tblApplicant SET email "
                    + "= " + "'email'" + "WHERE idnumber = " + "'id'");
        } catch (SQLException e) {
            error = "Unable to update email in tblApplicant";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }

    //updates database with new data
    public void setCellNumber(String cellNumber, String id) {
        try {
            ResultSet rs = dbm.queryDatabase("UPDATE tblApplicant SET cellnumber "
                    + "= " + "'cellNumber'" + "WHERE idnumber = " + "'id'");
        } catch (SQLException e) {
            error = "Unable to update cellnumber in tblApplicant";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }
}
