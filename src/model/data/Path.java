package model.data;

public class Path extends GeneralObject{

	public Path(Point p) {
		this.p=p;
	}

	@Override
	public char getSymbol() {

		return ' ';
	}


}
