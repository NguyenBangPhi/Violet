/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.Help;

import com.violet.Entity.HoaDonThanhToanPhong;
import com.violet.Entity.KhachHang;
import com.violet.Entity.Phong;

/**
 *
 * @author Admin
 */
public class ThongTinNhanh {
    public static HoaDonThanhToanPhong hdttp = null;
    public static Phong p = null;
    public static KhachHang kh = null;
    
    
    public static boolean checkHDTTP(){
        return ThongTinNhanh.hdttp != null;
    }
    public static boolean checkPhong(){
        return ThongTinNhanh.p != null;
    }
    public static boolean checkKhachHang(){
        return ThongTinNhanh.kh != null;
    }
    public static void clearHDTTP(){
        ThongTinNhanh.hdttp = null;
    }
    public static void clearPhong(){
        ThongTinNhanh.p = null;
    }
    public static void clearKhachHang(){
        ThongTinNhanh.kh = null;
    }
}
