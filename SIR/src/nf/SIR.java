/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

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

    public String afficherListePatients() {
        String s = "";
        for (int i = 0; i < patients.size(); i++) {
            s += "Patient " + i + " \n";
            s += patients.get(i).afficher();
        }
        return s;
    }

    public String afficherTout() {
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
    }

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
    public Patient chercherPatient(String nom, String prenom) {
        Patient p = null;
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getNomUsuel().equals(nom) && patients.get(i).getPrenom().equals(prenom)) {
                p = patients.get(i);
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

    //affiche le DMR d'un patient donne
    public String afficherDmr(Patient p) {
        String s="";
        if (patients.contains(p)) {
            s+=p.afficher();
            s+=p.getDmr().afficherListeExamen();
        }
        return s;
    }

    //afficher la liste des professionnels
    public String afficherListeProfessionnel() {
        String s="";
        s+=listePro.afficherListeProfessionnel();
        return s;
    }

    //affiche la liste d'examen qu'un professionnel de sante doit faire
    public String afficherExamProfessionnel(Professionnel p) {
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
    }
}
