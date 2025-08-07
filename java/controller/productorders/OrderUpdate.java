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
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderUpdate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static  ProductOrdersServiceImpl psi=new ProductOrdersServiceImpl();
	private JTextField orders_id;
	private JTextField acay;
	private JTextField daikonradish;
	private JTextField sugarsnappea;
	private JTextField carrot;
	private JTextField onion;
	private JTextField waterspinach;
	private JTextField chinesecelery;
	private JTextField spooncabbage;
	private JTextField welshonion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderUpdate frame = new OrderUpdate();
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
	public OrderUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 250, 450, 342);
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
		panel.setBounds(0, 36, 434, 211);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("訂單編號:");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(23, 20, 79, 29);
		panel.add(lblNewLabel);
		
		orders_id = new JTextField();
		orders_id.setHorizontalAlignment(SwingConstants.CENTER);
		orders_id.setText("0");
		orders_id.setBounds(104, 22, 40, 29);
		panel.add(orders_id);
		orders_id.setColumns(10);
		
		JLabel lblA = new JLabel("A菜:");
		lblA.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblA.setBounds(23, 67, 62, 29);
		panel.add(lblA);
		
		acay = new JTextField();
		acay.setHorizontalAlignment(SwingConstants.CENTER);
		acay.setText("0");
		acay.setColumns(10);
		acay.setBounds(89, 67, 40, 29);
		panel.add(acay);
		
		JLabel lblA_1 = new JLabel("蘿蔔:");
		lblA_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblA_1.setBounds(23, 116, 62, 29);
		panel.add(lblA_1);
		
		daikonradish = new JTextField();
		daikonradish.setHorizontalAlignment(SwingConstants.CENTER);
		daikonradish.setText("0");
		daikonradish.setColumns(10);
		daikonradish.setBounds(89, 116, 40, 29);
		panel.add(daikonradish);
		
		JLabel lblA_1_1 = new JLabel("甜豆:");
		lblA_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblA_1_1.setBounds(23, 162, 62, 29);
		panel.add(lblA_1_1);
		
		sugarsnappea = new JTextField();
		sugarsnappea.setHorizontalAlignment(SwingConstants.CENTER);
		sugarsnappea.setText("0");
		sugarsnappea.setColumns(10);
		sugarsnappea.setBounds(89, 162, 40, 29);
		panel.add(sugarsnappea);
		
		carrot = new JTextField();
		carrot.setHorizontalAlignment(SwingConstants.CENTER);
		carrot.setText("0");
		carrot.setColumns(10);
		carrot.setBounds(219, 67, 40, 29);
		panel.add(carrot);
		
		JLabel lblA_2 = new JLabel("胡蘿蔔:");
		lblA_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblA_2.setBounds(151, 67, 62, 29);
		panel.add(lblA_2);
		
		onion = new JTextField();
		onion.setHorizontalAlignment(SwingConstants.CENTER);
		onion.setText("0");
		onion.setColumns(10);
		onion.setBounds(219, 116, 40, 29);
		panel.add(onion);
		
		JLabel lblA_2_1 = new JLabel("洋蔥:");
		lblA_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblA_2_1.setBounds(151, 116, 62, 29);
		panel.add(lblA_2_1);
		
		waterspinach = new JTextField();
		waterspinach.setHorizontalAlignment(SwingConstants.CENTER);
		waterspinach.setText("0");
		waterspinach.setColumns(10);
		waterspinach.setBounds(219, 162, 40, 29);
		panel.add(waterspinach);
		
		JLabel lblA_2_1_1 = new JLabel("空心菜:");
		lblA_2_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblA_2_1_1.setBounds(151, 162, 62, 29);
		panel.add(lblA_2_1_1);
		
		chinesecelery = new JTextField();
		chinesecelery.setHorizontalAlignment(SwingConstants.CENTER);
		chinesecelery.setText("0");
		chinesecelery.setColumns(10);
		chinesecelery.setBounds(356, 67, 40, 29);
		panel.add(chinesecelery);
		
		JLabel lblA_2_1_1_1 = new JLabel("芹菜:");
		lblA_2_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblA_2_1_1_1.setBounds(288, 67, 62, 29);
		panel.add(lblA_2_1_1_1);
		
		spooncabbage = new JTextField();
		spooncabbage.setHorizontalAlignment(SwingConstants.CENTER);
		spooncabbage.setText("0");
		spooncabbage.setColumns(10);
		spooncabbage.setBounds(356, 116, 40, 29);
		panel.add(spooncabbage);
		
		JLabel lblA_2_1_1_1_1 = new JLabel("青江菜:");
		lblA_2_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblA_2_1_1_1_1.setBounds(288, 116, 62, 29);
		panel.add(lblA_2_1_1_1_1);
		
		welshonion = new JTextField();
		welshonion.setHorizontalAlignment(SwingConstants.CENTER);
		welshonion.setText("0");
		welshonion.setColumns(10);
		welshonion.setBounds(356, 162, 40, 29);
		panel.add(welshonion);
		
		JLabel lblA_2_1_1_1_1_1 = new JLabel("青蔥:");
		lblA_2_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblA_2_1_1_1_1_1.setBounds(288, 162, 62, 29);
		panel.add(lblA_2_1_1_1_1_1);
		JButton btnNewButton = new JButton("修改");
		btnNewButton.setBounds(60, 263, 98, 30);
		contentPane.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ID = Integer.parseInt(orders_id.getText());
				boolean exists = psi.checkOrderExistsByIdAndName(ID, member.getName());
				if(exists == true)
				{
					ProductOrders productOrders=new ProductOrders();
					int ACay = Integer.parseInt(acay.getText());
					int Carrot = Integer.parseInt(carrot.getText());
					int ChineseCelery = Integer.parseInt(chinesecelery.getText());
					int DaikonRadish = Integer.parseInt(daikonradish.getText());
					int Onion = Integer.parseInt(onion.getText());
					int SpoonCabbage = Integer.parseInt(spooncabbage.getText());
					int SugarSnapPea = Integer.parseInt(sugarsnappea.getText());
					int WaterSpinach = Integer.parseInt(waterspinach.getText());
					int WelshOnion = Integer.parseInt(waterspinach.getText());
					productOrders.setId(ID);
					productOrders.setaChoy(ACay);
					productOrders.setCarrot(Carrot);
					productOrders.setChineseCelery(ChineseCelery);
					productOrders.setDaikonRadish(DaikonRadish);
					productOrders.setOnion(Onion);
					productOrders.setSpoonCabbage(SpoonCabbage);
					productOrders.setSugarSnapPea(SugarSnapPea);
					productOrders.setWaterSpinach(WaterSpinach);
					productOrders.setWelshOnion(WelshOnion);
				
				psi.updateProductOrders(productOrders);
				JOptionPane.showMessageDialog(null,"訂單已修改", "修改成功", JOptionPane.INFORMATION_MESSAGE);
		        return;
				}
				else
				{
					JOptionPane.showMessageDialog(null,"您沒有該筆訂單", "修改失敗", JOptionPane.INFORMATION_MESSAGE);
			        return;
				}
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyOrder myorder = new MyOrder();
				myorder.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1.setBounds(249, 263, 98, 30);
		contentPane.add(btnNewButton_1);
		
		
	}
}
