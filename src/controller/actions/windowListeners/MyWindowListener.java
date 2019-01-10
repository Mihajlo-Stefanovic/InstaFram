package controller.actions.windowListeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public abstract class MyWindowListener implements WindowListener {

	@Override
	public void windowActivated(WindowEvent e) {
		myWindowActivated(e);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		myWindowClosed(e);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		myWindowClosing(e);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		myWindowDeactivated(e);
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		myWindowDeiconified(e);
	}

	@Override
	public void windowIconified(WindowEvent e) {
		myWindowIconified(e);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		myWindowOpened(e);
	}
	

	public abstract void myWindowActivated(WindowEvent e);

	public abstract void myWindowClosed(WindowEvent e);

	public abstract void myWindowClosing(WindowEvent e);

	public abstract void myWindowDeactivated(WindowEvent e);

	public abstract void myWindowDeiconified(WindowEvent e);

	public abstract void myWindowIconified(WindowEvent e);

	public abstract void myWindowOpened(WindowEvent e);
}
