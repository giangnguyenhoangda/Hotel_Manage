/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import object.KhachHang;

/**
 *
 * @author dell
 */
public class QueryKhachHang {

    Connection cn;

    public QueryKhachHang() {
        this.cn = MyConnection.getConnection();
    }

    public HashMap<String, Integer> thongKeTheoTen() {
        HashMap<String, Integer> ketQua = new HashMap<>();
        try {
            String sql = "select TenKhachHang,Count(*) from KhachHang group by TenKhachHang";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String srt = rs.getString(1);
                Integer soLuong = rs.getInt(2);
                ketQua.put(srt, soLuong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public HashMap<String, Integer> thongKeTheoGioiTinh() {
        HashMap<String, Integer> ketQua = new HashMap<>();
        try {
            String sql = "select GioiTinh,Count(*) from KhachHang group by GioiTinh";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String srt = rs.getString(1);
                Integer soLuong = rs.getInt(2);
                ketQua.put(srt, soLuong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public HashMap<String, Integer> thongKeTheoDiaChi() {
        HashMap<String, Integer> ketQua = new HashMap<>();
        try {
            String sql = "select DiaChi,Count(*) from KhachHang group by DiaChi";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String srt = rs.getString(1);
                Integer soLuong = rs.getInt(2);
                ketQua.put(srt, soLuong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<KhachHang> SelectFromKhachHang() {
        ArrayList<KhachHang> ds = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        String sql = "select * from KhachHang";
        try {
            statement = cn.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(rs.getString("MaKhachHang"));
                kh.setTenKhachHang(rs.getString("TenKhachHang"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setSdt(rs.getString("Phone"));
                kh.setCmnd(rs.getString("CMND"));
                kh.setDiaChi(rs.getString("DiaChi"));
                ds.add(kh);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return ds;
    }

    public int insertIntoKhachHang(KhachHang kh) {
        String sql = "Insert Into KhachHang values(?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, kh.getMaKhachHang());
            ps.setString(2, kh.getTenKhachHang());
            ps.setString(3, kh.getGioiTinh());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getCmnd());
            ps.setString(6, kh.getDiaChi());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return kq;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int suaKhachHang(KhachHang kh) {
        String sql = "Update KhachHang set TenKhachHang=?,GioiTinh=?,Phone=?,CMND=?,DiaChi=? where MaKhachHang=?";
        int kq = 0;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, kh.getTenKhachHang());
            ps.setString(2, kh.getGioiTinh());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getDiaChi());
            ps.setString(5, kh.getCmnd());
            ps.setString(6, kh.getDiaChi());
            kq = ps.executeUpdate();
            if (kq > 0) {
                return kq;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public int deleteKhachHang(KhachHang kh) {
        int kq = 0;
        String sql = "delete from KhachHang where MaKhachHang=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, kh.getMaKhachHang());
            kq = ps.executeUpdate();
            if (kq > 0) {
                return kq;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public ArrayList<KhachHang> timKiemKhachHang(KhachHang kh) {

        ArrayList<KhachHang> ds = new ArrayList();
        String sql = "SELECT * FROM KhachHang "
                + "where MaKhachHang like ? AND TenKhachHang like ? "
                + "AND GioiTinh like ? AND Phone like ? AND CMND like ? AND DiaChi like ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + kh.getMaKhachHang() + "%");
            ps.setString(2, "%" + kh.getTenKhachHang() + "%");
            ps.setString(3, "%" + kh.getGioiTinh() + "%");
            ps.setString(4, "%" + kh.getSdt() + "%");
            ps.setString(5, "%" + kh.getCmnd() + "%");
            ps.setString(6, "%" + kh.getDiaChi() + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maKhachHang = rs.getString("MaKhachHang");
                String tenKhachHang = rs.getString("TenKhachHang");
                String gioiTinh = rs.getString("GioiTinh");
                String sdt = rs.getString("Phone");
                String cmnd = rs.getString("CMND");
                String diaChi = rs.getString("DiaChi");
                KhachHang khachHangTimThay = new KhachHang();
                khachHangTimThay.setMaKhachHang(maKhachHang);
                khachHangTimThay.setTenKhachHang(tenKhachHang);
                khachHangTimThay.setGioiTinh(gioiTinh);
                khachHangTimThay.setSdt(sdt);
                khachHangTimThay.setCmnd(cmnd);
                khachHangTimThay.setDiaChi(diaChi);
                ds.add(khachHangTimThay);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public static void main(String[] args) {
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang("2");
        kh.setTenKhachHang("%2");
        kh.setGioiTinh("2");
        kh.setSdt("2");
        kh.setCmnd("2");
        kh.setDiaChi("%2");
        QueryKhachHang k = new QueryKhachHang();
        int q = k.deleteKhachHang(kh);
        if (q > 0) {
            System.out.println("OK");
        }
    }

    public int laySoThuTuCuoiCuaBangKhachHang() {
        int stt = 0;
        String maKhachHang = "";
        try {
            String sql = "Select MaKhachHang from KhachHang";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maKhachHang = rs.getString(1).trim();
            }
            if (!maKhachHang.equals("")) {
                maKhachHang = maKhachHang.substring(2);
                stt = Integer.parseInt(maKhachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stt;
    }

    public boolean kiemTraTonTaiMaKhachHang(KhachHang kh) {
        String sql = "Select MaKhachHang from KhachHang where MaKhachHang=?";
        String maKhachHangTimDuoc = "";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, kh.getMaKhachHang());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maKhachHangTimDuoc = rs.getString("MaKhachHang").trim();
            }
            if (maKhachHangTimDuoc.equals("")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
