/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.QueryPhong;
import object.LoaiPhong;
import object.Phong;
import object.TinhTrangPhong;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Nguyen Hoang Giang
 */
public class BLLPhong {

    public static ArrayList<TinhTrangPhong> layToanBoTinhTrangPhong() {
        return QueryPhong.layToanBoTinhTrangPhong();
    }

    public static ArrayList<LoaiPhong> layToanBoLoaiPhongs() {
        return QueryPhong.layToanBoLoaiPhong();
    }

    public static int themPhong(String maPhong, String tenPhong, String loaiPhong, String tinhTrang) {
        Phong phong = new Phong();
        phong.setMaPhong(maPhong);
        phong.setTenPhong(tenPhong);
        phong.setMaLoaiPhong(loaiPhong);
        phong.setMaTinhTrang(tinhTrang);
        return QueryPhong.themPhong(phong);
    }

    public static ArrayList<Phong> layToanBoDanhSachPhong() {
        return QueryPhong.layToanBoDanhSachPhong();
    }

    public static ArrayList<Phong> timKiemPhong(String maPhong, String tenPhong, String maLoaiPhong, String maTinhTrang) {
        Phong phong = new Phong();
        phong.setMaPhong(maPhong);
        phong.setTenPhong(tenPhong);
        phong.setMaLoaiPhong(maLoaiPhong);
        phong.setMaTinhTrang(maTinhTrang);
        return QueryPhong.timKiemPhong(phong);
    }

    public static int xoaPhong(String maPhong) {
        Phong phong = new Phong();
        phong.setMaPhong(maPhong);
        return QueryPhong.xoaPhong(phong);
    }

    public static int suaPhong(String maPhong, String tenPhong, String maLoaiPhong, String maTinhTrang) {
        Phong phong = new Phong();
        phong.setMaPhong(maPhong);
        phong.setTenPhong(tenPhong);
        phong.setMaLoaiPhong(maLoaiPhong);
        phong.setMaTinhTrang(maTinhTrang);
        return QueryPhong.suaPhong(phong);
    }

    public static int demSoPhongSanSang() {
        return QueryPhong.demSoPhongSanSang();
    }

    public static int demSoPhongCoKhach() {
        return QueryPhong.demSoPhongCoKhach();
    }

    public static int demSoPhongChuaDonDep() {
        return QueryPhong.demSoPhongChuaDonDep();
    }

    public static int demSoPhongDangDonDep() {
        return QueryPhong.demSoPhongDangDonDep();
    }

    public static int demSoPhongDangSuaChua() {
        return QueryPhong.demSoPhongDangSuaChua();
    }

    public static HashMap<String, Integer> thongKeTheoLoaiPhong() {
        return QueryPhong.thongKeTheoLoaiPhong();
    }

    public static HashMap<String, Integer> thongKeTheoTinhTrang() {
        return QueryPhong.thongKeTheoTinhTrangPhong();
    }

}
