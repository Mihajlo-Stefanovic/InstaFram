package view.frames;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import app.LogInCore;
import controller.actions.actionListeners.logInListeners.LogInListener;
import controller.actions.actionListeners.logInListeners.RegisterListener;
import model.User;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;

public class LogInFrame extends MyFrame{

	private static final long serialVersionUID = -4058646908060167917L;
	JButton jbLogin;
	JButton jbRegister;
	
	JTextField tfUserName;
	JPasswordField tfPassword;
	JCheckBox cbAdmin;
	
	JPanel panel;
	
	public LogInFrame(boolean adminCheck) {
		initializeFrame(0, 0);
		addActions();
		
		if(adminCheck) {
			
			setTitle("Admin Check");
			
			panel.remove(jbRegister);
			panel.remove(cbAdmin);
			
			for( ActionListener al : jbLogin.getActionListeners() ) {
				jbLogin.removeActionListener(al);
		    }
			
			jbLogin.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					User user = new User(getUserName(), getPassword(), true);
					if(LogInCore.getInstance().testUser(user)) {
						LogInCore.getInstance().register(true);
						close();
					}
					
					else {
						LogInCore.getInstance().getExceptionManager().handleException(new MyException(MyExceptionSubTypes.LOGIN.WRONGINFO));
					}
				}
			});
		}
		else {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		setVisible(true);
	}
	
	private void addActions() {
		jbLogin.addActionListener(new LogInListener());
		jbRegister.addActionListener(new RegisterListener());
	}

	@Override
	void initializeFrame(float screenHeightPercent, float screenWidthPercent) {
		defaultScreenWidthPercent = 20;
		defaultScreenHightPercent = 20;

		minScreenWidthPercent = 20;
		minScreenHightPercent = 20;

		setSizeNPos(screenHeightPercent, screenWidthPercent);
		
		tfUserName = new JTextField("Username");
		tfUserName.setMaximumSize(new Dimension(100, 20));
		tfUserName.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		tfPassword = new JPasswordField("Password");
		tfPassword.setEchoChar('\7');
		tfPassword.setMaximumSize(new Dimension(100, 20));
		tfPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		jbLogin = new JButton("Log In");
		jbLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		jbRegister = new JButton("Register");
		jbRegister.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		cbAdmin = new JCheckBox("Admin?");
		cbAdmin.setAlignmentX(Component.CENTER_ALIGNMENT);
		cbAdmin.setSelected(true);
		
		panel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);
		
		this.add(panel);
		
		panel.add(tfUserName);
		panel.add(tfPassword);
		
		panel.add(cbAdmin);
		
		panel.add(jbLogin);
		panel.add(jbRegister);
		
		setTitle("Log In");
	}

	public String getUserName() {
		return tfUserName.getText();
	}

	public String getPassword() {
		return tfPassword.getText();
	}

	public boolean getIsAdmin() {
		return cbAdmin.isSelected();
	}
}
