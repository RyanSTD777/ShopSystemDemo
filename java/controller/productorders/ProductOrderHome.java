package controller.productorders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Users;
import util.Tools;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductOrderHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductOrderHome frame = new ProductOrderHome();
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
	public ProductOrderHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 250, 450, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(92, 33, 252, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("俗俗賣蔬菜行");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		lblNewLabel.setBounds(47, 6, 158, 34);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(23, 89, 391, 154);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
			
		JLabel welcomeMsg = new JLabel("");
		welcomeMsg.setForeground(new Color(0, 0, 255));
		welcomeMsg.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		welcomeMsg.setBounds(23, 10, 391, 23);
		contentPane.add(welcomeMsg);
		
		Users member=(Users)Tools.readFile("data/user.txt");
		String show="<<"+member.getMemberLevel()+" "+member.getName()+", 您好>>";
		welcomeMsg.setText(show);
		
		JButton btnNewButton_2 = new JButton("蔬菜市集");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					OrderAdd orderadd = new OrderAdd();
					orderadd.setVisible(true);
					dispose();
			}
		});
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_2.setBounds(38, 30, 133, 37);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("我的訂單");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyOrder myorder = new MyOrder();
				myorder.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.setBounds(212, 30, 133, 37);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton("退出系統");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(ProductOrderHome.this,"您是否要退出系統","系統登入",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
						System.exit(0);
					}
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(125, 91, 133, 37);
		panel_1.add(btnNewButton_1_1);

	}
}
