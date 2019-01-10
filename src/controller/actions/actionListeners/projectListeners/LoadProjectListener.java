package controller.actions.actionListeners.projectListeners;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.SwingUtilities;

import app.AppCore;
import controller.actions.actionListeners.MyActionListener;
import controller.loader.Loader;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;
import model.tree.MyJTree;
import model.tree.MyTreeModel;
import model.tree.nodes.MyTreeNode;

public class LoadProjectListener extends MyActionListener {

	@Override
	public void myActionPerformed(ActionEvent e) {

		boolean open = false;
		if (AppCore.getInstance().getTree() != null && !AppCore.getInstance().getTree().isSaved()) {
			if (!AppCore.getInstance().getTree().isSaved()) {
				open = AppCore.getInstance().getSaver().notSavedWarning();
			} else
				open = true;
		} else
			open = true;

		if (open) {
			Loader treeLoader = AppCore.getInstance().getLoader();

			File fileToRead = treeLoader.choseTextFileToLoadFrom();
			try {
				if (fileToRead != null) {
					MyTreeNode nodeToAddTo = new MyTreeNode();
					treeLoader.load(fileToRead, nodeToAddTo);

					if (nodeToAddTo.getChildCount() == 0) {
						throw new MyException(MyExceptionSubTypes.LOADPROJECTLISTENER.FILEEMPTY);
					}

					AppCore.getInstance().getMainFrame().getCenterPanel().getTreePanel().addTree();
					AppCore.getInstance().getNodeTabPanel().getTabbedPane().removeAll();
					
					if (nodeToAddTo.getChildCount() == 1) {
						((MyTreeModel) AppCore.getInstance().getTree().getModel()).setRoot(nodeToAddTo.getChildAt(0));
						
						AppCore.getInstance().getTree().setSavedVersion();
						SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getTree());
						
					} else {
						nodeToAddTo.setName("Root");
						((MyTreeModel) AppCore.getInstance().getTree().getModel()).setRoot(nodeToAddTo);
						
						AppCore.getInstance().getTree().setSavedVersion();
						SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getTree());
						
						throw new MyException(MyExceptionSubTypes.LOADPROJECTLISTENER.NEWROOTADDED);
					}
					expandAllNodes(AppCore.getInstance().getTree(), 0, AppCore.getInstance().getTree().getRowCount());
				}
			} catch (MyException exception) {
				AppCore.getInstance().getExceptionManager().handleException(exception);
			}
		}
	}
	
	private void expandAllNodes(MyJTree tree, int startingIndex, int rowCount){
	    for(int i=startingIndex;i<rowCount;++i){
	        tree.expandRow(i);
	    }

	    if(tree.getRowCount()!=rowCount){
	        expandAllNodes(tree, rowCount, tree.getRowCount());
	    }
	}
}
