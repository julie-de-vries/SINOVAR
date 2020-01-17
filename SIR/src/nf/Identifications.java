/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author Julie
 */
public class Identifications {
    
    /*String hashWith256(String textToHash) { //encryption
        MessageDigest digest=null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Personnel.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] byteOfTextToHash = textToHash.getBytes(StandardCharsets.UTF_8);
        byte[] hashedByetArray = digest.digest(byteOfTextToHash);
        String encoded = Base64.getEncoder().encodeToString(hashedByetArray);
        return encoded;
    }*/
    
    
    
    String authentification(String id, String password){
        String name=null;
        DataBaseLayer DBL = new DataBaseLayer("SELECT nom FROM personnel WHERE id ='"+id+"' AND password='"+password+"'");
        
        try {
            String result = DBL.getResult().getString(1); /*récupère le nom du personnel authetifié*/
            boolean test = DBL.getResult().wasNull(); /*vérifie si une personne a été authentifiée*/
            if(!test){
                name=result;
            }
                } catch (SQLException ex) {
            Logger.getLogger(Identifications.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        return name;
        /*sans id et mot de passe correspondant, la méthode retourne un string null*/
    } 
    
}
