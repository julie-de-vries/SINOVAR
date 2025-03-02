/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.util.ArrayList;
import java.util.Date;

public class DMR {

    private ArrayList<Examen> examens;

    public DMR() {
        examens = new ArrayList<Examen>();
    }

    public ArrayList<Examen> getExamen() {
        return this.examens;
    }

    public void ajouterExamen(Examen e) {
        examens.add(e);
    }
    
    

    /*public String afficherListeExamen() {
        String s="";
        for (int i = 0; i < examens.size(); i++) {
            s+="Examen " + examens.get(i).getIdExam() + " : \n";
            s+=examens.get(i).afficherExam();
            s+="---------------------------------------";
        }
        return s;
    }*/

    //On trie tous les examens par date
    /*public String trierParDates() {
        //on copie la liste d'examen dans une nouvelle liste afin de ne rien supprimer dans la principale
        ArrayList<Examen> copieExam = new ArrayList<Examen>(examens);
        String s="";
        //tant que la liste créée n'est pas vide, on recommence
        while (!copieExam.isEmpty()) {
            int imin = 0;
            Examen e1 = copieExam.get(imin);
            for (int i = 1; i < copieExam.size(); i++) {
                Examen e2 = copieExam.get(i);
                if(e1.getDateDebut().compareTo(e2.getDateDebut())>0){
                    imin = i;
                    e1=e2;
                }
            }
            //on affiche cet examen
            s+=e1.afficherExam();
            s+="---------------------";
            //on le supprime de la liste
            copieExam.remove(imin);
        }
        return s;
    }

    public String trierParNom() {
        //creation d'une liste, copie de la liste examens
        ArrayList<Examen> copieExam = new ArrayList<>(examens);
        String s="";
        //Tant que nous sommes pas a la fin de la liste
        while (!copieExam.isEmpty()) {
            int imin = 0;
            Examen e1 = copieExam.get(imin);
            for (int i = 1; i < copieExam.size(); i++) {
                Examen e2 = copieExam.get(i);
                //on compare les noms d'examen entre les 2 listes et si le 2eme es plus petit, alors on le recupere
                if (e1.getNomExamen().toUpperCase().compareTo(e2.getNomExamen().toUpperCase()) > 0) {
                    imin = i;
                    e1 = e2;
                }
            }
            //on affiche l'examen
            s+=e1.afficherExam();
            s+="------------------------";
            //on eneleve l'examen qu'on a affiche de la liste
            copieExam.remove(imin);
        }
        return s;
    }*/

    //trier par numero d'archivage
//    public void trierParNumArchivage() {
//        //creation d'une liste, copie de la liste examens
//        ArrayList<Examen> copieExam = new ArrayList<>(examens);
//        //Tant que nous sommes pas a la fin de la liste
//        while (!copieExam.isEmpty()) {
//            int imin = 0;
//            Examen e1 = copieExam.get(imin);
//            for (int i = 1; i < copieExam.size(); i++) {
//                Examen e2 = copieExam.get(i);
//                //on compare les noms d'examen entre les 2 listes et si le 2eme es plus petit, alors on le recupere
//                if (e1.getNumArchivage() > (e2.getNumArchivage())) {
//                    imin = i;
//                    e1 = e2;
//                }
//            }
//            //on affiche l'examen
//            e1.afficherExam();
//            System.out.println("------------------------");
//            //on eneleve l'examen qu'on a affiche de la liste
//            copieExam.remove(imin);
//        }
//    }
    public Examen chercherExam(Examen e) {
        Examen exam = null;
        if (this.examens.contains(e)) {
            exam=e;
        }
        return exam;
    }

    public Examen chercherExamId(int idExam) {
        Examen e=null;
        for (int i = 0; i < examens.size(); i++) {
            if (examens.get(i).getIdExam() == idExam) {
                e=examens.get(i);
            }
        }
        return e;
    }

}
