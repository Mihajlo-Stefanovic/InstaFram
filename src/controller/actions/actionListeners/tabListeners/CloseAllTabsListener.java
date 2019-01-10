package controller.actions.actionListeners.tabListeners;

import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

import app.AppCore;
import controller.actions.actionListeners.MyActionListener;

public class CloseAllTabsListener extends MyActionListener {

	@Override
	public void myActionPerformed(ActionEvent e) {
		JTabbedPane jTabbedPane = AppCore.getInstance().getNodeTabPanel().getTabbedPane();
		jTabbedPane.removeAll();
	}

}
