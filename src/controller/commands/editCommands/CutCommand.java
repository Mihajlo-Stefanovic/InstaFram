package controller.commands.editCommands;

import java.util.ArrayList;
import controller.commands.Command;
import controller.commands.treeCommands.AddNodesCommand;
import controller.commands.treeCommands.RemoveNodesCommand;
import model.Pair;
import model.tree.nodes.MyTreeNode;

public class CutCommand implements Command {

	ArrayList<Pair<MyTreeNode, MyTreeNode>> nodePairs;

	public CutCommand(ArrayList<MyTreeNode> nodesToCut) {
		ArrayList<Pair<MyTreeNode, MyTreeNode>> nodePairs = new ArrayList<>();

		for (MyTreeNode node : nodesToCut) {
			nodePairs.add(new Pair<MyTreeNode, MyTreeNode>((MyTreeNode) node.getParent(), node));
		}

		this.nodePairs = nodePairs;
	}

	@Override
	public void doCommand() {
		ArrayList<MyTreeNode> nodesToCut = new ArrayList<>();
		
		for (Pair<MyTreeNode, MyTreeNode> pair : nodePairs) {
			nodesToCut.add(pair.getSecond());
		}
		
		(new CopyCommand(nodesToCut)).doCommand();
		(new RemoveNodesCommand(nodePairs,true)).doCommand();
	}

	@Override
	public void undoCommand() {
		Command counterCommand = new AddNodesCommand(nodePairs,true);
		counterCommand.doCommand();
	}

}
