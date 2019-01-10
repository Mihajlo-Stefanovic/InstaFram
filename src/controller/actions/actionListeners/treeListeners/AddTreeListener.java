package controller.actions.actionListeners.treeListeners;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.SwingUtilities;

import app.AppCore;
import controller.actions.actionListeners.MyActionListener;
import controller.loader.Loader;
import model.tree.nodes.MyTreeNode;

public class AddTreeListener extends MyActionListener {

	@Override
	public void myActionPerformed(ActionEvent event) {
			Loader treeLoader = AppCore.getInstance().getLoader();
			File fileToRead = treeLoader.choseTextFileToLoadFrom();

			if (fileToRead != null)
			{
				MyTreeNode nodeToAddTo;
				if (AppCore.getInstance().getTree() == null) {
					//throw new MyException(ExceptionSubTypes.ADDTREELISTENER.NOPROJECT);
					AppCore.getInstance().getMainFrame().getCenterPanel().getTreePanel().addTree();
					nodeToAddTo = (MyTreeNode) AppCore.getInstance().getTree().getModel().getRoot();
					nodeToAddTo.setName("Work Space");
				}
				else {
				nodeToAddTo = (MyTreeNode) AppCore.getInstance().getTree().getLastSelectedPathComponent();
				}
				
				if (nodeToAddTo == null) {
					//throw new MyException(ExceptionSubTypes.ADDTREELISTENER.NONODESELECTED);
				}
				
				treeLoader.load(fileToRead, nodeToAddTo);
				SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getTree());
			}
	}

}
