package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entity.KhachHang;


public class KhachHang_Dao {
	public boolean themKhachHang(KhachHang kh) {
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("insert into KhachHang values(?,?,?,?,?)");
			statement.setString(1, kh.getMaKhachHang());
			statement.setString(2, kh.getTenKhachHang());
			statement.setString(3, kh.getDiaChi());
			statement.setString(4, kh.getsDT());
			statement.setString(5, kh.getEmail());
			statement.executeUpdate();
			con.close();
			statement.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public List<KhachHang> getKhachHang() {
		
		List<KhachHang> list = new ArrayList<KhachHang>();
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("select * from KhachHang");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"),
						rs.getString("diaChi"), rs.getString("sDT"), rs.getString("email")));
			}
		} catch (SQLException e) {

		}
		return list;
	}

	public List<KhachHang> phanTrangKhachHang(int fn, int ln) {
		Connection con = new ConnectDB().getConnect();
		List<KhachHang> list = new ArrayList<KhachHang>();
		PreparedStatement statement = null;

		String sql = "select *from(select ROW_NUMBER() over (order by maKhachHang) as STT,maKhachHang,tenKhachHang,diaChi,sDT,email from KhachHang) as PhanTrang where PhanTrang.STT Between ? and ?";
		try {
			statement = con.prepareStatement(sql);
			statement.setInt(1, fn);
			statement.setInt(2, ln);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"),
						rs.getString("diaChi"), rs.getString("sDT"), rs.getString("email")));
			}
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int soLuongKH() {
		Connection con = new ConnectDB().getConnect();
		int dem = 0;
		try {
			PreparedStatement statement = con.prepareStatement("select count(maKhachHang) as Dem from KhachHang");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				dem = rs.getInt("Dem");
			}
		} catch (SQLException e) {

		}
		return dem;
	}

	public boolean XoaKH(String ma) {
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("delete KhachHang where maKhachHang=?");
			statement.setString(1, ma);
			statement.executeUpdate();
			con.close();
			statement.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean updateKhachHang(KhachHang kh) {
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con
					.prepareStatement("update KhachHang set tenKhachHang=?,diaChi=?,sDT=?,email=? where maKhachHang=?");
			statement.setString(1, kh.getTenKhachHang());
			statement.setString(2, kh.getDiaChi());
			statement.setString(3, kh.getsDT());
			statement.setString(4, kh.getEmail());
			statement.setString(5, kh.getMaKhachHang());
			statement.executeUpdate();
			con.close();
			statement.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	// select *from KhachHang join HoaDon on
	// KhachHang.maKhachHang=HoaDon.maKhachHang where sDT='a'
	public KhachHang timKhachHangTheoSDT(String sdt) {
		KhachHang kh = null;
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("select * from KhachHang where sDT=?");
			statement.setString(1, sdt);
			ResultSet rs = statement.executeQuery();
			rs.next();
			kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"), rs.getString("diaChi"),
					rs.getString("sDT"), rs.getString("email"));
			con.close();
		} catch (Exception e) {

		}
		return kh;
	}

	public List<KhachHang> timKHTheoTen(String ten) {
		List<KhachHang> list = new ArrayList<KhachHang>();
		Connection con = new ConnectDB().getConnect();
		try {
			String sql = "select * from KhachHang where tenKhachHang like N'%" + ten + "%'";

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"), rs.getString("diaChi"), rs.getString("sDT"), rs.getString("email")));
			}
		} catch (SQLException e) {

		}
		return list;
	}
	public List<KhachHang> timKHTheoSDT(String sdt) {
		List<KhachHang> list = new ArrayList<KhachHang>();
		Connection con = new ConnectDB().getConnect();
		try {
			String sql = "select * from KhachHang where sDT like N'%" + sdt + "%'";

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"), rs.getString("diaChi"), rs.getString("sDT"), rs.getString("email")));
			}
		} catch (SQLException e) {

		}
		return list;
	}
	public List<KhachHang> timKHTheoMa(String ma) {
		List<KhachHang> list = new ArrayList<KhachHang>();
		Connection con = new ConnectDB().getConnect();
		try {
			String sql = "select * from KhachHang where maKhachHang like N'%" + ma + "%'";

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"), rs.getString("diaChi"), rs.getString("sDT"), rs.getString("email")));
			}
		} catch (SQLException e) {

		}
		return list;
	}

}
