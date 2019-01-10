package controller.commands.treeCommands;

import app.AppCore;
import controller.commands.Command;
import model.tree.MyTreeModel;
import model.tree.nodes.MyTreeNode;

public class AddTreeCommand implements Command{

	MyTreeNode root;
	
	public AddTreeCommand(MyTreeNode root) {
		this.root = root;
	}

	@Override
	public void doCommand() {
		AppCore.getInstance().getMainFrame().getCenterPanel().getTreePanel().addTree();
		((MyTreeNode) AppCore.getInstance().getTree().getModel().getRoot()).setInitialDescription();
		((MyTreeModel) AppCore.getInstance().getTree().getModel()).setRoot(root);
	}

	@Override
	public void undoCommand() {
		Command counterCommand = new RemoveTreeCommand();
		counterCommand.doCommand();
	}

}
