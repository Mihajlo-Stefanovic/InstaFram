package controller.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import app.AppCore;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;
import model.tree.nodes.MyTreeNode;

public class TreeJavaSerLoader extends Loader {

	@Override
	public void load(File file, Object toLoadTo) {
		assert file != null : "No File";
		if (toLoadTo instanceof MyTreeNode) {
			MyTreeNode nodeToLoadTo = (MyTreeNode) toLoadTo;

			try {
				FileInputStream fileIntputStream = new FileInputStream(file);
				ObjectInputStream objectIntputStream = new ObjectInputStream(fileIntputStream);
				MyTreeNode loadNode = (MyTreeNode) objectIntputStream.readObject();
				nodeToLoadTo.add(loadNode);

			} catch (FileNotFoundException e) {
				AppCore.getInstance().getExceptionManager()
						.handleException(new MyException(MyExceptionSubTypes.LOADER.IOEXCEPTION, e));
			} catch (IOException e) {
				AppCore.getInstance().getExceptionManager()
						.handleException(new MyException(MyExceptionSubTypes.LOADER.IOEXCEPTION, e));
			} catch (ClassNotFoundException e) {
				AppCore.getInstance().getExceptionManager()
						.handleException(new MyException(MyExceptionSubTypes.LOADER.IOEXCEPTION, e));
			} catch (ClassCastException e) {
				AppCore.getInstance().getExceptionManager()
						.handleException(new MyException(MyExceptionSubTypes.LOADER.IOEXCEPTION, e));
			}
		}
	}

}
