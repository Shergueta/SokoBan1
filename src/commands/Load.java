package commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import model.data.Level;
import model.policy.MySokobanPolicy;



public class Load extends ConcreteCommand{

	private String type;
	private InputStream is;
	private Level level;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public void execute() {
		LoadFile loadFile= new LoadFile(is,type);
		loadFile.action();
		this.level=loadFile.getLevel();
		this.level.setPolicy(new MySokobanPolicy());
	}

	@Override
	public void setState(String fileName) {
		this.type= fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
		try {
			this.is = new FileInputStream(fileName);
			execute();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}


