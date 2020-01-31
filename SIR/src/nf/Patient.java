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
public class Patient {

    private final String nomUsuel;
    private String nomNaissance;
    private final String prenom;
    private String dateDeNaissance;
    private final String genre;
    private final int id_patient;
    private final String lieuDeNaissance;
    private DMR dmr;
    private String nss;
    //private final int id_patient;
//Ajouter un lien vers le PACS
    
    public Patient(String nom, String prenom, int id_patient, String dateDeNaissance, String genre, String nss, String adresse) {
        this.nomUsuel = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.genre = genre;
        if ("H".equals(genre)) {
            this.nomNaissance = this.nomUsuel;
        } else {
            this.nomNaissance = "";
        }
        this.id_patient = id_patient;
        this.nss=nss;
        dmr = new DMR();
        this.lieuDeNaissance = adresse;
    }

    public void afficher() {
        String s = "";
        s += this.getPrenom() + " " + this.getNomUsuel() + "\n" + this.getGenre() + "\nDate de Naissance : " + this.getDateDeNaissance() + "\nLieu de Naissance : "
                + this.getLieuDeNaissance() + "\nNumero de Securite Sociale : " + this.getNss();
        if (!this.getNomNaissance().equals("") && !this.getNomNaissance().equals(this.getNomUsuel())) {
            s += "\nNom De Naissance : " + this.getNomNaissance();
        }
        s += "\n--------------------";
        System.out.println(s);
    }

    public String getNomUsuel() {
        return nomUsuel;
    }

    public String getNomNaissance() {
        return this.nomNaissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public int getIdPatient() {
        return id_patient;
    }

    public String getNss() {
        return this.nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getGenre() {
        return genre;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getLieuDeNaissance() {
        return this.lieuDeNaissance;
    }

    public void setNomNaissance(String nom) {
        this.nomNaissance = nom;
    }

    public DMR getDmr() {
        return dmr;
    }

    public void setDmr(DMR dmr) {
        this.dmr = dmr;
    }

    public boolean nssValide() { //verifie si le numero de Securite Sociale est valide ou non
        if (nss.length() != 15) {
            System.out.println("Erreur : Numero de Securite Sociale Invalide, pas le bon nombre de caracteres");
            return false;
        }
        int i = 0;
        boolean eV = true;
        long deb = Long.parseLong(nss.substring(0, 13));

        while (i < 13 && eV == true) {
            if (nss.length() != 15) {
                eV = false;
            } else {
                if (Integer.parseInt(nss.substring(0, 1)) == 1 || Integer.parseInt(nss.substring(0, 1)) == 2) {
                    i++;
                } else {
                    System.out.println("Erreur, Genre");
                    eV = false;
                }
                if (Integer.parseInt(nss.substring(1, 3)) >= 0 && Integer.parseInt(nss.substring(1, 3)) <= 99) {
                    i += 2;
                } else {
                    System.out.println("Erreur, Année de naissance");
                    eV = false;
                }
                if (Integer.parseInt(nss.substring(3, 5)) >= 1 && Integer.parseInt(nss.substring(3, 5)) <= 12) {
                    i += 2;
                } else {
                    System.out.println("Erreur, Mois de naissance");
                    eV = false;
                }
                if (Integer.parseInt(nss.substring(5, 7)) >= 1 && Integer.parseInt(nss.substring(5, 7)) <= 98) {
                    i += 2;
                } else {
                    System.out.println("Erreur, Departement");
                    eV = false;
                }
                if (Integer.parseInt(nss.substring(7, 10)) >= 1 && Integer.parseInt(nss.substring(7, 10)) <= 999) {
                    i += 3;
                } else {
                    System.out.println("Erreur, Numero de commune");
                    eV = false;
                }
                if (Integer.parseInt(nss.substring(10, 13)) >= 1 && Integer.parseInt(nss.substring(10, 13)) <= 999) {
                    i += 3;
                } else {
                    System.out.println("Erreur, Numero de naissance");
                    eV = false;
                }
            }
        }
        long fin = Integer.parseInt(nss.substring(13, 15));
        if (97 - deb % 97 != fin) {
            System.out.println("Erreur clé");
            eV = false;
        }
        System.out.println(eV);
        return eV;
    }

    public boolean estDateValide() { //Verifie si la date entrée est valide ou non
        boolean eV;
        if (Integer.parseInt(dateDeNaissance.substring(2, 4)) == 1 || Integer.parseInt(dateDeNaissance.substring(2, 4)) == 3 || Integer.parseInt(dateDeNaissance.substring(2, 4)) == 5
                || Integer.parseInt(dateDeNaissance.substring(2, 4)) == 7 || Integer.parseInt(dateDeNaissance.substring(2, 4)) == 8 || Integer.parseInt(dateDeNaissance.substring(2, 4)) == 10
                || Integer.parseInt(dateDeNaissance.substring(2, 4)) == 12) {
            eV = Integer.parseInt(dateDeNaissance.substring(0, 2)) > 00 && Integer.parseInt(dateDeNaissance.substring(0, 2)) < 32;
        } else if (Integer.parseInt(dateDeNaissance.substring(2, 4)) == 4 || Integer.parseInt(dateDeNaissance.substring(2, 4)) == 6 || Integer.parseInt(dateDeNaissance.substring(2, 4)) == 9
                || Integer.parseInt(dateDeNaissance.substring(2, 4)) == 11) {
            eV = Integer.parseInt(dateDeNaissance.substring(0, 2)) > 0 && Integer.parseInt(dateDeNaissance.substring(0, 2)) < 31;
        } else if ((Integer.parseInt(dateDeNaissance.substring(2, 4)) == 2 && Integer.parseInt(dateDeNaissance.substring(4, 8)) % 4 == 0) && (Integer.parseInt(dateDeNaissance.substring(0, 2)) > 0
                && Integer.parseInt(dateDeNaissance.substring(0, 2)) < 30)) {
            eV = true;
        } else {
            eV = (Integer.parseInt(dateDeNaissance.substring(2, 4)) == 2 && Integer.parseInt(dateDeNaissance.substring(4, 8)) % 4 != 0) && (Integer.parseInt(dateDeNaissance.substring(0, 2)) > 0
                    && Integer.parseInt(dateDeNaissance.substring(0, 2)) < 29);
        }
        return eV;
    }

    public void affichageDate() { //affiche la date de Naissance au format JJ/MM/AAAA
        String s;
        if (estDateValide()) {
            s = dateDeNaissance.substring(0, 2);
            s += "/";
            s += dateDeNaissance.substring(2, 4);
            s += "/";
            s += dateDeNaissance.substring(4, 8);
        } else {
            s = "Erreur";
        }
        System.out.println(s);
    }
}
