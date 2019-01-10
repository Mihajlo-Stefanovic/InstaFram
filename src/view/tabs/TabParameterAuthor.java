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
import model.tree.nodes.parameterContainers.AuthorContainer;
import view.panels.parameterPanels.SavePanel;
import view.panels.parameterPanels.containerPanels.AuthorPanel;

public class TabParameterAuthor extends MyTab{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5717946063809362473L;
	private SavePanel savePanel;
	private AuthorPanel authorPanel;
	
	public TabParameterAuthor(ParameterNode node) {
		super(node);
	}
	
	@Override
	public void initialize()
	{
		savePanel = new SavePanel();
		authorPanel = new AuthorPanel(true);
		
		BorderLayout borderLayout = new BorderLayout(10,10);		
		setLayout(borderLayout);
		
		this.add(savePanel, BorderLayout.SOUTH);
		this.add(authorPanel,BorderLayout.CENTER);
		
	}
	
	@Override
	protected void putValuesForNode(MyTreeNode node) {
		ParameterNode parameterNode = (ParameterNode) node;
		
		if(parameterNode.getSubType() == ParameterSubtypes.Author) {
			AuthorContainer authorContainer = (AuthorContainer) parameterNode.getContainer();
			authorPanel.setContainer(authorContainer);
			authorPanel.showContainerValues();
			
			savePanel.getBtnSave().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					authorPanel.saveContainerValues();
				}
			});
		}
		else
			AppCore.getInstance().getExceptionManager().handleException(new MyException(MyExceptionSubTypes.PARAMETERTAB.WRONGSUBTYPE));
	}

}
