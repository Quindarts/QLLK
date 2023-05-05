package entity;

public class ChiTietHoaDon {
	private LinhKien linhKien;
	private HoaDon hoaDon;
	private int soLuong;
	private int mucGiamGia;

	public LinhKien getLinhKien() {
		return linhKien;
	}

	public void setLinhKien(LinhKien linhKien) {
		this.linhKien = linhKien;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getMucGiamGia() {
		return mucGiamGia;
	}

	public void setMucGiamGia(int mucGiamGia) {
		this.mucGiamGia = mucGiamGia;
	}

	public ChiTietHoaDon() {
		super();
	}

	public ChiTietHoaDon(HoaDon hoaDon) {
		super();
		this.hoaDon = hoaDon;
	}

	public ChiTietHoaDon(LinhKien linhKien, HoaDon hoaDon, int soLuong, int mucGiamGia) {
		super();
		this.linhKien = linhKien;
		this.hoaDon = hoaDon;
		this.soLuong = soLuong;
		this.mucGiamGia = mucGiamGia;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [linhKien=" + linhKien + ", hoaDon=" + hoaDon + ", soLuong=" + soLuong + ", mucGiamGia="
				+ mucGiamGia + "]";
	}

}
