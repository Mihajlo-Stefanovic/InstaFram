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
import model.tree.nodes.parameterContainers.LogoContainer;
import view.panels.parameterPanels.SavePanel;
import view.panels.parameterPanels.containerPanels.LogoPanel;

public class TabParameterLogo extends MyTab {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1154117987961455467L;
	private SavePanel savePanel;
	private LogoPanel logoPanel;

	public TabParameterLogo(MyTreeNode node) {
		super(node);
	}

	@Override
	protected void initialize() {
		savePanel = new SavePanel();
		logoPanel = new LogoPanel(true);
		
		BorderLayout borderLayout = new BorderLayout(10,10);		
		setLayout(borderLayout);
		
		this.add(savePanel, BorderLayout.SOUTH);
		this.add(logoPanel,BorderLayout.CENTER);
	}

	@Override
	protected void putValuesForNode(MyTreeNode node) {
		ParameterNode parameterNode = (ParameterNode) node;
		
		if(parameterNode.getSubType() == ParameterSubtypes.Logo) {
			LogoContainer container = (LogoContainer) parameterNode.getContainer();
			logoPanel.setContainer(container);
			logoPanel.showContainerValues();
			
			savePanel.getBtnSave().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					logoPanel.saveContainerValues();
				}
			});
		}
		else
			AppCore.getInstance().getExceptionManager().handleException(new MyException(MyExceptionSubTypes.PARAMETERTAB.WRONGSUBTYPE));
	}
}
