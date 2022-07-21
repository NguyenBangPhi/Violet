/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.Entity;

/**
 *
 * @author Admin
 */
public class Phong {
    private int MaPhong;
    private String TenPhong;
    private double DonGia;
    private String MaLoai;

    public int getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(int MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    @Override
    public String toString() {
        return "Tên phòng: " + TenPhong + " Loại: " + MaLoai; //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean equals(Object obj){
        Phong other = (Phong) obj;
        //System.out.println("Hello");
        return other.getMaPhong()==this.getMaPhong();
    }
}
