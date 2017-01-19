package commands;

import model.data.Level;

public class DisplayReciever extends Receiver{


	Level level;
	public DisplayReciever(Level level) {
		this.level=level;
	}
	@Override
	public void action() {
		this.level.printToScreen();
	}

}
