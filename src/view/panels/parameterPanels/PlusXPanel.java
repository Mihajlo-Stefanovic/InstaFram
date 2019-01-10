package view.panels.parameterPanels;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import app.AppCore;

public class PlusXPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 456751675484887721L;

	private JButton btnX;
	
	private JPanel panel;
	private JPanel parentPanel;
	
	public PlusXPanel(JPanel panel, JPanel parentPanel) {
		this.panel = panel;
		this.parentPanel = parentPanel;
		
		initialize();
	}

	private void initialize() {
		btnX = new JButton(AppCore.getInstance().getLoadedImages().getDeleteNodeIcon());
		
		btnX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parentPanel.remove(panel);
			}
		});
		
		FlowLayout flowLayout = new FlowLayout();
		setLayout(flowLayout);
		
		add(panel);
		add(btnX);
	}

	public JPanel getPanel() {
		return panel;
	}
	
}
