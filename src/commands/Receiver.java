package commands;

public abstract class Receiver {

	
	String state;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public abstract void action();

}
