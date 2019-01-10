package model.tree.nodes.parameterContainers;

import view.panels.parameterPanels.containerPanels.ContainerTypes;

public class StartAIContainer extends ParameterContainer {

	private static final long serialVersionUID = -271155620791606342L;
	
	private boolean toStart;
	private String filePath;
	
	public StartAIContainer(String filePath) {
		super(ContainerTypes.StartAfterInstalation,5);
		this.filePath = new String(filePath);
	}

	public StartAIContainer(boolean toStart, String filePath) {
		super(ContainerTypes.StartAfterInstalation,5);
		this.toStart = toStart;
		this.filePath = new String(filePath);
	}

	public boolean isToStart() {
		return toStart;
	}

	public void setToStart(boolean toStart) {
		this.toStart = toStart;
	}

	@Override
	public ParameterContainer getCopy() {
		return new StartAIContainer(toStart,filePath);
	}

	@Override
	public boolean equals(Object obj) {
		try {
			if (obj instanceof StartAIContainer) {
				StartAIContainer oth = (StartAIContainer) obj;
				if (oth.isToStart() == toStart)
					return true;
			}
		} catch (NullPointerException e) {
		}
		return false;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
