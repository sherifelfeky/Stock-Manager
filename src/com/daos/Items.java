package com.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JTextField;

import com.Managers.ProductStockManager;
import com.constants.GoodsType;
import com.constants.Units;
import com.panels.MainPanel;

import Entities.Product;
import Entities.StockItem;

public class Items {
	public static ArrayList <Product>products = new ArrayList<Product>();
	public static ArrayList <StockItem> stockItems = new ArrayList<StockItem>();
	public static List <String> namesListBeforeArray = new ArrayList<String>();
	
	
	     
	static StockItem lamar = ProductStockManager.getInstance().createStockItem("Lamar",0, Units.LITER,GoodsType.DAIRY );
	      
	static StockItem maraey = ProductStockManager.getInstance().createStockItem("Maraey",0, Units.LITER,GoodsType.DAIRY );
	
	
	public static void loadStockItems(){
		stockItems.add(lamar);	
		stockItems.add(maraey);
		
		
		// try-with-resources ==> conn & stmt will be closed
		// Connection string: <protocol>:<sub-protocol>:<data-source details>
		
		
		
	}
	
	
		public static int loadItemQty(Statement stmt, String data) throws SQLException {
			
			  String query = "SELECT qty from table1 WHERE productname = '"+ data +  "'";
              ResultSet rs = stmt.executeQuery(query);
              int quantity = 0;
              while(rs.next())
              {  
            	  quantity  = rs.getInt("qty");
             
              }
              return quantity;
			
			
	}


		public static String LoadItemType(Statement stmt, String data) throws SQLException {
			String query = "SELECT producttype from table1 WHERE productname = '"+ data +  "'";
            ResultSet rs = stmt.executeQuery(query);
            String type = null;
            while(rs.next())
            {  
          	  type  = rs.getString("producttype");
           
            }
			return type;
		}


		public static String LoadItemUnit(Statement stmt, String data) throws SQLException {
			
			String query = "SELECT unit from table1 WHERE productname = '"+ data +  "'";
            ResultSet rs = stmt.executeQuery(query);
            String unit = null;
            while(rs.next())
            {  
          	  unit  = rs.getString("unit");
           
            }
			return unit;
			
		}


		public static String LoadItemName(Statement stmt, String data) throws SQLException {
			String query = "SELECT productname from table1 WHERE productname = '"+ data +  "'";

         ResultSet rs = stmt.executeQuery(query);
         String name = null;
         while(rs.next())
         {  
       	  name  = rs.getString("productname");
         
         }
return name;
		
			
		}


		public static void saveNewQty(Statement stmt, String data, int newQty) throws SQLException {
			
			String query = "UPDATE `mydb`.`table1` SET `qty` = '"+ newQty +"' WHERE (`productname` = '"+ data + "')";
			stmt.executeUpdate(query);
			
			
			
		}


		public static void addItem(Statement stmt, int id, String newName, int newQty, String type, String unit) throws SQLException {
			
			String query = "INSERT INTO `mydb`.`table1` (`productid`, `productname`, `producttype`, `unit`, `qty`) VALUES ('"+id+"', '"+newName+"', '"+type+"', '"+unit+"', '"+newQty+"');";
			stmt.executeUpdate(query);
		}
	

}
