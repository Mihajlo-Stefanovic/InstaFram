package controller.loader;

import java.io.File;

import javax.swing.JFileChooser;
import app.AppCore;

public abstract class Loader {

	public File choseTextFileToLoadFrom() {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.showOpenDialog(AppCore.getInstance().getMainFrame());

		File file = jfc.getSelectedFile();

		if (file != null)
			AppCore.getInstance().getSaver().setDefaultFile(file);

		return file;
	}

	public abstract void load(File file, Object toLoadTo);
}
