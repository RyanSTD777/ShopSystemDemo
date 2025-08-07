package controller.productorders;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ProductOrders;
import model.Users;
import service.impl.ProductOrdersServiceImpl;
import util.Tools;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTextArea;

public class MyOrder extends JFrame {

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
					MyOrder frame = new MyOrder();
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
	public MyOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 250, 708, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 37, 653, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("我的訂單");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		lblNewLabel.setBounds(273, 5, 119, 33);
		panel.add(lblNewLabel);
				
		JLabel welcomeMsg = new JLabel("");
		welcomeMsg.setForeground(new Color(0, 0, 255));
		welcomeMsg.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		welcomeMsg.setBounds(23, 10, 391, 23);
		contentPane.add(welcomeMsg);
		
		Users member=(Users)Tools.readFile("data/user.txt");
		String welcomeMsgshow="<<"+member.getMemberLevel()+" "+member.getName()+", 您好>>";
		welcomeMsg.setText(welcomeMsgshow);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(23, 91, 653, 206);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 653, 206);
		panel_1.add(scrollPane);
		
		
		List<ProductOrders> list=psi.findProductOrdersByName(member.getName());
		String mylistShow = Tools.formatOrderList(list);
		JTextArea orderList = new JTextArea();
		orderList.setEditable(false);
		scrollPane.setViewportView(orderList);		
		orderList.setText(mylistShow);
		//Tools.saveFile(list, "myorderlist.txt");
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(23, 307, 653, 62);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("修改訂單");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderUpdate orderupdate = new OrderUpdate();
				orderupdate.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1.setBounds(458, 0, 124, 42);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("取消訂單");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderDelete orderdelete = new OrderDelete();
				orderdelete.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(264, 0, 124, 42);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("返回主頁");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductOrderHome poh = new ProductOrderHome();
				poh.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1_1_1.setBounds(70, 0, 124, 42);
		panel_2.add(btnNewButton_1_1_1);

	}
}
