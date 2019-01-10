package model.tree.nodes;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import observer.MyObservable;
import observer.MyObserver;

public class MyTreeNode implements MutableTreeNode, MyObservable, Serializable {
	
	private static final long serialVersionUID = -3859460596526251327L;

	private static int numOfInstances = 0;

	private String name;

	private ArrayList<MyTreeNode> children;

	private MyTreeNode parent;

	private boolean isLeaf;

	private String description;

	private MyTreeNodeTypes type = MyTreeNodeTypes.BasicNode;

	transient private ArrayList<MyObserver> observers;

	public MyTreeNode() {
		initialize("Node_" + numOfInstances);
	}

	public MyTreeNode(String name) {
		initialize(name);
	}

	public MyTreeNode(MyTreeNode oth) {
		if (oth.name != null)
			this.name = new String(oth.name);
		if (oth.description != null)
			this.description = new String(oth.description);

		isLeaf = true; // new node is always leaf
		this.type = oth.type;

		children = new ArrayList<>();
		observers = new ArrayList<>();
	}

	private void initialize(String name) {
		observers = new ArrayList<>();
		children = new ArrayList<>();

		this.name = new String(name);
		
		setInitialDescription();
		
		isLeaf = true;
		numOfInstances++;
	}

	private void readObject(java.io.ObjectInputStream in) {
		try {
			in.defaultReadObject();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("File not valid.");
		}
		observers = new ArrayList<>();
	}

	public boolean myEquals(Object obj) {
		if (obj instanceof MyTreeNode) {
			MyTreeNode oth = (MyTreeNode) obj;
			if (oth.name.equals(name)) {
				if (oth.description.equals(description))
					if(oth.type == this.type)
						return true;
			}
		}
		return false;
	}

	public void setInitialDescription() {
		this.description = new String();
		description = name + "\n" + "Description:\n";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyObservers();
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public Enumeration children() {
		return (Enumeration<MyTreeNode>) children;
	}

	public ArrayList<MyTreeNode> getChildren() {
		return children;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int index) {
		return children.get(index);
	}

	@Override
	public int getChildCount() {
		return children.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return children.indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public boolean isLeaf() {
		return isLeaf;
	}

	@Override
	public void insert(MutableTreeNode newChild, int index) {
		if (newChild != null) {
			if (this.isLeaf)
				isLeaf = false;

			for (MyTreeNode child : children) {
				if (child == newChild) {
					return;
				}
			}

			//if (newChild.getParent() != null)
				//newChild.removeFromParent();

			children.add(index, (MyTreeNode) newChild);
			newChild.setParent(this);
			notifyObservers();
		}
	}

	public void add(MutableTreeNode newChild) {
		insert(newChild, getChildCount());
	}

	@Override
	public void remove(int index) {
		children.get(index).setParent(null);
		chekIfIsLeaf();
		children.remove(index);
		notifyObservers();
	}

	@Override
	public void remove(MutableTreeNode childToRemove) {
		children.remove(childToRemove);
		chekIfIsLeaf();
		childToRemove.setParent(null);
		notifyObservers();
	}

	@Override
	public void removeFromParent() {
		if (parent != null) {
			parent.remove(this);
			this.setParent(null);
		}
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		parent = (MyTreeNode) newParent;
		if (parent != null && !parent.children.contains(this))
			((MyTreeNode) newParent).add(this);
	}

	@Override
	public void setUserObject(Object object) {
		System.err.println("NOT IMPLEMENTED");
	}

	public void chekIfIsLeaf() {
		if (children.isEmpty())
			this.isLeaf = true;
	}

	public static int getNumOfInstances() {
		return numOfInstances;
	}

	public static void setNumOfInstances(int numOfInstances) {
		MyTreeNode.numOfInstances = numOfInstances;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		notifyObservers();
	}

	public int getAllChildrenCount(Boolean lookingForLeaf, int level) {
		int s = 0;
		if ((!lookingForLeaf || isLeaf) && level != 0)
			s += 1;

		for (MyTreeNode child : getChildren()) {
			s += child.getAllChildrenCount(lookingForLeaf, level + 1);
		}

		return s;
	}

	@Override
	public void registerObserver(MyObserver newObserver) {
		if (newObserver != null && !observers.contains(newObserver))
			observers.add(newObserver);
	}

	@Override
	public void unregisterObserver(Object observerToRemove) {
		observers.remove(observerToRemove);
	}

	@Override
	public void notifyObservers() {
		for (MyObserver observer : observers) {
			observer.update(this);
		}
	}

	@Override
	public boolean hasObserver(Object o) {
		return observers.contains(o);
	}

	public MyTreeNodeTypes getType() {
		return type;
	}

	public void setType(MyTreeNodeTypes type) {
		this.type = type;
	}

	// @Override
	/*
	 * public boolean equals(Object obj) { if(obj instanceof MyTreeNode) {
	 * MyTreeNode oth = (MyTreeNode) obj; if(oth.name.equals(this.name)) { return
	 * true; } } return false; }
	 */
}
