package view.tabs;

import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import controller.actions.keyListeners.NodeDescriptionListener;
import model.tree.nodes.MyTreeNode;
import model.tree.nodes.ParameterSubtypes;

public class DescriptionTab extends MyTab {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4124375250058674806L;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	private NodeDescriptionListener nodeDescriptionKeyListener;
	
	public DescriptionTab(MyTreeNode node) {
		super(node);
		setNode(node);
	}
	
	@Override
	protected void initialize() {
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		nodeDescriptionKeyListener = new NodeDescriptionListener();
		textArea.addKeyListener(nodeDescriptionKeyListener);

		setLayout(new GridLayout());
		add(scrollPane);
		
		ParameterSubtypes subType;
	}
	
	@Override
	protected void putValuesForNode(MyTreeNode node) {
		textArea.setText(node.getDescription());
	}
	@Override
	public void setNode(MyTreeNode node) {
		this.node = node;
		nodeDescriptionKeyListener.setNode(node);
		nodeDescriptionKeyListener.setTextArea(textArea);
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

}
