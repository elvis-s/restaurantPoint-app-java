package tutorial.internship.java.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.MouseInputAdapter;

import tutorial.internship.java.controller.AuthorizationService;
import tutorial.internship.java.model.UserFeature;
import tutorial.internship.java.utils.UserFeatureLabelResolver;
import tutorial.internship.login.LoginController;
import tutorial.internship.login.UserRole;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class UserRoleView {

	
	private JFrame mainFrame;
	private  JLayeredPane layeredPane;

	
	public void prepareView() {
		initialize();
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initializeMainFrame();
		
		
	    layeredPane= new JLayeredPane();
	    
	    // perform user Login
	    LoginController loginController = LoginController.getInstance();
	   
	    
	    
	    // get authorizet features for logged in user
	    UserRole userRole = loginController.getLoggedInUser().getUserRole();
	    
	    AuthorizationService authorizationService = new AuthorizationService();
	    
	    List<UserFeature> userFeatures = authorizationService.getUserFeaturesByUserRole(userRole);
	    
	    
		
	    
		JPanel navigationBar = createNavigationBar(userFeatures);
		//create Welcome content Panel
				JPanel welcomeContentPanel = createContentPanel("Welcome to dynamiic navigation Bar");
				switchPanel(welcomeContentPanel);
		
				mainFrame.getContentPane().add(navigationBar);
				mainFrame.getContentPane().add(layeredPane);
		
	}
	private void initializeMainFrame() {
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 984, 619);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JPanel createNavigationBar(List<UserFeature> userFeatures) {
		JPanel navigationBar = new JPanel();
		navigationBar.setBounds(0, 0, 266, 582);
		TitledBorder navigationBarTitledBorder = BorderFactory.createTitledBorder("Navigation Bar");
		navigationBar.setBorder(navigationBarTitledBorder);
		navigationBar.setLayout(null);
		
		
		// create navigationBar panel buttons
		List<JPanel> navigationBarPanelButtons = createNavigationBarPanelButtons(userFeatures);
		
		for(JPanel navigationBarPanelButton:navigationBarPanelButtons) {
			navigationBar.add(navigationBarPanelButton);
		}
		return navigationBar;
	}
	private List<JPanel> createNavigationBarPanelButtons(List<UserFeature> userFeatures) {
		List<JPanel>navigationBarPanelButtons = new ArrayList<>();
		// define JPanel for navigation Bar to "reuse"
		JPanel navigationBarPanelButton = null;
		
		int navigationPanelButtonVerticalPosition = 0;
		int navigationPanelButtonSpacing = 75;
		
		for(UserFeature userFeature:userFeatures ) {
			navigationBarPanelButton = new JPanel();
			navigationBarPanelButton.setForeground(new Color(255, 255, 255));
			
			navigationBarPanelButton.setBorder(null);
			navigationPanelButtonVerticalPosition += navigationPanelButtonSpacing;
			navigationBarPanelButton.setBounds(0, navigationPanelButtonVerticalPosition, 250, 75);
			
			String userFeatureLabel = UserFeatureLabelResolver.getUserFeatureLabel(userFeature);
			JLabel navigationBarPanelButtonLabel = new JLabel(userFeatureLabel);
			navigationBarPanelButton.add(navigationBarPanelButtonLabel);
			
			// create the content panel to show when the the navigation button is clicked
			//JPanel contentPanel = createContentPanel(userFeatureLabel+ "Content");
			
			// get the view for a userfeature
			JPanel userFeatureView = getViewByUserFeature(userFeature);
			
			// show the content panel on mouse click
			if(userFeatureView == null) {
				continue;
			}else {
				prepareNavigationBarPanelButtonMouseListener(navigationBarPanelButton, userFeatureView);
			
			}
			
			    // add navigation button to navigation button list
				navigationBarPanelButtons.add(navigationBarPanelButton);
			
	}
			return navigationBarPanelButtons;
		}
		
		
		
	

	private JPanel getViewByUserFeature(UserFeature userFeature) {
		switch (userFeature) {
		
		case RESTAURANT_POINT: 
			return new RestaurantPointView();
		case RESTAURANT_MANAGER: 
			return new RestaurantManagerView();
		
		case MENU_MANAGER: 
			return new MenuManagerView();
		case MENU_ITEM_MANAGER: 
			return new MenuItemManagerView();
		case TABLE_MANAGER:
			return new TableManagerView();
			
		default:
			//throw new IllegalArgumentException("User feature: " + userFeature + " is not supported");
			System.out.println("There is no view for user feature" + userFeature + "available");
			return null;
		}
		
	}
	
	private void prepareNavigationBarPanelButtonMouseListener(JPanel navigationBarPanelButton, JPanel contentPanel) {
		navigationBarPanelButton.addMouseListener(new MouseAdapter() {
		 
			@Override
			public void mouseClicked(MouseEvent e) {
				//switch panel
				switchPanel(contentPanel);
			}
		});
		
	}

	private JPanel createContentPanel(String contentPanelText) {
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(266, 0, 704, 582);
		TitledBorder contentTitleBorder = BorderFactory.createTitledBorder("Restaurant Point");
		contentPanel.setBorder(contentTitleBorder);
		JLabel contentPanelLabel = new JLabel(contentPanelText);
		contentPanel.add(contentPanelLabel);
		return contentPanel;
		
	}

	private void switchPanel(JPanel panel) {
		// switch to the panel provided as parameter
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}

	
}
