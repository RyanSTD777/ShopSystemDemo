package controller.productorders;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ProductOrders;
import model.Users;
import service.impl.ProductOrdersServiceImpl;
import util.Tools;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderDelete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private static  ProductOrdersServiceImpl psi=new ProductOrdersServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDelete frame = new OrderDelete();
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
	public OrderDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 250, 431, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcomeMsg = new JLabel("");
		welcomeMsg.setForeground(new Color(0, 0, 255));
		welcomeMsg.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		welcomeMsg.setBounds(23, 10, 391, 23);
		contentPane.add(welcomeMsg);
		
		Users member=(Users)Tools.readFile("user.txt");
		String show="<<"+member.getMemberLevel()+" "+member.getName()+", 您好>>";
		welcomeMsg.setText(show);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 43, 414, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("訂單編號:");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel.setBounds(35, 21, 95, 25);
		panel.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(140, 21, 35, 28);
		panel.add(id);
		id.setColumns(10);
		
		JButton btnNewButton = new JButton("刪除");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ID = Integer.parseInt(id.getText());
				boolean exists = psi.checkOrderExistsByIdAndName(ID, member.getName());
				if(exists == true)
				{
					int orderID= Integer.parseInt(id.getText());
					ProductOrders productorders = new ProductOrders();
					productorders.setId(orderID);
					psi.deleteProductOrders(productorders);
					JOptionPane.showMessageDialog(null,"訂單已刪除", "刪除成功", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"您沒有該筆訂單", "刪除失敗", JOptionPane.INFORMATION_MESSAGE);
			        return;
				}
				
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.setBounds(201, 19, 85, 28);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyOrder myorder = new MyOrder();
				myorder.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1.setBounds(330, 32, 74, 33);
		panel.add(btnNewButton_1);
		
		

	}

}
