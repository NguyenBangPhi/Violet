/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.DAO;

import com.violet.Entity.NhanVien;
import com.violet.Help.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienDAO extends VioletDAO<NhanVien, String>{

    String INSERT_SQL = "INSERT INTO NhanVien(MaNV,TenNV,GioiTinh,DiaChi,DienThoai,NgaySinh,MatKhau,Email,VaiTro,Hinh,ID) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE NhanVien SET TenNV=?, GioiTinh=?, DiaChi=?, DienThoai=?, NgaySinh=?, MatKhau=?, Email=?, VaiTro=?, Hinh=?  WHERE MaNV=?";
    String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV=?";
    String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE MaNV=?";
    
    @Override
    public void insert(NhanVien entity) {
        try {
            JdbcHelper.update(INSERT_SQL, 
                    entity.getMaNV(), entity.getTenNV(), entity.getGioiTinh(),
                    entity.getDiaChi(), entity.getDienThoai(), entity.getNgaySinh(), 
                    entity.getMatKhau(), entity.getEmail(), entity.getVaiTro(), entity.getHinh());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(NhanVien entity) {
        try {
            JdbcHelper.update(UPDATE_SQL, 
                    entity.getTenNV(), entity.getGioiTinh(),
                    entity.getDiaChi(), entity.getDienThoai(), entity.getNgaySinh(), 
                    entity.getMatKhau(), entity.getEmail(), entity.getVaiTro(), entity.getHinh(), entity.getMaNV());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.update(DELETE_SQL, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);           
            while(rs.next()){
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setTenNV(rs.getString("TenNV"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setDiaChi(rs.getString("DiaChi"));     
                entity.setDienThoai(rs.getString("DienThoai"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setEmail(rs.getString("Email"));
                entity.setVaiTro(rs.getString("VaiTro"));
                entity.setHinh(rs.getString("Hinh"));
                entity.setId(rs.getInt("ID"));
                list.add(entity);
            }    
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<NhanVien> selectByKeyword(String keyword){
        String sql = "SELECT * FROM NhanVien WHERE MaNV LIKE ? or TenNV LIKE ? or Email LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%","%" + keyword + "%","%" + keyword + "%");
    }
    public List<String> selectVaiTro(){
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query("select VaiTro from NhanVien GROUP BY VaiTro");
            while(rs.next()){
                list.add(rs.getString("VaiTro"));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }      
    }
    public NhanVien selectById2(int id2) {
        List<NhanVien> list = this.selectBySql("select top 1 * from NhanVien where ID = ?", id2);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
}
