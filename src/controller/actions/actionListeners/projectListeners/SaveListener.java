package controller.actions.actionListeners.projectListeners;

import java.awt.event.ActionEvent;
import app.AppCore;
import controller.actions.actionListeners.MyActionListener;
import controller.saver.Saver;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;

public class SaveListener extends MyActionListener {

	@Override
	public void myActionPerformed(ActionEvent arg0) {
		try {
			if (AppCore.getInstance().getTree() == null) {
				throw new MyException(MyExceptionSubTypes.SAVE.NOPROJECT);
			}
			Saver treeSaver = AppCore.getInstance().getSaver();
			treeSaver.save(AppCore.getInstance().getTree().getModel().getRoot());
		} catch (MyException e) {
			AppCore.getInstance().getExceptionManager().handleException(e);
		}
	}

}
