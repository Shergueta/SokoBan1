package commands;
import model.data.Box;
import model.data.Level;
import model.data.Path;
import model.data.Player;
import model.data.Point;

public class MoveReciever extends Receiver{

	public String direction;
	public Level level;



	public MoveReciever(String direction,Level level){
		this.direction=direction;
		this.level=level;
	}
	public Point getSourcePoint(){//מחזיר את הנקודה שהשחקן עליה

		return level.getPlayerList().get(0).getP();

	}

	public Point getDestinationPoint()	{//מחזיר את נקודת היעד הרצויה
		Point destPoint;
		int x;
		int y;
		switch (this.direction){
		case "up":
			y=this.getSourcePoint().getY();
			y--;
			destPoint= new Point(getSourcePoint().getX(),y);
			return destPoint;

		case "down":
			y=this.getSourcePoint().getY();
			y++;
			destPoint= new Point(getSourcePoint().getX(),y);
			return destPoint;

		case "right":

			x=this.getSourcePoint().getX();
			x++;
			destPoint= new Point(x,this.getSourcePoint().getY());
			return destPoint;

		case "left":
			x=this.getSourcePoint().getX();
			x--;
			destPoint= new Point(x,this.getSourcePoint().getY());
			return destPoint;
		}
		return null;
	}

	/*public boolean checkBoxMove(Point courrentLocation,Point newDest){
		if(level.getAtLocation(newDest)==Level.getBox() || level.getAtLocation(newDest)==Level.getWall()||level.getAtLocation(newDest)==Level.getBoxntarget())
			return level.getPolicy().pushBlockedBox();
		return true;//הפונציה בודקת אם הקופסא יכולה לזוז... תוכל לזוז אם אין קיר או קופסא לידה

	}*/

	public boolean checkBoxMove(Point newDest){
		char newDestSymbol = level.getSymbolByPoint(newDest);
		if(newDestSymbol=='$'||newDestSymbol=='@'||newDestSymbol=='!'||newDestSymbol=='A'||newDestSymbol=='#')
			return level.getPolicy().pushBlockedBox();
		return true;
	}

	public boolean checkMove(Point source,Point dest,String direction){//הפונקציה בודקת אם הצעד אפשרי
		char destSymbol = level.getSymbolByPoint(dest);
		//char sourceSymbol= level.getSymbolByPoint(source);
		if(destSymbol=='#')
			return this.level.getPolicy().passThroughWall();
		if((destSymbol=='@')||(destSymbol=='$'))
		{
			switch(direction){
			case "up":
				return checkBoxMove(new Point(dest.getX(),dest.getY()-1));
			case "down":
				return checkBoxMove(new Point(dest.getX(),dest.getY()+1));
			case "right":
				return checkBoxMove(new Point(dest.getX()+1,dest.getY()));
			case "left":
				return checkBoxMove(new Point(dest.getX()-1,dest.getY()));
			}

		}
		if(destSymbol=='!'||destSymbol=='A')
			return false;

		return true;

	}


	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction=direction;
	}
	public Level getLevel() {
		return this.level;
	}

	public void setLevel(Level level) {
		this.level=level;
	}

	//it was here..

	@Override
	public void action() {

		boolean check;

		check=checkMove(this.level.getPlayerList().get(0).getP(),getDestinationPoint(),this.direction);
		if (check)
			moveItem(this.level.getPlayerList().get(0).getP(),this.direction, getDestinationPoint());

	}
	public void  moveItem(Point currentPoint, String direction,Point newPoint) {

		Point pointAfter = this.level.PointAfter(newPoint, direction);
		char pointAfterChar = this.level.getSymbolByPoint(pointAfter);
		char currentChar = level.getSymbolByPoint(currentPoint);
		char newChar = level.getSymbolByPoint(newPoint);

		switch(currentChar){
		case '!':
			this.level.getPlayerList().remove(level.getPositionInArray(currentPoint, 'A'));
			break;
		case 'A':
			this.level.getPlayerList().remove(level.getPositionInArray(currentPoint, 'A'));
			this.level.getPathList().add(new Path(currentPoint));
			break;
		}
		switch(newChar){
		case '@':
		case '$':
			this.level.getBoxesList().remove(level.getPositionInArray(newPoint, '@'));
			this.level.getPlayerList().add(new Player(newPoint));
			switch(pointAfterChar)
			{
			case 'o':
				this.level.getBoxesList().add(new Box(pointAfter));
				break;
			case ' ':
				this.level.getPathList().remove(level.getPositionInArray(pointAfter, ' '));
				this.level.getBoxesList().add(new Box(pointAfter));
				break;
			}
			break;
		case ' ':
			this.level.getPlayerList().add(new Player(newPoint));
			this.level.getPathList().remove(level.getPositionInArray(newPoint, ' '));
			break;
		case 'o':
			this.level.getPlayerList().add(new Player(newPoint));
		}
		this.level.updateString();
}}



/*public boolean checkMove(Point source,Point dest){//הפונקציה בודקת אם הצעד אפשרי
boolean check=true;
if(level.getAtLocation(dest)==Level.getWall())
	check= level.getPolicy().passThroughWall();
if(level.getAtLocation(dest)==Level.getBox())//אם הדסטניישן הוא קופסא
{
	switch(this.direction){
	case "up":
		check=checkBoxMove(dest,new Point(dest.getX(),dest.getY()-1));
		break;
	case "down":
		check=checkBoxMove(dest,new Point(dest.getX(),dest.getY()+1));
		break;
	case "right":
		check=checkBoxMove(dest,new Point(dest.getX()+1,dest.getY()));
		break;
	case "left":
		check=checkBoxMove(dest,new Point(dest.getX()-1,dest.getY()));
		break;
	}
}

if((level.getAtLocation(dest))==Level.getBoxntarget())//אם הדסטניישן הוא דולר
{//בודק את המקרה שיש קופסא אחריי הדולר
	Point after= level.PointAfter(dest, this.direction);
	int pos=level.findPointInList(after, level.getBoxesList());
	if(pos>=0)
		check=level.getPolicy().pushBlockedBox();
	else
	{
		pos=level.findPointInList(after, level.getWallsList());
		if(pos>=0)
			check=level.getPolicy().pushBlockedBox();
	}
}
return check;
}*/
