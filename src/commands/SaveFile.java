package commands;

import java.io.OutputStream;
import java.util.HashMap;

import model.data.GeneralLevelSaver;
import model.data.Level;
import model.data.SaveObj;
import model.data.SaveTxt;
import model.data.SaveXml;

public class SaveFile extends Receiver {

	private Level level;
	private OutputStream outputStream;
	private String type;

	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public OutputStream getOutputStream() {
		return outputStream;
	}
	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public SaveFile(Level level,OutputStream outputStream, String type) {

		this.level=level;
		this.outputStream=outputStream;
		this.type=type;

	}
	@Override
	public void action() {

		HashMap<String, GeneralLevelSaver> fileTypes=new HashMap<String, GeneralLevelSaver>();
		fileTypes.put("txt", new SaveTxt(this.level,this.outputStream));
		fileTypes.put("xml", new SaveXml(this.level,this.outputStream));
		fileTypes.put("obj", new SaveObj(this.level,this.outputStream));
		GeneralLevelSaver gls=fileTypes.get(type);
		gls.saveLevel();
	}

}
