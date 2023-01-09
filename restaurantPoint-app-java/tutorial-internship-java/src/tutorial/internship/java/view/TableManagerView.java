package tutorial.internship.java.view;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class TableManagerView extends JPanel {
	
	public TableManagerView() {
		prepareView();
	}
	public void prepareView() {
		setVisible(true);
		setLayout(null);
		this.setBounds(266, 0, 704, 582);
		prepareRestaurantsComponents();
		
	}

	private void prepareRestaurantsComponents() {
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 704, 582);
		TitledBorder contentTitleBorder = BorderFactory.createTitledBorder("Restaurant Manager");
		contentPanel.setBorder(contentTitleBorder);
		JLabel restaurantLabel1 = new JLabel("Table 1");
		JLabel restaurantLabel2 = new JLabel("Table 2");
		contentPanel.add(restaurantLabel1);
		contentPanel.add(restaurantLabel2);
		add(contentPanel);
		
	}
}
