/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import object.LoaiPhong;
import object.Phong;
import object.TinhTrangPhong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Nguyen Hoang Giang
 */
public class QueryPhong {

    static final Connection con = MyConnection.getConnection();

    public static ArrayList<TinhTrangPhong> layToanBoTinhTrangPhong() {
        ArrayList<TinhTrangPhong> ds = new ArrayList<>();
        try {
            String sql = "select * from TinhTrangPhong";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TinhTrangPhong tinhTrang = new TinhTrangPhong();
                tinhTrang.setMaTinhTrang(rs.getString(1).trim());
                tinhTrang.setTenTinhTrang(rs.getString(2).trim());
                ds.add(tinhTrang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public static ArrayList<LoaiPhong> layToanBoLoaiPhong() {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        try {
            String sql = "select * from LoaiPhong";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiPhong loaiPhong = new LoaiPhong();
                loaiPhong.setMaLoaiPhong(rs.getString(1));
                loaiPhong.setTenLoaiPhong(rs.getString(2));
                loaiPhong.setGiaLoaiPhong(rs.getInt(3));
                ds.add(loaiPhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public static ArrayList<Phong> timKiemPhong(Phong phong) {
        ArrayList<Phong> ketQua = new ArrayList<>();
        try {

            String sql = "select * from Phong where MaPhong Like ? AND TenPhong Like ? And MaTinhTrang Like ? And MaLoaiPhong Like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, phong.getMaPhong());
            ps.setString(2, phong.getTenPhong());
            ps.setString(3, phong.getMaTinhTrang());
            ps.setString(4, phong.getMaLoaiPhong());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Phong phongTimThay = new Phong();
                phongTimThay.setMaPhong(rs.getString(1).trim());
                phongTimThay.setTenPhong(rs.getString(2).trim());
                phongTimThay.setMaLoaiPhong(rs.getString(3).trim());
                phongTimThay.setMaTinhTrang(rs.getString(4).trim());
                ketQua.add(phongTimThay);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public static int themPhong(Phong phong) {
        int kq = 0;
        try {
            String sql = "Insert into Phong values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, phong.getMaPhong());
            ps.setString(2, phong.getTenPhong());
            ps.setString(3, phong.getMaLoaiPhong());
            ps.setString(4, phong.getMaTinhTrang());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public static ArrayList<Phong> layToanBoDanhSachPhong() {
        ArrayList<Phong> ds = new ArrayList<>();
        try {
            String sql = "select * from Phong";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Phong phong = new Phong();
                phong.setMaPhong(rs.getString(1).trim());
                phong.setTenPhong(rs.getString(2).trim());
                phong.setMaLoaiPhong(rs.getString(3).trim());
                phong.setMaTinhTrang(rs.getString(4).trim());
                ds.add(phong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public static int xoaPhong(Phong phong) {
        int soLuong = 0;
        try {
            String sql = "delete from Phong where MaPhong=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, phong.getMaPhong());
            soLuong = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soLuong;
    }

    public static int suaPhong(Phong phong) {
        int kq = 0;
        try {
            String sql = "update Phong set TenPhong=?,MaLoaiPhong=?,MaTinhTrang=? where MaPhong=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, phong.getTenPhong());
            ps.setString(2, phong.getMaLoaiPhong());
            ps.setString(3, phong.getMaTinhTrang());
            ps.setString(4, phong.getMaPhong());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public static int demSoPhongSanSang() {
        int count = 0;
        try {
            String sql = "Select Count(*) From Phong where MaTinhTrang=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "TinhTrang01");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int demSoPhongCoKhach() {
        int count = 0;
        try {
            String sql = "Select Count(*) From Phong where MaTinhTrang=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "TinhTrang02");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int demSoPhongChuaDonDep() {
        int count = 0;
        try {
            String sql = "Select Count(*) From Phong where MaTinhTrang=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "TinhTrang03");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int demSoPhongDangDonDep() {
        int count = 0;
        try {
            String sql = "Select Count(*) From Phong where MaTinhTrang=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "TinhTrang05");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int demSoPhongDangSuaChua() {
        int count = 0;
        try {
            String sql = "Select Count(*) From Phong where MaTinhTrang=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "TinhTrang04");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static HashMap<String, Integer> thongKeTheoLoaiPhong() {
        HashMap<String, Integer> ds = new HashMap<>();
        try {
            String sql = "Select TenLoaiPhong,Count(*) SoLuong from Phong,LoaiPhong where Phong.MaLoaiPhong=LoaiPhong.MaLoaiPhong Group By TenLoaiPhong";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String loaiPhong = rs.getString(1);
                Integer soLuong = rs.getInt(2);
                ds.put(loaiPhong, soLuong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public static HashMap<String, Integer> thongKeTheoTinhTrangPhong() {
        HashMap<String, Integer> ds = new HashMap<>();
        try {
            String sql = "Select TenTinhTrang,Count(*) SoLuong from Phong,TinhTrangPhong where Phong.MaTinhTrang=TinhTrangPhong.MaTinhTrang Group By TenTinhTrang";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tinhTrang = rs.getString(1);
                Integer soLuong = rs.getInt(2);
                ds.put(tinhTrang, soLuong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

}
