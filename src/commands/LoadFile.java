package commands;

import java.io.InputStream;
import java.util.HashMap;
import model.data.GeneralLevelLoader;
import model.data.Level;
import model.data.MyObjectLevelLoader;
import model.data.MyTextLevelLoader;
import model.data.MyXMLLevelLoader;

public class LoadFile extends Receiver{

	private InputStream is;
	private String type;
	private Level level;

	public LoadFile(InputStream is, String type) {
		super();
		this.is = is;
		this.type = type;
	}

	public Level getLevel() {
		return level;
	}


	public void setLevel(Level level) {
		this.level = level;
	}


	@Override
	public void action() {

			HashMap<String, GeneralLevelLoader> fileTypes=	new HashMap<String, GeneralLevelLoader>();

			fileTypes.put("txt", new MyTextLevelLoader(is));
			fileTypes.put("xml", new MyXMLLevelLoader(is));
			fileTypes.put("obj", new MyObjectLevelLoader(is));

			this.level= fileTypes.get(type).loadLevel();
			//System.out.println("+++++++++++++++++");

		}

}
