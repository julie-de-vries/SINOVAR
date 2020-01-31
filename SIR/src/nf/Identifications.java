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
    private Professionnel currentUser;
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
    
    
    
    public Identifications(String ids, String password){
        int id =Integer.parseInt(ids);
        DataBaseLayer DBL = new DataBaseLayer("SELECT * FROM sinovar.personnel WHERE id ="+id+" AND motDePasse='"+password+"';");
        ArrayList<ArrayList<String>> result=DBL.getResult();
            result.remove(0);
            auth = !result.isEmpty(); /*vérifie si une personne a été authentifiée*/
            if(auth){
                ArrayList<String> row = DBL.getResult().get(0);
                Metier metier = Metier.valueOf(row.get(5));
                currentUser = new Professionnel(id,row.get(1),row.get(2),row.get(3),row.get(4),metier);
                /*récupère le personnel authetifié*/
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String date=dateFormat.format(new Date());
                DBL = new DataBaseLayer("INSERT INTO connections VALUES('"+date+"','"+id+"');");/*ajoute la connection à la base de données*/
                int m = DBL.getModification();
                ajoutTableConnections=(m>0);/*vrai si la modification a bien été effectuée*/
            }
    } 


    /**
     * @return the auth
     */
    public boolean isAuth() {
        return auth;
    }

    /**
     * @return the currentUser
     */
    public Professionnel getCurrentUser() {
        return currentUser;
    }

    /**
     * @return the ajoutTableConnections
     */
    public boolean isAjoutTableConnections() {
        return ajoutTableConnections;
    }
    
}
