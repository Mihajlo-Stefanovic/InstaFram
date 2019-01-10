package view.tabs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.tree.nodes.MyTreeNode;
import model.tree.nodes.ParameterNode;
import model.tree.nodes.ParameterSubtypes;
import model.tree.nodes.parameterContainers.LookAndFeelContainer;
import view.panels.parameterPanels.SavePanel;
import view.panels.parameterPanels.containerPanels.LookNFeelPanel;

public class TabParameterLookNFeel extends MyTab {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8623482924831184094L;
	private LookNFeelPanel lookNFeelPanel;
	private SavePanel savePanel;

	public TabParameterLookNFeel(ParameterNode node) {
		super(node);
	}

	@Override
	public void initialize() {
		lookNFeelPanel = new LookNFeelPanel(true);
		savePanel = new SavePanel();

		BorderLayout borderLayout = new BorderLayout(10, 10);
		setLayout(borderLayout);

		add(lookNFeelPanel, BorderLayout.CENTER);
		add(savePanel, BorderLayout.SOUTH);
	}

	@Override
	protected void putValuesForNode(MyTreeNode node) {
		ParameterNode parameterNode = (ParameterNode) node;

		if (parameterNode.getSubType() == ParameterSubtypes.LookAndFeel) {
			LookAndFeelContainer container = (LookAndFeelContainer) parameterNode.getContainer();
			lookNFeelPanel.setContainer(container);
			lookNFeelPanel.showContainerValues();

			savePanel.getBtnSave().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					lookNFeelPanel.saveContainerValues();
				}				
				
			});
		}
	}
}
