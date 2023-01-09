package tutorial.internship.java.view;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

	

	@SuppressWarnings("serial")
	public class RestaurantPointView extends JPanel {
		
		public RestaurantPointView() {
			prepareView();
		}

		public void prepareView() {
			setVisible(true);
			setLayout(null);
			this.setBounds(266, 0, 704, 582);
			prepareMenuComponents();
			
		}

		private void prepareMenuComponents() {
			JPanel contentPanel = new JPanel();
			contentPanel.setBounds(0, 0, 704, 582);
			TitledBorder contentTitleBorder = BorderFactory.createTitledBorder("Restaurant Point Manager");
			contentPanel.setBorder(contentTitleBorder);
			JLabel menuLabel1 = new JLabel("Menu 1");
			JLabel menuLabel2 = new JLabel("Menu 2");
			contentPanel.add(menuLabel1);
			contentPanel.add(menuLabel2);
			add(contentPanel);
			
			
		}
	}

