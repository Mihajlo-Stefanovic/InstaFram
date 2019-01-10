package model.tree.nodes.parameterContainers;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import view.panels.parameterPanels.containerPanels.ContainerTypes;

public class LookAndFeelContainer extends ParameterContainer {

	private static final long serialVersionUID = 4653118054380204763L;
	private String lookAndFeelInfo;

	public LookAndFeelContainer() {
		super(ContainerTypes.LookAndFeel,0);
	}

	public LookAndFeelContainer(LookAndFeelInfo lookAndFeelInfo) {
		super(ContainerTypes.LookAndFeel,0);
		if (lookAndFeelInfo != null)
			this.lookAndFeelInfo = new String(lookAndFeelInfo.getName());
	}

	public LookAndFeelInfo getLookAndFeelInfo() {
		return stringToLookNFeel(lookAndFeelInfo);
	}

	public void setLookAndFeelInfo(LookAndFeelInfo lookAndFeelInfo) {
		this.lookAndFeelInfo = lookAndFeelInfo.getName();
	}

	@Override
	public ParameterContainer getCopy() {
		return new LookAndFeelContainer(stringToLookNFeel(lookAndFeelInfo));
	}

	public LookAndFeelInfo stringToLookNFeel(String s) {
		for (LookAndFeelInfo look : UIManager.getInstalledLookAndFeels()) {
			if (look.getName().equals(s))
				return look;
		}
		return null;
	}

	@Override
	public boolean equals(Object obj) {
			if (obj instanceof LookAndFeelContainer) {
				LookAndFeelContainer oth = (LookAndFeelContainer) obj;
				if(oth.getLookAndFeelInfo() == null && getLookAndFeelInfo()==null)
					return true;
				else if(oth.getLookAndFeelInfo() == null)
					return false;
				if (oth.getLookAndFeelInfo().equals(getLookAndFeelInfo()))
					return true;
			}
		return false;
	}
}
