package model.data;

import java.io.InputStream;
 

public  abstract class GeneralLevelLoader implements LevelLoader {

	Level level;
	InputStream inputStream;
	public abstract Level loadLevel();
	
		

}
