package model.data;

public class Wall extends GeneralObject {

	public Wall(Point p) {

		this.p=p;
	}

	@Override
	public char getSymbol() {

		return '#';
	}


}
