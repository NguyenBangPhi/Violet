/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.DAO;

import com.violet.Help.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DoanhThuDAO {
    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args){
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs =  JdbcHelper.query(sql, args);
            while(rs.next()){
                Object[] vals = new Object[cols.length];
                for(int i = 0; i < cols.length; i++){
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;          
        } catch (Exception e) {
            throw new RuntimeException(e);
        }   
    }
    public List<Object[]> getTongDoanhThuAll(){
        String sql = "{CALL sp_TongDoanhThu}";
        String[] cols = {"MaHD","NgayThuPhi","NhanVienThu","TienThanhToan"};
        return this.getListOfArray(sql, cols);
    }
    public List<Object[]> getTongDoanhThuMonthAndYear(int thang,int nam){
        String sql = "{CALL sp_TongDoanhThu2(?,?)}";
        String[] cols = {"MaHD","NgayThuPhi","NhanVienThu","TienThanhToan"};
        return this.getListOfArray(sql, cols, thang, nam);
    }
    public List<Object[]> getTongDoanhThuPhong(){
        String sql = "{CALL sp_DoanhThuPhong}";
        String[] cols = {"TenPhong","NgayCheckIn","NgayCheckOut","DonGia"};
        return this.getListOfArray(sql, cols);
    }
    public List<Object[]> getDoanhThuPhongMonthAndYear(int thang,int nam){
        String sql = "{CALL sp_DoanhThuPhong2(?,?)}";
        String[] cols = {"TenPhong","NgayCheckIn","NgayCheckOut","DonGia"};
        return this.getListOfArray(sql, cols, thang, nam);
    }
    public List<Object[]> getDoanhThuDichVu(){
        String sql = "{CALL sp_DoanhThuDichVu}";
        String[] cols = {"MaDV","TenDV","TongTienThuDuoc"};
        return this.getListOfArray(sql, cols);
    }
    public List<Object[]> getDoanhThuDichVu2(int thang,int nam){
        String sql = "{CALL sp_DoanhThuDichVu2(?,?)}";
        String[] cols = {"MaDV","TenDV","TongTienThuDuoc"};
        return this.getListOfArray(sql, cols,thang,nam);
    }
    public List<Object[]> getTienDichVuMonthAndYear(int thang1, int thang2, int nam){
        String sql = "{CALL sp_ThongKeDichVu(?,?,?)}";
        String[] cols = {"MaDV","TongTien"};
        return this.getListOfArray(sql, cols,thang1,thang2,nam);
    }
    
}
