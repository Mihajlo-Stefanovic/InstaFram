package view.dialogs;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import app.AppCore;
import model.tree.nodes.MyTreeNode;
import model.tree.nodes.ProductNode;

public class NewProductDialog extends MyNewJDialog{

	private static final long serialVersionUID = 2180613912525366785L;

	MyTreeNode nodeAdded;
	
	private JLabel name;
	private JTextField tfName;
	
	public NewProductDialog(MyTreeNode myTreeNode) {
		super("Add New Product", myTreeNode);
	}
	
	@Override
	public void initialize() {
		
		name = new JLabel("Enter name of the product:");
		tfName = new JTextField();

		name.setBounds(10, 35, 200, 25);
		tfName.setBounds(180, 35, 190, 25);
		
		
		
		add(name);
		add(tfName);
		
		setModal(true);
	}

	@Override
	protected void doAction(MyTreeNode node) {
		ProductNode product;
		if(tfName.getText().length()==0)
			product = new ProductNode();
		else
			product = new ProductNode(tfName.getText());
		
		nodeAdded = product;
		node.add(product);
		
		SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getTree());
		
		close();
	}

	@Override
	public Object showDialog() {
		setVisible(true);
		return nodeAdded;
	}
}
