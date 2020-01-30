/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir;

public class Examen {

    private String date;
    private String heure;
    private final TypeExam appareil;
    private String nomPracticien;
    private String rapport;
    private final String nomExam;
    private final int id_exam;
    private double dose;
    private String libelleDose;
    private Code code;

    public Examen(int id_exam, String nomExam, String date, String heure, TypeExam appareil, String nomPracticien, String rapport) {
        this.id_exam = id_exam;
        this.date = date;
        this.heure = heure;
        this.appareil = appareil;
        this.nomPracticien = nomPracticien; //a changer avec les bases de données
        this.rapport = rapport;
        this.dose = 0;
        this.nomExam = nomExam;
        this.code = Code.ENREGISTREMENT;
    }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public TypeExam getAppareil() {
        return this.appareil;
    }
    
    public String getRapport(){
        return this.rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    public void setPracticien(String ph) {
        this.nomPracticien = ph;
    }

    public String getNomExamen(){
        return this.nomExam;
    }
    
    public String getNomPracticien(){
        return this.nomPracticien;
    }
    
    public int getIdExam() {
        return this.id_exam;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public double getDose() {
        return this.dose;
    }

    public String getLibelle() {
        return this.libelleDose;
    }

    public void setLibelle(String libelle) {
        this.libelleDose = libelle;
    }
    
    public void setCode(Code code){
        this.code = code;
    }

    public void afficherExam() {
        String s = "";
        s += "\t"+this.getDate().substring(4, 8) + "-" + this.getDate().substring(2, 4) + "-" + this.getDate().substring(0, 2); //ajout de la date au bon format
        s += "-" + this.getHeure().substring(0, 2) + "-" + this.getHeure().substring(3, 5); //ajout de l'heure
        s += "\n\tNumero de l'examen : " + this.id_exam;
        s += "\n\tNom de l'examen : " + this.nomExam;
        s += "\n\tAppareil utilisé : " + this.appareil;
        s += "\n\tNom du Practicien : " + this.nomPracticien;
        s += "\n\tCompte rendu : " + this.rapport;
        System.out.println(s);
    }

    public void afficherDose() {
        String s = "";
        s += this.getLibelle();
        s += "\n" + this.getDose();
        System.out.println(s);
    }
    
    public int calculerCout(){
        return code.coutExam();
    }
    
}
