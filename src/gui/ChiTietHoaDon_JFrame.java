package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import dao.ChiTietHoaDon_Dao;
import dao.HoaDon_Dao;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.EventObject;
import java.util.List;
import java.awt.event.ActionEvent;

public class ChiTietHoaDon_JFrame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cl_green = "#00c691";
	private String cl_greyblue = "#f0f6fb";
	private String cl_yellow = "#fcbe00";
	private Font font_btn13 = new Font("Arial", Font.BOLD, 13);
	private Font font_Ar_pl13 = new Font("Arial", Font.PLAIN, 13);
	private JPanel contentPane;
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtTenNhanVien;
	private JTextField txtMaNhanVien;
	private JTextField txtMaHoaDon;
	private JTextField txtNgayLapHoaDon;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private DefaultTableModel model;
	private JTable table;
	private JTextField txtEmail;
	private HoaDon hoaDon;
	private HoaDon_Dao hd_dao;
	private ChiTietHoaDon_Dao cthd_dao;
	private JTextField txtTongTien;
	private JTextField txtMucGiamGia;
	private JButton btnQuayLai;

	public ChiTietHoaDon_JFrame(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
		cthd_dao = new ChiTietHoaDon_Dao();
		hd_dao = new HoaDon_Dao();
		setBackground(Color.decode(cl_greyblue));
		setBounds(100, 100, 1015, 713);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode(cl_green));
		panel.setBounds(0, 0, 1011, 55);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//tiêu đề 
		JLabel lblNewLabel = new JLabel("Chi Tiết Hóa Đơn");
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER); // căn chỉnh giữa các nội dung trong Jlabel 
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(262, 10, 477, 35);
		panel.add(lblNewLabel);
		
		// textfield Mã Khách Hàng 
		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng :");
		lblNewLabel_1.setFont(font_btn13);
		lblNewLabel_1.setBounds(525, 109, 110, 25);
		contentPane.add(lblNewLabel_1);
		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setFont(font_Ar_pl13);
		txtMaKhachHang.setEditable(false);
		txtMaKhachHang.setBounds(645, 109, 201, 23);
		contentPane.add(txtMaKhachHang);
		txtMaKhachHang.setColumns(10);

		// textfield tên Khách Hàng
		JLabel lblNewLabel_1_1 = new JLabel("Tên khách hàng :");
		lblNewLabel_1_1.setFont(font_btn13);
		lblNewLabel_1_1.setBounds(525, 149, 110, 25);
		contentPane.add(lblNewLabel_1_1);
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(font_Ar_pl13);
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(645, 149, 201, 23);
		contentPane.add(txtTenKhachHang);

		// textfield tên nhân viên
		JLabel lblNewLabel_1_1_1 = new JLabel("Tên nhân viên :");
		lblNewLabel_1_1_1.setFont(font_btn13);
		lblNewLabel_1_1_1.setBounds(117, 189, 110, 25);
		contentPane.add(lblNewLabel_1_1_1);
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setFont(font_Ar_pl13);
		txtTenNhanVien.setEditable(false);
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(247, 189, 190, 23);
		contentPane.add(txtTenNhanVien);

		// textfield Mã Nhân Viên 
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setFont(font_Ar_pl13);
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(247, 149, 190, 23);
		contentPane.add(txtMaNhanVien);
		JLabel lblNewLabel_1_2 = new JLabel("Mã nhân viên :");
		lblNewLabel_1_2.setFont(font_btn13);
		lblNewLabel_1_2.setBounds(117, 149, 110, 25);
		contentPane.add(lblNewLabel_1_2);
		
		// textfield Mã Hóa đơn 
		JLabel lblNewLabel_1_3 = new JLabel("Mã hóa đơn :");
		lblNewLabel_1_3.setFont(font_btn13);
		lblNewLabel_1_3.setBounds(117, 109, 110, 25);
		contentPane.add(lblNewLabel_1_3);
		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setFont(font_Ar_pl13);
		txtMaHoaDon.setEditable(false);
		txtMaHoaDon.setColumns(10);
		txtMaHoaDon.setBounds(247, 109, 190, 23);
		contentPane.add(txtMaHoaDon);

		// textfield Ngày lập hóa đơn
		JLabel lblNewLabel_1_2_1 = new JLabel("Ngày lập hóa đơn :");
		lblNewLabel_1_2_1.setFont(font_btn13);
		lblNewLabel_1_2_1.setBounds(117, 229, 131, 25);
		contentPane.add(lblNewLabel_1_2_1);
		txtNgayLapHoaDon = new JTextField();
		txtNgayLapHoaDon.setFont(font_Ar_pl13);
		txtNgayLapHoaDon.setEditable(false);
		txtNgayLapHoaDon.setColumns(10);
		txtNgayLapHoaDon.setBounds(247, 229, 190, 23);
		contentPane.add(txtNgayLapHoaDon);
		
		// textfield số điện thoại
		txtSDT = new JTextField();
		txtSDT.setFont(font_Ar_pl13);
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		txtSDT.setBounds(645, 189, 201, 23);
		contentPane.add(txtSDT);
		JLabel lblNewLabel_1_1_2 = new JLabel("Số điện thoại :");
		lblNewLabel_1_1_2.setFont(font_btn13);
		lblNewLabel_1_1_2.setBounds(525, 189, 110, 25);
		contentPane.add(lblNewLabel_1_1_2);
		
		// textfield địa chỉ 
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(font_Ar_pl13);
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(247, 269, 599, 23);
		contentPane.add(txtDiaChi);
		JLabel lblNewLabel_1_1_3 = new JLabel("Địa chỉ :");
		lblNewLabel_1_1_3.setFont(font_btn13);
		lblNewLabel_1_1_3.setBounds(117, 269, 110, 25);
		contentPane.add(lblNewLabel_1_1_3);
		
		// textfield Email
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Email :");
		lblNewLabel_1_1_1_1.setFont(font_btn13);
		lblNewLabel_1_1_1_1.setBounds(525, 229, 110, 25);
		contentPane.add(lblNewLabel_1_1_1_1);
		txtEmail = new JTextField();
		txtEmail.setFont(font_Ar_pl13);
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(645, 229, 201, 23);
		contentPane.add(txtEmail);
		
		// tạo bảng 
		String row[] = { "STT", "Mã linh kiện", "Tên linh kiện", "Số lượng", "Giá bán", "Bảo Hành", "Thành Tiền" };
		model = new DefaultTableModel(row, 0);
		table = new JTable(model);
		// tô màu cho header table 
		JTableHeader a = table.getTableHeader();
		a.setBackground(Color.decode(cl_green));
		a.setForeground(Color.white);
		
		a.setFont(new Font("Tahoma", Font.BOLD, 10));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(117, 302, 729, 201);
		contentPane.add(scrollPane);
		
		
		//button quay lại
		btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(font_btn13);
		btnQuayLai.setFocusPainted(false);
		btnQuayLai.setBorder(null);
		btnQuayLai.setBackground(Color.decode(cl_yellow));
		btnQuayLai.setBounds(10, 625, 112, 36);
		contentPane.add(btnQuayLai);

		txtMaHoaDon.setText(hoaDon.getMaHoaDon());
		
		// Jtextfield Tổng tiền
		JLabel lblNewLabel_1_2_3 = new JLabel("Tổng tiền :");
		lblNewLabel_1_2_3.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_1_2_3.setBounds(570, 597, 108, 25);
		contentPane.add(lblNewLabel_1_2_3);
		txtTongTien = new JTextField();
		txtTongTien.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTongTien.setEditable(false);
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(664, 597, 182, 25);
		javax.swing.border.Border b = BorderFactory.createLineBorder(Color.decode(cl_green), 2);
		txtTongTien.setBorder(b);
		txtTongTien.setBackground(Color.decode(cl_greyblue));
		contentPane.add(txtTongTien);

		// Jtextfield Mức Giảm Giá
		txtMucGiamGia = new JTextField();
		txtMucGiamGia.setFont(font_Ar_pl13);
		txtMucGiamGia.setEditable(false);
		txtMucGiamGia.setColumns(10);
		txtMucGiamGia.setBounds(763, 514, 46, 23);
		contentPane.add(txtMucGiamGia);
		JLabel lblNewLabel_1_2_2 = new JLabel("Mức giảm giá :");
		lblNewLabel_1_2_2.setFont(font_btn13);
		lblNewLabel_1_2_2.setBounds(664, 513, 110, 25);
		contentPane.add(lblNewLabel_1_2_2);
		
		//update thông tin khách hàng 
		update_textfield();
		
		// update thông tin linh kiện 
		update_linhkien();
		
		// đăng kí sự kiện 
		btnQuayLai.addActionListener(this);
		
	}
	
	/**
	 * công dụng : thêm các thông tin khách hàng vào textfield.
	 */
	public void update_textfield() {
		List<HoaDon> listHD = hd_dao.getHoaDon();
		listHD.forEach(e -> {
			if (e.getMaHoaDon().equals(hoaDon.getMaHoaDon())) {
				txtMaKhachHang.setText(e.getKhachHang().getMaKhachHang());
				txtTenKhachHang.setText(e.getKhachHang().getTenKhachHang());
				txtSDT.setText(e.getKhachHang().getsDT());
				txtDiaChi.setText(e.getKhachHang().getDiaChi());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date = e.getNgayDatHang();
				String dateFormat = formatter.format(date);
				txtNgayLapHoaDon.setText(dateFormat);
				txtMaNhanVien.setText(e.getNhanVien().getMaNhanVien());
				txtTenNhanVien.setText(e.getNhanVien().getTenNhanVien());
				txtEmail.setText(e.getKhachHang().getEmail());

			}
		});
	}
	
	/*
	 * thêm các thông tin linh kiện vào table.
	 */
	public void update_linhkien() {
		DecimalFormat df = new DecimalFormat("#,###");
		List<ChiTietHoaDon> listCTHD = cthd_dao.getCTHDTheoMa(hoaDon.getMaHoaDon());
		int stt = 0;
		int mucGiamGia = 0;
		for (int i = 0; i < listCTHD.size(); i++) {
			stt++;
			String gia = df.format(listCTHD.get(i).getLinhKien().getGiaBan());
			model.addRow(new Object[] { stt, listCTHD.get(i).getLinhKien().getMaLinhKien(),
					listCTHD.get(i).getLinhKien().getTenLinhKien(), listCTHD.get(i).getSoLuong(), gia,
					listCTHD.get(i).getLinhKien().getBaoHanh(),
					listCTHD.get(i).getSoLuong() * listCTHD.get(i).getLinhKien().getGiaBan() });
			mucGiamGia = listCTHD.get(i).getMucGiamGia();
		}

		txtMucGiamGia.setText(String.valueOf(mucGiamGia) + " %");
		double tongTien = 0;
		for (int i = 0; i < table.getRowCount(); i++) {
			tongTien = tongTien + Double.parseDouble(table.getValueAt(i, 6).toString());
		}
		tongTien = tongTien - ((tongTien * mucGiamGia) / 100);
		txtTongTien.setText(String.valueOf(df.format(tongTien)) + " VNĐ");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnQuayLai)) {
			setVisible(false);
		}
	}


}
