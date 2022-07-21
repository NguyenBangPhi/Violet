/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.main;

import com.violet.DAO.KhachHangDAO;
import com.violet.DAO.NhanVienDAO;
import com.violet.Entity.DichVu;
import com.violet.Entity.KhachHang;
import com.violet.Entity.NhanVien;
import com.violet.Help.MsgBox;
import com.violet.Help.XDate;
import com.violet.UI.CuaSoChao2JDialog;
import com.violet.UI.CuaSoChaoJDialog;
import com.violet.UI.CuaSoDangNhapJDialog;
import com.violet.UI.CuaSoGioiThieuJDialog;
//import testgiaodien.DangKiDichVuJDialog;
import com.violet.UI.DichVuJDialog;
import com.violet.UI.DoanhThuJDialog;
import com.violet.UI.HoaDonDichVuJDialog;
import com.violet.UI.KhachHangJDialog;
import com.violet.UI.LuotWebJDialog;
import com.violet.UI.NhanVienJDialog;
import com.violet.UI.Phong_LoaiPhong_JDialog;
import com.violet.UI.QuanLiDangKiDVJDialog;
import com.violet.UI.QuenMatKhauJDialog;
import com.violet.UI.ThanhToanJDialog;
import com.violet.chart.MainChart;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author Admin
 */
public class MainChinh extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;
    
    public MainChinh() {
        initComponents();
        init();
    }

    private void init(){
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header();
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                //System.out.println("Menu Index: "+menuIndex+ "SubMenuIndex:"+subMenuIndex);
                if(menuIndex == 0 ){
                    if(subMenuIndex == 0){
                        new DichVuJDialog(null, true).setVisible(true);
                    }
                    if(subMenuIndex == 1){
                        new QuanLiDangKiDVJDialog(null, true).setVisible(true);
                    }
                    if(subMenuIndex == 2){
                        new HoaDonDichVuJDialog(null, true).setVisible(true);
                    }
                }
                if(menuIndex == 1){
                    if(subMenuIndex == 0){
                        new NhanVienJDialog(null, true).setVisible(true);
                    }
                }
                if(menuIndex == 2){
                    if(subMenuIndex == 0){
                        new KhachHangJDialog(null, true).setVisible(true);
                    }
                }
                if(menuIndex == 3){
                    if(subMenuIndex == 0){
                        new ThanhToanJDialog(null, true).setVisible(true);
                    }
                }
                if(menuIndex == 4){
                    if(subMenuIndex == 0){
                        new DoanhThuJDialog(null, true).setVisible(true);
                    }
                }
                if(menuIndex == 5){
                    if(subMenuIndex == 0){
                        new MainChart(null, true).setVisible(true);
                    }
                }
                if(menuIndex == 6){
                    if(subMenuIndex == 0){
                        new Phong_LoaiPhong_JDialog(null, true).setVisible(true);
                    }
                }
                if(menuIndex == 7){
                    if(subMenuIndex == 0){
                        new QuenMatKhauJDialog(null, true).setVisible(true);
                    }
                }
                if(menuIndex == 8){
                    if(subMenuIndex == 0){
                        new LuotWebJDialog(null, true).setVisible(true);
                    }
                    if(subMenuIndex == 1){
                        GuiFile();
                    }
                    if(subMenuIndex == 2){
                        GuiMailChucSinhNhat();
                    }
                    if(subMenuIndex == 3){
                        JFileChooser fc = new JFileChooser();
                        if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                            executeSql(fc.getSelectedFile().getAbsolutePath());
                        }
                    }
                    if(subMenuIndex == 4){
                        new CuaSoGioiThieuJDialog(null, true).setVisible(true);
                    }
                    if(subMenuIndex == 5){
                        if(MsgBox.confirm(null, "Bạn muốn kết thúc ứng dụng ?")){
                            System.exit(0);
                        }
                    }
                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem)com;
                PopupMenu popup = new PopupMenu(MainChinh.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = MainChinh.this.getX()+52;
                int y = MainChinh.this.getY()+com.getY()+86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        bg.add(menu,"w 230!, spany 2"); // Span Y 2cell
        bg.add(header, "h 50!,wrap");
        bg.add(main,"w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                double width;
                if(menu.isShowMenu()){
                    width = 60 + (170*(1f-fraction));
                }else{
                    width = 60 + (170*fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }
            
            
        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!animator.isRunning()){
                    animator.start();
                }
                menu.setEnableMenu(false);
                if(menu.isShowMenu()){
                    menu.hideallMenu();
                }
            }
        });
        new CuaSoChaoJDialog(this, true).setVisible(true);
        new CuaSoDangNhapJDialog(this, true).setVisible(true);
        new CuaSoChao2JDialog(this, true).setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1400, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainChinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
    KhachHangDAO dao = new KhachHangDAO();
    private void GuiMailChucSinhNhat(){
        if(dao.selectKhachHangCMSN(XDate.now())!=null){
            try {
                Properties p = new Properties();
                p.put("mail.smtp.auth", "true");
                p.put("mail.smtp.starttls.enable", "true");
                p.put("mail.smtp.host", "smtp.gmail.com");
                p.put("mail.smtp.port", 587); 
                //-----
                final String accountName = "bangphin1@gmail.com";
                final String accountPassword = "dl01869182991";  
                Session s = Session.getInstance(p,
                        new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                //4.xac thuc tai khoan email cua ban va mat khau
                                return new PasswordAuthentication(accountName, accountPassword); 
                            }
                        });
                //--------
                List<KhachHang> dstam = dao.selectKhachHangCMSN(XDate.now());
                String from = "bangphin1@gmail.com";
                String to = "";
                
                for (KhachHang row : dstam) {
                    to = row.getEmail();
                    String subject = "Khách Sạn Violet";
                    String body = "--- Chúc Mừng Sinh Nhật Khách Hàng ---\n";

                    body += "Chúc quí khách có sinh thần thật vui vẻ và hạnh phúc\n";

                    Message msg = new MimeMessage(s);

                    msg.setFrom(new InternetAddress(from));
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                    msg.setSubject(subject);
                    msg.setText(body);
                    //-----------
                    Transport.send(msg);

                }           
                

                JOptionPane.showMessageDialog(null, "Đã gửi chúc mừng thành công !", "Message", 
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
        }else{
            MsgBox.alert(null, "Không có khách hàng nào có sinh nhật vào hôm nay !");
        }
    }
    
    private void GuiFile() {
        JFileChooser fChooser = new JFileChooser();
        fChooser.setMultiSelectionEnabled(false);
        int selecttion = fChooser.showDialog(null,"Open File Lưu");
        
        if ( selecttion == fChooser.APPROVE_OPTION ){
            File fAttach = fChooser.getSelectedFile();           
            String duongdan = fAttach.getPath();
            SendMail(duongdan);
        }
        else
            MsgBox.alert(null, "Không tìm thấy đường dẫn !");
    }
    
    private void SendMail(String duongdan){
        try {
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", 587);
            String accountName = "bangphin1@gmail.com";
            String accountPassword = "dl01869182991";
            Session s = Session.getInstance(p,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(accountName, accountPassword);
                        }});          
            String from = "bangphin1@gmail.com";
            String to = MsgBox.prompt(this, "Nhập vào các Email cần gửi File: ");
            String subject = "BẢNG ĐIỂM";
            String body = "";
            String mailnhan = "";
            String[] temp = to.split(",");
            for(String ss :  temp){
                Message msg = new MimeMessage(s);
                msg.setFrom(new InternetAddress(from));
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ss));
                msg.setSubject(subject);
                msg.setText(body);
                msg.setSentDate(new Date());

                MimeBodyPart textPart = new MimeBodyPart();
                textPart.setContent(body, "text/plain");
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(textPart);
                String strAttach = duongdan.trim();
                if (!strAttach.equals("")) {
                    MimeBodyPart attachFilePart = new MimeBodyPart();
                    FileDataSource fds = new FileDataSource(strAttach);
                    attachFilePart.setDataHandler(new DataHandler(fds));
                    attachFilePart.setFileName(fds.getName());
                    mp.addBodyPart(attachFilePart);
                }
                msg.setContent(mp);
                Transport.send(msg);
                mailnhan = mailnhan + "- " + ss.trim() + "\n";
                //--------------------------------------------------
                
            }
            MsgBox.alert(this,"Các mail đã gửi thành công là: \n" + mailnhan);
            
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
    private static void executeSql(String sqlFilePath) {
        final class SqlExecuter extends SQLExec {
            public SqlExecuter() {
                Project project = new Project();
                project.init();
                setProject(project);
                setTaskType("sql");
                setTaskName("sql");
            }
        }

        SqlExecuter executer = new SqlExecuter();
        executer.setSrc(new File(sqlFilePath));
        executer.setDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        executer.setPassword("songlong");
        executer.setUserid("sa");
        executer.setUrl("jdbc:sqlserver://localhost:1433;");
        executer.execute();
    }
}
