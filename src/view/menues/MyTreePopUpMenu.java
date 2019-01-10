package view.menues;

import java.awt.Component;
import javax.swing.JPopupMenu;
import app.AppCore;
import controller.actions.ActionManager;
import model.tree.nodes.MyTreeNodeTypes;
import view.menues.Actors.MyJMenuItem;

public class MyTreePopUpMenu extends JPopupMenu{

	private static final long serialVersionUID = 4166531833943882316L;
	MyJMenuItem copy;
	MyJMenuItem cut;
	MyJMenuItem paste;
	
	MyJMenuItem newNode;
	MyJMenuItem delete;
	
	public MyTreePopUpMenu() {
		copy = new MyJMenuItem("Copy");
		cut = new MyJMenuItem("Cut");
		paste = new MyJMenuItem("Paste");
		newNode = new MyJMenuItem("New");
		delete = new MyJMenuItem("Delete");
		
		ActionManager actionManager = AppCore.getInstance().getActionManager();
		
		copy.addActionListener(actionManager.getCopyListener());
		cut.addActionListener(actionManager.getCutListener());
		paste.addActionListener(actionManager.getPasteListener());
		newNode.addActionListener(actionManager.getNewNodeListener());
		delete.addActionListener(actionManager.getDeleteNodeListener());

	}
	
	public void showFor(MyTreeNodeTypes nodeType, Component invoker, int x, int y) {
		removeAll();
		if(nodeType.equals(MyTreeNodeTypes.Parameter)) {
			add(copy);
			add(cut);
			addSeparator();
		}
		else if(nodeType.equals(MyTreeNodeTypes.Module) || nodeType.equals(MyTreeNodeTypes.Product)){
			add(paste);
			addSeparator();
		}
		
		add(newNode);
		add(delete);
		
		super.show(invoker, x, y);
	}
}
