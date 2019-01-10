package view.panels.parameterPanels.containerPanels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import app.AppCore;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;
import model.tree.nodes.parameterContainers.LogoContainer;
import model.tree.nodes.parameterContainers.ParameterContainer;

public class LogoPanel extends MyContainerPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1679522111294423156L;
	private JLabel lbLogo;
	private JTextField tfLogo;
	private JButton btnChoose;

	public LogoPanel(Boolean editable) {
		super(editable);
	}

	public LogoPanel(ParameterContainer container, Boolean editable) {
		super(container, editable);
	}

	@Override
	protected void initialize() {

		lbLogo = new JLabel("Choose path to logo:");

		tfLogo = new JTextField();
		tfLogo.setPreferredSize(new Dimension(200, 30));

		btnChoose = new JButton("Choose");

		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		setLayout(layout);

		add(lbLogo);
		add(tfLogo);
		add(btnChoose);

		btnChoose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setFileFilter(new FileFilter() {

					@Override
					public String getDescription() {
						return "\".jpg\",\".jpeg\",\".png\",\".git\"";
					}

					@Override
					public boolean accept(File f) {
						if (f!=null && f.toString()!=null)
							if (f.toString().endsWith(".jpg") || f.toString().endsWith(".jpeg")
									|| f.toString().endsWith(".png") || f.toString().endsWith(".gif"))
								return true;
						return false;
					}
				});
				int returnVal = chooser.showOpenDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String str = chooser.getSelectedFile().toString();
					if (str.endsWith(".jpg") || str.endsWith(".jpeg") || str.endsWith(".png") || str.endsWith(".git"))
						tfLogo.setText(chooser.getSelectedFile().getAbsolutePath());
					else
						AppCore.getInstance().getExceptionManager()
								.handleException(new MyException(MyExceptionSubTypes.PARAMETERTAB.NOTPICTURE));
				}
			}
		});
	}

	@Override
	public void showContainerValues() {
		if (container == null)
			System.out.println("Logo panel, container is null");

		tfLogo.setText(((LogoContainer) container).getPathToPicture());
	}

	@Override
	public void saveContainerValues() {
		if (container == null)
			System.out.println("Logo panel, container is null");

		((LogoContainer) container).setPathToPicture(tfLogo.getText());
	}

	public JLabel getLbLogo() {
		return lbLogo;
	}

	public JTextField getTfLogo() {
		return tfLogo;
	}

	public JButton getBtnChoose() {
		return btnChoose;
	}

}
