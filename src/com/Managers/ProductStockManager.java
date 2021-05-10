package com.Managers;

import java.util.ArrayList;

import com.constants.GoodsType;
import com.constants.Units;


import Entities.Product;
import Entities.StockItem;

public class ProductStockManager {
	
	private static ProductStockManager instance = new ProductStockManager();
	private ProductStockManager() {
	}

	public static ProductStockManager getInstance() {
		return instance;
	}
	
	/*public Product createProduct(String name, GoodsType type) {
		Product product = new Product(name, type);
		product.setName(name);
		product.setType(type);
		return product;
	}*/
	
	public StockItem createStockItem(String product, int qty, Units unit, GoodsType type) {
		StockItem stockItem = new StockItem(product, qty, unit, type);
		stockItem.setProduct(product);
		stockItem.setQty(qty);
		stockItem.setUnit(unit);
		return stockItem;		
	}
	

}
