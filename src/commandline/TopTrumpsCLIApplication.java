package commandline;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Top Trumps command line application
 */
public class TopTrumpsCLIApplication {

	public static void main(String[] args) throws IOException, SQLException {


		boolean writeGameLogsToFile = false; // Should we write game logs to file?
	//	if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection

		// State
		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application

		// Loop until the user wants to exit the game
		while (!userWantsToQuit) {

			// ----------------------------------------------------
			// Add your game logic here based on the requirements
			// ----------------------------------------------------
			System.out.println("\n" + "Please choose whether you would like to view persistent game data = 0, play a new game = 1, or quit = 2");
			Scanner userInput = new Scanner(System.in);
			int userChoice = userInput.nextInt();
			userInput.nextLine();

			if (userChoice == 1) {
				TTModel model = new TTModel();
				TTView view = new TTView();
				TTController controller = new TTController(model, view);
				controller.startGame(writeGameLogsToFile);
			} else if (userChoice == 0) {
				// database entry here to get data
				Database db = new Database();
				db.DB();
				System.out.println(db.getLastGameStats());

			} else if (userChoice == 2) {
				userWantsToQuit=true; // use this when the user wants to exit the game
			}
		}

	}

}