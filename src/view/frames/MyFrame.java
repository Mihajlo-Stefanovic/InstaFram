package view.frames;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class MyFrame extends JFrame {


	private static final long serialVersionUID = -4911898997740310115L;
	protected float defaultScreenWidthPercent;
	protected float defaultScreenHightPercent;

	protected float minScreenWidthPercent;
	protected float minScreenHightPercent;

	abstract void initializeFrame(float screenHeightPercent, float screenWidthPercent);

	protected void setSizeNPos(float screenHeightPercent, float screenWidthPercent) {

		Toolkit toolKit = Toolkit.getDefaultToolkit();

		Dimension screenSize = toolKit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		if (screenHeightPercent > 100 || screenHeightPercent <= 0) {
			screenHeightPercent = defaultScreenHightPercent;
		}
		if (screenWidthPercent > 100 || screenWidthPercent <= 0) {
			screenWidthPercent = defaultScreenWidthPercent;
		}

		screenHeightPercent /= 100;
		screenWidthPercent /= 100;

		int frameHeight = (int) (screenHeight * screenHeightPercent);
		int frameWidth = (int) (screenWidth * screenWidthPercent);

		int positionX = screenWidth / 2 - frameWidth / 2;
		int positionY = screenHeight / 2 - frameHeight / 2;

		this.setSize(frameWidth, frameHeight);
		this.setLocation(positionX, positionY);

		setMinimumSize(new Dimension((int) (screenWidth * minScreenWidthPercent / 100),
				(int) (screenHeight * minScreenHightPercent / 100))); // minimum values
	}

	public void close() {
		dispose();
		setVisible(false);
	}
}
