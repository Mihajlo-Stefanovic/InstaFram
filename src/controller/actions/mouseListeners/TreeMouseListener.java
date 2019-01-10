package controller.actions.mouseListeners;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.tree.TreePath;

import app.AppCore;
import model.tree.MyJTree;
import model.tree.nodes.MyTreeNode;
import view.menues.MyTreePopUpMenu;

public class TreeMouseListener extends MyMouseListener {
	MyTreePopUpMenu popUpMenu = new MyTreePopUpMenu();

	private MyTreeNode getNode() {
		return (MyTreeNode) AppCore.getInstance().getTree().getLastSelectedPathComponent();
	}

	@Override
	public void myMouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (e.getClickCount() == 2) {
				MyTreeNode node = getNode();
				if (node != null) {
					if (node != null && !node.hasObserver(AppCore.getInstance().getNodeTabPanel()))
						node.registerObserver(AppCore.getInstance().getNodeTabPanel());
					AppCore.getInstance().getNodeTabPanel().openTabForNode(node);
				}
			} else if (e.getClickCount() == 1) {
				MyTreeNode node = getNode();
				
				if (node != null && !node.hasObserver(AppCore.getInstance().getNodePanel()))
					node.registerObserver(AppCore.getInstance().getNodePanel());
				AppCore.getInstance().getNodePanel().setPanelForNode(node);
				AppCore.getInstance().getNodeTabPanel().setActiveTabForNode(node);
			}
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			MyJTree tree = AppCore.getInstance().getTree();
			
			int selRow = tree.getRowForLocation(e.getX(), e.getY());
			TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
			
			ArrayList<TreePath> paths = null;
			
			if(tree.getSelectionPaths()!=null) {
				paths = new ArrayList<>(Arrays.asList(tree.getSelectionPaths()));
			
			if(!paths.contains(selPath)) {
	                 tree.setSelectionPath(selPath); 
	                 if (selRow>-1){
	                    tree.setSelectionRow(selRow); 
	                 }
			}
			
			popUpMenu.showFor(tree.getBiggestNodeInPaths(paths),e.getComponent(), e.getX(), e.getY());
			}
		}
	}

	@Override
	public void myMousePressed(MouseEvent e) {

	}

	@Override
	public void myMouseReleased(MouseEvent e) {

	}

	@Override
	public void myMouseEntered(MouseEvent e) {

	}

	@Override
	public void myMouseExited(MouseEvent e) {

	}

}