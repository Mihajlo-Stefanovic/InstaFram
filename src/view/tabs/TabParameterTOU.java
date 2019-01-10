package view.tabs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.tree.nodes.MyTreeNode;
import model.tree.nodes.ParameterNode;
import model.tree.nodes.ParameterSubtypes;
import model.tree.nodes.parameterContainers.TOUContainer;
import view.panels.parameterPanels.SavePanel;
import view.panels.parameterPanels.containerPanels.TOUPanel;

public class TabParameterTOU extends MyTab {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9137729558667528532L;
	private TOUPanel touPanel;
	private SavePanel savePanel;

	public TabParameterTOU(MyTreeNode node) {
		super(node);
	}

	@Override
	public void initialize() {
		touPanel = new TOUPanel(true);
		savePanel = new SavePanel();

		BorderLayout borderLayout = new BorderLayout(10, 10);
		setLayout(borderLayout);

		add(touPanel, BorderLayout.CENTER);
		add(savePanel, BorderLayout.SOUTH);

	}

	@Override
	protected void putValuesForNode(MyTreeNode node) {
		ParameterNode parameterNode = (ParameterNode) node;

		if (parameterNode.getSubType() == ParameterSubtypes.TermsOfUse) {
			TOUContainer container = (TOUContainer) parameterNode.getContainer();
			touPanel.setContainer(container);
			touPanel.showContainerValues();

			savePanel.getBtnSave().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					touPanel.saveContainerValues();
				}
			});
		}
	}
}
