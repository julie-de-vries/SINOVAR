/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Peuillon
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        /*Patient p = new Patient("Tran", "Laura", 1, "23081998", "F", "199056908104853", "25 chemin des Combes");
        Patient p2 = new Patient("Pontille", "Thomas", 2, "26041965", "H", "199056908104853", "38 Rue des ponts");
        Patient p3 = new Patient("Decker", "Amandine", 3, "21091998", "F", "199056908104853", "1 rue Jules Valles");

        // creer des dateeeeeeeeeeeeeeeeees
        Metier metier1 = Metier.SecretairesMedicales;
        Metier metier3 = Metier.Manipulateurs;
        Metier metier4 = Metier.Practicien;

//        Agenda agenda1 = new Agenda()
        Professionnel pro1 = new Professionnel(1, "Deblouze", "Agathe", "cardio", "Cardiologie", metier4);
        Professionnel pro2 = new Professionnel(2, "Egee", "Yves", "respi", "Respiratoire", metier4);
        Professionnel pro3 = new Professionnel(3, "Cover", "Harry", "potter", "Digestif", metier3);
        Professionnel pro4 = new Professionnel(4, "Bole", "Pat", "patate", "urologie", metier4);
        Professionnel pro5 = new Professionnel(5, "Track", "Pat", "patate", "urologie", metier4);

        Professionnels listePro = new Professionnels();

        Date dateDebut1 = new Date(86, 03, 30, 12, 05);
        Date dateDebut2 = new Date(86, 03, 05, 16, 25);
        Date dateDebut3 = new Date(86, 03, 04, 15, 35);
        Date dateDebut4 = new Date(86, 03, 04, 16, 23);
        Date dateDebut5 = new Date(86, 03, 04, 21, 35);
        Date dateDebut6 = new Date(86, 03, 04, 12, 14);
        Date dateDebut7 = new Date(106, 04, 04, 12, 05);

        Date dateFin1 = new Date(86, 03, 04, 12, 30);
        Date dateFin2 = new Date(86, 03, 04, 16, 50);
        Date dateFin3 = new Date(86, 03, 04, 16, 25);
        Date dateFin4 = new Date(86, 03, 04, 16, 35);
        Date dateFin5 = new Date(86, 03, 04, 21, 45);
        Date dateFin6 = new Date(86, 03, 04, 12, 18);
        Date dateFin7 = new Date(106, 05, 30, 12, 05);

//        String date13 = "230120202135";
//        String date14 = "230120202226";
//        
//        sdf.setLenient(false);
        listePro.ajouterProfessionnel(pro1);
        listePro.ajouterProfessionnel(pro2);
        listePro.ajouterProfessionnel(pro3);
        listePro.ajouterProfessionnel(pro4);

        TypeExam te1 = TypeExam.AccelerateurParticule;
        TypeExam te2 = TypeExam.Angiographie;
        TypeExam te3 = TypeExam.Echoendoscope;
        TypeExam te4 = TypeExam.IRM;
        TypeExam te5 = TypeExam.Mammographe;
        TypeExam te6 = TypeExam.RadioArgentique;
        TypeExam te7 = TypeExam.Scanner;

        Examen exam1 = new Examen(1, "Tete particule", dateDebut1, dateFin1, te1, pro1, "g beso1 d'R");
        Examen exam2 = new Examen(2, "Angiographie des poumons", dateDebut2, dateFin2, te2, pro1, "astalista baby");
        Examen exam3 = new Examen(3, "Echographie", dateDebut3, dateFin3, te3, pro1, "RAS");
        Examen exam4 = new Examen(4, "IRM du cerveau", dateDebut4, dateFin4, te4, pro1, "");
        Examen exam5 = new Examen(5, "Cancer du sein", dateDebut5, dateFin5, te5, pro1, "My name is DRE");
        Examen exam6 = new Examen(6, "radio Argentique du foie", dateDebut6, dateFin6, te6, pro1, "");
//        
//        Examen exam7 = new Examen(7, "Radio de la clavicule", "230120202135", "230120202226", te7, "Egee", "Pas de luxation");
//        Examen exam8 = new Examen(6, "radio Argentique du foie", "030419591022", "030419591036", te6, "Egee", "");
//        Examen exam9 = new Examen(6, "radio Argentique du foie", "030419591035", "030419591100", te6, "Egee", "");
//        Examen exam10 = new Examen(6, "radio Argentique du foie", "030419591215", "030419591230", te6, "Egee", "");

        DMR dmr1 = new DMR();
        DMR dmr2 = new DMR();
        DMR dmr3 = new DMR();

        Agenda agenda = new Agenda(listePro);

        SIR sir = new SIR(listePro);

        p3.setNomNaissance("Tyran");

        sir.ajouterPatient(p);
        sir.ajouterPatient(p2);
        sir.ajouterPatient(p3);

        //sir.afficherListeProfessionnel();
        dmr1.ajouterExamen(exam1);
        dmr1.ajouterExamen(exam2);
        dmr1.ajouterExamen(exam3);
        dmr1.ajouterExamen(exam4);
        dmr2.ajouterExamen(exam5);
        dmr2.ajouterExamen(exam6);
//        System.out.println(dmr1.afficherListeExamen());
//        System.out.println("******************\n******************\n******************\n");
        System.out.println(dmr1.trierParDates());
//        dmr3.ajouterExamen(exam7);

        p.setDmr(dmr1);
        p2.setDmr(dmr2);
        pro1.ajouterExamen(exam1);
//        pro1.ajouterExamen(exam2);
//        pro1.ajouterExamen(exam3);
//        pro1.ajouterExamen(exam4);
//        pro1.ajouterExamen(exam5);
//        pro1.ajouterExamen(exam6);
//
//        pro2.ajouterExamen(exam7);
//        pro2.ajouterExamen(exam8);
//        pro2.ajouterExamen(exam9);
//        pro2.ajouterExamen(exam10);

        //pro1.afficherExamen();
        //listePro.afficherListeProfessionnel();
        //dmr1.afficherListeExamen();
        //sir.afficherListePatients();
        //sir.afficherTout();
        //dmr2.chercherExamId(2);
        //sir.chercherPatient("Mars","Bruno");
        //sir.afficherDmr(p2);
        exam1.setCode(Code.NUMERISATION);
        //dmr1.afficherRapport(exam7);
        //System.out.println(exam1.calculerCout());
        //sir.afficherExamProfessionnel(pro5);

//        agenda.afficherAgenda(pro1, "04041959");*/
    }

}
