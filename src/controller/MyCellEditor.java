package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import app.AppCore;
import model.tree.nodes.MyTreeNode;

public class MyCellEditor extends DefaultTreeCellEditor {

	private Object node = null;
	private JTextField edit;
	
	public MyCellEditor(JTree jTree, DefaultTreeCellRenderer renderer) {
		super(jTree, renderer);
	}

	@Override
	public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {

		super.getTreeCellEditorComponent(tree, value, isSelected, expanded, leaf, row);
		node = value;
		
		edit = new JTextField(value.toString());
		edit.addActionListener(this);
		return edit;
	}

	@Override
	public boolean isCellEditable(EventObject event) {
		if (event instanceof MouseEvent)
			if (((MouseEvent) event).getClickCount() == 3) {
				return true;
			}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (node instanceof MyTreeNode) {
			((MyTreeNode) node).setName(e.getActionCommand());
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getTree());
		}
	}
}
