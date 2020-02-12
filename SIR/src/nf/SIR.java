/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.util.ArrayList;
import java.util.Date;

public class SIR {

    private ArrayList<Patient> patients;
    private Professionnels listePro;

    public SIR(Professionnels p) {
        patients = new ArrayList<>();
        this.listePro = p;
    }

    public ArrayList<Patient> getPatient() {
        return this.patients;
    }

    public boolean ajouterPatientBDD(String nomNaissance,String nomUsuel, String prenom,String nss,String tel, String adresse,  String dateDeNaissance, String genre) {
        DataBaseLayer DBL = new DataBaseLayer("Select * from database_sinovar.patient where numero_SS= '"+nss+"';");
        DBL.getResult().remove(0);
        boolean modif=false;
        if(DBL.getResult().isEmpty()){
            DBL = new DataBaseLayer("Insert into database_sinovar.patient(nom_naissance_patient,nom_usuel_patient,prenom_patient,numero_SS,adresse,tel_patient,date_de_naissance,genre) values('"+nomNaissance+"','"+nomUsuel+"','"+prenom+"','"+nss+"','"+tel+"','"+adresse+"','"+dateDeNaissance+"','"+genre+"');");
            modif=true;
        }
        
        return modif;
        
    }
    
    public void ajouterExamBDD(TypeExam type, LocalisationExamen localisation_examen,String notes, String dateDebut, String dateFin, int salle, double dose, String libelleDose,int id_patient, Professionnel pro, Code code) {
        DataBaseLayer DBL = new DataBaseLayer("Insert into database_sinovar.examen(type_examen,localisation_examen,note_examen,date_debut,date_fin,salle,dose_examen,libelle_dose,identifiant_patient,identifiant_personnel,numero_archivage,code_cout,id_compte_rendu) values('"+type.toString()+"','"+localisation_examen+"','"+notes+"','"+dateDebut+"','"+dateFin+"','"+salle+"','"+dose+"','"+libelleDose+"','"+id_patient+"','"+pro.getId_pro()+"',null,'"+code.toString()+"',null);"); 
    }
    
    public void ajouterCR(int idExam,String title, String content) {
        DataBaseLayer DBL = new DataBaseLayer("Insert into database_sinovar.compte_rendu(titre,contenu) values('"+title+"','"+content+"');"); 
        DBL = new DataBaseLayer("SELECT id_compte_rendu FROM compte_rendu ORDER BY id_compte_rendu DESC;");
        String id_cr = DBL.getResult().get(1).get(0);
        DBL = new DataBaseLayer("UPDATE examen SET `id_compte_rendu` ="+id_cr+" WHERE `id_examen`="+idExam+";");
    }
    
    public void ajouterPatient(Patient p){
        patients.add(p);
    }

    public String afficherListePatients() {
        String s = "";
        for (int i = 0; i < patients.size(); i++) {
            s += "Patient " + i + " \n";
            s += patients.get(i).afficher();
        }
        return s;
    }

    /*public String afficherTout() {
        String s = "";
        for (int i = 0; i < patients.size(); i++) {
            s += "Patient " + patients.get(i).getNomUsuel() + " :\n";
            s += patients.get(i).afficher();
            s += "\n";
            for (int j = 0; j < patients.get(i).getDmr().getExamen().size(); j++) {
                s += "\tExamen " + patients.get(i).getDmr().getExamen().get(j).getIdExam() + " :\n";
                s += patients.get(i).getDmr().getExamen().get(j).afficherExam();
                s += "\n";
            }
            s += "--------------------";
        }
        return s;
    }*/

    public String trierNomPatient() {
        ArrayList<Patient> copiePatient = new ArrayList<>(patients);
        String s = "";
        while (!copiePatient.isEmpty()) {
            int imin = 0;
            Patient p1 = copiePatient.get(imin);
            for (int i = 0; i < copiePatient.size(); i++) {
                Patient p2 = copiePatient.get(i);
                if (p1.getNomUsuel().compareTo(p2.getNomUsuel()) > 0) {
                    imin = i;
                    p1 = p2;
                }
            }
            s += p1.afficher();
            s += "-----------------------";
            copiePatient.remove(imin);
        }
        return s;
    }

    public String trierIdPatient() {
        ArrayList<Patient> copiePatient = new ArrayList<>(patients);
        String s = "";
        while (!copiePatient.isEmpty()) {
            int imin = 0;
            Patient p1 = copiePatient.get(imin);
            for (int i = 0; i < copiePatient.size(); i++) {
                Patient p2 = copiePatient.get(i);
                if (p1.getIdPatient() > (p2.getIdPatient())) {
                    imin = i;
                    p1 = p2;
                }
            }
            s += p1.afficher();
            s += "-----------------------";
            copiePatient.remove(imin);
        }
        return s;
    }

    //cherche un patient selon son nom
    public ArrayList<Patient> chercherPatient(String recherche) {
        ArrayList<Patient> p=new ArrayList();
        for (int i = 0; i < patients.size(); i++) {
            if ((patients.get(i).getNomUsuel()+patients.get(i).getPrenom()).toLowerCase().contains(recherche.trim().toLowerCase())) {
                p.add(patients.get(i));
            }
        }
        return p;
    }

    //cherche un patient selon son identifiant
    public Patient chercherPatientId(int id_patient) {
        Patient p = null;
        int i = 0;
        while (i != patients.size() && patients.get(i).getIdPatient() != id_patient) {
            i++;
        }
        if (i != patients.size()) {
            p = patients.get(i);
        }
        return p;
    }

    //cherche un professionnel en particulier grace a son nom
    public Professionnel chercherProfessionnel(String nom, String prenom) {
        Professionnel p = null;
        for (int i = 0; i < listePro.getListePro().size(); i++) {
            if (listePro.getListePro().get(i).getNom().equals(nom) && listePro.getListePro().get(i).getPrenom().equals(prenom)) {
                p = listePro.getListePro().get(i);
            }
        }
        return p;
    }
//cherche un professionnel en particulier grace a son id
    public Professionnel chercherProfessionnel(String id) {
        Professionnel p = null;
        int i=0;
        boolean stop=false;
        while( i < listePro.getListePro().size()&&(!stop)) {
            
            if (listePro.getListePro().get(i).getId_pro().equals(id)) {
                p = listePro.getListePro().get(i);
                stop=true;
            }
            i++;
        }
        return p;
    }
    //affiche le DMR d'un patient donne
    /*public String afficherDmr(Patient p) {
        String s="";
        if (patients.contains(p)) {
            s+=p.afficher();
            s+=p.getDmr().afficherListeExamen();
        }
        return s;
    }*/

    //afficher la liste des professionnels
    public String afficherListeProfessionnel() {
        String s="";
        s+=listePro.afficherListeProfessionnel();
        return s;
    }

    //affiche la liste d'examen qu'un professionnel de sante doit faire
    /*public String afficherExamProfessionnel(Professionnel p) {
        String s="";
        //parcourt la liste des patients
        for (int i = 0; i < patients.size(); i++) {
            //pour chaque patient, parcourt la liste d'examen de son DMR
            for (int j = 0; j < patients.get(i).getDmr().getExamen().size(); j++) {
                //si le professionnel de sante correspond
                if (patients.get(i).getDmr().getExamen().get(j).getNomPracticien().equals(p.getNom())) {
                    //affiche l'examen en question
                    s+=patients.get(i).getDmr().getExamen().get(j).afficherExam();
                    s+="------------------------";
                }
            }

        }
        return s;
    }*/
}
