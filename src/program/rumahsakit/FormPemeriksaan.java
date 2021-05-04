package program.rumahsakit;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FormPemeriksaan extends javax.swing.JFrame {
    private final DefaultTableModel model;
    
    public FormPemeriksaan() {
        initComponents();
        // membuat TableModel
        model = new DefaultTableModel();
        
        //membuat TableModel ke Tabel
        TabelPemeriksaan.setModel(model);
        
        model.addColumn("Pemeriksaan ID");
        model.addColumn("Pasien ID");
        model.addColumn("Dokter ID");
        model.addColumn("Obat ID");
        model.addColumn("Fasilitas ID");
        model.addColumn("Umur");
        model.addColumn("Berat Badan");
        model.addColumn("Keluhan");
       
        // panggil loadData()
        loadData();
    }

    public void loadData() {
     // menghapus seluruh data
     model.getDataVector().removeAllElements();
     // meberi tahu bahwa data telah kosong
     model.fireTableDataChanged();
     
     try{
         Connection c = KoneksiDatabase.getKoneksi();
         Statement s = c.createStatement();
         
         String sql = "SELECT * FROM pemeriksaan";
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
             // lakukan penelusuran baris 
             Object[] o = new Object[8];
             o[0] = r.getString("PemeriksaanID");
             o[1] = r.getString("PasienID");
             o[2] = r.getString("DokterID");
             o[3] = r.getString("ObatID");
             o[4] = r.getString("FasilitasID");
             o[5] = r.getString("Umur");
             o[6] = r.getString("BeratBadan");
             o[7] = r.getString("Keluhan");
             
             model.addRow(o);
         }
         r.close();
         s.close();
         
     }catch (SQLException e){
         System.out.println("Tejadi Error");
     }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputPasienId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inputDokterId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputObatId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputFasilitasId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        inputUmur = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        inputBB = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        inputKeluhan = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelPemeriksaan = new javax.swing.JTable();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnkembali = new javax.swing.JButton();
        inputPemeriksaanId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel10.setBackground(new java.awt.Color(255, 102, 0));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("FORM PEMERIKSAAN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel10)
                .addContainerGap(297, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pemeriksaan ID");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pasien ID");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dokter ID");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Obat ID");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fasilitas ID");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Umur");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Berat Badan");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Keluhan");

        btnTambah.setBackground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("TAMBAH");
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });

        TabelPemeriksaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelPemeriksaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPemeriksaanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelPemeriksaan);

        btnUbah.setBackground(new java.awt.Color(204, 255, 255));
        btnUbah.setText("UBAH");
        btnUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahMouseClicked(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(204, 255, 255));
        btnHapus.setText("HAPUS");
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });

        btnkembali.setBackground(new java.awt.Color(204, 255, 255));
        btnkembali.setText("KEMBALI");
        btnkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnkembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(btnTambah))
                    .addComponent(inputKeluhan, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(inputFasilitasId, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputDokterId, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addComponent(inputPemeriksaanId, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(inputPasienId, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(inputObatId)
                            .addComponent(inputUmur)))
                    .addComponent(inputBB, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUbah)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputPasienId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputPemeriksaanId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputDokterId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputObatId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputFasilitasId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputUmur, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputBB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputKeluhan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUbah)
                            .addComponent(btnHapus))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnkembali)
                            .addComponent(btnTambah))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelPemeriksaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPemeriksaanMouseClicked
        int i = TabelPemeriksaan.getSelectedRow();
        if(i == -1){
            //tidak ada baris terseleksi
            return;
        }
        String PemeriksaanID = (String) model.getValueAt(i, 0);
        inputPemeriksaanId.setText(PemeriksaanID);

        String PasienID = (String) model.getValueAt(i, 1);
        inputPasienId.setText(PasienID);

        String DokterID = (String) model.getValueAt(i, 2);
        inputDokterId.setText(DokterID);

        String ObatID = (String) model.getValueAt(i, 3);
        inputObatId.setText(ObatID);
        
        String FasilitasID = (String) model.getValueAt(i, 4);
        inputFasilitasId.setText(FasilitasID);
        
        String Umur = (String) model.getValueAt(i, 5);
        inputUmur.setText(Umur);
        
        String BeratBadan = (String) model.getValueAt(i, 6);
        inputBB.setText(BeratBadan);
        
        String Keluhan = (String) model.getValueAt(i, 7);
        inputKeluhan.setText(Keluhan);
    }//GEN-LAST:event_TabelPemeriksaanMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        int i = TabelPemeriksaan.getSelectedRow();
        if(i == -1){
            //tidak ada baris terseleksi
            return;
        }
        String PemeriksaanID = (String) model.getValueAt(i, 0);
        try {
            Connection c = KoneksiDatabase.getKoneksi();
            
            String sql = "delete FROM pemeriksaan where PemeriksaanID = ?";
            
            PreparedStatement p = c.prepareStatement(sql);
            
            p.setString(1, PemeriksaanID);
        //ambil ID yang terseleksi
        
        p.executeUpdate();
        p.close();
        JOptionPane.showMessageDialog(null,"Data Berhasil Di Hapus");
        }catch(SQLException e){
            System.out.println("Terjadi Eror");
            JOptionPane.showMessageDialog(null,"Data Gagal Di Hapus");
        }finally {
            loadData();
        }
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        String PemeriksaanID = inputPemeriksaanId.getText();
        String PasienID = inputPasienId.getText();
        String DokterID = inputDokterId.getText();
        String ObatID = inputObatId.getText();
        String FasilitasID = inputFasilitasId.getText();
        String Umur = inputUmur.getText();
        String BeratBadan = inputBB.getText();
        String Keluhan = inputKeluhan.getText();
        
        try {
            Connection c = KoneksiDatabase.getKoneksi();
            
            String sql = "insert into pemeriksaan values (?, ?, ?, ?, ?, ?, ?, ?)";
            
            
            PreparedStatement p = c.prepareStatement(sql);
            
            p.setString(1, PemeriksaanID);
            p.setString(2, PasienID);
            p.setString(3, DokterID);
            p.setString(4, ObatID);
            p.setString(5, FasilitasID);
            p.setString(6, Umur);
            p.setString(7, BeratBadan);
            p.setString(8, Keluhan);
            
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil Di Tambah");
        }catch(SQLException e){
            System.out.println("Terjadi Eror");
            JOptionPane.showMessageDialog(null,"Data Gagal Di Tambah");
        }finally {
            loadData();
        }
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
        dispose();
    }//GEN-LAST:event_btnkembaliActionPerformed

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        int i = TabelPemeriksaan.getSelectedRow();
        if(i == -1){
            //tidak ada baris terseleksi
            return;
        }
        //ambil nim yang terseleksi
        String PemeriksaanID = (String) model.getValueAt(i, 0);  
        String PasienID = inputPasienId.getText();
        String DokterID = inputDokterId.getText();
        String ObatID = inputObatId.getText();
        String FasilitasID = inputFasilitasId.getText();
        String Umur = inputUmur.getText();
        String BeratBadan = inputBB.getText();
        String Keluhan = inputKeluhan.getText();
        
        try{
            Connection c = KoneksiDatabase.getKoneksi();
            
            String sql = "update pemeriksaan set PasienID = ?, DokterID = ?, ObatID = ?, FasilitasID = ?, Umur  = ?, BeratBadan = ?, Keluhan = ? where PemeriksaanID = ?";
            
            PreparedStatement p = c.prepareStatement(sql);
            
            p.setString(1, PasienID);
            p.setString(2, DokterID);
            p.setString(3, ObatID);
            p.setString(4, FasilitasID);
            p.setString(5, Umur);
            p.setString(6, BeratBadan);
            p.setString(7, Keluhan);
            p.setString(8, PemeriksaanID);
            
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil Di Ubah");
        }catch (SQLException e){
           System.out.println("Terjadi Eror");
           JOptionPane.showMessageDialog(null,"Data Gagal Di Ubah");
        }finally {
            loadData();
        }
    }//GEN-LAST:event_btnUbahMouseClicked

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
            java.util.logging.Logger.getLogger(FormPemeriksaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPemeriksaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPemeriksaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPemeriksaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPemeriksaan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelPemeriksaan;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton btnkembali;
    private javax.swing.JTextField inputBB;
    private javax.swing.JTextField inputDokterId;
    private javax.swing.JTextField inputFasilitasId;
    private javax.swing.JTextField inputKeluhan;
    private javax.swing.JTextField inputObatId;
    private javax.swing.JTextField inputPasienId;
    private javax.swing.JTextField inputPemeriksaanId;
    private javax.swing.JTextField inputUmur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
