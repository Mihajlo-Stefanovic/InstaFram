package controller.actions.actionListeners.installListeners;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import app.AppCore;
import controller.actions.actionListeners.MyActionListener;
import model.InstallData;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;
import view.tabs.MyTab;
import view.tabs.TabSoftware;

public class InstallListener extends MyActionListener {

	@Override
	protected void myActionPerformed(ActionEvent event) {
		MyTab tab = ((MyTab) AppCore.getInstance().getNodeTabPanel().getTabbedPane()
				.getSelectedComponent());

		if (tab instanceof TabSoftware) {
			TabSoftware tabSoftware = (TabSoftware) tab;

			InstallData installData;
			File file = new File(tabSoftware.getExportPanel().getTfPath().getText());
			
			FileInputStream fileIntputStream;
			ObjectInputStream objectIntputStream;
			try {
				fileIntputStream = new FileInputStream(file);
				objectIntputStream = new ObjectInputStream(fileIntputStream);
				installData = (InstallData) objectIntputStream.readObject();
				
				AppCore.getInstance().getInstaller().install(installData);
			} catch (FileNotFoundException e) {
				AppCore.getInstance().getExceptionManager().handleException(new MyException(MyExceptionSubTypes.INSTALL.FILENOTVALID));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (ClassCastException e) {
				AppCore.getInstance().getExceptionManager().handleException(new MyException(MyExceptionSubTypes.INSTALL.FILENOTVALID));
			}
		}
	}

}
