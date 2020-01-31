/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.util.ArrayList;

public class Professionnels {

    private ArrayList<Professionnel> listePro;

    public Professionnels() {
        listePro = new ArrayList<>();
    }

    public ArrayList<Professionnel> getListePro() {
        return this.listePro;
    }

    public void ajouterProfessionnel(Professionnel p) {
        listePro.add(p);
    }

    public void afficherListeProfessionnel() {
        for (int i = 0; i < listePro.size(); i++) {
            listePro.get(i).afficher();
            System.out.println("------------------");
        }
    }
}
