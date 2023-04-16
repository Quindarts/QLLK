package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entity.NhanVien;

public class NhanVien_Dao {
	public List<NhanVien> getNhanVien() {
		List<NhanVien> list = new ArrayList<NhanVien>();
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("select *from NhanVien");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				list.add(new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"), rs.getString("chucVu"), rs.getDouble("luong"), rs.getString("diaChi"), rs.getBoolean("gioiTinh"), rs.getString("sDT"),rs.getString("cMND"), rs.getString("matKhau")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean ThemNV(NhanVien nv) {
		Connection con  = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?,?,?)");
			statement.setString(1, nv.getMaNhanVien());
			statement.setString(2, nv.getTenNhanVien());
			statement.setString(3, nv.getChucVu());
			statement.setDouble(4, nv.getHeSoLuong());
			statement.setString(5, nv.getDiaChi());
			statement.setBoolean(6, nv.isGioiTinh());
			statement.setString(7, nv.getsDT());
			statement.setString(8, nv.getcMND());
			statement.setString(9, nv.getMatKhau());
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			return false;
			
		}
		return true;
	}
	public boolean CapNhatNV(NhanVien nv) {
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("update NhanVien set tenNhanVien=?,chucVu=?,luong=?,diaChi=?,gioiTinh=?,sDT=?,cMND=?,matKhau=? where maNhanVien=?");
			statement.setString(1, nv.getTenNhanVien());
			statement.setString(2, nv.getChucVu());
			statement.setDouble(3, nv.getHeSoLuong());
			statement.setString(4, nv.getDiaChi());
			statement.setBoolean(5, nv.isGioiTinh());
			statement.setString(6, nv.getsDT());
			statement.setString(7, nv.getcMND());
			statement.setString(8, nv.getMatKhau());
			statement.setString(9, nv.getMaNhanVien());
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	public boolean xoaNV(String ma) {
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("delete NhanVien where maNhanVien=?");
			statement.setString(1, ma);
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
		
	}
}
