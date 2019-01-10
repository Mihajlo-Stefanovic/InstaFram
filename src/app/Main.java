package app;

import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
		setLookAndFeel();
		LogInCore.instantiateLogin();
	}

	
	private static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
