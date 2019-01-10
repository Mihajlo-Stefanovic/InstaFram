package view.panels.parameterPanels.containerPanels;

import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import model.tree.nodes.parameterContainers.ParameterContainer;
import model.tree.nodes.parameterContainers.StartAIContainer;

public class StartAIPanel extends MyContainerPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8957352695569625763L;
	private JCheckBox checkBox;

	public StartAIPanel(Boolean editable) {
		super(editable);
	}
	
	public StartAIPanel(ParameterContainer container,Boolean editable) {
		super(container,editable);
	}

	@Override
	protected void initialize() {
		
		checkBox = new JCheckBox("Start after instalation");
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER,10,10);
		setLayout(layout);
		
		add(checkBox);
	}

	@Override
	public void showContainerValues() {
		if (container == null)
			System.out.println("Start A. I. panel, container is null");
		
		checkBox.setSelected(((StartAIContainer) container).isToStart());
	}

	@Override
	public void saveContainerValues() {
		if (container == null)
			System.out.println("Start A. I. panel, container is null");
		
		((StartAIContainer) container).setToStart(checkBox.isSelected());
	}
	
	public JCheckBox getCheckBox() {
		return checkBox;
	}
}
