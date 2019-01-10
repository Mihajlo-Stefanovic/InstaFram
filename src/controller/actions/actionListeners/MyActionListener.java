package controller.actions.actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import view.menues.Actors.MyActor;

public abstract class MyActionListener implements ActionListener{
	private ArrayList<MyActor> actors;
	private boolean isEnabled = true;
	
	@Override
	public void actionPerformed(ActionEvent event) {
		myActionPerformed(event);
	}
	
	protected abstract void myActionPerformed(ActionEvent event);

	public MyActionListener() {
		actors = new ArrayList<>();
	}
	
	public void associateWButton(MyActor actor) {
		if(!actors.contains(actor)) {
			actors.add(actor);
			if(!isEnabled)
				actor.disableAction();
		}
		else {
			System.out.println(actor + " already associated!");
		}
	}
	
	public void dissableActors() {
		isEnabled = false;
		for (MyActor myActor : actors) {
			myActor.disableAction();
		}
	}
	
	public void enableActors() {
		isEnabled = true;
		for (MyActor myActor : actors) {
			myActor.enableAction();
		}
	}
}
