package entity;

import java.sql.Date;

public class LinhKien {
	private NhaCungCap nhaCC;
	private String maLinhKien;
	private String tenLinhKien;
	private String loaiLinhKien;
	private int soLuongTon;
	private double giaBan;
	private int baoHanh;
	private String moTa;
	private Date ngayNhap;
	public NhaCungCap getNhaCC() {
		return nhaCC;
	}
	public void setNhaCC(NhaCungCap nhaCC) {
		this.nhaCC = nhaCC;
	}
	public String getMaLinhKien() {
		return maLinhKien;
	}
	public void setMaLinhKien(String maLinhKien) {
		this.maLinhKien = maLinhKien;
	}
	public String getTenLinhKien() {
		return tenLinhKien;
	}
	public void setTenLinhKien(String tenLinhKien) {
		this.tenLinhKien = tenLinhKien;
	}
	public String getLoaiLinhKien() {
		return loaiLinhKien;
	}
	public void setLoaiLinhKien(String loaiLinhKien) {
		this.loaiLinhKien = loaiLinhKien;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public int getBaoHanh() {
		return baoHanh;
	}
	public void setBaoHanh(int baoHanh) {
		this.baoHanh = baoHanh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public LinhKien(NhaCungCap nhaCC) {
		super();
		this.nhaCC = nhaCC;
	}
	public LinhKien(String maLinhKien) {
		super();
		this.maLinhKien = maLinhKien;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLinhKien == null) ? 0 : maLinhKien.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		LinhKien other = (LinhKien) obj;
		if (maLinhKien == null) {
			if (other.maLinhKien != null)
				return false;
		} else if (!maLinhKien.equals(other.maLinhKien))
			return false;
		return true;
	}
	public LinhKien(NhaCungCap nhaCC, String maLinhKien) {
		super();
		this.nhaCC = nhaCC;
		this.maLinhKien = maLinhKien;
	}
	public LinhKien(NhaCungCap nhaCC, String maLinhKien, String tenLinhKien, String loaiLinhKien, int soLuongTon,
			double giaBan, int baoHanh, String moTa, Date ngayNhap) {
		super();
		this.nhaCC = nhaCC;
		this.maLinhKien = maLinhKien;
		this.tenLinhKien = tenLinhKien;
		this.loaiLinhKien = loaiLinhKien;
		this.soLuongTon = soLuongTon;
		this.giaBan = giaBan;
		this.baoHanh = baoHanh;
		this.moTa = moTa;
		this.ngayNhap = ngayNhap;
	}
	@Override
	public String toString() {
		return "LinhKien [nhaCC=" + nhaCC + ", maLinhKien=" + maLinhKien + ", tenLinhKien=" + tenLinhKien
				+ ", loaiLinhKien=" + loaiLinhKien + ", soLuongTon=" + soLuongTon + ", giaBan=" + giaBan + ", baoHanh="
				+ baoHanh + ", moTa=" + moTa + ", ngayNhap=" + ngayNhap + "]";
	}
	public LinhKien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}