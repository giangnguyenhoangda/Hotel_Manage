/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import object.DichVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Hoang Giang
 */
public class QueryDichVu {

    Connection con;

    public QueryDichVu() {
        con = MyConnection.getConnection();
    }

    public DichVu timThongTinDichVu(String maDichVu) {
        DichVu dv = new DichVu();
        try {
            String sql = "select * from DichVu where MaDichVu=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDichVu);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dv.setMaDichVu(rs.getString(1).trim());
                dv.setTenDichVu(rs.getString(2).trim());
                dv.setGiaDichVu(rs.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dv;
    }

    public ArrayList<DichVu> layToanBoDichVu() {
        ArrayList<DichVu> ds = new ArrayList<>();
        try {
            String sql = "select * from DichVu";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DichVu dv = new DichVu();
                dv.setMaDichVu(rs.getString(1).trim());
                dv.setTenDichVu(rs.getString(2).trim());
                dv.setGiaDichVu(rs.getInt(3));
                ds.add(dv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public int themDichVu(DichVu dv) {
        try {
            String sql = "insert into DichVu values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dv.getMaDichVu());
            ps.setString(2, dv.getTenDichVu());
            ps.setInt(3, dv.getGiaDichVu());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return kq;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int xoaDichVu(DichVu dv) {
        int soLuong = 0;
        try {
            String sql = "delete from DichVu where MaDichVu=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dv.getMaDichVu());
            soLuong = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soLuong;
    }

    public int suaDichVu(DichVu dv) {
        int kq = 0;
        try {
            String sql = "update DichVu set TenDichVu=?,GiaDichVu=? where MaDichVu=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dv.getTenDichVu());
            ps.setInt(2, dv.getGiaDichVu());
            ps.setString(3, dv.getMaDichVu());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public ArrayList<DichVu> timKiemDichVu(DichVu dv) {
        ArrayList<DichVu> ketQua = new ArrayList<>();
        try {

            String sql = "select * from DichVu where MaDichVu Like ? AND TenDichVu Like ? And GiaDichVu Like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + dv.getMaDichVu() + "%");
            ps.setString(2, "%" + dv.getTenDichVu() + "%");
            if (dv.getGiaDichVu() == null) {
                ps.setString(3, "%%");
            } else {
                ps.setString(3, "%" + dv.getGiaDichVu() + "%");
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DichVu dichVuTimThay = new DichVu();
                dichVuTimThay.setMaDichVu(rs.getString(1).trim());
                dichVuTimThay.setTenDichVu(rs.getString(2).trim());
                dichVuTimThay.setGiaDichVu(rs.getInt(3));
                ketQua.add(dichVuTimThay);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
