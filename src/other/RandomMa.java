package other;

import java.util.ArrayList;
import java.util.List;

import dao.HoaDon_Dao;
import dao.KhachHang_Dao;
import dao.LinhKien_Dao;
import dao.NhanVien_Dao;
import entity.HoaDon;
import entity.KhachHang;
import entity.LinhKien;
import entity.NhanVien;

public class RandomMa {
	public String taoMaHoaDon() {
		long ma = 10000000;
		HoaDon_Dao hd = new HoaDon_Dao();
		List<HoaDon> list = hd.getHoaDon();
		for (int i = 0; i < list.size(); i++) {
			if (i == (list.size() - 1)) {
				String chuoi[] = list.get(i).getMaHoaDon().split("D");
				ma = Long.parseLong(chuoi[1]) + 1;
			}
		}
		return "HD" + ma;
	}

	public String taoMaLinhKien() {
		long ma = 10000000;
		LinhKien_Dao lk = new LinhKien_Dao();
		List<LinhKien> list = lk.getLinhKien();
		for (int i = 0; i < list.size(); i++) {
			if (i == (list.size() - 1)) {
				String chuoi[] = list.get(i).getMaLinhKien().split("K");
				ma = Long.parseLong(chuoi[1]) + 1;
			}
		}
		return "LK" + ma;
	}

	public String taoMaKhachHang() {
		long ma = 10000000;
		KhachHang_Dao kh = new KhachHang_Dao();
		List<KhachHang> list = kh.getKhachHang();
		for (int i = 0; i < list.size(); i++) {
			if (i == (list.size() - 1)) {
				String chuoi[] = list.get(i).getMaKhachHang().split("H");
				ma = Long.parseLong(chuoi[1]) + 1;
			}
		}
		return "KH" + ma;
	}

	public String taoMaNhanVien() {
		long ma = 10000000;
		NhanVien_Dao nv = new NhanVien_Dao();
		List<NhanVien> list = nv.getNhanVien();
		for (int i = 0; i < list.size(); i++) {
			if (i == (list.size() - 1)) {
				String chuoi[] = list.get(i).getMaNhanVien().split("V");
				ma = Long.parseLong(chuoi[1]) + 1;
			}
		}
		return "NV" + ma;
	}

}
