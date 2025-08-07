package dao;

import java.util.List;

import model.ProductOrders;

public interface ProductOrdersDao {
	//create
		void add(ProductOrders productorders);
		
		
		//read
		List<ProductOrders> selectAll();
		List<ProductOrders> selectByName(String name);
		boolean checkOrderExists(int id, String name);
		boolean checkOrderExists(int id);
		ProductOrders selectById(int id);
		
		//update
		void update(ProductOrders productorders);
		
		//delete
		void delete(ProductOrders productorders);
}
