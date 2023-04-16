package gui;

import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.util.EventObject;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.NhanVien_Dao;
import entity.NhanVien;
import other.RandomMa;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class NhanVien_QL_JPanel extends JPanel {
	/**
	 * 
	 */
	private String cl_green = "#00c691";
	private String cl_greyblue = "#f0f6fb";
	private String cl_greenbold ="#015a06";
	private String cl_yellow = "#fcbe00";
	private String cl_black = "#222222";
	private Font font_btn16 = new Font("Arial", Font.BOLD, 16);
	private Font font_btn13 = new Font("Arial", Font.BOLD, 13);
	private Font font_pln13 = new Font("Arial", Font.PLAIN, 13);
	private Font font_btn20 = new Font("Arial", Font.BOLD, 20);
	private Font font_btnita = new Font("Arial", Font.ITALIC, 13);
	private static final long serialVersionUID = 1L;
	private JTextField txtMaNhanVien;
	private JTextField txtTenNhanVien;
	private JTextField txtHeSoLuong;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtMatKhau;
	private JTextField txtCMND;
	private DefaultTableModel model;
	private NhanVien_Dao nv_dao;
	private JComboBox<String> cboChucVu;

	/**
	 * Create the panel.
	 */
	public NhanVien_QL_JPanel() {
		nv_dao = new NhanVien_Dao();

		setSize(1015, 683);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1015, 683);
		panel.setBackground(Color.decode(cl_greyblue));
		add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.decode(cl_green));
		panel_1.setBounds(0, 0, 1026, 55);
		panel.add(panel_1);

		JLabel lblThngTinNhn = new JLabel("Thông Tin Nhân Viên");
		lblThngTinNhn.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinNhn.setForeground(Color.WHITE);
		lblThngTinNhn.setFont(font_btn20);
		lblThngTinNhn.setBounds(321, 10, 441, 35);
		panel_1.add(lblThngTinNhn);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng Tin Nh\u00E2n Vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_3.setBounds(10, 65, 1006, 215);
		panel_3.setBackground(Color.white);
		panel.add(panel_3);

		JLabel lblMNhnVin = new JLabel("Mã nhân viên :");
		lblMNhnVin.setFont(font_pln13);
		lblMNhnVin.setBounds(100, 35, 94, 25);
		panel_3.add(lblMNhnVin);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(192, 35, 205, 23);
		panel_3.add(txtMaNhanVien);

		JLabel lblTnNhnVin = new JLabel("Tên nhân viên :");
		lblTnNhnVin.setFont(font_pln13);
		lblTnNhnVin.setBounds(100, 70, 94, 25);
		panel_3.add(lblTnNhnVin);

		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(192, 70, 205, 23);
		panel_3.add(txtTenNhanVien);

		JLabel lblChcV = new JLabel("Chức vụ :");
		lblChcV.setFont(font_pln13);
		lblChcV.setBounds(533, 35, 94, 25);
		panel_3.add(lblChcV);

		JLabel lblMNhnVin_1_1 = new JLabel("Giới tính :");
		lblMNhnVin_1_1.setFont(font_pln13);
		lblMNhnVin_1_1.setBounds(533, 70, 94, 25);
		panel_3.add(lblMNhnVin_1_1);

		txtHeSoLuong = new JTextField();
		txtHeSoLuong.setColumns(10);
		txtHeSoLuong.setBounds(192, 105, 205, 23);
		panel_3.add(txtHeSoLuong);

		JLabel lblMNhnVin_1_2 = new JLabel("Hệ số lương :");
		lblMNhnVin_1_2.setFont(font_pln13);
		lblMNhnVin_1_2.setBounds(100, 105, 94, 25);
		panel_3.add(lblMNhnVin_1_2);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(625, 103, 149, 23);
		panel_3.add(txtSDT);

		JLabel lblMNhnVin_1_3 = new JLabel("Số điện thoại :");
		lblMNhnVin_1_3.setFont(font_pln13);
		lblMNhnVin_1_3.setBounds(533, 103, 94, 25);
		panel_3.add(lblMNhnVin_1_3);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(192, 175, 582, 23);
		panel_3.add(txtDiaChi);

		JLabel lblMNhnVin_1_4 = new JLabel("Địa chỉ :");
		lblMNhnVin_1_4.setFont(font_pln13);
		lblMNhnVin_1_4.setBounds(100, 175, 94, 25);
		panel_3.add(lblMNhnVin_1_4);

		cboChucVu = new JComboBox<String>();
		cboChucVu.setBounds(625, 37, 149, 21);
		panel_3.add(cboChucVu);
		cboChucVu.addItem("Bán Hàng");
		cboChucVu.addItem("Quản Lý");

		JRadioButton rbnNam = new JRadioButton("Nam");
		rbnNam.setSelected(true);
		rbnNam.setFont(font_pln13);
		rbnNam.setFocusPainted(false);
		rbnNam.setBounds(625, 72, 52, 21);
		panel_3.add(rbnNam);

		JRadioButton rbnNu = new JRadioButton("Nữ");
		rbnNu.setFont(font_pln13);
		rbnNu.setFocusPainted(false);
		rbnNu.setBounds(679, 72, 62, 21);
		panel_3.add(rbnNu);
		ButtonGroup g = new ButtonGroup();
		g.add(rbnNu);
		g.add(rbnNam);

		JLabel lblMNhnVin_1_2_1 = new JLabel("Mật khẩu :");
		lblMNhnVin_1_2_1.setFont(font_pln13);
		lblMNhnVin_1_2_1.setBounds(100, 140, 94, 25);
		panel_3.add(lblMNhnVin_1_2_1);

		txtMatKhau = new JTextField();
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(192, 140, 205, 23);
		panel_3.add(txtMatKhau);

		JLabel lblMNhnVin_1_3_1 = new JLabel("CMND :");
		lblMNhnVin_1_3_1.setFont(font_pln13);
		lblMNhnVin_1_3_1.setBounds(533, 140, 94, 25);
		panel_3.add(lblMNhnVin_1_3_1);

		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(625, 140, 149, 23);
		panel_3.add(txtCMND);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "Danh S\u00E1ch Nh\u00E2n Vi\u00EAn", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 288, 1006, 330);
		panel_4.setBackground(Color.white);
		panel.add(panel_4);

		String row[] = { "Mã nhân viên", "Tên nhân viên", "Chức vụ", "Giới tính", "Hệ số lương", "Số điện thoại",
				"CMND", "Địa chỉ", "Mật khẩu" };
		model = new DefaultTableModel(row, 0);
		JTable table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) {
				return false;
			};
		};
		JTableHeader a = table.getTableHeader();
		a.setBackground(Color.decode(cl_green));
		a.setForeground(Color.white);
		a.setFont(new Font("Tahoma", Font.BOLD, 10));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				txtMaNhanVien.setText(table.getValueAt(row, 0).toString());
				txtTenNhanVien.setText(table.getValueAt(row, 1).toString());
				cboChucVu.setSelectedItem(table.getValueAt(row, 2).toString());
				if (table.getValueAt(row, 3).toString().equals("Nam")) {
					rbnNam.setSelected(true);
				} else {
					rbnNu.setSelected(true);
				}
				txtHeSoLuong.setText(table.getValueAt(row, 4).toString());
				txtSDT.setText(table.getValueAt(row, 5).toString());
				txtCMND.setText(table.getValueAt(row, 6).toString());
				txtDiaChi.setText(table.getValueAt(row, 7).toString());
				txtMatKhau.setText(table.getValueAt(row, 8).toString());
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setBounds(10, 22, 986, 300);
		panel_4.add(scrollPane);

		JButton btnThem = new JButton("Thêm");
		btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (thongTinNhanVien()) {
					String maNhanVien = txtMaNhanVien.getText();
					String tenNhanVien = txtTenNhanVien.getText();
					String chucVu = (String) cboChucVu.getSelectedItem();
					double heSoLuong = Double.parseDouble(txtHeSoLuong.getText());
					String diaChi = txtDiaChi.getText();
					boolean gioiTinh;
					if (rbnNam.isSelected() == true) {
						gioiTinh = true;
					} else {
						gioiTinh = false;
					}
					String sDT = txtSDT.getText();
					String cMND = txtCMND.getText();
					String matKhau = txtMatKhau.getText();
					NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, chucVu, heSoLuong, diaChi, gioiTinh, sDT, cMND,
							matKhau);
					if (nv_dao.ThemNV(nv)) {
						xoaDL();
						docDL();
						table.clearSelection();
						JOptionPane.showMessageDialog(null, "Thêm thành công !");

					} else {
						JOptionPane.showMessageDialog(null, "Trùng mã nhân viên !");
					}
				}

			}
		});
		btnThem.setIcon(new ImageIcon(NhanVien_QL_JPanel.class.getResource("/image/add_25px.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(font_btn13);
		btnThem.setFocusPainted(false);
		btnThem.setBorder(null);
		btnThem.setBackground(new Color(34, 139, 34));
		btnThem.setBounds(127, 629, 112, 36);
		panel.add(btnThem);

		JButton btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "Phải chọn nhân viên cần thay đổi !");
				} else {
					if(thongTinNhanVien()) {
						String maNhanVien = txtMaNhanVien.getText();
						String tenNhanVien = txtTenNhanVien.getText();
						String chucVu = (String) cboChucVu.getSelectedItem();
						double heSoLuong = Double.parseDouble(txtHeSoLuong.getText());
						String diaChi = txtDiaChi.getText();
						boolean gioiTinh;
						if (rbnNam.isSelected() == true) {
							gioiTinh = true;
						} else {
							gioiTinh = false;
						}
						String sDT = txtSDT.getText();
						String cMND = txtCMND.getText();
						String matKhau = txtMatKhau.getText();
						NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, chucVu, heSoLuong, diaChi, gioiTinh, sDT, cMND,
								matKhau);
						int t = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thay đổi", "Cập nhật",
								JOptionPane.YES_NO_OPTION);
						if (t == JOptionPane.YES_OPTION) {
							if (nv_dao.CapNhatNV(nv)) {
								xoaDL();
								docDL();
								table.clearSelection();
								JOptionPane.showMessageDialog(null, "Cập nhật thành công !");
							} else {
								JOptionPane.showMessageDialog(null, "Cập nhật thất bại !");
							}
						}

					}
					
				}

			}
		});
		btnCapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCapNhat.setIcon(new ImageIcon(NhanVien_QL_JPanel.class.getResource("/image/settings_25px.png")));
		btnCapNhat.setForeground(Color.WHITE);
		btnCapNhat.setFont(font_btn13);
		btnCapNhat.setFocusPainted(false);
		btnCapNhat.setBorder(null);
		btnCapNhat.setBackground(Color.decode(cl_yellow));
		btnCapNhat.setBounds(344, 629, 112, 36);
		panel.add(btnCapNhat);

		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RandomMa rd = new RandomMa();
				txtMaNhanVien.setText(rd.taoMaNhanVien());
				txtTenNhanVien.setText("");
				cboChucVu.setSelectedIndex(0);
				rbnNam.setSelected(true);
				txtHeSoLuong.setText("");
				txtSDT.setText("");
				txtCMND.setText("");
				txtDiaChi.setText("");
				txtMatKhau.setText("");
			}
		});
		btnXoaTrang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoaTrang.setIcon(new ImageIcon(NhanVien_QL_JPanel.class.getResource("/image/create_25px.png")));
		btnXoaTrang.setForeground(Color.WHITE);
		btnXoaTrang.setFont(font_btn13);
		btnXoaTrang.setFocusPainted(false);
		btnXoaTrang.setBorder(null);
		btnXoaTrang.setBackground(new Color(34, 139, 34));
		btnXoaTrang.setBounds(549, 629, 112, 36);
		panel.add(btnXoaTrang);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "Phải chọn nhân viên cần thay đổi !");
				} else {
					String ma = table.getValueAt(row, 0).toString();
					int t = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên !", "Xóa",
							JOptionPane.YES_NO_OPTION);
					if (t == JOptionPane.YES_OPTION) {
						if (nv_dao.xoaNV(ma)) {
							xoaDL();
							docDL();
							table.clearSelection();
							JOptionPane.showMessageDialog(null, "Xóa thành công !");
						} else {
							JOptionPane.showMessageDialog(null, "Xóa thất bại !");
						}
					}
				}
			}
		});
		btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoa.setIcon(new ImageIcon(NhanVien_QL_JPanel.class.getResource("/image/delete_bin_25px.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(font_btn13);
		btnXoa.setFocusPainted(false);
		btnXoa.setBorder(null);
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(748, 629, 112, 36);
		panel.add(btnXoa);

		docDL();
		RandomMa rd = new RandomMa();
		txtMaNhanVien.setText(rd.taoMaNhanVien());
	}

	public void xoaDL() {
		model.getDataVector().removeAllElements();
	}

	public void docDL() {
		List<NhanVien> list = nv_dao.getNhanVien();
		list.forEach(e -> {
			String gt;
			if (e.isGioiTinh() == true) {
				gt = "Nam";
			} else {
				gt = "Nữ";
			}
			model.addRow(new Object[] { e.getMaNhanVien(), e.getTenNhanVien(), e.getChucVu(), gt, e.getHeSoLuong(),
					e.getsDT(), e.getcMND(), e.getDiaChi(), e.getMatKhau() });
		});
	}

	public boolean thongTinNhanVien() {
		String tenNhanVien = txtTenNhanVien.getText();
		double heSoLuong = 0;
		String matKhau = txtMatKhau.getText();
		String diaChi = txtDiaChi.getText();
		String sDT = txtSDT.getText();
		String cMND = txtCMND.getText();
		if (tenNhanVien.length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên không được để trống !");
			txtTenNhanVien.requestFocus();
			txtTenNhanVien.selectAll();
			return false;
		}

		else {
			if (!tenNhanVien.matches("[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\r\n"
					+ "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\r\n"
					+ "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]+")) {
				JOptionPane.showMessageDialog(null, "Tên không hợp lệ !");
				txtTenNhanVien.requestFocus();
				txtTenNhanVien.selectAll();
				return false;
			}
		}
		try {
			heSoLuong = Double.parseDouble(txtHeSoLuong.getText());
			if (heSoLuong <= 0) {
				JOptionPane.showMessageDialog(null, "Hệ số lương phải lớn hơn 0 !");
				txtHeSoLuong.requestFocus();
				txtHeSoLuong.selectAll();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hệ số lương phải là chử số !");
			txtHeSoLuong.requestFocus();
			txtHeSoLuong.selectAll();
			return false;
		}
		if (matKhau.length() == 0) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống !");
			txtMatKhau.requestFocus();
			txtMatKhau.selectAll();
			return false;
		}
		else {
			if(!matKhau.matches("[0-9a-zA-Z]{6}")) {
				JOptionPane.showMessageDialog(null, "Mật khẩu phải gồm 6 kí tự !");
				txtMatKhau.requestFocus();
				txtMatKhau.selectAll();
				return false;
			}
		}
		if (diaChi.length() == 0) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống !");
			txtDiaChi.requestFocus();
			txtDiaChi.selectAll();
			return false;
		}
		if (sDT.length() == 0) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống !");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		} else {
			if (!sDT.matches("[0-9]{10}")) {
				JOptionPane.showMessageDialog(null, "Số điện thoại phải là chử số và gồm 10 số !");
				txtSDT.requestFocus();
				txtSDT.selectAll();
				return false;
			}
		}
		if (cMND.length() == 0) {
			JOptionPane.showMessageDialog(null, "Chứng minh nhân dân không được để trống !");
			txtCMND.requestFocus();
			txtCMND.selectAll();
			return false;
		} else {
			if (!cMND.matches("[0-9]{9}")) {
				JOptionPane.showMessageDialog(null, "Chứng minh nhân dân phải gồm 9 chử số !");
				txtCMND.requestFocus();
				txtCMND.selectAll();
				return false;
			}
		}
		return true;
	}
}
