package model.tree.nodes.parameterContainers;

import view.panels.parameterPanels.containerPanels.ContainerTypes;

public class LogoContainer extends ParameterContainer {

	private static final long serialVersionUID = 5112048939607404784L;
	private String pathToPicture;

	public LogoContainer() {
		super(ContainerTypes.Logo,2);
	}

	public LogoContainer(String pathToPicture) {
		super(ContainerTypes.Logo,2);
		if(pathToPicture!=null)
			this.pathToPicture = new String(pathToPicture);
	}

	public String getPathToPicture() {
		return pathToPicture;
	}

	public void setPathToPicture(String pathToPicture) {
		this.pathToPicture = pathToPicture;
	}

	@Override
	public ParameterContainer getCopy() {
		return new LogoContainer(pathToPicture);
	}

	@Override
	public boolean equals(Object obj) {
		try {
			if (obj instanceof LogoContainer) {
				LogoContainer oth = (LogoContainer) obj;
				if(oth.getPathToPicture() == null && pathToPicture == null)
					return true;
				if (oth.getPathToPicture().equals(pathToPicture))
					return true;
			}
		} catch (NullPointerException e) {
		}
		return false;
	}
}
