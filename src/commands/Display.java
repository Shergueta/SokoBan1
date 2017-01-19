package commands;

import model.data.Level;

public class Display extends ConcreteCommand {

	Level level;
	public Display(Level level) {
		this.level=level;
	}
	@Override
	public void setState(String s) {
		
	}
	@Override
	public void execute() {
		DisplayReciever dr=new DisplayReciever(this.level);
		dr.action();
		
	}

}
