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
public class Professionnel {

    private final int id_pro;
    private final String nom;
    private final String prenom;
    private final String motDePasse;
    private final String departement;
    private final Metier metier;
    private ArrayList<Examen> exam;

    public Professionnel(int id, String nom, String prenom, String motDePasse, String departement, Metier metier) {
        this.id_pro = id;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.departement = departement;
        this.metier = metier;
        this.exam = new ArrayList<>();
    }

    public int getId_pro() {
        return id_pro;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getDepartement() {
        return this.departement;
    }

    public Metier getMetier() {
        return this.metier;
    }
    
    public ArrayList<Examen> getExam(){
        return this.exam;
    }

    public String afficher() {
        String s = "";
        s += this.prenom + " " + this.nom + "\n" + this.metier + "\n" + this.departement;
        return s;
    }

    //ajouter un examen dans la liste d'un professionnel
    public void ajouterExamen(Examen e) {
        if (this.nom.equals(e.getNomPracticien())) {
            this.exam.add(e);
        } else {
            System.out.println("ce n'est pas le bon medecin");
        }
    }
    //affiche la liste d'examen que le practicien doit faire

    public String afficherExamen() {
        String s="";
        for(int i=0;i<exam.size();i++){
            s+=exam.get(i).afficherExam();
        }
        return s;
    }

}
