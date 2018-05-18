/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import javax.swing.JLabel;

/**
 *
 * @author Nguyen Hoang Giang
 */
public class MyLabel extends JLabel {

    private Phong phong;
    private ChiTietDichVu chiTiet;

    public ChiTietDichVu getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(ChiTietDichVu chiTiet) {
        this.chiTiet = chiTiet;
    }

    public MyLabel(String text) {
        super(text);
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }
}
