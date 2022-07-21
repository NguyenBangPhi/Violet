/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.DAO;

import com.violet.Entity.ChiTietDichVu;
import com.violet.Help.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChiTietDichVuDAO extends VioletDichVuDAO<ChiTietDichVu, Integer, String>{

    String INSERT_SQL = "INSERT INTO ChiTietDichVu(MaHD,MaDV) VALUES (?,?)";
    String UPDATE_SQL = "UPDATE ChiTietDichVu SET NgayDK=? WHERE MaHD=? and MaDV=?";
    String DELETE_SQL = "DELETE FROM ChiTietDichVu WHERE MaHD=? and MaDV=?";
    String SELECT_ALL_SQL = "SELECT * FROM ChiTietDichVu";
    String SELECT_BY_ID_SQL = "SELECT * FROM ChiTietDichVu WHERE MaHD=? and MaDV=?";
    
    @Override
    public void insert(ChiTietDichVu entity) {
        try {
            JdbcHelper.update(INSERT_SQL, entity.getMaHD(),entity.getMaDV());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ChiTietDichVu entity) {
        try {
            JdbcHelper.update(UPDATE_SQL, entity.getNgayDK(),entity.getMaHD(),entity.getMaDV());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id1, String id2) {
        try {
            JdbcHelper.update(DELETE_SQL, id1, id2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ChiTietDichVu selectById(Integer id1, String id2) {
        List<ChiTietDichVu> list = this.selectBySql(SELECT_BY_ID_SQL, id1, id2);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChiTietDichVu> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<ChiTietDichVu> selectBySql(String sql, Object... args) {
        List<ChiTietDichVu> list = new ArrayList<ChiTietDichVu>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);           
            while(rs.next()){
                ChiTietDichVu entity = new ChiTietDichVu();
                entity.setMaHD(rs.getInt("MaHD"));
                entity.setMaDV(rs.getString("MaDV"));
                entity.setNgayDK(rs.getDate("NgayDK"));              
                list.add(entity);
            }    
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectMaHD(){
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query("SELECT MaHD from ChiTietDichVu GROUP BY MaHD");
            while(rs.next()){
                list.add(rs.getInt("MaHD"));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<String> selectMaDV(){
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query("SELECT MaDV from ChiTietDichVu GROUP BY MaDV");
            while(rs.next()){
                list.add(rs.getString("MaDV"));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<String> selectDVdaDK(Integer maHD){
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query("SELECT MaDV FROM ChiTietDichVu Where MaHD = ?",maHD);
            while(rs.next()){
                list.add(rs.getString("MaDV"));
            }
            if(list.isEmpty()){
                return null;
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Object[]> selectAllvaTenDV(){
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query("select MaHD,ChiTietDichVu.MaDV,TenDV,NgayDK from ChiTietDichVu join DichVu on DichVu.MaDV = ChiTietDichVu.MaDV");
            while(rs.next()){
                list.add(new Object[]{rs.getInt("MaHD"),rs.getString("MaDV"),rs.getString("TenDV"),rs.getDate("NgayDK")});
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Object[]> selectDVDKtheoMaHDTTPhong(int MaHD){
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query("select ChiTietDichVu.MaDV,TenDV,Gia from ChiTietDichVu join DichVu on DichVu.MaDV = ChiTietDichVu.MaDV where MaHD = ?", MaHD);
            while(rs.next()){
                list.add(new Object[]{ rs.getString("MaDV"),rs.getString("TenDV"),rs.getDouble("Gia")});
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Object[]> selectMaDVTenDVGia(int maHD){
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query("select ct.MaDV,TenDV,Gia,NgayDK from DichVu join ChiTietDichVu ct on ct.MaDV = DichVu.MaDV where MaHD = ?", maHD);
            while(rs.next()){
                list.add(new Object[]{rs.getString("MaDV"),rs.getString("TenDV"),rs.getDouble("Gia"),rs.getDate("NgayDK")});
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
