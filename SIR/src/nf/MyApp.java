/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Julie
 */

public class MyApp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Text connection
        /*Identifications id = new Identifications("Laura","123");
        if (id.isAuth()){
            System.out.println(id.getName());
        }
        else {
            System.out.println("niqueTaMère");
        }
        */
        //Test traitement d'image
        /*ImageProcessing img = new ImageProcessing("C:\\Users\\Julie\\Downloads\\pgm\\pgm\\abdomen\\cor494-i43.pgm");
        System.out.println(img.getImg());
        */
        //System.out.println(Metier.valueOf("Practicien"));
        /*Test Tableau des examens*/
        Date d1=new Date(2020,02,05,8,30);
        Date d2=new Date(2020,02,05,9,30);
        Examen e1 = new Examen(1,"Radiographie thoracique",d1,d2,TypeExam.IRM,"Peuillon","");
        
        
    }

}
