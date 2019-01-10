package model.tree.nodes.parameterContainers;

import java.io.Serializable;

import model.tree.nodes.ParameterNode;
import view.panels.parameterPanels.containerPanels.ContainerTypes;

public abstract class ParameterContainer implements Serializable{

	private static final long serialVersionUID = -3635621522969570031L;
	
	ParameterNode parameterNode;
	ContainerTypes containerType;
	
	public final Integer priority;
	
	public abstract ParameterContainer getCopy();

	protected ParameterContainer(ContainerTypes containerType, Integer priority) {
		this.containerType = containerType;
		this.priority = priority;
	}
	
	public ParameterNode getParameterNode() {
		return parameterNode;
	}

	public void setParameterNode(ParameterNode parameterNode) {
		this.parameterNode = parameterNode;
	}

	public ContainerTypes getContainerType() {
		return containerType;
	}
	
}
