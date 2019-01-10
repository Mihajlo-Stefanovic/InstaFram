package view.panels.installationPanels.installationContainerPanels;

import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JLabel;
import app.AppCore;
import model.tree.nodes.parameterContainers.ParameterContainer;
import model.tree.nodes.parameterContainers.StartAIContainer;

public class InstallationStartAIPanel extends InstallationContainerPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4991349421179090426L;
	private JLabel lbStart;

	public InstallationStartAIPanel() {
		super();
	}
	
	public InstallationStartAIPanel(ParameterContainer container) {
		super(container);
	}

	@Override
	protected void initialize() {
		
		lbStart = new JLabel();
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER,10,10);
		setLayout(layout);
		
		add(lbStart);
	}

	@Override
	public void showContainerValues() {
		if (container == null)
			System.out.println("Start A. I. panel, container is null");
		
		if(((StartAIContainer) container).isToStart())
			lbStart.setText("Module will start after installation.");
		else
			lbStart.setText("Module will NOT start after installation.");
	}

	@Override
	public void doAction() {
		if(((StartAIContainer) container).isToStart())
			AppCore.getInstance().getInstaller().getToOpen().add(new File(((StartAIContainer) container).getFilePath()));
	}
}
