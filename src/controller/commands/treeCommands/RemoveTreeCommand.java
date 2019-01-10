package controller.commands.treeCommands;

import app.AppCore;
import controller.commands.Command;
import model.tree.nodes.MyTreeNode;

public class RemoveTreeCommand implements Command {

	MyTreeNode root;

	@Override
	public void doCommand() {
		root = (MyTreeNode) AppCore.getInstance().getTree().getModel().getRoot();
		AppCore.getInstance().getMainFrame().getCenterPanel().getTreePanel().removeTree();
		AppCore.getInstance().getNodeTabPanel().getTabbedPane().removeAll();
	}

	@Override
	public void undoCommand() {
		Command counterCommand = new AddTreeCommand(root);
		counterCommand.doCommand();
	}

}
