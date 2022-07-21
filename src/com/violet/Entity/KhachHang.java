/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.Entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhachHang {
    private int MaKH;
    private String TenKH;
    private boolean GioiTinh;
    private String CMND;
    private String DienThoai;
    private Date NgaySinh;
    private String Email;
    private String MaNV;

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    @Override
    public String toString() {
        return "Mã khách hàng: " + MaKH + " Tên khách hàng: " + TenKH; //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean equals(Object obj){
        KhachHang other = (KhachHang) obj;
        //System.out.println("Hello");
        return other.getMaKH()==this.getMaKH();
    }
}
