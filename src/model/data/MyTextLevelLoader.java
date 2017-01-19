package model.data;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MyTextLevelLoader extends GeneralLevelLoader {

	public MyTextLevelLoader(InputStream inputStream) {
		this.inputStream=inputStream;
	}


	public Level loadLevel() {
		String line;
		String result=new String();
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
			line=br.readLine();
			while(line!=null)
			{
				result=result+line+"\n";
				line = br.readLine();

			}

		} catch(Exception e){

		};

		level = new Level(result);
		return level;
	}
}

