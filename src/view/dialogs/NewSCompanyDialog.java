package view.dialogs;

import javax.swing.JLabel;
import javax.swing.JTextField;
import model.tree.nodes.MyTreeNode;
import model.tree.nodes.SoftwareCompanyNode;

public class NewSCompanyDialog extends MyNewJDialog{

	private static final long serialVersionUID = -4986426702400000266L;

	MyTreeNode nodeAdded;
	
	private JLabel name;
	private JTextField tfName;
	
	public NewSCompanyDialog(MyTreeNode myTreeNode) {
		super("Add New Company", myTreeNode);
	}
	
	@Override
	public void initialize() {
		
		name = new JLabel("Enter name of company:");
		tfName = new JTextField();

		name.setBounds(10, 35, 200, 25);
		tfName.setBounds(180, 35, 190, 25);
		
		add(name);
		add(tfName);
	
		setModal(true);
	}
	
	@Override
	protected void doAction(MyTreeNode node) {
		SoftwareCompanyNode softwareCompany;
		if(tfName.getText().length()==0)
			softwareCompany = new SoftwareCompanyNode();
		else
			softwareCompany = new SoftwareCompanyNode(tfName.getText());
		
		nodeAdded = softwareCompany;
		node.add(softwareCompany);
		
		close();
	}

	@Override
	public Object showDialog() {
		setVisible(true);
		return nodeAdded;
	}
}
