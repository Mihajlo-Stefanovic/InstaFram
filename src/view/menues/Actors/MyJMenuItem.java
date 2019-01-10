package view.menues.Actors;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import controller.actions.actionListeners.MyActionListener;

public class MyJMenuItem extends JMenuItem implements MyActor{


	private static final long serialVersionUID = -4431074528904785374L;

	@Override
	public void addActionListener(ActionListener actionListener) {
		if (actionListener instanceof MyActionListener) {
			MyActionListener myActionListener = (MyActionListener) actionListener;
			myActionListener.associateWButton(this);
			super.addActionListener(actionListener);
		} else
			System.out.println("Action not added!");
	}
	
	@Override
	public void disableAction() {
		this.setEnabled(false);
	}

	@Override
	public void enableAction() {
		this.setEnabled(true);
	}
	
	public MyJMenuItem(String string) {
		super(string);
	}
}
