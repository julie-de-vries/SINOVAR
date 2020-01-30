/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir;

import java.util.ArrayList;

public class SIR {

    private ArrayList<Patient> patients;
    private ArrayList<Professionnel> professionnel;
//    private Agenda agenda;

    public SIR() {
        patients = new ArrayList<>();
        professionnel = new ArrayList<Professionnel>();
    }

    public ArrayList<Patient> getPatient() {
        return this.patients;
    }

    public void ajouterPatient(Patient p) {
        this.patients.add(p);
    }

    public void ajouterProfessionnel(Professionnel p) {
        this.professionnel.add(p);
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

    public void chercherPatient(String nom, String prenom) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getNomUsuel().equals(nom) && patients.get(i).getPrenom().equals(prenom)) {
                patients.get(i).afficher();
            }
        }
    }

    public void chercherPatientId(int id_patient) {
        int i = 0;
        while (i != patients.size() && patients.get(i).getIdPatient() != id_patient) {
            i++;
        }
        if (i != patients.size()) {
            patients.get(i).afficher();
        }
    }

    public void afficherDmr(Patient p) {
        if (patients.contains(p)) {
            p.afficher();
            p.getDmr().afficherListeExamen();
        }
    }

    public void afficherListeProfessionnel() {
        for (int i = 0; i < professionnel.size(); i++) {
            professionnel.get(i).afficher();
            System.out.println("------------------");
        }
    }
}
