package controller.actions.actionListeners.projectListeners;

import java.awt.event.ActionEvent;
import app.AppCore;
import controller.actions.actionListeners.MyActionListener;
import controller.commands.treeCommands.RemoveTreeCommand;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;

public class CloseProjectListener extends MyActionListener {

	@Override
	public void myActionPerformed(ActionEvent arg0) {
		try {
			
			if (AppCore.getInstance().getTree() == null) {
				throw new MyException(MyExceptionSubTypes.CLOSEPROJECTLISTENER.NOPROJECT);
			}

			boolean close = false;
			if (!AppCore.getInstance().getTree().isSaved()) {
				close = AppCore.getInstance().getSaver().notSavedWarning();
			} else
				close = true;

			if (close) {
				AppCore.getInstance().getCommandManager().addCommand(new RemoveTreeCommand());
			}
		} catch (MyException e) {
			AppCore.getInstance().getExceptionManager().handleException(e);
		}
	}

}
