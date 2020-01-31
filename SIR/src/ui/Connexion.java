/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author laura
 */
public class Connexion extends javax.swing.JFrame {

    /**
     * Creates new form Connexion
     */
    public Connexion() {
        initComponents();
        
        //récuperer la dimension de l'écran
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        int longueur = tailleMoniteur.width * 2/3;
        int hauteur = tailleMoniteur.height * 2/3;
        //régler la taille de JFrame à 2/3 la taille de l'écran
        this.setSize(longueur, hauteur);
        this.setLocationRelativeTo(null);
        
        this.setTitle("Se connecter au SIR 1.0");
        
        //Centrer le carré de texte
        texte_indicatif.setSize(longueur, hauteur);
        this.getContentPane().add(texte_indicatif, SwingConstants.CENTER);
        
        //Couleur de la Jpanel
        texte_indicatif.setBackground(new Color(241,184,185));
        
        texte_indicatif.add(texte1);
        texte_indicatif.add(texte2);
        
        texte1.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,30));
        texte2.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,30));
        
        texte1.setHorizontalAlignment(SwingConstants.CENTER);
        texte2.setHorizontalAlignment(SwingConstants.CENTER);
        
        texte_connexion.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,30));
        texte_id.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,30));
        texte_mdp.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,30));
        
        entree_mdp.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,30));
        entree_id.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,30));
//        //Centrer les textes d'indications
//                jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
//
//        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
//        
//        //Changer la police
//        jLabel1.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,30));
//        jLabel2.setFont(new java.awt.Font(Font.SANS_SERIF,Font.ITALIC,30));

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        texte_indicatif = new javax.swing.JPanel();
        texte1 = new javax.swing.JLabel();
        texte2 = new javax.swing.JLabel();
        texte_connexion = new javax.swing.JLabel();
        texte_id = new javax.swing.JLabel();
        entree_id = new javax.swing.JTextField();
        texte_mdp = new javax.swing.JLabel();
        entree_mdp = new javax.swing.JPasswordField();
        valider = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        texte1.setText("Le Système d'Information Radiologique n'est accessible qu'aux Praticiens Hospitaliers,");

        texte2.setText("manipulateurs(trices) en électroradiologie médicale et secrétaires médicales");

        texte_connexion.setText("Connexion");

        texte_id.setText("Identifiant");

        entree_id.setText("jTextField1");

        texte_mdp.setText("Mot de passe");

        entree_mdp.setText("jPasswordField1");
        entree_mdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entree_mdpActionPerformed(evt);
            }
        });

        valider.setText("Valider");

        javax.swing.GroupLayout texte_indicatifLayout = new javax.swing.GroupLayout(texte_indicatif);
        texte_indicatif.setLayout(texte_indicatifLayout);
        texte_indicatifLayout.setHorizontalGroup(
            texte_indicatifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(texte_indicatifLayout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(texte1, javax.swing.GroupLayout.DEFAULT_SIZE, 1301, Short.MAX_VALUE)
                .addGap(337, 337, 337))
            .addGroup(texte_indicatifLayout.createSequentialGroup()
                .addGroup(texte_indicatifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(texte_indicatifLayout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(texte2))
                    .addGroup(texte_indicatifLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(texte_connexion))
                    .addGroup(texte_indicatifLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(texte_id)
                        .addGap(197, 197, 197)
                        .addComponent(entree_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(texte_indicatifLayout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(texte_mdp)
                        .addGap(161, 161, 161)
                        .addComponent(entree_mdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(texte_indicatifLayout.createSequentialGroup()
                        .addGap(812, 812, 812)
                        .addComponent(valider)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        texte_indicatifLayout.setVerticalGroup(
            texte_indicatifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(texte_indicatifLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(texte1)
                .addGap(29, 29, 29)
                .addComponent(texte2)
                .addGap(140, 140, 140)
                .addComponent(texte_connexion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addGroup(texte_indicatifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texte_id)
                    .addComponent(entree_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(texte_indicatifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texte_mdp)
                    .addComponent(entree_mdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112)
                .addComponent(valider)
                .addGap(123, 123, 123))
        );

        valider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                validerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(texte_indicatif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(texte_indicatif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entree_mdpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entree_mdpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entree_mdpActionPerformed

    private void validerMouseClicked(java.awt.event.MouseEvent evt) {                                         
        String id = entree_id.getText();
        String mdp=String.valueOf(entree_mdp.getPassword());
        //Identifications c = new Identifications(id, mdp);       
        
        System.out.println(id);
        System.out.println(mdp);
        if((id.equals("1"))&&(mdp.equals("ab"))){
//            Test t = new Test();            
//            t.setVisible(true);     
//            this.remove(jPanel1);
            
            this.remove(jPanel1);
            //jPanel1.setVisible(false);
            Test te = new Test();
            this.add(te);
            te.setVisible(true);
            
            this.repaint();
            
            
            
//            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//                getContentPane().setLayout(layout);
//                layout.setHorizontalGroup(
//                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                .addComponent(t, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
//                );
//                layout.setVerticalGroup(
//                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                .addComponent(t, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
//                );
            
        }  else{
                JOptionPane.showMessageDialog(null, "Identifiant/Mot de passe incorrect(s)");
        
    }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Connexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField entree_id;
    private javax.swing.JPasswordField entree_mdp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel texte1;
    private javax.swing.JLabel texte2;
    private javax.swing.JLabel texte_connexion;
    private javax.swing.JLabel texte_id;
    private javax.swing.JPanel texte_indicatif;
    private javax.swing.JLabel texte_mdp;
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables
}
