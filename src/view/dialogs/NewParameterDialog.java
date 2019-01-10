package view.dialogs;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.tree.nodes.MyTreeNode;
import model.tree.nodes.ParameterNode;
import model.tree.nodes.ParameterSubtypes;
import model.tree.nodes.ProductNode;

public class NewParameterDialog extends MyNewJDialog {

	private static final long serialVersionUID = -925075884092901522L;

	MyTreeNode nodeAdded;

	private JLabel name;
	private JTextField tfName;
	private JComboBox cmb;
	private JLabel lbCmb;

	public NewParameterDialog(MyTreeNode node) {
		super("New Parameter", node);
	}

	@Override
	public void initialize() {
		setSize(400, 200);

		name = new JLabel("Enter name of Parameter:");
		lbCmb = new JLabel("Choose type of Parameter:");
		tfName = new JTextField();

		cmb = new JComboBox(ParameterSubtypes.values());
		if (getNode() instanceof ProductNode) {
			cmb.removeItem(ParameterSubtypes.DesktopShortcut);
			cmb.removeItem(ParameterSubtypes.StartAfterInstalation);
		}

		name.setBounds(10, 35, 200, 25);
		tfName.setBounds(200, 35, 190, 25);
		lbCmb.setBounds(10, 85, 200, 25);
		cmb.setBounds(200, 85, 190, 25);

		btnOk.setBounds(120, 135, 70, 25);
		btnCancel.setBounds(210, 135, 80, 25);

		add(name);
		add(tfName);
		add(cmb);
		add(lbCmb);

		setModal(true);
	}

	@Override
	protected void doAction(MyTreeNode node) {
		ParameterNode parameter = new ParameterNode();
		node.add(parameter);
		nodeAdded = parameter;

		ParameterSubtypes subType;

		subType = (ParameterSubtypes) cmb.getSelectedItem();

		if (tfName.getText().length() == 0)
			parameter.setName(null);
		else
			parameter.setName(tfName.getText());

		parameter.setContainer(subType);
		close();
	}

	@Override
	public Object showDialog() {
		setVisible(true);
		return nodeAdded;
	}
}
