package controller.actions.mouseListeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class MyMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		myMouseClicked(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		myMouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		myMouseExited(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		myMousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		myMouseReleased(e);
	}
	
	public abstract void myMouseClicked(MouseEvent e);

	public abstract void myMouseEntered(MouseEvent e);

	public abstract void myMouseExited(MouseEvent e);

	public abstract void myMousePressed(MouseEvent e);

	public abstract void myMouseReleased(MouseEvent e);
}
