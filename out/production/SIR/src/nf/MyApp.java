/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Julie
 */

public class MyApp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ca part en prod");
        /*Identifications id = new Identifications("Laura","123");
        if (id.isAuth()){
            System.out.println(id.getName());
        }
        else {
            System.out.println("niqueTaMère");
        }*/
        DataBaseLayer DBL = new DataBaseLayer("SELECT * FROM sinovar.utilisateur;");

    }

}
