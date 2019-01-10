package observer;

public interface MyObservable {
	public void registerObserver(MyObserver newObserver);
	public void unregisterObserver(Object ObserverToDelete);
	public void notifyObservers();
	public boolean hasObserver(Object o);
}
