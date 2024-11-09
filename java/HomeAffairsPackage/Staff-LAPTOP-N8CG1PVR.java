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
public class Staff {
    //instantiates the fields
    private String IDNumber, roleID, firstName, middleName, surname, password;

    //parameterised constructor method    
    public Staff(String sID, String rID, String fName, String mName, 
            String sName, String pass) {
        //assigns values to fields
        IDNumber = sID;
        roleID = rID;
        firstName = fName;
        middleName = mName;
        surname = sName;
        password = pass;
    }

    //returns the ID field
    public String getID() {
        return IDNumber;
    }
    
    //returns the roleID field
    public String getRoleID() {
        return roleID;
    }

    //returns the firstName field
    public String getFirstName() {
        return firstName;
    }

    //returns the middleName field
    public String getMiddleName() {
        return middleName;
    }

    //returns the surname field
    public String getSurname() {
        return surname;
    }

    //returns the password field
    public String getPassword() {
        return password;
    }

    //returns the ID field
    public void setID(String i) {
        IDNumber = i;
    }
   
    //edits the firstName field
    public void setFirstName(String f) {
        firstName = f;
    }

    //edits the middleName field
    public void setMiddleName(String m) {
        middleName = m;
    }

    //edits the surname field
    public void setSurname(String s) {
        surname = s;
    }
}
