package view.menues;

import java.awt.Color;
import javax.swing.Box;
import javax.swing.JMenuBar;

import view.menues.menuBarItems.MenuBarAbout;
import view.menues.menuBarItems.MenuBarFile;
import view.menues.menuBarItems.MenuBarHelp;
import view.menues.menuBarItems.MenuBarTools;

public class MenuBar extends JMenuBar {


	private static final long serialVersionUID = 8020509188749854568L;
	private MenuBarFile mFile;
	private MenuBarTools mTools;
	private MenuBarHelp mHelp;
	private MenuBarAbout mAbout;

	public MenuBar() {
		setMenues();
		setBackground(Color.GRAY);
	}

	private void setMenues() {
		makeMenues();
		addMenues();
	}

	private void addMenues() {
		add(mFile);
		//add(mView);
		//add(mTools);
		add(Box.createHorizontalGlue());
		add(mHelp);
		//mHelp.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		add(mAbout);
		//mAbout.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	}

	private void makeMenues() {
		mFile = new MenuBarFile();
		mTools = new MenuBarTools();
		mHelp = new MenuBarHelp();
		mAbout = new MenuBarAbout();
	}

}
