package model.data;

import java.io.IOException;
import java.io.OutputStream;

public class SaveTxt extends GeneralLevelSaver {



public SaveTxt(Level level, OutputStream outputStream) {
		this.level=level;
		this.outputStream=outputStream;
}
	@Override
	public void saveLevel() {
		try {
			outputStream.write(level.getLevel().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("dont forget to close the file!");

	}

}
