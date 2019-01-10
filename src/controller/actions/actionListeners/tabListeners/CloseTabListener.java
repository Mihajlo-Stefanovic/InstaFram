package controller.actions.actionListeners.tabListeners;

import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

import app.AppCore;
import controller.actions.actionListeners.MyActionListener;

public class CloseTabListener extends MyActionListener {

	@Override
	public void myActionPerformed(ActionEvent arg0) {
		JTabbedPane jTabbedPane = AppCore.getInstance().getNodeTabPanel().getTabbedPane();
		jTabbedPane.remove(jTabbedPane.getSelectedComponent());
	}

}
