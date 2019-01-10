package model.tree.nodes;

public class ModuleNode extends MyTreeNode{

	private static final long serialVersionUID = -3709531843322559490L;

	private static int numOfInstances = 0;

	private String filePath;
	
	public ModuleNode(String name, String filePath) {
		super(name);
		this.filePath = filePath;
		setType(MyTreeNodeTypes.Module);
		numOfInstances++;
	}
	
	public ModuleNode(String filePath) {
		super("Module_" + numOfInstances);
		this.filePath = filePath;
		setType(MyTreeNodeTypes.Module);
		numOfInstances++;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
