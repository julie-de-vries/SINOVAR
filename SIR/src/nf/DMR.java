/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.util.ArrayList;

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

    public void afficherListeExamen() {
        for (int i = 0; i < examens.size(); i++) {
            System.out.println("Examen " + examens.get(i).getIdExam() + " : \n");
            examens.get(i).afficherExam();
            System.out.println("---------------------------------------");
        }
    }

    //On trie tous les examens par date
    public void trierParDates() {
        //on copie la liste d'examen dans une nouvelle liste afin de ne rien supprimer dans la principale
        ArrayList<Examen> copieExam = new ArrayList<Examen>(examens);
        //tant que la liste créée n'est pas vide, on recommence
        while (!copieExam.isEmpty()) {
            int imin = 0;
            Examen e1 = copieExam.get(imin);
            for (int i = 1; i < copieExam.size(); i++) {
                Examen e2 = copieExam.get(i);
                //on compare les dates des 2 examens, si le résultat est positif, cela signifie que la date du 2 est anterieure a celle du premier donc on la recupere
                if (e1.getDate().substring(4, 8).compareTo(e2.getDate().substring(4, 8)) > 0) {
                    imin = i;
                    e1 = e2;
                } //si l'annee est la meme, on compare les mois
                else if (e1.getDate().substring(4, 8).compareTo(e2.getDate().substring(4, 8)) == 0 && e1.getDate().substring(2, 4).compareTo(e2.getDate().substring(2, 4)) > 0) {
                    imin = i;
                    e1 = e2;
                } //si l'annee est le mois sont les mêmes on compare les jours
                else if (e1.getDate().substring(4, 8).compareTo(e2.getDate().substring(4, 8)) == 0 && e1.getDate().substring(2, 4).compareTo(e2.getDate().substring(2, 4)) == 0
                        && e1.getDate().substring(0, 2).compareTo(e2.getDate().substring(0, 2)) > 0) {
                    imin = i;
                    e1 = e2;
                } //si la date est la même oncompare les heures
                else if (e1.getDate().compareTo(e2.getDate()) == 0 && e1.getHeureDebut().substring(0, 2).compareTo(e2.getHeureDebut().substring(0, 2)) > 0) {
                    imin = i;
                    e1 = e2;
                } //si la date est l'heure sont les mêmes, on compare les minutes
                else if (e1.getDate().compareTo(e2.getDate()) == 0 && e1.getHeureDebut().substring(0, 2).compareTo(e2.getHeureDebut().substring(0, 2)) == 0
                        && e1.getHeureDebut().substring(2, 4).compareTo(e2.getHeureDebut().substring(2, 4)) > 0) {
                    imin = i;
                    e1 = e2;
                }
            }
            //on affiche cet examen
            e1.afficherExam();
            System.out.println("---------------------");
            //on le supprime de la liste
            copieExam.remove(imin);
        }
    }

    public void trierParNom() {
        //creation d'une liste, copie de la liste examens
        ArrayList<Examen> copieExam = new ArrayList<>(examens);
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
            e1.afficherExam();
            System.out.println("------------------------");
            //on eneleve l'examen qu'on a affiche de la liste
            copieExam.remove(imin);
        }
    }

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
    public void chercherExam(Examen e) {
        if (this.examens.contains(e)) {
            e.afficherExam();
        }
    }

    public void chercherExamId(int idExam) {
        for (int i = 0; i < examens.size(); i++) {
            if (examens.get(i).getIdExam() == idExam) {
                examens.get(i).afficherExam();
            }
        }
    }

    public void afficherRapport(Examen e) {
        if (examens.contains(e)) {
            System.out.println(e.getRapport());
        }
        else {
            System.out.println("Cet examen n'est pas dans le dossier");
        }
    }

}
