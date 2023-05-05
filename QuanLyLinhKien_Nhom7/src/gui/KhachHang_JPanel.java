
package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import dao.ChiTietHoaDon_Dao;
import dao.HoaDon_Dao;
import dao.KhachHang_Dao;
import entity.HoaDon;
import entity.KhachHang;
import other.RandomMa;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KhachHang_JPanel extends JPanel implements ActionListener {

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

	private DefaultTableModel model;
	private JTable table;

	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtDiaChi;
	private JTextField txtTim;
	private JTextField txtTrang;
	private KhachHang_Dao kh_dao;
	private HoaDon_Dao hd_dao;
	private ChiTietHoaDon_Dao cthd_dao;
	private JComboBox<String> cboTim;
	private JButton btnThem;
	private JButton btnCapNhat;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel lblTmKimTheo;
	private JButton btnTrangDau;
	private JButton btnTrangTruoc;
	private JButton btnTrangSau;
	private JButton btnTrangCuoi;

	/**
	 * Create the panel.
	 */
	public KhachHang_JPanel() {
		// Lay data tu table KH, HD, CTHD
		kh_dao = new KhachHang_Dao();
		hd_dao = new HoaDon_Dao();
		cthd_dao = new ChiTietHoaDon_Dao();

		// Setting cho KhachHang_JPanel
		setSize(1015, 683);
		setLayout(null);
		setBackground(Color.decode(cl_greyblue));

		// add Tiêu đề cho KhachHang_JPanel
		panel_2 = new JPanel();
		panel_2.setBackground(Color.decode(cl_green));
		panel_2.setBounds(0, 0, 1015, 55);
		add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel = new JLabel("Thông Tin Khách Hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(212, 10, 588, 35);
		panel_2.add(lblNewLabel);

		// Tạo Tiêu đề cho table
		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Danh Sách Khách Hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 281, 995, 284);
		panel.setBackground(Color.WHITE);
		add(panel);
		panel.setLayout(null);

		// Tạo table, table model
		String row[] = { "Mã Khách Hàng", "Tên Khách Hàng", "SDT", "Email", "Địa Chỉ" };
		model = new DefaultTableModel(row, 0);
		table = new JTable(model);
		// Setting cho header table
		JTableHeader a = table.getTableHeader();
		a.setBackground(Color.decode(cl_green));
		a.setForeground(Color.white);
		a.setFont(new Font("Tahoma", Font.BOLD, 10));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 25, 975, 247);
		panel.add(scrollPane);

		// Panel Nhập thông tin KH
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Thông tin khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 88, 995, 133);
		panel_1.setBackground(Color.WHITE);
		add(panel_1);
		panel_1.setLayout(null);

		// Lbl, txt của mã KH
		JLabel lblMKhchHng = new JLabel("Mã khách hàng :");
		lblMKhchHng.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMKhchHng.setBounds(173, 21, 111, 23);
		panel_1.add(lblMKhchHng);

		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setEditable(false);
		txtMaKhachHang.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMaKhachHang.setBounds(279, 21, 244, 23);
		panel_1.add(txtMaKhachHang);
		txtMaKhachHang.setColumns(10);

		// Lbl, txt của tên KH
		JLabel lblMKhchHng_1 = new JLabel("Tên khách hàng :");
		lblMKhchHng_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMKhchHng_1.setBounds(173, 54, 108, 23);
		panel_1.add(lblMKhchHng_1);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(279, 54, 244, 23);
		panel_1.add(txtTenKhachHang);

		// Lbl, txt của SĐT
		JLabel lblMKhchHng_3 = new JLabel("SDT :");
		lblMKhchHng_3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMKhchHng_3.setBounds(553, 21, 46, 23);
		panel_1.add(lblMKhchHng_3);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSDT.setColumns(10);
		txtSDT.setBounds(606, 21, 206, 23);
		panel_1.add(txtSDT);

		// Lbl, txt của Email
		JLabel lblMKhchHng_2 = new JLabel("Email :");
		lblMKhchHng_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMKhchHng_2.setBounds(553, 54, 45, 23);
		panel_1.add(lblMKhchHng_2);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		txtEmail.setBounds(606, 54, 206, 23);
		panel_1.add(txtEmail);

		// Lbl, txt của Địa chỉ
		JLabel lblMKhchHng_1_1 = new JLabel("Địa chỉ :");
		lblMKhchHng_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMKhchHng_1_1.setBounds(173, 87, 96, 23);
		panel_1.add(lblMKhchHng_1_1);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Arial", Font.PLAIN, 13));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(279, 87, 533, 23);
		panel_1.add(txtDiaChi);

		// Txt tim kiem
		txtTim = new JTextField();
		txtTim.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTim.setBounds(291, 234, 246, 25);
		add(txtTim);
		txtTim.setColumns(10);

		// ComoBox Tim kiem
		cboTim = new JComboBox<String>();
		cboTim.setBackground(Color.WHITE);
		cboTim.setFont(new Font("Arial", Font.PLAIN, 13));
		cboTim.setBounds(137, 234, 144, 25);
		add(cboTim);
		// Thêm các dạng tìm kiếm cho combobox
		cboTim.addItem("Tên khách hàng");
		cboTim.addItem("SDT khách hàng");
		cboTim.addItem("Mã khách hàng");

		// Label Tim kiem
		lblTmKimTheo = new JLabel("Tìm kiếm theo :");
		lblTmKimTheo.setFont(font_btn13);
		lblTmKimTheo.setBounds(20, 234, 119, 25);
		add(lblTmKimTheo);

		// BTN Thêm
		btnThem = new JButton("Thêm");
		btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThem.setIcon(new ImageIcon("/image/add_25px.png"));
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(34, 139, 34));
		btnThem.setBorder(null);
		btnThem.setFocusPainted(false);
		btnThem.setFont(font_btn13);
		btnThem.setBounds(126, 629, 112, 36);
		add(btnThem);

		// BTN Cập nhật
		btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCapNhat.setIcon(new ImageIcon(KhachHang_JPanel.class.getResource("/image/settings_25px.png")));
		btnCapNhat.setForeground(new Color(255, 255, 255));
		btnCapNhat.setBackground(Color.decode(cl_yellow));
		btnCapNhat.setBorder(null);
		btnCapNhat.setFocusPainted(false);
		btnCapNhat.setFont(font_btn13);
		btnCapNhat.setBounds(343, 629, 112, 36);
		add(btnCapNhat);

		// BTN Xóa trắng
		btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoaTrang.setIcon(new ImageIcon(KhachHang_JPanel.class.getResource("/image/create_25px.png")));
		btnXoaTrang.setForeground(new Color(255, 255, 255));
		btnXoaTrang.setBackground(new Color(34, 139, 34));
		btnXoaTrang.setBorder(null);
		btnXoaTrang.setFocusPainted(false);
		btnXoaTrang.setFont(new Font("Arial", Font.BOLD, 13));
		btnXoaTrang.setBounds(548, 629, 112, 36);
		add(btnXoaTrang);

		// BTN Xóa
		btnXoa = new JButton("Xóa");
		btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoa.setIcon(new ImageIcon(KhachHang_JPanel.class.getResource("/image/delete_bin_25px.png")));
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setBorder(null);
		btnXoa.setFocusPainted(false);
		btnXoa.setFont(font_btn13);
		btnXoa.setBounds(747, 629, 112, 36);
		add(btnXoa);

		// BTN Trang Đầu
		btnTrangDau = new JButton("");
		btnTrangDau.setIcon(new ImageIcon(KhachHang_JPanel.class.getResource("/image/skip_to_start_20px.png")));
		btnTrangDau.setFocusPainted(false);
		btnTrangDau.setBorder(null);
		btnTrangDau.setBackground(Color.decode(cl_green));
		btnTrangDau.setBounds(418, 572, 30, 25);
		add(btnTrangDau);

		// BTN Trang Trước
		btnTrangTruoc = new JButton("");
		btnTrangTruoc.setIcon(new ImageIcon(KhachHang_JPanel.class.getResource("/image/rewind_20px.png")));
		btnTrangTruoc.setFocusPainted(false);
		btnTrangTruoc.setBorder(null);
		btnTrangTruoc.setBackground(Color.decode(cl_green));
		btnTrangTruoc.setBounds(455, 572, 30, 25);
		add(btnTrangTruoc);

		// TXT Số trang
		txtTrang = new JTextField();
		txtTrang.setEditable(false);
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setColumns(10);
		txtTrang.setBounds(497, 572, 30, 25);
		add(txtTrang);

		// BTN Trang Sau
		btnTrangSau = new JButton("");
		btnTrangSau.setIcon(new ImageIcon(KhachHang_JPanel.class.getResource("/image/fast_forward_20px.png")));
		btnTrangSau.setFocusPainted(false);
		btnTrangSau.setBorder(null);
		btnTrangSau.setBackground(Color.decode(cl_green));
		btnTrangSau.setBounds(537, 572, 30, 25);
		add(btnTrangSau);

		// BTN Trang Cuối
		btnTrangCuoi = new JButton("");
		btnTrangCuoi.setIcon(new ImageIcon(KhachHang_JPanel.class.getResource("/image/end_20px.png")));
		btnTrangCuoi.setFocusPainted(false);
		btnTrangCuoi.setBorder(null);
		btnTrangCuoi.setBackground(Color.decode(cl_green));
		btnTrangCuoi.setBounds(574, 572, 30, 25);
		add(btnTrangCuoi);

		// Random mã KH
		RandomMa rd = new RandomMa();
		txtMaKhachHang.setText(rd.taoMaKhachHang());
		// Đọc DL
		docDL(1, 15);
		txtTrang.setText("1");

		// Add su kien
		btnCapNhat.addActionListener(this);
		btnThem.addActionListener(this);
		btnTrangCuoi.addActionListener(this);
		btnTrangDau.addActionListener(this);
		btnTrangSau.addActionListener(this);
		btnTrangTruoc.addActionListener(this);
		;
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);

		// Event xử lý nhấp chuột vào môi dòng table thả dữ liệu vào textfield
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtMaKhachHang.setText(table.getValueAt(row, 0).toString());
				txtTenKhachHang.setText(table.getValueAt(row, 1).toString());
				txtSDT.setText(table.getValueAt(row, 2).toString());
				txtEmail.setText(table.getValueAt(row, 3).toString());
				txtDiaChi.setText(table.getValueAt(row, 4).toString());
			}
		});
		// Event tìm kiếm khách theo: tên, sđt, mã
		txtTim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// Tìm theo Tên
				if (cboTim.getSelectedIndex() == 0) {
					List<KhachHang> list1 = kh_dao.timKHTheoTen(txtTim.getText());
					xoaDL();
					list1.forEach(i -> {

						model.addRow(new Object[] { i.getMaKhachHang(), i.getTenKhachHang(), i.getsDT(), i.getEmail(),
								i.getDiaChi() });
					});
				}
				// Tìm theo SDT
				else if (cboTim.getSelectedIndex() == 1) {
					List<KhachHang> list1 = kh_dao.timKHTheoSDT(txtTim.getText());
					xoaDL();
					list1.forEach(i -> {

						model.addRow(new Object[] { i.getMaKhachHang(), i.getTenKhachHang(), i.getsDT(), i.getEmail(),
								i.getDiaChi() });
					});
				}
				// Tìm theo Mã
				else {
					List<KhachHang> list1 = kh_dao.timKHTheoMa(txtTim.getText());
					xoaDL();
					list1.forEach(i -> {

						model.addRow(new Object[] { i.getMaKhachHang(), i.getTenKhachHang(), i.getsDT(), i.getEmail(),
								i.getDiaChi() });
					});
				}
			}
		});

	}
	
	//Hàm xóa DL  table model
	public void xoaDL() {
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
	}
	//Hàm đọc DL  table model
	public void docDL(int fn, int ln) {
		List<KhachHang> listKH = kh_dao.phanTrangKhachHang(fn, ln);
		listKH.forEach(e -> {
			model.addRow(
					new Object[] { e.getMaKhachHang(), e.getTenKhachHang(), e.getsDT(), e.getEmail(), e.getDiaChi() });

		});
	}
	//Hàm reset dữ liệu trên txt
	public void xoaTrang() {
		RandomMa rd = new RandomMa();
		txtMaKhachHang.setText(rd.taoMaKhachHang());
		txtTenKhachHang.setText("");
		txtSDT.setText("");
		txtEmail.setText("");
		txtDiaChi.setText("");
	}
	//Hàm đến trang sau
	public void denTrangSau() {
		int soLuong = kh_dao.soLuongKH();
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
			xoaDL();
			docDL(fn, ln);
			table.clearSelection();

		}
	}
	//Hàm đến trang trước
	public void denTrangTruoc() {
		int trang = Integer.parseInt(txtTrang.getText());
		if (trang > 1) {
			txtTrang.setText(String.valueOf(trang - 1));
			int fn = 15 * (trang - 2) + 1;
			int ln = fn + 14;
			xoaDL();
			docDL(fn, ln);
			table.clearSelection();
		}
	}
	//Hàm đến trang đầu
	public void denTrangDau() {
		txtTrang.setText("1");
		xoaDL();
		docDL(1, 15);
		table.clearSelection();
	}
	//Hàm đến trang cuối
	public void denTrangCuoi() {
		int soLuong = kh_dao.soLuongKH();
		int trangCuoi;
		if (soLuong % 15 == 0) {
			trangCuoi = soLuong / 15;
		} else {
			trangCuoi = soLuong / 15 + 1;
		}
		int fn = (trangCuoi - 1) * 15 + 1;
		int ln = fn + 14;
		xoaDL();
		docDL(fn, ln);
		txtTrang.setText(String.valueOf(trangCuoi));
		table.clearSelection();

	}
	//Hàm lấy số trang hiện tại
	public void trangHienTai() {
		int trang = Integer.parseInt(txtTrang.getText());
		int ln = trang * 15;
		int fn = ln - 14;
		xoaDL();
		docDL(fn, ln);
	}
	
	//Kiểm tra kiểu dữ liệu nhập vào
	public boolean validateKhachHang() {
		String tenKhachHang = txtTenKhachHang.getText();
		String diaChi = txtDiaChi.getText();
		String sDT = txtSDT.getText();
		String email = txtEmail.getText();
		//Kt tên
		if (tenKhachHang.length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên khách hàng không được để trống !");
			txtTenKhachHang.requestFocus();
			txtTenKhachHang.selectAll();
			return false;
		} else {
			if (!tenKhachHang.matches("[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\r\n"
					+ "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\r\n"
					+ "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]+")) {
				JOptionPane.showMessageDialog(null, "Tên không hợp lệ !");
				txtTenKhachHang.requestFocus();
				txtTenKhachHang.selectAll();
				return false;
			}
		}
		//Kt ĐC
		if (diaChi.length() == 0) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống !");
			txtDiaChi.requestFocus();
			txtDiaChi.selectAll();
			return false;
		}
		//Kt SĐT
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
		//Kt email
		if (email.length() != 0) {
			if (!email.matches("[A-Za-z0-9.]+@[A-Za-z]+.[A-Za-z]+")) {
				JOptionPane.showMessageDialog(null, "Email không hợp lệ !");
				txtEmail.requestFocus();
				txtEmail.selectAll();
				return false;
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();

		// Button cập nhật
		if (o.equals(btnCapNhat)) {

			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Phải chọn khách hàng cần sửa !");
			} else {
				if (validateKhachHang()) {

					String maKhachHang = txtMaKhachHang.getText();
					String tenKhachHang = txtTenKhachHang.getText();
					String diaChi = txtDiaChi.getText();
					String sDT = txtSDT.getText();
					String email = txtEmail.getText();
					
					// Lấy dữ liệu và tạo KH mới đã cập nhật
					KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, diaChi, sDT, email);
					int t = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thay đổi ?", "Cập nhật",
							JOptionPane.YES_NO_OPTION);
					if (t == JOptionPane.YES_OPTION) {
						if (kh_dao.updateKhachHang(kh)) {
							JOptionPane.showMessageDialog(null, "Cập nhật thành công !");
							trangHienTai();
						} else {
							JOptionPane.showMessageDialog(null, "Cập nhật thất bại !");
						}
					}

				}

			}
		}
		// Button thêm
		if (o.equals(btnThem)) {
			if (validateKhachHang()) {

				String maKhachHang = txtMaKhachHang.getText();
				String tenKhachHang = txtTenKhachHang.getText();
				String diaChi = txtDiaChi.getText();
				String sDT = txtSDT.getText();
				String email = txtEmail.getText();
				
				//Tạo KH muốn thêm vào CSDL
				KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, diaChi, sDT, email);
				if (kh_dao.themKhachHang(kh)) {
					xoaDL();
					denTrangCuoi(); // chuyển đến trang cuối
					table.clearSelection();
					xoaTrang(); // xóa dữ liệu textfield
					JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công !");
				} else {
					JOptionPane.showMessageDialog(null, "Trùng mã !");
				}
			}
		}
		// Button trang cuối
		if (o.equals(btnTrangCuoi)) {

			denTrangCuoi();
		}
		// Button trang đầu
		if (o.equals(btnTrangDau)) {

			denTrangDau();
		}
		// Button trang sau
		if (o.equals(btnTrangSau)) {

			denTrangSau();
		}
		// Button trang trư
		if (o.equals(btnTrangTruoc)) {
			denTrangTruoc();
		}
		// Button xóa theo mã KH
		if (o.equals(btnXoa)) {

			int row = table.getSelectedRow();
			String ma = txtMaKhachHang.getText();

			if (row == -1) {

				JOptionPane.showMessageDialog(null, "Phải chọn khách hàng cần xóa !");
			} else {

				int t = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa ?", "Xóa", JOptionPane.YES_NO_OPTION);

				if (hd_dao.timHoaDon(ma) == null) {

					if (t == JOptionPane.YES_OPTION) {
						if (kh_dao.XoaKH(ma)) {
							trangHienTai();
							xoaTrang();
							table.clearSelection();
							JOptionPane.showMessageDialog(null, "Xóa thành công !");
						}

					}
				} else {

					List<HoaDon> listHD = hd_dao.getHoaDon();
					for (int i = 0; i < listHD.size(); i++) {

						if (t == JOptionPane.YES_OPTION) {
							if (listHD.get(i).getKhachHang().getMaKhachHang().equals(ma)) {

								if (cthd_dao.XoaCTHD(listHD.get(i).getMaHoaDon())
										&& hd_dao.XoaHD(listHD.get(i).getMaHoaDon()) && kh_dao.XoaKH(ma)) {
									trangHienTai();
									xoaTrang();
									table.clearSelection();
									JOptionPane.showMessageDialog(null, "Xóa thành công !");

								}
							}
						}
						//
					}
				}
			}
		}
		// Button xóa trắng
		if (o.equals(btnXoaTrang)) {

			xoaTrang();
		}

	}

}
