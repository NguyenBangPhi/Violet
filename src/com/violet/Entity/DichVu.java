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
public class DichVu {
    private String MaDV;
    private String TenDV;
    private String MoTaChiTiet;
    private double Gia;

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }

    public String getMoTaChiTiet() {
        return MoTaChiTiet;
    }

    public void setMoTaChiTiet(String MoTaChiTiet) {
        this.MoTaChiTiet = MoTaChiTiet;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }
    @Override
    public String toString() {
        return "MaDV: " + MaDV + " Tên DV: " + TenDV;
    }
    @Override
    public boolean equals(Object obj){
        DichVu other = (DichVu) obj;
        //System.out.println("Hello");
        return other.getMaDV().equals(this.getMaDV());
    }
}
