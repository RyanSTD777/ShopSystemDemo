package controller.employee;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Users;
import util.Tools;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductOrderManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductOrderManager frame = new ProductOrderManager();
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
	public ProductOrderManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 250, 450, 349);
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
		panel_1.setBounds(23, 89, 391, 194);
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
		
		JLabel lblNewLabel_1 = new JLabel("開發中...");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(300, 164, 68, 20);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("查看全部訂單");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AllOrder allorder =new AllOrder();
				allorder.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.setBounds(116, 10, 170, 33);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("退出系統");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductOrderManager productordermanager = new ProductOrderManager();
				if (JOptionPane.showConfirmDialog(productordermanager,"您是否要退出系統","系統登入",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
						System.exit(0);
					}
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1.setBounds(140, 108, 116, 33);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("訂單管理");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderManagement om = new OrderManagement();
				om.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_2.setBounds(140, 58, 116, 33);
		panel_1.add(btnNewButton_2);

	}
}
