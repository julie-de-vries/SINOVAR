/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ui.Accueil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import nf.Code;
import nf.DataBaseLayer;
import nf.Examen;
import nf.LocalisationExamen;
import nf.Metier;
import nf.Patient;
import nf.Professionnel;
import nf.Professionnels;
import nf.SIR;
import nf.TypeExam;

/**
 *
 * @author Julie
 */
public class Controleur {
    /**
     * @param args the command line arguments
     */
    
    Professionnel currentUser;
    
    public static void main(String[] args) {
        //new Connexion().setVisible(true);
        
        
    }
    public SIR chargeSIR(){
        DataBaseLayer DBL = new DataBaseLayer("SELECT * from sinovar.personnel;");
        Professionnels pros = new Professionnels();
        for (int i = 1; i < DBL.getResult().size(); i++) {
            ArrayList<String> row = DBL.getResult().get(i);
            Metier m = Metier.valueOf(row.get(4));
            Professionnel p = new Professionnel(row.get(0), row.get(1), row.get(2), row.get(3),m, row.get(5), row.get(6),row.get(7));
            pros.ajouterProfessionnel(p);
        }
        /*récupération du personnel de la BDD*/
        SIR sir = new SIR(pros);
        DBL = new DataBaseLayer("SELECT * from database_sinovar.patient join sinovar.examen on id=identifiant_patient;");
        ArrayList<String> row=null;
        for (int i = 1; i < DBL.getResult().size(); i++) {
            row = DBL.getResult().get(i);
            int id = Integer.parseInt(row.get(0));
            Patient p = new Patient(id,row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6),row.get(7),row.get(8));
            DataBaseLayer DBL1 = new DataBaseLayer("SELECT * from database_sinovar.examen where identifiant_patient="+id+";");
            for (int j = 1 ; j < DBL1.getResult().size() ; j++){
                row = DBL1.getResult().get(j);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date d1 = format.parse(row.get(4));
                    Date d2 = format.parse(row.get(5));
                    Professionnel pro = sir.chercherProfessionnel(row.get(9));
                    Examen e = new Examen(Integer.parseInt(row.get(0)), TypeExam.valueOf(row.get(1)),LocalisationExamen.valueOf(row.get(2)),row.get(3), d1, d2, Integer.parseInt(row.get(6)),Double.parseDouble(row.get(7)),row.get(8),pro,Integer.parseInt(row.get(10)),Code.valueOf(row.get(11)),Integer.parseInt(row.get(12)) );
                    //en commentaire tant qu'il n'y a pas accord sur Examen (bdd, ui et nf)
                    /*d1 = new Date(120,01,05,8,30);
                    d2 = new Date(120,01,05,9,0);
                    Examen e = new Examen(1,"examen de ta mère",d1,d2,TypeExam.IRM,this.currentUser,"");*/
                    p.getDmr().ajouterExamen(e);
                } catch (ParseException ex) {
                    Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            sir.ajouterPatient(p);
        }   
        return sir;
    }
    
    public void identifications(String ids, String password){
        int id =Integer.parseInt(ids);
        DataBaseLayer DBL = new DataBaseLayer("SELECT * FROM database_sinovar.personnel WHERE id ="+id+" AND motDePasse='"+password+"';");
        ArrayList<ArrayList<String>> result=DBL.getResult();
            result.remove(0);
            boolean auth = !result.isEmpty(); /*vérifie si une personne a été authentifiée*/
            if(auth){
                ArrayList<String> row = DBL.getResult().get(0);
                Metier metier = Metier.valueOf(row.get(4));
                currentUser = new Professionnel(row.get(0),row.get(1),row.get(2),row.get(3),metier, row.get(5), row.get(6),row.get(7));
                /*récupère le personnel authetifié*/
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String date=dateFormat.format(new Date());
                DBL = new DataBaseLayer("INSERT INTO database_connexions VALUES('"+date+"','"+id+"');");/*ajoute la connection à la base de données*/
            }
    } 
    
    public void ajouterCR(int idExam,String title, String content) {
        DataBaseLayer DBL = new DataBaseLayer("Insert into database_sinovar.compte_rendu(titre,contenu) values('"+title+"','"+content+"');"); 
        DBL = new DataBaseLayer("SELECT id_compte_rendu FROM compte_rendu ORDER BY id_compte_rendu DESC;");
        String id_cr = DBL.getResult().get(0).get(0);
        DBL = new DataBaseLayer("UPDATE examen SET `id_compte_rendu` ="+id_cr+" WHERE `id_examen`="+idExam+";");
    }
}
