/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author laura
 */
public class Connexion {
   
    
    public Connexion() {
        initComponents();
    }
    
    private void initComponents(){
        //Initialisation des attributs
        JFrame fenetre = new JFrame();
        JPanel fenetre_indication = new JPanel();
        JLabel texte_indication = new JLabel();
        
        //Définit un titre pour la fenêtre
        fenetre.setTitle("Se connecter à SIR 1.0");
        
        //Créer la JPanel pour la couleur de fond
        fenetre.setBackground(new Color(247,250,253));
        
        //Définit sa taille
        //récuperer la dimension de l'écran
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        int longueur = tailleMoniteur.width * 2/3;
        int hauteur = tailleMoniteur.height * 2/3;
        //régler la taille de JFrame à 2/3 la taille de l'écran
        fenetre.setSize(longueur, hauteur);
        
        //Positionnement au centre de l'écran
        fenetre.setLocationRelativeTo(null);      
   
        //Termine le processus lorsqu'on clique sur la croix rouge
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        
        //Et enfin, la rendre visible        
        fenetre_indication.setVisible(true);        
        
        //Création de la JPanel pour le texte d'indication
        //texte_indication.setLayout(new FlowLayout());
        //Texte du JPanel par JLabel
        //texte_indication.setText("Le système d'information radiologique n'est accessible qu'aux Praticiens Hospitaliers, manipulateurs(trices) en électroradiologie médicale et secrétaires médicales");
        //ajout du label dans le panel
        //fenetre_indication.add(texte_indication);
        
        //fenetre.setContentPane(fenetre_indication);
    
        
       
    }
    
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Connexion().setVisible(true);
        });
    }      

    private void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

