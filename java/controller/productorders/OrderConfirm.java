package controller.productorders;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ProductOrders;
import model.Users;
import service.impl.ProductOrdersServiceImpl;
import util.Tools;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderConfirm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderConfirm frame = new OrderConfirm();
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
	public OrderConfirm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 250, 408, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcomeMsg = new JLabel("");
		welcomeMsg.setForeground(new Color(0, 0, 255));
		welcomeMsg.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		welcomeMsg.setBounds(23, 10, 391, 23);
		contentPane.add(welcomeMsg);
		
		ProductOrders pdorder = (ProductOrders)Tools.readFile("data/porders.txt");
		Users member=(Users)Tools.readFile("data/user.txt");
		String show="<<"+member.getMemberLevel()+" "+member.getName()+", 您好>>";
		welcomeMsg.setText(show);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 51, 392, 279);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea showPorders = new JTextArea();
		showPorders.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		showPorders.setEditable(false);
		showPorders.setBounds(0, 0, 392, 279);
		panel.add(showPorders);
		showPorders.setText(Tools.getOrderDetailsText(pdorder,member));
		;
		
		JButton btnNewButton = new JButton("返回重新挑選");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderAdd orderadd = new OrderAdd();
				orderadd.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.setBounds(23, 340, 156, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("確認訂單");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ProductOrdersServiceImpl().addProductOrders(pdorder);
				OrderFinished orderfinished = new OrderFinished();
				orderfinished.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(170, 213, 255));
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1.setBounds(215, 340, 156, 36);
		contentPane.add(btnNewButton_1);
		
		

	}
}
