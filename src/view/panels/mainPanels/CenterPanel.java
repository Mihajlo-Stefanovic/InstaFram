package view.panels.mainPanels;

import javax.swing.JSplitPane;
import view.toolbars.MainToolBar;

public class CenterPanel extends JSplitPane {

	private static final long serialVersionUID = -5232717354433361472L;
	// TODO extract panels in clases
	private TreePanel treePanel;
	private RightPanel rightPanel;

	private MainToolBar toolBar;

	public CenterPanel() {
		makePanels();

		toolBar = new MainToolBar();

		setLeftComponent(treePanel);
		setRightComponent(rightPanel);

	}

	private void makePanels() {
		treePanel = new TreePanel();
		rightPanel = new RightPanel(JSplitPane.VERTICAL_SPLIT);
	}

	public TreePanel getTreePanel() {
		return treePanel;
	}

	public RightPanel getRightPanel() {
		return rightPanel;
	}
}
