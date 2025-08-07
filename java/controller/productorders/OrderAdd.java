package controller.productorders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.ProductOrders;
import model.Users;
import util.Tools;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderAdd extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField acay;
	private JTextField carrot;
	private JTextField chinesecelery;
	private JTextField daikonradish;
	private JTextField onion;
	private JTextField spooncabbage;
	private JTextField sugarsnappea;
	private JTextField waterspinach;
	private JTextField welshonion;
	ProductOrders productOrders=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderAdd frame = new OrderAdd();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 250, 450, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(92, 33, 252, 46);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("俗俗賣蔬菜行");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		lblNewLabel.setBounds(47, 6, 158, 34);
		panel.add(lblNewLabel);
		
		JLabel welcomeMsg = new JLabel("");
		welcomeMsg.setForeground(new Color(0, 0, 255));
		welcomeMsg.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		welcomeMsg.setBounds(23, 10, 391, 23);
		contentPane.add(welcomeMsg);
		
		Users member=(Users)Tools.readFile("data/user.txt");
		String show="<<"+member.getMemberLevel()+" "+member.getName()+", 您好>>";
		welcomeMsg.setText(show);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 81, 438, 313);
		contentPane.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setPreferredSize(new Dimension(420, 1180)); //捲軸顯示高度
		panel_1.setLayout(null);
		
		
		
		JLabel item1_price = new JLabel("A菜(105元/1kg)");
		item1_price.setHorizontalAlignment(SwingConstants.CENTER);
		item1_price.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		item1_price.setBounds(27, 168, 180, 23);
		panel_1.add(item1_price);
		
		JLabel item2_price = new JLabel("胡蘿蔔(38元/1kg)");
		item2_price.setHorizontalAlignment(SwingConstants.CENTER);
		item2_price.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		item2_price.setBounds(224, 168, 180, 23);
		panel_1.add(item2_price);
		
		JLabel item3_price = new JLabel("芹菜(47元/1kg)");
		item3_price.setHorizontalAlignment(SwingConstants.CENTER);
		item3_price.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		item3_price.setBounds(27, 398, 180, 23);
		panel_1.add(item3_price);
		
		JLabel item4_price = new JLabel("蘿蔔(35元/1kg)");
		item4_price.setHorizontalAlignment(SwingConstants.CENTER);
		item4_price.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		item4_price.setBounds(224, 398, 180, 23);
		panel_1.add(item4_price);
		
		JLabel item5_price = new JLabel("洋蔥(42元/1kg)");
		item5_price.setHorizontalAlignment(SwingConstants.CENTER);
		item5_price.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		item5_price.setBounds(27, 628, 180, 23);
		panel_1.add(item5_price);
		
		JLabel item6_price = new JLabel("青江菜(94元/1kg)");
		item6_price.setHorizontalAlignment(SwingConstants.CENTER);
		item6_price.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		item6_price.setBounds(224, 628, 180, 23);
		panel_1.add(item6_price);
		
		JLabel item7_price = new JLabel("甜豆(117元/1kg)");
		item7_price.setHorizontalAlignment(SwingConstants.CENTER);
		item7_price.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		item7_price.setBounds(27, 858, 180, 23);
		panel_1.add(item7_price);
		
		JLabel item8_price = new JLabel("空心菜(134元/1kg)");
		item8_price.setHorizontalAlignment(SwingConstants.CENTER);
		item8_price.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		item8_price.setBounds(224, 858, 180, 23);
		panel_1.add(item8_price);
		
		JLabel item9_price = new JLabel("青蔥(152元/1kg)");
		item9_price.setHorizontalAlignment(SwingConstants.CENTER);
		item9_price.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		item9_price.setBounds(27, 1088, 180, 23);
		panel_1.add(item9_price);
		
		acay = new JTextField();
		acay.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		acay.setHorizontalAlignment(SwingConstants.CENTER);
		acay.setText("0");
		acay.setEditable(true);
		acay.setBounds(90, 201, 44, 29);
		panel_1.add(acay);
		acay.setColumns(10);
		
		carrot = new JTextField();
		carrot.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		carrot.setText("0");
		carrot.setHorizontalAlignment(SwingConstants.CENTER);
		carrot.setEditable(true);
		carrot.setColumns(10);
		carrot.setBounds(293, 201, 44, 29);
		panel_1.add(carrot);
		
		chinesecelery = new JTextField();
		chinesecelery.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		chinesecelery.setHorizontalAlignment(SwingConstants.CENTER);
		chinesecelery.setText("0");
		chinesecelery.setEditable(true);
		chinesecelery.setBounds(90, 431, 44, 29);
		panel_1.add(chinesecelery);
		chinesecelery.setColumns(10);
		
		daikonradish = new JTextField();
		daikonradish.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		daikonradish.setHorizontalAlignment(SwingConstants.CENTER);
		daikonradish.setText("0");
		daikonradish.setEditable(true);
		daikonradish.setBounds(293, 431, 44, 29);
		panel_1.add(daikonradish);
		daikonradish.setColumns(10);
		
		onion = new JTextField();
		onion.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		onion.setHorizontalAlignment(SwingConstants.CENTER);
		onion.setText("0");
		onion.setEditable(true);
		onion.setBounds(90, 661, 44, 29);
		panel_1.add(onion);
		onion.setColumns(10);
		
		spooncabbage = new JTextField();
		spooncabbage.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		spooncabbage.setHorizontalAlignment(SwingConstants.CENTER);
		spooncabbage.setText("0");
		spooncabbage.setEditable(true);
		spooncabbage.setBounds(293, 661, 44, 29);
		panel_1.add(spooncabbage);
		spooncabbage.setColumns(10);
		
		sugarsnappea = new JTextField();
		sugarsnappea.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		sugarsnappea.setHorizontalAlignment(SwingConstants.CENTER);
		sugarsnappea.setText("0");
		sugarsnappea.setEditable(true);
		sugarsnappea.setBounds(90, 891, 44, 29);
		panel_1.add(sugarsnappea);
		sugarsnappea.setColumns(10);
		
		waterspinach = new JTextField();
		waterspinach.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		waterspinach.setHorizontalAlignment(SwingConstants.CENTER);
		waterspinach.setText("0");
		waterspinach.setEditable(true);
		waterspinach.setBounds(293, 891, 44, 29);
		panel_1.add(waterspinach);
		waterspinach.setColumns(10);
		
		welshonion = new JTextField();
		welshonion.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		welshonion.setHorizontalAlignment(SwingConstants.CENTER);
		welshonion.setText("0");
		welshonion.setEditable(true);
		welshonion.setBounds(90, 1121, 44, 29);
		panel_1.add(welshonion);
		welshonion.setColumns(10);
		
		JLabel img_Item1 = new JLabel("");
		img_Item1.setIcon(new ImageIcon(OrderAdd.class.getResource("/controller/images/aChoy.png")));
		img_Item1.setBounds(54, 29, 128, 128);
		panel_1.add(img_Item1);
		
		JLabel img_Item2 = new JLabel("");
		img_Item2.setIcon(new ImageIcon(OrderAdd.class.getResource("/controller/images/carrot.png")));
		img_Item2.setBounds(253, 29, 128, 128);
		panel_1.add(img_Item2);
		
		JLabel img_Item3 = new JLabel("");
		img_Item3.setIcon(new ImageIcon(OrderAdd.class.getResource("/controller/images/chineseCelery.png")));
		img_Item3.setBounds(54, 259, 128, 128);
		panel_1.add(img_Item3);
		
		JLabel img_Item4 = new JLabel("");
		img_Item4.setIcon(new ImageIcon(OrderAdd.class.getResource("/controller/images/daikonRadish.png")));
		img_Item4.setBounds(253, 259, 128, 128);
		panel_1.add(img_Item4);
		
		JLabel img_Item5 = new JLabel("");
		img_Item5.setIcon(new ImageIcon(OrderAdd.class.getResource("/controller/images/onion.png")));
		img_Item5.setBounds(54, 489, 128, 128);
		panel_1.add(img_Item5);
		
		JLabel img_Item6 = new JLabel("");
		img_Item6.setIcon(new ImageIcon(OrderAdd.class.getResource("/controller/images/spoonCabbage.png")));
		img_Item6.setBounds(253, 489, 128, 128);
		panel_1.add(img_Item6);
		
		JLabel img_Item7 = new JLabel("");
		img_Item7.setIcon(new ImageIcon(OrderAdd.class.getResource("/controller/images/sugarSnapPea.png")));
		img_Item7.setBounds(54, 719, 128, 128);
		panel_1.add(img_Item7);
		
		JLabel img_Item8 = new JLabel("");
		img_Item8.setIcon(new ImageIcon(OrderAdd.class.getResource("/controller/images/waterSpinach.png")));
		img_Item8.setBounds(253, 719, 128, 128);
		panel_1.add(img_Item8);
		
		JLabel img_Item9 = new JLabel("");
		img_Item9.setIcon(new ImageIcon(OrderAdd.class.getResource("/controller/images/welshOnion.png")));
		img_Item9.setBounds(54, 949, 128, 128);
		panel_1.add(img_Item9);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductOrderHome poh = new ProductOrderHome();
				poh.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1.setBounds(10, 404, 94, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("清空");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				acay.setText("0");
				carrot.setText("0");
				chinesecelery.setText("0");
				daikonradish.setText("0");
				onion.setText("0");
				spooncabbage.setText("0");
				sugarsnappea.setText("0");
				waterspinach.setText("0");
				welshonion.setText("0");
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(118, 404, 100, 29);
		contentPane.add(btnNewButton_1_1);
			
		JButton btnNewButton = new JButton("結帳");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				int ACay = Integer.parseInt(acay.getText());
				int Carrot = Integer.parseInt(carrot.getText());
				int ChineseCelery = Integer.parseInt(chinesecelery.getText());
				int DaikonRadish = Integer.parseInt(daikonradish.getText());
				int Onion = Integer.parseInt(onion.getText());
				int SpoonCabbage = Integer.parseInt(spooncabbage.getText());
				int SugarSnapPea = Integer.parseInt(sugarsnappea.getText());
				int WaterSpinach = Integer.parseInt(waterspinach.getText());
				int WelshOnion = Integer.parseInt(welshonion.getText());
				
				ProductOrders p = new ProductOrders(member.getName(),ACay,Carrot,ChineseCelery,DaikonRadish,
						Onion,SpoonCabbage,SugarSnapPea,WaterSpinach,WelshOnion);
				Tools.saveFile(p, "data/porders.txt");
				
				} catch (NumberFormatException ex) {
				    JOptionPane.showMessageDialog(null, "請輸入有效的數字！", "輸入錯誤", JOptionPane.ERROR_MESSAGE);
				    return;
				}
				
				OrderConfirm oconfirm = new OrderConfirm();
				oconfirm.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(170, 213, 255));
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.setBounds(228, 404, 186, 29);
		contentPane.add(btnNewButton);
		
	}
}
