package controller.actions.actionListeners.treeListeners;

import java.awt.event.ActionEvent;
import app.AppCore;
import controller.actions.actionListeners.MyActionListener;

public class NewProjectListener extends MyActionListener {

	@Override
	public void myActionPerformed(ActionEvent arg0) {
		boolean open = false;
		if(AppCore.getInstance().getTree()!=null && !AppCore.getInstance().getTree().isSaved()) {
			if(!AppCore.getInstance().getTree().isSaved()) {
				open = AppCore.getInstance().getSaver().notSavedWarning();
			}
			else open = true;
		}
		else open = true;
		if(open)
			AppCore.getInstance().getMainFrame().getCenterPanel().getTreePanel().addTree();
	}

}
