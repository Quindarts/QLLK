package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.NhanVien_Dao;
import entity.NhanVien;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import java.util.EventObject;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NhanVien_BH_JPanel extends JPanel {
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
	private Font font_pln13 = new Font("Arial", Font.PLAIN, 13);
	private Font font_btn20 = new Font("Arial", Font.BOLD, 20);
	private Font font_btnita = new Font("Arial", Font.ITALIC, 13);
	
	private static final long serialVersionUID = 1L;
	private JTextField txtTenNhanVien;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	
	@SuppressWarnings("unused")
	private NhanVien nhanVien;

	public NhanVien_BH_JPanel(NhanVien nhanVien) {
		super();
		this.nhanVien = nhanVien;
	}

	private NhanVien_Dao nv_dao;
	private DefaultTableModel model;
	private JTable table;
	private JTextField txtChucVu;

	/**
	 * Create the panel.
	 */
	public NhanVien_BH_JPanel() {

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
		panel_1.setBounds(0, 0, 1016, 55);
		panel.add(panel_1);

		JLabel lblThngTinNhn = new JLabel("Thông Tin Nhân Viên");
		lblThngTinNhn.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinNhn.setForeground(Color.WHITE);
		lblThngTinNhn.setFont(font_btn20);
		lblThngTinNhn.setBounds(322, 10, 441, 35);
		panel_1.add(lblThngTinNhn);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng Tin Nh\u00E2n Vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_3.setBounds(10, 65, 1006, 160);
		panel_3.setBackground(Color.white);
		panel.add(panel_3);

		JLabel lblTnNhnVin = new JLabel("Tên nhân viên :");
		lblTnNhnVin.setFont(font_pln13);
		lblTnNhnVin.setBounds(102, 38, 94, 25);
		panel_3.add(lblTnNhnVin);

		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setEditable(false);
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(194, 38, 205, 23);
		panel_3.add(txtTenNhanVien);

		JLabel lblChcV = new JLabel("Chức vụ :");
		lblChcV.setFont(font_pln13);
		lblChcV.setBounds(533, 35, 94, 25);
		panel_3.add(lblChcV);

		JLabel lblMNhnVin_1_1 = new JLabel("Giới tính :");
		lblMNhnVin_1_1.setFont(font_pln13);
		lblMNhnVin_1_1.setBounds(533, 70, 94, 25);
		panel_3.add(lblMNhnVin_1_1);

		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		txtSDT.setBounds(194, 73, 205, 23);
		panel_3.add(txtSDT);

		JLabel lblMNhnVin_1_3 = new JLabel("Số điện thoại :");
		lblMNhnVin_1_3.setFont(font_pln13);
		lblMNhnVin_1_3.setBounds(102, 73, 94, 25);
		panel_3.add(lblMNhnVin_1_3);

		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(194, 108, 582, 23);
		panel_3.add(txtDiaChi);

		JLabel lblMNhnVin_1_4 = new JLabel("Địa chỉ :");
		lblMNhnVin_1_4.setFont(font_pln13);
		lblMNhnVin_1_4.setBounds(102, 108, 94, 25);
		panel_3.add(lblMNhnVin_1_4);

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

		txtChucVu = new JTextField();
		txtChucVu.setEditable(false);
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(625, 38, 149, 23);
		panel_3.add(txtChucVu);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "Danh S\u00E1ch Nh\u00E2n Vi\u00EAn", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 235, 1006, 426);
		panel_4.setBackground(Color.white);
		panel.add(panel_4);

		String row[] = { "Tên nhân viên", "Chức vụ", "Giới tính", "Số điện thoại", "Địa chỉ" };
		model = new DefaultTableModel(row, 0);
		table = new JTable(model);
		JTableHeader a = table.getTableHeader();
		a.setBackground(Color.decode(cl_green));
		a.setForeground(Color.white);
		a.setFont(new Font("Tahoma", Font.BOLD, 10));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setBounds(10, 22, 986, 382);
		panel_4.add(scrollPane);
		
		docDL();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtTenNhanVien.setText(table.getValueAt(row, 0).toString());
				txtChucVu.setText(table.getValueAt(row, 1).toString());
				if (table.getValueAt(row, 2).toString() == "Nam") {
					rbnNam.setSelected(true);
				} else {
					rbnNu.setSelected(true);
				}
				txtSDT.setText(table.getValueAt(row, 3).toString());
				txtDiaChi.setText(table.getValueAt(row, 4).toString());
			}
		});
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
			model.addRow(new Object[] { e.getTenNhanVien(), e.getChucVu(), gt, e.getsDT(), e.getDiaChi() });
		});
	}
}
