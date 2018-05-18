/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.MyConnection;
import model.QueryChiTietDichVu;
import object.ChiTietDichVu;

/**
 *
 * @author Nguyen Hoang Giang
 */
public class BLLChiTietDichVu {

    public static ArrayList<ChiTietDichVu> layToanBoDichVu(String maDatPhong, String maHoaDon, String maPhong) {
        ChiTietDichVu ct = new ChiTietDichVu();
        ct.setMaDatPhong(maDatPhong);
        ct.setMaHoaDon(maHoaDon);
        ct.setMaPhong(maPhong);
        return QueryChiTietDichVu.layToanBoChiTietDichVuDaDung(ct);
    }

    public static ChiTietDichVu layChiTietDichVuCuoiTheoPhong(String maPhong) {
        return QueryChiTietDichVu.layChiTietDichVuCuoiCungTheoMaPhong(maPhong);
    }

    public static int suaSoLuong(String maDatPhong, String maHoaDon, String maDichVu, String maPhong, Integer soLuong) {
        ChiTietDichVu ct = new ChiTietDichVu();
        ct.setMaDatPhong(maDatPhong);
        ct.setMaHoaDon(maHoaDon);
        ct.setMaDichVu(maDichVu);
        ct.setMaPhong(maPhong);
        ct.setSoLuong(soLuong);
        return QueryChiTietDichVu.suaSoLuongDichVuTrongChiTietDichVu(ct);
    }

    public static int themChiTietMuonTra(String maDatPhong, String maHoaDon, String maDichVu, String maPhong, Integer soLuong) {
        ChiTietDichVu ct = new ChiTietDichVu();
        ct.setMaDatPhong(maDatPhong);
        ct.setMaHoaDon(maHoaDon);
        ct.setMaDichVu(maDichVu);
        ct.setMaPhong(maPhong);
        ct.setSoLuong(soLuong);
        return QueryChiTietDichVu.them(ct);
    }
}
