package view.panels.parameterPanels.containerPanels;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import model.tree.nodes.parameterContainers.LookAndFeelContainer;
import model.tree.nodes.parameterContainers.ParameterContainer;

public class LookNFeelPanel extends MyContainerPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5057719106775604755L;
	private JLabel lbLook;
	private JComboBox<String> cmbLook;

	public LookNFeelPanel(Boolean editable) {
		super(editable);
	}

	public LookNFeelPanel(ParameterContainer container,Boolean editable) {
		super(container,editable);
	}

	@Override
	protected void initialize() {

		lbLook = new JLabel("Look & feel:");
		cmbLook = new JComboBox();

		for (LookAndFeelInfo look : UIManager.getInstalledLookAndFeels()) {
			cmbLook.addItem(look.getName());
		}

		cmbLook.setSelectedIndex(0);
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		setLayout(layout);

		add(lbLook);
		add(cmbLook);
	}

	@Override
	public void showContainerValues() {
		if (container == null)
			System.out.println("LokNFeel panel, container is null");

		if (((LookAndFeelContainer) container).getLookAndFeelInfo() != null)
			cmbLook.setSelectedItem(((LookAndFeelContainer) container).getLookAndFeelInfo().getName());
	}

	@Override
	public void saveContainerValues() {
		if (container == null)
			System.out.println("LokNFeel panel, container is null");
		
		((LookAndFeelContainer) container).setLookAndFeelInfo(
				((LookAndFeelContainer) container).stringToLookNFeel((String) cmbLook.getSelectedItem()));
	}

	public JLabel getLbLook() {
		return lbLook;
	}

	public JComboBox getCmbLook() {
		return cmbLook;
	}
}
