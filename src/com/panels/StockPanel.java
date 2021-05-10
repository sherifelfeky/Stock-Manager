package com.panels;

// Java program to implement
// a Simple Registration Form
// using Java Swing
  
import javax.swing.*;

import com.Managers.ProductStockManager;
import com.constants.GoodsType;
import com.constants.Units;
import com.daos.Items;

import Entities.Product;
import Entities.StockItem;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;
  
class StockPanel
    extends JFrame
    implements ActionListener {
  
    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel touttitle2;
    private JLabel touttitle3;
    private JLabel name;
    private JTextField tname;
    private JTextField used;
    private JLabel mno;
    private JComboBox tmno;
    private JLabel mno2;
    private JComboBox tmno2;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel add;
    private JLabel addNew;
    private JLabel newIdfield;
    private JTextArea tadd;
    private JCheckBox term;
    private JButton sub;
    private JTextField setintstock;
    private JTextField newName;
    private JTextField newId;
    private JButton save;
    private JButton saveNew;
    private JButton plus;
    private JButton minus;
    private JTextArea tout;
    private JTextArea tout2;
    private JLabel res;
    private JTextArea resadd;
  
   
    String[] GoodsTypeEnumArray = {"Dairy", "Meat","Fruit","Vegetable","Cleaning", "Snacks"  };
    String[] UnitsArray = {"KG", "Litre","Bottle", "Pack", "Bag","Box" };
    String[] ProductNames = {"Lamar", "Maraey", "Orange", "Toamto"};
    
    
   
    /*private String years[]
        = { "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019" };*/
  
    // constructor, to initialize the components
    // with default values.
    public StockPanel()
    {
        setTitle("Product ");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
  
        c = getContentPane();
        c.setLayout(null);
  
        title = new JLabel("Stock Manager");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);
        
        touttitle2 = new JLabel("Viewer");
        touttitle2.setFont(new Font("Arial", Font.PLAIN, 15));
        touttitle2.setSize(150, 15);
        touttitle2.setLocation(500, 70);
        c.add(touttitle2);
        
        /*touttitle3 = new JLabel("Logger");
        touttitle3.setFont(new Font("Arial", Font.PLAIN, 15));
        touttitle3.setSize(150, 15);
        touttitle3.setLocation(850, 70);
        c.add(touttitle3);*/
  
        name = new JLabel("Product Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(150, 20);
        name.setLocation(80, 100);
        c.add(name);
  
        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(300, 100);
        c.add(tname);
        
        used = new JTextField();
        used.setFont(new Font("Arial", Font.PLAIN, 15));
        used.setSize(190, 20);
        used.setLocation(300, 170);
        c.add(used);
        
        
        
  
        mno = new JLabel("Goods Type");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(150, 20);
        mno.setLocation(80, 260);
        c.add(mno);
  
        tmno = new JComboBox(GoodsTypeEnumArray);
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(150, 20);
        tmno.setLocation(300, 260);
        c.add(tmno);
        
        mno2 = new JLabel("Units");
        mno2.setFont(new Font("Arial", Font.PLAIN, 20));
        mno2.setSize(150, 20);
        mno2.setLocation(80, 290);
        c.add(mno2);
  
        tmno2 = new JComboBox(UnitsArray);
        tmno2.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno2.setSize(150, 20);
        tmno2.setLocation(300, 290);
        c.add(tmno2);
        
        add = new JLabel("Initial Stock");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(150, 20);
        add.setLocation(80, 320);
        c.add(add);
        
        add = new JLabel("Or Reset Stock");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(150, 20);
        add.setLocation(80, 340);
        c.add(add);
  
        setintstock = new JTextField();
        setintstock.setFont(new Font("Arial", Font.PLAIN, 15));
        setintstock.setSize(190, 20);
        setintstock.setLocation(300, 320);        
        c.add(setintstock);
        
        
        addNew = new JLabel("New Product Name");
        addNew.setFont(new Font("Arial", Font.PLAIN, 20));
        addNew.setSize(170, 20);
        addNew.setLocation(80, 400);
        c.add(addNew);
  
        newName = new JTextField();
        newName.setFont(new Font("Arial", Font.PLAIN, 15));
        newName.setSize(190, 20);
        newName.setLocation(300, 400);        
        c.add(newName);
        
        newIdfield = new JLabel("New Id");
        newIdfield.setFont(new Font("Arial", Font.PLAIN, 20));
        newIdfield.setSize(170, 20);
        newIdfield.setLocation(80, 370);
        c.add(newIdfield);
  
        newId = new JTextField();
        newId.setFont(new Font("Arial", Font.PLAIN, 15));
        newId.setSize(190, 20);
        newId.setLocation(300, 370);        
        c.add(newId);
        
  
        /*gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 200);
        c.add(gender);
  
        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 200);
        c.add(male);
  
        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 200);
        c.add(female);
  
        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);
  
        dob = new JLabel("DOB");
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        dob.setSize(100, 20);
        dob.setLocation(100, 250);
        c.add(dob);
  
        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 250);
        c.add(date);
  
        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(250, 250);
        c.add(month);
  
        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(320, 250);
        c.add(year);
  
       

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        c.add(term);
  */  
        sub = new JButton("View");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(300, 130);
        sub.addActionListener(this);
        c.add(sub);
        
        plus = new JButton("Add");
        plus.setFont(new Font("Arial", Font.PLAIN, 15));
        plus.setSize(60, 20);
        plus.setLocation(300, 200);
        plus.addActionListener(this);
        c.add(plus);
        
        minus = new JButton("Subtract");
        minus.setFont(new Font("Arial", Font.PLAIN, 15));
        minus.setSize(100, 20);
        minus.setLocation(380, 200);
        minus.addActionListener(this);
        c.add(minus);
  
       /* setintstock = new JButton("Set Initial Stock");
        setintstock.setFont(new Font("Arial", Font.PLAIN, 15));
        setintstock.setSize(100, 20);
        setintstock.setLocation(270, 450);
        setintstock.addActionListener(this);
        c.add(setintstock);*/
        
        /*save = new JButton("Save");
        save.setFont(new Font("Arial", Font.PLAIN, 15));
        save.setSize(100, 20);
        save.setLocation(300, 450);
        save.addActionListener(this);
        c.add(save);*/
        
        saveNew = new JButton("Save New Product");
        saveNew.setFont(new Font("Arial", Font.PLAIN, 15));
        saveNew.setSize(180, 20);
        saveNew.setLocation(300, 500);
        saveNew.addActionListener(this);
        c.add(saveNew);
  
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);
        
        tout2 = new JTextArea();
        tout2.setFont(new Font("Arial", Font.PLAIN, 15));
        tout2.setSize(300, 400);
        tout2.setLocation(850, 100);
        tout2.setLineWrap(true);
        tout2.setEditable(false);
        c.add(tout2);
  
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);
  

  
        setVisible(true);
    }
  
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        
    	
    	
    	if (e.getSource() == sub) {
    		
        	  String data =  (String) tname.getText();
        	  
        	
               
                
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "shixos123S$");
        				Statement stmt = conn.createStatement();) {
        			
                	String name = Items.LoadItemName(stmt, data); // Item name
                	
                	
                	int data2 = Items.loadItemQty(stmt, data); // Item Qty
            		String data3 = Integer.toString(data2);
            		
            		
            		String type = Items.LoadItemType(stmt, data); // Item type
            		String unit = Items.LoadItemUnit(stmt, data); // Item type
            		
            		
            		
            		tout.setText(name +": "+ data3 +" "+ unit + ", "+ type);
            		
                    tout.setEditable(false);
                    res.setText("Item Checked");
                    //{"Dairy", "Meat","Fruit","Vegetable","Cleaning"  };
        		} catch (SQLException e1) {
        			e1.printStackTrace();
        		}
                
                
            }

        else if(e.getSource() == save) {
        	
        	/*GoodsType goodsType = null;
            if (tmno.getSelectedIndex() == 0) {
            	goodsType = GoodsType.DAIRY;
            }
            if (tmno.getSelectedIndex() == 1) {
            	goodsType = GoodsType.MEAT;
            }
            if (tmno.getSelectedIndex() == 2) {
            	goodsType = GoodsType.FRUIT;
            }
            if (tmno.getSelectedIndex() == 3) {
            	goodsType = GoodsType.VEGTABLE;
            }
            if (tmno.getSelectedIndex() == 4) {
            	goodsType = GoodsType.CLEANING;
            }
            
            Units unit = null;
            if (tmno2.getSelectedIndex() == 0) {
            	unit = Units.KG;
            }
            if (tmno2.getSelectedIndex() == 1) {
            	unit = Units.LITER;
            }
            if (tmno2.getSelectedIndex() == 2) {
            	unit = Units.BOTTLE;
            }*/
            
        	String data =  (String) tname.getText();
        	String data2 = setintstock.getText();
        	
        	
        	  try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "shixos123S$");
      				Statement stmt = conn.createStatement();) {
        	int newQty=Integer.parseInt(data2);
        	Items.saveNewQty(stmt, data, newQty);
      	  
        	 
        	
      	  	} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        } 
        	  
        	  
        	  
        	  
        	  
        		 else if(e.getSource() == saveNew) {
        			 
        			 String data2 = setintstock.getText();
        			 String data5 = newId.getText();
        			 String newName1 = newName.getText();
        			 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "shixos123S$");
      				Statement stmt = conn.createStatement();) {
        	
        	String type = (String) tmno.getSelectedItem();
        	String unit = (String) tmno2.getSelectedItem();
        	
        	int newQty=Integer.parseInt(data2);
        	int id=Integer.parseInt(data5);
        	Items.addItem(stmt,id, newName1, newQty, type, unit);
      	  
        	 
        	
      	  	} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	   
        }
        		 else if(e.getSource() == plus) {
        			 
        			String data =  (String) tname.getText(); 
        			String data1 = used.getText();
        			int addedQty=Integer.parseInt(data1);
        			
        			 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "shixos123S$");
      				Statement stmt = conn.createStatement();) {
        				 int data2 = Items.loadItemQty(stmt, data); // Item Qty
        				 int newQty = addedQty+ data2;
        				 Items.saveNewQty(stmt, data, newQty);
        	
      	  
        	 
        	
      	  	} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	   
        }
    	
        		 else if(e.getSource() == minus) {
        			 
         			String data =  (String) tname.getText(); 
         			String data1 = used.getText();
         			int usedQty=Integer.parseInt(data1);
         			
         			 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "shixos123S$");
       				Statement stmt = conn.createStatement();) {
         				 int data2 = Items.loadItemQty(stmt, data); // Item Qty
         				 int newQty = data2 - usedQty;
         				 Items.saveNewQty(stmt, data, newQty);
         	
       	  
         	 
         	
       	  	} catch (SQLException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
         	   
         }
    	
       
}


}



/* 

String data1 = (String) tname.getSelectedItem();
String data
= setintstock.getText();
int i=Integer.parseInt(data);




ListIterator<StockItem> product1 = Items.stockItems.listIterator();
	while (product1.hasNext() ) {
	if (product1.next().getProduct().equalsIgnoreCase(data1)) {
	 int qtyIndex = product1.previousIndex();
	 int beforeUpdate = ((StockItem)Items.stockItems.get(qtyIndex)).getQty();
	((StockItem) Items.stockItems.get(qtyIndex)).setQty(i+beforeUpdate);
	


 
 


 
int lastIndex = Items.stockItems.size();
 tout2.append("\n Product Name: " +  ((StockItem) Items.stockItems.get(qtyIndex)).getProduct());
 tout2.append( " QTY: " +  ( (StockItem) Items.stockItems.get(qtyIndex)).getQty());
 tout2.append( " " +  ( (StockItem) Items.stockItems.get(qtyIndex)).getUnit());
 res.setText("Item saved");
break;
*/
/*
public class StockEditor  extends JFrame
implements ActionListener  {
	
	private Container c;
	private JLabel title;
	private JLabel name;
    private JTextField tname;
    private JLabel add;
    private JTextField setintstock;
    private JTextArea tout;
    private JLabel touttitle2;
    private JButton sub;
    private JButton view;
    private JLabel res;
    
	
	
	
	
	public StockEditor() {
	setTitle("Stock Editor");
    setBounds(300, 90, 900, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(true);

    c = getContentPane();
    c.setLayout(null);
	
    
    title = new JLabel("Stock Editor");
    title.setFont(new Font("Arial", Font.PLAIN, 30));
    title.setSize(300, 30);
    title.setLocation(300, 30);
    c.add(title);    
    
    touttitle2 = new JLabel("Viewer");
    touttitle2.setFont(new Font("Arial", Font.PLAIN, 15));
    touttitle2.setSize(150, 15);
    touttitle2.setLocation(500, 70);
    c.add(touttitle2);    
	
    name = new JLabel("Product Name");
    name.setFont(new Font("Arial", Font.PLAIN, 20));
    name.setSize(150, 20);
    name.setLocation(100, 100);
    c.add(name);

    tname = new JTextField();
    tname.setFont(new Font("Arial", Font.PLAIN, 15));
    tname.setSize(190, 20);
    tname.setLocation(300, 100);
    c.add(tname);
    
    
    add = new JLabel("Add Stock");
    add.setFont(new Font("Arial", Font.PLAIN, 20));
    add.setSize(150, 20);
    add.setLocation(100, 300);
    c.add(add);

    setintstock = new JTextField();
    setintstock.setFont(new Font("Arial", Font.PLAIN, 15));
    setintstock.setSize(190, 20);
    setintstock.setLocation(300, 300);        
    c.add(setintstock);
    
    tout = new JTextArea();
    tout.setFont(new Font("Arial", Font.PLAIN, 15));
    tout.setSize(600, 400);
    tout.setLocation(500, 100);
    tout.setLineWrap(true);
    tout.setEditable(false);
    c.add(tout);
    
    res = new JLabel("");
    res.setFont(new Font("Arial", Font.PLAIN, 20));
    res.setSize(500, 25);
    res.setLocation(100, 500);
    c.add(res); 
    
    
    
    //buttons
    
    sub = new JButton("Submit");
    sub.setFont(new Font("Arial", Font.PLAIN, 15));
    sub.setSize(100, 20);
    sub.setLocation(150, 350);
    sub.addActionListener(this);
    c.add(sub);
    
    view = new JButton("View");
    view.setFont(new Font("Arial", Font.PLAIN, 15));
    view.setSize(100, 20);
    view.setLocation(150, 150);
    view.addActionListener(this);
    c.add(view);
    

    setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

    	if (e.getSource() == view) {
        	  String productName
              = tname.getText();
        	  // Iterator<String> cityIterator = city.iterator();
        	  
        	  
        	  ListIterator<StockItem> product = ProductStockManager.stockItems.listIterator();
        	  while (product.hasNext() ) {
        		  
        	  if (product.next().getProduct().getName().equalsIgnoreCase(productName)) {
        		 int qtyIndex = product.previousIndex();
        		  
        		  tout.append("\n Product Name: " +  productName + " QTY avaialable: "  );
        		  tout.append(" " + ((StockItem)ProductStockManager.stockItems.get(qtyIndex)).getQty());
        		  tout.append(" " + ((StockItem)ProductStockManager.stockItems.get(qtyIndex)).getUnit());
        		
        	  }
        	 
        	  }
    	}
        	  if (e.getSource() == sub) {
            	  try {
        		  String productName1
                  = tname.getText();
            	  // Iterator<String> cityIterator = city.iterator();
            	  String data = setintstock.getText();
            	  int newQty=Integer.parseInt(data);
            	  
            	  
            	  ListIterator<StockItem> product1 = ProductStockManager.stockItems.listIterator();
            	  while (product1.hasNext() ) {
            		  
            	  if (product1.next().getProduct().getName().equalsIgnoreCase(productName1)) {
            		 int qtyIndex = product1.previousIndex();
            		  
            		  tout.append("\n Product Name: " +  productName1 + " QTY avaialable: "  );
            		  ((StockItem) ProductStockManager.stockItems.get(qtyIndex)).setQty(newQty+((StockItem)ProductStockManager.stockItems.get(qtyIndex)).getQty());
            		  tout.append(" " + ((StockItem)ProductStockManager.stockItems.get(qtyIndex)).getQty());
            		
            	  }
        	  

            	  }
            }
            	  catch(NumberFormatException ex) {
            		  System.out.println("NumberFormatException is occured"); 
            		  res.setText("Enter Correct Qty");
            	  }
            	  
        	  }
    	}
	private String toString(int qty) {
		// TODO Auto-generated method stub
		return null;
	}
	*/