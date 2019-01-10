package view.tabs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.tree.nodes.MyTreeNode;
import model.tree.nodes.ParameterNode;
import model.tree.nodes.ParameterSubtypes;
import model.tree.nodes.parameterContainers.DShortCutContainer;
import view.panels.parameterPanels.SavePanel;
import view.panels.parameterPanels.containerPanels.DShortCutPanel;

public class TabParameterDShortcut extends MyTab{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8158687952768376970L;
	private SavePanel savePanel;
	private DShortCutPanel dShortCutPanel;
	
	public TabParameterDShortcut(MyTreeNode node) {
		super(node);
	}
	
	@Override
	public void initialize()
	{
		savePanel = new SavePanel();
		dShortCutPanel = new DShortCutPanel(true);
		
		BorderLayout borderLayout = new BorderLayout(10,10);		
		setLayout(borderLayout);
		
		this.add(savePanel, BorderLayout.SOUTH);
		this.add(dShortCutPanel,BorderLayout.CENTER);
	}
	
	@Override
	protected void putValuesForNode(MyTreeNode node) {
		ParameterNode parameterNode = (ParameterNode) node;

		if (parameterNode.getSubType() == ParameterSubtypes.DesktopShortcut) {
			DShortCutContainer container = (DShortCutContainer) parameterNode.getContainer();
			dShortCutPanel.setContainer(container);
			dShortCutPanel.showContainerValues();
			
			savePanel.getBtnSave().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					dShortCutPanel.saveContainerValues();
				}
			});
		}
	}
	
}
