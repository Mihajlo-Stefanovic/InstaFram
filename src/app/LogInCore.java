package app;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import controller.ExceptionManager;
import model.User;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;
import view.frames.LogInFrame;
import view.frames.MainFrame;

public class LogInCore {
	private static LogInCore instance;

	private LogInFrame logInFrame;
	private LogInFrame adminCheckFrame;
	
	private ArrayList<User> users;
	private String usersLocation = new String("data/Users.secret");
	private ExceptionManager exceptionManager;

	private User defaultAdmin = new User("Mihajlo", "Miha", true);
	
	public LogInCore() {
		logInFrame = new LogInFrame(false);
		loadUsers();

		exceptionManager = new ExceptionManager();
	}

	public static void instantiateLogin() {
		if (instance == null) {
			instance = new LogInCore();
		} else {
			System.out.println("Login already instantiated.");
		}
	}

	public boolean testUser(User user) {
		if (users.contains(user) || user.equals(defaultAdmin)) {
			return true;
		} else
			return false;
	}

	public void login() {
		if (testUser(getUser())) {
			initializeApp();
			AppCore.getInstance().setUser(getUser());

			instance = null;
			logInFrame.close();
		} else {
			exceptionManager.handleException(new MyException(MyExceptionSubTypes.LOGIN.WRONGINFO));
		}
	}

	public void register(Boolean checked) {
		User currUser = getUser();

		if (!users.contains(currUser)) {
			if (currUser.isAdmin() && !checked)
				checkWAdmin();
			else {
				users.add(currUser);
				writeUsers();
				login();
			}
		} else {
			exceptionManager.handleException(new MyException(MyExceptionSubTypes.LOGIN.USERALREADYEXSISTS));
		}

	}

	private void checkWAdmin() {
		if (adminCheckFrame != null)
			adminCheckFrame.close();
		adminCheckFrame = new LogInFrame(true);
	}

	private void loadUsers() {
		users = new ArrayList<>(); // if load fails
		try {
			FileInputStream fis = new FileInputStream(usersLocation);
			ObjectInputStream ois = new ObjectInputStream(fis);
			users = (ArrayList<User>) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
		} catch (ClassNotFoundException e) {
		} catch (ClassCastException e) {
		}
	}

	private void writeUsers() {
		try {
			FileOutputStream fos = new FileOutputStream(new File(usersLocation));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(users);
			oos.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private void initializeApp() {
		AppCore.initializeAppCore();
		AppCore.getInstance().setMainFrame(new MainFrame(new Dimension(70, 70)));
	}

	private User getUser() {
		return new User(logInFrame.getUserName(), logInFrame.getPassword(), logInFrame.getIsAdmin());
	}

	public LogInFrame getLogInFrame() {
		return logInFrame;
	}

	public static LogInCore getInstance() {
		return instance;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public ExceptionManager getExceptionManager() {
		return exceptionManager;
	}

}
