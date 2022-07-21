/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.chart;

import com.violet.DAO.DoanhThuDAO;
import com.violet.DAO.HoaDonThanhToanPhongDAO;
import com.violet.Help.MsgBox;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class MainChart extends javax.swing.JDialog {

    
    public MainChart(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        btnClear = new com.violet.UI.Button();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        chart = new com.violet.chart.Chart();
        chart2 = new com.violet.chart.Chart();
        chart3 = new com.violet.chart.CurveChart();
        lblTieuDe = new javax.swing.JLabel();
        cboThang = new javax.swing.JComboBox<>();
        lblThang = new javax.swing.JLabel();
        lblThang2 = new javax.swing.JLabel();
        cboThang1 = new javax.swing.JComboBox<>();
        lblNam = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();
        btnLoad = new com.violet.UI.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));

        btnClear.setText("Clear");
        btnClear.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jTabbedPane1.addTab("Thống Kế Doanh Thu", new javax.swing.ImageIcon(getClass().getResource("/com/violet/icon/DoanhThuDichVuIcon.png")), chart); // NOI18N
        jTabbedPane1.addTab("Thống Kê Dịch Vụ", new javax.swing.ImageIcon(getClass().getResource("/com/violet/icon/DoanhThuPhongIcon.png")), chart2); // NOI18N
        jTabbedPane1.addTab("Tăng Trưởng", chart3);

        lblTieuDe.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(51, 255, 255));
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("Thống Kê");
        lblTieuDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255), 10));

        cboThang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        lblThang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblThang.setText("Từ Tháng:");

        lblThang2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblThang2.setText("Đến Tháng:");

        cboThang1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        lblNam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNam.setText("Năm:");

        cboNam.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        btnLoad.setText("Load");
        btnLoad.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboThang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblThang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboThang1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblNam)
                                .addGap(552, 1061, Short.MAX_VALUE))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addComponent(lblTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addComponent(lblTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblThang)
                    .addComponent(lblThang2)
                    .addComponent(lblNam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboThang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        chart.start();
        chart2.start();
        chart3.start();
    }//GEN-LAST:event_formWindowOpened

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        chart.clear();
        chart2.clear();
        chart3.clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        loadChart();
        loadChart2();
        loadChart3();
    }//GEN-LAST:event_btnLoadActionPerformed

    
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
            java.util.logging.Logger.getLogger(MainChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainChart dialog = new MainChart(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.violet.UI.Button btnClear;
    private com.violet.UI.Button btnLoad;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JComboBox<String> cboThang;
    private javax.swing.JComboBox<String> cboThang1;
    private com.violet.chart.Chart chart;
    private com.violet.chart.Chart chart2;
    private com.violet.chart.CurveChart chart3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblNam;
    private javax.swing.JLabel lblThang;
    private javax.swing.JLabel lblThang2;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JPanel pnlBackground;
    // End of variables declaration//GEN-END:variables
    
    DoanhThuDAO dao = new DoanhThuDAO();
    HoaDonThanhToanPhongDAO dao2 = new HoaDonThanhToanPhongDAO();
    int temp = 0;
    public void init(){
        getContentPane().setBackground(new Color(250,250,250));
        chart.addLegend("Tháng", new Color(245, 189, 135));
        chart2.addLegend("Mã Dịch Vụ", new Color(135, 250, 150));
        chart3.addLegend("Tháng", new Color(12, 84, 175), new Color(0, 108, 247));
//        chart2.addLegend("DV001", new Color(135, 150, 245));
//        chart2.addLegend("DV002", new Color(150, 189, 245));
//        chart2.addLegend("DV003", new Color(135, 189, 200));
//        chart2.addLegend("DV004", new Color(140, 189, 245));
//        chart2.addLegend("DV005", new Color(130, 140, 245));
//        chart2.addLegend("DV006", new Color(135, 189, 205));
//        chart2.addLegend("DV007", new Color(170, 150, 220));
//        chart2.addLegend("DV008", new Color(180, 110, 245));
//        chart2.addLegend("DV009", new Color(200, 120, 245));
//        chart2.addLegend("DV010", new Color(145, 200, 249));
//        chart2.addLegend("DV011", new Color(130, 109, 245));
//        chart2.addLegend("DV012", new Color(135, 189, 205));
//        chart2.addLegend("DV013", new Color(105, 189, 245));
//        chart2.addLegend("DV014", new Color(130, 189, 205));
//        chart2.addLegend("DV015", new Color(135, 109, 200));
//        chart.addLegend("Expense", new Color(135, 189, 245));
//        chart.addLegend("Profit", new Color(189, 135, 245));
//        chart.addLegend("Cost", new Color(139, 229, 222));
//        chart.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
//        chart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
//        chart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
//        chart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
//        chart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
//        chart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        
//        chart3.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
//        chart3.addLegend("Profit", new Color(5, 125, 20), new Color(95, 209, 69));
//        chart3.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
//        chart3.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
//        chart3.addData(new ModelChart("February", new double[]{1000, 750, 90, 150}));
//        chart3.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
//        chart3.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
//        chart3.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
//        chart3.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        
        fillComboboxThang();
        fillComboboxThang2();
        fillComboboxNam();  
        //loadChart();
        //loadChart2();
    }
    
    
    private void fillComboboxThang(){
        cboThang.removeAllItems();
        for(int i = 1; i < 13;i++){
            cboThang.addItem(String.valueOf(i));
        }
    }
    private void fillComboboxThang2(){
        cboThang1.removeAllItems();
        for(int i = 1; i < 13;i++){
            cboThang1.addItem(String.valueOf(i));
        }
    }
    private void fillComboboxNam(){
        cboNam.removeAllItems();
        for(int i = 0; i < dao2.selectNamHD().size(); i++){
            cboNam.addItem(String.valueOf(dao2.selectNamHD().get(i)));
        }
    }
    private void loadChart(){
        chart.clear();
        int thang1 = Integer.parseInt(cboThang.getSelectedItem().toString());
        int thang2 = Integer.parseInt(cboThang1.getSelectedItem().toString());    
        int namm = Integer.parseInt(cboNam.getSelectedItem().toString()); 
        for(int i = thang1; i <= thang2 ; i++){
            chart.addData(new ModelChart("Tháng "+ i, new double[]{(int)dao2.selectTienThanhToanMonthAndYear(i, namm)}));
        }
        chart.start();
    }
    private void loadChart2(){
        chart2.clear();
        int thang1 = Integer.parseInt(cboThang.getSelectedItem().toString());
        int thang2 = Integer.parseInt(cboThang1.getSelectedItem().toString());    
        int namm = Integer.parseInt(cboNam.getSelectedItem().toString());
        List<Object[]> list = dao.getTienDichVuMonthAndYear(thang1,thang2, namm);
        for(Object[] row : list){
            chart2.addData(new ModelChart(row[0].toString(), new double[]{Double.parseDouble(row[1].toString())}));           
        }        
        chart2.start();
    }
    private void loadChart3(){
        chart3.clear();
        int thang1 = Integer.parseInt(cboThang.getSelectedItem().toString());
        int thang2 = Integer.parseInt(cboThang1.getSelectedItem().toString());    
        int namm = Integer.parseInt(cboNam.getSelectedItem().toString()); 
        for(int i = thang1; i <= thang2 ; i++){
            chart3.addData(new ModelChart("Tháng "+ i, new double[]{(int)dao2.selectTienThanhToanMonthAndYear(i, namm)}));
        }
        chart3.start();
    }
}
