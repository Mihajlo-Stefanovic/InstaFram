package view.panels.installationPanels.installationContainerPanels;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import model.tree.nodes.parameterContainers.AuthorContainer;
import model.tree.nodes.parameterContainers.ParameterContainer;

public class InstallationAuthorPanel extends InstallationContainerPanel{

	private static final long serialVersionUID = -4153962474901677714L;
	
	private JLabel lbName;
	
	public InstallationAuthorPanel() {
		super();
	}
	
	public InstallationAuthorPanel(ParameterContainer container) {
		super(container);		
	}
	
	@Override
	protected void initialize() {
		lbName = new JLabel("Author:");
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER,10,10);
		setLayout(layout);
		
		add(lbName);
	}

	@Override
	public void showContainerValues() {
		if(container == null)
			System.out.println("Author panel, container is null");
		
		lbName.setText("Author of this module is: " + ((AuthorContainer)container).getName());
	}
	
	public JLabel getLbName() {
		return lbName;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}
	
}
