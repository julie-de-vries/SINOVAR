/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir;

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
    public void afficherExam(Professionnel p) {
        ///verifie si le professionnel appartient a la liste des professionnels de l'hopital
        if (listePro.getListePro().contains(p)) {
            //affiche la liste de ses examens à faire
            p.afficherExamen();
        }
    }

    //affiche l'agenda d'un professionnel de sante
    public void afficherAgenda(Professionnel p, String jour) {
        ///verifie si le professionnel appartient a la liste des professionnels de l'hopital
        if (listePro.getListePro().contains(p)) {
            for (int i = 0; i < p.getExam().size(); i++) {
                //affiche la liste de ses examens à faire ce jour
                if (p.getExam().get(i).getDate().equals(jour)) {
                    //verification que 2 examens ne se chevauchent pas
                    String hd = p.getExam().get(i).getHeureDebut(); //heure de debut de l'examen
                    String hf =p.getExam().get(i).getHeureFin(); //heure de debut de l'examen
                    //on compare a toutes les valeurs d'examen
                    for (int j=0;j<p.getExam().size();j++){
                        //on compare les valeurs de debut et de fin
                        if(hf.compareTo(p.getExam().get(j).getHeureDebut())>0 && hd.compareTo(p.getExam().get(j).get)){
                            
                        }
                    }
                    p.getExam().get(i).afficherExam();
                }
                System.out.println("-----------------------");
            }
        }
    }

}
