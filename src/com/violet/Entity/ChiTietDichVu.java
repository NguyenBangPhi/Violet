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
public class ChiTietDichVu {
    private int MaHD;
    private String MaDV;
    private Date NgayDK;

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public Date getNgayDK() {
        return NgayDK;
    }

    public void setNgayDK(Date NgayDK) {
        this.NgayDK = NgayDK;
    }
//    @Override
//    public String toString() {
//        return "MaHD: " + MaHD;
//    }
//    @Override
//    public boolean equals(Object obj){
//        ChiTietDichVu other = (ChiTietDichVu) obj;
//        //System.out.println("Hello");
//        return other.getMaHD()==this.getMaHD();
//    }
    
}
