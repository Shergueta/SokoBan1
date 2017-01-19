package model.data;

public class Target extends GeneralObject {

	public Target(Point p) {
		this.p=p;
	}

	int numOfTargets;

	public int getNumOfTargets() {
		return numOfTargets;
	}

	public void setNumOfTargets(int numOfTargets) {
		this.numOfTargets = numOfTargets;
	}


	@Override
	public char getSymbol() {

		return 'o';
	}



}
