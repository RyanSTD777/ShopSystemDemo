package service;

import java.util.List;

import model.ProductOrders;

public interface ProductOrdersService {
	//create
	void addProductOrders(ProductOrders productorders);
		
		
	//read
	List<ProductOrders> findAllProductOrders();	
	List<ProductOrders> findProductOrdersByName(String name);
	boolean checkOrderExistsByIdAndName(int id, String name);
	boolean checkOrderExistsById(int id);
		
	//update
	boolean updateProductOrders(ProductOrders productorders);
		
	//delete
	boolean deleteProductOrders(ProductOrders productorders);

}