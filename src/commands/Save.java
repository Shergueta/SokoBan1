package commands;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import model.data.Level;


public class Save  extends ConcreteCommand{

	Level level;
	OutputStream outputStream;
	String fileType;
	

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

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Save(Level level) {
		this.level=level;
	}

	@Override
	public void execute() {

		SaveFile s= new SaveFile(this.level, this.outputStream, this.fileType);
		s.action();

	}

	@Override
	public void setState(String fileName) {
		this.fileType= fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());

		try {
			this.outputStream = new FileOutputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		execute();
	}
}


