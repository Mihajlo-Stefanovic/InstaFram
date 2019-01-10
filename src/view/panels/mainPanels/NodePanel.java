package view.panels.mainPanels;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.tree.nodes.MyTreeNode;
import observer.MyObserver;

public class NodePanel extends JPanel implements MyObserver {

	private static final long serialVersionUID = 1184361601765629587L;

	private BoxLayout layout;

	private MyTreeNode currNode;

	private JLabel nodeName;
	private JLabel parentName;
	private JLabel nodeChildCount;
	private JLabel nodeLeafCount;
	private JLabel nodeDescription;

	public NodePanel() {
		layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);

		instantiateLabels();
		addLabels();
	}

	private void instantiateLabels() {
		nodeName = new JLabel("Node Name: ");
		parentName = new JLabel("Parent Name: ");
		nodeChildCount = new JLabel("Child Count: ");
		nodeLeafCount = new JLabel("Leaf Count: ");
		nodeDescription = new JLabel("Node Description: ");
	}

	private void addLabels() {
		this.add(nodeName);
		this.add(parentName);
		this.add(nodeChildCount);
		this.add(nodeLeafCount);
		this.add(nodeDescription);
	}

	public JLabel getNodeName() {
		return nodeName;
	}

	private void setNodeName(String nodeName) {
		this.nodeName.setText("<html>" + "<b>" + "Node Name: " + "</b>" + nodeName + "<html>");
	}

	private void setParentName(String parentName) {
		this.parentName.setText("<html>" + "<b>" + "Parent Name: " + "</b>" + parentName + "<html>");
	}

	public JLabel getNodeChildCount() {
		return nodeChildCount;
	}

	private void setNodeChildCount(Integer nodeChildCount) {
		this.nodeChildCount.setText("<html>" + "<b>" + "Child Count: " + "</b>" + nodeChildCount + "<html>");
	}

	public JLabel getNodeLeafCount() {
		return nodeLeafCount;
	}

	private void setNodeLeafCount(Integer nodeLeafCount) {
		this.nodeLeafCount.setText("<html>" + "<b>" + "Leaf Count: " + "</b>" + nodeLeafCount + "<html>");
	}

	public JLabel getNodeDescription() {
		return nodeDescription;
	}

	private void setNodeDescription(String nodeDescription) {
		if (nodeDescription != null)
			this.nodeDescription.setText(
					"<html>" + "<b>" + "Node Description:<br/>" + "</b>" + convertToHTML(nodeDescription) + "<html>");
	}

	private String convertToHTML(String stringToConvert) {
		return stringToConvert.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>");
	}

	public void setPanelForNode(MyTreeNode node) {
		if (node != null) {
			currNode = node;
			setNodeName(node.getName());
			if (node.getParent() != null)
				setParentName(((MyTreeNode) node.getParent()).getName());
			else
				setParentName("No Parent");
			setNodeChildCount(node.getAllChildrenCount(false, 0));
			setNodeLeafCount(node.getAllChildrenCount(true, 0));
			setNodeDescription(node.getDescription());
		}
	}

	@Override
	public void update(Object obj) {
		if (obj instanceof MyTreeNode) {
			MyTreeNode node = (MyTreeNode) obj;
			if (node == currNode)
				setPanelForNode(node);
		}
	}
}
