package program.rumahsakit;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Pasien extends javax.swing.JFrame {
   private final DefaultTableModel model;
    
    public Pasien() {
        initComponents();
       // membuat TableModel
        model = new DefaultTableModel();
        
        //membuat TableModel ke Tabel
        tabelPasien1.setModel(model);
        
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
         
         String sql = "select*from pasien";
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
             // lakukan penelusuran baris 
             Object[] o = new Object[7];
             o[0] = r.getString("PasienID");
             o[1] = r.getString("NoKTP");
             o[2] = r.getString("Nama");
             o[3] = r.getString("Alamat");
             o[4] = r.getString("TglLahir");
             o[5] = r.getString("NoTelp");
             o[6] = r.getString("RiwayatPenyakit");
             
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
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        inputPasienId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        inputNoKTP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inputNama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputTL = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        inputNoTelp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputAlamat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        inputRiwayatPenyakit = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPasien1 = new javax.swing.JTable();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnkembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel9.setBackground(new java.awt.Color(255, 102, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DATA PASIEN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pasien ID");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("No KTP");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tanggal Lahir");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("No Telepon");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Alamat");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Riwayat Penyakit");

        btnTambah.setBackground(new java.awt.Color(204, 255, 255));
        btnTambah.setText("TAMBAH");
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });

        tabelPasien1.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPasien1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPasien1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelPasien1);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnkembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTambah))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(inputPasienId, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(inputNoKTP, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(inputNama, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputAlamat, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputRiwayatPenyakit, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(inputTL)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(74, 74, 74)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(inputNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUbah)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputPasienId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputNoKTP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputNama, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputTL, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputRiwayatPenyakit, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambah)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUbah)
                        .addComponent(btnHapus)
                        .addComponent(btnkembali)))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        int i = tabelPasien1.getSelectedRow();
        if(i == -1){
        //tidak ada baris terseleksi
        return;
        }
        //ambil nim yang terseleksi
        String PasienID = (String) model.getValueAt(i, 0);  
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
        }catch (SQLException e){
           System.out.println("Terjadi Eror");
        }finally {
            loadData();
        }
    }//GEN-LAST:event_btnUbahMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        int i = tabelPasien1.getSelectedRow();
        if(i == -1){
            //tidak ada baris terseleksi
            return;
        }
        String PasienID = (String) model.getValueAt(i, 0);
        try {
            Connection c = KoneksiDatabase.getKoneksi();
            
            String sql = "delete FROM pasien where PasienID= ?";
            
            PreparedStatement p = c.prepareStatement(sql);
            
            p.setString(1, PasienID);
        //ambil nim yang terseleksi
        
        p.executeUpdate();
        p.close();
            
        }catch(SQLException e){
            System.out.println("Terjadi Eror");
        }finally {
            loadData();
        }    
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        String PasienID = inputPasienId.getText();
        String NoKTP = inputNoKTP.getText();
        String Nama = inputNama.getText();
        String Alamat = inputAlamat .getText();
        String TglLahir = inputTL.getText();
        String NoTelp = inputNoTelp.getText();
        String RiwayatPenyakit = inputRiwayatPenyakit.getText();
        
        
        try {
            Connection c = KoneksiDatabase.getKoneksi();
            
            String sql = "insert into pasien values (?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement p = c.prepareStatement(sql);
            
            p.setString(1, PasienID);
            p.setString(2, NoKTP);
            p.setString(3, Nama);
            p.setString(4, Alamat);
            p.setString(5, TglLahir);
            p.setString(6, NoTelp);
            p.setString(7, RiwayatPenyakit);
            
            p.executeUpdate();
            p.close();
            
        }catch(SQLException e){
            System.out.println("Terjadi Eror");
        }finally {
            loadData();
        }  
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
        dispose();
    }//GEN-LAST:event_btnkembaliActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbahActionPerformed

    private void tabelPasien1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPasien1MouseClicked
        int i = tabelPasien1.getSelectedRow();
        if(i == -1){
            //tidak ada baris terseleksi
            return;
        }
        String PasienID = (String) model.getValueAt(i, 0);
        inputPasienId.setText(PasienID);

        String NoKTP = (String) model.getValueAt(i, 1);
        inputNoKTP.setText(NoKTP);

        String Nama = (String) model.getValueAt(i, 2);
        inputNama.setText(Nama);

        String Alamat = (String) model.getValueAt(i, 3);
        inputAlamat.setText(Alamat);

        String TglLahir = (String) model.getValueAt(i, 4);
        inputTL.setText(TglLahir);

        String NoTelp = (String) model.getValueAt(i, 5);
        inputNoTelp.setText(NoTelp);

        String RiwayatPenyakit = (String) model.getValueAt(i, 6);
        inputRiwayatPenyakit.setText(RiwayatPenyakit);
    }//GEN-LAST:event_tabelPasien1MouseClicked

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton btnkembali;
    private javax.swing.JTextField inputAlamat;
    private javax.swing.JTextField inputNama;
    private javax.swing.JTextField inputNoKTP;
    private javax.swing.JTextField inputNoTelp;
    private javax.swing.JTextField inputPasienId;
    private javax.swing.JTextField inputRiwayatPenyakit;
    private javax.swing.JTextField inputTL;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTable tabelPasien1;
    // End of variables declaration//GEN-END:variables
}
