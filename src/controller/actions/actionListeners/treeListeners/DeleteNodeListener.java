package controller.actions.actionListeners.treeListeners;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.tree.TreePath;

import app.AppCore;
import controller.actions.actionListeners.MyActionListener;
import controller.commands.treeCommands.RemoveNodesCommand;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;
import model.tree.MyJTree;
import model.tree.nodes.MyTreeNode;

public class DeleteNodeListener extends MyActionListener {

	@Override
	public void myActionPerformed(ActionEvent arg0) {
		try {
		if(AppCore.getInstance().getTree()==null)
		{
			throw new MyException(MyExceptionSubTypes.DELETENODELISTENER.NOPROJECT);
		}
		
		ArrayList<MyTreeNode> selectedNodes = new ArrayList<>();
		
		MyJTree tree = AppCore.getInstance().getTree();
		ArrayList<TreePath> paths = new ArrayList<>(Arrays.asList(tree.getSelectionPaths()));
		
		for (TreePath treePath : paths) {
			MyTreeNode node = (MyTreeNode)treePath.getLastPathComponent();
			selectedNodes.add(node);
		}
		
		if(selectedNodes.size()<=0)
		{
			throw new MyException(MyExceptionSubTypes.DELETENODELISTENER.NONODESELECTED);
		}
		
		for (MyTreeNode node : selectedNodes) {
			if (node == AppCore.getInstance().getTree().getModel().getRoot()) {
				throw new MyException(MyExceptionSubTypes.DELETENODELISTENER.DELETEROOT);
			}
		}
		
		AppCore.getInstance().getCommandManager().addCommand(new RemoveNodesCommand(selectedNodes));
		
		}
		catch(MyException e) {
			AppCore.getInstance().getExceptionManager().handleException(e);
		}
	}

}
