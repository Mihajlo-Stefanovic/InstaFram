package view.frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.WindowConstants;

import controller.actions.windowListeners.mainFrameWindowListener;
import view.menues.MenuBar;
import view.panels.mainPanels.BottomPanel;
import view.panels.mainPanels.CenterPanel;
import view.toolbars.MainToolBar;

public class MainFrame extends MyFrame {


	private static final long serialVersionUID = 8185628597657191542L;
	CenterPanel centerPanel;
	BottomPanel bottomPanel;

	public AboutFrame aboutFrame;

	public MainFrame(Dimension dimension) {
		initializeFrame(dimension.height, dimension.width);
		setVisible(true);
	}

	public MainFrame() {
		initializeFrame(0, 0);
		setVisible(true);
	}

	@Override
	/**
	 * Sets main frame and adds all elements to it
	 * 
	 * @param screenHeightPercent Main frame height in proportion to screen size.
	 * @param screenWidthPercent  Main frame width in proportion to screen size.
	 */
	protected void initializeFrame(float screenHeightPercent, float screenWidthPercent) {

		defaultScreenWidthPercent = 60;
		defaultScreenHightPercent = 60;

		minScreenWidthPercent = 50;
		minScreenHightPercent = 50;

		setSizeNPos(screenHeightPercent, screenWidthPercent);
		addMenuBar();
		addToolBar();

		centerPanel = new CenterPanel();
		bottomPanel = new BottomPanel();

		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);

		this.addWindowListener(new mainFrameWindowListener());

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("InstaFram");
	}

	private void addToolBar() {
		MainToolBar toolBar = new MainToolBar();
		add(toolBar, BorderLayout.NORTH);
	}

	private void addMenuBar() {
		MenuBar menuBar = new MenuBar();
		setJMenuBar(menuBar);
	}

	public CenterPanel getCenterPanel() {
		return centerPanel;
	}

	public BottomPanel getBottomPanel() {
		return bottomPanel;
	}

}
