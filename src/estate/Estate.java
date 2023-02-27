package estate;


import frames.AddUser;
import frames.UpdateAdvert;
import frames.UpdateEstate;
import frames.AddEstate;
import frames.AddAdvert;
import frames.UpdateUser;
import assets.User;
import assets.Advert;
import assets.RealEstate;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Muhammed Ali LALE
 */
public class Estate extends javax.swing.JFrame {
        
        private ArrayList<User> userList;
        private ArrayList<RealEstate> estateList;
        private ArrayList<Advert> advertList;
        
        private JTable advertTable ;
        private JTable estateTable;
        private JTable userTable;
        private JTable detail;
        
        Operations op;
    
     /**
      * Creates new form Estate
      */
    public Estate() {
        op = new Operations();
        
        initComponents();
        initTables();
        fillTable();

        detButton.setVisible(false);                
        budget.setText("Toplam Bütçe: "+String.valueOf(op.getBudget()));
    }
    
    public void listInject(){
        java.awt.EventQueue.invokeLater(() -> {
                new Estate().setVisible(true);
            });
    }
    
    //create tables
    public void initTables(){
        //Tables of real estates
        estateTable = new JTable();
        estateTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        estateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Taşınmaz ID", "Tür", "Fiyat", "Alan", "Adres"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        estateTable.setRowHeight(25);
        estateTable.getColumnModel().getColumn(4).setPreferredWidth(400);

        //Tables of adverts
        advertTable = new JTable();
        advertTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        advertTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Taşınmaz ID", "İlan Açıklaması","Tarih"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        advertTable.setRowHeight(25);
      
        advertTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        advertTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        advertTable.getColumnModel().getColumn(0).setMaxWidth(100);
        advertTable.getColumnModel().getColumn(2).setMaxWidth(200);
        
        //Tables of users
        userTable = new JTable();
        userTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kullanıcı adı",  "İsim", "Soyisim", "Telefon", "Cuzdan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        userTable.setRowHeight(25);
        
        ScrollPane.setViewportView(advertTable);    //show advert table in screen

        //Tables of users those have more than one estate
        detail = new JTable();
        detail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        detail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kullanıcı adı",  "Toplam Mülk Ederleri"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        detail.setRowHeight(25);
       
    }
   
    
    //Adds the elements to JTables from Lists
    public void fillTable(){
        userList = op.getUserList();
        estateList = op.getEstateList();
        advertList = op.getAdvertList();
        
        for(User u:userList){
            getDefaultModel(userTable).addRow(new Object[]{u.userName,u.firstName,u.lastName,u.tel,Integer.toString(u.salary)});
        }  
        
        for(RealEstate e:estateList){
            getDefaultModel(estateTable).addRow(new Object[]{Integer.toString(e.estateID),e.getType(),Integer.toString(e.price),Integer.toString(e.area),e.address});
        }   
        
        for(Advert a:advertList){
            getDefaultModel(advertTable).addRow(new Object[]{a.estateID,a.description,a.date});
        }   
    }
    
    public DefaultTableModel getDefaultModel(javax.swing.JTable table) {
        return (DefaultTableModel) table.getModel();   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        message = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        tableTitle = new javax.swing.JLabel();
        detButton = new javax.swing.JButton();
        ScrollPane = new javax.swing.JScrollPane();
        saleButton = new javax.swing.JButton();
        budget = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Yıldız Emlak");

        jComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "İlanlar", "Taşınmazlar", "Kullanıcılar" }));
        jComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxİtemStateChanged(evt);
            }
        });
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addButton.setText("İlan Ver");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        updateButton.setText("İlan Bilgilerini Düzenle");
        updateButton.setPreferredSize(new java.awt.Dimension(220, 26));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        message.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        deleteButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteButton.setText("İlanı Kaldır");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        tableTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tableTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tableTitle.setText("İLANLAR");
        tableTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        detButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        detButton.setText("Kullanıcı Detay Görüntüle");
        detButton.setPreferredSize(new java.awt.Dimension(220, 26));
        detButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detButtonActionPerformed(evt);
            }
        });

        saleButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        saleButton.setText("Satış Yap");
        saleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleButtonActionPerformed(evt);
            }
        });

        budget.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        budget.setText("Toplam Bütçe:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(445, 445, 445)
                        .addComponent(tableTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(detButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(budget, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(tableTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(detButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(budget, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        addButton.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxActionPerformed
    
    //Set the changes according to combobox states
    private void jComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxİtemStateChanged
        if(jComboBox.getSelectedIndex()==0){//adverts
            ScrollPane.setViewportView(advertTable);
            addButton.setText("İlan ver");
            deleteButton.setText("İlanı Kaldır");
            updateButton.setText("İlan Bilgilerini Düzenle");
            saleButton.setVisible(true);
            saleButton.setText("Satış Yap");
            detButton.setVisible(true);
            tableTitle.setText("İLANLAR");
        }//estates
        else if(jComboBox.getSelectedIndex()==1){
            ScrollPane.setViewportView(estateTable);
            addButton.setText("Taşınmaz ekle");
            deleteButton.setText("Taşınmazı Sil");
            updateButton.setText("Taşınmaz Bilgilerini Düzenle");
            saleButton.setVisible(true);
            saleButton.setText("Bağış Yap");
            detButton.setVisible(true);
            tableTitle.setText("TAŞINMAZLAR");
        }//users
        else if(jComboBox.getSelectedIndex()==2){
            ScrollPane.setViewportView(userTable);
            addButton.setText("Kullanıcı Ekle");
            deleteButton.setText("Kullanıcıyı Sil");
            updateButton.setText("Kullanıcı Bilgilerini Düzenle");
            saleButton.setVisible(false);
            detButton.setVisible(true);
            detButton.setText("Kullanıcı detay görüntüle");
            tableTitle.setText("KULLANICILAR");
        }
    }//GEN-LAST:event_jComboBoxİtemStateChanged

    
    //Removes all the rows of tables
    public void clearTable(){
        while(getDefaultModel(userTable).getRowCount()>0){
            getDefaultModel(userTable).removeRow(0);
        }
        while(getDefaultModel(estateTable).getRowCount()>0){
            getDefaultModel(estateTable).removeRow(0);
        }
        while(getDefaultModel(advertTable).getRowCount()>0){
            getDefaultModel(advertTable).removeRow(0);
        }
    }
    
   
    public void refreshTables(){
        clearTable();
        fillTable();
    }
    
   //Gives the List on the screen
    private ArrayList getCurrentList(){
        if(jComboBox.getSelectedIndex()==0)
            return advertList;
        else if(jComboBox.getSelectedIndex()==1)
            return estateList;
        else
            return userList;
    }
    
    //Gives the table on the screen
    private JTable getCurrentTable(){
        if(jComboBox.getSelectedIndex()==0)
            return advertTable;
        else if(jComboBox.getSelectedIndex()==1)
            return estateTable;
        else
            return userTable;
    }
    
    //Puts message on the message label
    public void putMessage(Color renk, String msg){
        message.setForeground(renk);
        message.setText(msg);
    }
    
    //Returns the selected item ad the current row
    private Object getSelectedItem(){
        int selectedIndex;
        selectedIndex = getCurrentTable().getSelectedRow();
        return getCurrentList().get(selectedIndex);
    }
    
    
    //Opens Add user/advert/estate frames
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        message.setText("");
       if(jComboBox.getSelectedIndex()==0){
           //add advert
           AddAdvert adv = new AddAdvert(op,this);
           adv.setVisible(true);
       }else if(jComboBox.getSelectedIndex()==1){
           //add estate
           AddEstate est = new AddEstate(op, this);
           est.setVisible(true);
       }else if(jComboBox.getSelectedIndex()==2){
           //add user
           AddUser user = new AddUser(op, this);
           user.setVisible(true);
       }
    }//GEN-LAST:event_addButtonActionPerformed
    
    //Opens Update user/advert/estate frames
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
       
       Advert adv;
       RealEstate est;
       User user;
       //if any row is not selected
       int selectedIndex = getCurrentTable().getSelectedRow(); 
        if(selectedIndex ==-1){
            putMessage(Color.red, "Seçim yapınız");
            return;
        }
        
        if(jComboBox.getSelectedIndex()==0){
           //update advert
           adv = advertList.get(selectedIndex);
           UpdateAdvert updt = new UpdateAdvert(adv,op,this);
           updt.setVisible(true);
       }else if(jComboBox.getSelectedIndex()==1){
           //update estate
           est = estateList.get(selectedIndex);
           UpdateEstate updt = new UpdateEstate(est,op,this);
           updt.setVisible(true);
       }else if(jComboBox.getSelectedIndex()==2){
           //update user
           user = userList.get(selectedIndex);
           UpdateUser updt = new UpdateUser(user,op,this);
           updt.setVisible(true);
       }
    }//GEN-LAST:event_updateButtonActionPerformed
    
    //Deletes user/advert/estate
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
       Advert adv;
       RealEstate est;
       User user;
       //if any row is not selected
       int selectedIndex = getCurrentTable().getSelectedRow(); 
        if(selectedIndex ==-1){
            putMessage(Color.red, "Seçim yapınız");
            return;
        }
        
        Object[] options = { "EVET", "HAYIR" };
            int response=JOptionPane.showOptionDialog(this, "Silmek istediğinize emin misiniz?", "Uyarı", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(response == JOptionPane.NO_OPTION){  
                return;
            }
        
        if(jComboBox.getSelectedIndex()==0){
           //remove advert
           op.deleteAdvert(advertList.get(selectedIndex).estateID);
           refreshTables();
       }else if(jComboBox.getSelectedIndex()==1){
           //remove estate
            op.deleteEstate(estateList.get(selectedIndex).estateID);
            refreshTables();
       }else if(jComboBox.getSelectedIndex()==2){
           //remove user
           op.deleteUser(userList.get(selectedIndex).userName);
           refreshTables();
       }
    }//GEN-LAST:event_deleteButtonActionPerformed

    //shows details
    private void detButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detButtonActionPerformed
        //if it is on the adverts table
        if(jComboBox.getSelectedIndex()==1){
            //if any rows is not selected
            int selectedIndex = getCurrentTable().getSelectedRow(); 
            if(selectedIndex ==-1){
                putMessage(Color.red, "Seçim yapınız");
                return;
            }
            String msg;
            RealEstate est=estateList.get(selectedIndex);
            if(est.type==0){
                msg=op.getApartmentInfo(est.estateID);
                JOptionPane.showMessageDialog(this, msg);
            }else{
                msg=op.getInfo(est.estateID);
                JOptionPane.showMessageDialog(this, msg);
            }
        }else{  //on users table
            JFrame frame = new JFrame();    //open a new frame
            frame.setTitle("Birden Fazla Mal Varlığı Olanlar");
            frame.setBounds(480,150,600, 600);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
            frame.setVisible(true);
            
            JScrollPane scr = new JScrollPane();
            frame.add(scr);
            scr.setBounds(20,20,520,520);
            scr.setVisible(true);
            
            while(getDefaultModel(detail).getRowCount()>0){
            getDefaultModel(detail).removeRow(0);
        }
           
            for(User u:userList){
                getDefaultModel(detail).addRow(new Object[]{u.userName,op.getMoreThenOne(u.userName)});
        } 
             scr.setViewportView(detail);
            //add  the detail table to the screen by scrollpane
        }
    }//GEN-LAST:event_detButtonActionPerformed

    //Sale or Donation operations
    private void saleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleButtonActionPerformed
        //if the advert table on
        if(jComboBox.getSelectedIndex()==0){
            
            int selectedIndex = getCurrentTable().getSelectedRow(); 
            if(selectedIndex ==-1){
                putMessage(Color.red, "Seçim yapınız");
                return;
            }
            putMessage(Color.red, "");
            //Sale operations
            String user = JOptionPane.showInputDialog(this,"Satış Yapılacak Kullanıcı Adını Giriniz");
            if(user==(null))
                return;
            Double result=op.sale(user, advertList.get(selectedIndex).estateID);

            if(result != -1){
                JOptionPane.showMessageDialog(this, "Satış İŞlemi Başarılı. Komisyon tutarı: "+result);
                budget.setText("Toplam Bütçe: "+String.valueOf(op.getBudget()));
            }else{
                JOptionPane.showMessageDialog(this, "Satış İŞlemi Başarısız!");
            }
        }else if(jComboBox.getSelectedIndex()==1){
            //if the estate table on
            int selectedIndex = getCurrentTable().getSelectedRow(); 
            if(selectedIndex ==-1){
                putMessage(Color.red, "Seçim yapınız");
                return;
            }
            //Donation operations
            String user = JOptionPane.showInputDialog(this,"Bağışanacak Kullanıcı Adını Giriniz");
            if(user==(null))
                return;
            Date result=op.donate(user, estateList.get(selectedIndex).estateID);

            if(result != (null)){
                JOptionPane.showMessageDialog(this, "Bağış İŞlemi Başarılı. Tarih: "+result);
                budget.setText("Toplam Bütçe: "+String.valueOf(op.getBudget()));
            }else{
                JOptionPane.showMessageDialog(this, "Bağış İŞlemi Başarısız!");
            }
            
        }
    }//GEN-LAST:event_saleButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Estate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel budget;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton detButton;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel message;
    private javax.swing.JButton saleButton;
    private javax.swing.JLabel tableTitle;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
