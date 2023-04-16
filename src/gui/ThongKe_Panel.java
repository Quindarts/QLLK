package gui;

import javax.swing.JPanel;
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
		lblNewLabel.setIcon(new ImageIcon(ThongKe_Panel.class.getResource("/image/money_bag_60px.png")));
		lblNewLabel.setBounds(10, 62, 58, 63);
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
		lblNewLabel_3.setIcon(new ImageIcon(ThongKe_Panel.class.getResource("/image/money_bag_60px.png")));
		lblNewLabel_3.setBounds(10, 62, 58, 63);
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
		lblNewLabel_4.setIcon(new ImageIcon(ThongKe_Panel.class.getResource("/image/money_bag_60px.png")));
		lblNewLabel_4.setBounds(10, 62, 58, 63);
		panel_3.add(lblNewLabel_4);
		LocalDate date = LocalDate.now();

		JLabel txtDoanhThuNam = new JLabel();
		txtDoanhThuNam.setForeground(Color.WHITE);
		txtDoanhThuNam.setFont(new Font("Arial", Font.PLAIN, 17));
		txtDoanhThuNam.setBounds(78, 78, 175, 30);
		panel_3.add(txtDoanhThuNam);
		DecimalFormat df = new DecimalFormat("#,##0.00");
		txtDoanhThuNgay.setText(String.valueOf(df.format(doanhSoTheoNgay())) + " VNĐ");
		txtDoanhThuThang
				.setText(String.valueOf(df.format(doanhSoTheoThang(date.getMonthValue(), date.getYear()))) + " VNĐ");
		txtDoanhThuNam.setText(String.valueOf(df.format(doanhSoTheoNam())) + " VNĐ");

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.decode(cl_green)));
		panel_4.setBounds(10, 238, 498, 418);
		add(panel_4);
		panel_4.setLayout(null);

		JLabel lblThngKLinh = new JLabel("BIỂU ĐỒ DOANH THU THEO TỪNG THÁNG");
		lblThngKLinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKLinh.setFont(new Font("Arial", Font.BOLD, 15));
		lblThngKLinh.setBounds(10, 10, 480, 35);
		panel_4.add(lblThngKLinh);

		JLabel lblNewLabel_2 = new JLabel("(5 năm gần đây)");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(166, 32, 146, 26);
		panel_4.add(lblNewLabel_2);

		JPanel pCot = new JPanel();
		pCot.setLayout(null);
		pCot.setBackground(Color.WHITE);
		pCot.setBounds(10, 111, 480, 305);
		panel_4.add(pCot);
		JComboBox<String> cboDoanhThu = new JComboBox<String>();
		cboDoanhThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item[] = cboDoanhThu.getSelectedItem().toString().split(" ");
				ChartPanel chartPanel1 = new ChartPanel(createChart1(Integer.parseInt(item[1])));
				chartPanel1.setBounds(0, 0, 480, 305);
				chartPanel1.setPreferredSize(new java.awt.Dimension(480, 305));
				pCot.removeAll();
				pCot.add(chartPanel1);
				pCot.invalidate();
				pCot.repaint();
			}
		});
		cboDoanhThu.setBounds(10, 75, 146, 26);
		panel_4.add(cboDoanhThu);
		cboDoanhThu.addItem("Năm " + String.valueOf(date.getYear()));
		cboDoanhThu.addItem("Năm " + String.valueOf(date.getYear() - 1));
		cboDoanhThu.addItem("Năm " + String.valueOf(date.getYear() - 2));
		cboDoanhThu.addItem("Năm " + String.valueOf(date.getYear() - 3));
		cboDoanhThu.addItem("Năm " + String.valueOf(date.getYear() - 4));

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(Color.decode(cl_yellow)));
		panel_5.setBounds(518, 238, 487, 418);
		add(panel_5);
		panel_5.setLayout(null);

		JLabel lblTopLinh = new JLabel("TOP 5 LINH KIỆN BÁN CHẠY TRONG THÁNG ");
		lblTopLinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopLinh.setFont(new Font("Arial", Font.BOLD, 15));
		lblTopLinh.setBounds(10, 10, 460, 35);
		panel_5.add(lblTopLinh);

		JLabel lblNewLabel_2_1 = new JLabel("(5 tháng gần đây)");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(156, 32, 146, 26);
		panel_5.add(lblNewLabel_2_1);

		JPanel pTron = new JPanel();
		pTron.setLayout(null);
		pTron.setBorder(null);
		pTron.setBounds(10, 111, 468, 305);
		panel_5.add(pTron);

		JLabel lblNewLabel_5 = new JLabel("STT");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5.setBounds(25, 23, 46, 35);
		pTron.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("Tên Linh Kiện");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(81, 23, 100, 35);
		pTron.add(lblNewLabel_5_1);

		JLabel lblNewLabel_5_2 = new JLabel("Mã Linh Kiện");
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5_2.setBounds(279, 23, 95, 35);
		pTron.add(lblNewLabel_5_2);

		JLabel lblNewLabel_5_3 = new JLabel("Số lượng");
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5_3.setBounds(374, 23, 84, 35);
		pTron.add(lblNewLabel_5_3);

		JLabel lblNewLabel_5_4 = new JLabel("1");
		lblNewLabel_5_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_5_4.setBounds(25, 73, 46, 35);
		pTron.add(lblNewLabel_5_4);

		JLabel lblNewLabel_5_5 = new JLabel("2");
		lblNewLabel_5_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_5_5.setBounds(25, 103, 46, 35);
		pTron.add(lblNewLabel_5_5);

		JLabel lblNewLabel_5_6 = new JLabel("3");
		lblNewLabel_5_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_6.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_5_6.setBounds(25, 133, 46, 35);
		pTron.add(lblNewLabel_5_6);

		JLabel lblNewLabel_5_7 = new JLabel("4");
		lblNewLabel_5_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_7.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_5_7.setBounds(25, 163, 46, 35);
		pTron.add(lblNewLabel_5_7);

		JLabel lblNewLabel_5_7_1 = new JLabel("5");
		lblNewLabel_5_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_7_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_5_7_1.setBounds(25, 193, 46, 35);
		pTron.add(lblNewLabel_5_7_1);

		JLabel txtTen1 = new JLabel("");
		txtTen1.setHorizontalAlignment(SwingConstants.LEFT);
		txtTen1.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTen1.setBounds(81, 73, 182, 35);
		pTron.add(txtTen1);

		JLabel txtMa1 = new JLabel("");
		txtMa1.setHorizontalAlignment(SwingConstants.LEFT);
		txtMa1.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMa1.setBounds(279, 73, 106, 35);
		pTron.add(txtMa1);

		JLabel txtSL1 = new JLabel("");
		txtSL1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSL1.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSL1.setBounds(384, 73, 62, 35);
		pTron.add(txtSL1);

		JLabel txtTen2 = new JLabel("");
		txtTen2.setHorizontalAlignment(SwingConstants.LEFT);
		txtTen2.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTen2.setBounds(81, 103, 188, 35);
		pTron.add(txtTen2);

		JLabel txtMa2 = new JLabel("");
		txtMa2.setHorizontalAlignment(SwingConstants.CENTER);
		txtMa2.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMa2.setBounds(279, 103, 106, 35);
		pTron.add(txtMa2);

		JLabel txtSL2 = new JLabel("");
		txtSL2.setHorizontalAlignment(SwingConstants.CENTER);
		txtSL2.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSL2.setBounds(384, 103, 62, 35);
		pTron.add(txtSL2);

		JLabel txtTen3 = new JLabel("");
		txtTen3.setHorizontalAlignment(SwingConstants.LEFT);
		txtTen3.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTen3.setBounds(81, 133, 188, 35);
		pTron.add(txtTen3);

		JLabel txtMa3 = new JLabel("");
		txtMa3.setHorizontalAlignment(SwingConstants.CENTER);
		txtMa3.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMa3.setBounds(279, 133, 106, 35);
		pTron.add(txtMa3);

		JLabel txtSL3 = new JLabel("");
		txtSL3.setHorizontalAlignment(SwingConstants.CENTER);
		txtSL3.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSL3.setBounds(384, 133, 62, 35);
		pTron.add(txtSL3);

		JLabel txtTen4 = new JLabel("");
		txtTen4.setHorizontalAlignment(SwingConstants.LEFT);
		txtTen4.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTen4.setBounds(81, 163, 188, 35);
		pTron.add(txtTen4);

		JLabel txtMa4 = new JLabel("");
		txtMa4.setHorizontalAlignment(SwingConstants.CENTER);
		txtMa4.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMa4.setBounds(279, 163, 106, 35);
		pTron.add(txtMa4);

		JLabel txtSL4 = new JLabel("");
		txtSL4.setHorizontalAlignment(SwingConstants.CENTER);
		txtSL4.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSL4.setBounds(384, 163, 62, 35);
		pTron.add(txtSL4);

		JLabel txtTen5 = new JLabel("");
		txtTen5.setHorizontalAlignment(SwingConstants.LEFT);
		txtTen5.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTen5.setBounds(81, 193, 188, 35);
		pTron.add(txtTen5);

		JLabel txtMa5 = new JLabel("");
		txtMa5.setHorizontalAlignment(SwingConstants.CENTER);
		txtMa5.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMa5.setBounds(279, 193, 106, 35);
		pTron.add(txtMa5);

		JLabel txtSL5 = new JLabel("");
		txtSL5.setHorizontalAlignment(SwingConstants.CENTER);
		txtSL5.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSL5.setBounds(384, 193, 62, 35);
		pTron.add(txtSL5);

		JComboBox<String> cboBanChay = new JComboBox<String>();
		cboBanChay.setBounds(10, 75, 146, 26);
		panel_5.add(cboBanChay);
		cboBanChay.addItem("Tháng " + String.valueOf(date.getMonthValue()));
		cboBanChay.addItem("Tháng " + String.valueOf(date.getMonthValue() - 1));
		cboBanChay.addItem("Tháng " + String.valueOf(date.getMonthValue() - 2));
		cboBanChay.addItem("Tháng " + String.valueOf(date.getMonthValue() - 3));
		cboBanChay.addItem("Tháng " + String.valueOf(date.getMonthValue() - 4));
		cboBanChay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item[] = cboBanChay.getSelectedItem().toString().split(" ");
				List<String> malk = new ArrayList<String>();
				List<String> tenlk = new ArrayList<String>();
				List<Integer> sl = new ArrayList<Integer>();
				Map<String, Integer> map = tk_dao.topLinhKien(5, (Integer.parseInt(item[1])), date.getYear());
				TreeMap<String, Integer> map1 = sortMapByValue(map);
				map1.forEach((m, n) -> {
					malk.add(m);
					sl.add(n);
				});
				List<LinhKien> listLK = lk_Dao.getLinhKien();
				for (int i = 0; i < malk.size(); i++) {
					for (int j = 0; j < listLK.size(); j++) {
						if (malk.get(i).toString().equals(listLK.get(j).getMaLinhKien())) {
							tenlk.add(listLK.get(j).getTenLinhKien());
						}
					}
				}
				if (malk.size() != 0) {
					if (malk.size() == 1) {
						txtTen1.setText(tenlk.get(0).toString());
						txtMa1.setText(malk.get(0).toString());
						txtSL1.setText(sl.get(0).toString());
						txtTen2.setText("");
						txtMa2.setText("");
						txtSL2.setText("");
						txtTen3.setText("");
						txtMa3.setText("");
						txtSL3.setText("");
						txtTen4.setText("");
						txtMa4.setText("");
						txtSL4.setText("");
						txtTen5.setText("");
						txtMa5.setText("");
						txtSL5.setText("");

					}
					if (malk.size() == 2) {
						txtTen1.setText(tenlk.get(0).toString());
						txtMa1.setText(malk.get(0).toString());
						txtSL1.setText(sl.get(0).toString());
						txtTen2.setText(tenlk.get(1).toString());
						txtMa2.setText(malk.get(1).toString());
						txtSL2.setText(sl.get(1).toString());
						txtTen3.setText("");
						txtMa3.setText("");
						txtSL3.setText("");
						txtTen4.setText("");
						txtMa4.setText("");
						txtSL4.setText("");
						txtTen5.setText("");
						txtMa5.setText("");
						txtSL5.setText("");
					}
					if (malk.size() == 3) {
						txtTen1.setText(tenlk.get(0).toString());
						txtMa1.setText(malk.get(0).toString());
						txtSL1.setText(sl.get(0).toString());
						txtTen2.setText(tenlk.get(1).toString());
						txtMa2.setText(malk.get(1).toString());
						txtSL2.setText(sl.get(1).toString());
						txtTen3.setText(tenlk.get(2).toString());
						txtMa3.setText(malk.get(2).toString());
						txtSL3.setText(sl.get(2).toString());
						txtTen4.setText("");
						txtMa4.setText("");
						txtSL4.setText("");
						txtTen5.setText("");
						txtMa5.setText("");
						txtSL5.setText("");
					}
					if (malk.size() == 4) {
						txtTen1.setText(tenlk.get(0).toString());
						txtMa1.setText(malk.get(0).toString());
						txtSL1.setText(sl.get(0).toString());
						txtTen2.setText(tenlk.get(1).toString());
						txtMa2.setText(malk.get(1).toString());
						txtSL2.setText(sl.get(1).toString());
						txtTen3.setText(tenlk.get(2).toString());
						txtMa3.setText(malk.get(2).toString());
						txtSL3.setText(sl.get(2).toString());
						txtTen4.setText(tenlk.get(3).toString());
						txtMa4.setText(malk.get(3).toString());
						txtSL4.setText(sl.get(3).toString());
						txtTen5.setText("");
						txtMa5.setText("");
						txtSL5.setText("");
					}
					if (malk.size() == 5) {
						txtTen1.setText(tenlk.get(0).toString());
						txtMa1.setText(malk.get(0).toString());
						txtSL1.setText(sl.get(0).toString());
						txtTen2.setText(tenlk.get(1).toString());
						txtMa2.setText(malk.get(1).toString());
						txtSL2.setText(sl.get(1).toString());
						txtTen3.setText(tenlk.get(2).toString());
						txtMa3.setText(malk.get(2).toString());
						txtSL3.setText(sl.get(2).toString());
						txtTen4.setText(tenlk.get(3).toString());
						txtMa4.setText(malk.get(3).toString());
						txtSL4.setText(sl.get(3).toString());
						txtTen5.setText(tenlk.get(4).toString());
						txtMa5.setText(malk.get(4).toString());
						txtSL5.setText(sl.get(4).toString());
					}

				} else {
					txtTen1.setText("");
					txtMa1.setText("");
					txtSL1.setText("");
					txtTen2.setText("");
					txtMa2.setText("");
					txtSL2.setText("");
					txtTen3.setText("");
					txtMa3.setText("");
					txtSL3.setText("");
					txtTen4.setText("");
					txtMa4.setText("");
					txtSL4.setText("");
					txtTen5.setText("");
					txtMa5.setText("");
					txtSL5.setText("");
				}

			}
		});

		List<String> malk = new ArrayList<String>();
		List<String> tenlk = new ArrayList<String>();
		List<Integer> sl = new ArrayList<Integer>();
		Map<String, Integer> map = tk_dao.topLinhKien(5, date.getMonthValue(), date.getYear());
		TreeMap<String, Integer> map1 = sortMapByValue(map);
		map1.forEach((m, n) -> {
			malk.add(m);
			sl.add(n);
		});
		List<LinhKien> listLK = lk_Dao.getLinhKien();
		for (int i = 0; i < malk.size(); i++) {
			for (int j = 0; j < listLK.size(); j++) {
				if (malk.get(i).toString().equals(listLK.get(j).getMaLinhKien())) {
					tenlk.add(listLK.get(j).getTenLinhKien());
				}
			}
		}
		if (malk.size() != 0) {
			if (malk.size() == 1) {
				txtTen1.setText(tenlk.get(0).toString());
				txtMa1.setText(malk.get(0).toString());
				txtSL1.setText(sl.get(0).toString());

			}
			if (malk.size() == 2) {
				txtTen1.setText(tenlk.get(0).toString());
				txtMa1.setText(malk.get(0).toString());
				txtSL1.setText(sl.get(0).toString());
				txtTen2.setText(tenlk.get(1).toString());
				txtMa2.setText(malk.get(1).toString());
				txtSL2.setText(sl.get(1).toString());
			}
			if (malk.size() == 3) {
				txtTen1.setText(tenlk.get(0).toString());
				txtMa1.setText(malk.get(0).toString());
				txtSL1.setText(sl.get(0).toString());
				txtTen2.setText(tenlk.get(1).toString());
				txtMa2.setText(malk.get(1).toString());
				txtSL2.setText(sl.get(1).toString());
				txtTen3.setText(tenlk.get(2).toString());
				txtMa3.setText(malk.get(2).toString());
				txtSL3.setText(sl.get(2).toString());
			}
			if (malk.size() == 4) {
				txtTen1.setText(tenlk.get(0).toString());
				txtMa1.setText(malk.get(0).toString());
				txtSL1.setText(sl.get(0).toString());
				txtTen2.setText(tenlk.get(1).toString());
				txtMa2.setText(malk.get(1).toString());
				txtSL2.setText(sl.get(1).toString());
				txtTen3.setText(tenlk.get(2).toString());
				txtMa3.setText(malk.get(2).toString());
				txtSL3.setText(sl.get(2).toString());
				txtTen4.setText(tenlk.get(3).toString());
				txtMa4.setText(malk.get(3).toString());
				txtSL4.setText(sl.get(3).toString());
			}
			if (malk.size() == 5) {
				txtTen1.setText(tenlk.get(0).toString());
				txtMa1.setText(malk.get(0).toString());
				txtSL1.setText(sl.get(0).toString());
				txtTen2.setText(tenlk.get(1).toString());
				txtMa2.setText(malk.get(1).toString());
				txtSL2.setText(sl.get(1).toString());
				txtTen3.setText(tenlk.get(2).toString());
				txtMa3.setText(malk.get(2).toString());
				txtSL3.setText(sl.get(2).toString());
				txtTen4.setText(tenlk.get(3).toString());
				txtMa4.setText(malk.get(3).toString());
				txtSL4.setText(sl.get(3).toString());
				txtTen5.setText(tenlk.get(4).toString());
				txtMa5.setText(malk.get(4).toString());
				txtSL5.setText(sl.get(4).toString());
			}

		} else {
			txtTen1.setText("");
			txtMa1.setText("");
			txtSL1.setText("");
			txtTen2.setText("");
			txtMa2.setText("");
			txtSL2.setText("");
			txtTen3.setText("");
			txtMa3.setText("");
			txtSL3.setText("");
			txtTen4.setText("");
			txtMa4.setText("");
			txtSL4.setText("");
			txtTen5.setText("");
			txtMa5.setText("");
			txtSL5.setText("");
		}

	}

	public static JFreeChart createChart1(int nam) {
		JFreeChart barChart = ChartFactory.createBarChart("", "Tháng", "Tổng tiền (VNĐ)", createDataset1(nam),
				PlotOrientation.VERTICAL, false, false, false);
		return barChart;
	}

	private static CategoryDataset createDataset1(int nam) {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// LocalDate date = LocalDate.now();
		for (int i = 1; i < 13; i++) {
			dataset.addValue(doanhSoTheoThang(i, nam), "Tổng tiền (VNĐ)", String.valueOf(i));
		}

		return dataset;
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

	public static TreeMap<String, Integer> sortMapByValue(Map<String, Integer> map) {
		Comparator<String> comparator = new ValueComparator(map);
		// TreeMap is a map sorted by its keys.
		// The comparator is used to sort the TreeMap by keys.
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
