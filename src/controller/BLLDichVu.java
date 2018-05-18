/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.QueryDichVu;
import object.DichVu;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Hoang Giang
 */
public class BLLDichVu {

    QueryDichVu qDichVu;

    public BLLDichVu() {
        qDichVu = new QueryDichVu();
    }

    public ArrayList<DichVu> layToanBoDichVu() {
        return qDichVu.layToanBoDichVu();
    }

    public int themDichVu(String maDichVu, String tenDichVu, String giaDichVu) {
        DichVu dv = new DichVu();
        dv.setMaDichVu(maDichVu);
        dv.setTenDichVu(tenDichVu);
        dv.setGiaDichVu(Integer.parseInt(giaDichVu));
        return qDichVu.themDichVu(dv);
    }

    public int xoaDichVu(String maDichVu) {
        DichVu dv = new DichVu();
        dv.setMaDichVu(maDichVu);
        return qDichVu.xoaDichVu(dv);
    }

    public int suaDichVu(String maDichVu, String tenDichVu, String giaDichVu) {
        DichVu dv = new DichVu();
        dv.setMaDichVu(maDichVu);
        dv.setTenDichVu(tenDichVu);
        dv.setGiaDichVu(Integer.parseInt(giaDichVu));
        return qDichVu.suaDichVu(dv);
    }

    public ArrayList<DichVu> timKiemDichVu(String maDichVu, String tenDichVu, String giaDichVu) {
        DichVu dv = new DichVu();
        dv.setMaDichVu(maDichVu);
        dv.setTenDichVu(tenDichVu);
        if (giaDichVu.matches("\\s*")) {
            dv.setGiaDichVu(null);
        } else {
            dv.setGiaDichVu(Integer.parseInt(giaDichVu));
        }
        return qDichVu.timKiemDichVu(dv);
    }

    public DichVu timKiemDichVu(String maDichVu) {
        return qDichVu.timThongTinDichVu(maDichVu);
    }
}
