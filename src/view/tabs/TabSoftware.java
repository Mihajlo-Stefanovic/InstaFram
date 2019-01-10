package view.tabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import app.AppCore;
import model.tree.nodes.MyTreeNode;
import model.tree.nodes.ProductNode;
import view.panels.parameterPanels.ExportPanel;

public class TabSoftware extends MyTab {
	/**
	 * 
	 */
	private static final long serialVersionUID = -663539030285213771L;
	private ExportPanel exportPanel;

	public TabSoftware(MyTreeNode node) {
		super(node);
	}

	@Override
	protected void initialize() {
		exportPanel = new ExportPanel();
		add(exportPanel);
	}

	@Override
	protected void putValuesForNode(MyTreeNode node) {
		
		ProductNode softwareCompany = (ProductNode) node;
		
		exportPanel.getBtnChoose().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
				chooser.showOpenDialog(AppCore.getInstance().getMainFrame());

				File file = chooser.getSelectedFile();
				if (file != null) {
					exportPanel.getTfPath().setText(file.getPath());
					softwareCompany.setFilePath(exportPanel.getTfPath().getText());
				} else {
					exportPanel.getTfPath().setText("");
					softwareCompany.setFilePath("");
				}
			}
		});

		exportPanel.getBtnExport().addActionListener(AppCore.getInstance().getActionManager().getExportListener());
		exportPanel.getBtnInstall().addActionListener(AppCore.getInstance().getActionManager().getInstallListener());
	}

	public ExportPanel getExportPanel() {
		return exportPanel;
	}

}
