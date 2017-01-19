package commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import model.data.Level;

public class CLI  {

	private BufferedReader in;
	private PrintWriter out;
	private Level level;

	public CLI(BufferedReader in, PrintWriter out) throws ClassNotFoundException, FileNotFoundException
	{
		this.in = in;
		this.out = out;
	}

	private Level getLevel() {
		return this.level;
	}

	public void menuCommand(){
		try
		{
			System.out.println("Enter Command:\n>Load file name\n>DisplayLevelCommand\n>Move {up, down, left, right}\n>Save file name\n>Exit");

			String input=in.readLine();
			String[] inputs ;
			Move mov = new Move(this.level);
			//asking for an input if its more than 3 words.
			while(true)
			{
				inputs=input.split("\\s+"); //splits the line to 2 strings
				while(inputs.length>2) {
					System.out.println("Invalid Input.");
					inputs=input.split("\\s+");
				}
				switch (inputs[0].toUpperCase()) //making the first word upper case
				{
				case "LOAD":
					if(inputs.length==1)
					{
						System.out.println("Invalid File Path.try again\n\n");
						break;
					}
					Load load= new Load();
					load.setState(inputs[1]);
					this.level=load.getLevel();
					mov = new Move(this.level);
					break;

				case("DISPLAY"):
					if(getLevel()==null) {
						System.out.println("No level loaded!");
						break;
					}
				Display display=new Display(getLevel());
				display.execute();
				break;
				case("SAVE"):
					if(inputs.length==1)
					{
						System.out.println("Invalid File Path.");
						break;
					}
				Save save=new Save(getLevel());
				save.setState(inputs[1]);
				break;
				case("MOVE"):
					if(inputs.length==1)
					{
						System.out.println("Invalid File Path.");
						break;
					}
				mov.setState(inputs[1]);
				this.level=mov.getLevel();
				break;

				case("EXIT"):
				{
					Exit exit= new Exit();
					exit.execute();
				}
				default: System.out.println("invalid Input");

				}
				input= in.readLine();

			}

		}

		catch (IOException e) {
			e.printStackTrace();
		}


	}

}