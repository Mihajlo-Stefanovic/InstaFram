package controller.commands.editCommands;

import java.util.ArrayList;
import app.AppCore;
import controller.commands.Command;
import controller.commands.treeCommands.RemoveNodesCommand;
import model.Pair;
import model.tree.nodes.MyTreeNode;

public class PasteCommand implements Command{

	MyTreeNode nodeToAddTo;
	ArrayList<MyTreeNode> nodesToPaste;
	ArrayList<MyTreeNode> nodesPasted;
	
	public PasteCommand(MyTreeNode nodeToAddTo, ArrayList<MyTreeNode> nodesToPaste) {
		this.nodesToPaste = nodesToPaste;
		this.nodeToAddTo = nodeToAddTo;
	}

	@Override
	public void doCommand() {
		nodesPasted = AppCore.getInstance().getTree().paste(nodeToAddTo, nodesToPaste);
	}

	@Override
	public void undoCommand() {
		ArrayList<Pair<MyTreeNode, MyTreeNode>> pairs = new ArrayList<Pair<MyTreeNode, MyTreeNode>>();
		
		for (MyTreeNode parameterNode : nodesPasted) {
			pairs.add(new Pair<MyTreeNode, MyTreeNode>(nodeToAddTo, parameterNode));
		}
		
		Command counterCommand = new RemoveNodesCommand(pairs,false);
		counterCommand.doCommand();
	}

}
