package entity;

public class NhaCungCap {
	private String maNCC;
	private String tenNCC;
	private String diaChi;
	private String sDT;
	private String email;

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public NhaCungCap() {
		super();
	}

	public NhaCungCap(String maNCC) {
		super();
		this.maNCC = maNCC;
	}

	public NhaCungCap(String maNCC, String tenNCC, String diaChi, String sDT, String email) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.sDT = sDT;
		this.email = email;
	}

	@Override
	public String toString() {
		return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", diaChi=" + diaChi + ", sDT=" + sDT + ", email="
				+ email + "]";
	}

}
