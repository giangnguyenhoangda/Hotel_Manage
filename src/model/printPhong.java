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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Nguyen Hoang Giang
 */
public class printPhong {

    static Connection con = MyConnection.getConnection();

    public static void inDanhSachPhong() {
        try {
            JasperReport report = JasperCompileManager.compileReport("src/printThongTin/printThongTinPhong/inDanhSachPhong.jrxml");
            JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), con);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void inKetQuaTimKiemPhong(String maPhong, String tenPhong, String maLoaiPhong, String maTinhTrang) {
        try {
            JasperReport report = JasperCompileManager.compileReport("src/printThongTin/printThongTinPhong/inKetQuaTimKiemPhong.jrxml");
            Hashtable hash = new Hashtable();
            hash.put("pMaPhong", maPhong);
            hash.put("pTenPhong", tenPhong);
            hash.put("pMaLoaiPhong", maLoaiPhong);
            hash.put("pMaTinhTrang", maTinhTrang);
            JasperPrint print = JasperFillManager.fillReport(report, hash, con);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void inThongKePhongTheoLoaiPhong() {
        try {
            JasperReport report = JasperCompileManager.compileReport("src/printThongTin/printThongTinPhong/inThongKePhongTheoLoaiPhong.jrxml");
            JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), con);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void inThongKePhongTheoTinhTrang() {
        try {
            JasperReport report = JasperCompileManager.compileReport("src/printThongTin/printThongTinPhong/inThongKePhongTheoTinhTrang.jrxml");
            JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), con);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

//    public static void main(String[] args) {
////        inKetQuaTimKiemPhong("%102%", "%%", "%%", "%%");
////    inThongKePhongTheoLoaiPhong();
//        inThongKePhongTheoTinhTrang();
//    }
}
