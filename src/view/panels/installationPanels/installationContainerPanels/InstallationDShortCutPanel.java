package view.panels.installationPanels.installationContainerPanels;

import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JLabel;
import app.AppCore;
import model.tree.nodes.parameterContainers.DShortCutContainer;
import model.tree.nodes.parameterContainers.ParameterContainer;

public class InstallationDShortCutPanel extends InstallationContainerPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4338543799896356546L;
	private JLabel lbSCut;

	public InstallationDShortCutPanel() {
		super();
	}
	
	public InstallationDShortCutPanel(ParameterContainer container) {
		super(container);
	}

	@Override
	protected void initialize() {
		lbSCut = new JLabel();
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER,10,10);
		setLayout(layout);
		
		add(lbSCut);		
	}

	@Override
	public void showContainerValues() {
		if(container == null)
			System.out.println("DS panel, container is null");
		
		if(((DShortCutContainer)container).isToMake()){
			lbSCut.setText("Desktop Shortcut will be made.");
		}
		else
			lbSCut.setText("Desktop Shortcut will NOT be made.");
	}

	@Override
	public void doAction() {
		if(((DShortCutContainer)container).isToMake())
			AppCore.getInstance().getInstaller().getToMakeDShortCut().add(new File(((DShortCutContainer) container).getFilePath()));
	}

}
