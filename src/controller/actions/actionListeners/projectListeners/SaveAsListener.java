package controller.actions.actionListeners.projectListeners;

import java.awt.event.ActionEvent;
import java.io.File;

import app.AppCore;
import controller.actions.actionListeners.MyActionListener;
import controller.saver.Saver;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;

public class SaveAsListener extends MyActionListener {

	@Override
	public void myActionPerformed(ActionEvent arg0) {
		try {
			if (AppCore.getInstance().getTree() == null) {
				throw new MyException(MyExceptionSubTypes.SAVE.NOPROJECT);
			}
		Saver treeSaver = AppCore.getInstance().getSaver();
		File file = treeSaver.choseFileToSaveTo();
		treeSaver.save(AppCore.getInstance().getTree().getModel().getRoot(),file);
		}
		catch (MyException e) {
			AppCore.getInstance().getExceptionManager().handleException(e);
		}
	}
}
