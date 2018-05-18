/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controller.BLLDichVu;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import model.printDichVu;
import object.DichVu;

/**
 *
 * @author Nguyen Hoang Giang
 */
public class QuanLyDichVu extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyDichVu
     */
    BLLDichVu bllDichVu;
    JButton btnLast;

    public QuanLyDichVu() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
        }
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

        bllDichVu = new BLLDichVu();
        hienThiDanhSachDichVu(bllDichVu.layToanBoDichVu());
    }

    private void hienThiDanhSachDichVu(ArrayList<DichVu> ds) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã Dịch Vụ");
        dtm.addColumn("Tên Dịch Vụ");
        dtm.addColumn("Giá dịch vụ");
        if (ds != null) {
            for (DichVu dv : ds) {
                Vector<String> v = new Vector<>();
                v.add(dv.getMaDichVu());
                v.add(dv.getTenDichVu());
                v.add(dv.getGiaDichVu() + " VND");
                dtm.addRow(v);
            }
        }

        tblDichVu.setModel(dtm);
    }

    private boolean kiemTraDuLieu(String maDichVu, String tenDichVu, String giaDichVu) {
        String regex = "\\s*";
        if (maDichVu.matches(regex) && tenDichVu.matches(regex) && giaDichVu.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Chưa nhập dữ liệu");
            return false;
        }
        if (maDichVu.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mã dịch vụ");
            return false;
        }
        if (tenDichVu.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Chưa nhập tên dịch vụ");
            return false;
        }
        if (giaDichVu.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Chưa nhập giá dịch vụ");
            return false;
        }
        if (!giaDichVu.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Giá dịch vụ nhập không hợp lệ");
            return false;
        }
        return true;
    }

    private void resetDuLieuNhap() {
        txtMaDichVu.setText("");
        txtTenDichVu.setText("");
        txtGiaDichVu.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaDichVu = new javax.swing.JTextField();
        txtTenDichVu = new javax.swing.JTextField();
        txtGiaDichVu = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        btnTimKiemDichVu = new javax.swing.JButton();
        btnXemToanBoDanhSach = new javax.swing.JButton();
        btnThemDichVu = new javax.swing.JButton();
        btnSuaDichVu = new javax.swing.JButton();
        btnXoaDichVu = new javax.swing.JButton();
        btnLamSachDuLieu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Dịch Vụ:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 153))); // NOI18N

        jLabel1.setText("Mã Dịch Vụ:");

        jLabel2.setText("Tên Dịch Vụ:");

        jLabel3.setText("Giá Dịch Vụ:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaDichVu))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGiaDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(txtTenDichVu)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGiaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Dịch Vụ:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 153))); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());

        tblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDichVuMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDichVu);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnTimKiemDichVu.setText("Tìm Kiếm Dịch Vụ");
        btnTimKiemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemDichVuActionPerformed(evt);
            }
        });

        btnXemToanBoDanhSach.setText("Xem Toàn Bộ Danh Sách Dịch Vụ");
        btnXemToanBoDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemToanBoDanhSachActionPerformed(evt);
            }
        });

        btnThemDichVu.setText("Thêm Dịch Vụ");
        btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDichVuActionPerformed(evt);
            }
        });

        btnSuaDichVu.setText("Sửa Dịch Vụ");
        btnSuaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDichVuActionPerformed(evt);
            }
        });

        btnXoaDichVu.setText("Xóa Dịch Vụ");
        btnXoaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDichVuActionPerformed(evt);
            }
        });

        btnLamSachDuLieu.setText("Làm Sạch Dữ Liệu Nhập");
        btnLamSachDuLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamSachDuLieuActionPerformed(evt);
            }
        });

        jButton1.setText("In Kết Quả");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXemToanBoDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSuaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLamSachDuLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiemDichVu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXemToanBoDanhSach)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThemDichVu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaDichVu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaDichVu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLamSachDuLieu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap(33, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDichVuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMousePressed
        // TODO add your handling code here:
        int row = tblDichVu.getSelectedRow();
        String maDichVu = tblDichVu.getValueAt(row, 0) + "";
        String tenDichVu = tblDichVu.getValueAt(row, 1) + "";
        String giaDichVu = tblDichVu.getValueAt(row, 2) + "";
        giaDichVu = giaDichVu.substring(0, giaDichVu.length() - 4);
        txtMaDichVu.setText(maDichVu);
        txtTenDichVu.setText(tenDichVu);
        txtGiaDichVu.setText(giaDichVu);
    }//GEN-LAST:event_tblDichVuMousePressed

    private void btnTimKiemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemDichVuActionPerformed
        // TODO add your handling code here:
        String maDichVu = txtMaDichVu.getText();
        String tenDichVu = txtTenDichVu.getText();
        String giaDichVu = txtGiaDichVu.getText();
        String regex = "\\s*";
        if (maDichVu.matches(regex) && tenDichVu.matches(regex) && giaDichVu.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Dữ liệu tìm kiếm trống");
            return;
        }
        if (!giaDichVu.matches("\\s*")) {
            if (!giaDichVu.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Giá dịch vụ nhập không thỏa mãn");
                return;
            }
        }
        hienThiDanhSachDichVu(bllDichVu.timKiemDichVu(maDichVu, tenDichVu, giaDichVu));
        btnLast = btnTimKiemDichVu;
    }//GEN-LAST:event_btnTimKiemDichVuActionPerformed

    private void btnXemToanBoDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemToanBoDanhSachActionPerformed
        // TODO add your handling code here:
        hienThiDanhSachDichVu(bllDichVu.layToanBoDichVu());
        btnLast = btnXemToanBoDanhSach;
    }//GEN-LAST:event_btnXemToanBoDanhSachActionPerformed

    private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDichVuActionPerformed
        // TODO add your handling code here:
        String maDichVu = txtMaDichVu.getText();
        String tenDichVu = txtTenDichVu.getText();
        String giaDichVu = txtGiaDichVu.getText();
        if (kiemTraDuLieu(maDichVu, tenDichVu, giaDichVu)) {
            int kt = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm dịch vụ ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (kt != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Thêm dịch vụ thất bại");
                return;
            }
            int kq = bllDichVu.themDichVu(maDichVu, tenDichVu, giaDichVu);
            if (kq > 0) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                hienThiDanhSachDichVu(bllDichVu.layToanBoDichVu());
                btnLast = btnThemDichVu;
                resetDuLieuNhap();
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại");
            }
        }
    }//GEN-LAST:event_btnThemDichVuActionPerformed

    private void btnSuaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDichVuActionPerformed
        // TODO add your handling code here:
        String maDichVu = txtMaDichVu.getText();
        String tenDichVu = txtTenDichVu.getText();
        String giaDichVu = txtGiaDichVu.getText();
        if (kiemTraDuLieu(maDichVu, tenDichVu, giaDichVu)) {
            int kt = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa dịch vụ ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (kt != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Sửa dịch vụ thất bại");
                return;
            }
            int kq = bllDichVu.suaDichVu(maDichVu, tenDichVu, giaDichVu);
            if (kq > 0) {
                JOptionPane.showMessageDialog(null, "Sửa thành công");
                hienThiDanhSachDichVu(bllDichVu.layToanBoDichVu());
                resetDuLieuNhap();
                btnLast = btnSuaDichVu;
            } else {
                JOptionPane.showMessageDialog(null, "Sửa thất bại");
            }
        }
    }//GEN-LAST:event_btnSuaDichVuActionPerformed

    private void btnXoaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDichVuActionPerformed
        // TODO add your handling code here:
        int[] row = tblDichVu.getSelectedRows();
        if (row.length <= 0) {
            JOptionPane.showMessageDialog(null, "Chưa chọn dữ liệu xóa");
        } else {
            int kt = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dịch vụ được chọn ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (kt != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Dịch vụ không bị xóa");
                return;
            }
            int soLuong = 0;
            for (int r : row) {
                String maDichVu = tblDichVu.getValueAt(r, 0) + "";
                soLuong += bllDichVu.xoaDichVu(maDichVu);
            }
            if (soLuong > 0) {
                JOptionPane.showMessageDialog(null, "Xóa thành công " + soLuong + " dịch vụ");
                hienThiDanhSachDichVu(bllDichVu.layToanBoDichVu());
                resetDuLieuNhap();
                btnLast = btnXoaDichVu;
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        }
    }//GEN-LAST:event_btnXoaDichVuActionPerformed

    private void btnLamSachDuLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamSachDuLieuActionPerformed
        // TODO add your handling code here:
        resetDuLieuNhap();
    }//GEN-LAST:event_btnLamSachDuLieuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (btnLast == btnTimKiemDichVu || btnLast == btnXemToanBoDanhSach) {
            if (btnLast == btnXemToanBoDanhSach) {
                printDichVu.inDanhSachDichVu();
            } else {
                String maDichVu = txtMaDichVu.getText();
                String tenDichVu = txtTenDichVu.getText();
                String giaDichVu = txtGiaDichVu.getText();
                printDichVu.inKetQuaTimKiem("%" + maDichVu + "%", "%" + tenDichVu + "%", "%" + giaDichVu + "%");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hãy tìm kiếm trước");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyDichVu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamSachDuLieu;
    private javax.swing.JButton btnSuaDichVu;
    private javax.swing.JButton btnThemDichVu;
    private javax.swing.JButton btnTimKiemDichVu;
    private javax.swing.JButton btnXemToanBoDanhSach;
    private javax.swing.JButton btnXoaDichVu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTextField txtGiaDichVu;
    private javax.swing.JTextField txtMaDichVu;
    private javax.swing.JTextField txtTenDichVu;
    // End of variables declaration//GEN-END:variables
}
