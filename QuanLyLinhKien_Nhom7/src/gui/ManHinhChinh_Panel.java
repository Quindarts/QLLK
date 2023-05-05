package gui;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import dao.ChiTietHoaDon_Dao;
import dao.HoaDon_Dao;
import dao.KhachHang_Dao;
import dao.LinhKien_Dao;
import dao.NhaCungCap_Dao;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.LinhKien;
import entity.NhaCungCap;
import entity.NhanVien;
import other.DatePicker;
import other.RandomMa;
import other.XuLyNgay;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.EventObject;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManHinhChinh_Panel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private String cl_green = "#00c691";
	private String cl_greyblue = "#f0f6fb";
	private String cl_greenbold = "#015a06";
	private String cl_yellow = "#fcbe00";
	private String cl_black = "#222222";
	private Font font_btn20 = new Font("Arial", Font.BOLD, 20);
	private Font font_btn16 = new Font("Arial", Font.BOLD, 16);
	private Font font_btn13 = new Font("Arial", Font.BOLD, 13);
	private Font font_btnita = new Font("Arial", Font.ITALIC, 13);
	
	private static final long serialVersionUID = 1L;
	private JTextField txtTim;
	private JTextField txtMaHoaDon;
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtNgayDatHang;
	private JTextField txtTongTien;
	private JTextField txtKhachTra;
	private JTextField txtThoiLai;
	private JTextField txtEmail;
	private DefaultTableModel model1;
	private JTable table1;
	private DefaultTableModel model2;
	private JTextField txtSoLuong;
	private JTable table2;
	@SuppressWarnings("unused")
	private NhanVien nhanVien;

	private JTextField txtTrang;
	private LinhKien_Dao lk_dao;
	private List<LinhKien> listLK;
	private JTextField txtNgayGiaoHang;
	private JTextField txtNgayChuyenHang;
	private JTextField txtNoiNhan;
	@SuppressWarnings("unused")
	private Date date;
	private String dateFormat;

	private KhachHang_Dao kh_dao;
	private HoaDon_Dao hd_dao;
	private ChiTietHoaDon_Dao cthd_dao;
	private JComboBox<String> cboLoaiLK;
	private NhaCungCap_Dao ncc_dao;
	private JComboBox<String> cboThuongHieu;
	private SimpleDateFormat formatter;
	private JComboBox<String> cboKhoangGia;
	private JTextField txtMucGiamGia;

	/**
	 * Create the panel.
	 */

	public ManHinhChinh_Panel(NhanVien nhanVien) {
		super();
		this.nhanVien = nhanVien;

		System.out.println(nhanVien.getMaNhanVien());

		ncc_dao = new NhaCungCap_Dao();
		cthd_dao = new ChiTietHoaDon_Dao();
		kh_dao = new KhachHang_Dao();
		hd_dao = new HoaDon_Dao();
		lk_dao = new LinhKien_Dao();
		hd_dao = new HoaDon_Dao();
		setSize(1015, 683);
		setLayout(null);
		JPanel pLeft = new JPanel();
		pLeft.setLayout(null);
		pLeft.setForeground(Color.WHITE);
		pLeft.setBackground(Color.decode(cl_greyblue));
		pLeft.setBounds(0, 0, 514, 684);
		add(pLeft);

		String row1[] = { "Mã linh kiện", "Tên linh kiện", "Loại", "Thương hiệu", "Số lượng tồn", "Giá bán" };
		model1 = new DefaultTableModel(row1, 0);
		table1 = new JTable(model1) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) {
				return false;
			};
		};
		table1.getColumnModel().getColumn(1).setPreferredWidth(140);
		JScrollPane scrollPane1 = new JScrollPane(table1);
		scrollPane1.setBounds(10, 182, 494, 364);
		pLeft.add(scrollPane1);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);
		table1.getColumnModel().getColumn(0).setCellRenderer(center);
		table1.getColumnModel().getColumn(2).setCellRenderer(center);
		table1.getColumnModel().getColumn(3).setCellRenderer(center);
		table1.getColumnModel().getColumn(4).setCellRenderer(center);
		table1.getColumnModel().getColumn(5).setCellRenderer(center);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode(cl_green));
		panel.setBounds(10, 10, 494, 55);
		pLeft.add(panel);

		JLabel lblDanhSchLinh = new JLabel("Danh Sách Linh Kiện Máy Tính");
		lblDanhSchLinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchLinh.setForeground(Color.WHITE);
		lblDanhSchLinh.setFont(font_btn20);
		lblDanhSchLinh.setBounds(58, 10, 377, 35);
		panel.add(lblDanhSchLinh);

		JLabel lblNewLabel_1 = new JLabel("Tìm theo tên :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 77, 111, 25);
		pLeft.add(lblNewLabel_1);

		txtTim = new JTextField();
		txtTim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (cboLoaiLK.getSelectedItem().equals("Tất cả") && cboThuongHieu.getSelectedItem().equals("Tất cả")
						&& cboKhoangGia.getSelectedItem().equals("Tất cả")) {

					List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "", "", 0, 1000000000);
					XoaDL1();
					listLK.forEach(lk -> {
						model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
								lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
					});
				} else if (cboLoaiLK.getSelectedItem().equals("Tất cả")
						&& !cboThuongHieu.getSelectedItem().equals("Tất cả")
						&& !cboKhoangGia.getSelectedItem().equals("Tất cả")) {
					if (cboKhoangGia.getSelectedIndex() == 1) {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "",
								(String) cboThuongHieu.getSelectedItem(), 0, 500000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					} else if (cboKhoangGia.getSelectedIndex() == 2) {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "",
								(String) cboThuongHieu.getSelectedItem(), 500000, 1000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					} else if (cboKhoangGia.getSelectedIndex() == 3) {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "",
								(String) cboThuongHieu.getSelectedItem(), 1000000, 1000000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					}

				} else if (cboLoaiLK.getSelectedItem().equals("Tất cả")
						&& !cboThuongHieu.getSelectedItem().equals("Tất cả")
						&& cboKhoangGia.getSelectedItem().equals("Tất cả")) {
					List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "",
							(String) cboThuongHieu.getSelectedItem(), 0, 1000000000);
					XoaDL1();
					listLK.forEach(lk -> {
						model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
								lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
					});
				} else if (cboLoaiLK.getSelectedItem().equals("Tất cả")
						&& cboThuongHieu.getSelectedItem().equals("Tất cả")
						&& !cboKhoangGia.getSelectedItem().equals("Tất cả")) {
					if (cboKhoangGia.getSelectedIndex() == 1) {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "", "", 0, 500000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					} else if (cboKhoangGia.getSelectedIndex() == 2) {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "", "", 500000, 1000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					} else if (cboKhoangGia.getSelectedIndex() == 3) {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "", "", 1000000,
								1000000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					}
				} else if (!cboLoaiLK.getSelectedItem().equals("Tất cả")
						&& cboThuongHieu.getSelectedItem().equals("Tất cả")
						&& cboKhoangGia.getSelectedItem().equals("Tất cả")) {
					List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
							(String) cboLoaiLK.getSelectedItem(), "", 0, 1000000000);
					XoaDL1();
					listLK.forEach(lk -> {
						model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
								lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
					});
				} else if (!cboLoaiLK.getSelectedItem().equals("Tất cả")
						&& !cboThuongHieu.getSelectedItem().equals("Tất cả")
						&& !cboKhoangGia.getSelectedItem().equals("Tất cả")) {
					if (cboKhoangGia.getSelectedIndex() == 1) {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
								(String) cboLoaiLK.getSelectedItem(), (String) cboThuongHieu.getSelectedItem(), 0,
								500000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					} else if (cboKhoangGia.getSelectedIndex() == 2) {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
								(String) cboLoaiLK.getSelectedItem(), (String) cboThuongHieu.getSelectedItem(), 500000,
								1000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					} else if (cboKhoangGia.getSelectedIndex() == 3) {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
								(String) cboLoaiLK.getSelectedItem(), (String) cboThuongHieu.getSelectedItem(), 1000000,
								1000000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					}
				} else if (!cboLoaiLK.getSelectedItem().equals("Tất cả")
						&& !cboThuongHieu.getSelectedItem().equals("Tất cả")
						&& cboKhoangGia.getSelectedItem().equals("Tất cả")) {
					List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
							(String) cboLoaiLK.getSelectedItem(), (String) cboThuongHieu.getSelectedItem(), 0,
							1000000000);
					XoaDL1();
					listLK.forEach(lk -> {
						model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
								lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
					});
				} else if (!cboLoaiLK.getSelectedItem().equals("Tất cả")
						&& cboThuongHieu.getSelectedItem().equals("Tất cả")
						&& !cboKhoangGia.getSelectedItem().equals("Tất cả")) {
					if (cboKhoangGia.getSelectedIndex() == 1) {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
								(String) cboLoaiLK.getSelectedItem(), "", 0, 500000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					} else if (cboKhoangGia.getSelectedIndex() == 2) {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
								(String) cboLoaiLK.getSelectedItem(), "", 500000, 1000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					} else if (cboKhoangGia.getSelectedIndex() == 3) {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
								(String) cboLoaiLK.getSelectedItem(), "", 1000000, 1000000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					}
				}

			}
		});
		txtTim.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTim.setColumns(10);
		txtTim.setBounds(115, 80, 362, 23);
		pLeft.add(txtTim);

		JLabel lblSLng = new JLabel("Số lượng :");
		lblSLng.setFont(new Font("Arial", Font.BOLD, 13));
		lblSLng.setBounds(342, 559, 75, 25);
		pLeft.add(lblSLng);

		JButton btnThemVaoGio = new JButton("Thêm");
		btnThemVaoGio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemVaoGio();
			}
		});
		btnThemVaoGio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThemVaoGio.setIcon(new ImageIcon(ManHinhChinh_Panel.class.getResource("/image/add_shopping_cart_30px.png")));
		btnThemVaoGio.setForeground(Color.WHITE);
		btnThemVaoGio.setFont(new Font("Arial", Font.BOLD, 15));
		btnThemVaoGio.setFocusPainted(false);
		btnThemVaoGio.setBorder(null);
		btnThemVaoGio.setBackground(Color.red);
		btnThemVaoGio.setBounds(377, 603, 127, 55);
		pLeft.add(btnThemVaoGio);

		JButton btnXemThongTin = new JButton("Thông Tin Linh Kiện");
		btnXemThongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table1.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "Phải chọn linh kiện cần xem !");
				} else {
					new ThongTinLinhKien_JFrame(new LinhKien(table1.getValueAt(row, 0).toString())).setVisible(true);
					;
				}
			}
		});
		btnXemThongTin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXemThongTin.setIcon(new ImageIcon(ManHinhChinh_Panel.class.getResource("/image/info_30px.png")));
		btnXemThongTin.setForeground(Color.WHITE);
		btnXemThongTin.setFont(new Font("Arial", Font.BOLD, 15));
		btnXemThongTin.setFocusPainted(false);
		btnXemThongTin.setBorder(null);
		btnXemThongTin.setBackground(Color.decode(cl_yellow));
		btnXemThongTin.setBounds(10, 603, 240, 55);
		pLeft.add(btnXemThongTin);

		txtSoLuong = new JTextField();
		txtSoLuong.setEditable(false);
		txtSoLuong.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoLuong.setBounds(437, 559, 30, 23);
		pLeft.add(txtSoLuong);
		txtSoLuong.setColumns(10);

		JButton btnTrangDau = new JButton("");
		btnTrangDau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				denTrangDau();
			}
		});
		btnTrangDau.setIcon(new ImageIcon(ManHinhChinh_Panel.class.getResource("/image/skip_to_start_20px.png")));
		btnTrangDau.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTrangDau.setBorder(null);
		btnTrangDau.setFocusPainted(false);
		btnTrangDau.setBackground(Color.decode(cl_green));
		btnTrangDau.setBounds(36, 559, 30, 25);
		pLeft.add(btnTrangDau);

		JButton btnTrangTruoc = new JButton("");
		btnTrangTruoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				denTrangTruoc();
			}
		});
		btnTrangTruoc.setIcon(new ImageIcon(ManHinhChinh_Panel.class.getResource("/image/rewind_20px.png")));
		btnTrangTruoc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTrangTruoc.setBorder(null);
		btnTrangTruoc.setFocusPainted(false);
		btnTrangTruoc.setBackground(Color.decode(cl_green));
		btnTrangTruoc.setBounds(73, 559, 30, 25);
		pLeft.add(btnTrangTruoc);

		txtTrang = new JTextField();
		txtTrang.setEditable(false);
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setBounds(115, 559, 30, 25);
		pLeft.add(txtTrang);
		txtTrang.setColumns(10);

		JButton btnTrangCuoi = new JButton("");
		btnTrangCuoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				denTrangCuoi();
			}
		});
		btnTrangCuoi.setIcon(new ImageIcon(ManHinhChinh_Panel.class.getResource("/image/end_20px.png")));
		btnTrangCuoi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTrangCuoi.setBorder(null);
		btnTrangCuoi.setFocusPainted(false);
		btnTrangCuoi.setBackground(Color.decode(cl_green));
		btnTrangCuoi.setBounds(192, 559, 30, 25);
		pLeft.add(btnTrangCuoi);

		JButton btnTrangSau = new JButton("");
		btnTrangSau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				denTrangSau();
			}
		});
		btnTrangSau.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTrangSau.setBorder(null);
		btnTrangSau.setFocusPainted(false);
		btnTrangSau.setBackground(Color.decode(cl_green));
		btnTrangSau.setIcon(new ImageIcon(ManHinhChinh_Panel.class.getResource("/image/fast_forward_20px.png")));
		btnTrangSau.setBounds(155, 559, 30, 25);
		pLeft.add(btnTrangSau);

		JPanel pRight = new JPanel();
		pRight.setLayout(null);
		pRight.setForeground(Color.WHITE);
		pRight.setBackground(Color.decode(cl_greyblue));
		;
		pRight.setBounds(515, 0, 500, 684);
		add(pRight);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.decode(cl_green));
		panel_1.setBounds(0, 10, 485, 55);
		pRight.add(panel_1);

		JLabel lblDanhSchLinh_1 = new JLabel("Đơn Hàng");
		lblDanhSchLinh_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchLinh_1.setForeground(Color.WHITE);
		lblDanhSchLinh_1.setFont(font_btn20);
		lblDanhSchLinh_1.setBounds(58, 10, 384, 35);
		panel_1.add(lblDanhSchLinh_1);

		JButton btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (thongTinDonHang()) {
					String maHoaDon = txtMaHoaDon.getText();
					String maKhachHang = txtMaKhachHang.getText();
					String maNhanVien = nhanVien.getMaNhanVien();
					String tenKhachHang = txtTenKhachHang.getText();
					String sDT = txtSDT.getText();
					String diaChi = txtDiaChi.getText();
					String email = txtEmail.getText();
					String noiNhanGiaoHang = txtNoiNhan.getText();
					int mucGiamGia = Integer.parseInt(txtMucGiamGia.getText());
					java.sql.Date ngayDatHang = XuLyNgay.chuyenStringThanhDate(txtNgayDatHang.getText());
					java.sql.Date ngayChuyenHang = XuLyNgay.chuyenStringThanhDate(txtNgayChuyenHang.getText());
					java.sql.Date ngayGiaoHang = XuLyNgay.chuyenStringThanhDate(txtNgayGiaoHang.getText());

					KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, diaChi, sDT, email);
					HoaDon hd = new HoaDon(maHoaDon, new KhachHang(maKhachHang), new NhanVien(maNhanVien), ngayDatHang,
							ngayChuyenHang, ngayGiaoHang, noiNhanGiaoHang);

					int dem = 0;
					if (table2.getRowCount() > 0) {
						if (hd_dao.timHoaDon(txtMaKhachHang.getText()) != null) {
							if (hd_dao.themHoaDon(hd)) {
								for (int i = 0; i < table2.getRowCount(); i++) {
									int soLuong = Integer.parseInt(table2.getValueAt(i, 2).toString());
									ChiTietHoaDon cthd = new ChiTietHoaDon(
											new LinhKien(table2.getValueAt(i, 0).toString()), new HoaDon(maHoaDon),
											soLuong, mucGiamGia);
									if (cthd_dao.themChiTietHoaDon(cthd) == true) {
										dem = 1;
									}
								}
							}
						} else {
							if (kh_dao.themKhachHang(kh)) {
								if (hd_dao.themHoaDon(hd)) {
									for (int i = 0; i < table2.getRowCount(); i++) {
										int soLuong = Integer.parseInt(table2.getValueAt(i, 2).toString());
										ChiTietHoaDon cthd = new ChiTietHoaDon(
												new LinhKien(table2.getValueAt(i, 0).toString()), new HoaDon(maHoaDon),
												soLuong, mucGiamGia);
										if (cthd_dao.themChiTietHoaDon(cthd) == true) {
											dem = 1;
										}
									}
								}
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Phải thêm linh kiện trước khi thanh toán !");
					}
					if (dem == 1) {
						new HoaDonThanhToan_JFrame(new HoaDon(txtMaHoaDon.getText())).setVisible(true);
						capNhatSoLuong();
						trangHienTai();
						XoaDL2();
						xoaTrang();
						txtTongTien.setText("");

					}

				}

			}
		});
		btnThanhToan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThanhToan.setIcon(new ImageIcon(ManHinhChinh_Panel.class.getResource("/image/money_bag_30px.png")));
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFont(new Font("Arial", Font.BOLD, 13));
		btnThanhToan.setFocusTraversalKeysEnabled(false);
		btnThanhToan.setFocusPainted(false);
		btnThanhToan.setBorder(null);
		btnThanhToan.setBackground(Color.decode(cl_green));
		btnThanhToan.setBounds(367, 619, 118, 46);
		pRight.add(btnThanhToan);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaKhoiGio();
			}
		});
		btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoa.setIcon(new ImageIcon(ManHinhChinh_Panel.class.getResource("/image/delete_bin_30px.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setFocusTraversalKeysEnabled(false);
		btnXoa.setFocusPainted(false);
		btnXoa.setBorder(null);
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(241, 563, 116, 46);
		pRight.add(btnXoa);

		JButton btnSua = new JButton("Cập Nhật");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table2.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "Phải chọn dòng cần cập nhật số lượng !");
				} else {
					int t = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thay đổi số lượng !",
							"Cập nhật số lượng", JOptionPane.YES_NO_OPTION);
					if (t == JOptionPane.YES_OPTION) {

						if (Integer.parseInt(txtSoLuong.getText()) > Integer
								.parseInt(table2.getValueAt(row, 2).toString())) {
							for (int i = 0; i < table2.getRowCount(); i++) {
								for (int j = 0; j < table1.getRowCount(); j++) {
									if (table2.getValueAt(i, 0).toString().equals(table1.getValueAt(j, 0).toString())) {
										table1.setValueAt(
												Integer.parseInt(table1.getValueAt(j, 4).toString())
														- (Integer.parseInt(txtSoLuong.getText())
																- Integer.parseInt(table2.getValueAt(i, 2).toString())),
												j, 4);
									}
								}
							}
						}
						if (Integer.parseInt(txtSoLuong.getText()) < Integer
								.parseInt(table2.getValueAt(row, 2).toString())) {
							for (int i = 0; i < table2.getRowCount(); i++) {
								for (int j = 0; j < table1.getRowCount(); j++) {
									if (table2.getValueAt(i, 0).toString().equals(table1.getValueAt(j, 0).toString())) {
										table1.setValueAt(Integer.parseInt(table1.getValueAt(j, 4).toString())
												+ (Integer.parseInt(table2.getValueAt(i, 2).toString())
														- Integer.parseInt(txtSoLuong.getText())),
												j, 4);
									}
								}
							}
						}

						table2.setValueAt(txtSoLuong.getText(), row, 2);

					}

				}
			}
		});
		btnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSua.setIcon(new ImageIcon(ManHinhChinh_Panel.class.getResource("/image/settings_30px.png")));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSua.setFocusTraversalKeysEnabled(false);
		btnSua.setFocusPainted(false);
		btnSua.setBorder(null);
		btnSua.setBackground(Color.decode(cl_yellow));
		btnSua.setBounds(367, 563, 118, 46);
		pRight.add(btnSua);

		JButton btnTaoMoi = new JButton("Tạo mới");
		btnTaoMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
			}
		});
		btnTaoMoi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTaoMoi.setIcon(new ImageIcon(ManHinhChinh_Panel.class.getResource("/image/create_30px.png")));
		btnTaoMoi.setForeground(Color.WHITE);
		btnTaoMoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTaoMoi.setFocusTraversalKeysEnabled(false);
		btnTaoMoi.setFocusPainted(false);
		btnTaoMoi.setBorder(null);
		btnTaoMoi.setBackground(new Color(65, 105, 225));
		btnTaoMoi.setBounds(241, 619, 116, 46);
		pRight.add(btnTaoMoi);

		JLabel lblNewLabel = new JLabel("Mã hóa đơn :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 75, 81, 25);
		pRight.add(lblNewLabel);

		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMaHoaDon.setColumns(10);
		txtMaHoaDon.setBounds(120, 75, 110, 23);
		pRight.add(txtMaHoaDon);
		txtMaHoaDon.setEditable(false);

		JLabel lblMKhchHng = new JLabel("Mã khách hàng :");
		lblMKhchHng.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMKhchHng.setBounds(10, 105, 110, 25);
		pRight.add(lblMKhchHng);

		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setBounds(120, 105, 108, 23);
		pRight.add(txtMaKhachHang);

		JLabel lblTnKhchHng = new JLabel("Tên khách hàng :");
		lblTnKhchHng.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTnKhchHng.setBounds(10, 135, 110, 25);
		pRight.add(lblTnKhchHng);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(120, 135, 335, 23);
		pRight.add(txtTenKhachHang);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Arial", Font.PLAIN, 13));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(120, 195, 362, 23);
		pRight.add(txtDiaChi);

		JLabel lblaCh = new JLabel("Địa chỉ :");
		lblaCh.setFont(new Font("Arial", Font.PLAIN, 13));
		lblaCh.setBounds(10, 195, 58, 25);
		pRight.add(lblaCh);

		JLabel lblSDinThoi = new JLabel("Số diện thoại :");
		lblSDinThoi.setFont(new Font("Arial", Font.PLAIN, 13));
		lblSDinThoi.setBounds(10, 165, 91, 25);
		pRight.add(lblSDinThoi);

		txtSDT = new JTextField();
		txtSDT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					KhachHang kh = kh_dao.timKhachHangTheoSDT(txtSDT.getText());
					if (kh != null) {
						txtMaKhachHang.setText(kh.getMaKhachHang());
						txtTenKhachHang.setText(kh.getTenKhachHang());
						txtDiaChi.setText(kh.getDiaChi());
						txtEmail.setText(kh.getEmail());
					} else {
						JOptionPane.showMessageDialog(null, "Chưa có khách hàng này !");
					}

				}
			}
		});
		txtSDT.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSDT.setColumns(10);
		txtSDT.setBounds(120, 165, 110, 23);
		pRight.add(txtSDT);

		JLabel lblNgyLpHa = new JLabel("Ngày lập hóa đơn :");
		lblNgyLpHa.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNgyLpHa.setBounds(247, 75, 117, 25);
		pRight.add(lblNgyLpHa);

		txtNgayDatHang = new JTextField();
		txtNgayDatHang.setEditable(false);
		txtNgayDatHang.setColumns(10);
		txtNgayDatHang.setBounds(374, 75, 81, 23);
		pRight.add(txtNgayDatHang);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder("Thanh Toán"));
		panel_3.setBounds(10, 527, 221, 141);
		pRight.add(panel_3);

		JLabel lblNewLabel_2 = new JLabel("Tổng tiền :");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 23, 71, 23);
		panel_3.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Khách trả :");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 58, 71, 23);
		panel_3.add(lblNewLabel_2_1);

		txtTongTien = new JTextField();
		txtTongTien.setEditable(false);
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(86, 23, 96, 23);
		panel_3.add(txtTongTien);

		txtKhachTra = new JTextField();
		txtKhachTra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					int n = table2.getRowCount();
					String khachTra1 = txtKhachTra.getText();
					if (khachTra1.length() == 0) {
						JOptionPane.showMessageDialog(null, "Bạn phải nhập tiền khách trả");
						txtKhachTra.requestFocus();
						txtKhachTra.selectAll();
					} else {
						if (!khachTra1.matches("[0-9]+")) {
							JOptionPane.showMessageDialog(null, "Tiền phải nhập số !");
							txtKhachTra.requestFocus();
							txtKhachTra.selectAll();
						} 
					}

				}

			}
		});
		txtKhachTra.setColumns(10);
		txtKhachTra.setBounds(86, 58, 96, 23);
		panel_3.add(txtKhachTra);


		JLabel lblNewLabel_2_5 = new JLabel("VNĐ");
		lblNewLabel_2_5.setForeground(Color.RED);
		lblNewLabel_2_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_5.setBounds(185, 23, 36, 23);
		panel_3.add(lblNewLabel_2_5);

		JLabel lblNewLabel_2_5_1 = new JLabel("VNĐ");
		lblNewLabel_2_5_1.setForeground(Color.RED);
		lblNewLabel_2_5_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_5_1.setBounds(185, 58, 36, 23);
		panel_3.add(lblNewLabel_2_5_1);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		txtEmail.setBounds(120, 225, 362, 23);
		pRight.add(txtEmail);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 13));
		lblEmail.setBounds(10, 225, 58, 25);
		pRight.add(lblEmail);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "Gi\u1ECF H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 290, 475, 227);
		pRight.add(panel_2);
		panel_2.setLayout(null);

		String row2[] = { "Mã linh kiện", "Tên linh kiện", "Số lượng", "Giá bán", "Bảo Hành", "Thành Tiền" };

		model2 = new DefaultTableModel(row2, 0);
		table2 = new JTable(model2) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) {
				return false;
			};
		};

		JTableHeader head = table2.getTableHeader();
		head.setBackground(Color.decode(cl_green));

		table2.getColumnModel().getColumn(0).setCellRenderer(center);
		table2.getColumnModel().getColumn(2).setCellRenderer(center);
		table2.getColumnModel().getColumn(3).setCellRenderer(center);
		table2.getColumnModel().getColumn(4).setCellRenderer(center);
		table2.getColumnModel().getColumn(5).setCellRenderer(center);
		JScrollPane scrollPane2 = new JScrollPane(table2);
		scrollPane2.setBounds(10, 20, 453, 200);
		panel_2.add(scrollPane2);
		table2.getColumnModel().getColumn(2).setPreferredWidth(50);
		table2.getColumnModel().getColumn(5).setPreferredWidth(90);
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setBackground(SystemColor.controlHighlight);
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setIcon(new ImageIcon(ManHinhChinh_Panel.class.getResource("/image/calendar_25px.png")));
		formatter = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = new java.util.Date();
		dateFormat = formatter.format(date);
		txtNgayDatHang.setText(dateFormat);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFrame f = new JFrame();
				txtNgayDatHang.setText(new DatePicker(f).setPickedDate());
			}
		});

		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setBounds(458, 75, 25, 23);
		pRight.add(btnNewButton_3);

		txtNgayGiaoHang = new JTextField();
		txtNgayGiaoHang.setEditable(false);
		txtNgayGiaoHang.setText(dateFormat);
		txtNgayGiaoHang.setColumns(10);
		txtNgayGiaoHang.setBounds(374, 165, 81, 23);
		pRight.add(txtNgayGiaoHang);

		JButton btnNewButton_3_1 = new JButton("");
		btnNewButton_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3_1.setBackground(SystemColor.controlHighlight);
		btnNewButton_3_1.setBorder(null);
		btnNewButton_3_1.setIcon(new ImageIcon(ManHinhChinh_Panel.class.getResource("/image/calendar_25px.png")));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFrame f = new JFrame();
				txtNgayGiaoHang.setText(new DatePicker(f).setPickedDate());
			}
		});
		btnNewButton_3_1.setFocusPainted(false);
		btnNewButton_3_1.setBounds(458, 165, 25, 23);
		pRight.add(btnNewButton_3_1);

		JLabel lblNgyChuyen = new JLabel("Ngày giao hàng :");
		lblNgyChuyen.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNgyChuyen.setBounds(247, 165, 118, 25);
		pRight.add(lblNgyChuyen);

		JLabel lblNgyChuyen_1 = new JLabel("Ngày chuyển hàng :");
		lblNgyChuyen_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNgyChuyen_1.setBounds(247, 105, 127, 25);
		pRight.add(lblNgyChuyen_1);

		txtNgayChuyenHang = new JTextField();
		txtNgayChuyenHang.setEditable(false);
		txtNgayChuyenHang.setText(dateFormat);
		txtNgayChuyenHang.setColumns(10);
		txtNgayChuyenHang.setBounds(374, 105, 81, 23);
		pRight.add(txtNgayChuyenHang);

		JButton btnNewButton_3_1_1 = new JButton("");
		btnNewButton_3_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFrame f = new JFrame();
				txtNgayChuyenHang.setText(new DatePicker(f).setPickedDate());
			}
		});
		btnNewButton_3_1_1.setBackground(SystemColor.controlHighlight);
		btnNewButton_3_1_1.setBorder(null);
		btnNewButton_3_1_1.setIcon(new ImageIcon(ManHinhChinh_Panel.class.getResource("/image/calendar_25px.png")));
		btnNewButton_3_1_1.setFocusPainted(false);
		btnNewButton_3_1_1.setBounds(458, 105, 25, 23);
		pRight.add(btnNewButton_3_1_1);

		JLabel lblaCh_1 = new JLabel("Nơi nhận hàng :");
		lblaCh_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblaCh_1.setBounds(10, 255, 118, 25);
		pRight.add(lblaCh_1);

		txtNoiNhan = new JTextField();
		txtNoiNhan.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNoiNhan.setColumns(10);
		txtNoiNhan.setBounds(120, 255, 362, 23);
		pRight.add(txtNoiNhan);

		JTableHeader a = table1.getTableHeader();
		JTableHeader b = table2.getTableHeader();
		a.setBackground(Color.decode(cl_green));
		b.setBackground(Color.decode(cl_green));
		a.setForeground(Color.white);
		b.setForeground(Color.white);
		a.setFont(new Font("Tahoma", Font.BOLD, 10));
		b.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtTrang.setText("1");

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				giamSL();
			}
		});
		btnNewButton.setIcon(new ImageIcon(ManHinhChinh_Panel.class.getResource("/image/minus_18px.png")));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.decode(cl_green));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(413, 559, 23, 23);
		pLeft.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tangSL();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ManHinhChinh_Panel.class.getResource("/image/plus_18px.png")));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.decode(cl_green));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBounds(468, 559, 23, 23);
		pLeft.add(btnNewButton_1);

		txtSoLuong.setText("1");

		JLabel lblNewLabel_1_1 = new JLabel("Loại linh kiện :");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 112, 111, 25);
		pLeft.add(lblNewLabel_1_1);

		cboLoaiLK = new JComboBox<String>();
		cboLoaiLK.setBackground(Color.WHITE);

		cboLoaiLK.addItem("Tất cả");
		cboLoaiLK.setFont(new Font("Arial", Font.PLAIN, 13));
		cboLoaiLK.setBounds(115, 115, 127, 23);
		pLeft.add(cboLoaiLK);
		List<LinhKien> l = lk_dao.getLoaiLinhKien();
		l.forEach(e -> {
			cboLoaiLK.addItem(e.getMaLinhKien());
		});

		JLabel lblNewLabel_1_2 = new JLabel("Thương hệu :");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(260, 115, 111, 25);
		pLeft.add(lblNewLabel_1_2);

		cboThuongHieu = new JComboBox<String>();
		cboThuongHieu.setBackground(Color.WHITE);
		cboThuongHieu.setFont(new Font("Arial", Font.PLAIN, 13));
		cboThuongHieu.addItem("Tất cả");
		
		List<NhaCungCap> listNCC = ncc_dao.getNhaCungCap();
		List<LinhKien> listLK = lk_dao.getLinhKien();

		for (int i = 0; i < listNCC.size(); i++) {
			int dem = 0;
			for (int j = 0; j < listLK.size(); j++) {
				if (listNCC.get(i).getTenNCC().equals(listLK.get(j).getNhaCC().getMaNCC())) {
					dem = 1;
				}
			}
			if (dem == 1) {
				cboThuongHieu.addItem(listNCC.get(i).getTenNCC());
			}
		}
		cboThuongHieu.setBounds(350, 115, 127, 23);
		pLeft.add(cboThuongHieu);

		JLabel lblNewLabel_1_1_1 = new JLabel("Khoảng giá :");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(10, 147, 111, 25);
		pLeft.add(lblNewLabel_1_1_1);

		cboKhoangGia = new JComboBox<String>();
		cboKhoangGia.setBackground(Color.WHITE);
		cboKhoangGia.addItem("Tất cả");
		cboKhoangGia.addItem("0 - 500.000 VNĐ");
		cboKhoangGia.addItem("500.000 - 1.000.000 VNĐ");
		cboKhoangGia.addItem(" > 1.000.000 VNĐ");
		cboKhoangGia.setFont(new Font("Arial", Font.PLAIN, 13));
		cboKhoangGia.setBounds(115, 150, 127, 23);
		pLeft.add(cboKhoangGia);
		RandomMa rd = new RandomMa();
		txtMaHoaDon.setText(rd.taoMaHoaDon());
		txtMaKhachHang.setText(rd.taoMaKhachHang());
		txtMaKhachHang.setEditable(false);

		txtMucGiamGia = new JTextField();
		txtMucGiamGia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtMucGiamGia.equals("")) {

				} else {
					DecimalFormat df = new DecimalFormat("#,##0.00");
					txtTongTien.setText(String.valueOf(df.format(tinhTongTien())));
				}

			}
		});
		txtMucGiamGia.setHorizontalAlignment(SwingConstants.CENTER);
		txtMucGiamGia.setText("0");
		txtMucGiamGia.setColumns(10);
		txtMucGiamGia.setBounds(425, 527, 34, 23);
		pRight.add(txtMucGiamGia);

		JLabel lblNewLabel_2_3 = new JLabel("Mức giảm giá :");
		lblNewLabel_2_3.setForeground(Color.RED);
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_3.setBounds(328, 527, 106, 23);
		pRight.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("%");
		lblNewLabel_2_4.setForeground(Color.RED);
		lblNewLabel_2_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_4.setBounds(461, 527, 39, 23);
		pRight.add(lblNewLabel_2_4);

		// dang ki sk
		cboLoaiLK.addActionListener(this);
		cboThuongHieu.addActionListener(this);
		cboKhoangGia.addActionListener(this);
		DocDL1(1, 25);
	}

	public void DocDL1(int fn, int ln) {
		List<LinhKien> listLK = lk_dao.phanTrangLinhKien(fn, ln);
		listLK.forEach(e -> {
			model1.addRow(new Object[] { e.getMaLinhKien(), e.getTenLinhKien(), e.getLoaiLinhKien(),
					e.getNhaCC().getMaNCC(), e.getSoLuongTon(), e.getGiaBan() });
		});
	}

	public void XoaDL1() {
		model1.getDataVector().removeAllElements();
		model1.fireTableDataChanged();
	}

	public void XoaDL2() {
		model2.getDataVector().removeAllElements();
		model2.fireTableDataChanged();
	}

	public void denTrangSau() {
		int soLuong = lk_dao.soLuongLK();
		int soTrang = Integer.parseInt(txtTrang.getText());
		int trangLonNhat;
		if (soLuong % 25 == 0) {
			trangLonNhat = soLuong / 25;
		} else {
			trangLonNhat = soLuong / 25 + 1;
		}
		if (soTrang < trangLonNhat) {
			txtTrang.setText(String.valueOf(soTrang + 1));
			int fn = 25 * soTrang + 1;
			int ln = fn + 24;
			XoaDL1();
			DocDL1(fn, ln);
			kiemTraSL();
			table1.clearSelection();

		}

	}

	public void denTrangTruoc() {
		int trang = Integer.parseInt(txtTrang.getText());
		if (trang > 1) {
			txtTrang.setText(String.valueOf(trang - 1));
			int fn = 25 * (trang - 2) + 1;
			int ln = fn + 25;
			XoaDL1();
			DocDL1(fn, ln);
			kiemTraSL();
			table1.clearSelection();
		}

	}

	public void denTrangDau() {
		txtTrang.setText("1");
		XoaDL1();
		DocDL1(1, 25);
		kiemTraSL();
		table1.clearSelection();
	}

	public void denTrangCuoi() {
		int soLuong = lk_dao.soLuongLK();
		int trangCuoi;
		if (soLuong % 25 == 0) {
			trangCuoi = soLuong / 25;
		} else {
			trangCuoi = soLuong / 25 + 1;
		}
		int fn = (trangCuoi - 1) * 25 + 1;
		int ln = fn + 24;
		XoaDL1();
		DocDL1(fn, ln);
		txtTrang.setText(String.valueOf(trangCuoi));
		kiemTraSL();
		table1.clearSelection();

	}

	public void trangHienTai() {
		int trang = Integer.parseInt(txtTrang.getText());
		int ln = trang * 25;
		int fn = ln - 24;
		XoaDL1();
		DocDL1(fn, ln);
	}

	public void ThemVaoGio() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		int row = table1.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Phải chọn linh kiện cần thêm !");
		} else {
			int soLuong1 = Integer.parseInt(txtSoLuong.getText());
			int dem = -1;

			int soLuong3 = Integer.parseInt(table1.getValueAt(row, 4).toString());
			if (soLuong3 > 0) {
				if (soLuong1 <= soLuong3) {
					table1.setValueAt(soLuong3 - soLuong1, row, 4);
					for (int i = 0; i < model2.getRowCount(); i++) {
						if (table2.getValueAt(i, 0).toString().equals(table1.getValueAt(row, 0).toString())) {
							dem = i;
						}
					}
					if (dem == -1) {

						listLK = lk_dao.getLinhKien();
						listLK.forEach(e -> {
							if (e.getMaLinhKien().equals(table1.getValueAt(row, 0).toString())) {
								model2.addRow(new Object[] { e.getMaLinhKien(), e.getTenLinhKien(),
										txtSoLuong.getText(), e.getGiaBan(), e.getBaoHanh(),
										df.format(Integer.parseInt(txtSoLuong.getText()) * e.getGiaBan()) });
								txtSoLuong.setText("1");
							}
						});
					} else {
						int soLuong2 = Integer.parseInt(table2.getValueAt(dem, 2).toString());
						table2.setValueAt(soLuong2 + soLuong1, dem, 2);
						table2.setValueAt(df.format(
								(soLuong1 + soLuong2) * Double.parseDouble(table1.getValueAt(row, 5).toString())), dem,
								5);
						txtSoLuong.setText("1");

					}
				} else {
					JOptionPane.showMessageDialog(null, "Không đủ số lượng bán !!");

				}
			} else {
				JOptionPane.showMessageDialog(null, "Hết hàng rồi !!");
			}
			txtTongTien.setText(String.valueOf(df.format(tinhTongTien())));
		}

	}

	public void XoaKhoiGio() {
		int row = table2.getSelectedRow();

		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Phải chọn dòng cần xóa khỏi giỏ hàng ! ");
		} else {
			int soluong1 = Integer.parseInt(table2.getValueAt(row, 2).toString());
			for (int i = 0; i < model1.getRowCount(); i++) {
				if (table2.getValueAt(row, 0).toString().equals(table1.getValueAt(i, 0).toString())) {
					int soluong2 = Integer.parseInt(table1.getValueAt(i, 4).toString());
					table1.setValueAt(soluong1 + soluong2, i, 4);
				}
			}
			model2.removeRow(row);
			DecimalFormat df = new DecimalFormat("#,##0.00");
			txtTongTien.setText(String.valueOf(df.format(tinhTongTien())));

		}

	}

	public void tangSL() {
		int sl = Integer.parseInt(txtSoLuong.getText()) + 1;
		txtSoLuong.setText(String.valueOf(sl));
	}

	public void giamSL() {
		int sl = Integer.parseInt(txtSoLuong.getText());
		if (sl != 1) {
			txtSoLuong.setText(String.valueOf(sl - 1));
		}
	}

	public double tinhTongTien() {
		if (!txtMucGiamGia.getText().equals("") && txtMucGiamGia.getText().matches("[0-9]+")) {
			int mucGiamGia = Integer.parseInt(txtMucGiamGia.getText());
			double tong = 0;
			List<LinhKien> listLK = lk_dao.getLinhKien();
			for (int i = 0; i < model2.getRowCount(); i++) {
				for (int j = 0; j < listLK.size(); j++) {
					if (table2.getValueAt(i, 0).toString().equals(listLK.get(j).getMaLinhKien())) {
						tong += listLK.get(j).getGiaBan() * Integer.parseInt(table2.getValueAt(i, 2).toString());
					}
				}

			}
			tong = tong - ((tong * mucGiamGia) / 100);
			if (tong < 0) {
				return 0;
			} else {
				return tong;
			}
		} else {
			int mucGiamGia = 0;
			double tong = 0;
			List<LinhKien> listLK = lk_dao.getLinhKien();
			for (int i = 0; i < model2.getRowCount(); i++) {
				for (int j = 0; j < listLK.size(); j++) {
					if (table2.getValueAt(i, 0).toString().equals(listLK.get(j).getMaLinhKien())) {
						tong += listLK.get(j).getGiaBan() * Integer.parseInt(table2.getValueAt(i, 2).toString());
					}
				}

			}
			tong = tong - ((tong * mucGiamGia) / 100);
			if (tong < 0) {
				return 0;
			} else {
				return tong;
			}
		}

	}

	public void kiemTraSL() {
		for (int i = 0; i < model2.getRowCount(); i++) {
			for (int j = 0; j < model1.getRowCount(); j++) {
				if (table2.getValueAt(i, 0).toString().equals(table1.getValueAt(j, 0).toString())) {
					int sl1 = Integer.parseInt(table1.getValueAt(j, 4).toString());
					int sl2 = Integer.parseInt(table2.getValueAt(i, 2).toString());
					table1.setValueAt(sl1 - sl2, j, 4);
				}
			}
		}
	}

	public void capNhatSoLuong() {
		List<LinhKien> listLK = lk_dao.getLinhKien();
		for (int i = 0; i < table2.getRowCount(); i++) {
			for (int j = 0; j < listLK.size(); j++) {
				if (table2.getValueAt(i, 0).toString().equals(listLK.get(j).getMaLinhKien())) {
					int soLuongTon = listLK.get(j).getSoLuongTon();
					int soLuong = Integer.parseInt(table2.getValueAt(i, 2).toString());
					lk_dao.updateSoLuong(soLuongTon - soLuong, listLK.get(j).getMaLinhKien());
				}
			}
		}

	}

	public void xoaTrang() {

		RandomMa rd = new RandomMa();
		txtMaHoaDon.setText(rd.taoMaHoaDon());
		txtMaKhachHang.setText(rd.taoMaKhachHang());
		txtTenKhachHang.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtEmail.setText("");
		txtNoiNhan.setText("");
		txtNgayDatHang.setText(dateFormat);
		txtNgayChuyenHang.setText(dateFormat);
		txtNgayGiaoHang.setText(dateFormat);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(cboLoaiLK)) {
			if (cboThuongHieu.getSelectedItem() == "Tất cả") {
				if (cboKhoangGia.getSelectedItem() == "Tất cả") {
					if (cboLoaiLK.getSelectedItem() == "Tất cả") {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "", "", 0, 1000000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					} else {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
								(String) cboLoaiLK.getSelectedItem(), "", 0, 1000000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});

					}
				} else {
					if (cboKhoangGia.getSelectedIndex() == 1) {
						if (cboLoaiLK.getSelectedItem() == "Tất cả") {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "", "", 0, 500000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), "", 0, 500000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						}
					} else if (cboKhoangGia.getSelectedIndex() == 2) {
						if (cboLoaiLK.getSelectedItem() == "Tất cả") {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "", "", 500000,
									1000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), "", 500000, 1000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						}
					} else if (cboKhoangGia.getSelectedIndex() == 3) {
						if (cboLoaiLK.getSelectedItem() == "Tất cả") {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "", "", 1000000,
									1000000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), "", 1000000, 1000000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						}
					}
				}
			} else {
				if (cboKhoangGia.getSelectedItem() == "Tất cả") {
					if (cboLoaiLK.getSelectedItem() == "Tất cả") {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "",
								(String) cboThuongHieu.getSelectedItem(), 0, 1000000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					} else {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
								(String) cboLoaiLK.getSelectedItem(), (String) cboThuongHieu.getSelectedItem(), 0,
								1000000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});

					}
				} else {
					if (cboKhoangGia.getSelectedIndex() == 1) {
						if (cboLoaiLK.getSelectedItem() == "Tất cả") {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "",
									(String) cboThuongHieu.getSelectedItem(), 0, 500000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), (String) cboThuongHieu.getSelectedItem(), 0,
									500000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						}
					} else if (cboKhoangGia.getSelectedIndex() == 2) {
						if (cboLoaiLK.getSelectedItem() == "Tất cả") {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "",
									(String) cboThuongHieu.getSelectedItem(), 500000, 1000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), (String) cboThuongHieu.getSelectedItem(),
									500000, 1000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						}
					} else if (cboKhoangGia.getSelectedIndex() == 3) {
						if (cboLoaiLK.getSelectedItem() == "Tất cả") {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "",
									(String) cboThuongHieu.getSelectedItem(), 1000000, 1000000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), (String) cboThuongHieu.getSelectedItem(),
									1000000, 1000000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						}
					}
				}

			}

		}
		if (o.equals(cboThuongHieu)) {

			if (cboLoaiLK.getSelectedItem() == "Tất cả") {
				if (cboKhoangGia.getSelectedItem() == "Tất cả") {
					if (cboThuongHieu.getSelectedItem() == "Tất cả") {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "", "", 0, 1000000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					} else {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "",
								(String) cboThuongHieu.getSelectedItem(), 0, 1000000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});

					}
				} else {
					if (cboKhoangGia.getSelectedIndex() == 1) {
						if (cboThuongHieu.getSelectedItem() == "Tất cả") {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "", "", 0, 500000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "",
									(String) cboThuongHieu.getSelectedItem(), 0, 500000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						}
					} else if (cboKhoangGia.getSelectedIndex() == 2) {
						if (cboThuongHieu.getSelectedItem() == "Tất cả") {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "", "", 500000,
									1000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "",
									(String) cboThuongHieu.getSelectedItem(), 500000, 1000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						}
					} else if (cboKhoangGia.getSelectedIndex() == 3) {
						if (cboThuongHieu.getSelectedItem() == "Tất cả") {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "", "", 1000000,
									1000000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "",
									(String) cboThuongHieu.getSelectedItem(), 1000000, 1000000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						}
					}
				}
			} else {
				if (cboKhoangGia.getSelectedItem() == "Tất cả") {
					if (cboThuongHieu.getSelectedItem() == "Tất cả") {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
								(String) cboLoaiLK.getSelectedItem(), "", 0, 1000000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					} else {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
								(String) cboLoaiLK.getSelectedItem(), (String) cboThuongHieu.getSelectedItem(), 0,
								1000000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});

					}
				} else {
					if (cboKhoangGia.getSelectedIndex() == 1) {
						if (cboThuongHieu.getSelectedItem() == "Tất cả") {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), "", 0, 500000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), (String) cboThuongHieu.getSelectedItem(), 0,
									500000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						}
					} else if (cboKhoangGia.getSelectedIndex() == 2) {
						if (cboThuongHieu.getSelectedItem() == "Tất cả") {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), "", 500000, 1000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), (String) cboThuongHieu.getSelectedItem(),
									500000, 1000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						}
					} else if (cboKhoangGia.getSelectedIndex() == 3) {
						if (cboThuongHieu.getSelectedItem() == "Tất cả") {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), "", 1000000, 1000000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), (String) cboThuongHieu.getSelectedItem(),
									1000000, 1000000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						}
					}
				}

			}

		}
		if (o.equals(cboKhoangGia)) {
			if (cboThuongHieu.getSelectedItem() == "Tất cả") {
				if (cboLoaiLK.getSelectedItem() == "Tất cả") {
					if (cboKhoangGia.getSelectedItem() == "Tất cả") {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "", "", 0, 1000000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					} else {
						if (cboKhoangGia.getSelectedIndex() == 1) {

							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "", "", 0, 500000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else if (cboKhoangGia.getSelectedIndex() == 2) {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "", "", 500000,
									1000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else if (cboKhoangGia.getSelectedIndex() == 3) {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "", "", 1000000,
									1000000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						}

					}
				} else {
					if (cboKhoangGia.getSelectedItem() == "Tất cả") {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
								(String) cboLoaiLK.getSelectedItem(), "", 0, 1000000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					} else {
						if (cboKhoangGia.getSelectedIndex() == 1) {

							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), "", 0, 500000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else if (cboKhoangGia.getSelectedIndex() == 2) {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), "", 500000, 1000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else if (cboKhoangGia.getSelectedIndex() == 3) {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), "", 1000000, 1000000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						}

					}
				}

			} else {
				if (cboLoaiLK.getSelectedItem() == "Tất cả") {
					if (cboKhoangGia.getSelectedItem() == "Tất cả") {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "",
								(String) cboThuongHieu.getSelectedItem(), 0, 1000000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					} else {
						if (cboKhoangGia.getSelectedIndex() == 1) {

							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "",
									(String) cboThuongHieu.getSelectedItem(), 0, 500000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else if (cboKhoangGia.getSelectedIndex() == 2) {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "",
									(String) cboThuongHieu.getSelectedItem(), 500000, 1000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else if (cboKhoangGia.getSelectedIndex() == 3) {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(), "",
									(String) cboThuongHieu.getSelectedItem(), 1000000, 1000000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						}

					}
				} else {
					if (cboKhoangGia.getSelectedItem() == "Tất cả") {
						List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
								(String) cboLoaiLK.getSelectedItem(), (String) cboThuongHieu.getSelectedItem(), 0,
								1000000000);
						XoaDL1();
						listLK.forEach(lk -> {
							model1.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
									lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
						});
					} else {
						if (cboKhoangGia.getSelectedIndex() == 1) {

							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), (String) cboThuongHieu.getSelectedItem(), 0,
									500000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else if (cboKhoangGia.getSelectedIndex() == 2) {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), (String) cboThuongHieu.getSelectedItem(),
									500000, 1000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						} else if (cboKhoangGia.getSelectedIndex() == 3) {
							List<LinhKien> listLK = lk_dao.timLinhKienTheoTen(txtTim.getText(),
									(String) cboLoaiLK.getSelectedItem(), (String) cboThuongHieu.getSelectedItem(),
									1000000, 1000000000);
							XoaDL1();
							listLK.forEach(lk -> {
								model1.addRow(
										new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getLoaiLinhKien(),
												lk.getNhaCC().getMaNCC(), lk.getSoLuongTon(), lk.getGiaBan() });
							});
						}

					}
				}

			}
		}
	}

	public boolean thongTinDonHang() {
		LocalDate date = LocalDate.now();
		String tenKhachHang = txtTenKhachHang.getText();
		String sDT = txtSDT.getText();
		String diaChi = txtDiaChi.getText();
		String email = txtEmail.getText();
		String noiNhanHang = txtNoiNhan.getText();
		String ngayLap = txtNgayDatHang.getText();
		String ngayChuyen = txtNgayChuyenHang.getText();
		String ngayGiao = txtNgayGiaoHang.getText();
		if (tenKhachHang.length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên không được để trống !");
			txtTenKhachHang.requestFocus();
			txtTenKhachHang.selectAll();
			return false;
		}

		else {
			if (!tenKhachHang.matches("[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\r\n"
					+ "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\r\n"
					+ "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]+")) {
				JOptionPane.showMessageDialog(null, "Tên không hợp lệ !");
				txtTenKhachHang.requestFocus();
				txtTenKhachHang.selectAll();
				return false;
			}
		}
		if (sDT.length() == 0) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống !");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		} else {
			if (!sDT.matches("[0-9]{10}")) {
				JOptionPane.showMessageDialog(null, "Số điện thoại phải là chữ số và gồm 10 số !");
				txtSDT.requestFocus();
				txtSDT.selectAll();
				return false;
			}
		}
		if (diaChi.length() == 0) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống !");
			txtDiaChi.requestFocus();
			txtDiaChi.selectAll();
			return false;
		}
		if (email.length() != 0) {
			if (!email.matches("[A-Za-z0-9.]+@[A-Za-z]+.[A-Za-z]+")) {
				JOptionPane.showMessageDialog(null, "Email không hợp lệ !");
				txtEmail.requestFocus();
				txtEmail.selectAll();
				return false;
			}
		}
		if (noiNhanHang.length() == 0) {
			JOptionPane.showMessageDialog(null, "Nơi nhận hàng không được để trống !");
			txtNoiNhan.requestFocus();
			txtNoiNhan.selectAll();
			return false;
		}
		try {
			String n1[] = ngayLap.split("-");
			if (date.getYear() != Integer.parseInt(n1[2]) || date.getMonthValue() != Integer.parseInt(n1[1])
					|| date.getDayOfMonth() != Integer.parseInt(n1[0])) {
				JOptionPane.showMessageDialog(null, "Ngày lập hóa đơn phải bằng ngày hiện tại !");
				txtNgayDatHang.setText(dateFormat);
				return false;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ngày lập hóa đơn không được để trống !");
			return false;
		}
		try {
			if (XuLyNgay.chuyenStringThanhDate(ngayChuyen).before(XuLyNgay.chuyenStringThanhDate(ngayLap))) {
				JOptionPane.showMessageDialog(null, "Ngày chuyển hàng phải lớn hơn hoặc bằng ngày ngày lập hóa đơn !");
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ngày chuyển hàng không được để trống !");
			return false;
		}
		try {
			if (XuLyNgay.chuyenStringThanhDate(ngayGiao).before(XuLyNgay.chuyenStringThanhDate(ngayChuyen))) {
				JOptionPane.showMessageDialog(null, "Ngày giao hàng phải lớn hơn hoặc bằng ngày ngày lập hóa đơn !");
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ngày giao hàng không được để trống !");
			return false;
		}

		return true;
	}
}
