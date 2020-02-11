/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import nf.Professionnel;

/**
 *
 * @author laura
 */
public class CreerDMR extends javax.swing.JFrame {
    Accueil a;
    int longueur = Toolkit.getDefaultToolkit().getScreenSize().width;
    int hauteur = Toolkit.getDefaultToolkit().getScreenSize().height;
    /**
     * Creates new form createDMR
     */
    public CreerDMR(Accueil a) {
//        //récuperer la dimension de l'écran
//        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
//        int longueur = tailleMoniteur.width;
//        int hauteur = tailleMoniteur.height;
        initComponents();
        this.a = a ;
        //régler la taille de JFrame à 2/3 la taille de l'écran
        this.setSize(longueur, hauteur);

        this.setTitle("Création d'un DMR");

        // set the jframe size and location, and make it visible
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
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

        SexeSelection = new javax.swing.ButtonGroup();
        box_panel = new javax.swing.JPanel();
        titre_panel = new javax.swing.JPanel();
        titre_label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Valider = new javax.swing.JButton();
        form_panel = new javax.swing.JPanel();
        nom_naiss_label = new javax.swing.JLabel();
        nom_usuel_label = new javax.swing.JLabel();
        nom_naiss_field = new javax.swing.JTextField();
        nom_usuel_field = new javax.swing.JTextField();
        prenom_label = new javax.swing.JLabel();
        id_label = new javax.swing.JLabel();
        prenom_field = new javax.swing.JTextField();
        nss_field = new javax.swing.JTextField();
        date_label = new javax.swing.JLabel();
        lieu_naiss_label = new javax.swing.JLabel();
        date_field = new javax.swing.JTextField();
        adresse_field = new javax.swing.JTextField();
        sexe_panel = new javax.swing.JPanel();
        genre_label = new javax.swing.JLabel();
        FemmeRadioButton = new javax.swing.JRadioButton();
        HommeRadioButton = new javax.swing.JRadioButton();
        lieu_naiss_label1 = new javax.swing.JLabel();
        tel_field = new javax.swing.JTextField();
        bouton_panel = new javax.swing.JPanel();
        Annuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        box_panel.setBackground(new java.awt.Color(204, 204, 204));
        box_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        titre_panel.setBackground(new java.awt.Color(185, 221, 227));
        titre_panel.setMinimumSize(new java.awt.Dimension(0, 0));
        titre_panel.setLayout(new java.awt.GridBagLayout());

        titre_label.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        titre_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titre_label.setText("CRÉER UN DOSSIER MÉDICAL RADIOLOGIQUE");
        titre_panel.add(titre_label, new java.awt.GridBagConstraints());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Veuillez renseigner les informations concernant le patient");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(29, 0, 73, 0);
        titre_panel.add(jLabel1, gridBagConstraints);

        Valider.setBackground(new java.awt.Color(117, 212, 129));
        Valider.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Valider.setText("VALIDER");
        Valider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ValiderMouseClicked(evt);
            }
        });
        titre_panel.add(Valider, new java.awt.GridBagConstraints());

        form_panel.setBackground(new java.awt.Color(185, 221, 227));
        form_panel.setMinimumSize(new java.awt.Dimension(0, 0));
        form_panel.setLayout(new java.awt.GridLayout(6, 2, 100, 10));

        nom_naiss_label.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        nom_naiss_label.setText("Nom de naissance");
        form_panel.add(nom_naiss_label);

        nom_usuel_label.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        nom_usuel_label.setText("Nom usuel");
        form_panel.add(nom_usuel_label);

        nom_naiss_field.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        nom_naiss_field.setPreferredSize(new java.awt.Dimension(80, 32));
        nom_naiss_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_naiss_fieldActionPerformed(evt);
            }
        });
        form_panel.add(nom_naiss_field);

        nom_usuel_field.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        form_panel.add(nom_usuel_field);

        prenom_label.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        prenom_label.setText("Prénom");
        form_panel.add(prenom_label);

        id_label.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        id_label.setText("Numéro de sécurité de sociale");
        form_panel.add(id_label);

        prenom_field.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        form_panel.add(prenom_field);

        nss_field.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        form_panel.add(nss_field);

        date_label.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        date_label.setText("Date de naissance (JJ/MM/AAAA)");
        form_panel.add(date_label);

        lieu_naiss_label.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lieu_naiss_label.setText("Adresse");
        form_panel.add(lieu_naiss_label);

        date_field.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        form_panel.add(date_field);

        adresse_field.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        form_panel.add(adresse_field);

        sexe_panel.setBackground(new java.awt.Color(185, 221, 227));
        sexe_panel.setMinimumSize(new java.awt.Dimension(0, 0));
        sexe_panel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 100, 50));

        genre_label.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        genre_label.setText("Genre :");
        sexe_panel.add(genre_label);

        SexeSelection.add(FemmeRadioButton);
        FemmeRadioButton.setText("Femme");
        sexe_panel.add(FemmeRadioButton);

        SexeSelection.add(HommeRadioButton);
        HommeRadioButton.setText("Homme");
        HommeRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HommeRadioButtonActionPerformed(evt);
            }
        });
        sexe_panel.add(HommeRadioButton);

        lieu_naiss_label1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lieu_naiss_label1.setText("Téléphone");
        sexe_panel.add(lieu_naiss_label1);

        tel_field.setMinimumSize(new java.awt.Dimension(150, 50));
        tel_field.setPreferredSize(new java.awt.Dimension(150, 50));
        sexe_panel.add(tel_field);

        bouton_panel.setBackground(new java.awt.Color(185, 221, 227));
        bouton_panel.setMinimumSize(new java.awt.Dimension(0, 0));
        bouton_panel.setLayout(new java.awt.GridBagLayout());

        Annuler.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Annuler.setText("ANNULER");
        Annuler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnnulerMouseClicked(evt);
            }
        });
        bouton_panel.add(Annuler, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout box_panelLayout = new javax.swing.GroupLayout(box_panel);
        box_panel.setLayout(box_panelLayout);
        box_panelLayout.setHorizontalGroup(
            box_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(box_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(box_panelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(box_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(form_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sexe_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bouton_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titre_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        box_panelLayout.setVerticalGroup(
            box_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(box_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(box_panelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(titre_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(form_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(144, 144, 144)
                    .addComponent(bouton_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(box_panel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nom_naiss_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_naiss_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_naiss_fieldActionPerformed

    private void ValiderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ValiderMouseClicked
        String champsVides = "";
        String champsTropLongs = "";
        String nomNaissance = nom_naiss_field.getText();
        if (nomNaissance.length() > 30) {
            champsTropLongs += "Le nom de naissance ne doit pas dépasser 30 caractères";
        }
        String nomUsuel = nom_usuel_field.getText();
        if (nomUsuel.isEmpty()) {
            champsVides += "\nNom usuel";
        }
        if (nomUsuel.length() > 30) {
            champsTropLongs += "Le nom usuel ne doit pas dépasser 30 caractères";
        }
        String prenom = prenom_field.getText();
        if (prenom.isEmpty()) {
            champsVides += "\nPrenom";
        }
        if (prenom.length() > 30){
            champsTropLongs += "Le prénom ne doit pas dépasser 30 caractères";
        }
        SimpleDateFormat formatFormulaire = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatBDD = new SimpleDateFormat("yyyy-MM-dd");
        String dateDeNaissance="";
        try {
            Date date=formatFormulaire.parse(date_field.getText());
            dateDeNaissance=formatBDD.format(date);
        } catch (ParseException ex) {
            Logger.getLogger(CreerDMR.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (dateDeNaissance.isEmpty()) {
            champsVides += "\nNom usuel";
        }
        String genre ;
        if(FemmeRadioButton.isSelected()){
        genre = "Femme";
        }
        else{
            genre = "Homme";
        }
        String nss = nss_field.getText();
        if (nss.isEmpty()) {
            champsVides += "\nNuméro de sécurité sociale";
        }
        if (nss.length() > 45) {
                champsTropLongs += "Le numéro ne doit pas dépasser 60 caractère";
            }
        String tel = tel_field.getText();
        if (tel.isEmpty()) {
            champsVides += "\nTéléphone";
        }
        if (tel.length() > 10) {
                champsTropLongs += "Le téléphone ne doit pas dépasser 10 caractère";
            }
        String adresse = adresse_field.getText();
        if (adresse.isEmpty()) {
            champsVides += "\nLieu de naissance";
        }
        if (adresse.length() > 60) {
                champsTropLongs += "L'adresse ne doit pas dépasser 60 caractère";
            }
        if (champsVides.equals("") && champsTropLongs.equals("")) {
            //récupere l'id patient a partir de la base de donnees
            boolean b = a.getSir().ajouterPatientBDD(nomNaissance, nomUsuel, prenom, nss, tel, adresse, dateDeNaissance, genre);
            if(b){
            Professionnel p = a.getCurrentUser();
            a.dispose();
            a = new Accueil(p);
            a.setVisible(true);
            this.dispose();
            }
            else{
                new Erreur("Le patient a déjà été rentré");
            }
        }
        else {
            champsVides="Les champs suivants n'ont pas été renseignés :"+champsVides;
            new Erreur(champsVides+"\n"+champsTropLongs).setVisible(true);
        }
    }//GEN-LAST:event_ValiderMouseClicked

    private void AnnulerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnnulerMouseClicked
        this.dispose();
    }//GEN-LAST:event_AnnulerMouseClicked

    private void HommeRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HommeRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HommeRadioButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CreerDMR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreerDMR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreerDMR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreerDMR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new CreerDMR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JRadioButton FemmeRadioButton;
    private javax.swing.JRadioButton HommeRadioButton;
    private javax.swing.ButtonGroup SexeSelection;
    private javax.swing.JButton Valider;
    private javax.swing.JTextField adresse_field;
    private javax.swing.JPanel bouton_panel;
    private javax.swing.JPanel box_panel;
    private javax.swing.JTextField date_field;
    private javax.swing.JLabel date_label;
    private javax.swing.JPanel form_panel;
    private javax.swing.JLabel genre_label;
    private javax.swing.JLabel id_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lieu_naiss_label;
    private javax.swing.JLabel lieu_naiss_label1;
    private javax.swing.JTextField nom_naiss_field;
    private javax.swing.JLabel nom_naiss_label;
    private javax.swing.JTextField nom_usuel_field;
    private javax.swing.JLabel nom_usuel_label;
    private javax.swing.JTextField nss_field;
    private javax.swing.JTextField prenom_field;
    private javax.swing.JLabel prenom_label;
    private javax.swing.JPanel sexe_panel;
    private javax.swing.JTextField tel_field;
    private javax.swing.JLabel titre_label;
    private javax.swing.JPanel titre_panel;
    // End of variables declaration//GEN-END:variables
}
