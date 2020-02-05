/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.sun.glass.events.KeyEvent;
import com.sun.glass.events.MouseEvent;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import nf.*;

/**
 *
 * @author Julie
 */
public class Accueil extends javax.swing.JFrame {

    private SIR sir;
    private final Professionnel currentUser;
    private ArrayList<Patient> searchResult;

    /**
     * Creates new form Accueil
     *
     * @param currentUser : utilisateur actuel connecté au logiciel
     */
    public Accueil(Professionnel currentUser) {
        Date d1=new Date(120,1,05,8,30);
        Date d2=new Date(120,1,05,9,30);
        Examen e1 = new Examen(1,"Radiographie thoracique",d1,d2,TypeExam.IRM,"Peuillon","");
        String titreDePage = "Sinovar";
        this.setTitle(titreDePage);
        this.currentUser = currentUser;
        DataBaseLayer DBL = new DataBaseLayer("SELECT * from sinovar.personnel;");
        Professionnels pros = new Professionnels();
        for (int i = 1; i < DBL.getResult().size(); i++) {
            ArrayList<String> row = DBL.getResult().get(i);
            int id = Integer.parseInt(row.get(0));
            Metier m = Metier.valueOf(row.get(5));
            Professionnel p = new Professionnel(id, row.get(1), row.get(2), row.get(3), row.get(4), m);
            p.ajouterExamen(e1);
            pros.ajouterProfessionnel(p);
        }
        /*récupération du personnel de la BDD*/
        sir = new SIR(pros);
        DBL = new DataBaseLayer("SELECT * from sinovar.patient;");
        for (int i = 1; i < DBL.getResult().size(); i++) {
            ArrayList<String> row = DBL.getResult().get(i);
            int id = Integer.parseInt(row.get(2));
            Patient p = new Patient(row.get(0), row.get(1), id, row.get(3), row.get(4), row.get(5), row.get(6));
            sir.ajouterPatient(p);
        }
        /*récupération des patients de la BDD*/
        
        sir.getPatient().get(0).getDmr().ajouterExamen(e1);
        
        initComponents();
        AgendaPanel ap = new AgendaPanel(this);
        this.jPanel1.add(ap,BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        SecondPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        PatientSearchPanel = new javax.swing.JPanel();
        DMRLabel = new javax.swing.JLabel();
        SearchPatientField = new javax.swing.JTextField();
        SearchPatientButton = new javax.swing.JButton();
        ScrollDMR = new javax.swing.JScrollPane();
        DMRTable = new javax.swing.JTable();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(858, 331));

        SecondPanel.setPreferredSize(new java.awt.Dimension(615, 331));
        SecondPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(615, 331));
        jPanel1.setPreferredSize(new java.awt.Dimension(615, 331));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        SecondPanel.add(jPanel1, java.awt.BorderLayout.EAST);

        PatientSearchPanel.setMinimumSize(new java.awt.Dimension(230, 331));
        PatientSearchPanel.setPreferredSize(new java.awt.Dimension(230, 331));

        DMRLabel.setText("CONSULTER UN DMR");

        SearchPatientField.setText("Rechercher");
        SearchPatientField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchPatientFieldMouseClicked(evt);
            }
        });
        SearchPatientField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchPatientFieldKeyPressed(evt);
            }
        });

        SearchPatientButton.setText("R");
        SearchPatientButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchPatientButtonMouseClicked(evt);
            }
        });

        DMRTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nom", "Identifiant"
            }
        ));
        DMRTable.setColumnSelectionAllowed(true);
        DMRTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DMRTableMouseClicked(evt);
            }
        });
        DMRTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DMRTableKeyPressed(evt);
            }
        });
        ScrollDMR.setViewportView(DMRTable);
        DMRTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout PatientSearchPanelLayout = new javax.swing.GroupLayout(PatientSearchPanel);
        PatientSearchPanel.setLayout(PatientSearchPanelLayout);
        PatientSearchPanelLayout.setHorizontalGroup(
            PatientSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientSearchPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PatientSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollDMR, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PatientSearchPanelLayout.createSequentialGroup()
                        .addGroup(PatientSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DMRLabel)
                            .addComponent(SearchPatientField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(SearchPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PatientSearchPanelLayout.setVerticalGroup(
            PatientSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientSearchPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PatientSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchPatientField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchPatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DMRLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollDMR, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        SecondPanel.add(PatientSearchPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(SecondPanel, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DMRTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DMRTableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DMRTableKeyPressed

    private void DMRTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DMRTableMouseClicked
        int row = DMRTable.getSelectedRow();
        if (searchResult != null && row >= 0 && row < searchResult.size()) {
            jPanel1.removeAll();
            jPanel1.add(new DMR(searchResult.get(row),this),BorderLayout.CENTER); /*ouvre le DMR du patient selectionne*/
            this.pack();
            this.repaint();
        }
    }//GEN-LAST:event_DMRTableMouseClicked

    private void SearchPatientFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchPatientFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            searchResult = getSir().chercherPatient(SearchPatientField.getText());//recherche les patients
            /*vide le tableau*/
            if (SearchPatientField.getText().trim().equals("") || searchResult.isEmpty()) {
                for (int i = 0; i < DMRTable.getRowCount(); i++) {
                    DMRTable.setValueAt("", i, 0);
                    DMRTable.setValueAt("", i, 1);
                }
            } else {
                /*remplit les lignes jusqu'à ce qu'il n'y en ait plus ou jusqu'à ce que la liste soit finie*/
                for (int i = 0; i < Math.min(searchResult.size(), DMRTable.getRowCount()); i++) {
                    DMRTable.setValueAt(searchResult.get(i).getNomUsuel(), i, 0);
                    DMRTable.setValueAt(searchResult.get(i).getIdPatient(), i, 1);
                }
                /*remplit le reste des lignes si la liste est plus longue que le tableau en ajoutant des lignes*/
                for (int i = DMRTable.getRowCount(); i < Math.max(searchResult.size(), DMRTable.getRowCount()); i++) {
                    //ajouter des lignes ??
                    DMRTable.setValueAt(searchResult.get(i).getNomUsuel(), i, 0);
                    DMRTable.setValueAt(searchResult.get(i).getIdPatient(), i, 1);
                }
            }
        }
    }//GEN-LAST:event_SearchPatientFieldKeyPressed

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
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Accueil a = new Accueil(null);
                AgendaPanel ap = new AgendaPanel(a);
                a.jPanel1.add(ap,BorderLayout.CENTER);
                a.pack();
                a.setVisible(true);
                a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
            }
        });
    }

    public void SearchPatientFieldMouseClicked(java.awt.event.MouseEvent evt) {
        SearchPatientField.selectAll();
        //.setText("");
    }

    public void SearchPatientButtonMouseClicked(java.awt.event.MouseEvent evt) {
        searchResult = getSir().chercherPatient(SearchPatientField.getText());//recherche les patients
        /*vide le tableau*/
        if (SearchPatientField.getText().trim().equals("") || searchResult.isEmpty()) {
            for (int i = 0; i < DMRTable.getRowCount(); i++) {
                DMRTable.setValueAt("", i, 0);
                DMRTable.setValueAt("", i, 1);
            }
        } else {
            /*remplit les lignes jusqu'à ce qu'il n'y en ait plus ou jusqu'à ce que la liste soit finie*/
            for (int i = 0; i < Math.min(searchResult.size(), DMRTable.getRowCount()); i++) {
                DMRTable.setValueAt(searchResult.get(i).getNomUsuel(), i, 0);
                DMRTable.setValueAt(searchResult.get(i).getIdPatient(), i, 1);
            }
            /*remplit le reste des lignes si la liste est plus longue que le tableau en ajoutant des lignes*/
            for (int i = DMRTable.getRowCount(); i < Math.max(searchResult.size(), DMRTable.getRowCount()); i++) {
                //ajouter des lignes ??
                DMRTable.setValueAt(searchResult.get(i).getNomUsuel(), i, 0);
                DMRTable.setValueAt(searchResult.get(i).getIdPatient(), i, 1);
            }
        }
    }
    
    public void CloseDMR(){
        jPanel1.removeAll();
        jPanel1.add(new AgendaPanel(this),BorderLayout.CENTER); /*ouvre le DMR du patient selectionne*/
        this.pack();
        this.repaint();
    }
    
    public void logOut(){
        this.dispose();
        new Connexion().setVisible(true);
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DMRLabel;
    private javax.swing.JTable DMRTable;
    private javax.swing.JPanel PatientSearchPanel;
    private javax.swing.JScrollPane ScrollDMR;
    private javax.swing.JButton SearchPatientButton;
    private javax.swing.JTextField SearchPatientField;
    private javax.swing.JPanel SecondPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the currentUser
     */
    public Professionnel getCurrentUser() {
        return currentUser;
    }

    /**
     * @return the sir
     */
    public SIR getSir() {
        return sir;
    }

}