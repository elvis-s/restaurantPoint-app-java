package tutorial.internship.java.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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

import tutorial.internship.java.model.Menu;
import tutorial.internship.java.model.RestaurantData;
import tutorial.internship.login.dataproviders.RestaurantDataProvider;

       

	@SuppressWarnings("serial")
	public class MenuManagerView extends JPanel {
		private JTable table;
		DefaultTableModel model;
		 
		private final ButtonGroup buttonGroup = new ButtonGroup();
		public MenuManagerView() {
			prepareView();
		}
		public void prepareView() {
			setVisible(true);
			setLayout(null);
			this.setBounds(266, 0, 704, 582);
			prepareMenuComponents();
			
		}

		private void prepareMenuComponents() {
			//Restaurant Manager Panel
			JPanel menuManagerPanel = new JPanel();
			menuManagerPanel.setBounds(0, 0, 704, 582);
			TitledBorder contentTitleBorder = BorderFactory.createTitledBorder("Restaurant Manager");
			menuManagerPanel.setBorder(contentTitleBorder);
			
			
			
			//Restaurant Management Panel
			JPanel restaurantManagementPanel = new JPanel();
			restaurantManagementPanel.setBounds(20, 60, 300, 350);
			//contentPanel2.setBackground(new Color(192, 192, 192));
			TitledBorder contentTitleBorder1 = BorderFactory.createTitledBorder("Management Panel");
			restaurantManagementPanel.setBorder(contentTitleBorder1);
			restaurantManagementPanel.setLayout(null);
			add(restaurantManagementPanel);
			
			
			JLabel lblMenuName = new JLabel("Menu Name");
			lblMenuName.setBounds(20, 31, 130, 14);
			restaurantManagementPanel.add(lblMenuName);
			
			JTextField textMenuName = new JTextField();
			textMenuName.setBounds(20, 44, 130, 20);
			restaurantManagementPanel.add(textMenuName);
			textMenuName.setBackground(new Color(255, 255, 255));
			textMenuName.setColumns(10);
			
			// ADD Button
			JButton buttonAdd = new JButton("Add");
			buttonAdd.addActionListener(new ActionListener() {
				
			

				public void actionPerformed(ActionEvent arg0) {
					
					if(textMenuName.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please Complete the Information");
					}
					else 
					{
						Object[] row = new Object[1];
						row[0] = textMenuName.getText();
						model.addRow(row);
						
					
						
						//ne momentin qe bejme Add, row qe do shtohet te jete bosh(Clear text field for new enter)
						textMenuName.setText(" ");
						JOptionPane.showMessageDialog(null, "Add data Successfully");
					}
					}
				});
					
						
					
					
			
			buttonAdd .setForeground(new Color(255, 255, 255));
			buttonAdd .setBackground(new Color(64, 128, 128));
			buttonAdd.setBounds(10, 300, 80, 25);
			restaurantManagementPanel.add(buttonAdd);
			
			
			JButton buttonUpdate = new JButton("Update");
			buttonUpdate.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if(i>=0) {
						model.setValueAt(textMenuName.getText(),i, 0);
						
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
			buttonUpdate.setBackground(new Color(64, 128, 128));
			buttonUpdate.setBounds(100, 300, 80, 25);
			restaurantManagementPanel.add(buttonUpdate);
			
			
			
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
			buttonDelete.setBackground(new Color(64, 128, 128));
			buttonDelete.setBounds(190, 300, 80, 25);
			restaurantManagementPanel.add(buttonDelete);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(192, 192, 192));
			panel_2.setForeground(new Color(192, 192, 192));
			panel_2.setBounds(320, 80, 312, 166);
			menuManagerPanel.add(panel_2);
			panel_2.setLayout(null);
			
			JTextField txtRestaurantManager = new JTextField();
			txtRestaurantManager.setFont(new Font("Arial", Font.BOLD, 15));
			txtRestaurantManager.setForeground(new Color(255, 255, 255));
			txtRestaurantManager.setBackground(new Color(64, 128, 128));
			txtRestaurantManager.setHorizontalAlignment(SwingConstants.CENTER);
			txtRestaurantManager.setText("Menu Manager");
			txtRestaurantManager.setBounds(20, 0, 620, 29);
			menuManagerPanel.add(txtRestaurantManager);
			txtRestaurantManager.setColumns(50);
			menuManagerPanel.add(txtRestaurantManager);
			
			JScrollPane scrollPane = new JScrollPane(table);
			TitledBorder contentTitleBorder3 = BorderFactory.createTitledBorder("Menu List");
			scrollPane.setBorder(contentTitleBorder3);
	        scrollPane.setBounds(367, 207, 307, 200);
	        add(scrollPane);
	        table = new JTable();
	        table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					
					int i = table.getSelectedRow();
					
					//The toString() method returns the string representation of the object
					textMenuName.setText(model.getValueAt(i, 0).toString());
					
						
					}
			});
			
	        RestaurantDataProvider restaurantDataProvider = new RestaurantDataProvider();
	        JComboBox restaurantJComboBox = new JComboBox();
	        
	        restaurantJComboBox.addItem("Select Restaurant");
			for(RestaurantData restaurantData:restaurantDataProvider.getRestaurantDataList() ) {
				restaurantJComboBox.addItem(restaurantData.getRestaurantName()) ;
			}
			TitledBorder contentTitleBorder4 = BorderFactory.createTitledBorder("Restaurant Selection");
			restaurantJComboBox.setBorder(contentTitleBorder4);
			restaurantJComboBox.setBounds(367, 60, 300, 45);
	         add(restaurantJComboBox);
	       	     
        
	        

	      
	        
			model = new DefaultTableModel();
			Object[] column = {"Menu Name"};
			Object[] row = new Object[1];
			model.setColumnIdentifiers(column);
			table.setModel(model);
			
			RestaurantDataProvider restaurantDataprovider = new RestaurantDataProvider();
			
			for (Menu menu : restaurantDataprovider.getMenuList()) {
			row[0] = menu.getMenuName();
			
			model.addRow(row);
			}
			
			table.setBackground(new Color(211, 211, 211));
			scrollPane.setViewportView(table);
			
	        add(menuManagerPanel);
			
			
		}
		
			
		
		
	}


