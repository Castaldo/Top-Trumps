import java.io.IOException;
import java.sql.SQLException;

import commandline.TopTrumpsCLIApplication;
import online.TopTrumpsOnlineApplication;

public class TopTrumps {

	/**
	 * This is the main class for the TopTrumps Application
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void main(String[] args) {
		
		System.out.println("--------------------");
		System.out.println("--- Top Trumps   ---");
		System.out.println("--------------------");
		
		// command line switches
		boolean onlineMode = true;
		boolean commandLineMode = false;
		boolean printTestLog = false;
		
		// check the command line for what switches are active
		for (String arg : args) {	
			if (arg.equalsIgnoreCase("-t")) printTestLog=false;
			if (arg.equalsIgnoreCase("-c")) commandLineMode=false;
			if (arg.equalsIgnoreCase("-o")) onlineMode=false;	
		}
		
		// We cannot run online and command line mode simultaneously
		if (onlineMode && commandLineMode) {
			System.out.println("ERROR: Both online and command line mode selected, select one or the other!");
			System.exit(0);
		}
		
		// Start the appropriate application
		if (onlineMode) {
			// Start the online application
			String[] commandArgs = {"server", "TopTrumps.json"};
			TopTrumpsOnlineApplication.main(commandArgs);
		} else if (commandLineMode) {
			// Start the command line application
			String[] commandArgs = {String.valueOf(printTestLog)};
			try {
				TopTrumpsCLIApplication.main(commandArgs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}