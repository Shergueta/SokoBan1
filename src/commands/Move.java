package commands;

import model.data.Level;

public class Move extends ConcreteCommand {

	private String direction;
	private Level level;

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	public Move(Level lvl){
		setLevel(lvl);
	}

	public void execute() {
		MoveReciever mr= new MoveReciever(this.direction,this.level);
		mr.action();
	}

	@Override
	public void setState(String direction) {

		this.direction=direction;
		execute();

	}



}
