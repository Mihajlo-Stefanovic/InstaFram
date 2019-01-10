package controller.commands.treeCommands;

import java.util.ArrayList;
import javax.swing.SwingUtilities;

import app.AppCore;
import controller.commands.Command;
import model.Pair;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;
import model.tree.nodes.MyTreeNode;

public class RemoveNodesCommand implements Command {

	ArrayList<Pair<MyTreeNode, MyTreeNode>> nodePairs;

	public RemoveNodesCommand(ArrayList<MyTreeNode> nodesToRemove) {

		ArrayList<Pair<MyTreeNode, MyTreeNode>> nodePairs = new ArrayList<>();

		for (MyTreeNode node : nodesToRemove) {
			nodePairs.add(new Pair<MyTreeNode, MyTreeNode>((MyTreeNode) node.getParent(), node));
		}

		this.nodePairs = nodePairs;
	}

	public RemoveNodesCommand(ArrayList<Pair<MyTreeNode, MyTreeNode>> nodePairs, boolean stupid) {
		this.nodePairs = nodePairs;
	}

	@Override
	public void doCommand() {
		for (Pair<MyTreeNode, MyTreeNode> pair : nodePairs) {
			try {
				if (pair.getSecond() == AppCore.getInstance().getTree().getModel().getRoot()) {
					throw new MyException(MyExceptionSubTypes.DELETENODELISTENER.DELETEROOT);
				}
				if (pair.getSecond() != null) {
					AppCore.getInstance().getNodeTabPanel().closeTabForNode(pair.getSecond());
					pair.getSecond().removeFromParent();
				}
			} catch (MyException e) {
				e.printStackTrace();
			}
		}
		SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getTree());
	}

	@Override
	public void undoCommand() {
		Command counterCommand = new AddNodesCommand(nodePairs, true);
		counterCommand.doCommand();
	}

}
