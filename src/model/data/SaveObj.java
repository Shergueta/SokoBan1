package model.data;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SaveObj extends GeneralLevelSaver {


	public SaveObj(Level level,OutputStream outputStream) {
		this.outputStream=outputStream;
		this.level=level;
	}
	@Override
	public void saveLevel() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(outputStream);
			out.writeObject(level);
			out.close();
		}catch(IOException i) {
			i.printStackTrace();
		}
	}


}
