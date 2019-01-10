package controller.actions.actionListeners.editListeners;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import app.AppCore;
import controller.actions.actionListeners.MyActionListener;
import controller.commands.editCommands.PasteCommand;
import model.tree.nodes.MyTreeNode;

public class TreePasteListener extends MyActionListener{

	@Override
	protected void myActionPerformed(ActionEvent event) {//trenutno samo za parametar radi
		Transferable clipboardContent = AppCore.getInstance().getClipBoard().getContents(AppCore.getInstance()); 
		DataFlavor arrayListParameter = null;
		arrayListParameter = new DataFlavor((new ArrayList<>()).getClass(),"Array Lista");
		
		if ((clipboardContent != null) &&
			 	(clipboardContent.isDataFlavorSupported (arrayListParameter))) {
			try {
				ArrayList<MyTreeNode> nodesToPaste = (ArrayList<MyTreeNode>)
						clipboardContent.getTransferData (arrayListParameter);
				
				MyTreeNode nodeToAddTo = (MyTreeNode) AppCore.getInstance().getTree().getLastSelectedPathComponent();

				if (nodeToAddTo == null)
					return;
				
				if(nodesToPaste.size()>0)
					AppCore.getInstance().getCommandManager().addCommand(new PasteCommand(nodeToAddTo,nodesToPaste));
				
			} catch (UnsupportedFlavorException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}
	
}
