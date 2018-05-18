/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author dell
 */
public class KhachHang {
    private String maKhachHang;
    private String tenKhachHang;
    private String gioiTinh;
    private String sdt;
    private String cmnd;
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String tenKhachHang, String gioiTinh, String sdt, String cmnd, String diaChi) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.cmnd = cmnd;
        this.diaChi = diaChi;
    }

    public String getCmnd() {
        return cmnd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getSdt() {
        return sdt;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}
