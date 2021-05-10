package com.panels;
// Java program to implement
// a Simple Registration Form
// using Java Swing

import java.util.Iterator;
import java.util.ListIterator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import com.daos.Items;

import Entities.StockItem;

public class MainPanel {
	
	
    public static void main(String[] args) throws Exception
   
    {
    	Items.loadStockItems();
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			//new com.mysql.jdbc.Driver(); 
			            // OR
			//System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
		
		                // OR java.sql.DriverManager
		    //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    	
    	
    	StockPanel f = new StockPanel();
    	//StockEditor g = new StockEditor();
    }
}
