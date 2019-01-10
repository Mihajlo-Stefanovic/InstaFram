package controller.actions.windowListeners;

import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import app.AppCore;

public class InstallationFrameWindowListener extends MyWindowListener {

	@Override
	public void myWindowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void myWindowClosed(WindowEvent e) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void myWindowClosing(WindowEvent e) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to cancel installation?", "Warning",
				dialogButton);
		if (dialogResult == JOptionPane.YES_OPTION) {
			e.getWindow().dispose();
			e.getWindow().setVisible(false);
		}
	}

	@Override
	public void myWindowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void myWindowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void myWindowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void myWindowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
