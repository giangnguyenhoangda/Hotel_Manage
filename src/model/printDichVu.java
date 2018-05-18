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
public class printDichVu {
    
    static Connection con = MyConnection.getConnection();
    
    public static void inDanhSachDichVu() {
        try {
            JasperReport report = JasperCompileManager.compileReport("src/printThongTin/printThongTinDichVu/inDanhSachDichVu.jrxml");
            JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), con);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static void inPhieuDichVu(String maDatPhong, String maHoaDon, String maPhong, String tongTien) {
        try {
            JasperReport report = JasperCompileManager.compileReport("src/printThongTin/printThongTinDichVu/inPhieuDichVu.jrxml");
            Hashtable hash = new Hashtable();
            hash.put("pMaDatPhong", maDatPhong);
            hash.put("pMaHoaDon", maHoaDon);
            hash.put("pMaPhong", maPhong);
            hash.put("pTongTien", tongTien + " VND");
            JasperPrint print = JasperFillManager.fillReport(report, hash, con);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static void inKetQuaTimKiem(String maDichVu, String tenDichVu, String giaDichVu) {
        try {
            JasperReport report = JasperCompileManager.compileReport("src/printThongTin/printThongTinDichVu/inKetQuaTimKiemDichVu.jrxml");
            Hashtable hash = new Hashtable();
            hash.put("pMaDichVu", maDichVu);
            hash.put("pTenDichVu", tenDichVu);
            hash.put("pGiaDichVu", giaDichVu);
            JasperPrint print = JasperFillManager.fillReport(report, hash, con);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
//    public static void main(String[] args) {
////        inDanhSachDichVu();
////        inPhieuDichVu("DP0001", "HD0001", "102", 5000 + "");
////        inKetQuaTimKiem("%%", "%%", "%%");
//    }
}
