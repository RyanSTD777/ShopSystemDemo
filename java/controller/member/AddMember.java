package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Login;
import model.Users;
import service.impl.MemberServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddMember extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField phone;
	private JComboBox<String> memberSelect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMember frame = new AddMember();
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
	public AddMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 332, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 10, 281, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("註冊");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		lblNewLabel.setBounds(111, 10, 59, 29);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 70, 281, 191);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("名字:");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(39, 10, 46, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號:");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(39, 46, 46, 30);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("密碼:");
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(39, 82, 46, 30);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("手機:");
		lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_1_1.setBounds(39, 118, 46, 30);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		name = new JTextField();
		name.setBounds(95, 10, 144, 31);
		panel_1.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(95, 46, 144, 31);
		panel_1.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(95, 82, 144, 31);
		panel_1.add(password);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(95, 118, 144, 31);
		panel_1.add(phone);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("會員:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_1_1_1.setBounds(39, 154, 46, 30);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		memberSelect = new JComboBox<>();
		memberSelect.setModel(new DefaultComboBoxModel<>(new String[] {"銅會員", "銀會員", "金會員"}));
		memberSelect.setBounds(95, 154, 144, 31);
		panel_1.add(memberSelect);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(22, 271, 281, 38);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("送出");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name = name.getText().trim();
				String UserName = username.getText().trim();
				String Password = password.getText().trim();
				String Phone = phone.getText().trim();
				String MemberLevel = memberSelect.getSelectedItem().toString();
				if (Name.isEmpty() || UserName.isEmpty() || Password.isEmpty() || Phone.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"部分資料為空，未填寫完整！", "錯誤提示", JOptionPane.INFORMATION_MESSAGE);
			        return;
			    }
				else
				{				
					Users member = new Users(Name,UserName,Password,Phone,"member",MemberLevel);		
					if(new MemberServiceImpl().addMember(member))
					{
						AddMemberSuccess addMemberSuccss = new AddMemberSuccess();
						addMemberSuccss.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"帳號重複，請更換其他帳！","錯誤提示",JOptionPane.INFORMATION_MESSAGE);
						name.setText("");
						username.setText("");
						password.setText("");
						phone.setText("");
						return;
					}
				}
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.setBounds(97, 0, 85, 33);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("清空");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("");
				username.setText("");
				password.setText("");
				phone.setText("");
				
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_1.setBounds(0, 0, 85, 33);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("返回");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(196, 0, 85, 33);
		panel_2.add(btnNewButton_1_1);

	}
}
