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
public class Applicant {

    private String IDNumber, firstName, middleName, surname, dateOfBirth,
            cellNumber, email, password;//instantiates fields

    //Parameterised Constructor method
    public Applicant(String fName, String mName, String sName, String cID,
            String DOB, String cNumber, String em, String pass) {

        firstName = fName;
        middleName = mName;
        surname = sName;
        IDNumber = cID;
        dateOfBirth = DOB;
        cellNumber = cNumber;
        email = em;
        password = pass;
    }

    public String getID() {//retrieves the ID
        return IDNumber;
    }

    public String getFirstName() {//retrieves the first name
        return firstName;
    }

    public String getMiddleName() {//retrieves the middle name
        return middleName;
    }

    public String getSurname() {//retrieves the surname
        return surname;
    }

    public String getDateOfBirth() {//retrieves the date of birth
        return dateOfBirth;
    }

    public String getCellNumber() {//retrieves the cell numebr
        return cellNumber;
    }

    public String getEmail() {//retrieves the email
        return email;
    }

    public String getPassword() {//retrieves the password
        return password;
    }

    public void setID(String i) {//sets the ID
        IDNumber = i;
    }

    public void setFirstName(String f) {//sets the first name
        firstName = f;
    }

    public void setMiddleName(String m) {//sets the middle name
        middleName = m;
    }

    public void setSurname(String s) {//sets the surname
        surname = s;
    }

    public void setCellNumber(String c) {//sets the cell number
        cellNumber = c;
    }

    public void setEmail(String e) {//sets the email
        email = e;
    }
}
