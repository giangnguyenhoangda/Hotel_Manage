/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.ChucVu;
import object.NhanVien;

/**
 *
 * @author Nguyen Hoang Giang
 */
public class NhanVienService {

    private PreparedStatement preparedStatement;
    private Connection con;

    public NhanVienService() {
        super();
        con=MyConnection.getConnection();
    }

    public ArrayList<ChucVu> layDanhSachChucVu() {
        ArrayList<ChucVu> list = new ArrayList<>();
        String sql = "select * from ChucVu";
        try {
            preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ChucVu nv = new ChucVu();
                nv.setMaChucVu(resultSet.getString(1));
                nv.setTenChucVu(resultSet.getString(2));
                nv.setLuongChucVu(resultSet.getInt(3));
                list.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public ArrayList<NhanVien> layDanhSachNhanVien() {
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "select * from NhanVien,ChucVu where NhanVien.MaChucVu=ChucVu.MaChucVu";
        try {
            preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(resultSet.getString("MaNhanVien"));
                nv.setTenNhanVien(resultSet.getString("TenNhanVien"));
                nv.setGioiTinh(resultSet.getString("GioiTinh"));
                nv.setChucVu(new ChucVu(resultSet.getString("MaChucVu"), resultSet.getString("TenChucVu"), resultSet.getInt("LuongChucVu")));
                nv.setDiaChi(resultSet.getString("DiaChi"));
                nv.setcMND(resultSet.getString("CMND"));
                nv.setsDT(resultSet.getString("Phone"));
                nv.setThuong(resultSet.getInt("LuongThuong"));
                list.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int themNhanVien(NhanVien nv) {
        try {
            String sql = "insert into NhanVien values(?,?,?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, nv.getMaNhanVien());
            preparedStatement.setString(2, nv.getTenNhanVien());
            preparedStatement.setString(3, nv.getGioiTinh());
            preparedStatement.setString(4, nv.getChucVu().getMaChucVu());
            preparedStatement.setString(5, nv.getcMND());
            preparedStatement.setString(6, nv.getsDT());
            preparedStatement.setString(7, nv.getDiaChi());
            preparedStatement.setInt(8, nv.getThuong());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int suaNhanVien(NhanVien nv) {
        try {
            String sql = "update NhanVien set TenNhanVien=? ,GioiTinh =? , MaChucVu=? , CMND=? , Phone=? , DiaChi=?, LuongThuong=?  where MaNhanVien=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, nv.getTenNhanVien());
            preparedStatement.setString(2, nv.getGioiTinh());
            preparedStatement.setString(3, nv.getChucVu().getMaChucVu());
            preparedStatement.setString(4, nv.getcMND());
            preparedStatement.setString(5, nv.getsDT());
            preparedStatement.setString(6, nv.getDiaChi());
            preparedStatement.setString(7, nv.getThuong() + "");
            preparedStatement.setString(8, nv.getMaNhanVien());
            return preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int xoaNhanVien(String nv) {
        try {
            String sql = " delete from NhanVien where MaNhanVien=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, nv);
            return preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<NhanVien> timKiemTheoMa(String ma) {
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "select * from NhanVien,ChucVu where NhanVien.MaChucVu=ChucVu.MaChucVu and MaNhanVien like ?";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "%" + ma + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(resultSet.getString("MaNhanVien"));
                nv.setTenNhanVien(resultSet.getString("TenNhanVien"));
                nv.setGioiTinh(resultSet.getString("GioiTinh"));
                nv.setChucVu(new ChucVu(resultSet.getString("MaChucVu"), resultSet.getString("TenChucVu"), resultSet.getInt("LuongChucVu")));
                nv.setDiaChi(resultSet.getString("DiaChi"));
                nv.setcMND(resultSet.getString("CMND"));
                nv.setsDT(resultSet.getString("Phone"));
                nv.setThuong(resultSet.getInt("LuongThuong"));
                list.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<NhanVien> timKiemTheoTen(String ma) {
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "select * from NhanVien,ChucVu where NhanVien.MaChucVu=ChucVu.MaChucVu and TenNhanVien like ?";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "%" + ma + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(resultSet.getString("MaNhanVien"));
                nv.setTenNhanVien(resultSet.getString("TenNhanVien"));
                nv.setGioiTinh(resultSet.getString("GioiTinh"));
                nv.setChucVu(new ChucVu(resultSet.getString("MaChucVu"), resultSet.getString("TenChucVu"), resultSet.getInt("LuongChucVu")));
                nv.setDiaChi(resultSet.getString("DiaChi"));
                nv.setcMND(resultSet.getString("CMND"));
                nv.setsDT(resultSet.getString("Phone"));
                nv.setThuong(resultSet.getInt("LuongThuong"));
                list.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<NhanVien> timKiemTheoTatCa(String ma, String ten, String gioitinh, String cmnd, String sdt, String diachi, int thuong, String chucvu) {
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "select * from NhanVien,ChucVu where NhanVien.MaChucVu=ChucVu.MaChucVu and MaNhanVien like ? and TenNhanVien like ? and GioiTinh= ? and CMND like ? and Phone like ? and DiaChi like ? and LuongThuong =? and TenChucVu=?";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "%" + ma + "%");
            preparedStatement.setString(2, "%" + ten + "%");
            preparedStatement.setString(3, gioitinh);
            preparedStatement.setString(4, "%" + cmnd + "%");
            preparedStatement.setString(5, "%" + sdt + "%");
            preparedStatement.setString(6, "%" + diachi + "%");
            preparedStatement.setString(7, thuong + "");
            preparedStatement.setString(8, chucvu);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(resultSet.getString("MaNhanVien"));
                nv.setTenNhanVien(resultSet.getString("TenNhanVien"));
                nv.setGioiTinh(resultSet.getString("GioiTinh"));
                nv.setChucVu(new ChucVu(resultSet.getString("MaChucVu"), resultSet.getString("TenChucVu"), resultSet.getInt("LuongChucVu")));
                nv.setDiaChi(resultSet.getString("DiaChi"));
                nv.setcMND(resultSet.getString("CMND"));
                nv.setsDT(resultSet.getString("Phone"));
                nv.setThuong(resultSet.getInt("LuongThuong"));
                list.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<NhanVien> timKiemTheoTatCa(String ma, String ten, String gioitinh, String cmnd, String sdt, String diachi, String chucvu) {
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "select * from NhanVien,ChucVu where NhanVien.MaChucVu=ChucVu.MaChucVu and MaNhanVien like ? and TenNhanVien like ? and GioiTinh= ? and CMND like ? and Phone like ? and DiaChi like ? and TenChucVu=?";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "%" + ma + "%");
            preparedStatement.setString(2, "%" + ten + "%");
            preparedStatement.setString(3, gioitinh);
            preparedStatement.setString(4, "%" + cmnd + "%");
            preparedStatement.setString(5, "%" + sdt + "%");
            preparedStatement.setString(6, "%" + diachi + "%");
            preparedStatement.setString(7, chucvu);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(resultSet.getString("MaNhanVien"));
                nv.setTenNhanVien(resultSet.getString("TenNhanVien"));
                nv.setGioiTinh(resultSet.getString("GioiTinh"));
                nv.setChucVu(new ChucVu(resultSet.getString("MaChucVu"), resultSet.getString("TenChucVu"), resultSet.getInt("LuongChucVu")));
                nv.setDiaChi(resultSet.getString("DiaChi"));
                nv.setcMND(resultSet.getString("CMND"));
                nv.setsDT(resultSet.getString("Phone"));
                nv.setThuong(resultSet.getInt("LuongThuong"));
                list.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ResultSet thongKeTheoGioiTinh() {
        try {
            String sql = "select GioiTinh,count (GioiTinh) from NhanVien group by GioiTinh;";
            preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet thongKeTheoChucVu() {
        try {
            String sql = "select TenChucVu,count(TenChucVu) from ChucVu,NhanVien where ChucVu.MaChucVu=NhanVien.MaChucVu group by TenChucVu;";
            preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
