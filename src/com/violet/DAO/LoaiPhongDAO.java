/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.DAO;

import com.violet.Entity.LoaiPhong;
import com.violet.Help.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LoaiPhongDAO extends VioletDAO<LoaiPhong, String>{

    String INSERT_SQL = "INSERT INTO LoaiPhong(MaLoai,TenLoai) VALUES (?,?)";
    String UPDATE_SQL = "UPDATE LoaiPhong SET TenLoai=? WHERE MaLoai=?";
    String DELETE_SQL = "DELETE FROM LoaiPhong WHERE MaLoai=?";
    String SELECT_ALL_SQL = "SELECT * FROM LoaiPhong";
    String SELECT_BY_ID_SQL = "SELECT * FROM LoaiPhong WHERE MaLoai=?";
    
    @Override
    public void insert(LoaiPhong entity) {
        try {
            JdbcHelper.update(INSERT_SQL, 
                    entity.getMaLoai(),entity.getTenLoai());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(LoaiPhong entity) {
        try {
            JdbcHelper.update(UPDATE_SQL, 
                    entity.getTenLoai(), entity.getMaLoai());
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
    public LoaiPhong selectById(String id) {
        List<LoaiPhong> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<LoaiPhong> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<LoaiPhong> selectBySql(String sql, Object... args) {
        List<LoaiPhong> list = new ArrayList<LoaiPhong>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);           
            while(rs.next()){
                LoaiPhong entity = new LoaiPhong();
                entity.setMaLoai(rs.getString("MaLoai"));
                entity.setTenLoai(rs.getString("TenLoai"));              
                list.add(entity);
            }    
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<String> selectMaLoai(){
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query("select MaLoai from LoaiPhong");
            while(rs.next()){
                list.add(rs.getString("MaLoai"));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
