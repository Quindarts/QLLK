package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.SwingConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import dao.LinhKien_Dao;
import dao.ThongKe_Dao;
import entity.ChiTietHoaDon;
import entity.LinhKien;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ThongKe_Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private String cl_green = "#00c691";
	private String cl_greyblue = "#f0f6fb";
	private String cl_greenbold = "#015a06";
	private String cl_yellow = "#fcbe00";
	private String cl_black = "#222222";
	private Font font_btn16 = new Font("Arial", Font.BOLD, 16);
	private Font font_btn13 = new Font("Arial", Font.BOLD, 13);
	private Font font_btnita = new Font("Arial", Font.ITALIC, 13);

	private static ThongKe_Dao tk_dao;
	private JPanel panel_2;
	private LinhKien_Dao lk_Dao;
	private DefaultTableModel model;
	private JTable tableTop5;
	private int soLuongTop;

	public ThongKe_Panel() {
		tk_dao = new ThongKe_Dao();
		lk_Dao = new LinhKien_Dao();
		setSize(1015, 683);
		setLayout(null);
		setBackground(Color.decode(cl_greyblue));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 51, 51));
		panel.setBounds(39, 75, 253, 140);
		add(panel);
		panel.setLayout(null);

		JLabel lblDoanhThuTrong = new JLabel("Doanh Thu Trong Ngày");
		lblDoanhThuTrong.setForeground(Color.WHITE);
		lblDoanhThuTrong.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDoanhThuTrong.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoanhThuTrong.setBounds(0, 10, 253, 30);
		panel.add(lblDoanhThuTrong);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ThongKe_Panel.class.getResource("/image/money.png")));
		lblNewLabel.setBounds(10, 62, 64, 64);
		panel.add(lblNewLabel);

		JLabel txtDoanhThuNgay = new JLabel();
		txtDoanhThuNgay.setForeground(Color.WHITE);
		txtDoanhThuNgay.setFont(new Font("Arial", Font.PLAIN, 17));
		txtDoanhThuNgay.setBounds(78, 78, 175, 30);
		panel.add(txtDoanhThuNgay);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.decode(cl_green));
		panel_1.setBounds(0, 0, 1015, 55);
		add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("Thống Kê");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);

		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(270, 10, 481, 35);
		panel_1.add(lblNewLabel_1);

		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.decode(cl_yellow));
		panel_2.setBounds(388, 75, 253, 140);
		add(panel_2);

		JLabel lblDoanhThuTrong_1 = new JLabel("Doanh Thu Trong Tháng");
		lblDoanhThuTrong_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoanhThuTrong_1.setForeground(Color.WHITE);
		lblDoanhThuTrong_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDoanhThuTrong_1.setBounds(0, 10, 253, 30);
		panel_2.add(lblDoanhThuTrong_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ThongKe_Panel.class.getResource("/image/money.png")));
		lblNewLabel_3.setBounds(10, 62, 64, 64);
		panel_2.add(lblNewLabel_3);

		JLabel txtDoanhThuThang = new JLabel();
		txtDoanhThuThang.setForeground(Color.WHITE);
		txtDoanhThuThang.setFont(new Font("Arial", Font.PLAIN, 17));
		txtDoanhThuThang.setBounds(78, 78, 175, 30);
		panel_2.add(txtDoanhThuThang);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(60, 179, 113));
		panel_3.setBounds(733, 75, 253, 140);
		add(panel_3);

		JLabel lblDoanhThuTrong_2 = new JLabel("Doanh Thu Trong Năm");
		lblDoanhThuTrong_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoanhThuTrong_2.setForeground(Color.WHITE);
		lblDoanhThuTrong_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDoanhThuTrong_2.setBounds(0, 10, 253, 30);
		panel_3.add(lblDoanhThuTrong_2);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ThongKe_Panel.class.getResource("/image/money.png")));
		lblNewLabel_4.setBounds(10, 62, 64, 64);
		panel_3.add(lblNewLabel_4);
		LocalDate date = LocalDate.now();

		JLabel txtDoanhThuNam = new JLabel();
		txtDoanhThuNam.setForeground(Color.WHITE);
		txtDoanhThuNam.setFont(new Font("Arial", Font.PLAIN, 17));
		txtDoanhThuNam.setBounds(78, 78, 175, 30);
		panel_3.add(txtDoanhThuNam);
		
		DecimalFormat df = new DecimalFormat("#,##0.00");
		txtDoanhThuNgay.setText(String.valueOf(df.format(doanhSoTheoNgay())) + " VNĐ");
		txtDoanhThuThang.setText(String.valueOf(df.format(doanhSoTheoThang(date.getMonthValue(), date.getYear()))) + " VNĐ");
		txtDoanhThuNam.setText(String.valueOf(df.format(doanhSoTheoNam())) + " VNĐ");

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(Color.decode(cl_yellow)));
		panel_5.setBounds(0, 238, 1011, 418);
		add(panel_5);
		panel_5.setLayout(null);

		String cols[] = { "STT", "Ma Linh Kien", "So Luong" };
		model = new DefaultTableModel(cols, 0);
		tableTop5 = new JTable(model);
		JScrollPane sp5 = new JScrollPane(tableTop5);
		sp5.setBounds(10, 50, 1000, 305);
		
		JTableHeader a = tableTop5.getTableHeader();
		a.setBackground(Color.decode(cl_green));
		a.setForeground(Color.white);
		
		panel_5.add(sp5);

		JLabel lblTopLinh = new JLabel("TOP 10 LINH KIỆN BÁN CHẠY TRONG THÁNG NAY ");
		lblTopLinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopLinh.setFont(new Font("Arial", Font.BOLD, 15));
		lblTopLinh.setBounds(10, 10, 1000, 35);
		panel_5.add(lblTopLinh);

		Map<String, Integer> map = tk_dao.topLinhKien(10, date.getMonthValue(), date.getYear());
		TreeMap<String, Integer> mapSort = tk_dao.sortMapByValue(map);
		soLuongTop = 0;
		
		mapSort.forEach((m, n) -> {
			soLuongTop++;
			model.addRow(new Object[] { soLuongTop, m, String.valueOf(n) });
		});

	}

	public double doanhSoTheoNgay() {
		LocalDate date = LocalDate.now();
		List<ChiTietHoaDon> listCTHD = tk_dao.doanhThuTheoNgay(date.getDayOfMonth(), date.getMonthValue(),
				date.getYear());
		double tong = 0;
		for (int i = 0; i < listCTHD.size(); i++) {
			
			tong += (listCTHD.get(i).getSoLuong() * listCTHD.get(i).getLinhKien().getGiaBan())
					- ((listCTHD.get(i).getSoLuong() * listCTHD.get(i).getLinhKien().getGiaBan())
							* listCTHD.get(i).getMucGiamGia()) / 100;
			
		}
		return tong;
	}

	private static double doanhSoTheoThang(int thang, int nam) {

		List<ChiTietHoaDon> listCTHD = tk_dao.doanhThuTheoThang(thang, nam);
		double tong = 0;
		for (int i = 0; i < listCTHD.size(); i++) {
			
			tong += (listCTHD.get(i).getSoLuong() * listCTHD.get(i).getLinhKien().getGiaBan())
					- ((listCTHD.get(i).getSoLuong() * listCTHD.get(i).getLinhKien().getGiaBan())
							* listCTHD.get(i).getMucGiamGia()) / 100;
			
		}
		return tong;
	}

	public double doanhSoTheoNam() {
		LocalDate date = LocalDate.now();
		List<ChiTietHoaDon> listCTHD = tk_dao.doanhThuTheoNam(date.getYear());
		double tong = 0;
		for (int i = 0; i < listCTHD.size(); i++) {
			
			tong += (listCTHD.get(i).getSoLuong() * listCTHD.get(i).getLinhKien().getGiaBan())
					- ((listCTHD.get(i).getSoLuong() * listCTHD.get(i).getLinhKien().getGiaBan())
							* listCTHD.get(i).getMucGiamGia()) / 100;
			
		}
		return tong;
	}
}
