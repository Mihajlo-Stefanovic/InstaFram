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
import model.tree.nodes.parameterContainers.CustomContainer;
import view.panels.parameterPanels.SavePanel;
import view.panels.parameterPanels.containerPanels.CustomPanel;

public class TabParameterCustom extends MyTab {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8567196004120177247L;
	CustomPanel customPanel;
	SavePanel savePanel;

	public TabParameterCustom(ParameterNode node) {
		super(node);
	}

	@Override
	protected void initialize() {
		customPanel = new CustomPanel(true,(MyTreeNode) node.getParent());
		savePanel = new SavePanel();

		BorderLayout borderLayout = new BorderLayout(10, 10);
		setLayout(borderLayout);

		add(customPanel, BorderLayout.CENTER);
		add(savePanel, BorderLayout.SOUTH);
	}

	@Override
	protected void putValuesForNode(MyTreeNode node) {
		ParameterNode parameterNode = (ParameterNode) node;
		if (parameterNode.getSubType() == ParameterSubtypes.CustomParameter) {
			CustomContainer container = (CustomContainer) parameterNode.getContainer();
			customPanel.setContainer(container);
			customPanel.showContainerValues();
			container.registerObserver(customPanel);
			
			savePanel.getBtnSave().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					customPanel.saveContainerValues();
				}
			});
		} else
			AppCore.getInstance().getExceptionManager()
					.handleException(new MyException(MyExceptionSubTypes.PARAMETERTAB.WRONGSUBTYPE));
	}

}
