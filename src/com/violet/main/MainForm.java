/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.main;

import com.violet.DAO.HoaDonThanhToanPhongDAO;
import com.violet.DAO.PhongDAO;
import com.violet.Entity.Phong;
import com.violet.Help.MsgBox;
import com.violet.Help.ThongTinNhanh;
import com.violet.UI.CuaSoChao2JDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Admin
 */
public class MainForm extends javax.swing.JPanel {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pnlBackground = new javax.swing.JPanel();
        btnReset = new com.violet.UI.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pnlBackground);

        btnReset.setText("Reset");
        btnReset.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        new CuaSoChao2JDialog(null, true).setVisible(true);
        pnlBackground.removeAll();
        init();
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.violet.UI.Button btnReset;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlBackground;
    // End of variables declaration//GEN-END:variables

    HoaDonThanhToanPhongDAO daoHD = new HoaDonThanhToanPhongDAO();
    PhongDAO daoP = new PhongDAO();
    public void init() {
        try {           
            int length = daoP.selectTongSoPhong();
            int count = length / 5;            
            
            pnlBackground.setLayout(new GridLayout(count, 5,5,5));
            for(int i = 1; i <= length;i++){
                if(!daoHD.xetPhongDangSuDung(i)){
                    JPanel pnl = new JPanel(); 
                    pnl.setLayout(new BorderLayout());
                    pnl.setBackground(new Color(202, 225, 255));
                    
                    JButton west = new JButton();
                    west.setIcon(new ImageIcon("src/com/violet/icon/home.png"));
                    //west.setIcon(new ImageIcon());
                    west.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {                       
                            
                        }                                        
                    });
                    
                    JLabel east = new JLabel();
                    east.setText(String.valueOf(i));
                    east.setFont(new Font("Time New Roman", Font.BOLD, 50));
                    east.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            //JOptionPane.showMessageDialog(null, east.getText());
                            Phong pp = new Phong();
                            pp.setMaPhong(Integer.parseInt(east.getText()));
                            ThongTinNhanh.p = pp;
                            MsgBox.alert(null, "Lấy mã phòng thành công !");
                        }
                    });
                    
                    JLabel north = new JLabel();
                    north.setText("Phòng Chưa Thuê");
                    north.setHorizontalAlignment(0);
                    north.setFont(new Font("Time New Roman", Font.BOLD, 15));
                    
                    JTextArea center = new JTextArea();
                    center.setText("Phòng chưa có người !");
                    center.setBorder(new LineBorder(Color.WHITE));
                    
                    pnl.add(west,BorderLayout.WEST);//trai
                    pnl.add(east,BorderLayout.EAST);//Phai
                    pnl.add(north,BorderLayout.NORTH);//Tren
                    //pnl.add(lblDangKi3,BorderLayout.SOUTH);//Nam
                    pnl.add(center,BorderLayout.CENTER);
                    
                    west.setBackground(Color.blue);
                    pnl.setBorder(new MatteBorder(3, 5, 3, 3, Color.BLUE));
                    pnlBackground.add(pnl,i-1);
                }else{
                    List<Object[]> list = daoHD.getThongTinPhongDangThue(i);
                    JPanel pnl = new JPanel(); 
                    pnl.setLayout(new BorderLayout());
                    pnl.setBackground(new Color(178, 34, 34));
                    
                    JButton west = new JButton();
                    west.setIcon(new ImageIcon("src/com/violet/icon/home2.png"));
                    west.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {                       
                            
                        }                                        
                    });
                    
                    JLabel east = new JLabel();
                    east.setText(String.valueOf(i));
                    east.setFont(new Font("Time New Roman", Font.BOLD, 50));
                    east.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            JOptionPane.showMessageDialog(null, east.getText());
                        }
                    });
                    
                    JLabel north = new JLabel();
                    north.setText("Phòng Đã Có Người !");
                    north.setHorizontalAlignment(0);
                    north.setFont(new Font("Time New Roman", Font.BOLD, 15));
                    
                    JTextArea center = new JTextArea();
                    center.setText("MaPhòng: "+list.get(0)[0]+" !\nMã Khách Hàng:\n" + list.get(0)[1] + "\nNgày Trả:\n" + list.get(0)[2]);
                    center.setBorder(new LineBorder(Color.WHITE));
                    
                    pnl.add(west,BorderLayout.WEST);//trai
                    pnl.add(east,BorderLayout.EAST);//Phai
                    pnl.add(north,BorderLayout.NORTH);//Tren
                    //pnl.add(lblDangKi3,BorderLayout.SOUTH);//Nam
                    pnl.add(center,BorderLayout.CENTER);
                    
                    west.setBackground(Color.blue);
                    pnl.setBorder(new MatteBorder(3, 5, 3, 3, Color.BLUE));
                    pnlBackground.add(pnl,i-1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
