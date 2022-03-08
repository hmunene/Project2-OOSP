package project2start;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Label;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import com.jgoodies.forms.factories.DefaultComponentFactory;


import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.AbstractListModel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;



public class MainFrame extends JPanel {
	private ProductCollection pc;
	private JLabel productData;
	private JTextField ID;
	private JTextField Name;
	private int count;
	private JButton push;
	private JTextField textField;
	private JTextField textField_1;
	private int delay;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_2;
	private JTextField textField_3;
	
	public MainFrame() {
		pc = new ProductCollection(
				"./data2.txt");
		
		count = 0;
		push = new JButton ("Update Quantity");
		push.setBounds(230, 220, 134, 23);
		push.addActionListener(new ButtonListener());
		setLayout(null);
		
		add (push);
		setBackground(new Color(255, 222, 173));
		setPreferredSize(new Dimension(800,800));
		
		JButton btnClearCount = new JButton("Remove");
		btnClearCount.setBounds(59, 220, 134, 23);
		btnClearCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 String btnClearCount = JOptionPane.showInputDialog("Enter an id of item to remove");
					 delay = Integer.parseInt(btnClearCount);
					 } catch (Exception e1) {
					 delay = -1;
					 }
			}
		});
		add(btnClearCount);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ian\\Desktop\\book\\bookstore-icon-template-creative-logo-design-vector-26921083 (100x99).jpg"));
		lblNewLabel.setBounds(567, -13, 105, 146);
		add(lblNewLabel);
		
		
		JButton btnSuggest = new JButton("Suggest");
		btnSuggest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 String btnSuggest = JOptionPane.showInputDialog("Enter a sugestion");
					 delay = Integer.parseInt(btnSuggest);
					 } catch (Exception e2) {
					 delay = -1;
					 }
		 	}
		 });
		btnSuggest.setBounds(398, 220, 134, 23);
		add(btnSuggest);
		
		JLabel lblBookStoreInventory = DefaultComponentFactory.getInstance().createTitle("Book Store Inventory");
		lblBookStoreInventory.setFont(new Font("Andalus", Font.PLAIN, 46));
		lblBookStoreInventory.setBounds(111, 21, 436, 55);
		add(lblBookStoreInventory);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(24, 342, 46, 14);
		add(lblId);
		
		ID = new JTextField();
		ID.setBounds(64, 339, 86, 20);
		add(ID);
		ID.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(24, 398, 46, 14);
		add(lblName);
		
		Name = new JTextField();
		Name.setBounds(64, 395, 86, 20);
		add(Name);
		Name.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 336, 490, 245);
		add(scrollPane);
	 
		 JTextArea textArea = new JTextArea();
		 textArea.setBounds(145, 342, 599, 227);
		 textArea.setEditable(false);
		 textArea.setText(pc.toString());
		 scrollPane.setViewportView(textArea);
		 
		 JRadioButton rdbtnStudents = new JRadioButton("Students Only");
		 buttonGroup.add(rdbtnStudents);
		 rdbtnStudents.setBounds(316, 271, 109, 23);
		 add(rdbtnStudents);
		 
		 JRadioButton rdbtnInstructorOnly = new JRadioButton("Instructor Only");
		 buttonGroup.add(rdbtnInstructorOnly);
		 rdbtnInstructorOnly.setBounds(59, 271, 109, 23);
		 add(rdbtnInstructorOnly);
		 
		 JButton btnAddItem = new JButton("Add Item");
		 btnAddItem.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		String id = ID.getText();
			 		int idInt = Integer.parseInt(id); 
//			 		String name = Name.getText();
//			 		int NameString = Integer.parseInt(name); 
//			 		String price = ID.getText();
//			 		int priceDouble = Integer.parseInt(price); 
//			 		String quantity = ID.getText();
//			 		int quantityInt = Integer.parseInt(quantity); 
//			 		
			 		// get the rest of the boxes
			 		Product newP = new Product (idInt);
			 		pc.writeFile("./data2.txt");
			 	}
			 });
		 btnAddItem.setBounds(64, 543, 89, 23);
		 add(btnAddItem);
		 
		 textField_2 = new JTextField();
		 textField_2.setBounds(64, 447, 86, 20);
		 add(textField_2);
		 textField_2.setColumns(10);
		 
		 textField_3 = new JTextField();
		 textField_3.setBounds(64, 494, 86, 20);
		 add(textField_3);
		 textField_3.setColumns(10);
		 
		 JLabel lblPrice = new JLabel("Price:");
		 lblPrice.setBounds(24, 450, 46, 14);
		 add(lblPrice);
		 
		 JLabel lblQuantity = new JLabel("Quantity:");
		 lblQuantity.setBounds(10, 497, 46, 14);
		 add(lblQuantity);
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(179, 103, 185, 94);
		 add(scrollPane_1);
		 
		 JList list = new JList();
		 list.setModel(new AbstractListModel() {
		 	String[] values = new String[] {"Category 1", "Category 2", "Category 3", "Category 4", "Category 5", "Category 6"};
		 	public int getSize() {
		 		return values.length;
		 	}
		 	public Object getElementAt(int index) {
		 		return values[index];
		 	}
		 });
		 scrollPane_1.setViewportView(list);
		 
		 JMenuBar menuBar = new JMenuBar();
		 menuBar.setBounds(0, 0, 101, 22);
		 add(menuBar);
		 	 
		 JMenu mnFile = new JMenu("File");
		 menuBar.add(mnFile);
		 
		 JMenu mnEdit = new JMenu("Edit");
		 menuBar.add(mnEdit);
		 
		 JLabel lblCurrentItemsIn = DefaultComponentFactory.getInstance().createTitle("Current Items in Stock:");
		 lblCurrentItemsIn.setFont(new Font("Andalus", Font.PLAIN, 15));
		 lblCurrentItemsIn.setBounds(302, 311, 206, 23);
		 add(lblCurrentItemsIn);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed (ActionEvent event){
			 try {
				 String push = JOptionPane.showInputDialog("Enter an integer 0-100");
				 delay = Integer.parseInt(push);
				 } catch (Exception e) {
				 delay = -1;
				 }
		}
	}
	public void doWrite() {
		pc.writeFile("./testwrite.txt");
	}
}
