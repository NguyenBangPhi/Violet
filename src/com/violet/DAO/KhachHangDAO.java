/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.DAO;

import com.violet.Entity.KhachHang;
import com.violet.Help.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangDAO extends VioletDAO<KhachHang, Integer>{

    String INSERT_SQL = "INSERT INTO KhachHang(TenKH,GioiTinh,CMND,DienThoai,NgaySinh,Email,MaNV) VALUES (?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE KhachHang SET TenKH=?, GioiTinh=?, CMND=?, DienThoai=?, NgaySinh=?, Email=?, MaNV=? WHERE MaKH=?";
    String DELETE_SQL = "DELETE FROM KhachHang WHERE MaKH=?";
    String SELECT_ALL_SQL = "SELECT * FROM KhachHang";
    String SELECT_BY_ID_SQL = "SELECT * FROM KhachHang WHERE MaKH=?";
    
    @Override
    public void insert(KhachHang entity) {
        try {
            JdbcHelper.update(INSERT_SQL, 
                    entity.getTenKH(), entity.getGioiTinh(), 
                    entity.getCMND(),entity.getDienThoai(), entity.getNgaySinh(),entity.getEmail(),entity.getMaNV());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(KhachHang entity) {
        try {
            JdbcHelper.update(UPDATE_SQL, 
                    entity.getTenKH(), entity.getGioiTinh(), entity.getCMND(), 
                    entity.getDienThoai(), entity.getNgaySinh(),entity.getEmail(),entity.getMaNV(), entity.getMaKH());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            JdbcHelper.update(DELETE_SQL, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public KhachHang selectById(Integer id) {
        List<KhachHang> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhachHang> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<KhachHang>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);           
            while(rs.next()){
                KhachHang entity = new KhachHang();
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setTenKH(rs.getString("TenKH"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setCMND(rs.getString("CMND"));  
                entity.setDienThoai(rs.getString("DienThoai"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setEmail(rs.getString("Email"));
                entity.setMaNV(rs.getString("MaNV"));
                list.add(entity);
            }    
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<KhachHang> selectByKeyword(String keyword){
        String sql = "SELECT * FROM KhachHang WHERE TenKH LIKE ? or Email LIKE ? or MaNV LIKE ?";
        return this.selectBySql(sql,"%"+keyword+"%","%"+keyword+"%","%"+keyword+"%");
    }
    public List<Integer> selectMaKH(){
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query("select MaKH from KhachHang");
            while(rs.next()){
                list.add(rs.getInt("MaKH"));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<KhachHang> selectKhachHangCMSN(Date ngaysinh){
        List<KhachHang> list = this.selectBySql("select * from KhachHang where MONTH(NgaySinh) = MONTH(?) and DAY(NgaySinh) = Day(?)", ngaysinh,ngaysinh);
        if(list.isEmpty()){
            return null;
        }
        return list;
    }
}
