package model;

import java.util.Observable;
import java.util.Observer;

public class MyModel extends Observable implements Model {

	@Override
	public Observer o() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteObserver(Observer o) {
		// TODO Auto-generated method stub

	}

	/*@Override
	public void notifyObservers() {

		for(Observer o : observersList)
			o.update();
				
	}*/
}
	
