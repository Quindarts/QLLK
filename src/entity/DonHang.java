package GUI_DonHang;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.SystemColor;

import java.awt.Cursor;
import java.awt.event.ActionListener;

import java.util.EventObject;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class DonHang extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTable table;
	private JTextField txtTrang;

	/**
	 * Create the panel.
	 */
	public DonHang() {
		setSize(1015, 683);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 61, 139));
		panel.setBounds(0, 0, 1005, 55);
		add(panel);
		panel.setLayout(null);

		JLabel lblThngTinHa = new JLabel("Thông Tin Hóa Đơn");
		lblThngTinHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinHa.setForeground(new Color(255, 255, 255));
		lblThngTinHa.setFont(new Font("Arial", Font.BOLD, 20));
		lblThngTinHa.setBounds(223, 10, 557, 35);
		panel.add(lblThngTinHa);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Danh Sách Hóa Đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 98, 995, 402);
		add(panel_1);
		panel_1.setLayout(null);

		String row[] = { "Mã Hóa Đơn", "Mã Nhân Viên", "Tên Nhân Viên", "Mã Khách Hàng", "Tên Khách Hàng",
				"Ngày Lập Hóa Đơn" };
		model = new DefaultTableModel(row, 0);
		table = new JTable(model) ;
//		{
//			private static final long serialVersionUID = 1L;
//
//			public boolean editCellAt(int row, int column, EventObject e) {
//				return false;
//			};
//		};
		JTableHeader a = table.getTableHeader();
		a.setBackground(new Color(72, 61, 139));
		a.setForeground(Color.white);
		a.setFont(new Font("Tahoma", Font.BOLD, 10));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 27, 975, 365);
		panel_1.add(scrollPane);

		JButton btnXemChiTit = new JButton("Xem Chi Tiết Hóa Đơn");
		btnXemChiTit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		btnXemChiTit.setIcon(new ImageIcon(DonHang.class.getResource("/image/info_30px.png")));
		btnXemChiTit.setForeground(Color.WHITE);
		btnXemChiTit.setFont(new Font("Arial", Font.BOLD, 15));
		btnXemChiTit.setFocusPainted(false);
		btnXemChiTit.setBorder(null);
		btnXemChiTit.setBackground(SystemColor.controlDkShadow);
		btnXemChiTit.setBounds(21, 577, 240, 55);
		add(btnXemChiTit);

		JButton btnTrangDau = new JButton("");
//		btnTrangDau.setIcon(new ImageIcon(DonHang.class.getResource("/image/skip_to_start_20px.png")));
		btnTrangDau.setFocusPainted(false);
		btnTrangDau.setBorder(null);
		btnTrangDau.setBackground(Color.GRAY);
		btnTrangDau.setBounds(406, 530, 30, 25);
		add(btnTrangDau);

		JButton btnTrangTruoc = new JButton("");
//		btnTrangTruoc.setIcon(new ImageIcon(DonHang.class.getResource("/image/rewind_20px.png")));
		btnTrangTruoc.setFocusPainted(false);
		btnTrangTruoc.setBorder(null);
		btnTrangTruoc.setBackground(Color.GRAY);
		btnTrangTruoc.setBounds(443, 530, 30, 25);
		add(btnTrangTruoc);

		txtTrang = new JTextField();
		txtTrang.setEditable(false);
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setColumns(10);
		txtTrang.setBounds(485, 530, 30, 25);
		add(txtTrang);

		JButton btnTrangSau = new JButton("");
//		btnTrangSau.setIcon(new ImageIcon(DonHang.class.getResource("/image/fast_forward_20px.png")));
		btnTrangSau.setFocusPainted(false);
		btnTrangSau.setBorder(null);
		btnTrangSau.setBackground(Color.GRAY);
		btnTrangSau.setBounds(525, 530, 30, 25);
		add(btnTrangSau);

		JButton btnTrangCuoi = new JButton("");
//		btnTrangCuoi.setIcon(new ImageIcon(DonHang.class.getResource("/image/end_20px.png")));
		btnTrangCuoi.setFocusPainted(false);
		btnTrangCuoi.setBorder(null);
		btnTrangCuoi.setBackground(Color.GRAY);
		btnTrangCuoi.setBounds(562, 530, 30, 25);
		add(btnTrangCuoi);

		txtTrang.setText("1");

	}

	public static void main(String[] args) {
		new DonHang().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	

}
