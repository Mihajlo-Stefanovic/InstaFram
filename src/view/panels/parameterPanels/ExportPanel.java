package view.panels.parameterPanels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ExportPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8078739486826338832L;
	private JTextField tfPath;
	private JButton btnChoose;
	private JButton btnInstall;
	private JButton btnExport;
	private JFileChooser fileChooser;
	private FileNameExtensionFilter filter;

	public ExportPanel() {
		
		tfPath = new JTextField();
		btnChoose = new JButton("Choose");
		btnInstall = new JButton("Try now");
		btnExport = new JButton("Export");
		fileChooser = new JFileChooser();
		
		JPanel bottomPanel = new JPanel();
		JPanel centralPanel = new JPanel();

		BorderLayout borderLayout = new BorderLayout(10, 10);
		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		FlowLayout fileFlowLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);

		btnInstall.setPreferredSize(new Dimension(150, 50));
		btnExport.setPreferredSize(new Dimension(150, 50));
		btnChoose.setPreferredSize(new Dimension(75, 30));

		tfPath.setPreferredSize(new Dimension(300, 40));

		centralPanel.setLayout(fileFlowLayout);
		bottomPanel.setLayout(flowLayout);

		setLayout(borderLayout);

		centralPanel.add(tfPath);
		centralPanel.add(btnChoose);

		bottomPanel.add(btnExport);
		bottomPanel.add(Box.createHorizontalGlue());
		bottomPanel.add(btnInstall);
		
		this.add(bottomPanel, BorderLayout.SOUTH);
		this.add(centralPanel, BorderLayout.CENTER);
	}

	public JTextField getTfPath() {
		return tfPath;
	}

	public JButton getBtnChoose() {
		return btnChoose;
	}

	public JButton getBtnInstall() {
		return btnInstall;
	}

	public JButton getBtnExport() {
		return btnExport;
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public FileNameExtensionFilter getFilter() {
		return filter;
	}
	
}
