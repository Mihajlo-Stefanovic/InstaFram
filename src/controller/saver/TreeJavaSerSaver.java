package controller.saver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import app.AppCore;
import model.tree.nodes.MyTreeNode;

public class TreeJavaSerSaver extends Saver {

	@Override
	public void save(Object o, File file) {
		if(o instanceof MyTreeNode && file!=null){
			MyTreeNode nodeToSave = (MyTreeNode) o;
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				
				objectOutputStream.writeObject(o);
				AppCore.getInstance().getTree().setSavedVersion();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			//throws custom exception
		}
	}

	@Override
	public void save(Object o) {
		File file;
		if(defaultFile==null)
			file = choseFileToSaveTo();
		else
			file = defaultFile;
		
		save(o,file);
	}

}
