package view.tabs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.AppCore;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;
import model.tree.nodes.MyTreeNode;
import model.tree.nodes.ParameterNode;
import model.tree.nodes.ParameterSubtypes;
import model.tree.nodes.parameterContainers.NameContainer;
import view.panels.parameterPanels.SavePanel;
import view.panels.parameterPanels.containerPanels.NamePanel;

public class TabParameterName extends MyTab{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2189577538086815722L;
	private SavePanel savePanel;
	private NamePanel namePanel;
	
	public TabParameterName(ParameterNode node) {
		super(node);
	}
	
	@Override
	public void initialize()
	{
		namePanel = new NamePanel(true);
		savePanel = new SavePanel();

		BorderLayout borderLayout = new BorderLayout(10, 10);
		setLayout(borderLayout);

		add(namePanel, BorderLayout.CENTER);
		add(savePanel, BorderLayout.SOUTH);
	}
	
	@Override
	protected void putValuesForNode(MyTreeNode node) {
		ParameterNode parameterNode = (ParameterNode) node;
		
		if(parameterNode.getSubType() == ParameterSubtypes.Name) {
			NameContainer container = (NameContainer) parameterNode.getContainer();
			namePanel.setContainer(container);
			namePanel.showContainerValues();
			
			savePanel.getBtnSave().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					namePanel.saveContainerValues();
				}
			});
		}
		else
			AppCore.getInstance().getExceptionManager().handleException(new MyException(MyExceptionSubTypes.PARAMETERTAB.WRONGSUBTYPE));
	}

}
