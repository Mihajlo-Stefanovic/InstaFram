package view.panels.parameterPanels;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SavePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6307539962949758343L;
	private JButton btnSave;
	
	public SavePanel() {
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER,10,10);
		setLayout(layout);
		
		btnSave = new JButton("Save");
		btnSave.setPreferredSize(new Dimension(150,50));
		
		add(btnSave);
	}

	public JButton getBtnSave() {
		return btnSave;
	}
	
}
