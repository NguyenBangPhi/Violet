/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.DAO;

import com.violet.Entity.DichVu;
import com.violet.Help.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DichVuDAO extends VioletDAO<DichVu, String>{

    String INSERT_SQL = "INSERT INTO DichVu(MaDV,TenDV,MoTaChiTiet,Gia) VALUES (?,?,?,?)";
    String UPDATE_SQL = "UPDATE DichVu SET TenDV=?, MoTaChiTiet=?, Gia=? WHERE MaDV=?";
    String DELETE_SQL = "DELETE FROM DichVu WHERE MaDV=?";
    String SELECT_ALL_SQL = "SELECT * FROM DichVu";
    String SELECT_BY_ID_SQL = "SELECT * FROM DichVu WHERE MaDV=?";
    
    @Override
    public void insert(DichVu entity) {
        try {
            JdbcHelper.update(INSERT_SQL, 
                    entity.getMaDV(), entity.getTenDV(),entity.getMoTaChiTiet(),entity.getGia());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DichVu entity) {
        try {
            JdbcHelper.update(UPDATE_SQL, 
                    entity.getTenDV(),entity.getMoTaChiTiet(),entity.getGia(),entity.getMaDV());
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
    public DichVu selectById(String id) {
        List<DichVu> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DichVu> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<DichVu> selectBySql(String sql, Object... args) {
        List<DichVu> list = new ArrayList<DichVu>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);           
            while(rs.next()){
                DichVu entity = new DichVu();
                entity.setMaDV(rs.getString("MaDV"));
                entity.setTenDV(rs.getString("TenDV"));
                entity.setMoTaChiTiet(rs.getString("MoTaChiTiet"));
                entity.setGia(rs.getDouble("Gia"));                              
                list.add(entity);
            }    
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<DichVu> selectByKeyword(String keyword){
        String sql = "SELECT * FROM DichVu WHERE MaDV LIKE ? or TenDV LIKE ? or MoTaChiTiet LIKE ? ";
        return this.selectBySql(sql, "%" + keyword + "%","%" + keyword + "%","%" + keyword + "%");
    }
}
