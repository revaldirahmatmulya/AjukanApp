/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

/**
 *
 * @author Revaldi
 */
public class Halaman_awal extends javax.swing.JFrame {

    /**
     * Creates new form data_diri
     */
    public Halaman_awal() {
        initComponents();
    }
    private void input_data(String a,String b,String c,String d){
        formulir form = new formulir();
        
        form.setNama(a);
        form.setNIM(b);
        form.setJurusan(c);
        form.setFakultas(d);
        
        form.printData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_dataNama = new javax.swing.JTextField();
        txt_dataNIM = new javax.swing.JTextField();
        txt_dataJurusan = new javax.swing.JTextField();
        txt_dataFakultas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Data Diri");
        jLabel1.setPreferredSize(new java.awt.Dimension(105, 35));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 140, -1));

        txt_dataNama.setBackground(new java.awt.Color(255, 255, 255));
        txt_dataNama.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_dataNama.setBorder(null);
        jPanel2.add(txt_dataNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 155, 350, -1));

        txt_dataNIM.setBackground(new java.awt.Color(255, 255, 255));
        txt_dataNIM.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_dataNIM.setBorder(null);
        jPanel2.add(txt_dataNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 235, 350, -1));

        txt_dataJurusan.setBackground(new java.awt.Color(255, 255, 255));
        txt_dataJurusan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_dataJurusan.setBorder(null);
        jPanel2.add(txt_dataJurusan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 315, 350, -1));

        txt_dataFakultas.setBackground(new java.awt.Color(255, 255, 255));
        txt_dataFakultas.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_dataFakultas.setBorder(null);
        jPanel2.add(txt_dataFakultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 395, 350, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nama :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("NIM :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Jurusan :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 310, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Fakultas :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 390, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 350, 10));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 350, 10));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 350, 10));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 350, 10));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Selanjutnya");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 100, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bg.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        
//        String dataNama = txt_dataNama.getText();
//        String dataNIM = txt_dataNIM.getText();
//        String dataJurusan = txt_dataJurusan.getText();
//        String dataFakultas = txt_dataFakultas.getText();
//        
//        input_data(dataNama, dataNIM, dataJurusan, dataFakultas);
//        MainForm x = new MainForm(dataNama,dataNIM,dataJurusan,dataFakultas);
//        x.setVisible(true);
//        this.dispose();
          
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
            java.util.logging.Logger.getLogger(Halaman_awal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Halaman_awal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Halaman_awal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Halaman_awal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Halaman_awal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField txt_dataFakultas;
    private javax.swing.JTextField txt_dataJurusan;
    private javax.swing.JTextField txt_dataNIM;
    private javax.swing.JTextField txt_dataNama;
    // End of variables declaration//GEN-END:variables
}