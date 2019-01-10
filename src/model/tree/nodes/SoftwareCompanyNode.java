package model.tree.nodes;

public class SoftwareCompanyNode extends MyTreeNode {

	private static final long serialVersionUID = -5419216872610729253L;
	
	private static int numOfInstances = 0;
	
	public SoftwareCompanyNode(String name) {
		super(name);
		setType(MyTreeNodeTypes.SoftwareCompany);
		numOfInstances++;
	}

	public SoftwareCompanyNode() {
		super("Company_" + numOfInstances);
		setType(MyTreeNodeTypes.SoftwareCompany);
		numOfInstances++;
	}

}
