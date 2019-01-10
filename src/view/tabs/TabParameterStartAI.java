package view.tabs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.tree.nodes.MyTreeNode;
import model.tree.nodes.ParameterNode;
import model.tree.nodes.ParameterSubtypes;
import model.tree.nodes.parameterContainers.StartAIContainer;
import view.panels.parameterPanels.SavePanel;
import view.panels.parameterPanels.containerPanels.StartAIPanel;

public class TabParameterStartAI extends MyTab {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5599756623282762657L;
	private SavePanel savePanel;
	private StartAIPanel startAIPanel;

	public TabParameterStartAI(MyTreeNode node) {
		super(node);
	}

	@Override
	public void initialize() {
		startAIPanel = new StartAIPanel(true);
		savePanel = new SavePanel();

		BorderLayout borderLayout = new BorderLayout(10, 10);
		setLayout(borderLayout);

		add(startAIPanel, BorderLayout.CENTER);
		add(savePanel, BorderLayout.SOUTH);
	}

	@Override
	protected void putValuesForNode(MyTreeNode node) {
		ParameterNode parameterNode = (ParameterNode) node;

		if (parameterNode.getSubType() == ParameterSubtypes.StartAfterInstalation) {
			StartAIContainer container = (StartAIContainer) parameterNode.getContainer();
			startAIPanel.setContainer(container);
			startAIPanel.showContainerValues();
			
			savePanel.getBtnSave().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					startAIPanel.saveContainerValues();
				}
			});
		}
	}
}
