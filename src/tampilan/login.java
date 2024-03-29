package tampilan;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import koneksi.koneksi;
import javax.swing.JOptionPane;

/**
 *
 * @author Fachmi
 */
public class login extends javax.swing.JFrame {
    String user="",pass="";
    private final Connection conn = new koneksi().connect();

    /**
     * Creates new form login
     */
    public login() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width / 6) - (getSize().width / 2), (dim.height / 2) - (getSize().height / 2));
        initComponents();
        tanggal();
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
    
       void tanggal() {
        java.util.Date tanggal = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EE , dd MMMM yyyy ");

        
        jLabel9.setText(sdf.format(tanggal));
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
        jLabelclose = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tuser = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        tpass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setBackground(new java.awt.Color(255, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(450, 350));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(450, 350));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 350));
        jPanel1.setLayout(null);

        jLabelclose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelclose.setText("X");
        jLabelclose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelcloseMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelclose);
        jLabelclose.setBounds(420, 10, 16, 29);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 255));
        jButton1.setText("Regis");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(250, 240, 80, 30);

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        jLabel1.setText("LOGIN");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(210, 40, 70, 21);

        jLabel9.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jLabel9.setText("field");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 310, 150, 17);

        tuser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tuser.setOpaque(false);
        tuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuserActionPerformed(evt);
            }
        });
        jPanel1.add(tuser);
        tuser.setBounds(150, 90, 190, 30);

        jCheckBox1.setFont(new java.awt.Font("Monotype Corsiva", 1, 12)); // NOI18N
        jCheckBox1.setText("Show Pass");
        jCheckBox1.setOpaque(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(360, 150, 90, 23);

        tpass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tpass.setOpaque(false);
        jPanel1.add(tpass);
        tpass.setBounds(150, 150, 190, 30);

        jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        jLabel3.setText("Username");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 100, 90, 21);

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(160, 120, 170, 10);

        jLabel4.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        jLabel4.setText("Password");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 160, 100, 21);

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(160, 180, 170, 10);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 255));
        jButton2.setText("Login");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setBorderPainted(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(140, 240, 80, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/penyewaanform.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.setMaximumSize(new java.awt.Dimension(450, 350));
        jLabel5.setMinimumSize(new java.awt.Dimension(450, 350));
        jLabel5.setName(""); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(450, 350));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 0, 550, 370);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 370));

        setSize(new java.awt.Dimension(466, 389));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        user = tuser.getText();
        pass = tpass.getText();

        String sql = "select * from user where username='"+user+"'and password='"+pass+"';";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if(hasil.next()){
                JOptionPane.showMessageDialog(null, "SELAMAT DATANG");
                new menu().setVisible(true);
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "LOGIN GAGAL");
                tuser.setText("");
                tpass.setText("");
                tuser.requestFocus(true);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "LOGIN GAGAL"+e);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code her
    }//GEN-LAST:event_jButton2MouseEntered

    private void jLabelcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelcloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelcloseMouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()){
            tpass.setEchoChar((char)0);
        }else{
            tpass.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void tuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tuserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        new regis().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed




    
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelclose;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField tpass;
    private javax.swing.JTextField tuser;
    // End of variables declaration//GEN-END:variables
}
