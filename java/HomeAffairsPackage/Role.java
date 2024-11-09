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
public class Role {
    private String roleID, roleDescription;
    
    //parameterised constructor method 
    public Role(String rID, String rD) {
        roleID = rID;
        roleDescription = rD;
    }
    
    //returns the field roleID
    public String getRoleID() {
        return roleID;
    }
    
    //returns the field roleDescription
    public String getRoleDescription() {
        return roleDescription;
    }
        
}
