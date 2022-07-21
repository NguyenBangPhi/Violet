/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.UI;

import com.violet.DAO.NhanVienDAO;
import com.violet.Help.Auth;
import com.violet.Help.MsgBox;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.IntPointer;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imencode;
import org.bytedeco.opencv.global.opencv_imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;
import static org.bytedeco.opencv.global.opencv_imgproc.rectangle;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_face.LBPHFaceRecognizer;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;

/**
 *
 * @author Admin
 */
public class NhanDienDangNhap extends javax.swing.JDialog {

    /**
     * Creates new form NhanDienDangNhap
     */
    public NhanDienDangNhap(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        recognizer.read("src\\com\\violet\\photo\\classifierLBPH.yml");
        recognizer.setThreshold(80);
    }
    NhanVienDAO dao = new NhanVienDAO();
    private DaemonThread myThread = null;
    String ten, email, sdt;
    int id;
    VideoCapture webSource = null;
    Mat frame = new Mat();
    CascadeClassifier faceDetector = new CascadeClassifier("src\\com\\violet\\photo\\haarcascade_frontalface_alt.xml");
    LBPHFaceRecognizer recognizer = LBPHFaceRecognizer.create();
    BytePointer mem = new BytePointer();
    RectVector detectedFaces = new RectVector();
    

    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    if (webSource.grab()) {
                        try {
                            webSource.retrieve(frame);
                            Graphics g = label_photo.getGraphics();
                            Mat imageColor = new Mat();
                            imageColor = frame;
                            Mat imageGray = new Mat();
                            cvtColor(imageColor, imageGray, COLOR_BGRA2GRAY);

                            faceDetector.detectMultiScale(imageGray, detectedFaces, 1.1, 1, 1, new Size(200, 200), new Size(500, 500));
                            for (int i = 0; i < detectedFaces.size(); i++) {
                                Rect dadosFace = detectedFaces.get(i);
                                rectangle(frame, dadosFace, new Scalar(0, 255, 0, 3), 3, 0, 0);
                                Mat faceCapturada = new Mat(imageGray, dadosFace);
                                opencv_imgproc.resize(faceCapturada, faceCapturada, new Size(160, 160));

                                IntPointer rotulo = new IntPointer(1);
                                DoublePointer confidence = new DoublePointer(1);
                                recognizer.predict(faceCapturada, rotulo, confidence);
                                int prediction = rotulo.get(0);
                                if (prediction == -1) {
                                    rectangle(frame, dadosFace, new Scalar(0, 0, 255, 3), 3, 0, 0);
                                    id = 0;
                                    System.out.println("Người lạ !");
//                                    txt_hoten.setText("ABc");
//                                    txt_email.setText("");
//                                   txt_dienthoi.setText("");
                                   //JOptionPane.showMessageDialog(null, "Không có dự liệu");
                                } else {
                                    rectangle(frame, dadosFace, new Scalar(0, 255, 0, 3), 3, 0, 0);
                                    id = prediction;
                                    if(dao.selectById2(id)!=null){
                                        Auth.user = dao.selectById2(id);
                                        System.out.println(id);
                                        System.out.println("Auth thành công !");
                                        MsgBox.alert(null, "Đã lấy xong thông tin !");
                                    }                                   
                                    System.out.println(confidence.get(0));
                                    System.out.print("Nhận diện Thành công !");
                                    btnDangNhap.setEnabled(true);
                                    myThread.runnable = false;
                                    btnchay.setEnabled(true);
                                    btndung.setEnabled(false);
                                    webSource.release();
                                    //this.wait();
                                    //dispose();
                                    
                                    //lblid.setText(String.valueOf(id));
                                    //rec();
                                }
                            }

                            imencode(".bmp", frame, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.getStringBytes()));
                            BufferedImage buff = (BufferedImage) im;
                            if (g.drawImage(buff, 0, 0, 360, 390, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                if (runnable == false) {
                                    System.out.println("Dừng");
                                    this.wait();
                                }

                            }
                        } catch (Exception ex) {
                            System.out.println("Lỗi");
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private void rec() {

        new Thread() {
            @Override
            public void run() {
//                acp.conn();
//                try {
//                    String sql = "SELECT * FROM nguoidung WHERE id = " + String.valueOf(id);
//                    acp.executaSQL(sql);
//                    while (acp.rs.next()) {
//                        txt_hoten.setText(acp.rs.getString("hoten"));
//                        txt_email.setText(acp.rs.getString("email"));
//                        txt_dienthoi.setText(acp.rs.getString("sdt"));
//                        System.out.println("Họ và tên : " + acp.rs.getString("hoten") + "Id : " + acp.rs.getInt("id"));
////                        Array ident = acp.rs.getArray(2);
////                        String[] person = (String[]) ident.getArray();
////
////                        for (int i = 0 ;i < person.length;i++) {
////                            System.out.println(person[i]);
////                        }
//
//                    }
//                    
//                } catch (Exception e) {
//                    //e.printStackTrace();
//                }
//                //acp.dis();
            }
        }.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        label_photo = new javax.swing.JLabel();
        btnchay = new com.violet.UI.Button();
        btndung = new com.violet.UI.Button();
        btnDangNhap = new com.violet.UI.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));

        btnchay.setText("Mở camera");
        btnchay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchayActionPerformed(evt);
            }
        });

        btndung.setText("Tắt camera");
        btndung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndungActionPerformed(evt);
            }
        });

        btnDangNhap.setText("Đăng Nhập");
        btnDangNhap.setEnabled(false);
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addComponent(label_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnchay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDangNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnchay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btndung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnchayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchayActionPerformed
        webSource = new VideoCapture(0);
        myThread = new DaemonThread();
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();
        btnchay.setEnabled(false);
        btndung.setEnabled(true);
    }//GEN-LAST:event_btnchayActionPerformed

    private void btndungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndungActionPerformed
        myThread.runnable = false;
        btnchay.setEnabled(true);
        btndung.setEnabled(false);
        webSource.release();
    }//GEN-LAST:event_btndungActionPerformed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_btnDangNhapActionPerformed

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
            java.util.logging.Logger.getLogger(NhanDienDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanDienDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanDienDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanDienDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanDienDangNhap dialog = new NhanDienDangNhap(new javax.swing.JFrame(), true);
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
    private com.violet.UI.Button btnDangNhap;
    private com.violet.UI.Button btnchay;
    private com.violet.UI.Button btndung;
    private javax.swing.JLabel label_photo;
    private javax.swing.JPanel pnlBackground;
    // End of variables declaration//GEN-END:variables
}
