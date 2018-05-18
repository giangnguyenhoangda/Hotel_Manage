USE QuanLyKhachSan
GO
CREATE TABLE LoaiPhong
(
	MaLoaiPhong CHAR(12) PRIMARY KEY,
	TenLoaiPhong NVARCHAR(70),
	GiaLoaiPhong INT
)
GO
CREATE TABLE TinhTrangPhong
(
	MaTinhTrang CHAR(12) PRIMARY KEY,
	TenTinhTrang NVARCHAR(70)
)
GO
CREATE TABLE Phong
(
	MaPhong CHAR(12) PRIMARY KEY,
	TenPhong NVARCHAR(70),
	MaLoaiPhong CHAR(12),
	MaTinhTrang CHAR(12),
	FOREIGN KEY(MaLoaiPhong) REFERENCES dbo.LoaiPhong(MaLoaiPhong),
	FOREIGN KEY(MaTinhTrang) REFERENCES dbo.TinhTrangPhong(MaTinhTrang)
)
GO
CREATE TABLE DichVu
(
	MaDichVu CHAR(12) PRIMARY KEY,
	TenDichVu NVARCHAR(70),
	GiaDichVu INT
)
GO
CREATE TABLE ChucVu
(
	MaChucVu CHAR(12) PRIMARY KEY,
	TenChucVu NVARCHAR(70),
	LuongChucVu INT
)
GO

CREATE TABLE NhanVien
(
	MaNhanVien CHAR(12) PRIMARY KEY,
	TenNhanVien NTEXT,
	GioiTinh NVARCHAR(10),
	MaChucVu CHAR(12),
	CMND CHAR(11),
	Phone CHAR(12),
	DiaChi NTEXT,
	LuongThuong INT,
	Luong INT,
	FOREIGN KEY(MaChucVu) REFERENCES dbo.ChucVu(MaChucVu)
)
GO
CREATE TABLE KhachHang
(
	MaKhachHang CHAR(12) PRIMARY KEY,
	TenKhachHang NTEXT,
	GioiTinh NVARCHAR(10),
	Phone CHAR(11),
	DiaChi NTEXT
)
GO
CREATE TABLE DatPhong
(
	MaDatPhong CHAR(12) PRIMARY KEY,
	MaNhanVien CHAR(12),
	MaKhachHang CHAR(12),
	NgayDatPhong DATE,
	TienCoc INT
	FOREIGN KEY(MaNhanVien) REFERENCES dbo.NhanVien(MaNhanVien),
	FOREIGN KEY(MaKhachHang) REFERENCES dbo.KhachHang(MaKhachHang)
)
GO
CREATE TABLE DanhSachPhongDat
(
	MaDatPhong CHAR(12),
	MaPhong CHAR(12) PRIMARY KEY,
	NgayHenTra DATE,
	FOREIGN KEY(MaPhong) REFERENCES dbo.Phong(MaPhong)
)
GO
CREATE TABLE HoaDon
(
	MaHoaDon CHAR(12) PRIMARY KEY,
	MaDatPhong CHAR(12),
	NgayLapHoaDon DATE,
	TongTien INT,
	TienCanTra INT
)
GO
CREATE TABLE ChiTietTraPhong
(
	MaHoaDon CHAR(12),
	MaDatPhong CHAR(12),
	MaPhong CHAR(12),
	NgayTra DATE,
	TienTinhThem INT,
	FOREIGN KEY(MaHoaDon) REFERENCES dbo.HoaDon(MaHoaDon),
	FOREIGN KEY(MaDatPhong) REFERENCES dbo.DatPhong(MaDatPhong),
	FOREIGN KEY(MaPhong) REFERENCES dbo.DanhSachPhongDat(MaPhong)
)
GO
CREATE TABLE ChiTietDichVu
(
	MaDatPhong CHAR(12),
	MaHoaDon CHAR(12),
	MaDichVu CHAR(12),
	SoLuong INT,
	FOREIGN KEY(MaHoaDon) REFERENCES dbo.HoaDon(MaHoaDon),
	FOREIGN KEY(MaDichVu) REFERENCES dbo.DichVu(MaDichVu),
	FOREIGN KEY(MaDatPhong) REFERENCES dbo.DatPhong(MaDatPhong)
)
GO
CREATE TABLE ChiTietDatPhong
(
	MaDatPhong CHAR(12),
	MaLoaiPhong CHAR(12),
	SoLuong INT,
	MaHoaDon CHAR(12),
	FOREIGN KEY(MaDatPhong) REFERENCES dbo.DatPhong(MaDatPhong),
	FOREIGN KEY(MaLoaiPhong) REFERENCES dbo.LoaiPhong(MaLoaiPhong),
	FOREIGN KEY(MaHoaDon) REFERENCES dbo.HoaDon(MaHoaDon)
)