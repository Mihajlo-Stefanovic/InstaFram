package view.panels.mainPanels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeCellRenderer;

import app.AppCore;
import controller.MyCellEditor;
import controller.actions.mouseListeners.TreeMouseListener;
import model.tree.MyJTreeWSavedVersion;
import model.tree.nodes.MyTreeNode;

public class TreePanel extends JPanel {

	private static final long serialVersionUID = -7489481645669592461L;
	private JScrollPane scrollPane;
	private MyJTreeWSavedVersion tree;

	public TreePanel() {
		setMinimumSize(new Dimension(250, 250));
		setLayout(new GridLayout());
	}

	public void addTree() {
		removeAll();

		tree = new MyJTreeWSavedVersion();
		tree.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		TreeMouseListener treeMouseListener = new TreeMouseListener();
		tree.addMouseListener(treeMouseListener);
		tree.setEditable(true);

		tree.setCellEditor(new MyCellEditor(tree, new DefaultTreeCellRenderer()));

		scrollPane = new JScrollPane(tree);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, BorderLayout.EAST);
		
		revalidate();
		repaint();
		SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getTree());
	}
	
	public void removeTree() {
		MyTreeNode.setNumOfInstances(0);
		removeAll();
		tree = null;
		revalidate();
		repaint();
	}

	public MyJTreeWSavedVersion getTree() {
		return tree;
	}
}
