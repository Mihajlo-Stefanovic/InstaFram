package controller.actions.windowListeners;

import java.awt.event.WindowEvent;
import app.AppCore;

public class mainFrameWindowListener extends MyWindowListener{

	@Override
	public void myWindowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myWindowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myWindowClosing(WindowEvent e) {
		boolean close = false;
		if(AppCore.getInstance().getTree()!=null && !AppCore.getInstance().getTree().isSaved()) {
			close = AppCore.getInstance().getSaver().notSavedWarning();
		}
		else close = true;
		
		if(close){
			AppCore.getInstance().getMainFrame().dispose();
			System.exit(1);
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
