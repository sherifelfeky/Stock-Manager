package Entities;

import com.constants.GoodsType;

public class Product {
		private String name;
		
		
		public Product (String name, GoodsType type){
			this.name = name;
			
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
}
