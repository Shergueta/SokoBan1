
package model.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class MyObjectLevelLoader extends GeneralLevelLoader{

	
	public MyObjectLevelLoader(InputStream inputStream) {

		this.inputStream=inputStream;
	
	}
	public Level loadLevel() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(this.inputStream);
			return (Level)objIn.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
