/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.io.Serializable;

/**
 *
 * @author Nguyen Hoang Giang
 */
public class ChucVu implements Serializable {

    private String maChucVu;
    private String tenChucVu;
    private Integer luongChucVu;

    public ChucVu(String maChucVu, String tenChucVu, int luongChucVu) {
        this.maChucVu = maChucVu;
        this.tenChucVu = tenChucVu;
        this.luongChucVu = luongChucVu;
    }

    public ChucVu() {
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public Integer getLuongChucVu() {
        return luongChucVu;
    }

    public void setLuongChucVu(Integer luongChucVu) {
        this.luongChucVu = luongChucVu;
    }
}
