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
import model.tree.nodes.parameterContainers.ParameterContainer;
import model.tree.nodes.parameterContainers.TOUContainer;

public class TOUPanel extends MyContainerPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2398918539722449159L;
	private JLabel lbTOU;
	private JTextField tfTOU;
	private JButton btnChoose;

	public TOUPanel(Boolean editable) {
		super(editable);
	}
	
	public TOUPanel(ParameterContainer container,Boolean editable) {
		super(container,editable);		
	}

	@Override
	protected void initialize() {

		lbTOU = new JLabel("Choose path to Terms of Use:");

		tfTOU = new JTextField();
		tfTOU.setPreferredSize(new Dimension(200, 30));

		btnChoose = new JButton("Choose");

		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		setLayout(layout);

		add(lbTOU);
		add(tfTOU);
		add(btnChoose);
		
		btnChoose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setFileFilter(new FileFilter() {

					@Override
					public String getDescription() {
						return "\".txt\"";
					}

					@Override
					public boolean accept(File f) {
						if (f!=null && f.toString()!=null && f.toString().endsWith(".txt"))
							return true;
						return false;
					}
				});
				int returnVal = chooser.showOpenDialog(null);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String str = chooser.getSelectedFile().toString();
					if (str.endsWith(".txt"))
						tfTOU.setText(chooser.getSelectedFile().getAbsolutePath());
					else
						AppCore.getInstance().getExceptionManager()
								.handleException(new MyException(MyExceptionSubTypes.PARAMETERTAB.NOTDOCUMENT));
				}
			}
		});
	}

	@Override
	public void showContainerValues() {
		if (container == null)
			System.out.println("T.O.U. panel, container is null");
		
		tfTOU.setText(((TOUContainer) container).getTermsOfUSe());
	}

	@Override
	public void saveContainerValues() {
		if (container == null)
			System.out.println("T.O.U. panel, container is null");
		
		((TOUContainer) container).setTermsOfUSe(tfTOU.getText());
	}
	
	public JButton getBtnChoose() {
		return btnChoose;
	}

	public JLabel getLbTOU() {
		return lbTOU;
	}

	public JTextField getTfTOU() {
		return tfTOU;
	}
	
}
