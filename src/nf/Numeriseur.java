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
public enum Numeriseur {
    ACMED30X("C:\\Users\\Julie\\Downloads\\pgm\\pgm\\abdomen\\cor494-i43.pgm"),
    EPSONSCAN("C:\\Users\\Julie\\Downloads\\pgm\\pgm\\abdomen\\cor494-i43.pgm"),
    HPSMART("C:\\Users\\Julie\\Downloads\\pgm\\pgm\\abdomen\\cor494-i43.pgm"),
    CANON("C:\\Users\\Julie\\Downloads\\pgm\\pgm\\abdomen\\cor494-i43.pgm");
    private String adresse;
    
    Numeriseur(String adresse){
        this.adresse = adresse;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

}
