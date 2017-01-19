package model.data;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.InputStream;



public class MyXMLLevelLoader extends GeneralLevelLoader {

	public MyXMLLevelLoader(InputStream inputStream) {
		this.inputStream=inputStream;
	}
	public Level loadLevel() {


		XMLDecoder d = new XMLDecoder(new BufferedInputStream(inputStream));
		this.level = (Level) d.readObject();
		d.close();
		return level;




	}

}
