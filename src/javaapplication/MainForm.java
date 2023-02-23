/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicLabelUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Revaldi
 */
public class MainForm extends javax.swing.JFrame {
   
    /**
     * Creates new form NewJFrame
     */
    public MainForm() {
        initComponents();
        kosongkanform();
        tampilkan_data_skripsi();
        tampilkan_data_pkl();
        JLabel [] btns = {homeBtn,skripsiBtn,pklBtn,listBtn};
        for (JLabel btn : btns){
            btn.setBackground(new Color(60,129,75));
            btn.setUI(new BasicLabelUI());
            btn.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    btn.setBackground(new Color(60,100,75));
                }

                @Override
                public void mousePressed(MouseEvent me) {
                }

                @Override
                public void mouseReleased(MouseEvent me) {
                    btn.setBackground(new Color(60,129,75));
                }

                @Override
                public void mouseEntered(MouseEvent me) {
                    btn.setBackground(new Color(60,100,75));
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    btn.setBackground(new Color(60,129,75));
                }
            });
        }
        
        //nonaktifkan maximize
//        setExtendedState(JFrame.MAXIMIZED_VERT);
//        setVisible(true);
//        setResizable(false);
        
        //judul aplikasi
        setTitle("Aplikasi Pengajuan Skripsi dan Tempat PKL");
        
        //setting jLabel
//        jLabel14.setText(input_labelNama);
//        jLabel16.setText(input_labelNIM);
//        jLabel17.setText(input_labelJurusan);
//        jLabel18.setText(input_labelFakultas);
        
    }

//    private MainForm() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    private void kosongkanform(){
        txtNama.setText(null);
        txtNIM.setText(null);
        txtJurusan.setText(null);
//        txtFakultas.setText(null);
//        txtJudul.setText(null);
//        txtDosenwali.setText(null);
        txtNama2.setText(null);
        txtNIM2.setText(null);
        txtFakultas2.setText(null);
        txtJurusan2.setText(null);
        txtKota.setText(null);
        txtTempat.setText(null);
        txtSKS.setText(null);
    }
    private void tampilkan_data_skripsi(){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("Nama");
        model.addColumn("NIM");
        model.addColumn("Jurusan");
        model.addColumn("Fakultas");
        model.addColumn("Judul Skripsi");
        model.addColumn("Dosen Wali");
        
        try {
            int no=1;
            String sql = "SELECT * FROM skripsi WHERE nama LIKE '%"
                    +jTxtCari.getText()+"%'"
                    + "OR nim LIKE '%"
                    + jTxtCari.getText()+"%'";
                     
            java.sql.Connection conn = (Connection)konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res;
            res = stm.executeQuery(sql);
            
            while (res.next()){
                model.addRow(new Object[]{no++,res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6)});
            }
            jTable1.setModel(model);
            
        }catch (SQLException e){
            System.out.println("gagal bos"+ e.getMessage());
        }
    }
     private void tampilkan_data_pkl(){
        
        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("No.");
        model2.addColumn("Nama");
        model2.addColumn("NIM");
        model2.addColumn("Jurusan");
        model2.addColumn("Fakultas");
        model2.addColumn("Kota Tujuan");
        model2.addColumn("Tempat PKL");
        model2.addColumn("Jumlah SKS");
        
        try {
            int no=1;
            String sql = "SELECT * FROM pkl WHERE nama LIKE '%"
                    +jTxtCari2.getText()+"%'"
                    + "OR nim LIKE '%"
                    + jTxtCari2.getText()+"%'";
                     
            java.sql.Connection conn = (Connection)konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res;
            res = stm.executeQuery(sql);
            
            while (res.next()){
                model2.addRow(new Object[]{no++,res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7)});
            }
            jTable2.setModel(model2);
            
        }catch (SQLException e){
            System.out.println("gagal bos"+ e.getMessage());
        }
    }
   
    private void input_skripsi(String a,String b,String c,String d,String e,String f){
        formulir form1 = new pengajuan_skripsi();
        form1.setNama(a);
        form1.setNIM(b);
        form1.setJurusan(c);
        form1.setFakultas(d);
        form1.setJudul(e);
        form1.setDosenwali(f);
        
        form1.printData();
    }
    
    private void input_pkl(String a,String b,String c,String d,String e,String f,String g){
        formulir form2 = new pengajuan_pkl();
        form2.setNama(a);
        form2.setNIM(b);
        form2.setJurusan(c);
        form2.setFakultas(d);
        form2.setKotaPKL(e);
        form2.setTempatPKL(f);
        form2.setSKS(g);
        
        form2.printData();
    }
    
    
    //mengganti warna button
    public void setlblColor(JLabel lbl){
        lbl.setBackground(new Color(60,100,75));
    }
    public void resetlblColor(JLabel lbl){
        lbl.setBackground(new Color(60,129,75));
    }
    
   //akhir
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator13 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        bodyPanel = new javax.swing.JPanel();
        sidebarPanel = new javax.swing.JPanel();
        skripsiBtn = new javax.swing.JLabel();
        pklBtn = new javax.swing.JLabel();
        listBtn = new javax.swing.JLabel();
        homeBtn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        mainPanel = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        skripsiPanel = new javax.swing.JPanel();
        panel_pelanggan = new javax.swing.JPanel();
        txtNama = new javax.swing.JTextField();
        jLabel2_skripsi = new javax.swing.JLabel();
        txtNIM = new javax.swing.JTextField();
        jLabel3_skripsi = new javax.swing.JLabel();
        txtJurusan = new javax.swing.JTextField();
        jLabel4_skripsi = new javax.swing.JLabel();
        printBtn_skripsi = new javax.swing.JButton();
        simpanBtn_skripsi = new javax.swing.JButton();
        kosongkanBtn_skripsi = new javax.swing.JButton();
        ubahBtn_skripsi = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        panel_barang = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        barang_btn = new javax.swing.JButton();
        pelanggan_btn = new javax.swing.JButton();
        pklPanel = new javax.swing.JPanel();
        txtNama2 = new javax.swing.JTextField();
        jLabel1_pkl = new javax.swing.JLabel();
        txtNIM2 = new javax.swing.JTextField();
        jLabel2_pkl = new javax.swing.JLabel();
        jLabel3_pkl = new javax.swing.JLabel();
        txtJurusan2 = new javax.swing.JTextField();
        txtFakultas2 = new javax.swing.JTextField();
        jTxtField4_pkl = new javax.swing.JLabel();
        jLabel5_pkl = new javax.swing.JLabel();
        txtKota = new javax.swing.JTextField();
        txtTempat = new javax.swing.JTextField();
        jLabel6_pkl = new javax.swing.JLabel();
        jLabel7_pkl = new javax.swing.JLabel();
        txtSKS = new javax.swing.JTextField();
        simpanBtn_pkl = new javax.swing.JButton();
        printBtn_pkl = new javax.swing.JButton();
        kosongkanBtn_pkl = new javax.swing.JButton();
        ubahBtn_pkl = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        listPanel = new javax.swing.JPanel();
        mainTabel = new javax.swing.JPanel();
        listSkripsi_view = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTxtCari = new javax.swing.JTextField();
        skripsiCari_btn = new javax.swing.JButton();
        skripsiHapus_btn = new javax.swing.JButton();
        listPkl_view = new javax.swing.JPanel();
        jTxtCari2 = new javax.swing.JTextField();
        pklCari_btn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        pklHapus_btn = new javax.swing.JButton();
        listPkl_btn = new javax.swing.JButton();
        listSkripsi_btn = new javax.swing.JButton();

        jLabel15.setText("jLabel15");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Pengajuan Skripsi dan Tempat PKL");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bodyPanel.setBackground(new java.awt.Color(255, 255, 255));
        bodyPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidebarPanel.setBackground(new java.awt.Color(60, 129, 75));
        sidebarPanel.setPreferredSize(new java.awt.Dimension(300, 600));
        sidebarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        skripsiBtn.setBackground(new java.awt.Color(60, 129, 75));
        skripsiBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        skripsiBtn.setForeground(new java.awt.Color(255, 255, 255));
        skripsiBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        skripsiBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_add_white_36dp.png"))); // NOI18N
        skripsiBtn.setText("   SKRIPSI");
        skripsiBtn.setOpaque(true);
        skripsiBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                skripsiBtnMouseClicked(evt);
            }
        });
        sidebarPanel.add(skripsiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 280, 50));

        pklBtn.setBackground(new java.awt.Color(60, 129, 75));
        pklBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pklBtn.setForeground(new java.awt.Color(255, 255, 255));
        pklBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pklBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_add_white_36dp.png"))); // NOI18N
        pklBtn.setText("   PKL");
        pklBtn.setOpaque(true);
        pklBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pklBtnMouseClicked(evt);
            }
        });
        sidebarPanel.add(pklBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 280, 50));

        listBtn.setBackground(new java.awt.Color(60, 129, 75));
        listBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        listBtn.setForeground(new java.awt.Color(255, 255, 255));
        listBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        listBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_toc_white_36dp.png"))); // NOI18N
        listBtn.setText("   LIST");
        listBtn.setOpaque(true);
        listBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listBtnMouseClicked(evt);
            }
        });
        sidebarPanel.add(listBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 280, 50));

        homeBtn.setBackground(new java.awt.Color(60, 129, 75));
        homeBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        homeBtn.setForeground(new java.awt.Color(255, 255, 255));
        homeBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_home_white_36dp.png"))); // NOI18N
        homeBtn.setText("   HOME");
        homeBtn.setOpaque(true);
        homeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeBtnMouseClicked(evt);
            }
        });
        sidebarPanel.add(homeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 280, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/uin2x_150x150.png"))); // NOI18N
        sidebarPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 30, -1, 150));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Universitas Islam Negeri");
        sidebarPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Maulana Malik Ibrahim");
        sidebarPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jSeparator2.setPreferredSize(new java.awt.Dimension(100, 10));
        sidebarPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 250, -1));

        bodyPanel.add(sidebarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 600));

        mainPanel.setBackground(new java.awt.Color(102, 102, 255));
        mainPanel.setLayout(new java.awt.CardLayout());

        homePanel.setBackground(new java.awt.Color(255, 255, 255));
        homePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-home-page-100.png"))); // NOI18N
        jLabel8.setAlignmentX(30.0F);
        jLabel8.setAlignmentY(100.0F);
        homePanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, -1, -1));

        jPanel1.setBackground(new java.awt.Color(80, 140, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Get Started");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 6, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 57, 306, 10));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Selamat Datang !");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 72, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Di aplikasi pengajuan SKRIPSI dan tempat PKL");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, -1, -1));

        homePanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 720, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Nama :");
        homePanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 265, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("NIM :");
        homePanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 325, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Jurusan :");
        homePanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 385, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Fakultas :");
        homePanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 445, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("jLabel14");
        homePanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 265, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("jLabel16");
        homePanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 325, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("jLabel17");
        homePanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 385, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("jLabel18");
        homePanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 445, -1, -1));

        mainPanel.add(homePanel, "card5");

        skripsiPanel.setBackground(new java.awt.Color(255, 255, 255));
        skripsiPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_pelanggan.setBackground(new java.awt.Color(51, 255, 255));
        panel_pelanggan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNama.setBackground(new java.awt.Color(255, 255, 255));
        txtNama.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtNama.setForeground(new java.awt.Color(0, 0, 0));
        txtNama.setBorder(null);
        panel_pelanggan.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 380, -1));

        jLabel2_skripsi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2_skripsi.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2_skripsi.setText("NAMA :");
        panel_pelanggan.add(jLabel2_skripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        txtNIM.setBackground(new java.awt.Color(255, 255, 255));
        txtNIM.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtNIM.setForeground(new java.awt.Color(0, 0, 0));
        txtNIM.setBorder(null);
        panel_pelanggan.add(txtNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 380, -1));

        jLabel3_skripsi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3_skripsi.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3_skripsi.setText("EMAIL :");
        panel_pelanggan.add(jLabel3_skripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        txtJurusan.setBackground(new java.awt.Color(255, 255, 255));
        txtJurusan.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtJurusan.setForeground(new java.awt.Color(0, 0, 0));
        txtJurusan.setBorder(null);
        panel_pelanggan.add(txtJurusan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 380, -1));

        jLabel4_skripsi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4_skripsi.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4_skripsi.setText("TELP :");
        panel_pelanggan.add(jLabel4_skripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        printBtn_skripsi.setBackground(new java.awt.Color(255, 255, 255));
        printBtn_skripsi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        printBtn_skripsi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-print-52 (2).png"))); // NOI18N
        printBtn_skripsi.setText("PRINT");
        printBtn_skripsi.setPreferredSize(new java.awt.Dimension(100, 50));
        printBtn_skripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtn_skripsiActionPerformed(evt);
            }
        });
        panel_pelanggan.add(printBtn_skripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 140, -1));

        simpanBtn_skripsi.setBackground(new java.awt.Color(255, 255, 255));
        simpanBtn_skripsi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        simpanBtn_skripsi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-save-52 (2).png"))); // NOI18N
        simpanBtn_skripsi.setText("SIMPAN");
        simpanBtn_skripsi.setPreferredSize(new java.awt.Dimension(100, 50));
        simpanBtn_skripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBtn_skripsiActionPerformed(evt);
            }
        });
        panel_pelanggan.add(simpanBtn_skripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 140, -1));

        kosongkanBtn_skripsi.setBackground(new java.awt.Color(255, 255, 255));
        kosongkanBtn_skripsi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kosongkanBtn_skripsi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-clear-formatting-48 (1).png"))); // NOI18N
        kosongkanBtn_skripsi.setText("KOSONGKAN");
        kosongkanBtn_skripsi.setPreferredSize(new java.awt.Dimension(100, 50));
        kosongkanBtn_skripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kosongkanBtn_skripsiActionPerformed(evt);
            }
        });
        panel_pelanggan.add(kosongkanBtn_skripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 170, -1));

        ubahBtn_skripsi.setBackground(new java.awt.Color(255, 255, 255));
        ubahBtn_skripsi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ubahBtn_skripsi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-edit-64 (1).png"))); // NOI18N
        ubahBtn_skripsi.setText("UBAH");
        ubahBtn_skripsi.setPreferredSize(new java.awt.Dimension(100, 50));
        ubahBtn_skripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahBtn_skripsiActionPerformed(evt);
            }
        });
        panel_pelanggan.add(ubahBtn_skripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 130, -1));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOpaque(true);
        panel_pelanggan.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 380, 2));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setOpaque(true);
        panel_pelanggan.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 380, 2));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setOpaque(true);
        panel_pelanggan.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 380, 2));

        panel_barang.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout panel_barangLayout = new javax.swing.GroupLayout(panel_barang);
        panel_barang.setLayout(panel_barangLayout);
        panel_barangLayout.setHorizontalGroup(
            panel_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        panel_barangLayout.setVerticalGroup(
            panel_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        panel_pelanggan.add(panel_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        skripsiPanel.add(panel_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 720, 480));

        jPanel2.setBackground(new java.awt.Color(80, 140, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Halaman Pengajuan Skripsi");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 14, -1, -1));

        skripsiPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 610, 60));

        barang_btn.setText("Barang");
        barang_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barang_btnActionPerformed(evt);
            }
        });
        skripsiPanel.add(barang_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 90, 30));

        pelanggan_btn.setText("Pelanggan");
        pelanggan_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelanggan_btnActionPerformed(evt);
            }
        });
        skripsiPanel.add(pelanggan_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 30));

        mainPanel.add(skripsiPanel, "card2");

        pklPanel.setBackground(new java.awt.Color(255, 255, 255));
        pklPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNama2.setBackground(new java.awt.Color(255, 255, 255));
        txtNama2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtNama2.setBorder(null);
        pklPanel.add(txtNama2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 260, -1));

        jLabel1_pkl.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1_pkl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1_pkl.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1_pkl.setText("NAMA :");
        pklPanel.add(jLabel1_pkl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        txtNIM2.setBackground(new java.awt.Color(255, 255, 255));
        txtNIM2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtNIM2.setBorder(null);
        pklPanel.add(txtNIM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 260, -1));

        jLabel2_pkl.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2_pkl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2_pkl.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2_pkl.setText("NIM :");
        pklPanel.add(jLabel2_pkl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel3_pkl.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3_pkl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3_pkl.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3_pkl.setText("JURUSAN :");
        pklPanel.add(jLabel3_pkl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        txtJurusan2.setBackground(new java.awt.Color(255, 255, 255));
        txtJurusan2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtJurusan2.setBorder(null);
        pklPanel.add(txtJurusan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 260, -1));

        txtFakultas2.setBackground(new java.awt.Color(255, 255, 255));
        txtFakultas2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtFakultas2.setBorder(null);
        pklPanel.add(txtFakultas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 260, -1));

        jTxtField4_pkl.setBackground(new java.awt.Color(0, 0, 0));
        jTxtField4_pkl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jTxtField4_pkl.setForeground(new java.awt.Color(0, 0, 0));
        jTxtField4_pkl.setText("FAKULTAS :");
        pklPanel.add(jTxtField4_pkl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel5_pkl.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5_pkl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5_pkl.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5_pkl.setText("KOTA TUJUAN :");
        pklPanel.add(jLabel5_pkl, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        txtKota.setBackground(new java.awt.Color(255, 255, 255));
        txtKota.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtKota.setBorder(null);
        pklPanel.add(txtKota, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 260, -1));

        txtTempat.setBackground(new java.awt.Color(255, 255, 255));
        txtTempat.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtTempat.setBorder(null);
        pklPanel.add(txtTempat, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 260, -1));

        jLabel6_pkl.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6_pkl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6_pkl.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6_pkl.setText("TEMPAT :");
        pklPanel.add(jLabel6_pkl, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));

        jLabel7_pkl.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7_pkl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7_pkl.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7_pkl.setText("SKS :");
        pklPanel.add(jLabel7_pkl, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, -1, -1));

        txtSKS.setBackground(new java.awt.Color(255, 255, 255));
        txtSKS.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtSKS.setBorder(null);
        pklPanel.add(txtSKS, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 260, -1));

        simpanBtn_pkl.setBackground(new java.awt.Color(255, 255, 255));
        simpanBtn_pkl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        simpanBtn_pkl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-save-52 (2).png"))); // NOI18N
        simpanBtn_pkl.setText("SIMPAN");
        simpanBtn_pkl.setPreferredSize(new java.awt.Dimension(100, 50));
        simpanBtn_pkl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBtn_pklActionPerformed(evt);
            }
        });
        pklPanel.add(simpanBtn_pkl, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 140, -1));

        printBtn_pkl.setBackground(new java.awt.Color(255, 255, 255));
        printBtn_pkl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        printBtn_pkl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-print-52 (2).png"))); // NOI18N
        printBtn_pkl.setText("PRINT");
        printBtn_pkl.setPreferredSize(new java.awt.Dimension(100, 50));
        printBtn_pkl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtn_pklActionPerformed(evt);
            }
        });
        pklPanel.add(printBtn_pkl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 140, -1));

        kosongkanBtn_pkl.setBackground(new java.awt.Color(255, 255, 255));
        kosongkanBtn_pkl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kosongkanBtn_pkl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-clear-formatting-48 (1).png"))); // NOI18N
        kosongkanBtn_pkl.setText("KOSONGKAN");
        kosongkanBtn_pkl.setPreferredSize(new java.awt.Dimension(100, 50));
        kosongkanBtn_pkl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kosongkanBtn_pklActionPerformed(evt);
            }
        });
        pklPanel.add(kosongkanBtn_pkl, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 520, 170, -1));

        ubahBtn_pkl.setBackground(new java.awt.Color(255, 255, 255));
        ubahBtn_pkl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ubahBtn_pkl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-edit-64 (1).png"))); // NOI18N
        ubahBtn_pkl.setText("UBAH");
        ubahBtn_pkl.setPreferredSize(new java.awt.Dimension(100, 50));
        ubahBtn_pkl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahBtn_pklActionPerformed(evt);
            }
        });
        pklPanel.add(ubahBtn_pkl, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 130, -1));

        jPanel3.setBackground(new java.awt.Color(80, 140, 100));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Halaman Pengajuan Tempat PKL");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pklPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 610, 60));

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator10.setOpaque(true);
        pklPanel.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 260, 2));

        jSeparator11.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator11.setOpaque(true);
        pklPanel.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 260, 2));

        jSeparator12.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator12.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator12.setOpaque(true);
        pklPanel.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 260, 2));

        jSeparator14.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator14.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator14.setOpaque(true);
        pklPanel.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 260, 2));

        jSeparator15.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator15.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator15.setOpaque(true);
        pklPanel.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 260, 2));

        jSeparator16.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator16.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator16.setOpaque(true);
        pklPanel.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 260, 2));

        jSeparator17.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator17.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator17.setOpaque(true);
        pklPanel.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 260, 2));

        mainPanel.add(pklPanel, "card3");

        listPanel.setBackground(new java.awt.Color(80, 140, 100));

        mainTabel.setBackground(new java.awt.Color(102, 255, 255));
        mainTabel.setLayout(new java.awt.CardLayout());

        listSkripsi_view.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setOpaque(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTxtCari.setBackground(new java.awt.Color(255, 255, 255));

        skripsiCari_btn.setBackground(new java.awt.Color(255, 255, 255));
        skripsiCari_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        skripsiCari_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-search-client-96.png"))); // NOI18N
        skripsiCari_btn.setText("Cari");
        skripsiCari_btn.setOpaque(false);
        skripsiCari_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skripsiCari_btnActionPerformed(evt);
            }
        });

        skripsiHapus_btn.setBackground(new java.awt.Color(255, 255, 255));
        skripsiHapus_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        skripsiHapus_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-bin-100.png"))); // NOI18N
        skripsiHapus_btn.setText("Hapus");
        skripsiHapus_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skripsiHapus_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listSkripsi_viewLayout = new javax.swing.GroupLayout(listSkripsi_view);
        listSkripsi_view.setLayout(listSkripsi_viewLayout);
        listSkripsi_viewLayout.setHorizontalGroup(
            listSkripsi_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listSkripsi_viewLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(listSkripsi_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(listSkripsi_viewLayout.createSequentialGroup()
                        .addComponent(skripsiCari_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(skripsiHapus_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        listSkripsi_viewLayout.setVerticalGroup(
            listSkripsi_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listSkripsi_viewLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(listSkripsi_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(skripsiCari_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(skripsiHapus_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        mainTabel.add(listSkripsi_view, "card2");

        listPkl_view.setBackground(new java.awt.Color(255, 255, 255));

        jTxtCari2.setBackground(new java.awt.Color(255, 255, 255));
        jTxtCari2.setForeground(new java.awt.Color(0, 0, 0));

        pklCari_btn.setBackground(new java.awt.Color(255, 255, 255));
        pklCari_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pklCari_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-search-client-96.png"))); // NOI18N
        pklCari_btn.setText("Cari");
        pklCari_btn.setOpaque(false);
        pklCari_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pklCari_btnActionPerformed(evt);
            }
        });

        jTable2.setBackground(new java.awt.Color(255, 255, 255));
        jTable2.setForeground(new java.awt.Color(0, 0, 0));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        pklHapus_btn.setBackground(new java.awt.Color(255, 255, 255));
        pklHapus_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pklHapus_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-bin-100.png"))); // NOI18N
        pklHapus_btn.setText("Hapus");
        pklHapus_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pklHapus_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listPkl_viewLayout = new javax.swing.GroupLayout(listPkl_view);
        listPkl_view.setLayout(listPkl_viewLayout);
        listPkl_viewLayout.setHorizontalGroup(
            listPkl_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listPkl_viewLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(listPkl_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(listPkl_viewLayout.createSequentialGroup()
                        .addComponent(pklCari_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtCari2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(pklHapus_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        listPkl_viewLayout.setVerticalGroup(
            listPkl_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPkl_viewLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(listPkl_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pklCari_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCari2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pklHapus_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        mainTabel.add(listPkl_view, "card3");

        listPkl_btn.setBackground(new java.awt.Color(255, 255, 255));
        listPkl_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        listPkl_btn.setText("PKL");
        listPkl_btn.setOpaque(false);
        listPkl_btn.setPreferredSize(new java.awt.Dimension(120, 40));
        listPkl_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listPkl_btnActionPerformed(evt);
            }
        });

        listSkripsi_btn.setBackground(new java.awt.Color(255, 255, 255));
        listSkripsi_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        listSkripsi_btn.setText("SKRIPSI");
        listSkripsi_btn.setOpaque(false);
        listSkripsi_btn.setPreferredSize(new java.awt.Dimension(120, 40));
        listSkripsi_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listSkripsi_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(listSkripsi_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(listPkl_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listPanelLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listSkripsi_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listPkl_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(mainTabel, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPanel.add(listPanel, "card4");

        bodyPanel.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 720, 600));

        getContentPane().add(bodyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseClicked
        // TODO add your handling code here:
        //menghilangkan panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        //menambahkan panel
        mainPanel.add(homePanel);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        
    }//GEN-LAST:event_homeBtnMouseClicked

    private void skripsiBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skripsiBtnMouseClicked
        //menghilangkan panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        //menambahkan panel
        mainPanel.add(skripsiPanel);
        mainPanel.repaint();
        mainPanel.revalidate();

    }//GEN-LAST:event_skripsiBtnMouseClicked

    private void pklBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pklBtnMouseClicked
        //menghilangkan panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        //menambahkan panel
        mainPanel.add(pklPanel);
        mainPanel.repaint();
        mainPanel.revalidate();

    }//GEN-LAST:event_pklBtnMouseClicked

    private void listBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listBtnMouseClicked
        //menghilangkan panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        //menambahkan panel
        mainPanel.add(listPanel);
        mainPanel.repaint();
        mainPanel.revalidate();

    }//GEN-LAST:event_listBtnMouseClicked

    private void simpanBtn_pklActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBtn_pklActionPerformed
        try{
            String sql = "INSERT INTO pkl VALUES ('"
            + txtNama2.getText()
            +"','"+txtNIM2.getText()
            +"','"+txtFakultas2.getText()
            +"','"+txtKota.getText()
            +"','"+txtKota.getText()
            +"','"+txtTempat.getText()
            +"','"+txtSKS.getText()+
            "')";
            java.sql.Connection conn = (Connection)konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Proses simpan data berhasil");

        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        kosongkanform();
        tampilkan_data_pkl();
    }//GEN-LAST:event_simpanBtn_pklActionPerformed

    private void printBtn_pklActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtn_pklActionPerformed
        String inputNama = txtNama2.getText();
        String inputNIM = txtNIM2.getText();
        String inputJurusan = txtJurusan2.getText();
        String inputFakultas = txtFakultas2.getText();
        String inputKota = txtKota.getText(); 
        String inputTempat = txtTempat.getText();
        String inputSKS = txtSKS.getText();

        //output
        input_pkl(inputNama,inputNIM,inputJurusan,inputFakultas,inputKota,inputTempat,inputSKS);
    }//GEN-LAST:event_printBtn_pklActionPerformed

    private void listPkl_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listPkl_btnActionPerformed
        mainTabel.removeAll();
        mainTabel.repaint();
        mainTabel.revalidate();
        
        mainTabel.add(listPkl_view);
        mainTabel.repaint();
        mainTabel.revalidate();
    }//GEN-LAST:event_listPkl_btnActionPerformed

    private void listSkripsi_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listSkripsi_btnActionPerformed
        mainTabel.removeAll();
        mainTabel.repaint();
        mainTabel.revalidate();
        
        mainTabel.add(listSkripsi_view);
        mainTabel.repaint();
        mainTabel.revalidate();
    }//GEN-LAST:event_listSkripsi_btnActionPerformed

    private void skripsiCari_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skripsiCari_btnActionPerformed
        try{
            String sql = "SELECT * FROM skripsi WHERE nama LIKE '%"
                    +jTxtCari.getText()+"%'"
                    + "OR nim LIKE '%"
                    + jTxtCari.getText()+"%'";
            java.sql.Connection conn = (Connection)konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            
        } catch(HeadlessException | SQLException e){
         
            
        }
        tampilkan_data_skripsi();
        kosongkanform();
    }//GEN-LAST:event_skripsiCari_btnActionPerformed

    private void pklCari_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pklCari_btnActionPerformed
        try{
            String sql = "SELECT * FROM pkl WHERE nama LIKE '%"
                    +jTxtCari2.getText()+"%'"
                    + "OR nim LIKE '%"
                    + jTxtCari2.getText()+"%'";
            java.sql.Connection conn = (Connection)konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            
        } catch(HeadlessException | SQLException e){
         
            
        }
        tampilkan_data_pkl();
        kosongkanform();
    }//GEN-LAST:event_pklCari_btnActionPerformed

    private void kosongkanBtn_pklActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kosongkanBtn_pklActionPerformed
        kosongkanform();
    }//GEN-LAST:event_kosongkanBtn_pklActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int baris = jTable2.rowAtPoint(evt.getPoint());
        String nama = jTable2.getValueAt(baris,1).toString();
        txtNama2.setText(nama);
        
        String nim = jTable2.getValueAt(baris, 2).toString();
        txtNIM2.setText(nim);
        
        String jurusan = jTable2.getValueAt(baris, 3).toString();
        txtJurusan2.setText(jurusan);
        
        String fakultas = jTable2.getValueAt(baris, 4).toString();
        txtFakultas2.setText(fakultas);
        
        String kotaPKL = jTable2.getValueAt(baris, 5).toString();
        txtKota.setText(kotaPKL);
        
        String tempatPKL = jTable2.getValueAt(baris, 6).toString();
        txtTempat.setText(tempatPKL);
        
        String SKS = jTable2.getValueAt(baris, 7).toString();
        txtSKS.setText(SKS);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int baris = jTable1.rowAtPoint(evt.getPoint());
        String nama = jTable1.getValueAt(baris,1).toString();
        txtNama.setText(nama);

        String nim = jTable1.getValueAt(baris, 2).toString();
        txtNIM.setText(nim);

        String jurusan = jTable1.getValueAt(baris, 3).toString();
        txtJurusan.setText(jurusan);

//        String fakultas = jTable1.getValueAt(baris, 4).toString();
//        txtFakultas.setText(fakultas);
//
//        String judul = jTable1.getValueAt(baris, 5).toString();
//        txtJudul.setText(judul);
//
//        String dosen = jTable1.getValueAt(baris, 6).toString();
//        txtDosenwali.setText(dosen);

    }//GEN-LAST:event_jTable1MouseClicked

    private void ubahBtn_pklActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahBtn_pklActionPerformed
        try {
            String sql = "UPDATE pkl SET nama ='"+ txtNama2.getText()
                    +"', nim ='"+txtNIM2.getText()
                    +"', jurusan ='"+txtJurusan2.getText()
                    +"', fakultas ='"+txtFakultas2.getText()
                    +"', kota ='"+txtKota.getText()
                    +"', tempat ='"+txtTempat.getText()
                    +"', sks ='"+txtSKS.getText()
                    +"'  WHERE nama ='"+txtNama2.getText() + "'";
            java.sql.Connection conn = (Connection)konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(this, "Edit data berhasil !");
        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data_pkl();
        kosongkanform();
        
    }//GEN-LAST:event_ubahBtn_pklActionPerformed

    private void pklHapus_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pklHapus_btnActionPerformed
        try {
            String sql = "DELETE FROM pkl WHERE nama = '" + txtNama2.getText() + "'";
            java.sql.Connection conn = (Connection) konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "hapus data berhasil...");
        }catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data_pkl();
    }//GEN-LAST:event_pklHapus_btnActionPerformed

    private void skripsiHapus_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skripsiHapus_btnActionPerformed
        try {
            String sql = "DELETE FROM skripsi WHERE nama = '" + txtNama.getText() + "'";
            java.sql.Connection conn = (Connection) konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "hapus data berhasil...");
        }catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data_skripsi();
    }//GEN-LAST:event_skripsiHapus_btnActionPerformed

    private void pelanggan_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelanggan_btnActionPerformed
        mainTabel.removeAll();
        mainTabel.repaint();
        mainTabel.revalidate();
        
        mainTabel.add(panel_barang);
        mainTabel.repaint();
        mainTabel.revalidate();
    }//GEN-LAST:event_pelanggan_btnActionPerformed

    private void barang_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barang_btnActionPerformed
        mainTabel.removeAll();
        mainTabel.repaint();
        mainTabel.revalidate();
        
        mainTabel.add(panel_pelanggan);
        mainTabel.repaint();
        mainTabel.revalidate();
    }//GEN-LAST:event_barang_btnActionPerformed

    private void ubahBtn_skripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahBtn_skripsiActionPerformed
        try {
            String sql = "UPDATE skripsi SET nama ='"+ txtNama.getText()
            +"', nim ='"+txtNIM.getText()
            +"', jurusan ='"+txtJurusan.getText()
         
            +"'  WHERE nama ='"+txtNama.getText() + "'";
            java.sql.Connection conn = (Connection)konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(this, "Edit data berhasil !");
        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data_skripsi();
        kosongkanform();
    }//GEN-LAST:event_ubahBtn_skripsiActionPerformed

    private void kosongkanBtn_skripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kosongkanBtn_skripsiActionPerformed
        kosongkanform();
    }//GEN-LAST:event_kosongkanBtn_skripsiActionPerformed

    private void simpanBtn_skripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBtn_skripsiActionPerformed
        try{
            String sql = "INSERT INTO skripsi VALUES ('"
            + txtNama.getText()
            +"','"+txtNIM.getText()
            +"','"+txtJurusan.getText()
            +
            "')";
            java.sql.Connection conn = (Connection)konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Proses simpan data berhasil");
            kosongkanform();
            tampilkan_data_skripsi();

        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_simpanBtn_skripsiActionPerformed

    private void printBtn_skripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtn_skripsiActionPerformed

        String inputNama = txtNama.getText();
        String inputNIM = txtNIM.getText();
        String inputJurusan = txtJurusan.getText();
       

        //output
        input_skripsi(inputNama,inputNIM,inputJurusan);
    }//GEN-LAST:event_printBtn_skripsiActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton barang_btn;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel homeBtn;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel1_pkl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel2_pkl;
    private javax.swing.JLabel jLabel2_skripsi;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel3_pkl;
    private javax.swing.JLabel jLabel3_skripsi;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel4_skripsi;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel5_pkl;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel6_pkl;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel7_pkl;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTxtCari;
    private javax.swing.JTextField jTxtCari2;
    private javax.swing.JLabel jTxtField4_pkl;
    private javax.swing.JButton kosongkanBtn_pkl;
    private javax.swing.JButton kosongkanBtn_skripsi;
    private javax.swing.JLabel listBtn;
    private javax.swing.JPanel listPanel;
    private javax.swing.JButton listPkl_btn;
    private javax.swing.JPanel listPkl_view;
    private javax.swing.JButton listSkripsi_btn;
    private javax.swing.JPanel listSkripsi_view;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mainTabel;
    private javax.swing.JPanel panel_barang;
    private javax.swing.JPanel panel_pelanggan;
    private javax.swing.JButton pelanggan_btn;
    private javax.swing.JLabel pklBtn;
    private javax.swing.JButton pklCari_btn;
    private javax.swing.JButton pklHapus_btn;
    private javax.swing.JPanel pklPanel;
    private javax.swing.JButton printBtn_pkl;
    private javax.swing.JButton printBtn_skripsi;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JButton simpanBtn_pkl;
    private javax.swing.JButton simpanBtn_skripsi;
    private javax.swing.JLabel skripsiBtn;
    private javax.swing.JButton skripsiCari_btn;
    private javax.swing.JButton skripsiHapus_btn;
    private javax.swing.JPanel skripsiPanel;
    private javax.swing.JTextField txtFakultas2;
    private javax.swing.JTextField txtJurusan;
    private javax.swing.JTextField txtJurusan2;
    private javax.swing.JTextField txtKota;
    private javax.swing.JTextField txtNIM;
    private javax.swing.JTextField txtNIM2;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNama2;
    private javax.swing.JTextField txtSKS;
    private javax.swing.JTextField txtTempat;
    private javax.swing.JButton ubahBtn_pkl;
    private javax.swing.JButton ubahBtn_skripsi;
    // End of variables declaration//GEN-END:variables

    private void input_skripsi(String inputNama, String inputNIM, String inputJurusan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
