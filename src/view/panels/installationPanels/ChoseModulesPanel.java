package view.panels.installationPanels;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import app.AppCore;
import model.Pair;
import model.tree.nodes.parameterContainers.ParameterContainer;

public class ChoseModulesPanel extends InstallationPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7989427188297662288L;
	ArrayList<JCheckBox> cbModules;
	
	public ChoseModulesPanel(ArrayList<Pair<Pair<String, String>, ArrayList<ParameterContainer>>> arrayList) {
		cbModules = new ArrayList<>();
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxLayout);
		
		for (Pair<Pair<String, String>, ArrayList<ParameterContainer>> pair : arrayList) {
			JCheckBox newCheckBox = new JCheckBox(pair.getFirst().getFirst());
			add(newCheckBox);
			cbModules.add(newCheckBox);
		}
	}

	@Override
	public void doAction() {
		for (JCheckBox jCheckBox : cbModules) {
			if(jCheckBox.isSelected()) {
				AppCore.getInstance().getInstaller().getNumOfModulForInstal().add(cbModules.indexOf(jCheckBox));
			}
		}
	}
}
