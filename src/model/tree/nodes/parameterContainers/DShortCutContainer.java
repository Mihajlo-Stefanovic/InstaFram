package model.tree.nodes.parameterContainers;

import view.panels.parameterPanels.containerPanels.ContainerTypes;

public class DShortCutContainer extends ParameterContainer{

	private static final long serialVersionUID = 8590974562297385831L;
	
	private boolean toMake;
	private String filePath;
	
	public DShortCutContainer(String filePath) {
		super(ContainerTypes.DesktopShortcut,6);
		this.filePath = new String(filePath);
	}
	
	public DShortCutContainer(boolean toMake, String filePath) {
		super(ContainerTypes.DesktopShortcut,6);
		this.toMake = toMake;
		this.filePath = new String(filePath);
	}

	public boolean isToMake() {
		return toMake;
	}

	public void setToMake(boolean toSave) {
		this.toMake = toSave;
	}

	@Override
	public ParameterContainer getCopy() {
		return new DShortCutContainer(toMake,filePath);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof DShortCutContainer) {
			DShortCutContainer oth = (DShortCutContainer) obj;
				if(oth.isToMake() == toMake)
					return true;
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
