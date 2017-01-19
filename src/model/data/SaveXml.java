package model.data;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.OutputStream;


public class SaveXml extends GeneralLevelSaver {

	
	public SaveXml(Level level,OutputStream outputStream) {
		this.level=level;
		this.outputStream=outputStream;
		
	}
	@Override
	
	public void saveLevel() {

		XMLEncoder encoder = null;
		encoder = new XMLEncoder(new BufferedOutputStream(this.outputStream));

		encoder.writeObject(this.level);
		encoder.close();


	}

}
