package view.panels.mainPanels;

import javax.swing.JSplitPane;

public class RightPanel extends JSplitPane {

	private static final long serialVersionUID = 7684158366128828364L;
	private NodeTabPanel nodeDescriptionPanel;
	private NodePanel nodePanel;

	public RightPanel(int arg) {
		super(arg);
		nodeDescriptionPanel = new NodeTabPanel();
		nodePanel = new NodePanel();
		setTopComponent(nodeDescriptionPanel);
		//setBottomComponent(nodePanel);
	}
	
    private final int location = 300;
    {
        setDividerLocation( location );
    }
    @Override
    public int getDividerLocation() {
        return location ;
    }
    @Override
    public int getLastDividerLocation() {
        return location ;
    }
	public NodeTabPanel getNodeDescriptionPanel() {
		return nodeDescriptionPanel;
	}
	public NodePanel getNodePanel() {
		return nodePanel;
	}
}
