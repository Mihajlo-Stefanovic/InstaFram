package controller.actions.keyListeners;

import java.awt.event.KeyEvent;
import javax.swing.JTextArea;

import model.tree.nodes.MyTreeNode;

public class NodeDescriptionListener extends MyKeyListener {
	private MyTreeNode node;
	private JTextArea textArea;
	
	public NodeDescriptionListener() {}
	
	public NodeDescriptionListener(MyTreeNode node,JTextArea textArea) {
		this.node = node;
		this.textArea = textArea;
	}

	@Override
	public void myKeyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void myKeyReleased(KeyEvent arg0) {
		node.setDescription(textArea.getText());
	}

	@Override
	public void myKeyTyped(KeyEvent arg0) {
		
	}

	public MyTreeNode getNode() {
		return node;
	}

	public void setNode(MyTreeNode node) {
		this.node = node;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
}
