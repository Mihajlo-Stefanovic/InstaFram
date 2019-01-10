package model.tree.nodes.parameterContainers;

import view.panels.parameterPanels.containerPanels.ContainerTypes;

public class NameContainer extends ParameterContainer {

	private static final long serialVersionUID = 7891212561099927473L;
	private String name;

	public NameContainer() {
		super(ContainerTypes.Name,3);
		name = new String();
	}

	public NameContainer(String name) {
		super(ContainerTypes.Name,3);
		if(name!=null)
			this.name = new String(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public ParameterContainer getCopy() {
		return new NameContainer(name);
	}

	@Override
	public boolean equals(Object obj) {
		try {
			if (obj instanceof NameContainer) {
				NameContainer oth = (NameContainer) obj;
				if (oth.getName().equals(name))
					return true;
			}
		} catch (NullPointerException e) {
		}
		return false;
	}
}
