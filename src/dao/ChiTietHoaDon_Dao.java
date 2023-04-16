package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;

import entity.LinhKien;
import entity.NhaCungCap;


public class ChiTietHoaDon_Dao {
	public boolean XoaCTHD(String ma) {
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("delete ChiTietHoaDon where maHoaDon=?");
			statement.setString(1, ma);
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	public  boolean themChiTietHoaDon(ChiTietHoaDon cthd) {
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("insert into ChiTietHoaDon values(?,?,?,?)");
			statement.setString(1, cthd.getLinhKien().getMaLinhKien());
			statement.setString(2, cthd.getHoaDon().getMaHoaDon());
			statement.setInt(3, cthd.getSoLuong());
			statement.setInt(4, cthd.getMucGiamGia());
			statement.executeUpdate();
			con.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public List<ChiTietHoaDon> getCTHDTheoMa(String ma) {
		List<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		Connection con  = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("select *from ChiTietHoaDon join LinhKien on ChiTietHoaDon.maLinhKien=LinhKien.maLinhKien where maHoaDon=?");
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				list.add(new ChiTietHoaDon(new LinhKien(new NhaCungCap(), rs.getString("maLinhKien"), rs.getString("tenLinhKien"), null, 0, rs.getDouble("giaBan"), rs.getInt("baoHanh"), null, rs.getDate("ngayNhap")), new HoaDon(rs.getString("maHoaDon")), rs.getInt("soLuong"),rs.getInt("mucGiamGia")));
			}
		} catch (SQLException e) {
			
		}
		
		return list;
	}
	
	
}
