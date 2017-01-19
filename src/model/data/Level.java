package model.data;

import java.io.Serializable;
import java.util.ArrayList;

import model.policy.Policy;

public class Level implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Box> boxesList;
	private ArrayList<Target> targetsList;
	private ArrayList<Wall> wallsList;
	private ArrayList<Player>playerList;
	private ArrayList<Path> pathList;

	private Policy policy;


	private int numOfBoxes;
	private int numOfTargets;
	private String level;


	public Policy getPolicy() {
		return policy;
	}


	public void setPolicy(Policy policy) {
		this.policy = policy;
	}


	public Level(String level) {

		this.level=level;


		boxesList = new ArrayList<Box>();
		targetsList = new ArrayList<Target>();
		wallsList = new ArrayList<Wall>();
		playerList= new ArrayList<Player>();
		pathList=new ArrayList<Path>();


		int x=0,y=0;
		for(int i=0; i <level.length(); i++) {
			switch( level.charAt(i)) {
			case '\n':
				y++;
				x=0;
				break;
			case ' ':
				pathList.add(new Path(new Point(x++,y)));
				break;
			case '#':
				wallsList.add(new Wall(new Point(x++,y)));
				break;

			case '@':
				boxesList.add(new Box(new Point(x++,y)));
				numOfBoxes++;
				break;
			case 'o':
				targetsList.add(new Target(new Point(x++,y)));
				numOfTargets++;
				break;

			case 'A':
				playerList.add(new Player(new Point(x++,y)));
				break;

			case '$':
				boxesList.add((new Box(new Point(x,y))));
				targetsList.add(new Target(new Point(x++,y)));
				numOfBoxes++;
				numOfTargets++;
				break;
			case '!':
				playerList.add((new Player(new Point(x,y))));
				targetsList.add(new Target(new Point(x++,y)));
				numOfTargets++;
				break;
			default:
			}
		}
		if(numOfBoxes!=numOfTargets)
			System.out.println("the num of boxes isnt equal to num of targets");
	}



	public void printToScreen(){

		System.out.println(level);
	}


	public Point PointAfter(Point dest,String direction)
	{
		switch(direction){
		case "up":
			return new Point(dest.getX(),dest.getY()-1);
		case"down":
			return new Point(dest.getX(),dest.getY()+1);
		case "right":
			return new Point(dest.getX()+1,dest.getY());
		case "left":
			return new Point(dest.getX()-1,dest.getY());
		}
		return null;
	}


	public char getSymbolByPoint(Point dest) {
		boolean target= false;

		for(int i=0;i<targetsList.size();i++)
			if(targetsList.get(i).p.compareTo(dest)==0)
				target=true;
		for(int i=0;i<playerList.size();i++)
			if(playerList.get(i).p.compareTo(dest)==0)
				if(target)
					return '!';
				else
					return 'A';

		for(int i=0;i<boxesList.size();i++)
			if(boxesList.get(i).p.compareTo(dest)==0)
				if(target)
					return '$';
				else
					return '@';

		for(int i=0;i<wallsList.size();i++)
			if(wallsList.get(i).p.compareTo(dest)==0)
				return '#';

		for(int i=0;i<pathList.size();i++)
			if(pathList.get(i).p.compareTo(dest)==0)
				return ' ';

		return 'o';
	}

	public int getPositionInArray(Point dest,char symbol) {
		switch(symbol)
		{
		case 'A':
			for(int i=0;i<this.playerList.size();i++)
				if(this.playerList.get(i).getP().compareTo(dest)==0)
					return i;
		case '#':
			for(int i=0;i<this.wallsList.size();i++)
				if(this.wallsList.get(i).getP().compareTo(dest)==0)
					return i;
		case '@':
			for(int i=0;i<this.boxesList.size();i++)
				if(this.boxesList.get(i).getP().compareTo(dest)==0)
					return i;
		case ' ':
			for(int i=0;i<this.pathList.size();i++)
				if(this.pathList.get(i).getP().compareTo(dest)==0)
					return i;
		case 'o':
			for(int i=0;i<this.targetsList.size();i++)
				if(this.targetsList.get(i).getP().compareTo(dest)==0)
					return i;
		default :
			return -1;
		}
	}

	public ArrayList<Box> getBoxesList() {
		return boxesList;
	}


	public void setBoxesList(ArrayList<Box> boxesList) {
		this.boxesList = boxesList;
	}


	public ArrayList<Target> getTargetsList() {
		return targetsList;
	}


	public void setTargetsList(ArrayList<Target> targetsList) {
		this.targetsList = targetsList;
	}


	public ArrayList<Wall> getWallsList() {
		return wallsList;
	}


	public void setWallsList(ArrayList<Wall> wallsList) {
		this.wallsList = wallsList;
	}


	public ArrayList<Player> getPlayerList() {
		return playerList;
	}


	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}


	public ArrayList<Path> getPathList() {
		return pathList;
	}


	public void setPathList(ArrayList<Path> pathList) {
		this.pathList = pathList;
	}


	public int getNumOfBoxes() {
		return numOfBoxes;
	}


	public void setNumOfBoxes(int numOfBoxes) {
		this.numOfBoxes = numOfBoxes;
	}


	public int getNumOfTargets() {
		return numOfTargets;
	}


	public void setNumOfTargets(int numOfTargets) {
		this.numOfTargets = numOfTargets;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public void updateString() {
		String newString=new String();
		int x=0,y=0;
		for(int i=0;i<this.level.length();i++)
		{
			if(level.charAt(i)!='\n')
				newString+=getSymbolByPoint(new Point(x++,y));
			else
			{
				newString+='\n';
				y++;
				x=0;
			}
		}
		this.level=newString;
	}

}



