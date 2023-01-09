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

import tutorial.internship.java.model.RestaurantData;
import tutorial.internship.java.model.User;
import tutorial.internship.login.dataproviders.RestaurantDataProvider;
import tutorial.internship.login.dataproviders.UserDataProvider;


@SuppressWarnings("serial")
public class RestaurantManagerView extends JPanel {
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JTable table;
	DefaultTableModel model;

	//private Object String;

	private Object ResaurantDataProvider;
	

	public RestaurantManagerView() {
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
		JPanel restaurantManagerPanel = new JPanel();
		restaurantManagerPanel.setBounds(0, 0, 704, 582);
		TitledBorder contentTitleBorder = BorderFactory.createTitledBorder("Restaurant Manager");
		restaurantManagerPanel.setBorder(contentTitleBorder);
		
		
		
		//Restaurant Management Panel
		JPanel restaurantManagementPanel = new JPanel();
		restaurantManagementPanel.setBounds(20, 60, 300, 350);
		//contentPanel2.setBackground(new Color(192, 192, 192));
		TitledBorder contentTitleBorder1 = BorderFactory.createTitledBorder("Management Panel");
		restaurantManagementPanel.setBorder(contentTitleBorder1);
		restaurantManagementPanel.setLayout(null);
		add(restaurantManagementPanel);
	
		//JLabel restaurant name
		JLabel labelRestaurantName = new JLabel("Restaurant Name");
		labelRestaurantName.setBounds(10, 37, 140, 30);
		restaurantManagementPanel.add(labelRestaurantName);
		
		//JTextField restaurant name
		JTextField textRestaurantName = new JTextField();
		textRestaurantName.setBounds(10, 65, 140, 30);
		restaurantManagementPanel.add(textRestaurantName);
		textRestaurantName.setBackground(new Color(255, 255, 255));
		textRestaurantName.setColumns(10);
		
		//JLabel restaurant address
		JLabel labelRestaurantAddress = new JLabel("Restaurant Address");
		labelRestaurantAddress.setBounds(10, 110, 140, 30);
		restaurantManagementPanel.add(labelRestaurantAddress);
		
		//JTextField restaurant address
		JTextField textRestaurantAddress = new JTextField();
		textRestaurantAddress.setBounds(10, 136, 140, 30);
		restaurantManagementPanel.add(textRestaurantAddress);
		textRestaurantAddress.setColumns(10);

       
		// ADD Button
		JButton buttonAdd = new JButton("Add");
		buttonAdd.addActionListener(new ActionListener() {
			
		

			public void actionPerformed(ActionEvent arg0) {
				
				if(textRestaurantName.getText().equals("")|| textRestaurantAddress.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "Please Complete the Information");
				}
				else 
				{
					Object[] row = new Object[2];
					row[0] = textRestaurantName.getText();
					row[1] = textRestaurantAddress.getText();
					model.addRow(row);
					
				
					
					//ne momentin qe bejme Add, row qe do shtohet te jete bosh(Clear text field for new enter)
					textRestaurantName.setText(" ");
					textRestaurantAddress.setText(" ");
					JOptionPane.showMessageDialog(null, "Add data Successfully");
				}
				}
			});
				
					
				
				
		
		buttonAdd.setBackground(new Color(64, 200, 128));
		buttonAdd.setForeground(new Color(255, 255, 255));
		buttonAdd.setBounds(10, 300, 80, 25);
		restaurantManagementPanel.add(buttonAdd);
		
		// Update Button
		JButton buttonUpdate = new JButton("Update");
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					model.setValueAt(textRestaurantName.getText(),i, 0);
					model.setValueAt(textRestaurantAddress.getText(),i, 1);
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
		restaurantManagementPanel.add(buttonUpdate);
		
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
		restaurantManagementPanel.add(buttonDelete);
		
		JTextField txtRestaurantManager = new JTextField();
		txtRestaurantManager.setFont(new Font("Arial", Font.BOLD, 15));
		txtRestaurantManager.setForeground(new Color(255, 255, 255));
		txtRestaurantManager.setBackground(new Color(64, 200, 128));
		txtRestaurantManager.setHorizontalAlignment(SwingConstants.CENTER);
		txtRestaurantManager.setText("Restaurant Manager");
		txtRestaurantManager.setBounds(20, 0, 620, 29);
		restaurantManagerPanel.add(txtRestaurantManager);
		txtRestaurantManager.setColumns(50);
		restaurantManagerPanel.add(txtRestaurantManager);
		
		//Restaurant List Panel
		
		
		//Table
		
		JScrollPane scrollPane = new JScrollPane(table);
		TitledBorder contentTitleBorder3 = BorderFactory.createTitledBorder("Restaurant List");
		scrollPane.setBorder(contentTitleBorder3);
        scrollPane.setBounds(367, 60, 307, 272);
        add(scrollPane);
		
		table = new JTable();
		
		
	
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				int i = table.getSelectedRow();
				
				//The toString() method returns the string representation of the object
				textRestaurantName.setText(model.getValueAt(i, 0).toString());
				textRestaurantAddress.setText(model.getValueAt(i, 1).toString());
					
				}
		});
		
		model = new DefaultTableModel();
		Object[] column = {"Name", "Address"};
		Object[] row = new Object[2];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		RestaurantDataProvider restaurantDataprovider = new RestaurantDataProvider();
		
		for (RestaurantData restaurantData : restaurantDataprovider.getRestaurantDataList()) {
		row[0] = restaurantData.getRestaurantName();
		row[1] = restaurantData.getRestaurantAddress();
		model.addRow(row);
		}
		
		table.setBackground(new Color(211, 211, 211));
		scrollPane.setViewportView(table);
	
		
		add(restaurantManagerPanel);
	}	
}
