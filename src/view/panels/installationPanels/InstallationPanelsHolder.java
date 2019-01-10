package view.panels.installationPanels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.tree.nodes.parameterContainers.ParameterContainer;
import view.panels.installationPanels.installationContainerPanels.InstallationAuthorPanel;
import view.panels.installationPanels.installationContainerPanels.InstallationContainerPanel;
import view.panels.installationPanels.installationContainerPanels.InstallationDShortCutPanel;
import view.panels.installationPanels.installationContainerPanels.InstallationLogoPanel;
import view.panels.installationPanels.installationContainerPanels.InstallationLookNFeelPanel;
import view.panels.installationPanels.installationContainerPanels.InstallationNamePanel;
import view.panels.installationPanels.installationContainerPanels.InstallationStartAIPanel;
import view.panels.installationPanels.installationContainerPanels.InstallationTOUPanel;

public class InstallationPanelsHolder extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6257979600539981769L;
	private JButton btnNext;
	private JButton btnCancel;
	//private JButton btnBack;
	
	private InstallationPanel installationPanel;
	private JPanel installationPanelsHolder;
	
	public InstallationPanelsHolder() {
		installationPanelsHolder = new JPanel();
		
		JPanel bottomPanel = new JPanel(new FlowLayout());
		btnNext = new JButton("Next");
		btnCancel = new JButton("Cancel");
		bottomPanel.add(btnCancel);
		bottomPanel.add(btnNext);
		
		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);
		
		add(installationPanelsHolder, BorderLayout.CENTER);
		add(bottomPanel,BorderLayout.SOUTH);
	}
	
	public JButton getBtnNext() {
		return btnNext;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}
	/*public JButton getBtnBack() {
		return btnBack;
	}*/

	public InstallationPanel getContainerPanel() {
		return installationPanel;
	}

	public void setInstallationPanel(InstallationPanel installationPanel) {
		this.installationPanel = installationPanel;
		this.installationPanelsHolder.removeAll();
		this.installationPanelsHolder.add(installationPanel);
		this.installationPanelsHolder.validate();
		this.installationPanelsHolder.repaint();
	}
	
	public void setInstallationPanel(ParameterContainer parameterContainer) {
		InstallationContainerPanel containerPanel = null;
		this.installationPanelsHolder.removeAll();
		
		switch (parameterContainer.getContainerType()) {
		case Author:
			containerPanel = new InstallationAuthorPanel(parameterContainer); 
			containerPanel.showContainerValues();
			this.installationPanelsHolder.add(containerPanel);
			break;
		case Name:
			containerPanel = new InstallationNamePanel(parameterContainer); 
			containerPanel.showContainerValues();
			this.installationPanelsHolder.add(containerPanel);
			break;
		case TermsOfUse:
			containerPanel = new InstallationTOUPanel(parameterContainer);
			containerPanel.showContainerValues();
			this.installationPanelsHolder.add(containerPanel);
			break;
		case Logo:
			containerPanel = new InstallationLogoPanel(parameterContainer); 
			containerPanel.showContainerValues();
			this.installationPanelsHolder.add(containerPanel);
			break;
		case LookAndFeel:
			containerPanel = new InstallationLookNFeelPanel(parameterContainer); 
			containerPanel.showContainerValues();
			this.installationPanelsHolder.add(containerPanel);
			break;
		case DesktopShortcut:
			containerPanel = new InstallationDShortCutPanel(parameterContainer); 
			containerPanel.showContainerValues();
			this.installationPanelsHolder.add(containerPanel);
			break;
		case StartAfterInstalation:
			containerPanel = new InstallationStartAIPanel(parameterContainer); 
			containerPanel.showContainerValues();
			this.installationPanelsHolder.add(containerPanel);
			break;
		}
		
		this.installationPanel = containerPanel;
		this.installationPanelsHolder.validate();
		this.installationPanelsHolder.repaint();
	}
	
}
