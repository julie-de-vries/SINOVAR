/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Julie
 */
public class Identifications {
    private String name;
    private boolean auth;
    private boolean ajoutTableConnections;
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
    
    
    
    public Identifications(String id, String password){
        DataBaseLayer DBL = new DataBaseLayer("SELECT nom FROM sinovar.utilisateur WHERE id ='"+id+"' AND password='"+password+"';");
        ArrayList<ArrayList<String>> result=DBL.getResult();
            result.remove(0);
            auth = !result.isEmpty(); /*vérifie si une personne a été authentifiée*/
            if(auth){
                name= result.get(0).get(0); /*récupère le nom du personnel authetifié*/
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String date=dateFormat.format(new Date());
                DBL = new DataBaseLayer("INSERT INTO connections VALUES('"+date+"','"+id+"');");/*ajoute la connection à la base de données*/
                int m = DBL.getModification();
                ajoutTableConnections=(m>0);/*vrai si la modification a bien été effectuée*/
            }
    } 

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the auth
     */
    public boolean isAuth() {
        return auth;
    }
    
}
