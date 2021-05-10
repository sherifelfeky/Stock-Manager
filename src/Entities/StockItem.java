package Entities;

import com.constants.GoodsType;
import com.constants.Units;
import java.util.Iterator;
import java.util.ListIterator;
public class StockItem {
	
	
	int qty;
	Units unit;
	private String product;
	private GoodsType type;
	
	public StockItem (String product, int qty, Units unit, GoodsType type){
			this.product = product;
			this.qty = qty;
			this.unit = unit;
			this.type = type;
		}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Units getUnit() {
		return unit;
	}

	public void setUnit(Units unit) {
		this.unit = unit;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	public GoodsType getType() {
		return type;
	}
	public void setType(GoodsType type) {
		this.type = type;
	}
	@Override
    public String toString() {
        return product;
    }
}
