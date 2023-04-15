package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.HoaDon_Dao;

import entity.HoaDon;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;

import java.util.EventObject;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class HoaDon_JPanel extends JPanel {

	/**
	 * 
	 */
	private String cl_green = "#00c691";
	private String cl_greyblue = "#f0f6fb";
	private String cl_greenbold ="#015a06";
	private String cl_yellow = "#fcbe00";
	private String cl_black = "#222222";
	private Font font_btn16 = new Font("Arial", Font.BOLD, 16);
	private Font font_btn20 = new Font("Arial", Font.BOLD, 20);
	private Font font_btn13 = new Font("Arial", Font.BOLD, 13);
	private Font font_btnita = new Font("Arial", Font.ITALIC, 13);
	private Font font_thm10 = new Font("Tahoma", Font.BOLD, 10);
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTable table;
	private JTextField txtTrang;
	private HoaDon_Dao hd_dao;
	

	/**
	 * Create the panel.
	 */
	public HoaDon_JPanel() {
		
		hd_dao = new HoaDon_Dao();
		setSize(1015,683);
		setLayout(null);
		setBackground(Color.decode(cl_greyblue));
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode(cl_green));
		panel.setBounds(0, 0, 1005, 55);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblThngTinHa = new JLabel("Thông Tin Hóa Đơn");
		lblThngTinHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinHa.setForeground(new Color(255, 255, 255));
		lblThngTinHa.setFont(font_btn20);
		lblThngTinHa.setBounds(223, 10, 557, 35);
		panel.add(lblThngTinHa);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Danh S\u00E1ch H\u00F3a \u0110\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 98, 995, 402);
		add(panel_1);
		panel_1.setLayout(null);
		
		String row[] = {"Mã Hóa Đơn","Mã Nhân Viên","Tên Nhân Viên","Mã Khách Hàng","Tên Khách Hàng","Ngày Lập Hóa Đơn"};
		model = new DefaultTableModel(row,0);
		
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) {
				return false;
			};
		};
		JTableHeader a = table.getTableHeader();
		a.setBackground(Color.decode(cl_green));
		a.setForeground(Color.white);
		a.setFont(font_thm10);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 27, 975, 365);
		scrollPane.setBackground(Color.white);
		panel_1.add(scrollPane);
		
		JButton btnXemChiTit = new JButton("Xem Chi Tiết Hóa Đơn");
		btnXemChiTit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row==-1) {
					JOptionPane.showMessageDialog(null, "Phải chọn hóa đơn cần xem !");
				}
				else {
					new ChiTietHoaDon_JFrame(new HoaDon(table.getValueAt(row, 0).toString()) ).setVisible(true);
				}
				
			}
		});
		btnXemChiTit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXemChiTit.setIcon(new ImageIcon(HoaDon_JPanel.class.getResource("/image/info_30px.png")));
		btnXemChiTit.setForeground(Color.WHITE);
		btnXemChiTit.setBackground(Color.decode(cl_yellow));
		btnXemChiTit.setFont(new Font("Arial", Font.BOLD, 15));
		btnXemChiTit.setFocusPainted(false);
		btnXemChiTit.setBorder(null);
		btnXemChiTit.setBounds(21, 577, 240, 55);
		add(btnXemChiTit);
		
		JButton btnTrangDau = new JButton("");
		btnTrangDau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				denTrangDau();
			}
		});
		btnTrangDau.setIcon(new ImageIcon(HoaDon_JPanel.class.getResource("/image/skip_to_start_20px.png")));
		btnTrangDau.setFocusPainted(false);
		btnTrangDau.setBorder(null);
		btnTrangDau.setBackground(Color.decode(cl_green));
		btnTrangDau.setBounds(406, 530, 30, 25);
		add(btnTrangDau);
		
		JButton btnTrangTruoc = new JButton("");
		btnTrangTruoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				denTrangTruoc();
			}
		});
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
		
		JButton btnTrangSau = new JButton("");
		btnTrangSau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				denTrangSau();
				
			}
		});
		btnTrangSau.setIcon(new ImageIcon(HoaDon_JPanel.class.getResource("/image/fast_forward_20px.png")));
		btnTrangSau.setFocusPainted(false);
		btnTrangSau.setBorder(null);
		btnTrangSau.setBackground(Color.decode(cl_green));
		btnTrangSau.setBounds(525, 530, 30, 25);
		add(btnTrangSau);
		
		JButton btnTrangCuoi = new JButton("");
		btnTrangCuoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				denTrangCuoi();
			}
		});
		btnTrangCuoi.setIcon(new ImageIcon(HoaDon_JPanel.class.getResource("/image/end_20px.png")));
		btnTrangCuoi.setFocusPainted(false);
		btnTrangCuoi.setBorder(null);
		btnTrangCuoi.setBackground(Color.decode(cl_green));
		btnTrangCuoi.setBounds(562, 530, 30, 25);
		add(btnTrangCuoi);
		
		txtTrang.setText("1");
		DocDL(1,25);
	}
	public void DocDL(int fn,int ln) {
		List<HoaDon> listHD = hd_dao.phanTrangHoaDon(fn, ln);
		listHD.forEach(e -> {
			model.addRow(new Object[] {					
					e.getMaHoaDon(),e.getNhanVien().getMaNhanVien(),e.getNhanVien().getTenNhanVien(),e.getKhachHang().getMaKhachHang(),e.getKhachHang().getTenKhachHang(),e.getNgayDatHang()
			});
		});	
				
	}
	public void XoaDL() {
		model.getDataVector().removeAllElements();
	}
	public void denTrangSau() {
		int soLuong = hd_dao.soLuongHD();
		int soTrang = Integer.parseInt(txtTrang.getText());
		int trangLonNhat;
		if(soLuong%25==0) {
			trangLonNhat=soLuong/25;
		}
		else {
			trangLonNhat=soLuong/25 +1;
		}
		if(soTrang<trangLonNhat) {
			txtTrang.setText(String.valueOf(soTrang+1));
			int fn = 25*soTrang+1;
			int ln = fn+24;
			XoaDL();
			DocDL(fn, ln);	
			table.clearSelection();
			
			
		}
	}
	public void denTrangTruoc() {
		int trang = Integer.parseInt(txtTrang.getText());
		if (trang > 1) {
			txtTrang.setText(String.valueOf(trang - 1));
			int fn = 25 * (trang - 2) + 1;
			int ln = fn + 24;
			XoaDL();
			DocDL(fn, ln);
			table.clearSelection();
		}
	}
	public void denTrangDau() {
		txtTrang.setText("1");
		XoaDL();
		DocDL(1, 25);
		table.clearSelection();
	}
	public void denTrangCuoi() {
		int soLuong = hd_dao.soLuongHD();
		int trangCuoi;
		if(soLuong%25==0) {
			trangCuoi=soLuong/25;
		}
		else {
			trangCuoi=soLuong/25 +1;
		}
		int fn = (trangCuoi-1)*25+1;
		int ln = fn+24;
		XoaDL();
		DocDL(fn, ln);
		txtTrang.setText(String.valueOf(trangCuoi));
		table.clearSelection();
		
	}
	public void trangHienTai() {
		int trang = Integer.parseInt(txtTrang.getText());
		int ln = trang*25;
		int fn = ln-24;
		XoaDL();
		DocDL(fn, ln);
	}
	
}
