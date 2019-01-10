package controller.actions.menuListeners;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public abstract class MyMenuListener implements MenuListener{

	@Override
	public void menuCanceled(MenuEvent e) {
		myMenuCanceled(e);
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		myMenuDeselected(e);
	}

	@Override
	public void menuSelected(MenuEvent e) {
		myMenuSelected(e);
	}
	
	protected abstract void myMenuCanceled(MenuEvent e);

	protected abstract void myMenuDeselected(MenuEvent e);

	protected abstract void myMenuSelected(MenuEvent e);

}
