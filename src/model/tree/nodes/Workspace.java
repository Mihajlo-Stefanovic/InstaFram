package model.tree.nodes;

public class Workspace extends MyTreeNode {

	private static final long serialVersionUID = 8288313781460168000L;
	
	private static int numOfInstances = 0;

	public Workspace(String name) {
		super(name);
		setType(MyTreeNodeTypes.WorkSpace);
		numOfInstances++;
	}

	public Workspace() {
		super("Workspace_" + numOfInstances);
		setType(MyTreeNodeTypes.WorkSpace);
		numOfInstances++;
	}
}
