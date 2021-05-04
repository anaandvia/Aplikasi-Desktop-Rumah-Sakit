package program.rumahsakit;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FormPendaftaran extends javax.swing.JFrame {
    private final DefaultTableModel model;
   
    public FormPendaftaran() {
        initComponents();
        // membuat TableModel
        model = new DefaultTableModel();
        
        //membuat TableModel ke Tabel
        TabelPendaftaran.setModel(model);
        
        model.addColumn("Pendaftaran ID");
        model.addColumn("Pasien ID");
        model.addColumn("No KTP");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("Tgl Lahir");
        model.addColumn("No Telp");
        model.addColumn("Riwayat Penyakit");
              
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
         
         String sql = "SELECT pendaftaran.PendaftaranID, pasien.PasienID,pasien.NoKTP, pasien.Nama, pasien.Alamat, pasien.TglLahir , pasien.NoTelp, pasien.RiwayatPenyakit FROM pendaftaran , pasien where pendaftaran.PasienID = pasien.PasienID";
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
             // lakukan penelusuran baris 
             Object[] o = new Object[8];
             o[0] = r.getString("PendaftaranID");
             o[1] = r.getString("PasienID");
             o[2] = r.getString("NoKTP");
             o[3] = r.getString("Nama");
             o[4] = r.getString("Alamat");
             o[5] = r.getString("TglLahir");
             o[6] = r.getString("NoTelp");
             o[7] = r.getString("RiwayatPenyakit");
             
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
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputPasienId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inputNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputAlamat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputTL = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        inputNoTelp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        inputRiwayatPenyakit = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelPendaftaran = new javax.swing.JTable();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnkembali = new javax.swing.JButton();
        inputNoKTP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inputPendaftaranId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jLabel9.setBackground(new java.awt.Color(255, 102, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("FORM PENDAFTARAN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pendaftaran ID");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pasien ID");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Alamat");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tanggal Lahir");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("No Telepon");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Riwayat Penyakit");

        inputRiwayatPenyakit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputRiwayatPenyakitActionPerformed(evt);
            }
        });

        btnTambah.setBackground(new java.awt.Color(204, 255, 255));
        btnTambah.setText("TAMBAH");
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });

        TabelPendaftaran.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelPendaftaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPendaftaranMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelPendaftaran);

        btnUbah.setBackground(new java.awt.Color(204, 255, 255));
        btnUbah.setText("UBAH");
        btnUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahMouseClicked(evt);
            }
        });
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
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

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("No KTP");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(inputTL, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(inputNoTelp)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnkembali)
                            .addGap(126, 126, 126)
                            .addComponent(btnTambah))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(inputRiwayatPenyakit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel4)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(120, 120, 120)
                                    .addComponent(jLabel6))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(76, 76, 76)
                                    .addComponent(jLabel2))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(inputAlamat, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(inputNama, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(inputPendaftaranId, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(inputPasienId, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                            .addComponent(inputNoKTP))))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(402, 402, 402)
                        .addComponent(btnUbah)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputPasienId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputPendaftaranId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputNama, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputNoKTP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputTL, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputRiwayatPenyakit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambah)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUbah)
                        .addComponent(btnHapus))
                    .addComponent(btnkembali))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelPendaftaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPendaftaranMouseClicked
        int i = TabelPendaftaran.getSelectedRow();
        if(i == -1){
            //tidak ada baris terseleksi
            return;
        }
        String PendaftaranID = (String) model.getValueAt(i, 0);
        inputPendaftaranId.setText(PendaftaranID);
        
        String PasienID = (String) model.getValueAt(i, 1);
        inputPasienId.setText(PasienID);
        
        String NoKTP = (String) model.getValueAt(i, 2);
        inputNoKTP.setText(NoKTP);
        
        String Nama = (String) model.getValueAt(i, 3);
        inputNama.setText(Nama);
        
        String Alamat = (String) model.getValueAt(i, 4);
        inputAlamat.setText(Alamat);
        
        String TglLahir = (String) model.getValueAt(i, 5);
        inputTL.setText(TglLahir);
        
        String NoTelp = (String) model.getValueAt(i, 6);
        inputNoTelp.setText(NoTelp);
        
        String RiwayatPenyakit = (String) model.getValueAt(i, 7);
        inputRiwayatPenyakit.setText(RiwayatPenyakit);
        
    }//GEN-LAST:event_TabelPendaftaranMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        // TODO add your handling code here:
        int i = TabelPendaftaran.getSelectedRow();
        if(i == -1){
            //tidak ada baris terseleksi
            return;
        }
        String PendaftaranID = (String) model.getValueAt(i, 0);
    
        try {
            Connection c = KoneksiDatabase.getKoneksi();
            
            String sql = "delete FROM pendaftaran where PendaftaranID = ?";
           
            PreparedStatement p = c.prepareStatement(sql);
            
        
            p.setString(1, PendaftaranID);
            
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
        String PendaftaranID = inputPendaftaranId.getText();
        String PasienID = inputPasienId.getText();
        String NoKTP = inputNoKTP.getText();
        String Nama = inputNama.getText();
        String Alamat = inputAlamat.getText();
        String TglLahir = inputTL.getText();
        String NoTelp = inputNoTelp.getText();
        String RiwayatPenyakit = inputRiwayatPenyakit.getText();
        
        try {
            Connection c = KoneksiDatabase.getKoneksi();
            
            String sql = "insert into pasien values (?, ?, ?, ?, ?, ?, ?)";
            String sql2 = "insert into pendaftaran values (?, ?)";
            
            
            PreparedStatement p = c.prepareStatement(sql);
            PreparedStatement p2 = c.prepareStatement(sql2);
            p.setString(1, PasienID);
            p.setString(2, NoKTP);
            p.setString(3, Nama);
            p.setString(4, Alamat);
            p.setString(5, TglLahir);
            p.setString(6, NoTelp);
            p.setString(7, RiwayatPenyakit);
            p2.setString(1, PendaftaranID);
            p2.setString(2, PasienID);
            
            p.executeUpdate();
            p.close();
            p2.executeUpdate();
            p2.close();
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
        int i = TabelPendaftaran.getSelectedRow();
        if(i == -1){
            //tidak ada baris terseleksi
            return;
        }
        //ambil nim yang terseleksi
        String PendaftaranID = (String) model.getValueAt(i, 0);  
        String PasienID = inputPasienId.getText();
        String NoKTP = inputNoKTP.getText();
        String Nama = inputNama.getText();
        String Alamat = inputAlamat.getText();
        String TglLahir = inputTL.getText();
        String NoTelp = inputNoTelp.getText();
        String RiwayatPenyakit = inputRiwayatPenyakit.getText();

        
        try{
            Connection c = KoneksiDatabase.getKoneksi();
            
            String sql = "update pasien set NoKTP = ?, Nama = ?, Alamat = ?, TglLahir = ?, NoTelp  = ?, RiwayatPenyakit = ? where PasienID = ?";
            
            PreparedStatement p = c.prepareStatement(sql);
            
            p.setString(1, NoKTP);
            p.setString(2, Nama);
            p.setString(3, Alamat);
            p.setString(4, TglLahir);
            p.setString(5, NoTelp);
            p.setString(6, RiwayatPenyakit);
            p.setString(7, PasienID);
            
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

    private void inputRiwayatPenyakitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputRiwayatPenyakitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputRiwayatPenyakitActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbahActionPerformed

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
            java.util.logging.Logger.getLogger(FormPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPendaftaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelPendaftaran;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton btnkembali;
    private javax.swing.JTextField inputAlamat;
    private javax.swing.JTextField inputNama;
    private javax.swing.JTextField inputNoKTP;
    private javax.swing.JTextField inputNoTelp;
    private javax.swing.JTextField inputPasienId;
    private javax.swing.JTextField inputPendaftaranId;
    private javax.swing.JTextField inputRiwayatPenyakit;
    private javax.swing.JTextField inputTL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
