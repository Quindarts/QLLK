package entity;

import java.sql.Date;

public class HoaDon {
	private String maHoaDon;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private Date ngayDatHang;
	private Date ngayChuyenHang;
	private Date ngayGiaoHang;
	private String noiNhanGiaoHang;

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public Date getNgayChuyenHang() {
		return ngayChuyenHang;
	}

	public void setNgayChuyenHang(Date ngayChuyenHang) {
		this.ngayChuyenHang = ngayChuyenHang;
	}

	public Date getNgayGiaoHang() {
		return ngayGiaoHang;
	}

	public void setNgayGiaoHang(Date ngayGiaoHang) {
		this.ngayGiaoHang = ngayGiaoHang;
	}

	public String getNoiNhanGiaoHang() {
		return noiNhanGiaoHang;
	}

	public void setNoiNhanGiaoHang(String noiNhanGiaoHang) {
		this.noiNhanGiaoHang = noiNhanGiaoHang;
	}

	public HoaDon() {
		super();
	}

	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}

	public HoaDon(String maHoaDon, KhachHang khachHang, NhanVien nhanVien, Date ngayDatHang, Date ngayChuyenHang,
			Date ngayGiaoHang, String noiNhanGiaoHang) {
		super();
		this.maHoaDon = maHoaDon;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayDatHang = ngayDatHang;
		this.ngayChuyenHang = ngayChuyenHang;
		this.ngayGiaoHang = ngayGiaoHang;
		this.noiNhanGiaoHang = noiNhanGiaoHang;
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + ", ngayDatHang="
				+ ngayDatHang + ", ngayChuyenHang=" + ngayChuyenHang + ", ngayGiaoHang=" + ngayGiaoHang
				+ ", noiNhanGiaoHang=" + noiNhanGiaoHang + "]";
	}

}
