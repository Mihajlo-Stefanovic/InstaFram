package controller.commands.treeCommands;

import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import app.AppCore;
import controller.commands.Command;
import model.Pair;
import model.tree.MyTreeModel;
import model.tree.nodes.MyTreeNode;

public class AddNodesCommand implements Command {

	ArrayList<Pair<MyTreeNode, MyTreeNode>> nodePairs;

	public AddNodesCommand(MyTreeNode nodeToAddTo, ArrayList<MyTreeNode> nodesToAdd) {

		ArrayList<Pair<MyTreeNode, MyTreeNode>> nodePairs = new ArrayList<>();

		for (MyTreeNode node : nodesToAdd) {
			nodePairs.add(new Pair<MyTreeNode, MyTreeNode>(nodeToAddTo, node));
		}

		this.nodePairs = nodePairs;
	}

	public AddNodesCommand(ArrayList<Pair<MyTreeNode, MyTreeNode>> nodePairs, boolean stupid) {
		this.nodePairs = nodePairs;
	}

	@Override
	public void doCommand() {		
		MyTreeModel model = (MyTreeModel) AppCore.getInstance().getTree().getModel();
		TreePath lastPath = null;
		
		for (Pair<MyTreeNode, MyTreeNode> pair : nodePairs) {
			lastPath = new TreePath(model.getPathToRoot(pair.getSecond()));
			AppCore.getInstance().getTree().expandPath(new TreePath(model.getPathToRoot(pair.getFirst())));
			
			pair.getFirst().add(pair.getSecond());
		}
		
		AppCore.getInstance().getTree().setSelectionPath(lastPath);
		
		SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getTree());
	}

	@Override
	public void undoCommand() {
		Command counterCommand = new RemoveNodesCommand(nodePairs,true);
		counterCommand.doCommand();
	}

}
