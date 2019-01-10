package controller.commands.editCommands;

import java.util.ArrayList;

import app.AppCore;
import controller.commands.Command;
import model.MyTransferable;
import model.tree.nodes.MyTreeNode;

public class CopyCommand implements Command {

	ArrayList<MyTreeNode> nodesToCopy;
	
	
	public CopyCommand(ArrayList<MyTreeNode> nodesToCopy) {
		this.nodesToCopy = nodesToCopy;
	}

	@Override
	public void doCommand() {
		MyTransferable nodeSelectionCB = new MyTransferable(nodesToCopy);
		AppCore.getInstance().getClipBoard().setContents(nodeSelectionCB, AppCore.getInstance());
	}

	@Override
	public void undoCommand() {
		System.out.println("Can't undo Copy Command.");
	}

}
