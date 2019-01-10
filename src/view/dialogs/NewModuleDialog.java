package view.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import app.AppCore;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;
import model.tree.nodes.ModuleNode;
import model.tree.nodes.MyTreeNode;

public class NewModuleDialog extends MyNewJDialog {

	private static final long serialVersionUID = -2503286763698249571L;

	private MyTreeNode nodeAdded;

	private JLabel name;
	private JTextField tfName;
	private JTextField tfPath;
	private JButton btnBrowse;

	public NewModuleDialog(MyTreeNode myTreeNode) {
		super("New Module", myTreeNode);
	}

	@Override
	public void initialize() {

		name = new JLabel("Enter name of module:");
		tfName = new JTextField();
		tfPath = new JTextField();
		btnBrowse = new JButton("Browse...");

		name.setBounds(10, 35, 200, 25);
		tfName.setBounds(180, 35, 190, 25);
		tfPath.setBounds(180, 70, 190, 25);
		btnBrowse.setBounds(10, 70, 140, 25);

		add(name);
		add(tfName);
		add(tfPath);
		add(btnBrowse);

		setModal(true);

		btnBrowse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
				chooser.showOpenDialog(AppCore.getInstance().getMainFrame());

				File file = chooser.getSelectedFile();
				tfPath.setText(file.getPath());
			}
		});
	}

	@Override
	protected void doAction(MyTreeNode node) {
		ModuleNode module;
		try {
			if(tfPath.getText().length() == 0)
				throw new MyException(MyExceptionSubTypes.NEWMODULE.NOPATH);
			if (tfName.getText().length() == 0) {
					module = new ModuleNode(tfPath.getText());
			}
			else {
				module = new ModuleNode(tfName.getText(),tfPath.getText());
			}

			module.setFilePath(tfPath.getText());

			nodeAdded = module;
			node.add(module);

			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getTree());

			close();
		} catch (MyException e) {
			AppCore.getInstance().getExceptionManager().handleException(e);
		}
	}

	@Override
	public Object showDialog() {
		setVisible(true);
		return nodeAdded;
	}
}
