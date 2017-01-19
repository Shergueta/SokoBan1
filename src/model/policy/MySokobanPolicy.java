package model.policy;

public class MySokobanPolicy implements Policy{

	public MySokobanPolicy() {
	}
	public boolean passThroughWall(){
		return false;
	}
	public boolean pushBlockedBox() {
		return false;
	}
}
