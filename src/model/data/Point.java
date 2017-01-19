package model.data;

import java.io.Serializable;

public class Point implements Comparable<Object>, Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static final  int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;

	int x;
	int y;

	public Point(Point p)
	{
		x=p.x;
		y=p.y;
	}

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int sizeSquared() {
		return x*x + y*y;
	}

	public void set(Point p) {
		x = p.x;
		y = p.y;
	}
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static int getUp() {
		return UP;
	}

	public static int getDown() {
		return DOWN;
	}

	public static int getLeft() {
		return LEFT;
	}

	public static int getRight() {
		return RIGHT;
	}

	public String toString(){

		return "x="+x+",y="+y;
	}

	public int compareTo(Object o) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		if ( x == ((Point)o).x && y == ((Point)o).y ) return EQUAL;
		if ( sizeSquared() > ((Point)o).sizeSquared()) return  BEFORE;
		return AFTER;
	}

}
