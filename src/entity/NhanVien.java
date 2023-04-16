package entity;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private String chucVu;
	private double heSoLuong;
	private String diaChi;
	private boolean gioiTinh;
	private String sDT;
	private String cMND;
	private String matKhau;
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public double getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public String getcMND() {
		return cMND;
	}
	public void setcMND(String cMND) {
		this.cMND = cMND;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public NhanVien() {
		super();
	}
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	public NhanVien(String maNhanVien, String tenNhanVien, String chucVu, double heSoLuong, String diaChi,
			boolean gioiTinh, String sDT, String cMND, String matKhau) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.chucVu = chucVu;
		this.heSoLuong = heSoLuong;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.sDT = sDT;
		this.cMND = cMND;
		this.matKhau = matKhau;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", chucVu=" + chucVu
				+ ", heSoLuong=" + heSoLuong + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", sDT=" + sDT
				+ ", cMND=" + cMND + ", matKhau=" + matKhau + "]";
	}
	
}