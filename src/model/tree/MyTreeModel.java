package model.tree;

import javax.swing.tree.DefaultTreeModel;
import model.tree.nodes.MyTreeNode;
import model.tree.nodes.Workspace;

public class MyTreeModel extends DefaultTreeModel {

	private static final long serialVersionUID = 4984693762264821369L;

	public MyTreeModel() {
		super(new MyTreeNode());
		setRoot(new Workspace());
	}

	public void addNode(MyTreeNode newNode) {
		((MyTreeNode) getRoot()).add(newNode);
	}

	public void setRoot(Workspace root) {
		super.setRoot(root);
	}

}
