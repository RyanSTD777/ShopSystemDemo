package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.employee.ProductOrderManager;
import controller.productorders.ProductOrderHome;
import model.Users;
import util.Tools;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginSuccess extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccess frame = new LoginSuccess();
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
	public LoginSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 250, 395, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 10, 349, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("登入成功");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel.setBounds(122, 10, 105, 28);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 66, 349, 63);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel welcomeMsg = new JLabel("");
		welcomeMsg.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeMsg.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		welcomeMsg.setBounds(10, 15, 329, 32);
		panel_1.add(welcomeMsg);
		
		Users member=(Users)Tools.readFile("user.txt");
		String show=member.getMemberLevel()+" "+member.getName()+", 歡迎回來~";
		welcomeMsg.setText(show);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(22, 139, 349, 48);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("點我進入系統");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(member.getMemberLevel().equals("管理員"))
				{
					ProductOrderManager pom = new ProductOrderManager();
					pom.setVisible(true);
					dispose();
				}
				else
				{
					ProductOrderHome poh = new ProductOrderHome();
					poh.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.setBounds(92, 0, 164, 33);
		panel_2.add(btnNewButton);

	}

}
