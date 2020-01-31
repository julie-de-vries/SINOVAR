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

    public String afficherListeProfessionnel() {
        String s="";
        for (int i = 0; i < listePro.size(); i++) {
            s+=listePro.get(i).afficher();
            s+="------------------";
        }
        return s;
    }
}
