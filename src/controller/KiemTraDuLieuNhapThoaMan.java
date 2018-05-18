/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author dell
 */
public class KiemTraDuLieuNhapThoaMan {
    public static String kiemTraDuLieuNhapCapNhatKhachHang(String tenKhachHang, String gioiTinh, String sdt, String cmnd, String diaChi) {
        String regex = "\\s*";
        String regexPhone = "\\d{10,11}";
        String regexCMND ="\\d{9,12}";
        if (tenKhachHang.matches(regex) && sdt.matches(regex) && diaChi.matches(regex) && gioiTinh.matches(regex)) {
            return "Chưa nhập dữ liệu";
        } else if (tenKhachHang.matches(regex)) {
            return  "Chưa nhập tên khách hàng";
        } else if (gioiTinh.matches(regex)) {
            return "Chưa chọn giới tính";
        } else if (sdt.matches(regex)) {
           return "Chưa nhập sđt";
        } else if(!sdt.matches(regexPhone)){
            return sdt+" không phải số điện thoại";
        } else if(cmnd.matches(regex)){
            return "Chưa nhập CMND";
        } else if(!cmnd.matches(regexCMND)){
            return "CMND phải có 9 hoặc 12 số";
        } else if (diaChi.matches(regex)) {
            return "Chưa nhập địa chỉ";
        }else 
           return "Dữ liệu thỏa mãn";
    }
}
