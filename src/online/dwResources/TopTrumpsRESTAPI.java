
package online.dwResources;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import commandline.Player;
import commandline.TTModel;
import commandline.TTController;
import commandline.TTView;

import online.configuration.TopTrumpsJSONConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Path("/toptrumps") // Resources specified here should be hosted at http://localhost:7777/toptrumps
@Produces(MediaType.APPLICATION_JSON) // This resource returns JSON content
@Consumes(MediaType.APPLICATION_JSON) // This resource can take JSON content as input
/**
 * This is a Dropwizard Resource that specifies what to provide when a user
 * requests a particular URL. In this case, the URLs are associated to the
 * different REST API methods that you will need to expose the game commands
 * to the Web page.
 *
 * Below are provided some sample methods that illustrate how to create
 * REST API methods in Dropwizard. You will need to replace these with
 * methods that allow a TopTrumps game to be controled from a Web page.
 */

public class TopTrumpsRESTAPI {

	/**
	 * A Jackson Object writer. It allows us to turn Java objects
	 * into JSON strings easily.
	 */
	ObjectWriter oWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
	TTModel model;
	TTController controller;
	TTView view;

	/**
	 * Contructor method for the REST API. This is called first. It provides
	 * a TopTrumpsJSONConfiguration from which you can get the location of
	 * the deck file and the number of AI players.
	 *
	 * @param conf
	 */

	public TopTrumpsRESTAPI(TopTrumpsJSONConfiguration conf) {

		model = new TTModel();
		view = new TTView();
		controller = new TTController(model, view);

		// ----------------------------------------------------
		// Add relevant initalization here
		// ----------------------------------------------------
	}

	@GET
	@Path("/startGame")

	public void startGame() throws IOException, SQLException {

		controller.startGame(true);

	}

	@GET
	@Path("/attributes")

	public ArrayList<String> getAttributes() throws IOException {

		ArrayList<String> player1 = new ArrayList<String>();

		int p1size = model.getActivePlayers().get(0).getGeo();
		String p1geo = oWriter.writeValueAsString(p1size);
		player1.add(p1geo);

		int p1Duration = model.getActivePlayers().get(0).getDur();
		String p1Dur = oWriter.writeValueAsString(p1Duration);
		player1.add(p1Dur);

		int p1Population = model.getActivePlayers().get(0).getPop();
		String p1Pop = oWriter.writeValueAsString(p1Population);
		player1.add(p1Pop);

		int p1Antiquity = model.getActivePlayers().get(0).getAnt();
		String p1Age = oWriter.writeValueAsString(p1Antiquity);
		player1.add(p1Age);

		int p1Cool = model.getActivePlayers().get(0).getCool();
		String p1Coolness = oWriter.writeValueAsString(p1Cool);
		player1.add(p1Coolness);

		String p1Name = model.getActivePlayers().get(0).getCardName();
		String p1name = oWriter.writeValueAsString(p1Name);
		player1.add(p1name);

		return player1;

	}

	@GET
	@Path("/player2")

	public ArrayList<String> player2() throws IOException {

		ArrayList<String> player2 = new ArrayList<String>();

		int p2size = model.getActivePlayers().get(1).getGeo();
		String p2geo = oWriter.writeValueAsString(p2size);
		player2.add(p2geo);

		int p2Duratiuon = model.getActivePlayers().get(1).getDur();
		String p2Dur = oWriter.writeValueAsString(p2Duratiuon);
		player2.add(p2Dur);

		int p2Population = model.getActivePlayers().get(1).getPop();
		String p2Pop = oWriter.writeValueAsString(p2Population);
		player2.add(p2Pop);

		int p2Antiquity = model.getActivePlayers().get(1).getAnt();
		String p2Age = oWriter.writeValueAsString(p2Antiquity);
		player2.add(p2Age);

		int p2Cool = model.getActivePlayers().get(1).getCool();
		String p2Coolness = oWriter.writeValueAsString(p2Cool);
		player2.add(p2Coolness);

		String p2Name = model.getActivePlayers().get(1).getCardName();
		String p2name = oWriter.writeValueAsString(p2Name);
		player2.add(p2name);

		return player2;

	}

	@GET
	@Path("/player3")

	public ArrayList<String> player3() throws IOException {

		ArrayList<String> player3 = new ArrayList<String>();

		int p3size = model.getActivePlayers().get(2).getGeo();
		String p3geo = oWriter.writeValueAsString(p3size);
		player3.add(p3geo);

		int p3Dur = model.getActivePlayers().get(2).getDur();
		String p3Duration = oWriter.writeValueAsString(p3Dur);
		player3.add(p3Duration);

		int p3Pop = model.getActivePlayers().get(2).getPop();
		String p3Population = oWriter.writeValueAsString(p3Pop);
		player3.add(p3Population);

		int p3Antiquity = model.getActivePlayers().get(2).getAnt();
		String p3Age = oWriter.writeValueAsString(p3Antiquity);
		player3.add(p3Age);

		int p3Cool = model.getActivePlayers().get(2).getCool();
		String p3Coolness = oWriter.writeValueAsString(p3Cool);
		player3.add(p3Coolness);

		String p3Name = model.getActivePlayers().get(2).getCardName();
		String p3name = oWriter.writeValueAsString(p3Name);
		player3.add(p3name);

		return player3;

	}

	@GET
	@Path("/player4")

	public ArrayList<String> player4() throws IOException {

		ArrayList<String> player4 = new ArrayList<String>();

		int p4size = model.getActivePlayers().get(3).getGeo();
		String p4geo = oWriter.writeValueAsString(p4size);
		player4.add(p4geo);

		int p4Duration = model.getActivePlayers().get(3).getDur();
		String p4Dur = oWriter.writeValueAsString(p4Duration);
		player4.add(p4Dur);

		int p4Population = model.getActivePlayers().get(3).getPop();
		String p4Pop = oWriter.writeValueAsString(p4Population);
		player4.add(p4Pop);

		int p4Antiquity = model.getActivePlayers().get(3).getAnt();
		String p4Age = oWriter.writeValueAsString(p4Antiquity);
		player4.add(p4Age);

		int p4Cool = model.getActivePlayers().get(3).getCool();
		String p4Coolness = oWriter.writeValueAsString(p4Cool);
		player4.add(p4Coolness);

		String p4Name = model.getActivePlayers().get(3).getCardName();
		String p4name = oWriter.writeValueAsString(p4Name);
		player4.add(p4name);

		return player4;

	}

	@GET
	@Path("/player5")

	public ArrayList<String> player5() throws IOException {

		ArrayList<String> player5 = new ArrayList<String>();

		int p5size = model.getActivePlayers().get(4).getGeo();
		String p5geo = oWriter.writeValueAsString(p5size);
		player5.add(p5geo);

		int p5Duration = model.getActivePlayers().get(4).getDur();
		String p5Dur = oWriter.writeValueAsString(p5Duration);
		player5.add(p5Dur);

		int p5Population = model.getActivePlayers().get(4).getPop();
		String p3Pop = oWriter.writeValueAsString(p5Population);
		player5.add(p3Pop);

		int p5Antiquity = model.getActivePlayers().get(4).getAnt();
		String p5Age = oWriter.writeValueAsString(p5Antiquity);
		player5.add(p5Age);

		int p5Cool = model.getActivePlayers().get(4).getCool();
		String p5Coolness = oWriter.writeValueAsString(p5Cool);
		player5.add(p5Coolness);

		String p5Name = model.getActivePlayers().get(4).getCardName();
		String p5name = oWriter.writeValueAsString(p5Name);
		player5.add(p5name);

		return player5;

	}

	@GET
	@Path("/value")

	public String KeyboardSize() throws IOException, SQLException {

		ArrayList<Player> currentHighest = new ArrayList<Player>();

		model.compareCards(1, model.getActivePlayers());

		for (int j = 0; j < model.getActivePlayers().size(); j++) {
			System.out.println(String.format("%s has %s with size %01d", model.getActivePlayers().get(j).getPlayerName(), model.getActivePlayers().get(j).getCardName(), model.getActivePlayers().get(j).getGeo()));
			if (j == 0) {
				currentHighest.add(0, model.getActivePlayers().get(j));
			} else if (j == 1) {
				currentHighest.add(1, model.getActivePlayers().get(j));
			}

		}

		return String.format(model.getRoundWinner());

	}

	@GET
	@Path("/value1")

	public String KeyboardDur() throws IOException, SQLException {

		ArrayList<Player> currentHighest = new ArrayList<Player>();

		model.compareCards(2, model.getActivePlayers());

		for (int j = 0; j < model.getActivePlayers().size(); j++) {
			System.out.println(String.format("%s has %s with size %01d", model.getActivePlayers().get(j).getPlayerName(), model.getActivePlayers().get(j).getCardName(), model.getActivePlayers().get(j).getDur()));
			if (j == 0) {
				currentHighest.add(0, model.getActivePlayers().get(j));
			} else if (j == 1) {
				currentHighest.add(1, model.getActivePlayers().get(j));
			}

		}

		return String.format(model.getRoundWinner());

	}

	@GET
	@Path("/value2")

	public String KeyboardPop() throws IOException, SQLException {

		ArrayList<Player> currentHighest = new ArrayList<Player>();

		model.compareCards(3, model.getActivePlayers());

		for (int j = 0; j < model.getActivePlayers().size(); j++) {
			System.out.println(String.format("%s has %s with size %01d", model.getActivePlayers().get(j).getPlayerName(), model.getActivePlayers().get(j).getCardName(), model.getActivePlayers().get(j).getPop()));
			if (j == 0) {
				currentHighest.add(0, model.getActivePlayers().get(j));
			} else if (j == 1) {
				currentHighest.add(1, model.getActivePlayers().get(j));
			}

		}

		return String.format(model.getRoundWinner());

	}

	@GET
	@Path("/value3")

	public String KeyboardAnt() throws IOException, SQLException {

		ArrayList<Player> currentHighest = new ArrayList<Player>();

		model.compareCards(4, model.getActivePlayers());

		for (int j = 0; j < model.getActivePlayers().size(); j++) {
			System.out.println(String.format("%s has %s with size %01d", model.getActivePlayers().get(j).getPlayerName(), model.getActivePlayers().get(j).getCardName(), model.getActivePlayers().get(j).getAnt()));
			if (j == 0) {
				currentHighest.add(0, model.getActivePlayers().get(j));
			} else if (j == 1) {
				currentHighest.add(1, model.getActivePlayers().get(j));
			}

		}

		return String.format(model.getRoundWinner());

	}

	@GET
	@Path("/value4")

	public String KeyboardCool() throws IOException, SQLException {

		ArrayList<Player> currentHighest = new ArrayList<Player>();

		model.compareCards(5, model.getActivePlayers());

		for (int j = 0; j < model.getActivePlayers().size(); j++) {
			System.out.println(String.format("%s has %s with size %01d", model.getActivePlayers().get(j).getPlayerName(), model.getActivePlayers().get(j).getCardName(), model.getActivePlayers().get(j).getCool()));
			if (j == 0) {
				currentHighest.add(0, model.getActivePlayers().get(j));
			} else if (j == 1) {
				currentHighest.add(1, model.getActivePlayers().get(j));
			}

		}

		return String.format(model.getRoundWinner());

	}
}


//	@GET
//	@Path("/getOverallStats")
//
//	public ArrayList<Integer> getOverallStats() throws IOException {
//
//		ArrayList<Integer> overalldata = null;
//
//		// overall game data
//
//		overalldata.add(controller.drawspergame());
//		overalldata.add(controller.AIwins());
//		overalldata.add(controller.humanwins());
//		overalldata.add(controller.gettotalofgames());
//		overalldata.add(controller.getlastroundwinner());
//
//		return overalldata;
//
//	}
//
//	@GET
//	@Path("/getLastGameStats")
//
//	public ArrayList<String> LastGameStats() throws IOException {
//
//		ArrayList<String> lastgamedata = new ArrayList<String>();
//
//		// last game data
//
//		int roundsperplayer = controller.roundsperplayer();
//		String roundsplayer = oWriter.writeValueAsString(roundsperplayer);
//		lastgamedata.add(roundsplayer);
//
//		int gamewinner = controller.gamewinner();
//		String winner = oWriter.writeValueAsString(gamewinner);
//		lastgamedata.add(winner);
//
//		int numofdraws = controller.numofdraws();
//		String draws = oWriter.writeValueAsString(numofdraws);
//		lastgamedata.add(draws);
//
//		int longestgame = controller.longestgame();
//		String longest = oWriter.writeValueAsString(longestgame);
//		lastgamedata.add(longest);
//
//		return lastgamedata;
//
//	}
//
//}



