package commands;

public abstract class ConcreteCommand implements Command {
	String state;
	
	public abstract void execute();
}
