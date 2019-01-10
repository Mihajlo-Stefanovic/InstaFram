package model.tree.nodes.parameterContainers;

import view.panels.parameterPanels.containerPanels.ContainerTypes;

public class AuthorContainer extends ParameterContainer {

	private static final long serialVersionUID = 4155674376304611430L;
	private String name;

	public AuthorContainer() {
		super(ContainerTypes.Author,1);
		this.name = new String();
	}

	public AuthorContainer(String name) {
		super(ContainerTypes.Author,1);
		if (name != null)
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
		return new AuthorContainer(name);
	}

	@Override
	public boolean equals(Object obj) {
		try {
			if (obj instanceof AuthorContainer) {
				AuthorContainer oth = (AuthorContainer) obj;
				if (oth.getName().equals(name))
					return true;
			}
		} catch (NullPointerException e) {
		}
		return false;
	}
}
