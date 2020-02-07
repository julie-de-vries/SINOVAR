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
    private final TypeExam type;
    private final Professionnel pro;
    private final int id_exam;
    private final LocalisationExamen localisation_examen;
    private double dose;
    private String libelleDose;
    private final Code code;
    private final int salle;
    private String notes;
    private String image;
    private String cr;

    public Examen(int id_exam, Date dateDebut, Date dateFin, TypeExam type, Professionnel pro, Code code, int salle, LocalisationExamen localisation_examen) {
        this.id_exam = id_exam;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.type = type;
        this.pro = pro; 
        this.salle = salle;
        this.code = code;
        this.localisation_examen = localisation_examen;
        image = null;
        cr = null;
    }

    

    public Date getDateDebut() {
        return this.dateDebut;
    }

    public Date getDateFin() {
        return this.dateFin;
    }

    public Professionnel getPro() {
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
        return this.getLibelleDose();
    }

    public void setLibelle(String libelle) {
        this.setLibelleDose(libelle);
    }

    public String getNomExamen(){
        return type + " " +localisation_examen;
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
        return type+" "+localisation_examen+", "+getPatient(sir).getNomUsuel();
    }
    
    public String afficherDose() {
        String s = "";
        s += this.getLibelle();
        s += "\n" + this.getDose();
        return s;
    }
    
    public int[] calculTrancheHoraire(){
        int duree = dateToTH(getDateFin())-dateToTH(getDateDebut());
        int[] TH=new int[duree];
        for(int i=0 ; i<duree ; i++){
            TH[i]=dateToTH(getDateDebut())+i;
        }
        return TH;
    }
    
    public int dateToTH(Date d){
        return d.getHours()*2+Math.round(d.getMinutes()/30);
    }
    

    public int calculerCout() {
        return getCode().coutExam();
    }
    
    public Patient getPatient(SIR sir){
        Patient p=null;
        /*on récupère le patient grâce à l'id de l'examen*/
        int i = 0;
        int j = 0;
        boolean stop = false;
        while (i<sir.getPatient().size()&&(!stop)){
            while (j<sir.getPatient().get(i).getDmr().getExamen().size()&&(!stop)){
                if(sir.getPatient().get(i).getDmr().getExamen().get(j).getIdExam()==getId_exam()){
                    p=sir.getPatient().get(i);
                    stop = true;
                }
            }
        i++;
        }
        return p;
    }
    

    /**
     * @return the salle
     */
    public int getSalle() {
        return salle;
    }

    /**
     * @return the type
     */
    public TypeExam getType() {
        return type;
    }
    
    /**
     * @return the id_exam
     */
    public int getId_exam() {
        return id_exam;
    }


    /**
     * @return the libelleDose
     */
    public String getLibelleDose() {
        return libelleDose;
    }

    /**
     * @param libelleDose the libelleDose to set
     */
    public void setLibelleDose(String libelleDose) {
        this.libelleDose = libelleDose;
    }

    /**
     * @return the code
     */
    public Code getCode() {
        return code;
    }

    /**
     * @return the facture
     */
    public String getFacture() {
        String facture="";
        return facture;
    }


    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the cr
     */
    public String getCr() {
        return cr;
    }

    /**
     * @param cr the cr to set
     */
    public void setCr(String cr) {
        this.cr = cr;
    }

    
    

}
