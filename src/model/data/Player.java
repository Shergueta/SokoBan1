package model.data;

import java.io.Serializable;

public class Player extends GeneralObject implements Serializable{

	private static final long serialVersionUID = 1L;


	public Player(Point p) {
		this.p=p;

	}

	@Override
	public char getSymbol() {
		return 'A';
	}

}
