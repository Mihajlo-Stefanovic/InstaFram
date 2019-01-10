package controller.actions.keyListeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class MyKeyListener implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		myKeyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		myKeyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		myKeyTyped(e);
	}
	
	protected abstract void myKeyPressed(KeyEvent e);

	protected abstract void myKeyReleased(KeyEvent e);

	protected abstract void myKeyTyped(KeyEvent e);
}
