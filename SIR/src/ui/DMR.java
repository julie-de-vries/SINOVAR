/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ui.Accueil;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import nf.*;

/**
 *
 * @author Julie
 */
public class DMR extends javax.swing.JPanel {

    private Patient patient;
    private Accueil a;
    private nf.DMR dmr;

    /**
     * Creates new form DMR
     */
    public DMR(Patient patient, Accueil a) {
        this.patient = patient;
        this.a = a;
        initComponents();
        idLabel.setText(String.valueOf(patient.getIdPatient()));
        nameLabel.setText(patient.getNomUsuel());
        firstNameLabel.setText(patient.getPrenom());
        nssLabel.setText(patient.getNss());
        DDNLabel.setText(patient.getDateDeNaissance());
        GenderLabel.setText(patient.getGenre());
        dmr = patient.getDmr();
        int nbExam = dmr.getExamen().size();
        /*création et remplissage du tableau*/
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nom");
        model.addColumn("Date");
        model.addColumn("Numéro");
        model.addColumn("Image");
        model.addColumn("CR");
        model.addColumn("Facture");
        model.setRowCount(nbExam);
        ExamTable.setModel(model);
        ImageIcon pdfIcon = new ImageIcon("pdf.png");
        ImageIcon imageIcon = new ImageIcon("image.png");
        ImageIcon numeriserIcon = new ImageIcon("numeriser.png");
        ImageIcon nouveauIcon = new ImageIcon("nouveau.png");
        /*remplit les lignes du tableau jusqu'à ce que la liste soit finie*/
        for (int i = 0; i < nbExam; i++) {
            ExamTable.setValueAt(dmr.getExamen().get(i).getNomExamen(), i, 0);
            ExamTable.setValueAt(dmr.getExamen().get(i).getDateDebut(), i, 1);
            ExamTable.setValueAt(dmr.getExamen().get(i).getIdExam(), i, 2);
            //mettre des icônes à la place des String
            if (dmr.getExamen().get(i).getImage() != 0) {
                ExamTable.setValueAt(imageIcon, i, 3);
            } else {
                ExamTable.setValueAt(numeriserIcon, i, 3);
            }
            if (dmr.getExamen().get(i).getCr() != 0) {
                ExamTable.setValueAt(pdfIcon, i, 4);
            } else {
                ExamTable.setValueAt(nouveauIcon, i, 4);
            }
            ExamTable.setValueAt(pdfIcon, i, 5);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        nssLabel = new javax.swing.JLabel();
        DDNLabel = new javax.swing.JLabel();
        GenderLabel = new javax.swing.JLabel();
        CloseDMR = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ExamTable = new javax.swing.JTable();
        SaveExamButton = new javax.swing.JButton();
        SortChoice = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        SearchExamField = new javax.swing.JTextField();
        SearchExamButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(615, 345));
        setPreferredSize(new java.awt.Dimension(615, 345));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setMinimumSize(new java.awt.Dimension(615, 120));
        jPanel1.setPreferredSize(new java.awt.Dimension(615, 120));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("DMR PATIENT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 80, -1));

        jLabel2.setText("Identifiant :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel3.setText("Nom :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel4.setText("Prénom :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel5.setText("N°SS :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, -1, -1));

        jLabel6.setText("DDN :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        jLabel7.setText("Genre :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        idLabel.setText("idLabel");
        jPanel1.add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        nameLabel.setText("nameLabel");
        jPanel1.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        firstNameLabel.setText("firstNameLabel");
        jPanel1.add(firstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        nssLabel.setText("nssLabel");
        jPanel1.add(nssLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, -1));

        DDNLabel.setText("DDNLabel");
        jPanel1.add(DDNLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        GenderLabel.setText("GenderLabel");
        jPanel1.add(GenderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        CloseDMR.setText("fermer");
        CloseDMR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseDMRMouseClicked(evt);
            }
        });
        jPanel1.add(CloseDMR, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));

        jPanel2.setMinimumSize(new java.awt.Dimension(615, 225));
        jPanel2.setPreferredSize(new java.awt.Dimension(615, 225));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nom", "Date", "Numéro", "Image", "CR", "Facture"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ExamTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExamTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ExamTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 570, 120));

        SaveExamButton.setText("Enregistrer un examen");
        SaveExamButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveExamButtonMouseClicked(evt);
            }
        });
        jPanel2.add(SaveExamButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 170, -1));

        SortChoice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trier par date", "Trier par nom", "Trier par numéro" }));
        jPanel2.add(SortChoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));
        SortChoice.getAccessibleContext().setAccessibleParent(jPanel2);

        jLabel8.setText("EXAMENS");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        SearchExamField.setText("Rechercher");
        jPanel2.add(SearchExamField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 102, -1));
        jPanel2.add(SearchExamButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 20, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CloseDMRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseDMRMouseClicked
        getA().CloseDMR();
    }//GEN-LAST:event_CloseDMRMouseClicked

    private void ExamTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExamTableMouseClicked
        int row = ExamTable.getSelectedRow();
        int column = ExamTable.getSelectedColumn();
        Examen e = dmr.getExamen().get(row);
        /*si on clique sur la case image*/
        if (column == 3) {
            /*soit ça ouvre la fenêtre de numérisation*/
            if (e.getImage()==0) {
                new NumeriserExamen().setVisible(true);
            } 
            /*soit ça ouvre l'image (jframe image)*/ 
            else {
                new Image().setVisible(true); //remplacer rien par e.getImage()
            }
        }
        /*si on clique sur la case CR*/
        if (column == 4) {
            /*soit ça ouvre la fenêtre ajouter CR*/
            if (e.getCr()==0) {
                new EcrireCR(e.getId_exam(),this).setVisible(true);
            }
            /*soit ça ouvre le CR*/
            else {
                new CR(e.getCr()).setVisible(true);
            }
        }
    }//GEN-LAST:event_ExamTableMouseClicked

    private void SaveExamButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveExamButtonMouseClicked
        new EnregistrerExamen(getA(), getPatient()).setVisible(true);
    }//GEN-LAST:event_SaveExamButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseDMR;
    private javax.swing.JLabel DDNLabel;
    private javax.swing.JTable ExamTable;
    private javax.swing.JLabel GenderLabel;
    private javax.swing.JButton SaveExamButton;
    private javax.swing.JButton SearchExamButton;
    private javax.swing.JTextField SearchExamField;
    private javax.swing.JComboBox<String> SortChoice;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nssLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @return the a
     */
    public Accueil getA() {
        return a;
    }
}
