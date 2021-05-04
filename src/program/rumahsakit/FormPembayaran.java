package program.rumahsakit;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FormPembayaran extends javax.swing.JFrame {
    private DefaultTableModel model;
    
    public FormPembayaran() {
        initComponents();
        ///membuat TableModel
        model = new DefaultTableModel();
        //menambahkan TableModel ke Table
        tabelPembayaran.setModel(model);
        
        model.addColumn("Pembayaran ID");
        model.addColumn("Pemeriksaan ID");
        model.addColumn("Jumlah");
        model.addColumn("Cara Pembayaran");
        model.addColumn("Tanggal");
        loadData();
    }

    public void loadData(){
        //menghapus seluruh data
        model.getDataVector().removeAllElements();
        //memberi tahu bahwa data telah kosong 
        model.fireTableDataChanged();
        try{
            
            Connection c = KoneksiDatabase.getKoneksi();
            Statement s = c.createStatement();
            
            String sql = "select*from pembayaran";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                //Lakukan penelusuran baris
                Object[] o = new Object[5];
                o[0] = r.getString("PembayaranID");
                o[1] = r.getString("PemeriksaanID");
                o[2] = r.getString("Jumlah");
                o[3] = r.getString("CaraPembayaran");
                o[4] = r.getString("Tanggal");
                model.addRow(o);
            }
            r.close();
            s.close();
        }catch(SQLException e){
            System.out.println("Tejadi Eror");
        }
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        inputPembayaranId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        inputPemeriksaanId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputJumlah = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputCaraPembayaran = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        inputTanggal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPembayaran = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnkembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("FORM PEMBAYARAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pembayaran ID");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pemeriksaan ID");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jumlah");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cara Pembayaran");

        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Tanggal");

        inputTanggal.setBackground(new java.awt.Color(240, 240, 240));

        tabelPembayaran.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPembayaranMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelPembayaran);

        btnTambah.setBackground(new java.awt.Color(204, 255, 255));
        btnTambah.setText("TAMBAH");
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(204, 255, 255));
        btnHapus.setText("HAPUS");
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(204, 255, 255));
        btnUbah.setText("UBAH");
        btnUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahMouseClicked(evt);
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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(inputJumlah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addComponent(inputPembayaranId, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(inputPemeriksaanId, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(inputCaraPembayaran)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(inputTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnkembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTambah)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUbah)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputPembayaranId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputPemeriksaanId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputCaraPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnHapus)
                        .addComponent(btnUbah))
                    .addComponent(btnkembali)
                    .addComponent(btnTambah))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelPembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPembayaranMouseClicked
        int i = tabelPembayaran.getSelectedRow();
        if(i == -1){
            //tidak ada baris terseleksi
            return;
        }
        String PembayaranID = (String) model.getValueAt(i, 0);
        inputPembayaranId.setText(PembayaranID);

        String PemeriksaanID = (String) model.getValueAt(i, 1);
        inputPemeriksaanId.setText(PemeriksaanID);

        String Jumlah = (String) model.getValueAt(i, 2);
        inputJumlah.setText(Jumlah);

        String CaraPembayaran = (String) model.getValueAt(i, 3);
        inputCaraPembayaran.setText(CaraPembayaran);
        
        String Tanggal = (String) model.getValueAt(i, 4);
        inputTanggal.setText(Tanggal);
    }//GEN-LAST:event_tabelPembayaranMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        int i = tabelPembayaran.getSelectedRow();
        if(i == -1){
            //tidak ada baris terseleksi
            return;
        }
        String PembayaranID = (String) model.getValueAt(i, 0);
        try {
            Connection c = KoneksiDatabase.getKoneksi();

            String sql = "delete  FROM pembayaran where PembayaranID = ?";

            PreparedStatement p = c.prepareStatement(sql);

            p.setString(1, PembayaranID);
            //ambil ID yang terseleksi

            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil DiHapus");
        }catch(SQLException e){
            System.out.println("Terjadi Eror");
            JOptionPane.showMessageDialog(null,"Data Gagal DiHapus");
        }finally {
            loadData();
        }
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        String PembayaranID = inputPembayaranId.getText();
        String PemeriksaanID = inputPemeriksaanId.getText();
        String Jumlah = inputJumlah.getText();
        String CaraPembayaran = inputCaraPembayaran.getText();
        String Tanggal = inputTanggal.getText();

        try {
            Connection c = KoneksiDatabase.getKoneksi();

            String sql = "insert into pembayaran values (?, ?, ?, ?, ?)";

            PreparedStatement p = c.prepareStatement(sql);

            p.setString(1, PembayaranID);
            p.setString(2, PemeriksaanID);
            p.setString(3, Jumlah);
            p.setString(4, CaraPembayaran);
            p.setString(5, Tanggal);

            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil DiTambah");
        }catch(SQLException e){
            System.out.println("Terjadi Eror");
            JOptionPane.showMessageDialog(null,"Data Gagal DiTambah");
        }finally {
            loadData();
        }
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        //ambil ID yang terseleksi
        int i = tabelPembayaran.getSelectedRow();
        if(i == -1){
            //tidak ada baris terseleksi
            return;
        }
        //ambil ID yang terseleksi
        String PembayaranID = (String) model.getValueAt(i, 0);
        String PemeriksaanID = inputPemeriksaanId.getText();
        String Jumlah = inputJumlah.getText();
        String CaraPembayaran = inputCaraPembayaran.getText();
        String Tanggal = inputTanggal.getText();

        try{
            Connection c = KoneksiDatabase.getKoneksi();

            String que = "update pembayaran set PemeriksaanID = ?, Jumlah = ?, CaraPembayaran = ?, Tanggal = ? where PembayaranID = ?";

            PreparedStatement p = c.prepareStatement(que);

            p.setString(1, PemeriksaanID);
            p.setString(2, Jumlah);
            p.setString(3, CaraPembayaran);
            p.setString(4, Tanggal);
            p.setString(5, PembayaranID);

            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil DiUbah");
        }catch (SQLException e){
            System.out.println("Terjadi Eror");
            JOptionPane.showMessageDialog(null,"Data Gagal DiUbah");
        }finally {
            loadData();
        }
    }//GEN-LAST:event_btnUbahMouseClicked

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
        dispose();
    }//GEN-LAST:event_btnkembaliActionPerformed

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
            java.util.logging.Logger.getLogger(FormPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton btnkembali;
    private javax.swing.JTextField inputCaraPembayaran;
    private javax.swing.JTextField inputJumlah;
    private javax.swing.JTextField inputPembayaranId;
    private javax.swing.JTextField inputPemeriksaanId;
    private javax.swing.JTextField inputTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelPembayaran;
    // End of variables declaration//GEN-END:variables
}
