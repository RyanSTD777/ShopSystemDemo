package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductOrdersDao;
import model.ProductOrders;
import util.DbConnection;

public class ProductOrdersDaoImpl implements ProductOrdersDao{

	public static void main(String[] args) {
		//System.out.println(new ProductOrdersDaoImpl().checkOrderExists(1, "Jhon"));
		/*ProductOrders p=new ProductOrders("lin",2,1,4,0,2,0,0,1,0);
		new ProductOrdersDaoImpl().add(p);
		System.out.println(new ProductOrdersDaoImpl().selectAll());*/
		
		/*List<ProductOrders> l=new ProductOrdersDaoImpl().selectByName("Jay");
		int sum=0;
		int count=0;
		for(ProductOrders o:l)
		{
			System.out.println(o.getId()+"\t"+o.getName()+"\ta_cay:"+o.getaChoy());
			sum=sum+o.getaChoy();
			count++;
		}
		System.out.println("筆數: "+count+" 筆\t ,A菜共 "+sum+" 個");*/
		//System.out.println(new ProductOrdersDaoImpl().selectById(1));
		/*ProductOrders p=new ProductOrdersDaoImpl().selectById(1);
		p.setaChoy(3);
		new ProductOrdersDaoImpl().update(p);*/
		//ProductOrders p=new ProductOrdersDaoImpl().selectById(2);
		//new ProductOrdersDaoImpl().delete(p);
		//System.out.println(new ProductOrdersDaoImpl().selectByName("Jay"));

	}
	private static Connection conn = DbConnection.getDb();
	@Override
	public void add(ProductOrders productorders) {
		String sql ="insert into product_orders(name, a_choy, carrot, chinese_celery, daikon_radish, onion, spoon_cabbage, sugar_snap_pea, water_spinach, welsh_onion) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, productorders.getName());
			ps.setInt(2, productorders.getaChoy());
			ps.setInt(3, productorders.getCarrot());
			ps.setInt(4, productorders.getChineseCelery());
			ps.setInt(5, productorders.getDaikonRadish());
			ps.setInt(6, productorders.getOnion());
			ps.setInt(7, productorders.getSpoonCabbage());
			ps.setInt(8, productorders.getSugarSnapPea());
			ps.setInt(9, productorders.getWaterSpinach());
			ps.setInt(10, productorders.getWelshOnion());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ProductOrders> selectAll() {
		String sql = "select * from product_orders";
		List<ProductOrders> productList=new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				ProductOrders p = new ProductOrders();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setaChoy(rs.getInt("a_choy"));
				p.setCarrot(rs.getInt("carrot"));
				p.setChineseCelery(rs.getInt("chinese_celery"));
				p.setDaikonRadish(rs.getInt("daikon_radish"));
				p.setOnion(rs.getInt("onion"));
				p.setSpoonCabbage(rs.getInt("spoon_cabbage"));
				p.setSugarSnapPea(rs.getInt("sugar_snap_pea"));
				p.setWaterSpinach(rs.getInt("water_spinach"));
				p.setWelshOnion(rs.getInt("welsh_onion"));
				
				productList.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public List<ProductOrders> selectByName(String name) {
		String sql = "select * from product_orders where name=?";
		List<ProductOrders> productList=new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				ProductOrders p = new ProductOrders();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setaChoy(rs.getInt("a_choy"));
				p.setCarrot(rs.getInt("carrot"));
				p.setChineseCelery(rs.getInt("chinese_celery"));
				p.setDaikonRadish(rs.getInt("daikon_radish"));
				p.setOnion(rs.getInt("onion"));
				p.setSpoonCabbage(rs.getInt("spoon_cabbage"));
				p.setSugarSnapPea(rs.getInt("sugar_snap_pea"));
				p.setWaterSpinach(rs.getInt("water_spinach"));
				p.setWelshOnion(rs.getInt("welsh_onion"));
				
				productList.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
	
	@Override
	public ProductOrders selectById(int id) {
		String sql = "select *from product_orders where id=?";
		ProductOrders p=null;		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{
				p = new ProductOrders();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setaChoy(rs.getInt("a_choy"));
				p.setCarrot(rs.getInt("carrot"));
				p.setChineseCelery(rs.getInt("chinese_celery"));
				p.setDaikonRadish(rs.getInt("daikon_radish"));
				p.setOnion(rs.getInt("onion"));
				p.setSpoonCabbage(rs.getInt("spoon_cabbage"));
				p.setSugarSnapPea(rs.getInt("sugar_snap_pea"));
				p.setWaterSpinach(rs.getInt("water_spinach"));
				p.setWelshOnion(rs.getInt("welsh_onion"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public boolean checkOrderExists(int id, String name) {
		boolean exists = false;
		String sql = "select 1 from product_orders where id = ? and name = ?";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ResultSet rs = ps.executeQuery();
			exists = rs.next();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exists;
	}
	


	@Override
	public boolean checkOrderExists(int id) {
		boolean exists = false;
		String sql = "select 1 from product_orders where id = ?";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			exists = rs.next();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exists;
	}
	
	@Override
	public void update(ProductOrders productorders) {
		String sql ="update product_orders set a_choy=?, carrot=?, chinese_celery=?, daikon_radish=?, onion=?, "
					+ "spoon_cabbage=?, sugar_snap_pea=?, water_spinach=?, welsh_onion=? where id=?";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setInt(1, productorders.getaChoy());
			ps.setInt(2, productorders.getCarrot());
			ps.setInt(3, productorders.getChineseCelery());
			ps.setInt(4, productorders.getDaikonRadish());
			ps.setInt(5, productorders.getOnion());
			ps.setInt(6, productorders.getSpoonCabbage());
			ps.setInt(7, productorders.getSugarSnapPea());
			ps.setInt(8, productorders.getWaterSpinach());
			ps.setInt(9, productorders.getWelshOnion());
			ps.setInt(10, productorders.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(ProductOrders productorders) {
		String sql ="delete from product_orders where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, productorders.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
