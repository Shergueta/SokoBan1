package model.data;

public class Box extends GeneralObject  {

	public Box(Point p) {
		this.p=p;
	}



	@Override
	public char getSymbol() {
		return '@';
	}

}
