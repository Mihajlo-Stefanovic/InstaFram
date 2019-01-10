package controller.actions.actionListeners.treeListeners;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.SwingUtilities;

import app.AppCore;
import controller.actions.actionListeners.MyActionListener;
import controller.commands.treeCommands.AddNodesCommand;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;
import model.tree.nodes.ModuleNode;
import model.tree.nodes.MyTreeNode;
import model.tree.nodes.ParameterNode;
import model.tree.nodes.ProductNode;
import model.tree.nodes.SoftwareCompanyNode;
import model.tree.nodes.Workspace;
import view.dialogs.ModuleOrParameterDialog;
import view.dialogs.MyNewJDialog;
import view.dialogs.NewParameterDialog;
import view.dialogs.NewProductDialog;
import view.dialogs.NewSCompanyDialog;

public class AddNodeListener extends MyActionListener {

	@Override
	public void myActionPerformed(ActionEvent e) {
		try {
			if (AppCore.getInstance().getTree() == null) {
				throw new MyException(MyExceptionSubTypes.NEWNODELISTENER.NOTREE);
			}

			MyTreeNode nodeToAddTo = (MyTreeNode) AppCore.getInstance().getTree().getLastSelectedPathComponent();

			if (nodeToAddTo instanceof ParameterNode)
				throw new MyException(MyExceptionSubTypes.NEWNODELISTENER.ADDONPARAMETER);

			if (nodeToAddTo == null)
				nodeToAddTo = (MyTreeNode) AppCore.getInstance().getTree().getModel().getRoot();

			MyTreeNode nodeToAdd = showDialog(nodeToAddTo);
			if (nodeToAdd != null)
				AppCore.getInstance().getCommandManager()
						.addCommand(new AddNodesCommand(nodeToAddTo, new ArrayList<>(Arrays.asList(nodeToAdd))));

		} catch (MyException exception) {
			AppCore.getInstance().getExceptionManager().handleException(exception);
		}
	}

	private MyTreeNode showDialog(MyTreeNode nodeToAddTo) {
		MyNewJDialog dialog = null;
		MyTreeNode nodeToAdd = null;

		try {
			if (nodeToAddTo instanceof Workspace) {
				dialog = new NewSCompanyDialog(nodeToAddTo);
				nodeToAdd = (MyTreeNode) dialog.showDialog();
			}

			else if (nodeToAddTo instanceof SoftwareCompanyNode) {
				dialog = new NewProductDialog(nodeToAddTo);
				nodeToAdd = (MyTreeNode) dialog.showDialog();
			}

			else if (nodeToAddTo instanceof ProductNode) {
				dialog = new ModuleOrParameterDialog(nodeToAddTo);
				MyNewJDialog myNewJDialog = (MyNewJDialog) dialog.showDialog();
				nodeToAdd = (MyTreeNode) myNewJDialog.showDialog();
			}

			else if (nodeToAddTo instanceof ModuleNode) {
				dialog = new NewParameterDialog(nodeToAddTo);
				nodeToAdd = (MyTreeNode) dialog.showDialog();
			}
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getTree());
		} catch (NullPointerException exception) {

		}

		return nodeToAdd;
	}
}
