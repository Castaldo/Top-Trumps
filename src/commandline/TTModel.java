package commandline;

import java.sql.SQLException;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.lang.Math;

public class TTModel {
    // class variable initialisation
    private ArrayList<Card> Deck = new ArrayList<>();		// initial deck
    private ArrayList<Player> playerList = new ArrayList<>();		// player list
    private int numOfPlayers = 0;									// number of currently active players // stores player ID as game winner
    private boolean gameActive = true;								// game state

    public int lastRoundWinner;
    public int numOfDraws;
    public int roundsInGame;

    public int player1roundWins;
    public int player2roundWins;
    public int player3roundWins;
    public int player4roundWins;
    public int player5roundWins;

    public int gameWinner;
    public int computerWins;

    // constructor for model, two arraylists for storing initial deck
    // second arraylist contains the list of player objects
    public TTModel() {
        this.Deck = Deck;					// array list of initial pre-shuffled card objects
        this.playerList = playerList;		// arraylist of player objects

    }

    // cards are read from scanner and entered into the deck
    public void readCards() throws FileNotFoundException {

        File text = new File("/Users/chris/Downloads/Trumps 3/Empires.txt");				// read from text file
        Scanner civilizations = new Scanner(text);

        while (civilizations.hasNextLine()) {

            String NameFirst = civilizations.next();		// first name of card
            String NameLast = civilizations.next();			// last name of card
            int Size = civilizations.nextInt();
            int Duration = civilizations.nextInt();
            int Population = civilizations.nextInt();
            int Antiquity = civilizations.nextInt();
            int CoolFactor = civilizations.nextInt();

            Deck.add(new Card(NameFirst, NameLast, Size, Duration, Population, Antiquity, CoolFactor)); // adds each card incrementally
        }		
        																								  // to deck arraylist
        civilizations.close();
    }

    // method for printing completed deck for testing
    public String printCompleteDeck() {
        if (Deck.isEmpty() == false) {		// only runs if deck has contents
            String completedDeck = "";
            for(Card c : Deck) {
                completedDeck +=  c.toString() + "\n";
            }
            return completedDeck;
        }
        return null;	// otherwise returns null
    }

    /*
        This method creates the player objects for the game. Always creates 5 players + 1 communal pile
        Players can be set to have false activity later, which will allow number of player selection
        for the online view
    */
    public void createPlayers() {
        Player One = new Player("Player 1", true, 1);
        Player Two = new Player("Player 2", true, 2);
        Player Three = new Player("Player 3", true, 3);
        Player Four = new Player("Player 4", true, 4);
        Player Five = new Player("Player 5", true, 5);
        Player Six = new Player("Communal Pile", false, 0);		// communal pile is always set to false
        playerList.add(Six);									// communal pile added at position 0 of player list
        playerList.add(One);									// then other players added in positions 1 to 5
        playerList.add(Two);
        playerList.add(Three);
        playerList.add(Four);
        playerList.add(Five);
    }

    public int getNumOfDraws() { return numOfDraws; }

    public int getRoundsInGame() { return roundsInGame; }

    public int get1rounds() { return player1roundWins; }

    public int get2rounds() { return player2roundWins; }

    public int get3rounds() { return player3roundWins; }

    public int get4rounds() { return player4roundWins; }

    public int get5rounds() { return player5roundWins; }

    public int getGameWinner() { return gameWinner; }

    public int getComputerwins() { return computerWins; }

    // Shuffles the arraylist containing the card objects, this create a randomised deck within the same arraylist

    public  void shuffleDeck() {
        // shuffle deck using shuffle method from collections utility
        Collections.shuffle(Deck);
    }

    public String printShuffledDeck() {
        if (Deck.isEmpty() == false) {		// only runs if deck has contents
            String shuffledDeck = "";
            for(Card c : Deck) {
                shuffledDeck +=  c.toString() + "\n";
            }
            return shuffledDeck;
        }
        return null;	// otherwise returns null
    }

    public void setNumPlayers(int numPlayers) {
        for (int i = 5; i > numPlayers; i--) {
            playerList.get(i).setPlayerActivity(false);
        }
    }

    // find number of active players and sets class variable for initial shuffle
    public void numOfActive() {
        for (int i = 5; i > 1; i--) {							// loop decrements from maximum number of players
            if (playerList.get(i).isPlayerActive() == true) {	// if during intiailisation player has been set true
                this.numOfPlayers = numOfPlayers + 1;			// increases the active player count by one
            }
        }
    }

    // method deals cards dependent on the number of active players
    public void dealCards() {
        int DR = Deck.size() / (numOfPlayers + 1);			// DR is dealer rounds - how many times every player is dealt a card
        int rmndr = Deck.size() % (numOfPlayers + 1);		// remainder is used if there is an uneven distribution to deal additional cards
        int deckIndex = 0;									// deck index increments every time a card is dealt
        int LDP = 0;										// LDP is the last dealt player, in case remainder means additional cards need dealt
        // ensure the current dealt player is next in line
        // first for loop runs through the dealer rounds
        for (int i = 0; i < DR; i++) {
            //second loop deals a card to every player as part of these rounds
            for (int j = 1; j <= (numOfPlayers + 1); j++) {
                playerList.get(j).hand.add(Deck.get(deckIndex));		// adds card to player objects hand arraylist
                deckIndex++;											// increments deck to next card
                LDP = j;												// sets this player to be last one dealt too
            }
        }

        if (rmndr != 0) {							// only runs in cases where remainder is not equal to 0, in the case of 5 players and
            for (int k = 0; k < rmndr; k++)			// 40 cards this only occurs once, when there are 3 players
                if (LDP == numOfPlayers) {						// **** incorrect ****** needs to be based on numOfPLayers
                    LDP = 1;
                }
            playerList.get(LDP + 1).hand.add(Deck.get(deckIndex));
        }

    }

    // get top card returns a read out of the players next card to provide visibility for attribute selection
    public String getTopCard(int p) {
        if (playerList.get(p).hand.isEmpty() == false) {
            String s = null;
            s = playerList.get(p).hand.get(0).toString();
            return s;
        }
        return null;
    }

    // this method gets active players and adds them to an arraylist which is returned
    public ArrayList<Player> getActivePlayers() {

        ArrayList<Player> activePlayers = new ArrayList<Player>();

        for (int i = 1; i <= 5; i++) {
            boolean addToList;
            addToList = playerList.get(i).isPlayerActive();			// if player status is true, sets boolean to true
            if (addToList == true) {								// in this case the player is then added to the active player arraylist
                activePlayers.add(playerList.get(i));
            }
        }
        return activePlayers;										// once fully constructed
    }
    // returns the size of the active players array
    public int getActivePlayerNum(ArrayList<Player> aP) {
        return aP.size();
    }
    // gets the players hand as a String to output for testing
    public String getPlayerHand(ArrayList<Player> aP, int p) {
        return aP.get(p).printHand();
    }
    /*
     *  The compare cards method finds the player with the highest value for the chosen category, a
     *  if two players have the same highest value then this results in a draw
     */
    public int compareCards(int a, ArrayList<Player> aP) throws SQLException {
        int winner = 0;		// int for storing winner
        int draw = 0;		// int which marks draw status, 1 for true, 0 for false
        ArrayList<Player> activePlayers = aP;						// the players currently active in the game
        ArrayList<Player> currentHighest = new ArrayList<Player>();	// array list for storing
        roundsInGame++;
        /*
         * The if loops check for the highest player by iterating through the active player arrayList and finding the two highest values
         * this allows us to check for a draw between the top two player card values
         * currently this outputs each players top card which should be part of the view
         * attempts to change this have affected the game logic significantly
         */
        if (a == 1) {
            for (int j = 0; j < activePlayers.size(); j++) {
                System.out.println(String.format("%s has %s with size %01d", activePlayers.get(j).getPlayerName(), activePlayers.get(j).getCardName(), activePlayers.get(j).getGeo()));
                if (j == 0) {
                    currentHighest.add(0, activePlayers.get(j));		// adds the first two players to avoid out of bounds loops
                } else if (j == 1) {
                    currentHighest.add(1, activePlayers.get(j));
                }

                // if current player being checked
                if (activePlayers.get(j).getGeo() >= currentHighest.get(0).getGeo()) {
                    currentHighest.add(1, currentHighest.get(0));
                    currentHighest.add(0, activePlayers.get(j));
                }

            }
            // checks for draw otherwise outputs winner and card
            if (currentHighest.get(0).getGeo() == currentHighest.get(1).getGeo()) {
                System.out.println("There is a draw and the cards will be added to the communal pile");
                draw = 1;
                numOfDraws++;

            } else {
                System.out.println(String.format("%s has the highest card for this round, with a value of %01d", currentHighest.get(0).getPlayerName(), currentHighest.get(0).getGeo()));
                draw = 0;
            }
            // sets communal pile as current highest if draw to pass cards correctly
            if (draw == 1) {
                currentHighest.add(0, playerList.get(0));
            } else {
                winner = currentHighest.get(0).getPlayerNum();	// or if winner is defined as currenthighest
            }

        }

        if (a == 2) {
            for (int j = 0; j < activePlayers.size(); j++) {
                System.out.println(String.format("%s has %s with duration %01d", activePlayers.get(j).getPlayerName(), activePlayers.get(j).getCardName(), activePlayers.get(j).getDur()));

                if (j == 0) {
                    currentHighest.add(0, activePlayers.get(j));
                } else if (j == 1) {
                    currentHighest.add(1, activePlayers.get(j));
                }


                if (activePlayers.get(j).getDur() >= currentHighest.get(0).getDur()) {
                    currentHighest.add(1, currentHighest.get(0));
                    currentHighest.add(0, activePlayers.get(j));
                }

            }

            if (currentHighest.get(0).getDur() == currentHighest.get(1).getDur()) {
                System.out.println("There is a draw and the cards will be added to the communal pile");
                draw = 1;
                numOfDraws++;

            } else {
                System.out.println(String.format("%s has the highest card for this round, with a value of %01d", currentHighest.get(0).getPlayerName(), currentHighest.get(0).getDur()));
                draw = 0;
            }

            if (draw == 1) {
                currentHighest.add(0, playerList.get(0));
            } else {
                winner = currentHighest.get(0).getPlayerNum();
            }

        }

        if (a == 3) {
            for (int j = 0; j < activePlayers.size(); j++) {
                System.out.println(String.format("%s has %s with population %01d", activePlayers.get(j).getPlayerName(), activePlayers.get(j).getCardName(), activePlayers.get(j).getPop()));
                if (j == 0) {
                    currentHighest.add(0, activePlayers.get(j));
                } else if (j == 1) {
                    currentHighest.add(1, activePlayers.get(j));
                }


                if (activePlayers.get(j).getPop() >= currentHighest.get(0).getPop()) {
                    currentHighest.add(1, currentHighest.get(0));
                    currentHighest.add(0, activePlayers.get(j));
                }

            }

            if (currentHighest.get(0).getPop() == currentHighest.get(1).getPop()) {
                System.out.println("There is a draw and the cards will be added to the communal pile");
                draw = 1;
                numOfDraws++;

            } else {
                System.out.println(String.format("%s has the highest card for this round, with a value of %01d", currentHighest.get(0).getPlayerName(), currentHighest.get(0).getPop()));
                draw = 0;
            }

            if (draw == 1) {
                currentHighest.add(0, playerList.get(0));
            } else {
                winner = currentHighest.get(0).getPlayerNum();
            }


        }

        if (a == 4) {
            for (int j = 0; j < activePlayers.size(); j++) {
                System.out.println(String.format("%s has %s with antiquity %01d", activePlayers.get(j).getPlayerName(), activePlayers.get(j).getCardName(), activePlayers.get(j).getAnt()));
                if (j == 0) {
                    currentHighest.add(0, activePlayers.get(j));
                } else if (j == 1) {
                    currentHighest.add(1, activePlayers.get(j));
                }


                if (activePlayers.get(j).getAnt() >= currentHighest.get(0).getAnt()) {
                    currentHighest.add(1, currentHighest.get(0));
                    currentHighest.add(0, activePlayers.get(j));
                }

            }

            if (currentHighest.get(0).getAnt() == currentHighest.get(1).getAnt()) {
                System.out.println("There is a draw and the cards will be added to the communal pile");
                draw = 1;
            } else {
                System.out.println(String.format("%s has the highest card for this round, with a value of %01d", currentHighest.get(0).getPlayerName(), currentHighest.get(0).getAnt()));
                draw = 0;
                numOfDraws++;

            }

            if (draw == 1) {
                currentHighest.add(0, playerList.get(0));
            } else {
                winner = currentHighest.get(0).getPlayerNum();
            }


        }

        if (a == 5) {
            for (int j = 0; j < activePlayers.size(); j++) {
                System.out.println(String.format("%s has %s with cool factor %01d", activePlayers.get(j).getPlayerName(), activePlayers.get(j).getCardName(), activePlayers.get(j).getCool()));
                if (j == 0) {
                    currentHighest.add(0, activePlayers.get(j));
                } else if (j == 1) {
                    currentHighest.add(1, activePlayers.get(j));
                }


                if (activePlayers.get(j).getCool() >= currentHighest.get(0).getCool()) {
                    currentHighest.add(1, currentHighest.get(0));
                    currentHighest.add(0, activePlayers.get(j));
                }

            }

            if (currentHighest.get(0).getCool() == currentHighest.get(1).getCool()) {
                System.out.println("There is a draw and the cards will be added to the communal pile");
                draw = 1;
                numOfDraws++;

            } else {
                System.out.println(String.format("\n %s has the highest card for this round, with a value of %01d", currentHighest.get(0).getPlayerName(), currentHighest.get(0).getCool()));
                draw = 0;
            }

            if (draw == 1) {
                currentHighest.add(0, playerList.get(0));
            } else {
                winner = currentHighest.get(0).getPlayerNum();
            }

        }

        if (lastRoundWinner == 1) {player1roundWins++;}

        if (lastRoundWinner == 2) {player2roundWins++; }

        if (lastRoundWinner == 3) {player3roundWins++; }

        if (lastRoundWinner == 4) {player4roundWins++; }

        if (lastRoundWinner == 5) { player5roundWins++; }

        addWinnerCards(winner, draw, activePlayers);
        lastRoundWinner = winner;

        if (lastRoundWinner != 1)
            computerWins++;

        roundsInGame++;
        return winner;
    }

	/*
		add winner cards takes winner, draw and the active players list as its parameters
		using these it distributes the cards either to the winning players hand
		or in the case of a draw to the communal pile for redistribution in the next
		player won round
	*/

    public void addWinnerCards(int w, int d, ArrayList<Player> activePlayers) {

        int numberActive = activePlayers.size();		// size of current player list initialised for ease of use
        loseCondition(activePlayers);

        if (d == 0) {
            int numComPile = playerList.get(0).hand.size();		// gets size of current communal pile hand
            while (numComPile > 0) {									// runs through every index of communal pile hand while containing cards
                if (playerList.get(0).hand.isEmpty() == false) {		// only runs when pile has at least one card left
                    playerList.get(w).addToHand(playerList.get(0).getTopCard()); // adds to winners hand
                    playerList.get(0).removeTopCard();							 // and removes from communal pile
                }
                numComPile = playerList.get(0).hand.size();
            }
        }


        if (d == 1) {
            numOfDraws++;
            numberActive = activePlayers.size();									// first if loop runs only if draw
            for (int i = 0; i < numberActive; i++) {								// runs for ever currently active player
                playerList.get(0).addToHand(activePlayers.get(i).getTopCard());
                activePlayers.get(i).removeTopCard();								// removes first card from active player
                loseCondition(activePlayers);
                numberActive = activePlayers.size();
            }																		// and adds to communal pile player object
        } else {
            numberActive = activePlayers.size();
            for (int j = 0; j < numberActive; j++) {								// if not a draw
                playerList.get(w).addToHand(activePlayers.get(j).getTopCard());		// every player, including winners cards are added at end of list
                activePlayers.get(j).removeTopCard();								// and the top card is removed from each player
                loseCondition(activePlayers);
                numberActive = activePlayers.size();
            }

        }
    }

    public int aiChoice(int p, ArrayList<Player> activePlayers) {

        int cardGeo = playerList.get(p).getGeo();				// intialised variables with the card attributes
        int cardDur = playerList.get(p).getDur();
        int cardPop = playerList.get(p).getPop();
        int cardAnt = playerList.get(p).getAnt();
        int cardCool = playerList.get(p).getAnt();

        int biggest = Math.max(cardGeo,Math.max(cardDur,Math.max(cardPop,Math.max(cardAnt,cardCool))));	// returns highest value card
        // the next series of if conditionals checks which value is highest and returns, prioritising 1 to 5
        if (cardGeo == biggest) {
            System.out.println("Player " + p + " has chosen Geographic size" + "\n");
            return 1;
        } else if (cardDur == biggest) {
            System.out.println("Player " + p + " has chosen Duration" + "\n");
            return 2;
        } else if (cardPop == biggest) {
            System.out.println("Player " + p + " has chosen Population" + "\n");
            return 3;
        } else if (cardAnt == biggest) {
            System.out.println("Player " + p + " has chosen Antiquity" + "\n");
            return 4;
        } else {
            System.out.println("Player " + p + " has chosen Cool Factor" + "\n");
            return 5;
        }

    }

    // returns game active boolean state
    public boolean isGameActive() {
        return gameActive;
    }

    // checks each active player, and whether they are still active in the game
    public void loseCondition(ArrayList<Player> activePlayers) {
        for (int i = 0; i < activePlayers.size(); i++) {
            if (activePlayers.get(i).hand.isEmpty() == true) {		// if a players hand arraylist is empty
                activePlayers.get(i).setPlayerActivity(false);		// their active state is set to false
                System.out.println(activePlayers.get(i).getPlayerName() + " has been eliminated!");
                activePlayers.remove(i);							// and the player is removed from the active players list

            }
        }

    }

    // this method finds the overall game winner
    public boolean findWinner (ArrayList<Player> activePlayers) {
        for (int i = 0; i < activePlayers.size(); i ++) {
            if (activePlayers.get(i).hand.size() == 40) {			// if the players hand holds all 40 cards
                gameWinner = activePlayers.get(i).getPlayerNum();	// they are set as the game winner through their player number
            }
        }

        if (activePlayers.size() == 1) {
            gameWinner = activePlayers.get(0).getPlayerNum();
        }

        if (gameWinner != 0) {		// and if there is a game winner
            gameActive = false;		// game state is set to false
        }

        return gameActive;			// returns boolean value for whether game is still active or not
    }

    // returns integer value for the game winner
    public int getWinner() {
        return gameWinner;		// returns game winners playernumber
    }

    // method for checking whether a specific player is active
    public boolean isPlayerActive(int p) {
        if (playerList.get(p).isPlayerActive() == true) {
            return true;
        } else {
            return false;
        }
    }

    // method for finding highest player number still active in the game, used in conditional loop in controller
    public int getHighestActivePlayer() {
        int biggest = 0;

        for (int i = 1; i < playerList.size(); i++){
            if (playerList.get(i).isPlayerActive() == true) {
                biggest = playerList.get(i).getPlayerNum();
            }
        }

        return biggest;
    }
    // gets player name string from player object in player list array
    public String getPlayerName(int p) {
        return playerList.get(p).getPlayerName();
    }
    // gets playernumber int from last round winner class variable
    public int getLastRoundWinner(ArrayList<Player> activePlayers) {
        return playerList.get(lastRoundWinner).getPlayerNum();
    }
    // returns the contents of the communal pile
    public String getCommunalPile() {
        return playerList.get(0).printHand();
    }
    // gets the player number from position in activeplayer array, rather than playerlist
    public int getPlayerNum(ArrayList<Player> activePlayers, int p) {
        return activePlayers.get(p).getPlayerNum();
    }
    // returns last round winner int as a string
    public String getRoundWinner() {
        return String.valueOf(lastRoundWinner);
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;										// once fully constructed
    }

}