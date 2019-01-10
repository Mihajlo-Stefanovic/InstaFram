package view.panels.installationPanels.installationContainerPanels;

import model.tree.nodes.parameterContainers.ParameterContainer;
import view.panels.installationPanels.InstallationPanel;

public abstract class InstallationContainerPanel extends InstallationPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5479321365522810816L;
	protected ParameterContainer container;
	
	public InstallationContainerPanel() {
		initialize();
	}
	
	public InstallationContainerPanel(ParameterContainer container) {
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
}
