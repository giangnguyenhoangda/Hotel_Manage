/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import model.QueryKhachHang;
import object.KhachHang;

/**
 *
 * @author dell
 */
public class BLLKhachHang {

    QueryKhachHang khachHang;

    public BLLKhachHang() {
        khachHang = new QueryKhachHang();
    }

    public ArrayList<KhachHang> layToanBoKhachHang() {
        return khachHang.SelectFromKhachHang();
    }

    public HashMap<String, Integer> thongKeTheoTen() {
        return khachHang.thongKeTheoTen();
    }

    public HashMap<String, Integer> thongKeTheoGioiTinh() {
        return khachHang.thongKeTheoGioiTinh();
    }

    public HashMap<String, Integer> thongKeTheoDiaChi() {
        return khachHang.thongKeTheoDiaChi();
    }

    public int laySoThuTuCuoiBangSach() {
        return khachHang.laySoThuTuCuoiCuaBangKhachHang();
    }

    public int themKhachHang(String maKhachHang, String tenKhachHang, String gioiTinh, String sdt, String cmnd, String diaChi) {
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(maKhachHang);
        kh.setTenKhachHang(tenKhachHang);
        kh.setGioiTinh(gioiTinh);
        kh.setSdt(sdt);
        kh.setCmnd(cmnd);
        kh.setDiaChi(diaChi);
        return khachHang.insertIntoKhachHang(kh);
    }

    public int suaKhachHang(String maKhachHang, String tenKhachHang, String gioiTinh, String sdt, String cmnd, String diaChi) {
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(maKhachHang);
        kh.setTenKhachHang(tenKhachHang);
        kh.setGioiTinh(gioiTinh);
        kh.setSdt(sdt);
        kh.setCmnd(cmnd);
        kh.setDiaChi(diaChi);
        return khachHang.suaKhachHang(kh);
    }

    public ArrayList<KhachHang> timKiemKhachHang(String maKhachHang, String tenKhachHang, String gioiTinh, String sdt, String cmnd, String diaChi) {
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(maKhachHang);
        kh.setTenKhachHang(tenKhachHang);
        kh.setGioiTinh(gioiTinh);
        kh.setSdt(sdt);
        kh.setCmnd(cmnd);
        kh.setDiaChi(diaChi);
        return khachHang.timKiemKhachHang(kh);
    }

    public int xoaKhachHnag(KhachHang kh) {
        return khachHang.deleteKhachHang(kh);
    }

    public boolean kiemTraTonTaiMaKhachHang(String maKhachHang) {
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(maKhachHang);
        return khachHang.kiemTraTonTaiMaKhachHang(kh);
    }
}
