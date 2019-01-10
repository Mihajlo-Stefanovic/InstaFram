package model.tree.nodes;

import java.util.ArrayList;

import model.Pair;
import model.tree.nodes.parameterContainers.ParameterContainer;

public class ProductNode extends MyTreeNode {

	private static final long serialVersionUID = -1511654668421233370L;

	private static int numOfInstances = 0;

	private String filePath;
	
	private ArrayList<Pair<String, ArrayList<ParameterContainer>>> instalData;
	
	public ProductNode(String name) {
		super(name);
		setType(MyTreeNodeTypes.Product);
		numOfInstances++;
	}

	public ProductNode() {
		super("Product_" + numOfInstances);
		setType(MyTreeNodeTypes.Product);
		numOfInstances++;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
