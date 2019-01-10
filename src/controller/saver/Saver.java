package controller.saver;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import app.AppCore;

public abstract class Saver {
	
	protected File defaultFile;
	
	public File choseFileToSaveTo() {
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("Save As");
		jfc.showSaveDialog(AppCore.getInstance().getMainFrame());
		
		File file = jfc.getSelectedFile();
		
		if(file!=null)
			defaultFile = file;
		
		return file;
	}
	
	public abstract void save(Object o, File file);
	public abstract void save(Object o);
	/**
	 * Shows dialog for user to chose to close app or save first.
	 * @return True if user chose to close app. False if user chose cancel.
	 */
	public boolean notSavedWarning() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (null, "PROJECT IS UNSAVED. Close?","Warning",dialogButton);
		return dialogResult == JOptionPane.YES_OPTION;
	}

	public File getDefaultFile() {
		return defaultFile;
	}

	public void setDefaultFile(File defaultFile) {
		this.defaultFile = defaultFile;
	}
	
}
