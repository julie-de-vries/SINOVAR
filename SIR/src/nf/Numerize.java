/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

/**
 *
 * @author Julie
 */
public class Numerize {
    
    public Numerize(String fileName){
        DataBaseLayer DBL = new DataBaseLayer("INSERT INTO pacs VALUES('"+fileName+"');");
        /*ajoute la connection à la base de données*/
    }
}
