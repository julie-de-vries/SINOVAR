/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.util.Date;

public class Examen {

    private final Date dateDebut;
    private final Date dateFin;
    private final TypeExam appareil;
    private Professionnel pro;
    private String rapport;
    private final String nomExam;
    private final int id_exam;
    private double dose;
    private String libelleDose;
    private Code code;
    private int salle=1;

    public Examen(int id_exam, String nomExam, Date dateDebut, Date dateFin, TypeExam appareil, Professionnel pro, String rapport) {
        this.id_exam = id_exam;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.appareil = appareil;
        this.pro = pro; //a changer avec les bases de données
        this.rapport = rapport;
        this.dose = 0;
        this.nomExam = nomExam;
        this.code = Code.ENREGISTREMENT;
    }

    

    public Date getDateDebut() {
        return this.dateDebut;
    }

    public Date getDateFin() {
        return this.dateFin;
    }


    public TypeExam getAppareil() {
        return this.appareil;
    }

    public String getRapport() {
        return this.rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    public void setPracticien(Professionnel ph) {
        this.pro = ph;
    }

    public String getNomExamen() {
        return this.nomExam;
    }

    public Professionnel getNomPracticien() {
        return this.pro;
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

    public void setCode(Code code) {
        this.code = code;
    }

    /*public String afficherExam() {
        String s = "";
//        s += "\t" + this.getDateDebut().substring(4, 8) + "-" + this.getDateDebut().substring(2, 4) + "-" + this.getDateDebut().substring(0, 2); //ajout de la date au bon format
//        s += "-" + this.getDateDebut().substring(8, 10) + "-" + this.getDateDebut().substring(10, 12);//ajout de l'heure
//        s += "  " + this.getDateFin().substring(8, 10) + "-" + this.getDateFin().substring(10, 12);//ajout heure de fin
//        Integer.parseInt(s);
        s+= getDateDebut() + "\n";
        s+= getDateFin();

        s += "\n\tNumero de l'examen : " + this.id_exam;
        s += "\n\tNom de l'examen : " + this.nomExam;
        s += "\n\tAppareil utilisé : " + this.appareil;
        s += "\n\tNom du Practicien : " + this.pro;
        s += "\n\tCompte rendu : " + this.rapport + "\n";
        return s;
    }*/
    
    public String afficherExamen(SIR sir){
        return nomExam+"\n"+getPatient(sir);
    }

    public String afficherDose() {
        String s = "";
        s += this.getLibelle();
        s += "\n" + this.getDose();
        return s;
    }
    
    public int[] calculTrancheHoraire(){
        int duree = dateToTH(dateFin)-dateToTH(dateDebut);
        int[] TH=new int[duree];
        for(int i=0 ; i<duree ; i++){
            TH[i]=dateToTH(dateDebut)+i;
        }
        return TH;
    }
    
    public int dateToTH(Date d){
        return d.getHours()*2+Math.round(d.getMinutes()/30);
    }
    

    public int calculerCout() {
        return code.coutExam();
    }
    
    public Patient getPatient(SIR sir){
        Patient p=null;
        /*on récupère le patient grâce à l'id de l'examen*/
        int i = 0;
        int j = 0;
        boolean stop = false;
        while (i<sir.getPatient().size()||(!stop)){
            while (j<sir.getPatient().get(i).getDmr().getExamen().size()||(!stop)){
                if(sir.getPatient().get(i).getDmr().getExamen().get(j).getIdExam()==id_exam){
                    p=sir.getPatient().get(i);
                    stop = true;
                }
            }
        i++;
        }
        return p;
    }
    
    public int getSalle(){
        return salle;
    }

    /**
     * @return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

}
