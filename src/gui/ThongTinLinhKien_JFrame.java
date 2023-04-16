package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.LinhKien_Dao;
import entity.LinhKien;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Insets;

public class ThongTinLinhKien_JFrame extends JFrame {

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
	private JPanel contentPane;
	private JTextField txtTenLinhKien;
	private JTextField txtGiaBan;
	private JTextField txtThuongHieu;
	private JTextField txtNgayNhap;
	private JTextField txtMaLinhKien;
	private JTextField txtLoaiLinhKien;
	private JTextField txtSoLuongTon;
	@SuppressWarnings("unused")
	private DefaultTableModel model;
	private JTextField txtBaoHanh;
	@SuppressWarnings("unused")
	private LinhKien linhKien;
	private LinhKien_Dao lk_dao;

	public ThongTinLinhKien_JFrame(LinhKien linhKien) {
		super();
		this.linhKien = linhKien;

		lk_dao = new LinhKien_Dao();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 580);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.decode(cl_green));
		panel.setBounds(0, 0, 1011, 55);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thông Tin Linh Kiện");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(262, 10, 477, 35);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên linh kiện :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(117, 149, 110, 25);
		contentPane.add(lblNewLabel_1);

		txtTenLinhKien = new JTextField();
		txtTenLinhKien.setEditable(false);
		txtTenLinhKien.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTenLinhKien.setBounds(225, 149, 201, 23);
		contentPane.add(txtTenLinhKien);
		txtTenLinhKien.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Giá bán :");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(117, 189, 110, 25);
		contentPane.add(lblNewLabel_1_1);

		txtGiaBan = new JTextField();
		txtGiaBan.setEditable(false);
		txtGiaBan.setFont(new Font("Arial", Font.PLAIN, 13));
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(225, 189, 201, 23);
		contentPane.add(txtGiaBan);

		JLabel lblNewLabel_1_1_1 = new JLabel("Thương hiệu :");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(525, 189, 110, 25);
		contentPane.add(lblNewLabel_1_1_1);

		txtThuongHieu = new JTextField();
		txtThuongHieu.setEditable(false);
		txtThuongHieu.setFont(new Font("Arial", Font.PLAIN, 13));
		txtThuongHieu.setColumns(10);
		txtThuongHieu.setBounds(645, 189, 201, 23);
		contentPane.add(txtThuongHieu);

		txtNgayNhap = new JTextField();
		txtNgayNhap.setEditable(false);
		txtNgayNhap.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNgayNhap.setColumns(10);
		txtNgayNhap.setBounds(645, 149, 201, 23);
		contentPane.add(txtNgayNhap);

		JLabel lblNewLabel_1_2 = new JLabel("Ngày nhập :");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(525, 149, 110, 25);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Mã linh kiện :");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(117, 109, 110, 25);
		contentPane.add(lblNewLabel_1_3);

		txtMaLinhKien = new JTextField();
		txtMaLinhKien.setEditable(false);
		txtMaLinhKien.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMaLinhKien.setColumns(10);
		txtMaLinhKien.setBounds(225, 112, 201, 23);
		contentPane.add(txtMaLinhKien);

		JLabel lblNewLabel_1_2_1 = new JLabel("Loại linh kiện :");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(525, 109, 110, 25);
		contentPane.add(lblNewLabel_1_2_1);

		txtLoaiLinhKien = new JTextField();
		txtLoaiLinhKien.setEditable(false);
		txtLoaiLinhKien.setFont(new Font("Arial", Font.PLAIN, 13));
		txtLoaiLinhKien.setColumns(10);
		txtLoaiLinhKien.setBounds(645, 109, 201, 23);
		contentPane.add(txtLoaiLinhKien);

		txtSoLuongTon = new JTextField();
		txtSoLuongTon.setEditable(false);
		txtSoLuongTon.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSoLuongTon.setColumns(10);
		txtSoLuongTon.setBounds(225, 229, 63, 23);
		contentPane.add(txtSoLuongTon);

		JLabel lblNewLabel_1_1_2 = new JLabel("Số lượng tồn :");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1_1_2.setBounds(117, 229, 110, 25);
		contentPane.add(lblNewLabel_1_1_2);

		String row[] = { "Mã linh kiện", "Tên linh kiện", "Số lượng", "Giá bán", "Bảo Hành", "Thành Tiền" };
		model = new DefaultTableModel(row, 0);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Bảo hành :");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(525, 227, 110, 25);
		contentPane.add(lblNewLabel_1_1_1_1);

		txtBaoHanh = new JTextField();
		txtBaoHanh.setEditable(false);
		txtBaoHanh.setFont(new Font("Arial", Font.PLAIN, 13));
		txtBaoHanh.setColumns(10);
		txtBaoHanh.setBounds(645, 227, 63, 23);
		contentPane.add(txtBaoHanh);

		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnQuayLai.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(new Font("Arial", Font.BOLD, 13));
		btnQuayLai.setFocusPainted(false);
		btnQuayLai.setBorder(null);
		btnQuayLai.setBackground(Color.decode(cl_yellow));
		btnQuayLai.setBounds(22, 489, 112, 36);
		contentPane.add(btnQuayLai);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Mô tả :");
		lblNewLabel_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1.setBounds(117, 269, 110, 25);
		contentPane.add(lblNewLabel_1_1_2_1);

		JTextArea txtMoTa = new JTextArea();
		txtMoTa.setMargin(new Insets(5, 5, 5, 5));
		txtMoTa.setEditable(false);
		JScrollPane js = new JScrollPane(txtMoTa);
		js.setBounds(225, 269, 621, 170);
		contentPane.add(js);

		txtMaLinhKien.setText(linhKien.getMaLinhKien());
		List<LinhKien> listLK = lk_dao.getLinhKien();
		listLK.forEach(e -> {
			if (e.getMaLinhKien().equals(linhKien.getMaLinhKien())) {
				txtTenLinhKien.setText(e.getTenLinhKien());
				txtGiaBan.setText(String.valueOf(e.getGiaBan()));
				txtSoLuongTon.setText(String.valueOf(e.getSoLuongTon()));
				txtMoTa.setText(e.getMoTa());
				txtLoaiLinhKien.setText(e.getLoaiLinhKien());
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				Date date = e.getNgayNhap();
				String dateFormat = formatter.format(date);
				txtNgayNhap.setText(dateFormat);
				txtThuongHieu.setText(e.getNhaCC().getMaNCC());
				txtBaoHanh.setText(String.valueOf(e.getBaoHanh()));

			}
		});
	}
}
