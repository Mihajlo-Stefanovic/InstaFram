package view.toolbars;

import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;

import app.AppCore;

public class NodeToolBar extends JToolBar {

	private static final long serialVersionUID = -5864387020858410771L;
	private JButton jbCloseTab;
	private JButton jbCloseAllTabs;
	
	public NodeToolBar() {
		makeButtons();
		addIcons();
		setBorders();
		setButtonListeners();
		addButtons();

		setFloatable(false);
		setBackground(SystemColor.control);
	}
	

	private void setButtonListeners() {
		jbCloseTab.addActionListener(AppCore.getInstance().getActionManager().getCloseTabListener());
		jbCloseAllTabs.addActionListener(AppCore.getInstance().getActionManager().getCloseAllTabsListener());
	}

	private void makeButtons() {
		jbCloseTab = new JButton();
		jbCloseAllTabs = new JButton();
	}

	private void addIcons() {
		jbCloseTab.setText("Close Tab");
		jbCloseAllTabs.setText("Close All Tabs");
	}

	private void setBorders() {
		jbCloseTab.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jbCloseAllTabs.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}

	private void addButtons() {
		add(jbCloseTab);
		addSeparator();
		add(jbCloseAllTabs);
	}
}
