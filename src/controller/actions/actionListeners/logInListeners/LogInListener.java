package controller.actions.actionListeners.logInListeners;

import java.awt.event.ActionEvent;

import app.LogInCore;
import controller.actions.actionListeners.MyActionListener;

public class LogInListener extends MyActionListener {

	@Override
	protected void myActionPerformed(ActionEvent event) {
		LogInCore.getInstance().login();
	}

}
