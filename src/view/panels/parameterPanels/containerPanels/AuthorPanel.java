package view.panels.parameterPanels.containerPanels;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.tree.nodes.parameterContainers.AuthorContainer;
import model.tree.nodes.parameterContainers.ParameterContainer;

public class AuthorPanel extends MyContainerPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1255404285983375838L;
	private JLabel lbName;
	private JTextField tfName;
	
	public AuthorPanel(Boolean editable) {
		super(editable);
	}
	
	public AuthorPanel(ParameterContainer container,Boolean editable) {
		super(container,editable);		
	}
	
	@Override
	protected void initialize() {
		lbName = new JLabel("Author:");
		tfName = new JTextField();

		tfName.setPreferredSize(new Dimension(200, 30));
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER,10,10);
		setLayout(layout);
		
		add(lbName);
		add(tfName);
	}

	@Override
	public void showContainerValues() {
		if(container == null)
			System.out.println("Author panel, container is null");
		
		tfName.setText(((AuthorContainer)container).getName());
	}

	@Override
	public void saveContainerValues() {
		if(container == null)
			System.out.println("Author panel, container is null");
		
		((AuthorContainer) container).setName(tfName.getText());
	}
	
	public JLabel getLbName() {
		return lbName;
	}

	public JTextField getTfName() {
		return tfName;
	}
	
}
