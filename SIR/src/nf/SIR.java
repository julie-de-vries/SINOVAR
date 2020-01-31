/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir;

import java.util.ArrayList;

public class SIR {

    private ArrayList<Patient> patients;
    private Professionnels listePro;
//    private Agenda agenda;

    public SIR(Professionnels p) {
        patients = new ArrayList<>();
        this.listePro = p;
    }

    public ArrayList<Patient> getPatient() {
        return this.patients;
    }

    public void ajouterPatient(Patient p) {
        this.patients.add(p);
    }

    public void afficherListePatients() {
        for (int i = 0; i < patients.size(); i++) {
            System.out.println("Patient " + i + " \n");
            patients.get(i).afficher();
        }
    }

    public void afficherTout() {
        for (int i = 0; i < patients.size(); i++) {
            System.out.println("Patient " + patients.get(i).getNomUsuel() + " :\n");
            patients.get(i).afficher();
            System.out.println("");
            for (int j = 0; j < patients.get(i).getDmr().getExamen().size(); j++) {
                System.out.println("\tExamen " + patients.get(i).getDmr().getExamen().get(j).getIdExam() + " :\n");
                patients.get(i).getDmr().getExamen().get(j).afficherExam();
                System.out.println("");
            }
            System.out.println("--------------------");
        }
    }

    public void trierNomPatient() {
        ArrayList<Patient> copiePatient = new ArrayList<>(patients);
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
            p1.afficher();
            System.out.println("-----------------------");
            copiePatient.remove(imin);
        }
    }

    public void trierIdPatient() {
        ArrayList<Patient> copiePatient = new ArrayList<>(patients);
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
            p1.afficher();
            System.out.println("-----------------------");
            copiePatient.remove(imin);
        }
    }

    //cherche un patient selon son nom
    public void chercherPatient(String nom, String prenom) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getNomUsuel().equals(nom) && patients.get(i).getPrenom().equals(prenom)) {
                patients.get(i).afficher();
            }
        }
    }

    //cherche un patient selon son identifiant
    public void chercherPatientId(int id_patient) {
        int i = 0;
        while (i != patients.size() && patients.get(i).getIdPatient() != id_patient) {
            i++;
        }
        if (i != patients.size()) {
            patients.get(i).afficher();
        }
    }

    //cherche un professionnel en particulier grace a son nom
    public void chercherProfessionnel(String nom, String prenom) {
        for (int i = 0; i < listePro.getListePro().size(); i++) {
            if (listePro.getListePro().get(i).getNom().equals(nom) && listePro.getListePro().get(i).getPrenom().equals(prenom)) {
                listePro.getListePro().get(i).afficher();
            } else {
                System.out.println("This doctor doesn't exist in our data base");
            }
        }
    }

    //affiche le DMR d'un patient donne
    public void afficherDmr(Patient p) {
        if (patients.contains(p)) {
            p.afficher();
            p.getDmr().afficherListeExamen();
        }
    }

    //afficher la liste des professionnels
    public void afficherListeProfessionnel(){
        listePro.afficherListeProfessionnel();
    }
    
    //affiche la liste d'examen qu'un professionnel de sante doit faire
    public void afficherExamProfessionnel(Professionnel p){
        //parcourt la liste des patients
        for(int i=0;i<patients.size();i++){
            //pour chaque patient, parcourt la liste d'examen de son DMR
            for(int j=0;j<patients.get(i).getDmr().getExamen().size();j++){
                //si le professionnel de sante correspond
                if(patients.get(i).getDmr().getExamen().get(j).getNomPracticien().equals(p.getNom())){
                    //affiche l'examen en question
                    patients.get(i).getDmr().getExamen().get(j).afficherExam();
                    System.out.println("------------------------");
                }
            }
            
        }
    }
}
