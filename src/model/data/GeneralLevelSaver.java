package model.data;

import java.io.OutputStream;

public abstract class GeneralLevelSaver implements LevelSaver {

	Level level;
	OutputStream outputStream;
	@Override
	public abstract void saveLevel();

}
