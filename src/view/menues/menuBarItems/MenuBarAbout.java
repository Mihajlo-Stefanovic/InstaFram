package view.menues.menuBarItems;

import javax.swing.JMenu;
import controller.actions.menuListeners.OpenAboutListener;

public class MenuBarAbout extends JMenu {
	

	private static final long serialVersionUID = -7740667933862184212L;

	public MenuBarAbout() {
		super("About");
		addMenuListener(new OpenAboutListener());
	}
}
