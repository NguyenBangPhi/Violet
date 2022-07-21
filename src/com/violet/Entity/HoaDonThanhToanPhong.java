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
public class HoaDonThanhToanPhong {
    private int MaHD;
    private Date NgayThue;
    private Date NgayTra;
    private double TienThanhToan;
    private String DanhGia;
    private int MaPhong;
    private int MaKH;
    private String MaNV;
    private Date NgayLapHD;

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public Date getNgayThue() {
        return NgayThue;
    }

    public void setNgayThue(Date NgayThue) {
        this.NgayThue = NgayThue;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }

    public double getTienThanhToan() {
        return TienThanhToan;
    }

    public void setTienThanhToan(double TienThanhToan) {
        this.TienThanhToan = TienThanhToan;
    }

    public String getDanhGia() {
        return DanhGia;
    }

    public void setDanhGia(String DanhGia) {
        this.DanhGia = DanhGia;
    }

    public int getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(int MaPhong) {
        this.MaPhong = MaPhong;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Date getNgayLapHD() {
        return NgayLapHD;
    }

    public void setNgayLapHD(Date NgayLapHD) {
        this.NgayLapHD = NgayLapHD;
    }

    @Override
    public String toString() {
        return "MaHD: " + MaHD + " MaKH: " + MaKH;
    }
    @Override
    public boolean equals(Object obj){
        HoaDonThanhToanPhong other = (HoaDonThanhToanPhong) obj;
        //System.out.println("Hello");
        return other.getMaHD()==this.getMaHD();
    }
    
}
