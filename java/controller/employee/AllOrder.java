package controller.employee;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import model.ProductOrders;
import model.Users;
import service.impl.ProductOrdersServiceImpl;
import util.Tools;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AllOrder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static  ProductOrdersServiceImpl psi=new ProductOrdersServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllOrder frame = new AllOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AllOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 250, 676, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 37, 619, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("全部訂單");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		lblNewLabel.setBounds(250, 5, 119, 33);
		panel.add(lblNewLabel);
				
		JLabel welcomeMsg = new JLabel("");
		welcomeMsg.setForeground(new Color(0, 0, 255));
		welcomeMsg.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		welcomeMsg.setBounds(23, 10, 391, 23);
		contentPane.add(welcomeMsg);
		
		Users member=(Users)Tools.readFile("user.txt");
		String welcomeMsgshow="<<"+member.getMemberLevel()+" "+member.getName()+", 您好>>";
		welcomeMsg.setText(welcomeMsgshow);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(23, 91, 619, 206);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 619, 206);
		panel_1.add(scrollPane);
		
		List<ProductOrders> list=psi.findAllProductOrders();
		String mylistShow = Tools.formatOrderList(list);
		JTextArea orderList = new JTextArea();
		orderList.setEditable(false);
		scrollPane.setViewportView(orderList);		
		orderList.setText(mylistShow);
		//Tools.saveFile(list, "myorderlist.txt");
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(23, 307, 619, 62);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("返回主頁");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductOrderManager pom = new ProductOrderManager();
				pom.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.setBounds(356, 10, 170, 42);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("訂單管理");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderManagement om = new OrderManagement();
				om.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1.setBounds(93, 10, 170, 42);
		panel_2.add(btnNewButton_1);
		
	}
}
