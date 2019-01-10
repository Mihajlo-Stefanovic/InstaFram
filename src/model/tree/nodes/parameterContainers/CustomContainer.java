package model.tree.nodes.parameterContainers;

import java.util.ArrayList;
import observer.MyObservable;
import observer.MyObserver;
import view.panels.parameterPanels.containerPanels.ContainerTypes;

public class CustomContainer extends ParameterContainer implements MyObservable {

	private static final long serialVersionUID = -6156001541734790352L;

	private ArrayList<ParameterContainer> subContainers;

	private ArrayList<MyObserver> observers;

	public CustomContainer(ArrayList<ParameterContainer> subContainers) {
		super(ContainerTypes.Custom, null);
		this.subContainers = new ArrayList<>(subContainers);
		observers = new ArrayList<>();
	}

	public CustomContainer() {
		super(ContainerTypes.Custom, null);
		subContainers = new ArrayList<>();
		observers = new ArrayList<>();
	}

	public void addContainer(ParameterContainer container) {
		this.subContainers.add(container);
		notifyObservers();
	}

	public void removeContainer(ParameterContainer container) {
		this.subContainers.remove(container);
		notifyObservers();
	}

	public ArrayList<ParameterContainer> getSubContainers() {
		return subContainers;
	}

	@Override
	public ParameterContainer getCopy() {
		return new CustomContainer(subContainers);
	}

	@Override
	public void registerObserver(MyObserver newObserver) {
		observers.add(newObserver);
	}

	@Override
	public void unregisterObserver(Object ObserverToDelete) {
		observers.remove(ObserverToDelete);
	}

	@Override
	public void notifyObservers() {
		for (MyObserver myObserver : observers) {
			myObserver.update(this);
		}
	}

	@Override
	public boolean hasObserver(Object o) {
		return observers.contains(o);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CustomContainer) {
			try {
				CustomContainer oth = (CustomContainer) obj;
				for (int i = 0; i < subContainers.size(); i++) {
					if(!subContainers.get(i).equals(oth.getSubContainers().get(i)))
						return false;
				}
				return true;
			} catch (IndexOutOfBoundsException e) {
			}
		}
		return super.equals(obj);
	}
}
