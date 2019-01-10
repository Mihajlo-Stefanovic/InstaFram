package controller.actions.actionListeners.undoRedoListeners;

import java.awt.event.ActionEvent;
import app.AppCore;
import controller.actions.actionListeners.MyActionListener;

public class RedoListener extends MyActionListener {

	@Override
	protected void myActionPerformed(ActionEvent event) {
		AppCore.getInstance().getCommandManager().redoCommand();
	}

}
