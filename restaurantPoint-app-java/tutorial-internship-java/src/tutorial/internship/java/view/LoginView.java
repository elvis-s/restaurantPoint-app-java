package tutorial.internship.java.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import tutorial.internship.java.model.User;
import tutorial.internship.login.LoginController;
import tutorial.internship.login.RestaurantAdminView;

public class LoginView {
	
	private final Font GENERAL_LABEL_FONT = new Font("Arial", Font.PLAIN, 15);

	

	private JFrame frame;
	
	private JTextField usernameTextField = new JTextField();
	private JPasswordField passwordTextField = new JPasswordField();
	
	private JLabel loginResultLabel;
	 
	 
	 /**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						LoginView loginView = new LoginView();
						loginView.prepareView();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
  
	protected void prepareView() {
		initializeLoginFrame();
		createLoginComponents();
	}
	private void initializeLoginFrame() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
	}
	
	
	
	private void createLoginComponents() {
		createUsernameComponent();
		createPasswordFieldComponent();
		createLoginButton();
		createLoginResultLabel();
		
	}
	
	

	private void createUsernameComponent() {
	JLabel usernameLabel = createUsernameTextfieldLabel();
	createUsernameTextfield();
	
	frame.getContentPane().add(usernameLabel);
	frame.getContentPane().add(usernameTextField);
		
	}

	private void createUsernameTextfield() {
		usernameTextField.setColumns(10);
		usernameTextField.setFont(GENERAL_LABEL_FONT);
		usernameTextField.setBounds(87, 50, 306, 40);
	}

	private JLabel createUsernameTextfieldLabel() {
		JLabel usernameLabel = new JLabel("Username: ");
		usernameLabel.setFont(GENERAL_LABEL_FONT);
		
		usernameLabel.setBounds(0, 57, 91, 26);
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		return usernameLabel;
	}

	private void createPasswordFieldComponent() {
		JLabel passwordLabel = createPasswordFieldLabel();
		createPasswordTextField();
		
		frame.getContentPane().add(passwordLabel);
		frame.getContentPane().add(passwordTextField);		
	}
	
	private void createPasswordTextField() {
		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		passwordTextField.setFont(GENERAL_LABEL_FONT);
		passwordTextField.setBounds(87, 98, 306, 40);
		
		
	}

	private JLabel createPasswordFieldLabel() {
		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setFont(GENERAL_LABEL_FONT);
		passwordLabel.setBounds(0, 105, 91, 26);
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		return passwordLabel;
		
	}
		
	

	private void createLoginButton() {
		JButton loginButton = new JButton("Login ");
		loginButton.setFont(GENERAL_LABEL_FONT);
		loginButton.setForeground(Color.black);
		
	
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginWithProvidedUserCredentials();
				
			}

		});
		loginButton.setBounds(157, 175, 108, 37);
		frame.getContentPane().add(loginButton);
	}
	
	private void loginWithProvidedUserCredentials() {
		String username = usernameTextField.getText();
		String password = String.valueOf(passwordTextField.getPassword());
		
		boolean credentialsProvided = isCredentialsProvided(username, password);
		
		if(credentialsProvided) {
			LoginController.getInstance().loginUser(username, password);
			
			User loggedInUser = LoginController.getInstance().getLoggedInUser();
			handleWrongUserCredentials(loggedInUser);
			
			UserRoleView userRoleView = new UserRoleView();
			userRoleView.prepareView();
		}
		
	}

	private void handleWrongUserCredentials(User loggedInUser) {
		if(loggedInUser== null) {
			loginResultLabel.setText("User credentials are wrong!");
			passwordTextField.setText("");
			usernameTextField.setText("");
		}
		
	}

	private boolean isCredentialsProvided(String username, String password) {
		LoginController loginController = LoginController.getInstance();
		if(loginController.isStringNullOrBlank(username)) {
			loginResultLabel.setText("Please provide your username. ");
			return false;
		}else if(loginController.isStringNullOrBlank(password)) {
			loginResultLabel.setText("Please provide your password. ");
			return false;
		}
		return true;
	}

	private void createLoginResultLabel() {
		loginResultLabel = new JLabel("");
		loginResultLabel.setFont(GENERAL_LABEL_FONT);
		loginResultLabel.setBounds(107, 212, 250, 40);
		loginResultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(loginResultLabel);
		
	}

	public void loginUser() {
	//get userName from textField
		String userName = "TestUser1";
	//get password from textfield
		String password = "123test";
	
	LoginController loginController = LoginController.getInstance();
	loginController.loginUser(userName, password);
	User loggedInUser = loginController.getLoggedInUser();
	
	System.out.println("Username: " + loggedInUser.getUserName());
	System.out.println("Password: " + loggedInUser.getPassword());
	
	RestaurantAdminView adminView = new RestaurantAdminView();
	adminView.getAllRestaurantsFromAdmin();
	
}
	
}
