/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.util.ArrayList;

/**
 *
 * @author Nguyen Hoang Giang
 */
public class ChiTietDichVu {

    private String maDatPhong;
    private String maHoaDon;
    private String maDichVu;
    private String maPhong;
    private Integer soLuong;

    public String getMaDatPhong() {
        return maDatPhong;
    }

    public void setMaDatPhong(String maDatPhong) {
        this.maDatPhong = maDatPhong;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public boolean equals(Object obj) {
        ChiTietDichVu ct = (ChiTietDichVu) obj;
        String maDatPhong = ct.getMaDatPhong();
        String maHoaDon = ct.getMaHoaDon();
        String maDichVu = ct.getMaDichVu();
        String maPhong = ct.getMaPhong();
        if (maDatPhong == null || maHoaDon == null || maDichVu == null || maPhong == null) {
            return false;
        }
        boolean kt1 = this.maDatPhong.equalsIgnoreCase(maDatPhong);
        boolean kt2 = this.maHoaDon.equalsIgnoreCase(maHoaDon);
        boolean kt3 = this.maDichVu.equalsIgnoreCase(maDichVu);
        boolean kt4 = this.maPhong.equalsIgnoreCase(maPhong);
        if (kt1 == true && kt2 == true && kt3 == true && kt4 == true) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ArrayList<ChiTietDichVu> ds = new ArrayList<>();
        ChiTietDichVu ct = new ChiTietDichVu();
        ChiTietDichVu ct1 = new ChiTietDichVu();
        ct.setMaDatPhong("001");
        ct.setMaHoaDon("002");
        ct.setMaDichVu("1");
        ct.setMaPhong("1");
        ct1.setMaDatPhong("001");
        ct1.setMaHoaDon("002");
        ct1.setMaDichVu("1");
        ct1.setMaPhong("1");
        ds.add(ct);
        if (ds.contains(ct1)) {
            System.out.println("có");
        } else {
            System.out.println("không");
        }
    }

}
