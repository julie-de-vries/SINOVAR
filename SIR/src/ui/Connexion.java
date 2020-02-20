/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import nf.Identifications;

/**
 *
 * @author Julie
 */
public class Connexion extends javax.swing.JFrame {
    private Controler controler;
    /**
     * Creates new form Connexion
     */
    public Connexion(Controler controler) {
        this.controler= controler;
        initComponents();
        //récuperer la dimension de l'écran
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        int longueur = tailleMoniteur.width*2/3;
        int hauteur = tailleMoniteur.height*2/3;
        System.out.println(longueur);
        System.out.println(hauteur);
        //régler la taille de JFrame à 2/3 la taille de l'écran
        this.setSize(longueur, hauteur);
        this.setTitle("Se connecter au SIR 1.0");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //this.setResizable(false);

        int longueur1 = longueur*2/3;
        int hauteur1 = hauteur*1/3;
        
        message_panel.setPreferredSize(new Dimension(longueur1, hauteur1));
        System.out.println(longueur1);
        connexion_panel.setPreferredSize(new Dimension(longueur1, hauteur1));
        System.out.println(hauteur1);
        deco_panel.setPreferredSize(new Dimension(longueur1, hauteur1));
        
        
    }
    public Connexion() {
        initComponents();
        //récuperer la dimension de l'écran
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        int longueur = tailleMoniteur.width*2/3;
        int hauteur = tailleMoniteur.height*2/3;
        System.out.println(longueur);
        System.out.println(hauteur);
        //régler la taille de JFrame à 2/3 la taille de l'écran
        this.setSize(longueur, hauteur);
        this.setTitle("Se connecter au SIR 1.0");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //this.setResizable(false);

        int longueur1 = longueur*2/3;
        int hauteur1 = hauteur*1/3;
        
        message_panel.setPreferredSize(new Dimension(longueur1, hauteur1));
        System.out.println(longueur1);
        connexion_panel.setPreferredSize(new Dimension(longueur1, hauteur1));
        System.out.println(hauteur1);
        deco_panel.setPreferredSize(new Dimension(longueur1, hauteur1));
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        connexion_panel = new javax.swing.JPanel();
        sepa_1 = new javax.swing.JPanel();
        seconnecter_panel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        mdp = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollBar1 = new javax.swing.JScrollBar();
        sepa_2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        logo1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        message_panel = new javax.swing.JPanel();
        texte_panel = new javax.swing.JPanel();
        text1_label = new javax.swing.JLabel();
        text2_label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        deco_panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(247, 250, 253));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        connexion_panel.setBackground(new java.awt.Color(247, 250, 253));
        connexion_panel.setLayout(new javax.swing.BoxLayout(connexion_panel, javax.swing.BoxLayout.LINE_AXIS));

        sepa_1.setBackground(new java.awt.Color(247, 250, 253));
        sepa_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        connexion_panel.add(sepa_1);

        seconnecter_panel.setBackground(new java.awt.Color(217, 217, 217));
        seconnecter_panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        seconnecter_panel.setMinimumSize(new java.awt.Dimension(8, 373));
        seconnecter_panel.setName(""); // NOI18N
        seconnecter_panel.setPreferredSize(new java.awt.Dimension(200, 373));
        seconnecter_panel.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setText("CONNEXION");
        seconnecter_panel.add(jLabel6, new java.awt.GridBagConstraints());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setText("Identifiant :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 50);
        seconnecter_panel.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setText("Mot de passe :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 50);
        seconnecter_panel.add(jLabel5, gridBagConstraints);

        id.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        id.setMinimumSize(new java.awt.Dimension(200, 40));
        id.setPreferredSize(new java.awt.Dimension(600, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        seconnecter_panel.add(id, gridBagConstraints);

        mdp.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        mdp.setMinimumSize(new java.awt.Dimension(200, 40));
        mdp.setPreferredSize(new java.awt.Dimension(600, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        seconnecter_panel.add(mdp, gridBagConstraints);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jButton2.setText("Se connecter");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        seconnecter_panel.add(jButton2, gridBagConstraints);

        connexion_panel.add(seconnecter_panel);

        jScrollPane1.setViewportView(jScrollBar1);

        connexion_panel.add(jScrollPane1);

        sepa_2.setBackground(new java.awt.Color(247, 250, 253));
        sepa_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        connexion_panel.add(sepa_2);

        getContentPane().add(connexion_panel);

        jPanel2.setBackground(new java.awt.Color(247, 250, 253));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(247, 250, 253));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1547, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1);

        logo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/Copie de SINOVAR.png"))); // NOI18N
        jPanel2.add(logo1);

        jPanel3.setBackground(new java.awt.Color(247, 250, 253));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3);

        getContentPane().add(jPanel2);

        message_panel.setBackground(new java.awt.Color(247, 250, 253));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 100, 50);
        flowLayout1.setAlignOnBaseline(true);
        message_panel.setLayout(flowLayout1);

        texte_panel.setBackground(new java.awt.Color(241, 184, 185));
        texte_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        texte_panel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        texte_panel.setMaximumSize(new java.awt.Dimension(1203, 138));
        texte_panel.setName(""); // NOI18N
        texte_panel.setNextFocusableComponent(logo1);
        texte_panel.setLayout(new java.awt.GridBagLayout());

        text1_label.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        text1_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text1_label.setText("Le Systeme d'Information Radiologique ");
        text1_label.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 0);
        texte_panel.add(text1_label, gridBagConstraints);

        text2_label.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        text2_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text2_label.setText("manipulateurs(trices) en électroradiologie médicale");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 55, 10, 55);
        texte_panel.add(text2_label, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel1.setText("n'est accessible qu'aux Praticiens Hospitaliers,");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        texte_panel.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel2.setText(" et secrétaires médicales");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        texte_panel.add(jLabel2, gridBagConstraints);

        message_panel.add(texte_panel);

        getContentPane().add(message_panel);

        deco_panel.setBackground(new java.awt.Color(247, 250, 253));
        deco_panel.setLayout(new javax.swing.BoxLayout(deco_panel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setBackground(new java.awt.Color(247, 250, 253));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/Connexion_SINOVAR.png"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(30000, 296));
        deco_panel.add(jLabel3);

        getContentPane().add(deco_panel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        String id = this.id.getText();
        String mdp = String.valueOf(this.mdp.getPassword());
        boolean auth = controler.identifications(id, mdp);
        
        if(auth){
            this.dispose();
            controler.launchHomePage();
        } else {             
            JOptionPane.showMessageDialog(null, "Identifiant/Mot de passe incorrect(s)");
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        String id = this.id.getText();
        String mdp = String.valueOf(this.mdp.getPassword());
        boolean auth = controler.identifications(id, mdp);
        
        if(auth){
            this.dispose();
            controler.launchHomePage();
        } else {             
            JOptionPane.showMessageDialog(null, "Identifiant/Mot de passe incorrect(s)");
        }
        }
    }//GEN-LAST:event_jButton2KeyPressed

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
    private javax.swing.JPanel connexion_panel;
    private javax.swing.JPanel deco_panel;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo1;
    private javax.swing.JPasswordField mdp;
    private javax.swing.JPanel message_panel;
    private javax.swing.JPanel seconnecter_panel;
    private javax.swing.JPanel sepa_1;
    private javax.swing.JPanel sepa_2;
    private javax.swing.JLabel text1_label;
    private javax.swing.JLabel text2_label;
    private javax.swing.JPanel texte_panel;
    // End of variables declaration//GEN-END:variables
}
