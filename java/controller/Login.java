package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.AddMember;
import controller.member.LoginError;
import controller.member.LoginSuccess;
import model.Users;
import service.impl.EmployeeServiceImpl;
import service.impl.MemberServiceImpl;
import util.Tools;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 250, 278, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 10, 210, 53);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("系統登入");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel.setBounds(50, 10, 101, 33);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(32, 73, 210, 79);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("帳號:");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(29, 10, 46, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼:");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(29, 45, 46, 25);
		panel_1.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setBounds(85, 12, 96, 21);
		panel_1.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(85, 47, 96, 21);
		panel_1.add(password);
		password.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(30, 162, 212, 28);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username = username.getText();
				String Password = password.getText();
				
				Users msi = new MemberServiceImpl().login(Username, Password);
				Users esi = new EmployeeServiceImpl().login(Username, Password);
				
				if(msi!=null||esi!=null)
				{
					if(msi!=null)
					{
						Tools.saveFile(msi, "user.txt");
					}else
					{
						Tools.saveFile(esi, "user.txt");
					}
					LoginSuccess loginSuccess = new LoginSuccess();
					loginSuccess.setVisible(true);
					dispose();
				}
				else
				{
					LoginError loginError = new LoginError();
					loginError.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton.setBounds(24, 0, 74, 23);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMember addmember = new AddMember();
				addmember.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1.setBounds(120, 0, 74, 23);
		panel_2.add(btnNewButton_1);
		
		JLabel VersionLabel = new JLabel("Beta 1.0");
		VersionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		VersionLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		VersionLabel.setBounds(188, 195, 54, 15);
		contentPane.add(VersionLabel);

	}
}
