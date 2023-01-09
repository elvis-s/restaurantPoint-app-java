package tutorial.internship;

import java.awt.EventQueue;

import javax.swing.JFrame;

import tutorial.internship.login.LoginController;



public class MainClass {
	
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass mainClassWindow = new MainClass();
					mainClassWindow.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MainClass() {
		initialize();
	}
	        private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 984, 619);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	        }        
}

