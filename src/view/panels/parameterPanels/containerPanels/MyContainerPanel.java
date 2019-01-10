package view.panels.parameterPanels.containerPanels;

import javax.swing.JPanel;

import model.tree.nodes.parameterContainers.ParameterContainer;

public abstract class MyContainerPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8992947095246022115L;
	protected ParameterContainer container;
	protected boolean editable;
	
	public MyContainerPanel(Boolean editable) {
		this.editable = editable;
		initialize();
	}
	
	public MyContainerPanel(ParameterContainer container, Boolean editable) {
		this.editable = editable;
		initialize();
		setContainer(container);
	}
	
	protected abstract void initialize();
	
	public ParameterContainer getContainer() {
		return container;
	}

	public void setContainer(ParameterContainer container) {
		this.container = container;
	}
	
	public abstract void showContainerValues();
	public abstract void saveContainerValues();
}
