package model.tree;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import app.AppCore;
import controller.commands.treeCommands.AddNodesCommand;
import model.tree.nodes.ModuleNode;
import model.tree.nodes.MyTreeNode;
import model.tree.nodes.MyTreeNodeTypes;
import model.tree.nodes.ParameterNode;
import model.tree.nodes.ProductNode;

public class MyJTree extends JTree {

	private static final long serialVersionUID = 8790342390812747766L;

	public MyJTree() {
		super();
		this.setModel(new MyTreeModel());
	}

	public MyJTree(JTree oth) { // copies using two queues

		MyTreeModel model = new MyTreeModel();

		if (oth != null && oth.getModel().getRoot() != null) {

			LinkedBlockingQueue<MyTreeNode> nodesToVisitOth = new LinkedBlockingQueue<>();
			LinkedBlockingQueue<MyTreeNode> nodesToVisitThis = new LinkedBlockingQueue<>();

			nodesToVisitOth.add((MyTreeNode) oth.getModel().getRoot());
			MyTreeNode currNode;

			nodesToVisitThis.add(getCopyOf((MyTreeNode) oth.getModel().getRoot()));
			MyTreeNode nodeToAddTo;

			model.setRoot(nodesToVisitThis.peek());

			while (!nodesToVisitOth.isEmpty()) {
				currNode = nodesToVisitOth.remove();
				nodeToAddTo = nodesToVisitThis.remove();

				for (MyTreeNode child : currNode.getChildren()) {
					MyTreeNode newChild = getCopyOf(child);
					nodeToAddTo.add(newChild);

					nodesToVisitOth.add(child);
					nodesToVisitThis.add(newChild);
				}
			}
		}

		this.setModel(model);
	}

	// hack
	private MyTreeNode getCopyOf(MyTreeNode myTreeNode) {
		if (myTreeNode instanceof ParameterNode)
			return new ParameterNode((ParameterNode) myTreeNode);
		else
			return new MyTreeNode(myTreeNode);
	}

	public boolean equalsTree(Object obj) {
		if (obj instanceof MyJTree) {
			MyJTree oth = (MyJTree) obj;
			return identicalTrees((MyTreeNode) this.getModel().getRoot(), (MyTreeNode) oth.getModel().getRoot());
		}
		return false;
	}

	private boolean identicalTrees(MyTreeNode a, MyTreeNode b) {
		if (a == null && b == null)
			return true;

		if (a != null && b != null) {
			boolean ret = a.myEquals(b);
			if (ret)
				for (int i = 0; i < a.getChildCount(); i++) {
					try {
						ret = ret && identicalTrees((MyTreeNode) a.getChildAt(i), (MyTreeNode) b.getChildAt(i));
					} catch (IndexOutOfBoundsException e) {
						ret = false;
					}
				}

			return ret;
		}

		return false;
	}

	public static void sysoTree(MyJTree myJTree) {
		LinkedBlockingQueue<MyTreeNode> nodesToVisit = new LinkedBlockingQueue<>();
		nodesToVisit.add((MyTreeNode) myJTree.getModel().getRoot());

		MyTreeNode currNode;

		while (!nodesToVisit.isEmpty()) {
			currNode = nodesToVisit.remove();
			System.out.println(currNode.getName() + "\n" + currNode.getDescription() + "\n--------");

			for (MyTreeNode child : currNode.getChildren()) {
				nodesToVisit.add(child);
			}

		}
	}

	public ArrayList<MyTreeNode> paste(MyTreeNode nodeToAddTo, ArrayList<MyTreeNode> nodesToPaste) {
		if (nodeToAddTo == null)
			return null;
		
		ArrayList<MyTreeNode> newNodes = new ArrayList<>();

		if (nodeToAddTo instanceof ModuleNode || nodeToAddTo instanceof ProductNode) {
			
			for (MyTreeNode myTreeNode : nodesToPaste) {
				ParameterNode newNode = new ParameterNode((ParameterNode)myTreeNode); //hack
				newNodes.add(newNode);
			}

			new AddNodesCommand(nodeToAddTo, newNodes).doCommand();
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getTree());
			
			return newNodes;
		}
		
		return null;
	}

	public MyTreeNodeTypes getBiggestNodeInPaths(ArrayList<TreePath> paths) {

		ArrayList<MyTreeNode> selectedNodes = new ArrayList<>();

		for (TreePath treePath : paths) {
			MyTreeNode node = (MyTreeNode) treePath.getLastPathComponent();
			selectedNodes.add(node);
		}

		if (selectedNodes.size() > 0) {
			MyTreeNodeTypes maxType = selectedNodes.get(0).getType();

			for (MyTreeNode node : selectedNodes) {
				if (node.getType().getValue() < maxType.getValue())
					maxType = node.getType();
			}
			return maxType;
		}

		return null;
	}

	// OLD VERSION, not working for parameters
	/*
	 * @Override public boolean equals(Object obj) {
	 * 
	 * if (obj instanceof MyJTree) { MyJTree oth = (MyJTree) obj;
	 * 
	 * if (oth != null && oth.getModel().getRoot() != null) {
	 * 
	 * LinkedBlockingQueue<MyTreeNode> nodesToVisitOth = new
	 * LinkedBlockingQueue<>(); nodesToVisitOth.add((MyTreeNode)
	 * oth.getModel().getRoot());
	 * 
	 * LinkedBlockingQueue<MyTreeNode> nodesToVisitThis = new
	 * LinkedBlockingQueue<>(); nodesToVisitThis.add((MyTreeNode)
	 * this.getModel().getRoot());
	 * 
	 * MyTreeNode currNodeOth = new MyTreeNode(nodesToVisitOth.peek()); MyTreeNode
	 * currNodeThis = new MyTreeNode(nodesToVisitThis.peek());
	 * 
	 * while (!nodesToVisitOth.isEmpty() && !nodesToVisitThis.isEmpty()) {
	 * currNodeOth = nodesToVisitOth.remove(); currNodeThis =
	 * nodesToVisitThis.remove();
	 * 
	 * if (!currNodeOth.equals(currNodeThis)) return false;
	 * 
	 * for (MyTreeNode childOth : currNodeOth.getChildren()) {
	 * nodesToVisitOth.add(childOth); }
	 * 
	 * for (MyTreeNode childThis : currNodeThis.getChildren()) {
	 * nodesToVisitOth.add(childThis); } }
	 * 
	 * return true; } } return false; }
	 */
}
