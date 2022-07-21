/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.UI;

import com.violet.DAO.KhachHangDAO;
import com.violet.Entity.KhachHang;
import com.violet.Help.Auth;
import com.violet.Help.HeaderColor;
import com.violet.Help.MsgBox;
import com.violet.Help.ThongTinNhanh;
import com.violet.Help.XDate;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class KhachHangJDialog extends javax.swing.JDialog {

    public KhachHangJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
        //1200 600
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlBackground = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        lblTenKH = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        lblGioiTinh = new javax.swing.JLabel();
        lblGioiTinh1 = new javax.swing.JLabel();
        lblSoDienThoai = new javax.swing.JLabel();
        lblKhachHang1 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        dtcNgaySinh = new com.toedter.calendar.JDateChooser();
        lblTieuDe = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        lblMaNhanVien = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        btnThem = new com.violet.UI.Button();
        btnCapNhat = new com.violet.UI.Button();
        btnXoa = new com.violet.UI.Button();
        btnMoi = new com.violet.UI.Button();
        btnFirst = new com.violet.UI.Button();
        btnPrev = new com.violet.UI.Button();
        btnNext = new com.violet.UI.Button();
        btnLast = new com.violet.UI.Button();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Violet - Khách Hàng");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));

        tblKhachHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MaKH", "TenKH", "Giới Tính", "CMND", "Điện Thoại", "Ngày Sinh", "Email", "MaNV"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.setRowHeight(30);
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        lblTenKH.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblTenKH.setText("TenKH:");
        lblTenKH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtTenKH.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        rdoNam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        rdoNu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoNu.setText("Nữ");

        lblGioiTinh.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblGioiTinh.setText("Giới Tính:");
        lblGioiTinh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        lblGioiTinh1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblGioiTinh1.setText("CMND:");
        lblGioiTinh1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        lblSoDienThoai.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblSoDienThoai.setText("Số ĐT:");
        lblSoDienThoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        lblKhachHang1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblKhachHang1.setText("Ngày Sinh:");
        lblKhachHang1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtCMND.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        dtcNgaySinh.setBackground(new java.awt.Color(255, 255, 255));
        dtcNgaySinh.setDateFormatString("dd-MM-yyyy");
        dtcNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblTieuDe.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(32, 136, 203));
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("Khách Hàng");
        lblTieuDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(32, 136, 203), 10));

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(0, 255, 255));
        btnTimKiem.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/violet/icon/TimKiemIcon.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");

        lblMaNhanVien.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblMaNhanVien.setText("MaNV:");
        lblMaNhanVien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        lblMaNV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblMaNV.setText("NV01");
        lblMaNV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/violet/icon/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setColor1(new java.awt.Color(183, 227, 253));
        btnThem.setColor2(new java.awt.Color(134, 112, 187));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/violet/icon/update.png"))); // NOI18N
        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.setColor1(new java.awt.Color(183, 227, 253));
        btnCapNhat.setColor2(new java.awt.Color(134, 112, 187));
        btnCapNhat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/violet/icon/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setColor1(new java.awt.Color(183, 227, 253));
        btnXoa.setColor2(new java.awt.Color(134, 112, 187));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/violet/icon/new.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.setColor1(new java.awt.Color(183, 227, 253));
        btnMoi.setColor2(new java.awt.Color(134, 112, 187));
        btnMoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnFirst.setText("|<");
        btnFirst.setColor1(new java.awt.Color(26, 239, 246));
        btnFirst.setColor2(new java.awt.Color(67, 29, 245));
        btnFirst.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setText("<<");
        btnPrev.setColor1(new java.awt.Color(26, 239, 246));
        btnPrev.setColor2(new java.awt.Color(67, 29, 245));
        btnPrev.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.setColor1(new java.awt.Color(26, 239, 246));
        btnNext.setColor2(new java.awt.Color(67, 29, 245));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.setColor1(new java.awt.Color(26, 239, 246));
        btnLast.setColor2(new java.awt.Color(67, 29, 245));
        btnLast.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblEmail.setText("Email:");
        lblEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBackgroundLayout.createSequentialGroup()
                            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblTenKH)
                                .addComponent(lblGioiTinh)
                                .addComponent(lblGioiTinh1)
                                .addComponent(lblSoDienThoai)
                                .addComponent(lblKhachHang1)
                                .addComponent(lblMaNhanVien))
                            .addGap(43, 43, 43)
                            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTenKH)
                                .addComponent(txtCMND)
                                .addComponent(txtSDT)
                                .addComponent(dtcNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmail)
                                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                    .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblMaNV)
                                        .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                            .addComponent(rdoNam)
                                            .addGap(42, 42, 42)
                                            .addComponent(rdoNu)))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(pnlBackgroundLayout.createSequentialGroup()
                            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                                    .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblEmail))
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiem)
                        .addGap(0, 91, Short.MAX_VALUE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(txtTimKiem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenKH)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu)
                            .addComponent(lblGioiTinh))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGioiTinh1)
                            .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSoDienThoai)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKhachHang1)
                            .addComponent(dtcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaNhanVien)
                            .addComponent(lblMaNV))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(pnlBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        fillTable();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(Auth.isServe()){
            MsgBox.alert(this, "Phục vụ không có quyền thêm !");
            return;
        }
        if(!Validate()){
            return;
        }
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if(Auth.isServe()){
            MsgBox.alert(this, "Phục vụ không có quyền cập nhật !");
            return;
        }
        if(!Validate()){
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

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            this.row = tblKhachHang.getSelectedRow();
            edit();
        }
    }//GEN-LAST:event_tblKhachHangMouseClicked

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
            java.util.logging.Logger.getLogger(KhachHangJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KhachHangJDialog dialog = new KhachHangJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnTimKiem;
    private com.violet.UI.Button btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dtcNgaySinh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblGioiTinh1;
    private javax.swing.JLabel lblKhachHang1;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    KhachHangDAO dao = new KhachHangDAO();
    int row =-1;
    
    public void init(){
        this.setLocationRelativeTo(null);
        tblKhachHang.getTableHeader().setDefaultRenderer(new HeaderColor());
        tblKhachHang.getParent().setBackground(Color.WHITE);
        tblKhachHang.getTableHeader().setPreferredSize(new Dimension(40, 40));
        tblKhachHang.getColumnModel().getColumn(0).setMaxWidth(60);
        tblKhachHang.getColumnModel().getColumn(1).setMinWidth(150);
        tblKhachHang.getColumnModel().getColumn(2).setMaxWidth(80);
        tblKhachHang.getColumnModel().getColumn(6).setMaxWidth(120);
        tblKhachHang.getColumnModel().getColumn(7).setMaxWidth(60);
        this.fillTable();
        txtTenKH.setToolTipText("0");
        this.clearForm();
    }
    
    private void fillTable(){
        DefaultTableModel model = (DefaultTableModel)tblKhachHang.getModel();
        model.setRowCount(0);
        try{
            String keyword = txtTimKiem.getText();
            List<KhachHang> list = dao.selectByKeyword(keyword); 
            for(KhachHang kh : list){
                Object[] row = {
                    kh.getMaKH(),
                    kh.getTenKH(),
                    kh.getGioiTinh()?"Nam" : "Nữ",
                    kh.getCMND(),
                    kh.getDienThoai(),
                    XDate.toString(kh.getNgaySinh(),"dd/MM/yyyy"),
                    kh.getEmail(),
                    kh.getMaNV()
                    
                };
                model.addRow(row);
                }
        }catch(Exception e){
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    void insert(){
        KhachHang kh = getForm();
        try {
            dao.insert(kh);  
//            KhachHang khnew = getForm();
//            khnew.setMaKH((int)tblKhachHang.getValueAt(tblKhachHang.getRowCount()-1, 0));
//            ThongTinNhanh.kh = khnew;
            this.fillTable();     
            int makhnew = tblKhachHang.getRowCount();
            KhachHang new3 = dao.selectById(makhnew);
            ThongTinNhanh.kh = new3;
            this.clearForm();
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại!");
        }
    }
    void update(){
        KhachHang kh = getForm();
        try {
            dao.update(kh); 
            this.fillTable(); 
            MsgBox.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại!");
            e.printStackTrace();
        }     
    }
    void delete(){
            try {
                dao.delete(Integer.valueOf(txtTenKH.getToolTipText()));
                this.fillTable();
                this.clearForm();
                MsgBox.alert(this, "Xóa thành công");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại");
            }
    }
    void clearForm(){      
        KhachHang kh = new KhachHang();
        kh.setMaKH(0);
        kh.setMaNV(Auth.user.getMaNV());
        this.setForm(kh);
        this.row = -1;
        this.updateStatus();
        this.fillTable();
    }
    void edit(){
        Integer MaKH = (Integer) tblKhachHang.getValueAt(this.row, 0);
        tblKhachHang.setRowSelectionInterval(this.row, this.row);
        KhachHang kh = dao.selectById(MaKH);
        this.setForm(kh);
        this.updateStatus();
    }
    void setForm(KhachHang kh){
        txtTenKH.setToolTipText(String.valueOf(kh.getMaKH()));
        txtTenKH.setText(kh.getTenKH());        
        rdoNam.setSelected(kh.getGioiTinh());
        rdoNu.setSelected(!kh.getGioiTinh());
        txtCMND.setText(kh.getCMND());
        txtSDT.setText(kh.getDienThoai());
        dtcNgaySinh.setDate(kh.getNgaySinh());
        lblMaNV.setText(kh.getMaNV());
        txtEmail.setText(kh.getEmail());             
    }
    KhachHang getForm(){
        KhachHang kh = new KhachHang();
        kh.setMaKH(Integer.valueOf(txtTenKH.getToolTipText()));
        kh.setMaKH(new Integer(txtTenKH.getToolTipText()));
        kh.setTenKH(txtTenKH.getText());
        kh.setGioiTinh(rdoNam.isSelected());
        kh.setCMND(txtCMND.getText());
        kh.setDienThoai(txtSDT.getText());
        kh.setNgaySinh(dtcNgaySinh.getDate());
        kh.setMaNV(lblMaNV.getText());
        kh.setEmail(txtEmail.getText());       
        return kh;
    }
    void first(){
        this.row = 0;
        this.edit();
    }
    void prev(){
        if(this.row > 0){
            this.row--;
            this.edit();
        }
    }
    void next(){
        if(this.row < tblKhachHang.getRowCount()-1){
            this.row++;
            this.edit();
        }
    }
    void last(){
        this.row = tblKhachHang.getRowCount()-1;
        this.edit();
    }
    void updateStatus(){
        boolean edit = (this.row >=0);
        boolean first = (this.row ==0);
        boolean last = (this.row >= tblKhachHang.getRowCount()-1);

        
        btnThem.setEnabled(!edit);
        btnCapNhat.setEnabled(edit);
        btnXoa.setEnabled(edit);
        //trang thai dieu huong
        btnFirst.setEnabled(edit && !first);
        btnPrev.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
    }
    public boolean Validate() {
        if (txtTenKH.getText().trim().length() == 0) {
            MsgBox.alert(this, "Tên khách hàng không được để trống!");
            txtTenKH.requestFocus();
            return false;
        }
        if (txtCMND.getText().trim().length() == 0) {
            MsgBox.alert(this, "CMND không được để trống!");
            txtCMND.requestFocus();
            return false;
        }
        if (!txtCMND.getText().trim().matches("[0-9]{9}")){
            MsgBox.alert(this, "Sai định dạng CMND !");
            txtCMND.requestFocus();
            return false;
        }
        if (txtSDT.getText().trim().length() == 0) {           
            MsgBox.alert(this, "Không được để trống SĐT !");           
            txtSDT.requestFocus();
            return false;
        }
        if (!txtSDT.getText().matches("^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$")){
            MsgBox.alert(this, "Sai định dạng SĐT !");           
            txtSDT.requestFocus();
            return false;
        }
        if(dtcNgaySinh.getDate()==null){
            MsgBox.alert(this, "Chưa chọn ngày sinh !"); 
            dtcNgaySinh.requestFocus();
            return false;
        }
        if (txtEmail.getText().trim().length() == 0) {
            MsgBox.alert(this, "Email không được để trống!");
            txtEmail.requestFocus();
            return false;
        }
        if (!txtEmail.getText().trim().matches("\\w+@\\w+(\\.\\w+){1,2}")){
            MsgBox.alert(this, "Sai định dạng Email!");
            txtEmail.requestFocus();
            return false;
        }
        return true;
    }
}
