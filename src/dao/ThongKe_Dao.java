package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import connect.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;

import entity.LinhKien;

public class ThongKe_Dao {
	public List<ChiTietHoaDon> doanhThuTheoNgay(int ngay, int thang, int nam) {
		List<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement(
					"select *from HoaDon join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon join LinhKien on ChiTietHoaDon.maLinhKien = LinhKien.maLinhKien where DAY(ngayDatHang)=? and MONTH(ngayDatHang)=? and YEAR(ngayDatHang)=?");

			statement.setInt(1, ngay);
			statement.setInt(2, thang);
			statement.setInt(3, nam);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				LinhKien lk = new LinhKien();
				lk.setMaLinhKien(rs.getString("maLinhKien"));
				lk.setGiaBan(rs.getDouble("giaBan"));
				HoaDon hd = new HoaDon();
				hd.setMaHoaDon(rs.getString("maHoaDon"));
				hd.setNgayDatHang(rs.getDate("ngayDatHang"));
				list.add(new ChiTietHoaDon(lk, hd, rs.getInt("soLuong"), rs.getInt("mucGiamGia")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ChiTietHoaDon> doanhThuTheoThang(int thang, int nam) {
		List<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement(
					"select *from HoaDon join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon join LinhKien on ChiTietHoaDon.maLinhKien = LinhKien.maLinhKien where MONTH(ngayDatHang)=? and YEAR(ngayDatHang)=?");
			statement.setInt(1, thang);
			statement.setInt(2, nam);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				LinhKien lk = new LinhKien();
				lk.setMaLinhKien(rs.getString("maLinhKien"));
				lk.setGiaBan(rs.getDouble("giaBan"));
				HoaDon hd = new HoaDon();
				hd.setMaHoaDon(rs.getString("maHoaDon"));
				hd.setNgayDatHang(rs.getDate("ngayDatHang"));
				list.add(new ChiTietHoaDon(lk, hd, rs.getInt("soLuong"), rs.getInt("mucGiamGia")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ChiTietHoaDon> doanhThuTheoNam(int nam) {
		List<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement(
					"select *from HoaDon join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon join LinhKien on ChiTietHoaDon.maLinhKien = LinhKien.maLinhKien where YEAR(ngayDatHang)=?");
			statement.setInt(1, nam);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				LinhKien lk = new LinhKien();
				lk.setMaLinhKien(rs.getString("maLinhKien"));
				lk.setGiaBan(rs.getDouble("giaBan"));
				HoaDon hd = new HoaDon();
				hd.setMaHoaDon(rs.getString("maHoaDon"));
				hd.setNgayDatHang(rs.getDate("ngayDatHang"));
				list.add(new ChiTietHoaDon(lk, hd, rs.getInt("soLuong"), rs.getInt("mucGiamGia")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static Map<String, Integer> topLinhKien(int top, int thang, int nam) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement(
					"select top 10 ChiTietHoaDon.maLinhKien,tenLinhKien,dem=sum(soLuong) from ChiTietHoaDon join LinhKien on ChiTietHoaDon.maLinhKien=linhKien.maLinhKien join HoaDon on HoaDon.maHoaDon=ChiTietHoaDon.maHoaDon where MONTH(ngayDatHang)=? and YEAR(ngayDatHang)=? group by ChiTietHoaDon.maLinhKien,tenLinhKien order by dem desc");

			statement.setInt(1, thang);
			statement.setInt(2, nam);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				LinhKien lk = new LinhKien();

				lk.setMaLinhKien(rs.getString("maLinhKien"));
				map.put(rs.getString("maLinhKien"), rs.getInt("dem"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static TreeMap<String, Integer> sortMapByValue(Map<String, Integer> map) {
		Comparator<String> comparator = new ValueComparator(map);
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
		return result;
	}
}

class ValueComparator implements Comparator<String> {

	HashMap<String, Integer> map = new HashMap<String, Integer>();

	public ValueComparator(Map<String, Integer> map2) {
		this.map.putAll(map2);
	}

	@Override
	public int compare(String s1, String s2) {
		if (map.get(s1) >= map.get(s2)) {
			return -1;
		} else {
			return 1;
		}
	}
}
