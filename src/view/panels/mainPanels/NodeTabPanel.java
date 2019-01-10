package view.panels.mainPanels;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import model.tree.nodes.MyTreeNode;
import model.tree.nodes.MyTreeNodeTypes;
import model.tree.nodes.ParameterNode;
import model.tree.nodes.ParameterSubtypes;
import observer.MyObserver;
import view.tabs.DescriptionTab;
import view.tabs.MyTab;
import view.tabs.TabParameterAuthor;
import view.tabs.TabParameterCustom;
import view.tabs.TabParameterDShortcut;
import view.tabs.TabParameterLogo;
import view.tabs.TabParameterLookNFeel;
import view.tabs.TabParameterName;
import view.tabs.TabParameterStartAI;
import view.tabs.TabParameterTOU;
import view.tabs.TabSoftware;
import view.toolbars.NodeToolBar;

public class NodeTabPanel extends JPanel implements MyObserver {

	private static final long serialVersionUID = -8262677768343243581L;
	
	private JTabbedPane tabbedPane;
	private NodeToolBar toolBar;

	public NodeTabPanel() {
		toolBar = new NodeToolBar();
		tabbedPane = new JTabbedPane();
		setLayout(new BorderLayout());
		add(toolBar, BorderLayout.NORTH);
		add(tabbedPane);
	}

	public void openTabForNode(MyTreeNode node) {
		boolean tabForNodeExists = tabForNodeExsists(node);

		if (!tabForNodeExists) {
			MyTab tab = makeNewTab(node);

			if (tab != null) {
				tabbedPane.addTab(node.getName(), null, tab, "Description of " + node.getName());

				tabbedPane.setSelectedIndex(tabbedPane.getComponentCount() - 1);
			}
		}
	}

	private MyTab makeNewTab(MyTreeNode node) {
		MyTreeNodeTypes type = node.getType();

		if (type == MyTreeNodeTypes.Parameter) {
			ParameterNode parameter = (ParameterNode) node;
			ParameterSubtypes subType = parameter.getSubType();

			switch (subType) {
			case None:
				return new DescriptionTab(node);
			case Name:
				return new TabParameterName(parameter);
			case LookAndFeel:
				return new TabParameterLookNFeel(parameter);
			case Author:
				return new TabParameterAuthor(parameter);
			case Logo:
				return new TabParameterLogo(parameter);
			case DesktopShortcut:
				return new TabParameterDShortcut(parameter);
			case StartAfterInstalation:
				return new TabParameterStartAI(parameter);
			case TermsOfUse:
				return new TabParameterTOU(parameter);
			case CustomParameter:
				return new TabParameterCustom(parameter);
			}
		} else if (type == MyTreeNodeTypes.Product) {
			return new TabSoftware(node);
		} else
			return new DescriptionTab(node);
		return null;
	}

	public void setActiveTabForNode(MyTreeNode node) {
		MyTab tab = findTabForNode(node);
		if (tab != null)
			tabbedPane.setSelectedComponent(tab);
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public MyTab findTabForNode(MyTreeNode node) {
		for (Component tab : tabbedPane.getComponents()) {
			if (((MyTab) tab).getNode() == node)
				return (MyTab) tab;
		}
		return null;
	}

	public boolean tabForNodeExsists(MyTreeNode node) {
		if (findTabForNode(node) != null)
			return true;
		else
			return false;
	}

	public void closeTabForNode(MyTreeNode node) {
		MyTab tab = findTabForNode(node);
		tabbedPane.remove(tab);
		if(node.hasObserver(tab)) {
			node.unregisterObserver(tab);
		}
	}

	public int findTabIndexForNode(MyTreeNode node) {
		int i = 0;
		for (Component tab : tabbedPane.getComponents()) {
			if (((MyTab) tab).getNode() == node)
				return i;
			i++;
		}
		return -1;
	}

	@Override
	public void update(Object obj) {
		if (obj instanceof MyTreeNode) {
			MyTreeNode node = (MyTreeNode) obj;
			MyTab tab = findTabForNode(node);
			if (tab != null) {
				if (tab != tabbedPane.getSelectedComponent() && tab instanceof DescriptionTab) { // only custom update
																									// for DESCRIPTION
																									// tab
					((DescriptionTab) tab).getTextArea().setText(node.getDescription()); // upgrade when needed
				}
				
				tabbedPane.setTitleAt(findTabIndexForNode(node), node.getName());
			}
		}
	}

}
