package view.frames;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import app.AppCore;

public class AboutFrame extends MyFrame {

	private static final long serialVersionUID = -4148940559735026269L;
	JLabel lbIme;
	JLabel lbPrezime;
	JLabel lbBrIndeksa;
	JLabel lbMyPic;

	private JFrame parentFrame;
	
	public AboutFrame(JFrame parentFrame) {
		this.parentFrame = parentFrame;
		initializeFrame(0, 0);
		setVisible(true);
	}

	@Override
	void initializeFrame(float screenHeightPercent, float screenWidthPercent) {

		defaultScreenWidthPercent = 20;
		defaultScreenHightPercent = 20;

		minScreenWidthPercent = 20;
		minScreenHightPercent = 20;

		setSizeNPos(screenHeightPercent, screenWidthPercent);
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		setLayout(flowLayout);

		makeLabels();
		addLabels();
		
		// hack
		setAlwaysOnTop(true);
		
		setTitle("About");
	}

	private void addLabels() {
		add(lbMyPic);
		add(lbIme);
		add(lbPrezime);
		add(lbBrIndeksa);
	}

	private void makeLabels() {
		lbIme = new JLabel("Mihajlo");
		lbPrezime = new JLabel("Stefanovic");
		lbBrIndeksa = new JLabel("05/17 RN");

		lbMyPic = new JLabel(AppCore.getInstance().getLoadedImages().getMyPicIcon());
	}
}
