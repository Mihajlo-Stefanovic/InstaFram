package view.panels.parameterPanels.containerPanels;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.tree.nodes.parameterContainers.NameContainer;
import model.tree.nodes.parameterContainers.ParameterContainer;

public class NamePanel extends MyContainerPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3906977245026805591L;
	private JLabel lbName;
	private JTextField tfName;
	
	public NamePanel(Boolean editable) {
		super(editable);
	}
	
	public NamePanel(ParameterContainer container,Boolean editable) {
		super(container,editable);
	}

	@Override
	protected void initialize() {

		lbName = new JLabel("Name:");
		tfName = new JTextField();

		tfName.setPreferredSize(new Dimension(200, 30));
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER,10,10);
		setLayout(layout);
		
		add(lbName);
		add(tfName);
		
	}

	@Override
	public void showContainerValues() {
		if (container == null)
			System.out.println("Name panel, container is null");
		
		tfName.setText(((NameContainer) container).getName());
	}

	@Override
	public void saveContainerValues() {
		if (container == null)
			System.out.println("Name panel, container is null");
		
		((NameContainer) container).setName(tfName.getText());
	}
	
	public JLabel getLbName() {
		return lbName;
	}

	public JTextField getTfName() {
		return tfName;
	}
}
