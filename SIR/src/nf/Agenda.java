/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.util.ArrayList;

/**
 *
 * @author Peuillon
 */
public class Agenda {

    //private final Patient patient;
    private final String jour;
    private final Professionnels listePro;

    public Agenda(Professionnels pro, String jour) {
//        this.heure = heure;
        this.jour = jour;
        this.listePro = pro;
    }

//    public Patient getPatient() {
//        return this.patient;
//    }
    public String getJour() {
        return this.jour;
    }

    public Professionnels getProfessionnels() {
        return listePro;
    }

    //affiche les examens d'un professionnel de sante
//    public void afficherExam(Professionnel p) {
//        ///verifie si le professionnel appartient a la liste des professionnels de l'hopital
//        if (listePro.getListePro().contains(p)) {
//            //affiche la liste de ses examens à faire
//            p.afficherExamen();
//        }
//    }
//
//    //affiche l'agenda d'un professionnel de sante
//    public void afficherAgenda(Professionnel p, String jour) {
//        ///verifie si le professionnel appartient a la liste des professionnels de l'hopital
//        if (listePro.getListePro().contains(p)) {
//            for (int i = 0; i < p.getExam().size(); i++) {
//                //affiche la liste de ses examens à faire ce jour
//                if (p.getExam().get(i).getDate().equals(jour)) {
//                    //verification que 2 examens ne se chevauchent pas
//                    String hd = p.getExam().get(i).getHeureDebut(); //heure de debut de l'examen
//                    String hf = p.getExam().get(i).getHeureFin(); //heure de debut de l'examen
//                    //on compare a toutes les valeurs d'examen
//                    for (int j = 0; j < p.getExam().size(); j++) {
//                        //on compare les valeurs de debut et de fin
//                        if(hf.compareTo(p.getExam().get(j).getHeureDebut())>0 && hd.compareTo(p.getExam().get(j).get)){
//
//                        }
//                    }
//                    p.getExam().get(i).afficherExam();
//                }
//                System.out.println("-----------------------");
//            }
//        }
//    }
    public void afficherAgenda(Professionnel p, String jour) {
        if (listePro.getListePro().contains(p)) {
            ArrayList<Examen> copieExam = new ArrayList<>(p.getExam());
            ArrayList<Examen> examVide = new ArrayList<>();
            //Tant que nous sommes pas a la fin de la liste
            while (!copieExam.isEmpty()) {
                int imin = 0;
                Examen e1 = copieExam.get(imin);
                for (int i = 1; i < copieExam.size(); i++) {
                    Examen e2 = copieExam.get(i);
                    //on compare les noms d'examen entre les 2 listes et si le 2eme es plus petit, alors on le recupere
                    if (e1.getHeureDebut().compareTo(e2.getHeureDebut()) > 0) {
                        imin = i;
                        e1 = e2;
                    }
                }
                //on ajoute l'examen a la liste vide
                examVide.add(e1);
                //on eneleve l'examen qu'on a affiche de la liste
                copieExam.remove(imin);
            }
            //on parcourt la liste remplie  pour vérifier que les heures de fin sont bien superieures aux heures de debut && que le jour correspond bien
            int i;
            for (i = 0; i < examVide.size() - 1; i++) {
                if (!examVide.get(i).getDate().equals(jour)) {
                    examVide.remove(i);
                    System.out.println("ErreurDate");
                }else{
                if (examVide.get(i).getHeureFin().compareTo(examVide.get(i).getHeureDebut()) < 0) {
                    examVide.remove(i);
                    System.out.println("Erreur1");
                }
                if (examVide.get(i).getHeureFin().compareTo(examVide.get(i + 1).getHeureDebut()) > 0) {
                    examVide.remove(i + 1);
                    System.out.println("Erreur2");
                }
                }
            }
            if (examVide.get(i).getHeureFin().compareTo(examVide.get(i).getHeureDebut()) < 0) {
                examVide.remove(i);
                System.out.println("Erreur");
            }

            System.out.println(examVide.size());
            for (i = 0; i < examVide.size(); i++) {

                examVide.get(i).afficherExam();
                System.out.println("-------------------------");

            }
        }
    }
}
