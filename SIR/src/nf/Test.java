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
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Patient p = new Patient("Tran", "Laura", 1, "28021999", "F", "199056908104853", "25 chemin des Combes");
        Patient p2 = new Patient("Pontille", "Thomas", 2, "26041965", "H", "199056908104853", "38 Rue des ponts");
        Patient p3 = new Patient("Decker", "Amandine", 3, "21091998", "F", "199056908104853", "1 rue Jules Valles");

        Metier metier1 = Metier.SecretairesMedicales;
        Metier metier3 = Metier.Manipulateurs;
        Metier metier4 = Metier.Practicien;

//        Agenda agenda1 = new Agenda()
        
        
        
        Professionnel pro1 = new Professionnel(1, "Deblouze", "Agathe", "cardio", "Cardiologie", metier3);
        Professionnel pro2 = new Professionnel(2, "Egee", "Yves", "respi", "Respiratoire", metier4);
        Professionnel pro3 = new Professionnel(3, "Cover", "Harry", "potter", "Digestif", metier3);
        Professionnel pro4 = new Professionnel(4, "Bole", "Pat", "patate", "urologie", metier4);
        Professionnel pro5 = new Professionnel(5, "Track", "Pat", "patate", "urologie", metier4);
        
        Professionnels listePro = new Professionnels();
        
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

        Examen exam1 = new Examen(1, "Tete particule", "03041959", "10h58","11h05", te1, "Deblouze", "g beso1 d'R");
        Examen exam2 = new Examen(2, "Angiographie des poumons", "03041959", "10h56","12h00", te2, "Egee", "astalista baby");
        Examen exam3 = new Examen(3, "Echographie", "05062012", "15h35","16h05", te3, "Cover", "RAS");
        Examen exam4 = new Examen(4, "IRM du cerveau", "15052003", "16h13","16h45", te4, "Bole", "");
        Examen exam5 = new Examen(5, "Cancer du sein", "03041959", "11h00","17h03", te5, "Deblouze", "My name is DRE");
        Examen exam6 = new Examen(6, "radio Argentique du foie", "11032013", "12h14","12h45", te6, "Egee", "");
        Examen exam7 = new Examen(7, "Scanner de la clavicule", "23012020", "21h35","22h26", te7, "Etudiante numero4", "Pas de luxation");

        DMR dmr1 = new DMR();
        DMR dmr2 = new DMR();
        DMR dmr3 = new DMR();

        Agenda agenda = new Agenda(listePro,"03041959");
        
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
        dmr3.ajouterExamen(exam7);
        
        p.setDmr(dmr1);
        p2.setDmr(dmr2);
        pro1.ajouterExamen(exam1);
        pro1.ajouterExamen(exam5);
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

        agenda.afficherAgenda(pro1,"03041959");
    }

}
