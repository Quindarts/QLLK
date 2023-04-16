package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import connect.ConnectDB;
import entity.LinhKien;
import entity.NhaCungCap;

public class LinhKien_Dao {

	public int soLuongLK() {
		Connection con = new ConnectDB().getConnect();
		int dem = 0;
		try {
			PreparedStatement statement = con.prepareStatement("select count(maLinhKien) as Dem from LinhKien");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				dem = rs.getInt("Dem");
			}
		} catch (SQLException e) {

		}
		return dem;
	}

	public List<LinhKien> getLinhKien() {
		List<LinhKien> list = new ArrayList<LinhKien>();
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con
					.prepareStatement("select * from LinhKien join NhaCungCap on LinhKien.maNCC=NhaCungCap.maNCC");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new LinhKien(new NhaCungCap(rs.getString("tenNCC")), rs.getString("maLinhKien"),
						rs.getString("tenLinhKien"), rs.getString("loaiLinhKien"), rs.getInt("soLuongTon"),
						rs.getDouble("giaBan"), rs.getInt("baoHanh"), rs.getString("moTa"), rs.getDate("ngayNhap")));

			}
		} catch (SQLException e) {

		}

		return list;
	}

	public List<LinhKien> phanTrangLinhKien(int fn, int ln) {
		Connection con = new ConnectDB().getConnect();
		List<LinhKien> list = new ArrayList<LinhKien>();
		PreparedStatement statement = null;

		String sql = "select *from(select ROW_NUMBER() over (order by MaLinhKien) as STT, ncc.maNCC, lk.maLinhKien,"
				+ " lk.tenLinhKien, lk.loaiLinhKien,lk.soLuongTon, lk.giaBan, lk.baoHanh, lk.moTa, lk.ngayNhap, ncc.tenNCC, ncc.diaChi, ncc.sDT, ncc.email from LinhKien lk "
				+ "join NhaCungCap ncc on lk.maNCC=ncc.maNCC) as PhanTrang where PhanTrang.STT Between " + fn + " and "
				+ ln;
		try {
			statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				list.add(new LinhKien(new NhaCungCap(rs.getString("tenNCC")), rs.getString("maLinhKien"),
						rs.getString("tenLinhKien"), rs.getString("loaiLinhKien"), rs.getInt("soLuongTon"),
						rs.getDouble("giaBan"), rs.getInt("baoHanh"), rs.getString("moTa"), rs.getDate("ngayNhap")));

			}
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return list;

	}

	public boolean ThemLK(LinhKien lk) {
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("insert into LinhKien values(?,?,?,?,?,?,?,?,?)");
			statement.setString(1, lk.getNhaCC().getMaNCC());
			statement.setString(2, lk.getMaLinhKien());
			statement.setString(3, lk.getTenLinhKien());
			statement.setString(4, lk.getLoaiLinhKien());
			statement.setInt(5, lk.getSoLuongTon());
			statement.setDouble(6, lk.getGiaBan());
			statement.setInt(7, lk.getBaoHanh());
			statement.setString(8, lk.getMoTa());
			statement.setDate(9, lk.getNgayNhap());
			statement.executeUpdate();
			con.close();
			statement.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean XoaLK(String ma) {
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("delete LinhKien where maLinhKien=?");
			statement.setString(1, ma);
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean updateSoLuong(int soLuong, String ma) {
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("update LinhKien set soLuongTon=? where maLinhKien=?");
			statement.setInt(1, soLuong);
			statement.setString(2, ma);
			statement.executeUpdate();
			con.close();
			statement.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean updateLinhKien(LinhKien lk) {
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement(
					"update LinhKien set maNCC=?,tenLinhKien=?,loaiLinhKien=?,soLuongTon=?,giaBan=?,baoHanh=?,moTa=?,ngayNhap=? where maLinhKien=?");
			statement.setString(1, lk.getNhaCC().getMaNCC());
			statement.setString(2, lk.getTenLinhKien());
			statement.setString(3, lk.getLoaiLinhKien());
			statement.setInt(4, lk.getSoLuongTon());
			statement.setDouble(5, lk.getGiaBan());
			statement.setInt(6, lk.getBaoHanh());
			statement.setString(7, lk.getMoTa());
			statement.setDate(8, lk.getNgayNhap());
			statement.setString(9, lk.getMaLinhKien());
			statement.executeUpdate();
			con.close();
			statement.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public List<LinhKien> getLoaiLinhKien() {
		List<LinhKien> list = new ArrayList<LinhKien>();
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("select DISTINCT [loaiLinhKien] from LinhKien");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new LinhKien(rs.getString("loaiLinhKien")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public List<LinhKien> timLinhKienTheoTen(String ten, String loai, String thuongHieu, double s1, double s2) {
		List<LinhKien> list = new ArrayList<LinhKien>();
		Connection con = new ConnectDB().getConnect();
		try {
			String giaBanLK = "and giaBan Between ? and ?";
			String thuongHieuLK = "and tenNCC like N'%" + thuongHieu + "%'";
			String loaiLK = "and loaiLinhKien like N'%" + loai + "%'";
			String sql = "select * from LinhKien join NhaCungCap on LinhKien.maNCC=NhaCungCap.maNCC where tenLinhKien like N'%"
					+ ten + "%'" + loaiLK + thuongHieuLK + giaBanLK;

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setDouble(1, s1);
			statement.setDouble(2, s2);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new LinhKien(new NhaCungCap(rs.getString("tenNCC")), rs.getString("maLinhKien"),
						rs.getString("tenLinhKien"), rs.getString("loaiLinhKien"), rs.getInt("soLuongTon"),
						rs.getDouble("giaBan"), rs.getInt("baoHanh"), rs.getString("moTa"), rs.getDate("ngayNhap")));
			}
		} catch (SQLException e) {

		}
		return list;
	}

	public List<LinhKien> timLinhKien(String ten, String loai, String thuongHieu) {
		List<LinhKien> list = new ArrayList<LinhKien>();
		Connection con = new ConnectDB().getConnect();
		try {
			String thuongHieuLK = "and tenNCC like N'%" + thuongHieu + "%'";
			String loaiLK = "and loaiLinhKien like N'%" + loai + "%'";
			String sql = "select * from LinhKien join NhaCungCap on LinhKien.maNCC=NhaCungCap.maNCC where tenLinhKien like N'%"
					+ ten + "%'" + loaiLK + thuongHieuLK;

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new LinhKien(new NhaCungCap(rs.getString("tenNCC")), rs.getString("maLinhKien"),
						rs.getString("tenLinhKien"), rs.getString("loaiLinhKien"), rs.getInt("soLuongTon"),
						rs.getDouble("giaBan"), rs.getInt("baoHanh"), rs.getString("moTa"), rs.getDate("ngayNhap")));
			}
		} catch (SQLException e) {

		}
		return list;
	}

}
