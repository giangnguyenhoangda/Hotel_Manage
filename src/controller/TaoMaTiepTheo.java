/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.QueryKhachHang;

/**
 *
 * @author dell
 */
public class TaoMaTiepTheo {

    QueryKhachHang khachHang;

    public TaoMaTiepTheo() {
        khachHang = new QueryKhachHang();
    }

    public String taoChuoiTuSoDaCho(int n) {
        int sotieptheo = 0;
        if (n >= 0 && n < 9) {
            sotieptheo = n + 1;
            return "00" + sotieptheo;
        } else if (n >= 9 && n < 99) {
            sotieptheo = n + 1;
            return "0" + sotieptheo;
        } else if (n >= 99 && n < 999) {
            sotieptheo = n + 1;
            return "" + sotieptheo;
        }
        return "";
    }

    public String layMaKhachHangTiepTheo() {
        int soThuTuCuoiCuaBangKhachHang = khachHang.laySoThuTuCuoiCuaBangKhachHang();
        return "KH" + taoChuoiTuSoDaCho(soThuTuCuoiCuaBangKhachHang);
    }

}
