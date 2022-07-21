/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violet.DAO;

import com.violet.Entity.HoaDonThanhToanPhong;
import com.violet.Help.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonThanhToanPhongDAO extends VioletDAO<HoaDonThanhToanPhong, Integer>{

    String INSERT_SQL = "INSERT INTO HoaDonThanhToanPhong(NgayThue,NgayTra,TienThanhToan,DanhGia,MaPhong,MaKH,MaNV) VALUES (?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE HoaDonThanhToanPhong SET NgayThue=?, NgayTra=?, TienThanhToan=?,DanhGia=?,MaPhong=?,MaKH=?,MaNV=? WHERE MaHD=?";
    String DELETE_SQL = "DELETE FROM HoaDonThanhToanPhong WHERE MaHD=?";
    String SELECT_ALL_SQL = "SELECT * FROM HoaDonThanhToanPhong";
    String SELECT_BY_ID_SQL = "SELECT * FROM HoaDonThanhToanPhong WHERE MaHD=?";
    
    @Override
    public void insert(HoaDonThanhToanPhong entity) {
        try {
            JdbcHelper.update(INSERT_SQL, 
                    entity.getNgayThue(),entity.getNgayTra(),entity.getTienThanhToan(),
                    entity.getDanhGia(),entity.getMaPhong(),entity.getMaKH(),entity.getMaNV());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(HoaDonThanhToanPhong entity) {
        try {
            JdbcHelper.update(UPDATE_SQL, 
                    entity.getNgayThue(),entity.getNgayTra(),entity.getTienThanhToan(),
                    entity.getDanhGia(),entity.getMaPhong(),entity.getMaKH(),entity.getMaNV(),
                    entity.getMaHD());
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
    public HoaDonThanhToanPhong selectById(Integer id) {
        List<HoaDonThanhToanPhong> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDonThanhToanPhong> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<HoaDonThanhToanPhong> selectBySql(String sql, Object... args) {
        List<HoaDonThanhToanPhong> list = new ArrayList<HoaDonThanhToanPhong>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);           
            while(rs.next()){
                HoaDonThanhToanPhong entity = new HoaDonThanhToanPhong();
                entity.setMaHD(rs.getInt("MaHD"));
                entity.setNgayThue(rs.getDate("NgayThue"));
                entity.setNgayTra(rs.getDate("NgayTra"));
                entity.setTienThanhToan(rs.getDouble("TienThanhToan"));  
                entity.setDanhGia(rs.getString("DanhGia"));
                entity.setMaPhong(rs.getInt("MaPhong"));
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setNgayLapHD(rs.getDate("NgayLapHD"));
                list.add(entity);
            }    
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//    public List<HoaDonThanhToanPhong> selectByKeyword(String keyword){
//        String sql = "SELECT * FROM HoaDonThanhToanPhong WHERE MaHD = ? or MaKH = ?";
//        return this.selectBySql(sql, keyword , keyword );
//    }
    public List<Integer> selectMaHDTHPhong(){
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query("select MaHD from HoaDonThanhToanPhong");
            while(rs.next()){
                list.add(rs.getInt("MaHD"));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public double selectGiaDV(String MaDV) throws SQLException{
        ResultSet rs = JdbcHelper.query("select Gia from DichVu where MaDV = ?", MaDV);
        if(rs.next()){
            return rs.getDouble("Gia");
        }else{
            return 0.0;
        }
        
    }
    
    public void updateTienThanhToan(Integer MaHD, double giaUpdate) throws SQLException{
        JdbcHelper.update("UPDATE HoaDonThanhToanPhong SET TienThanhToan= (TienThanhToan + ?) where MaHD=?",giaUpdate, MaHD);
    }
    
    public List<Integer> selectNamHD(){
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query("SELECT YEAR(NgayTra) NgayThanhToan from HoaDonThanhToanPhong GROUP BY YEAR(NgayTra) ORDER BY YEAR(NgayTra) ASC");
            while(rs.next()){
                list.add(rs.getInt("NgayThanhToan"));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public double selectTienThanhToanMonthAndYear(int thang,int nam){
        try {
            ResultSet rs = JdbcHelper.query("select SUM(TienThanhToan) as 'TienThanhToan' from HoaDonThanhToanPhong where MONTH(NgayTra) = ? and YEAR(NgayTra) = ?", thang,nam);
            if(rs.next()){
                return rs.getDouble("TienThanhToan");
            }else{
                return 0.0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
    public List<HoaDonThanhToanPhong> selectByKeyword(String keyword){
        String sql = "SELECT * FROM HoaDonThanhToanPhong WHERE MaNV LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
    public boolean xetPhongDangSuDung(int maHD){
        String sql = "select IIF(NgayTra >= GETDATE() and NgayThue <= GETDATE(),1,0) as 'TrangThai' from HoaDonThanhToanPhong where MaPhong = ?";
        try {
            ResultSet rs = JdbcHelper.query(sql, maHD);
            while(rs.next()){
                if(rs.getBoolean("TrangThai")==true){
                    return true;//Phong Da Thue
                }
            }
            return false;//Phong Chua Thue
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
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
    public List<Object[]> getThongTinPhongDangThue(int maPhong){
        String sql = "{CALL sp_ThongTinPhongDangThue(?)}";
        String[] cols = {"MaPhong","MaKH","NgayTra"};
        return this.getListOfArray(sql, cols,maPhong);
    }
    public double getGiaPhongThanhToan(Date ngayThue,Date ngayTra,int maPhong){
        try {
            ResultSet rs = JdbcHelper.query("select DonGia*(DATEDIFF(day, ?, ?)+1) as 'TienThanhToan' from Phong where MaPhong = ? ", ngayThue, ngayTra, maPhong);
            if(rs.next()){
                return rs.getDouble("TienThanhToan");
            }
            return 0.0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
    public List<Object[]> selectHDtrongCTDV(){
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query("select hd.MaHD, TenKH from HoaDonThanhToanPhong hd join KhachHang kh on kh.MaKH = hd.MaKH where hd.MaHD in (select MaHD from ChiTietDichVu group by MaHD)");
            while(rs.next()){
                list.add(new Object[]{rs.getInt("MaHD"),rs.getString("TenKH")});
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Object[]> selectMaHDTenDVGia(int maHD){
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query("select ct.MaHD,TenDV,Gia from ChiTietDichVu ct join HoaDonThanhToanPhong hd on hd.MaHD = ct.MaHD join DichVu dv on dv.MaDV = ct.MaDV where ct.MaHD = ?", maHD);
            while(rs.next()){
                list.add(new Object[]{rs.getInt("MaHD"),rs.getString("TenDV"),rs.getDouble("Gia")});
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public double selectTongTienThanhToan(int maHD){
        try {
            ResultSet rs = JdbcHelper.query("select TienThanhToan from HoaDonThanhToanPhong where MaHD = ?", maHD);
            if(rs.next()){
                return rs.getDouble("TienThanhToan");
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
