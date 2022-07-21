/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author Admin
 */
public class Menu extends javax.swing.JPanel {



    /**
     * @return the showMenu
     */
    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }
    
    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;
    
    public Menu() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);

    }

    public void initMenuItem(){
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/violet/iconmain/2.png")), "Dịch Vụ", "Quản Lí Dịch Vụ", "Đăng Kí Dịch Vụ", "Hóa Đơn Dịch Vụ"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/violet/iconmain/5.png")), "Nhân Viên", "Quản Lí Nhân Viên"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/violet/iconmain/3.png")), "Khách Hàng", "Quản Lí Khách Hàng"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/violet/iconmain/11.png")), "Thanh Toán", "Quản Lí Thanh Toán"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/violet/iconmain/12.png")), "Doanh Thu", "Quản Lí Doanh Thu"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/violet/iconmain/8.png")), "Thống Kê", "Quản Lí Thống Kê"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/violet/iconmain/7.png")), "Phòng_Loại Phòng", "Quản Lí Phòng_Loại Phòng"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/violet/iconmain/6.png")), "Tài Khoản", "Đổi Mật Khẩu"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/violet/iconmain/9.png")), "App","Google","Gửi Mail File","Gửi lời chúc sinh nhật","Tạo Database","Giới thiệu","Thoát"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/violet/iconmain/10.png")), "Chat App", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/violet/iconmain/11.png")), "Contace", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/violet/iconmain/12.png")), "File Manager", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/violet/iconmain/13.png")), "Our Centres"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/violet/iconmain/14.png")), "Gallery"));
    }
    
    private void addMenu(ModelMenu menu){
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()),"h 40!");
    }
    
    private EventMenu getEventMenu(){
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if(enableMenu){
                    if(showMenu){
                        if(open){
                            new MenuAnimation(layout, com).openMenu();
                        }else{
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    }else{
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }
    
    public void hideallMenu(){
        for(Component com:panel.getComponents()){
            MenuItem item = (MenuItem) com;
            if(item.isOpen()){
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        profile1 = new com.violet.main.Profile();

        sp.setBackground(new java.awt.Color(214, 217, 223));
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setViewportBorder(null);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        profile1.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(33,105,249), getWidth(), 0, new Color(93,58,196));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs); 
        
        
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private com.violet.main.Profile profile1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
