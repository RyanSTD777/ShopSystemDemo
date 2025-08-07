package service.impl;

import java.util.List;

import dao.impl.ProductOrdersDaoImpl;
import model.ProductOrders;
import service.ProductOrdersService;

public class ProductOrdersServiceImpl implements ProductOrdersService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static ProductOrdersDaoImpl pdi=new ProductOrdersDaoImpl();
	@Override
	public void addProductOrders(ProductOrders productorders) {
		pdi.add(productorders);
		
	}

	@Override
	public List<ProductOrders> findAllProductOrders() {
		return pdi.selectAll();
	}
	@Override
	public List<ProductOrders> findProductOrdersByName(String name) {
		return pdi.selectByName(name);
	}	

	@Override
	public boolean checkOrderExistsByIdAndName(int id, String name) {
		return pdi.checkOrderExists(id, name);
	}

	@Override
	public boolean checkOrderExistsById(int id) {
		// TODO Auto-generated method stub
		return pdi.checkOrderExists(id);
	}
	
	@Override
	public boolean updateProductOrders(ProductOrders productorders) {
		ProductOrders p = pdi.selectById(productorders.getId());
		boolean isOrderExists=false;
		if(p!=null)
		{
			isOrderExists=true;
			pdi.update(productorders);
		}
		return isOrderExists;
	}

	@Override
	public boolean deleteProductOrders(ProductOrders productorders) {
		ProductOrders p = pdi.selectById(productorders.getId());
		boolean isOrderExists=false;
		if(p!=null)
		{
			isOrderExists=true;
			pdi.delete(productorders);
		}
		return isOrderExists;
	}

}
