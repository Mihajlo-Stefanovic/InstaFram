package view.panels.parameterPanels.containerPanels;

import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import model.tree.nodes.parameterContainers.DShortCutContainer;
import model.tree.nodes.parameterContainers.ParameterContainer;

public class DShortCutPanel extends MyContainerPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2014112859797582607L;
	private JCheckBox checkBox;

	public DShortCutPanel(Boolean editable) {
		super(editable);
	}
	
	public DShortCutPanel(ParameterContainer container,Boolean editable) {
		super(container,editable);
	}

	@Override
	protected void initialize() {
		checkBox = new JCheckBox("Desktop shortcut");
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER,10,10);
		setLayout(layout);
		
		add(checkBox);		
	}

	@Override
	public void showContainerValues() {
		if(container == null)
			System.out.println("DS panel, container is null");
		
		checkBox.setSelected(((DShortCutContainer)container).isToMake());
	}

	@Override
	public void saveContainerValues() {
		if(container == null)
			System.out.println("Author panel, container is null");
		
		((DShortCutContainer) container).setToMake(checkBox.isSelected());
	}
	
	public JCheckBox getCheckBox() {
		return checkBox;
	}
}
