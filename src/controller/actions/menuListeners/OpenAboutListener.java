package controller.actions.menuListeners;

import javax.swing.event.MenuEvent;
import app.AppCore;
import view.frames.AboutFrame;

public class OpenAboutListener extends MyMenuListener {
	 //AboutFrame aboutFrame;
	
	@Override
	public void myMenuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myMenuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myMenuSelected(MenuEvent arg0) {
		AppCore.getInstance().getMainFrame().aboutFrame = new AboutFrame(AppCore.getInstance().getMainFrame());
	}

}
