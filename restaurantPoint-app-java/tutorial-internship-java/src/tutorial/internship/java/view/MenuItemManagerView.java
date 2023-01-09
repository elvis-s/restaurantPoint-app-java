package tutorial.internship.java.view;

import java.awt.Color; 
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.TableView.TableRow;

import tutorial.internship.java.model.Menu;
import tutorial.internship.java.model.MenuItem;
import tutorial.internship.java.model.RestaurantData;
import tutorial.internship.java.model.User;
import tutorial.internship.login.dataproviders.RestaurantDataProvider;
import tutorial.internship.login.dataproviders.UserDataProvider;


@SuppressWarnings("serial")
public class MenuItemManagerView extends JPanel {
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JTable table;
	DefaultTableModel model;

	//private Object String;

	private Object ResaurantDataProvider;

	private String menuName;
	

	public MenuItemManagerView() {
		prepareView();
	}
	public void prepareView() {
		setVisible(true);
		setLayout(null);
		this.setBounds(266, 0, 704, 582);
		prepareRestaurantsComponents();
		
	}

	private void prepareRestaurantsComponents() {
		
		//Restaurant Manager Panel
		JPanel menuItemManagerPanel = new JPanel();
		menuItemManagerPanel.setBounds(0, 0, 704, 582);
		TitledBorder contentTitleBorder = BorderFactory.createTitledBorder("Menu Item Manager");
		menuItemManagerPanel.setBorder(contentTitleBorder);
		
		
		
		//Restaurant Management Panel
		JPanel menuItemManagementPanel = new JPanel();
		menuItemManagementPanel.setBounds(20, 60, 300, 350);
		//contentPanel2.setBackground(new Color(192, 192, 192));
		TitledBorder contentTitleBorder1 = BorderFactory.createTitledBorder("MenuItem Management Panel");
		menuItemManagementPanel.setBorder(contentTitleBorder1);
		menuItemManagementPanel.setLayout(null);
		add(menuItemManagementPanel);
		
		//JLabel menu item id
		JLabel labelItemId = new JLabel("Menu Item id");
		labelItemId.setBounds(10, 37, 140, 30);
		menuItemManagementPanel.add(labelItemId);
		
		//JTextField menu item id
		JTextField textMenuItemId = new JTextField();
		textMenuItemId.setBounds(10, 65, 140, 30);
		menuItemManagementPanel.add(textMenuItemId);
		textMenuItemId.setBackground(new Color(255, 255, 255));
		textMenuItemId.setColumns(10);
	
		
		//JLabel menu Item Name
		JLabel labelMenuItemName = new JLabel("Menu Item Name");
		labelMenuItemName.setBounds(10, 110, 140, 30);
		menuItemManagementPanel.add(labelMenuItemName);
		
		//JTextField menu Item Name
		JTextField textMenuItemName = new JTextField();
		textMenuItemName.setBounds(10, 136, 140, 30);
		menuItemManagementPanel.add(textMenuItemName);
		textMenuItemName.setBackground(new Color(255, 255, 255));
		textMenuItemName.setColumns(10);
		
		
		//JLabel menu Item price
		JLabel labelMenuItemPrice = new JLabel("Menu Item Price");
		labelMenuItemPrice.setBounds(10, 195, 140, 30);
		menuItemManagementPanel.add(labelMenuItemPrice);
		
		//JTextField menu Item price
		JTextField textMenuItemPrice = new JTextField();
		textMenuItemPrice.setBounds(10, 220, 140, 30);
		menuItemManagementPanel.add(textMenuItemPrice);
		textMenuItemPrice.setColumns(10);

       
		// ADD Button
		JButton buttonAdd = new JButton("Add");
		buttonAdd.addActionListener(new ActionListener() {
			
		

			public void actionPerformed(ActionEvent arg0) {
				
				if(textMenuItemId.getText().equals("")|| textMenuItemName.getText().equals("")|| textMenuItemPrice.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "Please Complete the Information");
				}
				else 
				{
					Object[] row = new Object[3];
					row[0] = textMenuItemId.getText();
					row[1] = textMenuItemName.getText();
					row[2] = textMenuItemPrice.getText();
					model.addRow(row);
					
				
					
					//ne momentin qe bejme Add, row qe do shtohet te jete bosh(Clear text field for new enter)
					textMenuItemId.setText(" ");
					textMenuItemName.setText(" ");
					textMenuItemPrice.setText(" ");
					JOptionPane.showMessageDialog(null, "Add data Successfully");
				}
				}
			});
				
					
				
				
		
		buttonAdd.setBackground(new Color(64, 200, 128));
		buttonAdd.setForeground(new Color(255, 255, 255));
		buttonAdd.setBounds(10, 300, 80, 25);
		menuItemManagementPanel.add(buttonAdd);
		
		// Update Button
		JButton buttonUpdate = new JButton("Update");
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					model.setValueAt(textMenuItemId.getText(), i, 0);
					model.setValueAt(textMenuItemName.getText(),i, 1);
					model.setValueAt(textMenuItemPrice.getText(),i, 2);
					JOptionPane.showMessageDialog(null, "Updated Successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select a Row first");
				}
			}
		});
		buttonGroup.add(buttonUpdate);
		buttonUpdate.setForeground(new Color(255, 255, 255));
		buttonUpdate.setBackground(new Color(64, 200, 128));
		buttonUpdate.setBounds(100, 300, 80, 25);
		menuItemManagementPanel.add(buttonUpdate);
		
		// Remove Button
		JButton buttonDelete = new JButton("Delete");
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = table.getSelectedRow();
				if(i>=0) {
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Deleted Successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select a Row first");
				}
			}
		});
		buttonDelete.setForeground(new Color(255, 255, 255));
		buttonDelete.setBackground(new Color(64, 200, 128));
		buttonDelete.setBounds(190, 300, 80, 25);
		menuItemManagementPanel.add(buttonDelete);
		
		// JTextField Menu Item Manager
		JTextField txtMenuItemManager = new JTextField();
		txtMenuItemManager.setFont(new Font("Arial", Font.BOLD, 15));
		txtMenuItemManager.setForeground(new Color(255, 255, 255));
		txtMenuItemManager.setBackground(new Color(64, 200, 128));
		txtMenuItemManager.setHorizontalAlignment(SwingConstants.CENTER);
		txtMenuItemManager.setText("Menu Item Manager");
		txtMenuItemManager.setBounds(20, 0, 620, 29);
		menuItemManagerPanel.add(txtMenuItemManager);
		txtMenuItemManager.setColumns(50);
		menuItemManagerPanel.add(txtMenuItemManager);
		
		
		// Create JScroll Pane
		JScrollPane scrollPane = new JScrollPane(table);
		TitledBorder contentTitleBorder3 = BorderFactory.createTitledBorder("Menu Item List");
		scrollPane.setBorder(contentTitleBorder3);
        scrollPane.setBounds(367, 207, 307, 200);
        add(scrollPane);
        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				int i = table.getSelectedRow();
				
				//The toString() method returns the string representation of the object
				textMenuItemId.setText(model.getValueAt(i, 0).toString());
				textMenuItemName.setText(model.getValueAt(i, 1).toString());
				textMenuItemPrice.setText(model.getValueAt(i, 2).toString());
				
					
				}
		});
        
        // JComboBox Restaurant List
        RestaurantDataProvider restaurantDataProvider = new RestaurantDataProvider();
        JComboBox restaurant = new JComboBox();
        
        restaurant.addItem("Select Restaurant");
		for(RestaurantData restaurantData:restaurantDataProvider.getRestaurantDataList() ) {
			restaurant.addItem(restaurantData.getRestaurantName()) ;
		}
		TitledBorder contentTitleBorder4 = BorderFactory.createTitledBorder("Restaurant Selection");
		restaurant.setBorder(contentTitleBorder4);
		restaurant.setBounds(367, 60, 300, 45);
         add(restaurant);
         
         
       // JComboBox Menu List
         JComboBox menuJComboBox = new JComboBox();
         
         menuJComboBox.addItem("Select Menu");
         
 		for(Menu menuData:restaurantDataProvider.getMenuList() ) {if(restaurant.getSelectedItem()!= "Juvenilja Castelo") {
//        	 JOptionPane.showMessageDialog(null, "Please select the restaurant first");
         }
 			menuJComboBox.addItem(menuData.getMenuName()) ;
 			 			
 			scrollPane.setViewportView(table);
 			add(menuItemManagerPanel);
 			

			
 				
 			
 			
 		}
 		TitledBorder contentTitleBorder6 = BorderFactory.createTitledBorder("Menu Selection");
 		menuJComboBox.setBorder(contentTitleBorder6);
 		menuJComboBox.setBounds(367, 120, 300, 45);
          add(menuJComboBox);
       
      
        //Table Model
        model = new DefaultTableModel();
		Object[] column = {"Menu Item id", "Menu Item Name", "Menu Item Price"};
		Object[] row = new Object[3];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		table.setBackground(new Color(211, 211, 211));
		
		scrollPane.setViewportView(table);
		add(menuItemManagerPanel);
		menuJComboBox.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				RestaurantDataProvider restaurantDataprovider = new RestaurantDataProvider();
				((DefaultTableModel)table.getModel()).setRowCount(0);
					for (MenuItem menuItem : restaurantDataprovider.getMenuItemList1()) {
					if(menuJComboBox.getSelectedItem().toString()== menuItem.getMenuName()) {
			row[0] = menuItem.getId();
			row[1] = menuItem.getMenuItemName();
			row[2] = menuItem.getPrice();
			
			model.addRow(row);}
				}
				
				
			}
			});
		
menuJComboBox.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel)table.getModel()).setRowCount(0);
//				if(i>=0) {
//				model.removeRow(i);
//			
//				}
				RestaurantDataProvider restaurantDataprovider = new RestaurantDataProvider();
				
//				
				for (MenuItem menuItem : restaurantDataprovider.getMenuItemList2()) {
						if(menuJComboBox.getSelectedItem().toString()== "Menu #2") {
			row[0] = menuItem.getId();
			row[1] = menuItem.getMenuItemName();
			row[2] = menuItem.getPrice();
			
			model.addRow(row);}
			}
				
				
			}
			});
menuJComboBox.addActionListener(new ActionListener() {

	
	public void actionPerformed(ActionEvent e) {
		((DefaultTableModel)table.getModel()).setRowCount(0);
		RestaurantDataProvider restaurantDataprovider = new RestaurantDataProvider();
		
			for (MenuItem menuItem : restaurantDataprovider.getMenuItemList3()) {
				
				if(menuJComboBox.getSelectedItem().toString()== menuItem.getMenuName()
				&& restaurant.getSelectedItem().toString()== menuItem.getRestaurantName()) {
	row[0] = menuItem.getId();
	row[1] = menuItem.getMenuItemName();
	row[2] = menuItem.getPrice();
	
	model.addRow(row);}
		}
		
		 
	}
	});
		// Menu List
		
//		RestaurantDataProvider restaurantDataprovider = new RestaurantDataProvider();
//		
//			if(menuJComboBox.getSelectedItem().toString()== "Menu #1") {
//				for (MenuItem menuItemTemplate : restaurantDataprovider.getMenuItemList1()) {
//		row[0] = menuItemTemplate.getId();
//		row[1] = menuItemTemplate.getMenuItemName();
//		row[2] = menuItemTemplate.getPrice();
//		
//		model.addRow(row);
//			}
//		}
		 
		
}
	
	private void printMenuList() {
		// TODO Auto-generated method stub
		
	}
	
}
