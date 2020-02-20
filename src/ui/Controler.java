/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import nf.Code;
import nf.DataBaseLayer;
import nf.Examen;
import nf.LocalisationExamen;
import nf.Metier;
import nf.Patient;
import nf.Professionnel;
import nf.Professionnels;
import nf.SIR;
import nf.TypeExam;

/**
 *
 * @author Julie
 */
public class Controler {

    /**
     * @param args the command line arguments
     *
     * @param sir : le sir actuel
     *
     * @param currentUser : utilisateur actuel connecté au logiciel
     */
    private SIR sir;
    private Professionnel currentUser;
    private Accueil accueil;
    private Patient currentPatient;
    private Examen currentExam;
    private boolean forcing=false;
    public Controler(){
    }
    
    public static void main(String[] args) {
        Controler controler = new Controler();
        new Connexion(controler).setVisible(true);
    }
    public void launchHomePage(){
        chargeSIR();
        accueil = new Accueil(this);
        accueil.setVisible(true);
    }
    public void chargeSIR() {
        DataBaseLayer DBL = new DataBaseLayer("SELECT * from database_sinovar.personnel;");
        Professionnels pros = new Professionnels();
        ArrayList<String> row = null;
        for (int i = 1; i < DBL.getResult().size(); i++) {
            row = DBL.getResult().get(i);
            Metier m = Metier.valueOf(row.get(4));
            Professionnel p = new Professionnel(row.get(0), row.get(1), row.get(2), row.get(3), m, row.get(5), row.get(6), row.get(7));
            pros.ajouterProfessionnel(p);
        }
        /*récupération du personnel de la BDD*/
        sir = new SIR(pros);
        DBL = new DataBaseLayer("SELECT * from database_sinovar.patient;");
        for (int i = 1; i < DBL.getResult().size(); i++) {
            row = DBL.getResult().get(i);
            int id = Integer.parseInt(row.get(0));
            Patient p = new Patient(id, row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6), row.get(7), row.get(8));
            sir.ajouterPatient(p);
        }
    }

    public void chargeDMR() {
        int id = currentPatient.getIdPatient();
        nf.DMR dmr = new nf.DMR();
        DataBaseLayer DBL1 = new DataBaseLayer("SELECT * from database_sinovar.examen where identifiant_patient=" + id + ";");
        for (int j = 1; j < DBL1.getResult().size(); j++) {
            ArrayList<String> row = DBL1.getResult().get(j);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date d1 = format.parse(row.get(4));
                Date d2 = format.parse(row.get(5));
                Professionnel pro = getSir().chercherProfessionnel(row.get(10));
                int idIm;
                if(row.get(11)!=null){
                    idIm=Integer.parseInt(row.get(11));
                }
                else{
                    idIm=0;
                }
                int idCR;
                if(row.get(13)!=null){
                    idCR=Integer.parseInt(row.get(13));
                }
                else{
                    idCR=0;
                }
                Examen e = new Examen(Integer.parseInt(row.get(0)), TypeExam.valueOf(row.get(1)), LocalisationExamen.valueOf(row.get(2)), row.get(3), d1, d2, Integer.parseInt(row.get(6)), Double.parseDouble(row.get(7)), row.get(8), pro, idIm, Code.valueOf(row.get(12)), idCR);
                dmr.ajouterExamen(e);
            } catch (ParseException ex) {
                Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        currentPatient.setDmr(dmr);
    }

    public boolean identifications(String id, String password) {
        DataBaseLayer DBL = new DataBaseLayer("SELECT * FROM database_sinovar.personnel WHERE identifiant_personnel =" + id + " AND mdp_personnel='" + password + "';");
        ArrayList<ArrayList<String>> result = DBL.getResult();
        result.remove(0);
        boolean auth = !result.isEmpty();
        /*vérifie si une personne a été authentifiée*/
        if (auth) {
            ArrayList<String> row = DBL.getResult().get(0);
            Metier metier = Metier.valueOf(row.get(4));
            setCurrentUser(new Professionnel(row.get(0), row.get(1), row.get(2), row.get(3), metier, row.get(5), row.get(6), row.get(7)));
            /*récupère le personnel authetifié pour adapter le logiciel à l'utilisateur*/
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String date = dateFormat.format(new Date());
            DBL = new DataBaseLayer("INSERT INTO database_sinovar.connexions VALUES('" + id + "','" + date + "');");/*ajoute la connexion à la base de données*/
            //launchHomePage();
        }
        return auth;
    }

    public void ajouterCRBDD(String title, String content) {
        int idExam = currentExam.getIdExam();
        DataBaseLayer DBL = new DataBaseLayer("Insert into database_sinovar.compte_rendu(titre,contenu) values('" + title + "','" + content + "');");
        DBL = new DataBaseLayer("SELECT id_compte_rendu FROM compte_rendu ORDER BY id_compte_rendu DESC;");
        String id_cr = DBL.getResult().get(1).get(0);
        DBL = new DataBaseLayer("UPDATE examen SET `id_compte_rendu` =" + id_cr + " WHERE `id_examen`=" + idExam + ";");
    }

    public boolean ajouterPatientBDD(String nomNaissance, String nomUsuel, String prenom, String nss, String tel, String adresse, String dateDeNaissance, String genre) {
        boolean doublon = false;
        DataBaseLayer DBL = new DataBaseLayer("Select * from database_sinovar.patient where nom_usuel_patient= '" + nomUsuel + "' and prenom = '" + prenom + "' and dateDeNaissance = '" + dateDeNaissance + "';");
        ArrayList<ArrayList<String>> patient = DBL.getResult();
        DBL.getResult().remove(0);
        if (forcing||DBL.getResult().isEmpty()) {
            DBL = new DataBaseLayer("Insert into database_sinovar.patient(nom_naissance_patient,nom_usuel_patient,prenom_patient,numero_SS,adresse,tel_patient,date_de_naissance,genre) values('" + nomNaissance + "','" + nomUsuel + "','" + prenom + "','" + nss + "','" + tel + "','" + adresse + "','" + dateDeNaissance + "','" + genre + "');");
            forcing=false;
        } else {
            doublon = true;
            String strPatient = patient.get(0).get(0) + " : " + patient.get(1).get(0);
            for (int i = 0; i < patient.get(0).size(); i++) {
                strPatient += " " + patient.get(0).get(i) + " : " + patient.get(1).get(i);
            }
            new Erreur("Le patient existe déjà :\n" + strPatient).setVisible(true);
        }
        return doublon;
    }
    
    public void ajouterExamBDD(TypeExam type, LocalisationExamen localisation_examen,String notes, String dateDebut, String dateFin, int salle, double dose, String libelleDose,int id_patient, Professionnel pro, Code code) {
        DataBaseLayer DBL = new DataBaseLayer("Insert into database_sinovar.examen(type_examen,localisation_examen,note_examen,date_debut,date_fin,salle,dose_examen,libelle_dose,identifiant_patient,identifiant_personnel,numero_archivage,code_cout,id_compte_rendu) values('"+type.toString()+"','"+localisation_examen+"','"+notes+"','"+dateDebut+"','"+dateFin+"','"+salle+"','"+dose+"','"+libelleDose+"','"+id_patient+"','"+pro.getId_pro()+"',null,'"+code.toString()+"',null);"); 
    }
    public void logOut() {
        accueil.dispose();
        new Connexion().setVisible(true);
    }
    public void CloseDMR() {
        accueil.CloseDMR();
    }
    public void refreshDMR(){
        chargeDMR();
        accueil.getDmr().initTable();
        accueil.repaint();
    }
    public void refreshAccueil(){
        chargeSIR();
    }
    /**
     * @return the sir
     */
    public SIR getSir() {
        return sir;
    }

    /**
     * @return the currentUser
     */
    public Professionnel getCurrentUser() {
        return currentUser;
    }

    /**
     * @param sir the sir to set
     */
    public void setSir(SIR sir) {
        this.sir = sir;
    }

    /**
     * @param currentUser the currentUser to set
     */
    public void setCurrentUser(Professionnel currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * @return the accueil
     */
    public Accueil getAccueil() {
        return accueil;
    }

    /**
     * @param accueil the accueil to set
     */
    public void setAccueil(Accueil accueil) {
        this.accueil = accueil;
    }

    /**
     * @return the currentPatient
     */
    public Patient getCurrentPatient() {
        return currentPatient;
    }

    /**
     * @param currentPatient the currentPatient to set
     */
    public void setCurrentPatient(Patient currentPatient) {
        this.currentPatient = currentPatient;
    }

    /**
     * @return the currentExam
     */
    public Examen getCurrentExam() {
        return currentExam;
    }

    /**
     * @param currentExam the currentExam to set
     */
    public void setCurrentExam(Examen currentExam) {
        this.currentExam = currentExam;
    }

    /**
     * @param forcing the forcing to set
     */
    public void setForcing(boolean forcing) {
        this.forcing = forcing;
    }
    
    public BufferedImage getImage(){
        int idImage = currentExam.getImage();
        DataBaseLayer DBL = new DataBaseLayer("SELECT image FROM database_sinovar.pacs WHERE numero_archivage ="+idImage+";","blob");
        return DBL.getBuffImg();
    }
}
