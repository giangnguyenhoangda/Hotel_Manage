/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import object.ChiTietDichVu;
import object.DatPhong;
import object.HoaDon;
import object.Phong;

/**
 *
 * @author Nguyen Hoang Giang
 */
public class QueryChiTietDichVu {

    static Connection con = MyConnection.getConnection();

    public static void main(String[] args) {
        ChiTietDichVu chiTiet = new ChiTietDichVu();
        chiTiet.setMaDatPhong("DP0001");
        chiTiet.setMaHoaDon("HD0001");
        chiTiet.setMaPhong("0001");
        chiTiet.setSoLuong(5);
        chiTiet.setMaDichVu("DV0001");
        suaSoLuongDichVuTrongChiTietDichVu(chiTiet);
    }

    //lấy toàn bộ chi tiết dịch vụ mà phòng đang sử dụng
    public static ArrayList<ChiTietDichVu> layToanBoChiTietDichVuDaDung(ChiTietDichVu chiTiet) {
        ArrayList<ChiTietDichVu> ds = new ArrayList<>();
        try {
            String sql = "select ChiTietDichVu.MaDatPhong,ChiTietDichVu.MaHoaDon,ChiTietDichVu.MaPhong,ChiTietDichVu.MaDichVu,ChiTietDichVu.SoLuong\n"
                    + "from ChiTietDichVu \n"
                    + "where ChiTietDichVu.MaDatPhong=?\n"
                    + "AND ChiTietDichVu.MaPhong=?\n"
                    + "AND ChiTietDichVu.MaHoaDon=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, chiTiet.getMaDatPhong());
            ps.setString(2, chiTiet.getMaPhong());
            ps.setString(3, chiTiet.getMaHoaDon());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietDichVu ct = new ChiTietDichVu();
                ct.setMaDatPhong(rs.getString(1).trim());
                ct.setMaHoaDon(rs.getString(2).trim());
                ct.setMaPhong(rs.getString(3).trim());
                ct.setMaDichVu(rs.getString(4).trim());
                ct.setSoLuong(rs.getInt(5));
                ds.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public static int xoaChiTietDichVu(ChiTietDichVu ct) {
        int kq = 0;
        try {
            String sql = "delete from ChiTietDichVu "
                    + "where MaDatPhong=? And MaHoaDon=? And MaDichVu=? And MaPhong=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ct.getMaDatPhong());
            ps.setString(2, ct.getMaHoaDon());
            ps.setString(3, ct.getMaDichVu());
            ps.setString(4, ct.getMaPhong());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public static int suaSoLuongDichVuTrongChiTietDichVu(ChiTietDichVu ct) {
        int kq = 0;
        try {
            String sql = "update ChiTietDichVu set SoLuong=? "
                    + "where MaDatPhong=? And MaHoaDon=? And MaDichVu=? And MaPhong=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ct.getSoLuong());
            ps.setString(2, ct.getMaDatPhong());
            ps.setString(3, ct.getMaHoaDon());
            ps.setString(4, ct.getMaDichVu());
            ps.setString(5, ct.getMaPhong());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public static int giamSoLuongDichVu(ChiTietDichVu ct) {
        int kq = 0;
        try {
            Integer soLuong = ct.getSoLuong();
            if (soLuong <= 0) {
                xoaChiTietDichVu(ct);
            } else {
                soLuong--;
                ct.setSoLuong(soLuong);
                suaSoLuongDichVuTrongChiTietDichVu(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public static int them(ChiTietDichVu ct) {
        int kq = 0;
        try {
            String sql = "insert into ChiTietDichVu "
                    + "values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ct.getMaDatPhong());
            ps.setString(2, ct.getMaHoaDon());
            ps.setString(3, ct.getMaDichVu());
            ps.setString(4, ct.getMaPhong());
            ps.setInt(5, ct.getSoLuong());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public static ChiTietDichVu layChiTietDichVuCuoiCungTheoMaPhong(String phong) {
        ChiTietDichVu ct = new ChiTietDichVu();
        try {
            String sql = "select * from ChiTietDichVu where MaPhong=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, phong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ct.setMaDatPhong(rs.getString(1).trim());
                ct.setMaHoaDon(rs.getString(2).trim());
                ct.setMaPhong(rs.getString(4).trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ct;
    }
}
