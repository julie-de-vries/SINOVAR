/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

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
    private Agenda agenda;

    public Professionnel(int id, String nom, String prenom, String motDePasse, String departement, Metier metier) {
        this.id_pro = id;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.departement = departement;
        this.metier = metier;
        this.agenda=agenda;
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

    public void afficher() {
        String s = "";
        s += this.prenom + " " + this.nom + "\n" + this.metier + "\n" + this.departement;
        System.out.println(s);
    }
}
