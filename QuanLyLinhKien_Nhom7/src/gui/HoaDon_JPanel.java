package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import dao.HoaDon_Dao;
import entity.HoaDon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class HoaDon_JPanel extends JPanel implements ActionListener {

	private String cl_green = "#00c691";
	private String cl_greyblue = "#f0f6fb";
	private String cl_yellow = "#fcbe00";
	private Font font_btn20 = new Font("Arial", Font.BOLD, 20);
	private Font font_thm10 = new Font("Tahoma", Font.BOLD, 10);
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTable table;
	private JTextField txtTrang;
	private HoaDon_Dao hd_dao;
	private JButton btnXemChiTiet;
	private JButton btnTrangSau;
	private JButton btnTrangCuoi;
	private JButton btnTrangTruoc;
	private AbstractButton btnTrangDau;

	/**
	 * Create the panel.
	 */
	public HoaDon_JPanel() {

		hd_dao = new HoaDon_Dao();
		setSize(1015, 683);
		setLayout(null);
		setBackground(Color.decode(cl_greyblue));
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode(cl_green));
		panel.setBounds(0, 0, 1005, 55);
		add(panel);
		panel.setLayout(null);

		// tiêu đề
		JLabel lblThngTinHa = new JLabel("Thông Tin Hóa Đơn");
		lblThngTinHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinHa.setForeground(new Color(255, 255, 255));
		lblThngTinHa.setFont(font_btn20);
		lblThngTinHa.setBounds(223, 10, 557, 35);
		panel.add(lblThngTinHa);

		// Tạo phần center
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(
				new TitledBorder(null, "Danh Sách Hóa Đơn", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 98, 995, 402);
		add(panel_1);
		panel_1.setLayout(null);

		// tạo bảng
		String row[] = { "Mã Hóa Đơn", "Mã Nhân Viên", "Tên Nhân Viên", "Mã Khách Hàng", "Tên Khách Hàng",
				"Ngày Lập Hóa Đơn" };
		model = new DefaultTableModel(row, 0);

		table = new JTable(model);
		JTableHeader a = table.getTableHeader();
		a.setBackground(Color.decode(cl_green));
		a.setForeground(Color.white);
		a.setFont(font_thm10);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 27, 975, 365);
		scrollPane.setBackground(Color.white);
		panel_1.add(scrollPane);

		// button đến trang đầu
		btnTrangDau = new JButton("");
		btnTrangDau.setIcon(new ImageIcon(HoaDon_JPanel.class.getResource("/image/skip_to_start_20px.png")));
		btnTrangDau.setFocusPainted(false);
		btnTrangDau.setBorder(null);
		btnTrangDau.setBackground(Color.decode(cl_green));
		btnTrangDau.setBounds(406, 530, 30, 25);
		add(btnTrangDau);

		// button đến trang trước
		btnTrangTruoc = new JButton("");
		btnTrangTruoc.setIcon(new ImageIcon(HoaDon_JPanel.class.getResource("/image/rewind_20px.png")));
		btnTrangTruoc.setFocusPainted(false);
		btnTrangTruoc.setBorder(null);
		btnTrangTruoc.setBackground(Color.decode(cl_green));
		btnTrangTruoc.setBounds(443, 530, 30, 25);
		add(btnTrangTruoc);

		txtTrang = new JTextField();
		txtTrang.setEditable(false);
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setColumns(10);
		txtTrang.setBounds(485, 530, 30, 25);
		add(txtTrang);

		// button đến trang sau
		btnTrangSau = new JButton("");
		btnTrangSau.setIcon(new ImageIcon(HoaDon_JPanel.class.getResource("/image/fast_forward_20px.png")));
		btnTrangSau.setFocusPainted(false);
		btnTrangSau.setBorder(null);
		btnTrangSau.setBackground(Color.decode(cl_green));
		btnTrangSau.setBounds(525, 530, 30, 25);
		add(btnTrangSau);

		// button đến trang cuối
		btnTrangCuoi = new JButton("");
		btnTrangCuoi.setIcon(new ImageIcon(HoaDon_JPanel.class.getResource("/image/end_20px.png")));
		btnTrangCuoi.setFocusPainted(false);
		btnTrangCuoi.setBorder(null);
		btnTrangCuoi.setBackground(Color.decode(cl_green));
		btnTrangCuoi.setBounds(562, 530, 30, 25);
		add(btnTrangCuoi);

		// số trang
		txtTrang.setText("1");

		// button xem chi tiết
		btnXemChiTiet = new JButton("Xem Chi Tiết Hóa Đơn");
		btnXemChiTiet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXemChiTiet.setIcon(new ImageIcon(HoaDon_JPanel.class.getResource("/image/info_30px.png")));
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setBackground(Color.decode(cl_yellow));
		btnXemChiTiet.setFont(new Font("Arial", Font.BOLD, 15));
		btnXemChiTiet.setFocusPainted(false);
		btnXemChiTiet.setBorder(null);
		btnXemChiTiet.setBounds(21, 577, 240, 55);
		add(btnXemChiTiet);

		// đọc dữ liệu lên bảng
		ReadData(1, 25);

		// đăng kí sự kiện
		btnXemChiTiet.addActionListener(this);
		btnTrangSau.addActionListener(this);
		btnTrangTruoc.addActionListener(this);
		btnTrangDau.addActionListener(this);
		btnTrangCuoi.addActionListener(this);
	}

	/**
	 * @param fn : số thứ tự bắt đầu lấy linh kiện trong danh sách
	 * @param ln : số thứ tự kết thúc lấy linh kiện trong danh sách công dụng : thêm
	 *           danh sách link kiện cần thêm vào bảng table
	 */
	public void ReadData(int fn, int ln) {

		List<HoaDon> listHD = hd_dao.phanTrangHoaDon(fn, ln);
		listHD.forEach(e -> {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = e.getNgayDatHang();
			String dateFormat = formatter.format(date);

			model.addRow(
					new Object[] { e.getMaHoaDon(), e.getNhanVien().getMaNhanVien(), e.getNhanVien().getTenNhanVien(),
							e.getKhachHang().getMaKhachHang(), e.getKhachHang().getTenKhachHang(), dateFormat });
		});
	}

	/**
	 * công dụng : xóa hết dữ liệu trên table
	 */
	public void DeleteDataTable() {
		model.getDataVector().removeAllElements();
	}

	/*
	 * công dụng : đến trang tiếp theo của trang hiện tại
	 */
	public void denTrangSau() {
		int soLuong = hd_dao.soLuongHD();
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
			DeleteDataTable();
			ReadData(fn, ln);
			table.clearSelection();

		}
	}

	/*
	 * công dụng : đến trang trước theo của trang hiện tại
	 */
	public void denTrangTruoc() {
		int trang = Integer.parseInt(txtTrang.getText());
		if (trang > 1) {
			txtTrang.setText(String.valueOf(trang - 1));
			int fn = 25 * (trang - 2) + 1;
			int ln = fn + 24;
			DeleteDataTable();
			ReadData(fn, ln);
			table.clearSelection();
		}
	}

	/*
	 * công dụng : quay lại trang đầu .
	 */
	public void denTrangDau() {
		txtTrang.setText("1");
		DeleteDataTable();
		ReadData(1, 25);
		table.clearSelection();
	}

	/*
	 * công dụng : đến trang cuối .
	 */
	public void denTrangCuoi() {
		int soLuong = hd_dao.soLuongHD();
		int trangCuoi;
		if (soLuong % 25 == 0) {
			trangCuoi = soLuong / 25;
		} else {
			trangCuoi = soLuong / 25 + 1;
		}
		int fn = (trangCuoi - 1) * 25 + 1;
		int ln = fn + 24;
		DeleteDataTable();
		ReadData(fn, ln);
		txtTrang.setText(String.valueOf(trangCuoi));
		table.clearSelection();

	}

	/*
	 * công dụng : về trang hiện tại
	 */
	public void trangHienTai() {
		int trang = Integer.parseInt(txtTrang.getText());
		int ln = trang * 25;
		int fn = ln - 24;
		DeleteDataTable();
		ReadData(fn, ln);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnXemChiTiet)) {
			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Phải chọn hóa đơn cần xem !");
			} else {
				new ChiTietHoaDon_JFrame(new HoaDon(table.getValueAt(row, 0).toString())).setVisible(true);

			}
		}

		if (o.equals(btnTrangSau)) {
			denTrangSau();
		}
		if (o.equals(btnTrangTruoc)) {
			denTrangTruoc();
		}
		if (o.equals(btnTrangDau)) {
			denTrangDau();
		}
		if (o.equals(btnTrangCuoi)) {
			denTrangCuoi();
		}

	}
}