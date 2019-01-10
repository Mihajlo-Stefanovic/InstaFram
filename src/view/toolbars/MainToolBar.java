package view.toolbars;

import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.JToolBar;

import app.AppCore;
import view.menues.Actors.MyJButton;

public class MainToolBar extends JToolBar {


	private static final long serialVersionUID = 7736370521518055290L;
	private MyJButton jbNewProject;
	private MyJButton jbLoadProject;
	private MyJButton jbCloseProject;

	private MyJButton jbSaveProject;
	private MyJButton jbSaveProjectAs;

	private MyJButton jbNewNode;
	private MyJButton jbAddTree;
	private MyJButton jbDeleteNodes;
	
	private MyJButton jbUndo;
	private MyJButton jbRedo;

	public MainToolBar() {
		makeButtons();
		addIcons();
		setBorders();
		setButtonListeners();
		addButtons();

		setFloatable(false);
		setBackground(SystemColor.control);
	}

	private void setButtonListeners() {
		jbSaveProject.addActionListener(AppCore.getInstance().getActionManager().getSaveListener());
		jbSaveProjectAs.addActionListener(AppCore.getInstance().getActionManager().getSaveAsListener());
		jbNewNode.addActionListener(AppCore.getInstance().getActionManager().getNewNodeListener());
		jbDeleteNodes.addActionListener(AppCore.getInstance().getActionManager().getDeleteNodeListener());
		jbLoadProject.addActionListener(AppCore.getInstance().getActionManager().getLoadProjectListener());
		jbNewProject.addActionListener(AppCore.getInstance().getActionManager().getNewProjectListener());
		jbAddTree.addActionListener(AppCore.getInstance().getActionManager().getAddTreeListener());
		jbCloseProject.addActionListener(AppCore.getInstance().getActionManager().getCloseProjectListener());
		
		jbUndo.addActionListener(AppCore.getInstance().getActionManager().getUndoListener());
		jbRedo.addActionListener(AppCore.getInstance().getActionManager().getRedoListener());
	}

	private void makeButtons() {
		jbNewProject = new MyJButton();
		jbLoadProject = new MyJButton();
		jbCloseProject = new MyJButton();

		jbNewNode = new MyJButton();
		jbDeleteNodes = new MyJButton();

		jbSaveProject = new MyJButton();
		jbAddTree = new MyJButton();
		jbSaveProjectAs = new MyJButton();
		
		jbUndo = new MyJButton();
		jbRedo = new MyJButton();
	}

	private void addIcons() {
		jbNewProject.setIcon(AppCore.getInstance().getLoadedImages().getNewProjectIcon());
		jbLoadProject.setIcon(AppCore.getInstance().getLoadedImages().getOpenProjectIcon());
		jbCloseProject.setIcon(AppCore.getInstance().getLoadedImages().getCloseProjectIcon());

		jbSaveProject.setIcon(AppCore.getInstance().getLoadedImages().getSaveProjectIcon());
		jbSaveProjectAs.setIcon(AppCore.getInstance().getLoadedImages().getSaveProjectAsIcon());

		jbNewNode.setIcon(AppCore.getInstance().getLoadedImages().getAddNodeIcon());
		jbAddTree.setIcon(AppCore.getInstance().getLoadedImages().getAddTreeIcon());
		jbDeleteNodes.setIcon(AppCore.getInstance().getLoadedImages().getDeleteNodeIcon());
		
		jbUndo.setText("Undo");
		jbRedo.setText("Redo");
	}

	private void setBorders() {
		jbNewProject.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jbLoadProject.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jbCloseProject.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		jbSaveProject.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jbSaveProjectAs.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		jbNewNode.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jbAddTree.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jbDeleteNodes.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		jbUndo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jbRedo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}

	private void addButtons() {
		add(jbNewProject);
		add(jbLoadProject);
		add(jbCloseProject);

		addSeparator();

		add(jbSaveProject);
		add(jbSaveProjectAs);

		addSeparator();

		add(jbNewNode);
		add(jbAddTree);
		add(jbDeleteNodes);
		
		addSeparator();
		
		add(jbUndo);
		add(jbRedo);
	}

}
