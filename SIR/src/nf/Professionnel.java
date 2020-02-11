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

    public Professionnel(int id, String nom, String prenom, String motDePasse, String departement, Metier metier) {
        this.id_pro = id;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.departement = departement;
        this.metier = metier;
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

    public String afficher() {
        String s = "";
        s += this.prenom + " " + this.nom + "\n" + this.metier + "\n" + this.departement;
        return s;
    }
    
    /*retourne les examens
    si c'est une secrétaire on met tous les examens du jour
    si c'est un PH on met ses examens*/
    public ArrayList<Examen> getExam(SIR sir){
        ArrayList<Examen> exam = new ArrayList();
        if(metier==Metier.secrétaire){
            for(int i=0 ; i<sir.getPatient().size(); i++){
                for(int j=0 ; j<sir.getPatient().get(i).getDmr().getExamen().size() ; j++){
                    exam.add(sir.getPatient().get(i).getDmr().getExamen().get(j));
                }
            }
        }
        else{
            for(int i=0 ; i<sir.getPatient().size(); i++){
                for(int j=0 ; j<sir.getPatient().get(i).getDmr().getExamen().size() ; j++){
                    if(sir.getPatient().get(i).getDmr().getExamen().get(j).getPro().getId_pro()==id_pro)
                        exam.add(sir.getPatient().get(i).getDmr().getExamen().get(j));
                }
            }
        }
        return exam;
    }
    //affiche la liste d'examen que le practicien doit faire

    /*public String afficherExamen() {
        String s="";
        for(int i=0;i<exam.size();i++){
            s+=exam.get(i).afficherExam();
        }
        return s;
    }*/

}
