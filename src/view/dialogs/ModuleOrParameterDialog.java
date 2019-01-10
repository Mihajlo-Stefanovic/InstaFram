package view.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import model.tree.nodes.MyTreeNode;

public class ModuleOrParameterDialog extends MyNewJDialog {

	private static final long serialVersionUID = -2230759800568079337L;

	private MyNewJDialog newJDialog;

	JButton btnNewModule;
	JButton btnNewParameter;

	public ModuleOrParameterDialog(MyTreeNode myTreeNode) {
		super("New", myTreeNode);
		setActions(myTreeNode);
	}

	@Override
	public void initialize() {
		btnNewModule = new JButton("New Module");
		btnNewParameter = new JButton("New Parameter");

		btnNewModule.setBounds(60, 20, 140, 25);
		btnNewParameter.setBounds(220, 20, 140, 25);

		remove(btnOk);

		add(btnNewModule);
		add(btnNewParameter);

		setModal(true);
	}

	private void setActions(MyTreeNode node) {
		btnNewModule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				close();
				newJDialog = new NewModuleDialog(node);
			}
		});

		btnNewParameter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				close();
				newJDialog = new NewParameterDialog(node);
			}
		});
	}

	@Override
	protected void doAction(MyTreeNode node) {
	}

	@Override
	public Object showDialog() {
		setVisible(true);
		return newJDialog;
	}
}
