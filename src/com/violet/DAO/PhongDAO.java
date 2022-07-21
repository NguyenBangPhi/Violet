/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.DAO;

import com.violet.Entity.Phong;
import com.violet.Help.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PhongDAO extends VioletDAO<Phong, Integer>{

    String INSERT_SQL = "INSERT INTO Phong(TenPhong,DonGia,MaLoai) VALUES (?,?,?)";
    String UPDATE_SQL = "UPDATE Phong SET TenPhong=?, DonGia=?, MaLoai=? WHERE MaPhong=?";
    String DELETE_SQL = "DELETE FROM Phong WHERE MaPhong=?";
    String SELECT_ALL_SQL = "SELECT * FROM Phong";
    String SELECT_BY_ID_SQL = "SELECT * FROM Phong WHERE MaPhong=?";
    
    @Override
    public void insert(Phong entity) {
        try {
            JdbcHelper.update(INSERT_SQL, 
                    entity.getTenPhong(),entity.getDonGia(),entity.getMaLoai());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Phong entity) {
        try {
            JdbcHelper.update(UPDATE_SQL, 
                    entity.getTenPhong(), entity.getDonGia(), entity.getMaLoai(), entity.getMaPhong());
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
    public Phong selectById(Integer id) {
        List<Phong> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Phong> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<Phong> selectBySql(String sql, Object... args) {
        List<Phong> list = new ArrayList<Phong>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);           
            while(rs.next()){
                Phong entity = new Phong();
                entity.setMaPhong(rs.getInt("MaPhong"));
                entity.setTenPhong(rs.getString("TenPhong"));
                entity.setDonGia(rs.getDouble("DonGia"));
                entity.setMaLoai(rs.getString("MaLoai"));               
                list.add(entity);
            }    
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Integer> selectMaPhong(){
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query("select MaPhong from Phong");
            while(rs.next()){
                list.add(rs.getInt("MaPhong"));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Phong> selectByKeyword(String keyword){
        String sql = "SELECT * FROM Phong WHERE TenPhong LIKE ? or MaLoai Like ?";
        return this.selectBySql(sql, "%" + keyword + "%", "%" + keyword + "%");
    }
    public int selectTongSoPhong() throws SQLException{
        ResultSet rs = JdbcHelper.query("select COUNT(*) TongSoPhong from Phong");
        if(rs.next()){
            return rs.getInt("TongSoPhong");
        }
        return 0;
    }
    
}
