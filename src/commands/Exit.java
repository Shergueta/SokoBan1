package commands;

import model.data.Level;

public class Exit extends ConcreteCommand {

	Level level;
	
	
	@Override
	public void setState(String s) {
		
	}

	@Override
	public void execute() {
		System.exit(0);
	}

}
