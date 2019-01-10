package app;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;

import controller.CommandManager;
import controller.ExceptionManager;
import controller.Installer;
import controller.actions.ActionManager;
import controller.loader.Loader;
import controller.loader.TreeJavaSerLoader;
import controller.saver.Saver;
import controller.saver.TreeJavaSerSaver;
import model.MyClipBoard;
import model.User;
import model.holders.LoadedImages;
import model.tree.MyJTreeWSavedVersion;
import view.frames.MainFrame;
import view.panels.mainPanels.NodePanel;
import view.panels.mainPanels.NodeTabPanel;

public class AppCore implements ClipboardOwner{
	private static AppCore instance;
	
	private User user;

	private ActionManager actionManager;
	private CommandManager commandManager;
	private ExceptionManager exceptionManager;
	
	private MyClipBoard clipBoard;

	private Loader loader;
	private Saver saver;
	
	private Installer installer;
	
	private MainFrame mainFrame;
	
	private LoadedImages loadedImages;
	
	//private boolean debugMode;
	
	private AppCore() {
		actionManager = new ActionManager();
		commandManager = new CommandManager();
		exceptionManager = new ExceptionManager();
		clipBoard = new MyClipBoard("Klip Bord");
		loader = new TreeJavaSerLoader();
		saver = new TreeJavaSerSaver();
		loadedImages = new LoadedImages();
		installer = new Installer();
	}

	/**
	 * Creates instance if it is not already created;
	 * @return True if instance is created. False if not.
	 */
	public static boolean initializeAppCore() {
		if (instance == null) {
			instance = new AppCore();
			return true;
		}
		else return false;
	}
	
	public static AppCore getInstance() {
		return instance;
	}

	public MyJTreeWSavedVersion getTree() {
		return mainFrame.getCenterPanel().getTreePanel().getTree();
	}

	public ActionManager getActionManager() {
		return actionManager;
	}

	public ExceptionManager getExceptionManager() {
		return exceptionManager;
	}

	public LoadedImages getLoadedImages() {
		return loadedImages;
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	public Loader getLoader() {
		return loader;
	}

	public Saver getSaver() {
		return saver;
	}
	
	public NodeTabPanel getNodeTabPanel() {
		return mainFrame.getCenterPanel().getRightPanel().getNodeDescriptionPanel();
	}
	
	public NodePanel getNodePanel() {
		return mainFrame.getCenterPanel().getRightPanel().getNodePanel();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		actionManager.setActionsFor(user);
		mainFrame.getBottomPanel().setUser(user);
	}

	public MyClipBoard getClipBoard() {
		return clipBoard;
	}
	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		System.out.println("App Core lost ownership of ClipBoard!");
	}

	public CommandManager getCommandManager() {
		return commandManager;
	}

	public Installer getInstaller() {
		return installer;
	}

	/*public boolean isDebugMode() {
		return debugMode;
	}*/
	
}
