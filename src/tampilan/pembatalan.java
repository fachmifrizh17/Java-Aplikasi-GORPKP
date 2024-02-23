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
public class pembatalan extends javax.swing.JFrame {
private DefaultTableModel data;
Connection conn;
    Statement stm;
    ResultSet rs;
    /**
     * Creates new form pembatalan
     */
    public pembatalan() {
        initComponents();
        tabel();     
        block();
        nobatal();
        Selectpenyewa();
        Selectkaryawan();
        idkaryawan.setVisible(false);
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
        nobatal();
        idpenyewa.setSelectedIndex(0);
        karyawan.setSelectedIndex(0);
        nama.setText("");
        hp.setText("");
        fasilitas.setText("");
        keterangan.setText("");
        save.setEnabled(true);
        edit.setEnabled(false);
    }
protected void block(){
    idpembatalan.setEnabled(false);
    nama.setEnabled(false);
    hp.setEnabled(false);
    fasilitas.setEnabled(false);
    }

public void nobatal() {
        try {
        
            String sql = "SELECT * FROM pembatalan ORDER by id_pembatalan desc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet r = stat.executeQuery(sql);

            if (r.next()) {
                String nofak = r.getString("id_pembatalan").substring(1);
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

               idpembatalan.setText("B" + Nol + AN);
            } else {
                idpembatalan.setText("B0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }  

 private void Selectpenyewa(){
        try {
        
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM transaksi");
            
           idpenyewa.addItem("ID Pelanggan");
            while(rs.next()){
                idpenyewa.addItem(rs.getString("idpenyewa"));
                fasilitas.setText(rs.getString("fasilitas"));
            }
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }
 
 private void Selectkaryawan(){
        try {
        
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM karyawan");
            
           karyawan.addItem("Nama Karyawan");
            while(rs.next()){
                karyawan.addItem(rs.getString("nama"));
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

        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        hp = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        keterangan = new javax.swing.JTextArea();
        save = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        del = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        fasilitas = new javax.swing.JTextField();
        idpenyewa = new javax.swing.JComboBox<>();
        karyawan = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        idkaryawan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        idpembatalan = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PEMBATALAN");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jLabel7.setText("TABEL PEMBATALAN");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 170, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pembatalan.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, -1, -1));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.black));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("ID PEMESANAN");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel4.setText("NOMOR HP/WA");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel5.setText("NAMA KARYAWAN");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel6.setText("NAMA FASILITAS");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 119, 20));

        jLabel8.setText("KETERANGAN");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));
        jPanel2.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 150, -1));
        jPanel2.add(hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 150, -1));

        keterangan.setColumns(20);
        keterangan.setRows(5);
        jScrollPane4.setViewportView(keterangan);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 240, 70));

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
        jPanel2.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 70, -1));

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
        jPanel2.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 70, -1));

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
        jPanel2.add(del, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 70, -1));

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
        jPanel2.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 70, -1));

        fasilitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fasilitasActionPerformed(evt);
            }
        });
        jPanel2.add(fasilitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 150, -1));

        idpenyewa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                idpenyewaItemStateChanged(evt);
            }
        });
        jPanel2.add(idpenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 150, -1));

        karyawan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                karyawanItemStateChanged(evt);
            }
        });
        jPanel2.add(karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 150, -1));

        jLabel10.setText("NAMA PENYEWA");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));
        jPanel2.add(idkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 17, -1));

        jLabel11.setText("ID PEMBATALAN");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPanel2.add(idpembatalan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 490, 430));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jLabel2.setText("PEMBATALAN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, 190, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 20, -1, -1));

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
        tabel.setOpaque(false);
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, 830, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/penyewaanform.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1100, 700));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        this.setVisible(false);
        new menu().setVisible(true);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        String sql = "insert into pembatalan values (?,?,?,?,?,?,?)";
        String reportSource = null;
        String reportDest = null;
        HashMap parameter = new HashMap();
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, idpembatalan.getText());
            stat.setString(2, idpenyewa.getSelectedItem().toString());
            stat.setString(3, karyawan.getSelectedItem().toString());
            stat.setString(4, nama.getText());
            stat.setString(5, hp.getText());
            stat.setString(6, fasilitas.getText());
            stat.setString(7, keterangan.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "YAKIN MELAKUKAN PEMBATALAN?");

        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "DATA GAGAL DISIMPAN"+e);

        }
        tabel();
        kosong();
        nobatal();
        idpenyewa.requestFocus();
        tabel();
    }//GEN-LAST:event_saveActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        int ok=JOptionPane.showConfirmDialog(null,"Apakah Yakin Untuk Update data ini???","Confirmation",JOptionPane.YES_NO_OPTION);
         try
            {
                String sql="update pembatalan set nama_penyewa=?,telefon=?,fasilitas=?, keterangan=? where nama_penyewa='"+nama.getText()+"'";
                PreparedStatement st=conn.prepareStatement(sql);
                if(ok==0)
                {
                try
                    {
                        st.setString(1,nama.getText());
                        st.setString(2,hp.getText());
                        st.setString(3,fasilitas.getText());
                        st.setString(4,keterangan.getText());
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
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null,"Hapus data ini?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from pembatalan where nama_penyewa ='"+nama.getText()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data akan di hapus dari sistem?");
                kosong();
                nobatal();
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
        
        idpembatalan.setText(a);
        idpenyewa.setSelectedItem(b);
        karyawan.setSelectedItem(c);
        nama.setText(d);
        hp.setText(e);
        fasilitas.setText(f);
        keterangan.setText(g);
    }//GEN-LAST:event_tabelMouseClicked

    private void fasilitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fasilitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fasilitasActionPerformed

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
                java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM pemesanan WHERE id_penyewa='"+id_beli+"'");
                if(rs.next()){
                    nama.setText(rs.getString("nama"));
                    hp.setText(rs.getString("telepon"));
                    fasilitas.setText(rs.getString("nama_fasilitas"));
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
        }else{

        }
    
    }//GEN-LAST:event_idpenyewaItemStateChanged

    private void karyawanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_karyawanItemStateChanged
    String[] nama_fasilitas = karyawan.getSelectedItem().toString().split("//s+");
        String kode = nama_fasilitas[0];
        if(!kode.equals("Nama Karyawan")){
            try {
                String nama = "";
                String namakaryawan = karyawan.getSelectedItem().toString();
                switch(karyawan.getSelectedIndex()){
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
                java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM karyawan WHERE nama='"+namakaryawan+"'");
                if(rs.next()){;
                 idkaryawan.setText(rs.getString("id_karyawan"));
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
        }else{
            idkaryawan.setText("");
                }
    }//GEN-LAST:event_karyawanItemStateChanged
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
        Object header[]={"ID PEMBATALAN","ID PESANAN","NAMA KARYAWAN","NAMA PENYEWA","TELEPON","NAMA FASILITAS","KETERANGAN"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tabel.setModel(data);
        setKoneksi();
        String sql="select*from pembatalan";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString("id_pembatalan");
                String kolom2=rs.getString("idpemesanan");
                String kolom3=rs.getString("karyawan");  
                String kolom4=rs.getString("nama_penyewa");
                String kolom5=rs.getString("telefon");
                String kolom6=rs.getString("fasilitas");
                String kolom7=rs.getString("keterangan");
                
                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5,kolom6,kolom7};
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
            java.util.logging.Logger.getLogger(pembatalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pembatalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pembatalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pembatalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pembatalan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JButton del;
    private javax.swing.JButton edit;
    private javax.swing.JTextField fasilitas;
    private javax.swing.JTextField hp;
    private javax.swing.JTextField idkaryawan;
    private javax.swing.JTextField idpembatalan;
    private javax.swing.JComboBox<String> idpenyewa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox<String> karyawan;
    private javax.swing.JTextArea keterangan;
    private javax.swing.JTextField nama;
    private javax.swing.JButton save;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}