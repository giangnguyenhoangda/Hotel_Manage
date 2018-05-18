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
public class DichVu {

    private String maDichVu;
    private String tenDichVu;
    private Integer giaDichVu;

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public Integer getGiaDichVu() {
        return giaDichVu;
    }

    public void setGiaDichVu(Integer giaDichVu) {
        this.giaDichVu = giaDichVu;
    }

    @Override
    public boolean equals(Object obj) {
        DichVu dv = (DichVu) obj;
        return this.maDichVu.equalsIgnoreCase(dv.getMaDichVu()) == true;
    }

}
