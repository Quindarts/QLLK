package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entity.NhaCungCap;


public class NhaCungCap_Dao {
	public List<NhaCungCap> getNhaCungCap() {
		List<NhaCungCap> list = new ArrayList<NhaCungCap>();
		Connection con = new ConnectDB().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("select *from NhaCungCap");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				list.add(new NhaCungCap(rs.getString("maNCC"), rs.getString("tenNCC"), rs.getString("diaChi"), rs.getString("sDT"), rs.getString("email")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
