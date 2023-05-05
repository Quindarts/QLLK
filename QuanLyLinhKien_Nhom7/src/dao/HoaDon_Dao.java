package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;

import entity.NhanVien;

public class HoaDon_Dao {
	public boolean themHoaDon(HoaDon hd) {
		Connection con = new ConnectDB().getConnect();
		try {

			PreparedStatement statement = con.prepareStatement("insert into HoaDon values(?,?,?,?,?,?,?)");
			statement.setString(1, hd.getMaHoaDon());
			statement.setString(2, hd.getKhachHang().getMaKhachHang());
			statement.setString(3, hd.getNhanVien().getMaNhanVien());
			statement.setDate(4, hd.getNgayDatHang());
			statement.setDate(5, hd.getNgayChuyenHang());
			statement.setDate(6, hd.getNgayGiaoHang());
			statement.setString(7, hd.getNoiNhanGiaoHang());
			statement.executeUpdate();
			con.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<HoaDon> getHoaDon() {
		List<HoaDon> list = new ArrayList<HoaDon>();
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement(
					"select *from HoaDon join KhachHang on HoaDon.maKhachHang=KhachHang.maKhachHang join NhanVien on HoaDon.maNhanVien=NhanVien.maNhanVien");

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				list.add(new HoaDon(rs.getString("maHoaDon"),
						new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"), rs.getString("diaChi"),
								rs.getString("sDT"), rs.getString("email")),
						new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"), rs.getString("chucVu"),
								rs.getDouble("luong"), rs.getString("diaChi"), rs.getBoolean("gioiTinh"),
								rs.getString("sDT"), rs.getString("cMND"), rs.getString("matKhau")),
						rs.getDate("ngayDatHang"), rs.getDate("ngayChuyenHang"), rs.getDate("ngayGiaoHang"),
						rs.getString("noiNhanGiaoHang")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean XoaHD(String ma) {
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("delete HoaDon where maHoaDon=?");
			statement.setString(1, ma);
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public HoaDon timHoaDon(String maKH) {
		HoaDon hd = null;
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("select * from HoaDon where maKhachHang=?");
			statement.setString(1, maKH);
			ResultSet rs = statement.executeQuery();
			rs.next();

			hd = new HoaDon(rs.getString("maHoaDon"), new KhachHang(rs.getString("maKhachHang")),
					new NhanVien(rs.getString("maNhanVien")), rs.getDate("ngayDatHang"), rs.getDate("ngayChuyenHang"),
					rs.getDate("ngayGiaoHang"), rs.getString("noiNhanGiaoHang"));

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hd;
	}

	public List<HoaDon> phanTrangHoaDon(int fn, int ln) {
		Connection con = new ConnectDB().getConnect();
		List<HoaDon> list = new ArrayList<HoaDon>();
		PreparedStatement statement = null;

		String sql = "select *from(select ROW_NUMBER() over (order by maHoaDon) as STT, maHoaDon,kh.maKhachHang,nv.maNhanVien ,kh.tenKhachHang,nv.tenNhanVien,hd.ngayChuyenHang,hd.ngayGiaoHang,hd.noiNhanGiaoHang,hd.ngayDatHang from HoaDon hd join KhachHang kh on hd.maKhachHang=kh.maKhachHang join NhanVien nv on hd.maNhanVien=nv.maNhanVien) as PhanTrang where PhanTrang.STT Between ? and ?";

		try {
			statement = con.prepareStatement(sql);
			statement.setInt(1, fn);
			statement.setInt(2, ln);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				list.add(new HoaDon(rs.getString("maHoaDon"),
						new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"), null, null, null),
						new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"), null, 0, null, true, null,
								null, null),
						rs.getDate("ngayDatHang"), rs.getDate("ngayChuyenHang"), rs.getDate("ngayGiaoHang"),
						rs.getString("noiNhanGiaoHang")));
			}
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return list;

	}

	public int soLuongHD() {
		Connection con = new ConnectDB().getConnect();
		int dem = 0;
		try {
			PreparedStatement statement = con.prepareStatement("select count(maHoaDon) as Dem from HoaDon");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				dem = rs.getInt("Dem");
			}
		} catch (SQLException e) {

		}
		return dem;
	}

}	