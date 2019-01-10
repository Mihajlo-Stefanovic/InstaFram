package view.menues.menuBarItems;

import javax.swing.JMenu;
import app.AppCore;
import controller.actions.ActionManager;
import view.menues.Actors.MyJMenuItem;

public class MenuBarFile extends JMenu {


	private static final long serialVersionUID = 1399827944722051888L;
	private MyJMenuItem miNewProject, miNewNode, miOpenProject ,miCloseProject, miCloseNode, miSaveSave, miSaveSaveAs,miOpenTree;
	private JMenu mNew, mOpen, mSave, mClose;

	public MenuBarFile() {
		setText("File");
		setFileItems();
	}

	private void setFileItems() {
		createFileItems();
		setListeners();
		addFileItems();
	}

	private void setListeners() {
		ActionManager actionManager = AppCore.getInstance().getActionManager();
		miNewProject.addActionListener(actionManager.getNewProjectListener());
		miNewNode.addActionListener(actionManager.getNewNodeListener());
		
		miOpenProject.addActionListener(actionManager.getLoadProjectListener());
		miOpenTree.addActionListener(actionManager.getAddTreeListener());
		
		miSaveSave.addActionListener(actionManager.getSaveListener());
		miSaveSaveAs.addActionListener(actionManager.getSaveAsListener());
		
		miCloseProject.addActionListener(actionManager.getCloseProjectListener());
		miCloseNode.addActionListener(actionManager.getDeleteNodeListener());
	}
	
	private void createFileItems() {
		mNew = new JMenu("New");
		mOpen = new JMenu("Open");
		mSave = new JMenu("Save");
		mClose = new JMenu("Close");

		createFileNewItems();
		createFileOpenItems();
		createFileSaveItems();
		createFileCloseItems();
		
		setIcons();
	}
	
	private void createFileNewItems() {
		miNewProject = new MyJMenuItem("Project");
		miNewNode = new MyJMenuItem("Node");
	}
	
	private void createFileOpenItems() {
		miOpenProject = new MyJMenuItem("Project");
		miOpenTree = new MyJMenuItem("Tree");
	}
	
	private void createFileSaveItems() {
		miSaveSave = new MyJMenuItem("Save");
		miSaveSaveAs = new MyJMenuItem("Save As");
	}
	
	private void createFileCloseItems() {
		miCloseProject = new MyJMenuItem("Project");
		miCloseNode = new MyJMenuItem("Node");
	}
	
	private void addFileItems() {
		add(mNew);
		addSeparator();
		add(mOpen);
		addSeparator();
		add(mSave);
		addSeparator();
		add(mClose);
		
		addFileNewItems();
		addFileOpenItems();
		addFileSaveItems();
		addFileCloseItems();
	}

	private void addFileNewItems() {
		mNew.add(miNewProject);
		mNew.add(miNewNode);
	}

	private void addFileOpenItems() {
		mOpen.add(miOpenProject);
		mOpen.add(miOpenTree);
	}
	
	private void addFileSaveItems() {
		mSave.add(miSaveSave);
		mSave.add(miSaveSaveAs);
	}
	
	private void addFileCloseItems() {
		mClose.add(miCloseProject);
		mClose.add(miCloseNode);
	}
	
	private void setIcons() {
		miNewProject.setIcon(AppCore.getInstance().getLoadedImages().getNewProjectIcon());
		miNewNode.setIcon(AppCore.getInstance().getLoadedImages().getAddNodeIcon());
		
		miOpenProject.setIcon(AppCore.getInstance().getLoadedImages().getOpenProjectIcon());
		miOpenTree.setIcon(AppCore.getInstance().getLoadedImages().getAddTreeIcon());
		
		miCloseProject.setIcon(AppCore.getInstance().getLoadedImages().getCloseProjectIcon());
		miCloseNode.setIcon(AppCore.getInstance().getLoadedImages().getDeleteNodeIcon());
		
		miSaveSave.setIcon(AppCore.getInstance().getLoadedImages().getSaveProjectIcon());
		miSaveSaveAs.setIcon(AppCore.getInstance().getLoadedImages().getSaveProjectAsIcon());
	}
}
