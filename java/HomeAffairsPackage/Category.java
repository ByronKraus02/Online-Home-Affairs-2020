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
public class Category {
    private String categoryID, categoryName;//instantiates fields
    
    public Category(String cID, String cNM) {//parameterised constructor
        categoryID = cID;
        categoryName = cNM;
    }
    
    //retrieves the category ID
    public String getCategoryID() {
        return categoryID;
    }
    
    //retrieves the category name
    public String getCategoryName() {
        return categoryName;
    }
}

