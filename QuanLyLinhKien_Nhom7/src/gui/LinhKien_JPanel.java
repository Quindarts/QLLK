package gui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.LinhKien_Dao;
import dao.NhaCungCap_Dao;
import entity.LinhKien;
import entity.NhaCungCap;

import other.DatePicker;
import other.RandomMa;
import other.XuLyNgay;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

import java.awt.Insets;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LinhKien_JPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private String cl_green = "#00c691";
	private String cl_greyblue = "#f0f6fb";
	private String cl_greenbold = "#015a06";
	private String cl_yellow = "#fcbe00";
	private String cl_black = "#222222";
	private Font font_btn16 = new Font("Arial", Font.BOLD, 16);
	private Font font_btn13 = new Font("Arial", Font.BOLD, 13);
	private Font font_btnita = new Font("Arial", Font.ITALIC, 13);

	private static final long serialVersionUID = 1L;

	private JComboBox<String> cboLoaiLinhKien;
	private JComboBox<String> cboThuongHieu;

	private LinhKien_Dao lk_dao;
	private NhaCungCap_Dao ncc_dao;
	private List<NhaCungCap> listNCC;

	private JTextField txtMaLinhKien;
	private JTextField txtTenLinhKien;
	private JTextField txtSoLuongTon;
	private JTextField txtBaoHanh;
	private JTextField txtGiaBan;

	private DefaultTableModel model;
	private JTable table;

	private JTextField txtNgayNhap;
	private JTextField txtTim;
	private JTextField txtTrang;
	private RandomMa rd;
	private JTextArea txtMoTa;
	private SimpleDateFormat formatter;
	private String dateFormat;

	private JButton btnCapNhat;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnThem;
	private JButton btnTrangDau;
	private JButton btnTrangSau;
	private JButton btnTrangTruoc;
	private JButton btnGiam;
	private JButton btnTang;
	private AbstractButton btnNgayNhap;
	private AbstractButton btnTrangCuoi;

	/**
	 * Create the panel.
	 */
	public LinhKien_JPanel() {

		lk_dao = new LinhKien_Dao();
		ncc_dao = new NhaCungCap_Dao();

		setSize(1015, 683);
		setLayout(null);
		setBackground(Color.decode(cl_greyblue));
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new TitledBorder(null, "Thông Tin Linh Kiện", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setBounds(10, 56, 997, 234);
		add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.decode(cl_greyblue));

		// Ma LinhKien
		JLabel lblNewLabel = new JLabel("Mã linh kiện :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBounds(62, 28, 87, 25);
		panel.add(lblNewLabel);

		txtMaLinhKien = new JTextField();
		txtMaLinhKien.setEditable(false);
		txtMaLinhKien.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMaLinhKien.setBounds(154, 28, 316, 23);
		panel.add(txtMaLinhKien);
		txtMaLinhKien.setColumns(10);

		// Ten LinhKien
		JLabel lblNewLabel_2 = new JLabel("Tên linh kiện :");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(62, 63, 87, 25);
		panel.add(lblNewLabel_2);

		txtTenLinhKien = new JTextField();
		txtTenLinhKien.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTenLinhKien.setColumns(10);
		txtTenLinhKien.setBounds(154, 63, 316, 23);
		panel.add(txtTenLinhKien);

		// Thuong hieu LinhKien
		JLabel lblNewLabel_3 = new JLabel("Thương hiệu :");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(573, 63, 84, 25);
		panel.add(lblNewLabel_3);

		// Loai LinhKien
		JLabel lblNewLabel_6 = new JLabel("Loại linh kiện :");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(573, 28, 84, 25);
		panel.add(lblNewLabel_6);

		// SoLuongTon LinhKien
		JLabel lblNewLabel_2_1 = new JLabel("Số lượng tồn :");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(573, 98, 87, 25);
		panel.add(lblNewLabel_2_1);

		txtSoLuongTon = new JTextField();
		txtSoLuongTon.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoLuongTon.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSoLuongTon.setColumns(10);
		txtSoLuongTon.setBounds(667, 98, 43, 23);
		txtSoLuongTon.setText("0");
		panel.add(txtSoLuongTon);

		// Baohanh LinhKien
		JLabel lblNewLabel_3_1 = new JLabel("Bảo hành :");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(748, 98, 84, 25);
		panel.add(lblNewLabel_3_1);

		txtBaoHanh = new JTextField();
		txtBaoHanh.setHorizontalAlignment(SwingConstants.CENTER);
		txtBaoHanh.setFont(new Font("Arial", Font.PLAIN, 13));
		txtBaoHanh.setColumns(10);
		txtBaoHanh.setBounds(816, 98, 36, 23);
		panel.add(txtBaoHanh);

		// Mota LinhKien
		JLabel lblNewLabel_2_1_1 = new JLabel("Mô tả :");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(62, 133, 80, 25);
		panel.add(lblNewLabel_2_1_1);

		txtMoTa = new JTextArea();
		txtMoTa.setMargin(new Insets(2, 2, 2, 2));
		txtMoTa.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMoTa.setLineWrap(true);
		txtMoTa.setBounds(150, 133, 702, 91);
		panel.add(txtMoTa);

		// cbo loai LinhKien
		cboLoaiLinhKien = new JComboBox<String>();
		cboLoaiLinhKien.setBackground(Color.WHITE);
		cboLoaiLinhKien.setFont(new Font("Arial", Font.PLAIN, 13));
		cboLoaiLinhKien.setBounds(667, 28, 185, 23);
		panel.add(cboLoaiLinhKien);

		cboLoaiLinhKien.addItem("HDD");
		cboLoaiLinhKien.addItem("SSD");
		cboLoaiLinhKien.addItem("Tản nhiệt");
		cboLoaiLinhKien.addItem("RAM");
		cboLoaiLinhKien.addItem("Case");
		cboLoaiLinhKien.addItem("Bàn phím");
		cboLoaiLinhKien.addItem("Chuột");
		cboLoaiLinhKien.addItem("Mainboard");
		cboLoaiLinhKien.addItem("USB");
		cboLoaiLinhKien.addItem("Cáp");
		cboLoaiLinhKien.addItem("CPU");
		cboLoaiLinhKien.addItem("Màn hình");
		cboLoaiLinhKien.addItem("Card đồ họa");

		// Gia ban linhKien
		JLabel lblNewLabel_2_2 = new JLabel("Giá bán :");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(62, 98, 87, 25);
		panel.add(lblNewLabel_2_2);

		txtGiaBan = new JTextField();
		txtGiaBan.setFont(new Font("Arial", Font.PLAIN, 13));
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(154, 98, 95, 23);
		panel.add(txtGiaBan);

		// Ngaynhap Linhkien
		JLabel lblNewLabel_2_2_1 = new JLabel("Ngày Nhập :");
		lblNewLabel_2_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2_2_1.setBounds(259, 98, 76, 25);
		panel.add(lblNewLabel_2_2_1);

		txtNgayNhap = new JTextField();
		txtNgayNhap.setEditable(false);
		txtNgayNhap.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNgayNhap.setColumns(10);
		txtNgayNhap.setBounds(335, 98, 106, 23);
		panel.add(txtNgayNhap);

		btnNgayNhap = new JButton("");
		btnNgayNhap.setBorder(null);
		btnNgayNhap.setBackground(new Color(240, 240, 240));
		btnNgayNhap.setIcon(new ImageIcon(LinhKien_JPanel.class.getResource("/image/calendar_25px.png")));
		btnNgayNhap.setFocusPainted(false);
		btnNgayNhap.setBounds(442, 98, 25, 23);
		panel.add(btnNgayNhap);

		formatter = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = new java.util.Date();
		dateFormat = formatter.format(date);
		txtNgayNhap.setText(dateFormat);

		// cboThuongHieu linhKien
		cboThuongHieu = new JComboBox<String>();
		cboThuongHieu.setBackground(Color.WHITE);
		cboThuongHieu.setFont(new Font("Arial", Font.PLAIN, 13));
		cboThuongHieu.setBounds(667, 63, 185, 23);

		listNCC = ncc_dao.getNhaCungCap();
		listNCC.forEach(e -> {
			cboThuongHieu.addItem(e.getTenNCC());
		});

		panel.add(cboThuongHieu);

		btnNgayNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFrame f = new JFrame();
				txtNgayNhap.setText(new DatePicker(f).setPickedDate());
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode(cl_green));
		panel_1.setBounds(0, 0, 1015, 55);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Thông Tin Linh Kiện");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(270, 10, 481, 35);
		panel_1.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Danh Sách Linh Kiện", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2.setBounds(10, 344, 995, 233);
		add(panel_2);
		panel_2.setLayout(null);

		// Table linhKien
		String cols[] = { "Mã Linh Kiện", "Tên Linh Kiện", "Số Lượng Tồn", "Thương Hiệu", "Loại Linh Kiện",
				"Bảo Hành(Tháng)", "Giá Bán", "Ngày Nhập", "Mô Tả" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);

		JTableHeader td = table.getTableHeader();
		td.setBackground(Color.decode(cl_green));
		td.setForeground(Color.white);
		td.setFont(new Font("Tahoma", Font.BOLD, 10));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 20, 975, 200);
		panel_2.add(scrollPane);

		// BtnCapNhat
		btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setIcon(new ImageIcon(LinhKien_JPanel.class.getResource("/image/settings_25px.png")));
		btnCapNhat.setFont(new Font("Arial", Font.BOLD, 13));
		btnCapNhat.setForeground(new Color(255, 255, 255));
		btnCapNhat.setFocusPainted(false);
		btnCapNhat.setBorder(null);
		btnCapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCapNhat.setBackground(Color.decode(cl_yellow));
		btnCapNhat.setBounds(343, 629, 112, 36);
		add(btnCapNhat);

		// btnXoaTrang
		btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setIcon(new ImageIcon(LinhKien_JPanel.class.getResource("/image/create_25px.png")));
		btnXoaTrang.setFont(new Font("Arial", Font.BOLD, 13));
		btnXoaTrang.setForeground(new Color(255, 255, 255));
		btnXoaTrang.setFocusPainted(false);
		btnXoaTrang.setBorder(null);
		btnXoaTrang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoaTrang.setBackground(new Color(34, 139, 34));
		btnXoaTrang.setBounds(548, 629, 112, 36);
		add(btnXoaTrang);

		// btnXoa
		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(LinhKien_JPanel.class.getResource("/image/delete_bin_25px.png")));
		btnXoa.setFont(new Font("Arial", Font.BOLD, 13));
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setFocusPainted(false);
		btnXoa.setBorder(null);
		btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setBounds(747, 629, 112, 36);
		add(btnXoa);

		// BtnThem
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(LinhKien_JPanel.class.getResource("/image/add_25px.png")));
		btnThem.setFont(new Font("Arial", Font.BOLD, 13));
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setFocusPainted(false);
		btnThem.setBorder(null);
		btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThem.setBackground(new Color(34, 139, 34));
		btnThem.setBounds(126, 629, 112, 36);
		add(btnThem);

		// Timkiem
		JLabel lblNewLabel_2_2_2 = new JLabel("Tìm kiếm theo :");
		lblNewLabel_2_2_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_2_2.setBounds(20, 300, 101, 25);
		add(lblNewLabel_2_2_2);

		JComboBox<String> cboTim = new JComboBox<String>();
		cboTim.setBounds(127, 300, 129, 25);
		cboTim.setFont(new Font("Arial", Font.PLAIN, 13));
		cboTim.setBackground(Color.WHITE);

		cboTim.addItem("Tên linh kiện");
		cboTim.addItem("Thương hiệu");
		cboTim.addItem("Loại linh kiện");
		add(cboTim);

		txtTim = new JTextField();
		txtTim.setBounds(276, 302, 253, 23);
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTim.setColumns(10);

		add(txtTim);

		// btnTrangDau
		btnTrangDau = new JButton("");
		btnTrangDau.setIcon(new ImageIcon(LinhKien_JPanel.class.getResource("/image/skip_to_start_20px.png")));
		btnTrangDau.setFocusPainted(false);
		btnTrangDau.setBorder(null);
		btnTrangDau.setBackground(Color.decode(cl_green));
		btnTrangDau.setBounds(403, 585, 30, 25);
		add(btnTrangDau);

		// btnTrangSau
		btnTrangSau = new JButton("");
		btnTrangSau.setIcon(new ImageIcon(LinhKien_JPanel.class.getResource("/image/rewind_20px.png")));
		btnTrangSau.setFocusPainted(false);
		btnTrangSau.setBorder(null);
		btnTrangSau.setBackground(Color.decode(cl_green));
		btnTrangSau.setBounds(440, 585, 30, 25);
		add(btnTrangSau);

		// btnTrang Hientai
		txtTrang = new JTextField();
		txtTrang.setEditable(false);
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setColumns(10);
		txtTrang.setBounds(482, 585, 30, 25);
		add(txtTrang);

		// btnTrangTruoc
		btnTrangTruoc = new JButton("");
		btnTrangTruoc.setIcon(new ImageIcon(LinhKien_JPanel.class.getResource("/image/fast_forward_20px.png")));
		btnTrangTruoc.setFocusPainted(false);
		btnTrangTruoc.setBorder(null);
		btnTrangTruoc.setBackground(Color.decode(cl_green));
		btnTrangTruoc.setBounds(522, 585, 30, 25);
		add(btnTrangTruoc);

		// btnTrangCuoi
		btnTrangCuoi = new JButton("");
		btnTrangCuoi.setIcon(new ImageIcon(LinhKien_JPanel.class.getResource("/image/end_20px.png")));
		btnTrangCuoi.setFocusPainted(false);
		btnTrangCuoi.setBorder(null);
		btnTrangCuoi.setBackground(Color.decode(cl_green));
		btnTrangCuoi.setBounds(559, 585, 30, 25);
		add(btnTrangCuoi);

		DocDL(1, 15);
		txtTrang.setText("1");
		rd = new RandomMa();
		txtMaLinhKien.setText(rd.taoMaLinhKien());

		// btnGiam
		btnGiam = new JButton("");
		btnGiam.setFocusPainted(false);
		btnGiam.setBorder(null);
		btnGiam.setBackground(Color.decode(cl_green));
		btnGiam.setIcon(new ImageIcon(LinhKien_JPanel.class.getResource("/image/chevron_down_9px.png")));
		btnGiam.setBounds(710, 110, 20, 11);
		panel.add(btnGiam);

		// btnTang
		btnTang = new JButton("");
		btnTang.setFocusPainted(false);
		btnTang.setIcon(new ImageIcon(LinhKien_JPanel.class.getResource("/image/chevron_up_9px.png")));
		btnTang.setBorder(null);
		btnTang.setBackground(Color.decode(cl_green));
		btnTang.setBounds(710, 98, 20, 11);
		panel.add(btnTang);

		// EVENT LINHKIEN
		btnCapNhat.addActionListener(this);
		btnGiam.addActionListener(this);
		btnNgayNhap.addActionListener(this);
		btnTang.addActionListener(this);
		btnThem.addActionListener(this);
		btnTrangCuoi.addActionListener(this);
		btnTrangDau.addActionListener(this);
		btnTrangSau.addActionListener(this);
		btnTrangTruoc.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();

				txtMaLinhKien.setText(table.getValueAt(row, 0).toString());
				txtTenLinhKien.setText(table.getValueAt(row, 1).toString());
				txtSoLuongTon.setText(table.getValueAt(row, 2).toString());
				cboThuongHieu.setSelectedItem(table.getValueAt(row, 3).toString());
				cboLoaiLinhKien.setSelectedItem(table.getValueAt(row, 4).toString());
				txtBaoHanh.setText(table.getValueAt(row, 5).toString());
				txtGiaBan.setText(table.getValueAt(row, 6).toString());
				txtNgayNhap.setText(table.getValueAt(row, 7).toString());
				txtMoTa.setText(table.getValueAt(row, 8).toString());

			}
		});

		txtTim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (cboTim.getSelectedIndex() == 0) {
					List<LinhKien> l = lk_dao.timLinhKien(txtTim.getText(), "", "");
					XoaDL();
					l.forEach(lk -> {

						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
						Date date = lk.getNgayNhap();
						String dateFormat = formatter.format(date);
						model.addRow(new Object[] {

								lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getSoLuongTon(), lk.getNhaCC().getMaNCC(),
								lk.getLoaiLinhKien(), lk.getBaoHanh(), lk.getGiaBan(), dateFormat, lk.getMoTa() });
					});
				} else if (cboTim.getSelectedIndex() == 1) {
					List<LinhKien> l = lk_dao.timLinhKien("", "", txtTim.getText());
					XoaDL();
					l.forEach(lk -> {
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
						Date date = lk.getNgayNhap();
						String dateFormat = formatter.format(date);
						model.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getSoLuongTon(),
								lk.getNhaCC().getMaNCC(), lk.getLoaiLinhKien(), lk.getBaoHanh(), lk.getGiaBan(),
								dateFormat, lk.getMoTa() });
					});
				} else {
					List<LinhKien> l = lk_dao.timLinhKien("", txtTim.getText(), "");
					XoaDL();
					l.forEach(lk -> {
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
						Date date = lk.getNgayNhap();
						String dateFormat = formatter.format(date);
						model.addRow(new Object[] { lk.getMaLinhKien(), lk.getTenLinhKien(), lk.getSoLuongTon(),
								lk.getNhaCC().getMaNCC(), lk.getLoaiLinhKien(), lk.getBaoHanh(), dateFormat,
								lk.getMoTa() });
					});
				}

			}
		});

	}

	// Các hàm bổ sung
	public void DocDL(int fn, int ln) {

		List<LinhKien> listLK = lk_dao.phanTrangLinhKien(fn, ln);
		listLK.forEach(e -> {

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = e.getNgayNhap();

			try {
				String dateFormat = formatter.format(date);

				model.addRow(

						new Object[] { e.getMaLinhKien(), e.getTenLinhKien(), e.getSoLuongTon(),
								e.getNhaCC().getMaNCC(), e.getLoaiLinhKien(), e.getBaoHanh(), e.getGiaBan(), dateFormat,
								e.getMoTa() });
			} catch (Exception e2) {

			}

		});

	}

	public void XoaDL() {

		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
	}

	public void xoaTrang() {

		RandomMa rd = new RandomMa();
		String a = rd.taoMaLinhKien();
		txtMaLinhKien.setText(a);
		txtTenLinhKien.setText("");
		txtGiaBan.setText("");
		txtNgayNhap.setText(dateFormat);
		txtMoTa.setText("");
		cboLoaiLinhKien.setSelectedIndex(0);
		cboThuongHieu.setSelectedIndex(0);
		txtSoLuongTon.setText("0");
		txtBaoHanh.setText("");
		txtMaLinhKien.requestFocus();

	}

	public void denTrangTruoc() {

		int soLuong = lk_dao.soLuongLK();
		int soTrang = Integer.parseInt(txtTrang.getText());

		int trangLonNhat;
		if (soLuong % 15 == 0) {
			trangLonNhat = soLuong / 15;
		} else {
			trangLonNhat = soLuong / 15 + 1;
		}
		if (soTrang < trangLonNhat) {
			txtTrang.setText(String.valueOf(soTrang + 1));
			int fn = 15 * soTrang + 1;
			int ln = fn + 14;
			XoaDL();
			DocDL(fn, ln);
			table.clearSelection();

		}
	}

	public void denTrangSau() {

		int trang = Integer.parseInt(txtTrang.getText());
		if (trang > 1) {
			txtTrang.setText(String.valueOf(trang - 1));
			int fn = 15 * (trang - 2) + 1;
			int ln = fn + 14;
			XoaDL();
			DocDL(fn, ln);
			table.clearSelection();
		}

	}

	public void denTrangDau() {

		txtTrang.setText("1");
		XoaDL();
		DocDL(1, 15);
		table.clearSelection();

	}

	public void denTrangCuoi() {

		int soLuong = lk_dao.soLuongLK();
		int trangCuoi;
		if (soLuong % 15 == 0) {
			trangCuoi = soLuong / 15;
		} else {
			trangCuoi = soLuong / 15 + 1;
		}
		int fn = (trangCuoi - 1) * 15 + 1;
		int ln = fn + 14;
		XoaDL();
		DocDL(fn, ln);
		txtTrang.setText(String.valueOf(trangCuoi));
		table.clearSelection();

	}

	public void trangHienTai() {

		int trang = Integer.parseInt(txtTrang.getText());
		int ln = trang * 15;
		int fn = ln - 14;
		XoaDL();
		DocDL(fn, ln);

	}

	public boolean regexLinhKien() {

		String tenLinhKien = txtTenLinhKien.getText();
		String moTa = txtMoTa.getText();
		String ngayNhap = txtNgayNhap.getText();
		int soLuongTon;
		int baoHanh;
		double giaBan;

		if (tenLinhKien.length() == 0) {

			JOptionPane.showMessageDialog(null, "Tên linh kiện không được để trống !!!");
			txtTenLinhKien.selectAll();
			;
			txtTenLinhKien.requestFocus();
			return false;

		}
		try {

			giaBan = Double.parseDouble(txtGiaBan.getText());
			if (giaBan < 0) {
				JOptionPane.showMessageDialog(null, "Giá bán phải lớn hơn 0 !!!");
				txtGiaBan.selectAll();
				;
				txtGiaBan.requestFocus();
				return false;
			}
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Giá bán phải là chử số và không được để trống !!!");
			txtGiaBan.selectAll();
			txtGiaBan.requestFocus();
			return false;
		}
		try {
			soLuongTon = Integer.parseInt(txtSoLuongTon.getText());

			if (soLuongTon <= 0) {

				JOptionPane.showMessageDialog(null, "Số lượng tồn phải lớn hơn 0 !!!");
				txtSoLuongTon.selectAll();
				txtSoLuongTon.requestFocus();
				return false;

			}
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Số lượng tồn phải là số nguyên và không được để trống !!!");
			txtSoLuongTon.selectAll();
			txtSoLuongTon.requestFocus();
			return false;

		}
		try {

			baoHanh = Integer.parseInt(txtBaoHanh.getText());
			if (baoHanh < 0) {

				JOptionPane.showMessageDialog(null, "Bảo hành lớn hơn 0 !!!");
				txtBaoHanh.selectAll();
				txtBaoHanh.requestFocus();
				return false;

			}
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Bảo hành là số nguyên không được để trống !!!");
			txtBaoHanh.selectAll();
			txtBaoHanh.requestFocus();
			return false;

		}
		if (moTa.length() == 0) {
			JOptionPane.showMessageDialog(null, "Mô tả không để trống !!!");
			txtMoTa.selectAll();
			;
			txtMoTa.requestFocus();
			return false;
		}
		java.util.Date date = new java.util.Date();
		try {
			java.util.Date ngay = XuLyNgay.chuyenStringThanhDate(ngayNhap);
			if (ngay.after(date)) {
				JOptionPane.showMessageDialog(null, "Ngày nhập phải bé hơn hoặc bằng ngày hiện tại !!!");
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ngày nhập không được để trống !!!");
			return false;
		}

		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();

		if (o.equals(btnCapNhat)) {
			JOptionPane.showMessageDialog(null, "Hello");
			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Phải chọn linh kiện cần sửa !!!");
			} else {
				if (regexLinhKien()) {
					String maNCC = "";
					String thuongHieu = (String) cboThuongHieu.getSelectedItem();
					List<NhaCungCap> listNCC = ncc_dao.getNhaCungCap();
					for (int i = 0; i < listNCC.size(); i++) {
						if (listNCC.get(i).getTenNCC().equals(thuongHieu)) {
							maNCC = listNCC.get(i).getMaNCC();
						}
					}
					String maLinhKien = txtMaLinhKien.getText();
					String tenLinhKien = txtTenLinhKien.getText();
					String loaiLinhKien = (String) cboLoaiLinhKien.getSelectedItem();
					int soLuongTon = Integer.parseInt(txtSoLuongTon.getText());
					double giaBan = Double.parseDouble(txtGiaBan.getText());
					int baoHanh = Integer.parseInt(txtBaoHanh.getText());
					String moTa = txtMoTa.getText();
					Date ngayNhap = XuLyNgay.chuyenStringThanhDate(txtNgayNhap.getText());
					LinhKien lk = new LinhKien(new NhaCungCap(maNCC), maLinhKien, tenLinhKien, loaiLinhKien, soLuongTon,
							giaBan, baoHanh, moTa, ngayNhap);

					int t = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thay đổi !!!", "Cập nhật",
							JOptionPane.YES_NO_OPTION);
					if (t == JOptionPane.YES_OPTION) {
						if (lk_dao.updateLinhKien(lk)) {
							trangHienTai();
							table.clearSelection();
							JOptionPane.showMessageDialog(null, "Cập nhật thành công !!!");

						} else {
							JOptionPane.showMessageDialog(null, "Cập nhật thất bại !!!");
						}
					}
				}
			}
		}
		if (o.equals(btnGiam)) {

			int sl = Integer.parseInt(txtSoLuongTon.getText());
			if (sl > 0) {
				txtSoLuongTon.setText(String.valueOf(sl - 1));
			}

		}
		if (o.equals(btnTang)) {

			int sl = Integer.parseInt(txtSoLuongTon.getText());
			txtSoLuongTon.setText(String.valueOf(sl + 1));

		}
		if (o.equals(btnThem)) {

			if (regexLinhKien()) {
				String tenNCC = (String) cboThuongHieu.getSelectedItem();
				String maNCC = "";
				for (int i = 0; i < listNCC.size(); i++) {
					if (listNCC.get(i).getTenNCC().equals(tenNCC)) {
						maNCC = listNCC.get(i).getMaNCC();
					}
				}
				String maLinhKien = txtMaLinhKien.getText();
				String tenLinhKien = txtTenLinhKien.getText();
				String loaiLinhKien = (String) cboLoaiLinhKien.getSelectedItem();
				int soLuongTon = Integer.parseInt(txtSoLuongTon.getText());
				double giaBan = Double.parseDouble(txtGiaBan.getText());
				int baoHanh = Integer.parseInt(txtBaoHanh.getText());
				String moTa = txtMoTa.getText();

				String ngay = txtNgayNhap.getText();
				Date ngayNhap = XuLyNgay.chuyenStringThanhDate(ngay);

				LinhKien lk = new LinhKien(new NhaCungCap(maNCC), maLinhKien, tenLinhKien, loaiLinhKien, soLuongTon,
						giaBan, baoHanh, moTa, ngayNhap);
				if (lk_dao.ThemLK(lk) == true) {
					JOptionPane.showMessageDialog(null, "Thêm thành công !!!");
					XoaDL();
					denTrangCuoi();
					xoaTrang();
				} else {
					JOptionPane.showMessageDialog(null, "Trùng mã linh kiện !!!");
				}

			}

		}
		if (o.equals(btnTrangDau)) {
			denTrangDau();
		}
		if (o.equals(btnTrangSau)) {
			denTrangSau();
		}
		if (o.equals(btnTrangTruoc)) {
			denTrangTruoc();
		}
		if (o.equals(btnTrangCuoi)) {
			denTrangCuoi();
		}
		if (o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			String ma = txtMaLinhKien.getText();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Phải chọn dòng cần xóa !!!");
			} else {
				int t = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không !!!", "Xóa",
						JOptionPane.YES_NO_OPTION);
				if (t == JOptionPane.YES_OPTION) {
					if (lk_dao.XoaLK(ma)) {

						xoaTrang();
						if (table.getRowCount() != 1) {
							trangHienTai();
							JOptionPane.showMessageDialog(null, "Xóa thành công !!!!!");
						} else {
							denTrangTruoc();
							JOptionPane.showMessageDialog(null, "Xóa thành công !!!!!");
						}

					} else {
						JOptionPane.showMessageDialog(null, "Xóa thất bại !!!!!");
					}

				}

			}
		}
		if (o.equals(btnXoaTrang)) {
			xoaTrang();
		}
	}

}
