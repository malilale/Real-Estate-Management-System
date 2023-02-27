package frames;

import estate.Estate;
import estate.Operations;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author A
 */
public class AddUser extends javax.swing.JFrame {
    Operations set;
    Estate list;
    /**
     * Creates new form AddProductFrontEnd
     */
    public AddUser(Operations set, Estate list) {
        this.set = set;
        this.list = list;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel = new javax.swing.JLabel();
        error_message = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        JuserName = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        JlastName = new javax.swing.JTextField();
        Label4 = new javax.swing.JLabel();
        Jtel = new javax.swing.JTextField();
        Label5 = new javax.swing.JLabel();
        Jsalary = new javax.swing.JTextField();
        Label2 = new javax.swing.JLabel();
        Jname = new javax.swing.JTextField();
        Label3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kullanıcı Ekleme");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel.setText("KULLANICI EKLE");

        error_message.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        label1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label1.setText("Kullanıcı Adı:");

        saveButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        saveButton.setText("Kaydet");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        Label4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Label4.setText("Telefon Numarası");

        Label5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Label5.setText("Varlık");

        Jsalary.setActionCommand("<Not Set>");

        Label2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Label2.setText("İsim");

        Label3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Label3.setText("Soyisim");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(error_message, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(58, 58, 58)
                            .addComponent(JuserName))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Jname))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Label5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Label4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Label3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Jsalary, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Jtel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JlastName, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1)
                    .addComponent(JuserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label2)
                    .addComponent(Jname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label3)
                    .addComponent(JlastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Label4)
                        .addGap(18, 18, 18)
                        .addComponent(Label5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Jtel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Jsalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton)
                    .addComponent(error_message, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try{
            if(JuserName.getText().equals("")){
                error_message.setForeground(Color.RED);
                error_message.setText("kullanıcı Adı Bos Birakilamaz!");
            }else if(Jname.getText().equals("")){
                error_message.setForeground(Color.RED);
                error_message.setText("İsim Bos Birakilamaz!");
            }else if(JlastName.getText().equals("")){
                error_message.setForeground(Color.RED);
                error_message.setText("Soyisim Bos Birakilamaz!");
            }else if(Jtel.getText().equals("")){
                error_message.setForeground(Color.RED);
                error_message.setText("Telefon Numarası Bos Birakilamaz!");
            }else if(Jsalary.getText().equals("")){
                error_message.setForeground(Color.RED);
                error_message.setText("Varlık Bos Birakilamaz!");
            }else if(Integer.parseInt(Jsalary.getText())<0){
                error_message.setForeground(Color.RED);
                error_message.setText("Varlık Negatif olamaz!");
            }else{
                boolean result=set.addUser(JuserName.getText(),Jname.getText(),JlastName.getText(),Jtel.getText(),Integer.parseInt(Jsalary.getText()));
                if(result){
                    list.refreshTables();   //refresh tables after insertion
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Kullanıcı güncellenemedi!");
                }
            }
        }catch(NumberFormatException ex){ 
            Logger.getLogger(UpdateUser.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Lütfen Uygun Değerler Giriniz!");
        }
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JlastName;
    private javax.swing.JTextField Jname;
    private javax.swing.JTextField Jsalary;
    private javax.swing.JTextField Jtel;
    private javax.swing.JTextField JuserName;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Label3;
    private javax.swing.JLabel Label4;
    private javax.swing.JLabel Label5;
    private javax.swing.JLabel error_message;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel label1;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}