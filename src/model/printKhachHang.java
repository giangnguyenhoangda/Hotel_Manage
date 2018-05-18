/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import static model.printPhong.con;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Nguyen Hoang Giang
 */
public class printKhachHang {

    static Connection con = MyConnection.getConnection();

    public static void main(String[] args) {
//        inDanhSachKhachHang();
//        inKetQuaTimKiemKhachHang("%%", "%%", "%%", "%%", "%%", "%%");
//        inThongKeTheoTen();
//        inThongKeTheoGioiTinh();
//        inThongKeTheoDiaChi();
    }

    public static void inDanhSachKhachHang() {
        try {
            JasperReport report = JasperCompileManager.compileReport("src/printThongTin/printThongTinKhachHang/inDanhSachKhachHang.jrxml");
            JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), con);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void inKetQuaTimKiemKhachHang(String maKhachHang, String tenKhachHang, String gioiTinh, String phone, String cmnd, String diaChi) {
        try {
            JasperReport report = JasperCompileManager.compileReport("src/printThongTin/printThongTinKhachHang/inKetQuaTimKiemKhachHang.jrxml");
            Hashtable hash = new Hashtable();
            hash.put("pMaKhachHang", maKhachHang);
            hash.put("pTenKhachHang", tenKhachHang);
            hash.put("pGioiTinh", gioiTinh);
            hash.put("pSoDienThoai", phone);
            hash.put("pSoCMND", cmnd);
            hash.put("pDiaChi", diaChi);
            JasperPrint print = JasperFillManager.fillReport(report, hash, con);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void inThongKeTheoTen() {
        try {
            JasperReport report = JasperCompileManager.compileReport("src/printThongTin/printThongTinKhachHang/inThongKeKhachHangTheoTen.jrxml");
            JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), con);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void inThongKeTheoGioiTinh() {
        try {
            JasperReport report = JasperCompileManager.compileReport("src/printThongTin/printThongTinKhachHang/inThongKeKhachHangTheoGioiTinh.jrxml");
            JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), con);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void inThongKeTheoDiaChi() {
        try {
            JasperReport report = JasperCompileManager.compileReport("src/printThongTin/printThongTinKhachHang/inThongKeKhachHangTheoDiaChi.jrxml");
            JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), con);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
