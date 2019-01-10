package controller.actions.actionListeners.editListeners;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.tree.TreePath;

import app.AppCore;
import controller.actions.actionListeners.MyActionListener;
import controller.commands.editCommands.CopyCommand;
import model.tree.MyJTree;
import model.tree.nodes.MyTreeNode;
import model.tree.nodes.MyTreeNodeTypes;

public class TreeCopyListener extends MyActionListener{

	@Override
	protected void myActionPerformed(ActionEvent event) {
		ArrayList<MyTreeNode> selectedNodes = new ArrayList<>();
		
		MyJTree tree = AppCore.getInstance().getTree();
		ArrayList<TreePath> paths = new ArrayList<>(Arrays.asList(tree.getSelectionPaths()));
		
		for (TreePath treePath : paths) {
			MyTreeNode node = (MyTreeNode)treePath.getLastPathComponent();
			
			if(node.getType().equals(MyTreeNodeTypes.Parameter))//can only only copy parameter
				selectedNodes.add(node);
		}
		
		if(selectedNodes.size()>0)
			(new CopyCommand(selectedNodes)).doCommand();
	}

}
