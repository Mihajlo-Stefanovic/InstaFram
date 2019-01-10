package model.tree.nodes;

import model.tree.nodes.parameterContainers.AuthorContainer;
import model.tree.nodes.parameterContainers.CustomContainer;
import model.tree.nodes.parameterContainers.DShortCutContainer;
import model.tree.nodes.parameterContainers.LogoContainer;
import model.tree.nodes.parameterContainers.LookAndFeelContainer;
import model.tree.nodes.parameterContainers.NameContainer;
import model.tree.nodes.parameterContainers.ParameterContainer;
import model.tree.nodes.parameterContainers.StartAIContainer;
import model.tree.nodes.parameterContainers.TOUContainer;
import view.panels.parameterPanels.containerPanels.ContainerTypes;

public class ParameterNode extends MyTreeNode {

	private static final long serialVersionUID = -3277372789980613115L;

	private static int numOfInstances = 0;

	private ParameterSubtypes subType;
	private ParameterContainer container;

	public ParameterNode(String name, ParameterSubtypes subType) {
		super(name);

		setType(MyTreeNodeTypes.Parameter);
		this.subType = subType;

		container = makeContainerForParam(subType);

		numOfInstances++;
	}

	public ParameterNode(ParameterSubtypes subType) {
		super("Parameter_" + numOfInstances + " " + subType);

		setType(MyTreeNodeTypes.Parameter);
		this.subType = subType;

		container = makeContainerForParam(subType);

		numOfInstances++;
	}

	public ParameterNode() {
		super("Parameter_" + numOfInstances);

		setType(MyTreeNodeTypes.Parameter);
		this.subType = ParameterSubtypes.None;

		container = makeContainerForParam(subType);

		numOfInstances++;
	}

	public ParameterNode(ParameterNode myTreeNode) {
		super(myTreeNode);
		this.subType = myTreeNode.subType;
		if (myTreeNode.container != null)
			this.container = myTreeNode.container.getCopy();
	}

	@Override
	public void setName(String name) {
		String newName;
		if (name == null)
			newName = new String("Parameter_" + numOfInstances);
		else
			newName = new String(name);
		super.setName(newName);
	}

	public void setContainer(ParameterSubtypes subType) {
		setName(getName() + " " + subType);
		container = makeContainerForParam(subType);
		this.subType = subType;
	}

	public ParameterContainer makeContainerForParam(ParameterSubtypes subType) {
		ParameterContainer container = null;

		switch (subType) {
		case None:
			container = null;
			return null;
		case Name:
			container = new NameContainer();
			break;
		case LookAndFeel:
			container = new LookAndFeelContainer();
			break;
		case Author:
			container = new AuthorContainer();
			break;
		case Logo:
			container = new LogoContainer();
			break;
		case DesktopShortcut:
			if (this.getParent() instanceof ModuleNode) {
				ModuleNode moduleNode = (ModuleNode) this.getParent();
				container = new DShortCutContainer(moduleNode.getFilePath());
			} else {
				System.out.println("DShortcut parameter doesnt work on Product node. Parent:"
						+ ((MyTreeNode) this.getParent()).getName());
			}
			break;
		case StartAfterInstalation:
			if (this.getParent() instanceof ModuleNode) {
				ModuleNode moduleNode = (ModuleNode) this.getParent();
				container = new StartAIContainer(moduleNode.getFilePath());
			} else {
				System.out.println("SAI parameter doesnt work on Product node. Parent: "
						+ ((MyTreeNode) this.getParent()).getName());
			}
			break;
		case TermsOfUse:
			container = new TOUContainer();
			break;
		case CustomParameter:
			container = new CustomContainer();
			break;
		}

		container.setParameterNode(this);
		return container;
	}

	public ParameterContainer makeContainer(ContainerTypes subType) {
		ParameterContainer container = null;

		switch (subType) {
		case Name:
			container = new NameContainer();
			break;
		case LookAndFeel:
			container = new LookAndFeelContainer();
			break;
		case Author:
			container = new AuthorContainer();
			break;
		case Logo:
			container = new LogoContainer();
			break;
		case DesktopShortcut:
			if (this.getParent() instanceof ModuleNode) {
				ModuleNode moduleNode = (ModuleNode) this.getParent();
				container = new DShortCutContainer(moduleNode.getFilePath());
			} else {
				System.out.println("DShortcut parameter doesnt work on Product node. Parent: "
						+ ((MyTreeNode) this.getParent()).getName());
			}
			break;
		case StartAfterInstalation:
			if (this.getParent() instanceof ModuleNode) {
				ModuleNode moduleNode = (ModuleNode) this.getParent();
				container = new StartAIContainer(moduleNode.getFilePath());
			} else {
				System.out.println("SAI parameter doesnt work on Product node. Parent: "
						+ ((MyTreeNode) this.getParent()).getName());
			}
			break;
		case TermsOfUse:
			container = new TOUContainer();
			break;
		case Custom:
			container = new CustomContainer();
			break;
		}

		container.setParameterNode(this);
		return container;
	}

	@Override
	public boolean myEquals(Object obj) {
		try {
			if (obj instanceof ParameterNode) {
				ParameterNode oth = (ParameterNode) obj;
				if (super.myEquals(oth))
					if (this.subType.equals(oth.subType))
						if (this.container.equals(oth.container))
							return true;
			}
		} catch (NullPointerException e) {

		}
		return false;
	}

	public ParameterSubtypes getSubType() {
		return subType;
	}

	public ParameterContainer getContainer() {
		return container;
	}

}
