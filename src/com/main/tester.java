/*package com.main;

import com.constants.GoodsType;
import com.constants.Units;


import Entities.Product;
import Entities.StockItem;
import com.Managers.ProductStockManager;
public class tester {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product = ProductStockManager.getInstance().createProduct("apple", GoodsType.FRUIT);
		StockItem stockItem = 	ProductStockManager.getInstance().createStockItem(product,10 , Units.KG);	
		
		Product product1 = ProductStockManager.getInstance().createProduct("orange", GoodsType.FRUIT);
		StockItem stockItem1 = 	ProductStockManager.getInstance().createStockItem(product,20 , Units.KG);	
		
		ProductStockManager.products.add(product);
		ProductStockManager.products.add(product1);
		
		System.out.println(" " + ((Product) ProductStockManager.products.get(1)).getName());
	}

	@Override
	public String toString() {
		return "tester [toString()=" + super.toString() + "]";
	}

}
// UserManager.getInstance().createUser(*/