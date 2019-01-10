package view.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.tree.nodes.MyTreeNode;

public abstract class MyNewJDialog extends MyJDialog {	

	private static final long serialVersionUID = 5437986735127340152L;

	private final MyTreeNode node;
	
	public MyNewJDialog(String title, MyTreeNode node) {
		super(title);
		this.node = node;
		initialize();
		setDefaultActions(node);
	}
	
	protected void setDefaultActions(MyTreeNode node) {
		for( ActionListener al : btnOk.getActionListeners() ) {
	        btnOk.removeActionListener( al );
	    }
		
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				doAction(node);
			}
		});
	}
	
	protected abstract void doAction(MyTreeNode node);
	
	@Override
	protected void doAction() {	
	}

	public MyTreeNode getNode() {
		return node;
	}
	
}
