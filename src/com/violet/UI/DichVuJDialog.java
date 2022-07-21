
package com.violet.UI;

import com.violet.DAO.DichVuDAO;
import com.violet.Entity.DichVu;
import com.violet.Help.Auth;
import com.violet.Help.HeaderColor;
import com.violet.Help.MsgBox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class DichVuJDialog extends javax.swing.JDialog {

    public DichVuJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        lblMaDV = new javax.swing.JLabel();
        txtMaDV = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        lblTenDV = new javax.swing.JLabel();
        txtTenDV = new javax.swing.JTextField();
        lblMoTaDV = new javax.swing.JLabel();
        lblGia = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        lblTieuDe = new javax.swing.JLabel();
        btnThem = new com.violet.UI.Button();
        btnCapNhat = new com.violet.UI.Button();
        btnXoa = new com.violet.UI.Button();
        btnMoi = new com.violet.UI.Button();
        btnFirst = new com.violet.UI.Button();
        btnPrev = new com.violet.UI.Button();
        btnNext = new com.violet.UI.Button();
        btnLast = new com.violet.UI.Button();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new com.violet.UI.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));

        tblDichVu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã DV", "Tên DV", "Mô tả", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDichVu.setRowHeight(30);
        tblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDichVu);

        lblMaDV.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblMaDV.setText("Mã dịch vụ:");
        lblMaDV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtMaDV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        lblTenDV.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblTenDV.setText("Tên dịch vụ:");
        lblTenDV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtTenDV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblMoTaDV.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblMoTaDV.setText("Mô tả dịch vụ:");
        lblMoTaDV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        lblGia.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblGia.setText("Giá:");
        lblGia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtGia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiaKeyReleased(evt);
            }
        });

        lblTieuDe.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(32, 136, 203));
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("Dịch Vụ");
        lblTieuDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(32, 136, 203), 3));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/violet/icon/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setColor1(new java.awt.Color(102, 255, 255));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/violet/icon/update.png"))); // NOI18N
        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.setColor1(new java.awt.Color(102, 255, 255));
        btnCapNhat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/violet/icon/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setColor1(new java.awt.Color(102, 255, 255));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/violet/icon/new.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.setColor1(new java.awt.Color(102, 255, 255));
        btnMoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnFirst.setText("|<");
        btnFirst.setColor1(new java.awt.Color(242, 250, 254));
        btnFirst.setColor2(new java.awt.Color(133, 130, 235));
        btnFirst.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFirst.setSizeSpeed(1.5F);
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setText("<<");
        btnPrev.setColor1(new java.awt.Color(242, 250, 254));
        btnPrev.setColor2(new java.awt.Color(133, 130, 235));
        btnPrev.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrev.setSizeSpeed(1.5F);
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.setColor1(new java.awt.Color(242, 250, 254));
        btnNext.setColor2(new java.awt.Color(133, 130, 235));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNext.setSizeSpeed(1.5F);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.setColor1(new java.awt.Color(242, 250, 254));
        btnLast.setColor2(new java.awt.Color(133, 130, 235));
        btnLast.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLast.setSizeSpeed(1.5F);
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/violet/icon/TimKiemIcon.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblGia)
                        .addGap(18, 18, 18)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblTieuDe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBackgroundLayout.createSequentialGroup()
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMoTaDV, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBackgroundLayout.createSequentialGroup()
                                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(lblMaDV))
                                            .addComponent(lblTenDV))
                                        .addGap(64, 64, 64)
                                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMaDV, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                            .addComponent(txtTenDV))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(37, 37, 37)))
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaDV)
                            .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenDV)
                            .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblMoTaDV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGia)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(Auth.isServe()){
            MsgBox.alert(this, "Phục vụ không có quyền thêm !");
            return;
        }
        if(validatee()){
            return;
        }
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if(Auth.isServe()){
            MsgBox.alert(this, "Phục vụ không có quyền cập nhật !");
            return;
        }
        if(validatee()){
            return;
        }
        update();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if(Auth.isServe()){
            MsgBox.alert(this, "Phục vụ không có quyền xóa !");
            return;
        }
        if(Auth.isReceptionist()){
            MsgBox.alert(this, "Lễ tân không có quyền xóa !");
            return;
        }
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        fillTable();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            this.row = tblDichVu.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblDichVuMouseClicked

    private void txtGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaKeyReleased
        // TODO add your handling code here:
        ChuyenDang();
    }//GEN-LAST:event_txtGiaKeyReleased

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
            java.util.logging.Logger.getLogger(DichVuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DichVuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DichVuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DichVuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DichVuJDialog dialog = new DichVuJDialog(new javax.swing.JFrame(), true);
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
    private com.violet.UI.Button btnCapNhat;
    private com.violet.UI.Button btnFirst;
    private com.violet.UI.Button btnLast;
    private com.violet.UI.Button btnMoi;
    private com.violet.UI.Button btnNext;
    private com.violet.UI.Button btnPrev;
    private com.violet.UI.Button btnThem;
    private com.violet.UI.Button btnTimKiem;
    private com.violet.UI.Button btnXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblMaDV;
    private javax.swing.JLabel lblMoTaDV;
    private javax.swing.JLabel lblTenDV;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaDV;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtTenDV;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    DichVuDAO dao = new DichVuDAO();
    int row = -1;
    
    public void init(){
        this.setLocationRelativeTo(null);
        tblDichVu.getTableHeader().setDefaultRenderer(new HeaderColor());
        tblDichVu.getParent().setBackground(Color.WHITE);
        tblDichVu.getTableHeader().setPreferredSize(new Dimension(40, 40));
        tblDichVu.getColumnModel().getColumn(0).setMaxWidth(60);
        tblDichVu.getColumnModel().getColumn(1).setMinWidth(150);
        tblDichVu.getColumnModel().getColumn(2).setMinWidth(150);
        fillTable();
        clearForm();
    }
    
    private void edit(){
        String madv = (String) tblDichVu.getValueAt(this.row, 0);
        tblDichVu.setRowSelectionInterval(this.row, this.row);
        DichVu dv = dao.selectById(madv);
        this.setForm(dv);    
    }
    
    private void first(){
        this.row = 0;
        this.edit();
    }
    private void prev(){
        if(this.row>0){
            this.row--;
            this.edit();
        }
    }
    private void next(){
        if(this.row<tblDichVu.getRowCount()-1){
            this.row++;
            this.edit();
        }
    }
    private void last(){
        this.row = tblDichVu.getRowCount()-1;
        this.edit();
    }
    private void clearForm(){
        DichVu dv = new DichVu();
        this.setForm(dv);
        this.row = -1;
        this.fillTable();
        updateStatus();
    }
    private void insert(){
        DichVu dv = getForm();
        try {
            dao.insert(dv);
            this.fillTable();
            this.clearForm();
            MsgBox.alert(this, "Thêm mới thành công !");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại !");
        }
    }
    
    private void update(){
        DichVu dv = getForm();
        try {
            dao.update(dv);
            this.fillTable();
            MsgBox.alert(this, "Cập nhật thành công !");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại !");
        }
        
    }
    
    private void delete() {
        String madv = txtMaDV.getText();
        try {
            dao.delete(madv);
            this.fillTable();
            this.clearForm();
            MsgBox.alert(this, "Xóa thành công !");
        } catch (Exception e) {
            MsgBox.alert(this, "Xóa thất bại !");
        }
    }
    
    private void fillTable(){
        DefaultTableModel model = (DefaultTableModel) tblDichVu.getModel();
        model.setRowCount(0);
        DecimalFormat format = new DecimalFormat("###,###,###");
        
        try {
            String keyword = txtTimKiem.getText();
            List<DichVu> list = dao.selectByKeyword(keyword);
            for(DichVu dv : list){
                Object[] row = {dv.getMaDV()
                        ,dv.getTenDV()
                        ,dv.getMoTaChiTiet()
                        ,format.format(dv.getGia())};
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }        
    }
    
    private void setForm(DichVu dv){
        txtMaDV.setText(dv.getMaDV());
        txtTenDV.setText(dv.getTenDV());
        txtMoTa.setText(dv.getMoTaChiTiet());
        DecimalFormat format = new DecimalFormat("###,###,###");
        
        txtGia.setText(new String(format.format(dv.getGia())));
    }
    
    private DichVu getForm(){
        DichVu dv = new DichVu();
        dv.setMaDV(txtMaDV.getText());
        dv.setTenDV(txtTenDV.getText());
        dv.setMoTaChiTiet(txtMoTa.getText());       
        dv.setGia(Double.valueOf(chuyenlai(txtGia.getText())));
        return dv;
    }
    public void updateStatus(){
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row >= tblDichVu.getRowCount() - 1);

        txtMaDV.setEditable(!edit);
        btnThem.setEnabled(!edit);
        btnCapNhat.setEnabled(edit);
        btnXoa.setEnabled(edit);

        btnFirst.setEnabled(edit && !first);
        btnPrev.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
    }
    
    private void ChuyenDang(){
        if(txtGia.getText().equals("")){
            return;
        }
        try {
            String gia = txtGia.getText();
            String giadd = gia.replace(",", "");
            DecimalFormat format = new DecimalFormat("###,###,###");
            String so = format.format(Long.parseLong(giadd));
            txtGia.setText(so);
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Chỉ nhập số !");
        }
    }
    private String chuyenlai(String txtgia){
        try {
            String gia = txtgia;
            String giadd = gia.replace(",", "");
            return giadd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private boolean validatee(){
        if(txtMaDV.getText().equals("")){
            MsgBox.alert(this, "Không được để trống Mã dịch vụ !");
            txtMaDV.requestFocus();
            return false;
        }
        if(!txtMaDV.getText().matches("^(DV|dv)[0-9]{3}")){
            MsgBox.alert(this, "Sai định dạng Mã dịch vụ !");
            txtMaDV.requestFocus();
            return false;
        }
        if(txtTenDV.getText().equals("")){
            MsgBox.alert(this, "Không được để trống Tên dịch vụ !");
            txtTenDV.requestFocus();
            return false;
        }
        if(txtMoTa.getText().equals("")){
            MsgBox.alert(this, "Không được để trống Mô tả dịch vụ !");
            txtMoTa.requestFocus();
            return false;
        }
        return true;
    }
}
