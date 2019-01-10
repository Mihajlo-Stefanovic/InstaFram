package view.panels.installationPanels.installationContainerPanels;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import model.tree.nodes.parameterContainers.NameContainer;
import model.tree.nodes.parameterContainers.ParameterContainer;

public class InstallationNamePanel extends InstallationContainerPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8788779420357093336L;
	private JLabel lbName;
	
	public InstallationNamePanel() {
		super();
	}
	
	public InstallationNamePanel(ParameterContainer container) {
		super(container);
	}

	@Override
	protected void initialize() {

		lbName = new JLabel();
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER,10,10);
		setLayout(layout);
		
		add(lbName);
		
	}

	@Override
	public void showContainerValues() {
		if (container == null)
			System.out.println("Name panel, container is null");
		
		lbName.setText(((NameContainer) container).getName().toUpperCase());
	}
	
	public JLabel getLbName() {
		return lbName;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
