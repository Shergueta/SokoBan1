package model;

import java.util.Observer;

public interface Model {

	Observer o();

	public void addObserver(Observer o);// Add an Observer.
	public void deleteObserver(Observer o);// Delete an Observer.
	public void notifyObservers();// notify observers of changes.

}
