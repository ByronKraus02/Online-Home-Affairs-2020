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
public class StaffManager {
    //instantiates the fields    
    private DatabaseManager dbm;
    private Staff[] staffArr = new Staff [100];
    private int size = 0;
    private String error;
    //defualt constructor method
    public StaffManager() {
        try {
            //retrieves from the access database
            ResultSet rs = dbm.queryDatabase("SELECT * FROM tblStaff");
            while (!(rs.next())) {//enters the database data into the array
                staffArr[size] = new Staff(rs.getString(1), rs.getString(2), 
                        rs.getString(3), rs.getString(4), rs.getString(5), 
                        rs.getString(6));
                size++;
            }
        } catch (SQLException ex) {//changes to the error screen
            error = "Unable to retrieve from tblStaff";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }
    
    //adds a staff member to the array and access database
    public void addStaff(String sID, String rID, String fName, 
            String mName, String sName, String pass) {
        
        staffArr[size] = new Staff(sID, rID, fName, mName, sName, pass);
        size++;
        try {
            ResultSet rs = dbm.queryDatabase("INSERT INTO tblStaff( idnumber, "
                    + "roleID, firstname, middlename, surname, password) "
                    + "VALUES(" + "'sID'" + "','" +  "'rID'" + "','"  
                    + "'fName'" + "','" + "'mName'" + "','" + "'sName'" + "','" 
                    + "'pass'" + "','" + ")");
        } catch (SQLException ex) {//changes to the error screen
            error = "Unable to insert into tblStaff";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }
    
    //returns the staff member with the corresponding ID number
    public Staff getStaff(String id) {
        Staff test = null;
        for(int i = 0; i < size; i++) {
            if(staffArr[i].getID().equals(id)) {
                test = staffArr[i];
            }
        }
        return test;
    }
    
    //checks if the ID is in the staff ID database
     public int checkStaffID(String id) {
        int test = -1;
        for (int i = 0; i < size; i++) {
            if (staffArr[i].getID().equals(id)) {
                test = i;
            }
        }
        return test;
    }
    
    //checks if the password is in the database at the staff's ID's position
    public boolean checkStaffPassword(int pos, String password) {
        boolean test = false;
        if(staffArr[pos].getPassword().equals(password)) {
                test = true;
        }
        return test;
    }
    
    //returns the role of the staff
    public String checkRole(int pos) {
        return staffArr[pos].getRoleID();
    }

    //deletes the staff member from the database and from the array
    public void deleteFromDatabase(String id) {
       for (int i = 0; i < size; i++) {
            if (staffArr[i].getID().equals(id)) {
                shiftLeft(i);
            }
        }
        try {
            ResultSet rs = dbm.queryDatabase("DELETE *  FROM tblApplicant "
                    + "WHERE idnumber = id");
        } catch (SQLException ex) {
            error = "Unable to delete from tblStaff";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }

    //removes staff member at a chosen position from array
    public void shiftLeft(int i) {
        for (int j = i; j < size; j++) {
            staffArr[j] = staffArr[j + 1];
        }
        staffArr[size] = null;
        size--;
    }
    
    //returns a 2D String with the employees hired
    public String[][] getEmployeeHiredArray()  {
        String [][] temp = new String [5][100];
        for(int i = 0; i < size; i++) {
            temp[i][0] = staffArr[i].getID();
            temp[i][1] = staffArr[i].getFirstName();
            temp[i][2] = staffArr[i].getMiddleName();
            temp[i][3] = staffArr[i].getSurname();
            temp[i][4] = staffArr[i].getRoleID();
        }
        return temp;
    }
    
    //updates database with new data
    public void setName(String name, String id) {
        try {
            ResultSet rs = dbm.queryDatabase("UPDATE tblStaff SET firstname "
                    + "= " + "'name'" + "WHERE idnumber = " + "'id'");
        } catch (SQLException e) {
            error = "Unable to update firstname in tblStaff";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }

    //updates database with new data
    public void setMiddleName(String middleName, String id) {
        try {
            ResultSet rs = dbm.queryDatabase("UPDATE tblStaff SET middlename "
                    + "= " + "'middleName'" + "WHERE idnumber = " + "'id'");
        } catch (SQLException e) {
            error = "Unable to update middlename in tblStaff";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }

    //updates database with new data
    public void setSurname(String surname, String id) {
        try {
            ResultSet rs = dbm.queryDatabase("UPDATE tblStaff SET surname "
                    + "= " + "'surname'" + "WHERE idnumber = " + "'id'");
        } catch (SQLException e) {
            error = "Unable to update surname in tblStaff";
            ErrorScreen eng = new ErrorScreen(error);
            eng.setVisible(true);
        }
    }
}
