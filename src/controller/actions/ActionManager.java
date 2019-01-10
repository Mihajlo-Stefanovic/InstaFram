package controller.actions;

import controller.actions.actionListeners.editListeners.TreeCopyListener;
import controller.actions.actionListeners.editListeners.TreeCutListener;
import controller.actions.actionListeners.editListeners.TreePasteListener;
import controller.actions.actionListeners.installListeners.ExportListener;
import controller.actions.actionListeners.installListeners.InstallListener;
import controller.actions.actionListeners.projectListeners.CloseProjectListener;
import controller.actions.actionListeners.projectListeners.LoadProjectListener;
import controller.actions.actionListeners.projectListeners.SaveAsListener;
import controller.actions.actionListeners.projectListeners.SaveListener;
import controller.actions.actionListeners.tabListeners.CloseAllTabsListener;
import controller.actions.actionListeners.tabListeners.CloseTabListener;
import controller.actions.actionListeners.treeListeners.AddTreeListener;
import controller.actions.actionListeners.treeListeners.DeleteNodeListener;
import controller.actions.actionListeners.treeListeners.AddNodeListener;
import controller.actions.actionListeners.treeListeners.NewProjectListener;
import controller.actions.actionListeners.undoRedoListeners.RedoListener;
import controller.actions.actionListeners.undoRedoListeners.UndoListener;
import model.User;

public class ActionManager {

	private NewProjectListener newProjectListener;
	private AddNodeListener newNodeListener;
	
	private LoadProjectListener loadProjectListener;
	private AddTreeListener addTreeListener;
	
	private SaveListener saveListener;
	private SaveAsListener saveAsListener;
	
	private DeleteNodeListener deleteNodeListener;
	private CloseProjectListener closeProjectListener;

	private CloseTabListener closeTabListener;
	private CloseAllTabsListener closeAllTabsListener;
	
	private TreeCopyListener copyListener;
	private TreeCutListener cutListener;
	private TreePasteListener pasteListener;
	
	private UndoListener undoListener;
	private RedoListener redoListener;
	
	private ExportListener exportListener;
	private InstallListener installListener;
	
	public ActionManager() {
		initialiseActions();
	}

	private void initialiseActions() {
		newNodeListener = new AddNodeListener();
		saveListener = new SaveListener();
		saveAsListener = new SaveAsListener();
		deleteNodeListener = new DeleteNodeListener();
		loadProjectListener = new LoadProjectListener();
		newProjectListener = new NewProjectListener();
		closeProjectListener = new CloseProjectListener();
		addTreeListener = new AddTreeListener();
		closeTabListener = new CloseTabListener();
		closeAllTabsListener = new CloseAllTabsListener();
		copyListener = new TreeCopyListener();
		cutListener = new TreeCutListener();
		pasteListener = new TreePasteListener();
		undoListener = new UndoListener();
		redoListener = new RedoListener();
		exportListener = new ExportListener();
		installListener = new InstallListener();
	}

	public void setActionsFor(User user) {
		if(!user.isAdmin()) {
			newNodeListener.dissableActors();
			deleteNodeListener.dissableActors();
			addTreeListener.dissableActors();
			newProjectListener.dissableActors();
			copyListener.dissableActors();
			cutListener.dissableActors();
			pasteListener.dissableActors();
		}
	}
	
	public AddTreeListener getAddTreeListener() {
		return addTreeListener;
	}

	public void setAddTreeListener(AddTreeListener addTreeListener) {
		this.addTreeListener = addTreeListener;
	}

	public CloseProjectListener getCloseProjectListener() {
		return closeProjectListener;
	}

	public NewProjectListener getNewProjectListener() {
		return newProjectListener;
	}

	public LoadProjectListener getLoadProjectListener() {
		return loadProjectListener;
	}

	public AddNodeListener getNewNodeListener() {
		return newNodeListener;
	}

	public SaveListener getSaveListener() {
		return saveListener;
	}

	public DeleteNodeListener getDeleteNodeListener() {
		return deleteNodeListener;
	}

	public SaveAsListener getSaveAsListener() {
		return saveAsListener;
	}

	public CloseTabListener getCloseTabListener() {
		return closeTabListener;
	}
	
	public CloseAllTabsListener getCloseAllTabsListener() {
		return closeAllTabsListener;
	}

	public TreeCopyListener getCopyListener() {
		return copyListener;
	}

	public TreeCutListener getCutListener() {
		return cutListener;
	}

	public TreePasteListener getPasteListener() {
		return pasteListener;
	}

	public UndoListener getUndoListener() {
		return undoListener;
	}

	public RedoListener getRedoListener() {
		return redoListener;
	}

	public InstallListener getInstallListener() {
		return installListener;
	}

	public ExportListener getExportListener() {
		return exportListener;
	}

}
