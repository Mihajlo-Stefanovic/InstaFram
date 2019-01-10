package view.tabs;

import javax.swing.JPanel;

import model.tree.nodes.MyTreeNode;

public abstract class MyTab extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3013776549726233521L;
	protected MyTreeNode node;
	
	protected MyTab(MyTreeNode node) {
		this.node = node;
		initialize();
		putValuesForNode(node);
	}

	protected abstract void initialize();
	
	protected abstract void putValuesForNode(MyTreeNode node);

	public MyTreeNode getNode() {
		return node;
	}

	public void setNode(MyTreeNode node) {
		this.node = node;
	}
	
	@Override
	public boolean equals(Object oth) {
		if (oth instanceof MyTab) {
			if (((MyTab) oth).getNode() == this.node) {
				return true;
			}
		}
		return false;
	}
}
