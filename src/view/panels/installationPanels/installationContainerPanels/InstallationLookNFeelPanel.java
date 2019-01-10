package view.panels.installationPanels.installationContainerPanels;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import app.AppCore;

import javax.swing.UnsupportedLookAndFeelException;

import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;
import model.tree.nodes.parameterContainers.LookAndFeelContainer;
import model.tree.nodes.parameterContainers.ParameterContainer;

public class InstallationLookNFeelPanel extends InstallationContainerPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6961046644248749902L;
	private JLabel lbLook;

	public InstallationLookNFeelPanel() {
		super();
	}

	public InstallationLookNFeelPanel(ParameterContainer container) {
		super(container);
	}

	@Override
	protected void initialize() {

		lbLook = new JLabel("Setting the looks...");

		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		setLayout(layout);

		add(lbLook);
	}

	@Override
	public void showContainerValues() {
		if (container == null)
			System.out.println("LokNFeel panel, container is null");

		try {
			UIManager.setLookAndFeel(((LookAndFeelContainer) container).getLookAndFeelInfo().getClassName());
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getInstaller().getInstallFrame());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			AppCore.getInstance().getExceptionManager()
			.handleException(new MyException(MyExceptionSubTypes.INSTALL.NOLOOK));
		}
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
