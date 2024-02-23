/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Fachmi Farizh
 */
public class memesan extends javax.swing.JFrame {
private DefaultTableModel data;
public String dateChooser;
    int harganya;
    int hargahitung,totalnya,totalfix,mayarnya,totalhitung,kembaliannya;
    Connection conn;
    Statement stm;
    ResultSet rs;
    private String tanggal;
    /**
     * Creates new form memesan
     */
    public memesan() {
        initComponents();
        tabel();     
        nofaktur();
        block();
        Selectfasilitas();
        Selectpenyewa();
        Selectbarang();
        isian.setVisible(false);
        idfasilitas.setVisible(false);
        diskonan = new ButtonGroup();
        ImageIcon img = new ImageIcon("src/foto/icon.png");
        this.setIconImage(img.getImage());
        initUI();
    }
    
     private void initUI(){ 
        getContentPane().setBackground(new Color(245, 245, 245));
        
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;    
        setLocation(dx, dy);
    }
    
     private void aktif(boolean x){
    idpenyewa.setEditable(x);
    }
protected void kosong(){
        nofaktur();
        idpenyewa.setSelectedIndex(0);
        nama.setText("");
        hp.setText("");
        alamat.setText("");
        tgl1.setDateFormatString("");
        nama_barang.setSelectedIndex(0);
        harga.setText("");
        fasilitas.setSelectedIndex(0);
        h_total.setText("");
        jumlah.setText("");
        save.setEnabled(true);
        edit.setEnabled(false);
    }
protected void block(){
    idpenyewaan.setEnabled(false);
    nama.setEnabled(false);
    hp.setEnabled(false);
    alamat.setEnabled(false);
    harga.setEnabled(false);
    }
   
    public void nofaktur() {
        try {
        
            String sql = "SELECT * FROM pemesanan ORDER by idpesanan desc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet r = stat.executeQuery(sql);

            if (r.next()) {
                String nofak = r.getString("idpesanan").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

               idpenyewaan.setText("S" + Nol + AN);
            } else {
                idpenyewaan.setText("S0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }  
 private void Selectfasilitas(){
        try {
        
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM fasilitas");
            
           fasilitas.addItem("Pilih Fasilitas");
            while(rs.next()){
                fasilitas.addItem(rs.getString("nama"));
            }
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }
 
 
  private void Selectpenyewa(){
        try {
        
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM penyewa");
            
           idpenyewa.addItem("ID Pelanggan");
            while(rs.next()){
                idpenyewa.addItem(rs.getString("id_penyewa"));
            }
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }
  
  private void Selectbarang(){
        try {
        
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM gudang");
            
           nama_barang.addItem("Fasilitas Tambahan");
            while(rs.next()){
                nama_barang.addItem(rs.getString("nama_barang"));
            }
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
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

        diskonan = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        nama = new javax.swing.JTextField();
        hp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        del = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        harga = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        idpenyewaan = new javax.swing.JTextField();
        fasilitas = new javax.swing.JComboBox<>();
        idfasilitas = new javax.swing.JTextField();
        idpenyewa = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tgl1 = new com.toedter.calendar.JDateChooser();
        h_total = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jumlah = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nama_barang = new javax.swing.JComboBox<>();
        isian = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PEMESANAN");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jLabel5.setText("TABEL PENYEWAAN");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 150, -1));

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 1, 48)); // NOI18N
        jLabel2.setText("Pemesanan");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 230, -1));

        jLabel15.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, -1, -1));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, null, java.awt.Color.cyan, java.awt.Color.black));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("ID PENYEWA");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel4.setText("NOMOR HP/WA");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel6.setText("TAMBAHAN");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 119, 20));

        alamat.setColumns(20);
        alamat.setRows(5);
        jScrollPane3.setViewportView(alamat);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 210, 60));
        jPanel2.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 150, -1));
        jPanel2.add(hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 150, -1));

        jLabel9.setText("ALAMAT");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        save.setBackground(new java.awt.Color(255, 255, 102));
        save.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        save.setText("SIMPAN");
        save.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        save.setBorderPainted(false);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel2.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 70, -1));

        edit.setBackground(new java.awt.Color(255, 255, 102));
        edit.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        edit.setText("UBAH");
        edit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edit.setBorderPainted(false);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel2.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 70, -1));

        del.setBackground(new java.awt.Color(255, 255, 102));
        del.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        del.setText("HAPUS");
        del.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        del.setBorderPainted(false);
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });
        jPanel2.add(del, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 70, -1));

        clear.setBackground(new java.awt.Color(255, 255, 102));
        clear.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        clear.setText("BATAL");
        clear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clear.setBorderPainted(false);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel2.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 270, 70, -1));

        harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaActionPerformed(evt);
            }
        });
        harga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hargaKeyReleased(evt);
            }
        });
        jPanel2.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 180, -1));

        jLabel12.setText("ID PENYEWAAN");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 29, -1, -1));
        jPanel2.add(idpenyewaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, -1));

        fasilitas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fasilitasItemStateChanged(evt);
            }
        });
        jPanel2.add(fasilitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 144, -1));
        jPanel2.add(idfasilitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 17, -1));

        idpenyewa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                idpenyewaItemStateChanged(evt);
            }
        });
        jPanel2.add(idpenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 150, -1));

        jLabel14.setText("HARGA");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        jLabel7.setText("TANGGAL PEMESANAN");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        tgl1.setDateFormatString("yyyy-MM-dd");
        tgl1.setMaxSelectableDate(new java.util.Date(253370743307000L));
        tgl1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl1PropertyChange(evt);
            }
        });
        jPanel2.add(tgl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 180, -1));

        h_total.setText("0");
        jPanel2.add(h_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, -1));

        jLabel11.setText("Total");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 102));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("TOTAL");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jumlahKeyReleased(evt);
            }
        });
        jPanel2.add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 180, -1));

        jLabel10.setText("BERAPA HARI");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        jLabel13.setText("NAMA PENYEWA");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel8.setText("NAMA FASILITAS");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 119, 20));

        nama_barang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nama_barangItemStateChanged(evt);
            }
        });
        jPanel2.add(nama_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 140, -1));
        jPanel2.add(isian, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 20, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 690, 350));

        tabel.setBackground(new java.awt.Color(255, 255, 102));
        tabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.black));
        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 1060, 94));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/penyewaanform.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(1100, 700));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
 SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = "";
        tanggal = Format.format(tgl1.getDate());
        String sql = "insert into pemesanan values (?,?,?,?,?,?,?,?,?,?,?,?)";
        String reportSource = null;
        String reportDest = null;
        HashMap parameter = new HashMap();
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, idpenyewaan.getText());
            stat.setString(2, idpenyewa.getSelectedItem().toString());
            stat.setString(3, nama.getText());
            stat.setString(4, hp.getText());
            stat.setString(5, alamat.getText());
            stat.setString(6, idfasilitas.getText());
            stat.setString(7, fasilitas.getSelectedItem().toString());
            stat.setString(8, tanggal);
            stat.setString(9, nama_barang.getSelectedItem().toString());
            stat.setString(10, harga.getText());
            stat.setString(11, jumlah.getText());
            stat.setString(12, h_total.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data akan disimpan");

        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal disimpan"+e);

        }
        tabel();
        nofaktur();
        nofaktur();
        kosong();
        idpenyewa.requestFocus();
        tabel();
    }//GEN-LAST:event_saveActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        int ok=JOptionPane.showConfirmDialog(null,"Apakah Yakin Untuk Update data ini???","Confirmation",JOptionPane.YES_NO_OPTION);
         try
            {
                String sql="update pemesanan set jumlah=? where jumlah='"+jumlah.getText()+"'";
                PreparedStatement st=conn.prepareStatement(sql);
                if(ok==0)
                {
                try
                    {
                        st.setString(1,jumlah.getText());
                        st.executeUpdate();

                        JOptionPane.showMessageDialog(null,"Update Data Sukses");
                    }catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(null, "Update Data Gagal");
                    }
                }
           }catch (Exception e){}
    }//GEN-LAST:event_editActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
       int ok = JOptionPane.showConfirmDialog(null,"Hapus data ini?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from pemesanan where id_penyewa ='"+idpenyewa.getSelectedItem()+"'";
            String sql2 = "delete from transaksi where idpenyewa ='"+idpenyewa.getSelectedItem()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                PreparedStatement stat2 = conn.prepareStatement(sql2);
                stat.executeUpdate();
                stat2.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data akan di hapus dari sistem?");
                nofaktur();
                kosong();
                idpenyewa.requestFocus();

            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
            tabel();

        }
    }//GEN-LAST:event_delActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        kosong();
        tabel();
    }//GEN-LAST:event_clearActionPerformed

    private void hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaActionPerformed

    private void hargaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaKeyReleased

    }//GEN-LAST:event_hargaKeyReleased

    private void fasilitasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fasilitasItemStateChanged
        String[] nama_fasilitas = fasilitas.getSelectedItem().toString().split("//s+");
        String kode = nama_fasilitas[0];
        if(!kode.equals("Pilih Fasilitas")){
            try {
                String kode_paket = "";
                String namafasilitass = fasilitas.getSelectedItem().toString();
                switch(fasilitas.getSelectedIndex()){
                    case 1: kode_paket = "1"; break;
                    case 2: kode_paket = "2"; break;
                    case 3: kode_paket = "3"; break;
                    case 4: kode_paket = "4"; break;
                    case 5: kode_paket = "5"; break;
                    case 6: kode_paket = "6"; break;
                    case 7: kode_paket = "7"; break;
                    case 8: kode_paket = "8"; break;
                    case 9: kode_paket = "9"; break;
                    case 10: kode_paket = "10"; break;
                    case 11: kode_paket = "11"; break;
                    case 12: kode_paket = "12"; break;
                }
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM fasilitas WHERE nama='"+namafasilitass+"'");
                if(rs.next()){
                    idfasilitas.setText(rs.getString("kode_fasilitas"));

                    harga.setText(rs.getString("harga"));
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
        }else{
            idfasilitas.setText("");
        }
    }//GEN-LAST:event_fasilitasItemStateChanged

    private void idpenyewaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_idpenyewaItemStateChanged
        String[] nama_pembeli = idpenyewa.getSelectedItem().toString().split("//s+");
        String kode = nama_pembeli[0];
        if(!kode.equals("ID Penyewa")){
            try {
                String id_pembelii = "";
                String id_beli = idpenyewa.getSelectedItem().toString();
                switch(idpenyewa.getSelectedIndex()){
                    case 1: id_pembelii = "1"; break;
                    case 2: id_pembelii = "2"; break;
                    case 3: id_pembelii = "3"; break;
                    case 4: id_pembelii = "4"; break;
                    case 5: id_pembelii = "5"; break;
                    case 6: id_pembelii = "6"; break;
                    case 7: id_pembelii = "7"; break;
                    case 8: id_pembelii = "8"; break;
                    case 9: id_pembelii = "9"; break;
                    case 10: id_pembelii = "10"; break;
                    case 11: id_pembelii = "11"; break;
                    case 12: id_pembelii = "12"; break;
                }
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM penyewa WHERE id_penyewa='"+id_beli+"'");
                if(rs.next()){
                    nama.setText(rs.getString("nama"));
                    hp.setText(rs.getString("telefon"));
                    alamat.setText(rs.getString("alamat"));
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
        }else{

        }
    }//GEN-LAST:event_idpenyewaItemStateChanged

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
     save.setEnabled(false);
        edit.setEnabled(true);
        int bar = tabel.getSelectedRow();
        String a = tabel.getValueAt(bar, 0).toString ();
        String b = tabel.getValueAt(bar, 1).toString ();
        String c = tabel.getValueAt(bar, 2).toString ();
        String d = tabel.getValueAt(bar, 3).toString ();
        String e = tabel.getValueAt(bar, 4).toString ();
        String f = tabel.getValueAt(bar, 5).toString ();
        String g = tabel.getValueAt(bar, 6).toString ();
        String h = tabel.getValueAt(bar, 7).toString ();
        String i = tabel.getValueAt(bar, 8).toString ();
        String j = tabel.getValueAt(bar, 9).toString ();
        String k = tabel.getValueAt(bar, 10).toString ();
        String l = tabel.getValueAt(bar, 11).toString ();
        
        idpenyewaan.setText(a);
        idpenyewa.setSelectedItem(b);
        nama.setText(c);
        hp.setText(d);
        alamat.setText(e);
        idfasilitas.setText(f);
        fasilitas.setSelectedItem(g);
        tgl1.setDateFormatString(h);
        nama_barang.setSelectedItem(i);
        harga.setText(j);
        jumlah.setText(k);
        h_total.setText(l);
    }//GEN-LAST:event_tabelMouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        this.setVisible(false);
        new menu().setVisible(true);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void tgl1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl1PropertyChange
    if(tgl1.getDate()!=null){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dateChooser=format.format(tgl1.getDate());
    }
    }//GEN-LAST:event_tgl1PropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String a = harga.getText();
        int aa = Integer.parseInt(a);
        
        String b = jumlah.getText();
        int bb = Integer.parseInt(b);

        int hargaa,jumlahh,total;

        hargaa = Integer.parseInt(harga.getText().toString());
        jumlahh = Integer.parseInt(jumlah.getText().toString());
        total = jumlahh*hargaa;
            h_total.setText(Integer.toString(total));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahKeyReleased
        String a = jumlah.getText();
        int aa = Integer.parseInt(a);

        String b = harga.getText();
        int bb = Integer.parseInt(b);

        int jumlahh,hargaa,totall,diskonn1,diskonn2;
        hargaa = Integer.parseInt(harga.getText().toString());
        jumlahh = Integer.parseInt(jumlah.getText().toString());
       
        totall = jumlahh-hargaa;

        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahKeyReleased

    private void nama_barangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nama_barangItemStateChanged
    String[] barang = nama_barang.getSelectedItem().toString().split("//s+");
        String kode = barang[0];
        if(!kode.equals("Nama Barang")){
            try {
                String nama = "";
                String namabarang = nama_barang.getSelectedItem().toString();
                switch(nama_barang.getSelectedIndex()){
                    case 1: nama = "1"; break;
                    case 2: nama = "2"; break;
                    case 3: nama = "3"; break;
                    case 4: nama = "4"; break;
                    case 5: nama = "5"; break;
                    case 6: nama = "6"; break;
                    case 7: nama = "7"; break;
                    case 8: nama = "8"; break;
                    case 9: nama = "9"; break;
                    case 10: nama = "10"; break;
                    case 11: nama = "11"; break;
                    case 12: nama = "12"; break;
                }
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM gudang WHERE nama_barang='"+namabarang+"'");
                if(rs.next()){;
                 isian.setText(rs.getString("kode_barang"));
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
        }else{
            isian.setText("");
        } 
    }//GEN-LAST:event_nama_barangItemStateChanged
public Connection setKoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/pkp","root","");
            stm=conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Koneksi Gagal :" +e);
        }
       return conn; 
    }
    
    public void tabel(){
        Object header[]={"ID PESANAN","ID PEMESAN","NAMA","TELEPON","ALAMAT","ID FASILITAS","NAMA FASILITAS","TANGGAL",",TAMBAHAN","HARGA","JUMLAH","TOTAL"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tabel.setModel(data);
        setKoneksi();
        String sql="select*from pemesanan";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString("idpesanan");
                String kolom2=rs.getString("id_penyewa");
                String kolom3=rs.getString("nama");
                String kolom4=rs.getString("telepon");
                String kolom5=rs.getString("alamat");
                String kolom6=rs.getString("kode_fasilitas");
                String kolom7=rs.getString("nama_fasilitas");
                String kolom8=rs.getString("tanggal");
                String kolom9=rs.getString("tambahan");
                String kolom10=rs.getString("harga");
                String kolom11=rs.getString("jumlah");
                String kolom12=rs.getString("total");
                
                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5,kolom6,kolom7,kolom8,kolom9,kolom10,kolom11,kolom12};
                data.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
        }
    }
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
            java.util.logging.Logger.getLogger(memesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(memesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(memesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(memesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new memesan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat;
    private javax.swing.JButton clear;
    private javax.swing.JButton del;
    private javax.swing.ButtonGroup diskonan;
    private javax.swing.JButton edit;
    private javax.swing.JComboBox<String> fasilitas;
    private javax.swing.JLabel h_total;
    private javax.swing.JTextField harga;
    private javax.swing.JTextField hp;
    private javax.swing.JTextField idfasilitas;
    private javax.swing.JComboBox<String> idpenyewa;
    private javax.swing.JTextField idpenyewaan;
    private javax.swing.JTextField isian;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField nama;
    private javax.swing.JComboBox<String> nama_barang;
    private javax.swing.JButton save;
    private javax.swing.JTable tabel;
    private com.toedter.calendar.JDateChooser tgl1;
    // End of variables declaration//GEN-END:variables
}
