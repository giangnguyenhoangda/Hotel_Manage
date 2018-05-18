/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author Nguyen Hoang Giang
 */
public class LoaiPhong {
    private String maLoaiPhong;
    private String tenLoaiPhong;
    private Integer giaLoaiPhong;

    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public Integer getGiaLoaiPhong() {
        return giaLoaiPhong;
    }

    public void setGiaLoaiPhong(Integer giaLoaiPhong) {
        this.giaLoaiPhong = giaLoaiPhong;
    }

    @Override
    public String toString() {
        return this.getTenLoaiPhong();
    }
    
}
