/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controller.BLLChiTietDichVu;
import controller.BLLPhong;
import object.MyLabel;
import object.Phong;
import object.WrapLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import object.ChiTietDichVu;

/**
 *
 * @author Nguyen Hoang Giang
 */
public class QuanLyKhachSan extends javax.swing.JFrame {

    /**
     * Creates new form JFrameQuanLyPhong
     */
    MyLabel lblLasted;
    static String maDatPhong = "";
    static String maPhong = "";
    static String maHoaDon = "";
    static Phong phongChon;

    //Tạo class có khả năng lắng nghe sự kiên click chuột phải
    public class MyMouseListener extends MouseAdapter {
        
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.isPopupTrigger()) {
                doPop(e);
            }
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.isPopupTrigger()) {
                doPop(e);
            }
        }
        
        public void doPop(MouseEvent e) {
            lblLasted = (MyLabel) e.getComponent();
            ChiTietDichVu ct = lblLasted.getChiTiet();
            maDatPhong = ct.getMaDatPhong();
            maHoaDon = ct.getMaHoaDon();
            maPhong = ct.getMaPhong();
            phongChon = lblLasted.getPhong();
            PopUpMenuPhong menu = new PopUpMenuPhong();
            System.out.println("Ma Phong Chon :" + ct.getMaPhong());
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    //Tạo class có khả năng như JpopUpmenu
    public class PopUpMenuPhong extends JPopupMenu {
        
        public PopUpMenuPhong() {
            Phong phong = QuanLyKhachSan.phongChon;
            if (phong.getMaTinhTrang().equalsIgnoreCase("TinhTrang01")) {
                JMenuItem mnuItemDatPhong = new JMenuItem("Đặt phòng", new ImageIcon("src/Image/if_Plus_206460.png"));
                mnuItemDatPhong.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        KhachDatPhong ui = new KhachDatPhong();
                    }
                });
                add(mnuItemDatPhong);
            } else if (phong.getMaTinhTrang().equalsIgnoreCase("TinhTrang02")) {
                JMenuItem mnuItemTraPhong = new JMenuItem("Trả phòng", new ImageIcon("src/Image/if_Money_206469.png"));
                mnuItemTraPhong.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        TraPhong ui = new TraPhong();
                    }
                });
                add(mnuItemTraPhong);
                JMenuItem mnuItemDichVu = new JMenuItem("Dịch vụ", new ImageIcon("src/Image/cutlery (1).png"));
                mnuItemDichVu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BanHang ui = new BanHang();
                    }
                });
                add(mnuItemDichVu);
            }
            if (phong.getMaTinhTrang().equalsIgnoreCase("TinhTrang03")) {
                JMenuItem mnuItemDonDepPhong = new JMenuItem("Dọn dẹp phòng", new ImageIcon("src/Image/if_edit-clear_118917.png"));
                add(mnuItemDonDepPhong);
            } else if (phong.getMaTinhTrang().equalsIgnoreCase("TinhTrang05")) {
                JMenuItem mnuItemDonDepPhong = new JMenuItem("Dọn dẹp phòng xong", new ImageIcon("src/Image/if_edit-clear_118917.png"));
                add(mnuItemDonDepPhong);
            }
            
        }
    }
    
    private void titleAlign(JFrame frame) {
        
        Font font = frame.getFont();
        
        String currentTitle = frame.getTitle().trim();
        FontMetrics fm = frame.getFontMetrics(font);
        int frameWidth = frame.getWidth();
        int titleWidth = fm.stringWidth(currentTitle);
        int spaceWidth = fm.stringWidth(" ");
        int centerPos = (frameWidth / 2) - (titleWidth / 2);
        int spaceCount = centerPos / spaceWidth;
        String pad = "";
        pad = String.format("%" + (spaceCount - 14) + "s", pad);
        frame.setTitle(pad + currentTitle);
        
    }
    
    public QuanLyKhachSan() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
        }
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        pnDanhSachPhong.setLayout(new WrapLayout(WrapLayout.LEFT));
        layToanBoPhong();
        hienThiSoLuongTinhTrangPhong();
        
    }
    
    private void layToanBoPhong() {
        pnDanhSachPhong.removeAll();
        ArrayList<Phong> dsPhong = BLLPhong.layToanBoDanhSachPhong();
        for (Phong phong : dsPhong) {
            JPanel pn = new JPanel(new BorderLayout());
            pn.setPreferredSize(new Dimension(161, 150));
            MyLabel lbl = new MyLabel("<html><h3 align=\"center\">Phòng: " + phong.getTenPhong() + "</h3>"
                    + "<p align=\"center\">" + layLoaiPhong(phong.getMaLoaiPhong()) + "</p>"
                    + "<p align=\"center\">" + layTinhTrang(phong.getMaTinhTrang()) + "</p> </html>");
            
            lbl.setPhong(phong);
            ChiTietDichVu chiTiet = BLLChiTietDichVu.layChiTietDichVuCuoiTheoPhong(phong.getMaPhong());
            lbl.setChiTiet(chiTiet);
            lbl.setIcon(new ImageIcon("src/Image/bedroom.png"));
            lbl.setHorizontalAlignment(JLabel.CENTER);
            lbl.setHorizontalTextPosition(JLabel.CENTER);
            lbl.setVerticalAlignment(JLabel.TOP);
            lbl.setVerticalTextPosition(JLabel.BOTTOM);
            lbl.addMouseListener(new MyMouseListener());
            pn.add(lbl);
            Color color = setMauChoLable(phong.getMaTinhTrang());
            pn.setBackground(color);
            pnDanhSachPhong.add(pn);
        }
    }
    
    private void hienThiSoLuongTinhTrangPhong() {
        lblPhongSanSang.setText("Đang sẵn sàng: " + BLLPhong.demSoPhongSanSang());
        lblPhongCoKhach.setText("Đang có khách: " + BLLPhong.demSoPhongCoKhach());
        lblPhongChuaDonDep.setText("Chưa dọn dẹp: " + BLLPhong.demSoPhongChuaDonDep());
        lblPhongDangSuaChua.setText("Đang sửa chữa: " + BLLPhong.demSoPhongDangSuaChua());
        lblPhongDangDonDep.setText("Đang dọn dẹp: " + BLLPhong.demSoPhongDangDonDep());
    }
    
    private String layTinhTrang(String maTinhTrang) {
        if (maTinhTrang.equalsIgnoreCase("TinhTrang01")) {
            return "Sẵn Sàng Đón Khách";
        }
        if (maTinhTrang.equalsIgnoreCase("TinhTrang02")) {
            return "Đang Có Khách";
        }
        if (maTinhTrang.equalsIgnoreCase("TinhTrang03")) {
            return "Chưa Dọn Dẹp";
        }
        if (maTinhTrang.equalsIgnoreCase("TinhTrang05")) {
            return "Đang Dọn Dẹp";
        }
        return "Đang Sửa Chữa";
    }
    
    private String layLoaiPhong(String maLoaiPhong) {
        if (maLoaiPhong.equalsIgnoreCase("LoaiPhong1")) {
            return "Phòng VIP";
        }
        if (maLoaiPhong.equalsIgnoreCase("LoaiPhong2")) {
            return "Phòng Đơn";
        }
        return "Phòng Đôi";
    }
    
    private Color setMauChoLable(String maTinhTrang) {
        if (maTinhTrang.equalsIgnoreCase("TinhTrang01")) {
            return Color.GREEN;
        }
        if (maTinhTrang.equalsIgnoreCase("TinhTrang02")) {
            return Color.RED;
        }
        if (maTinhTrang.equalsIgnoreCase("TinhTrang03")) {
            return Color.GRAY;
        }
        if (maTinhTrang.equalsIgnoreCase("TinhTrang05")) {
            return Color.BLUE;
        }
        return Color.DARK_GRAY;
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnKhachSan = new javax.swing.JPanel();
        scPhong = new javax.swing.JScrollPane();
        pnDanhSachPhong = new javax.swing.JPanel();
        lblPhongSanSang = new javax.swing.JLabel();
        lblPhongCoKhach = new javax.swing.JLabel();
        lblPhongChuaDonDep = new javax.swing.JLabel();
        lblPhongDangSuaChua = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblPhongDangDonDep = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Khách Sạn");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/room.png"))); // NOI18N
        jLabel1.setText("Phòng");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-Manager-64.png"))); // NOI18N
        jLabel2.setText("Nhân Viên");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/if_CatholicMonk_80815.png"))); // NOI18N
        jLabel3.setText("Khách Hàng");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cutlery.png"))); // NOI18N
        jLabel4.setText("Dịch Vụ");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/if_avatar_1814089.png"))); // NOI18N
        jLabel5.setText("Tài Khoản");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản Lý", new javax.swing.ImageIcon(getClass().getResource("/Image/network.png")), jPanel2); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/presentation.png"))); // NOI18N
        jLabel6.setText("Phòng");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/graph.png"))); // NOI18N
        jLabel7.setText("Nhân Viên");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/graph3.png"))); // NOI18N
        jLabel8.setText("Khách Hàng");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/graph (1).png"))); // NOI18N
        jLabel9.setText("Đặt Phòng");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 311, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Báo Cáo - Thống Kê", new javax.swing.ImageIcon(getClass().getResource("/Image/newspaper.png")), jPanel3); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pnKhachSan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khách Sạn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 204, 204))); // NOI18N
        pnKhachSan.setLayout(new java.awt.BorderLayout());

        scPhong.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout pnDanhSachPhongLayout = new javax.swing.GroupLayout(pnDanhSachPhong);
        pnDanhSachPhong.setLayout(pnDanhSachPhongLayout);
        pnDanhSachPhongLayout.setHorizontalGroup(
            pnDanhSachPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 838, Short.MAX_VALUE)
        );
        pnDanhSachPhongLayout.setVerticalGroup(
            pnDanhSachPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );

        scPhong.setViewportView(pnDanhSachPhong);

        pnKhachSan.add(scPhong, java.awt.BorderLayout.CENTER);

        lblPhongSanSang.setText("Sẵn sàng: ?");

        lblPhongCoKhach.setText("Đang có khách: ?");

        lblPhongChuaDonDep.setText("Chưa dọn dẹp: ?");

        lblPhongDangSuaChua.setText("Đang sửa chữa: ?");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-Refresh-16.png"))); // NOI18N
        jButton1.setText("Refresh Khách Sạn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblPhongDangDonDep.setText("Đang dọn dẹp: ?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnKhachSan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblPhongSanSang)
                .addGap(18, 18, 18)
                .addComponent(lblPhongCoKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPhongChuaDonDep)
                .addGap(10, 10, 10)
                .addComponent(lblPhongDangSuaChua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPhongDangDonDep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnKhachSan, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhongSanSang)
                    .addComponent(lblPhongCoKhach)
                    .addComponent(lblPhongChuaDonDep)
                    .addComponent(lblPhongDangSuaChua)
                    .addComponent(jButton1)
                    .addComponent(lblPhongDangDonDep))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
        QuanLyPhong frame = new QuanLyPhong();
        frame.setVisible(true);
    }//GEN-LAST:event_jLabel1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        layToanBoPhong();
        hienThiSoLuongTinhTrangPhong();
        JOptionPane.showMessageDialog(null, "Cập nhật thành công");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        // TODO add your handling code here:
        QuanLyDichVu frame = new QuanLyDichVu();
        frame.setVisible(true);
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        QuanLyNhanVienUI ui = new QuanLyNhanVienUI();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        // TODO add your handling code here:
        ThongKeNhanVienUI ui = new ThongKeNhanVienUI();
        ui.setVisible(true);
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        // TODO add your handling code here:
        ThongKePhongV2 ui = new ThongKePhongV2();
        ui.setVisible(true);
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        // TODO add your handling code here:
        QuanLyKhachHangUI ui = new QuanLyKhachHangUI();
        ui.setVisible(true);
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        // TODO add your handling code here:
        ThongKeKhachHangUI ui = new ThongKeKhachHangUI();
        ui.setVisible(true);
    }//GEN-LAST:event_jLabel8MousePressed

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
            java.util.logging.Logger.getLogger(QuanLyKhachSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKhachSan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblPhongChuaDonDep;
    private javax.swing.JLabel lblPhongCoKhach;
    private javax.swing.JLabel lblPhongDangDonDep;
    private javax.swing.JLabel lblPhongDangSuaChua;
    private javax.swing.JLabel lblPhongSanSang;
    private javax.swing.JPanel pnDanhSachPhong;
    private javax.swing.JPanel pnKhachSan;
    private javax.swing.JScrollPane scPhong;
    // End of variables declaration//GEN-END:variables
}
