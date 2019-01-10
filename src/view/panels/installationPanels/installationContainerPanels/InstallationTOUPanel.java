package view.panels.installationPanels.installationContainerPanels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import app.AppCore;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;
import model.tree.nodes.parameterContainers.ParameterContainer;
import model.tree.nodes.parameterContainers.TOUContainer;

public class InstallationTOUPanel extends InstallationContainerPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 252126399682672422L;
	private JLabel lbTOU;
	private JTextArea taTOU;

	public InstallationTOUPanel() {
		super();
	}
	
	public InstallationTOUPanel(ParameterContainer container) {
		super(container);		
	}

	@Override
	protected void initialize() {

		lbTOU = new JLabel("Terms of use:");

		taTOU = new JTextArea();
		taTOU.setPreferredSize(new Dimension(400, 500));
		taTOU.setEditable(false);
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		setLayout(layout);

		add(lbTOU);
		add(taTOU);
		
	}

	@Override
	public void showContainerValues() {
		if (container == null)
			System.out.println("T.O.U. panel, container is null");
		
		File file = new File(((TOUContainer) container).getTermsOfUSe());
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				taTOU.append("\n"+scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			AppCore.getInstance().getExceptionManager()
			.handleException(new MyException(MyExceptionSubTypes.INSTALL.NOSUCHFILE));
		}
		
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}
	
}
