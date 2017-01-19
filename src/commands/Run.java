package commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Run {

	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		CLI cli;
		try {
			cli = new CLI(reader, writer);
			cli.menuCommand();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


}
