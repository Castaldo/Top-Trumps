package commandline;

import java.io.*;
import java.util.ArrayList;

public class TestLog {
    /*
     * testlog uses a filewriter and buffered writer to create a fresh test log each time the program is run with the test log
     * activity set to true
     */
    FileWriter writer = new FileWriter("/Users/chris/Desktop/untitled folder/testlog.log");
    BufferedWriter buffer = new BufferedWriter(writer);

    public TestLog() throws IOException {

    }
    // prints initial deck to test log
    public void printInitialDeck(String deck) throws IOException {
        buffer.write("-----------------------------------------------------------------------" + "\n");
        buffer.write("Initial Deck" + "\n");
        buffer.write(deck + "\n" + "\n" + "\n");
        buffer.write("-----------------------------------------------------------------------" + "\n");
    }

    // prints deck after shuffle
    public void printShuffledDeck(String deck) throws IOException {
        buffer.write("-----------------------------------------------------------------------" + "\n");
        buffer.write("Shuffled Deck" + "\n");
        buffer.write(deck + "\n" + "\n" + "\n");
        buffer.write("-----------------------------------------------------------------------" + "\n");
    }
    // formatting for player hand surrounds
    public void playerHandsSurround() throws IOException {
        buffer.write("-----------------------------------------------------------------------" + "\n");
        buffer.write("Player Hands" + "\n");
    }
    // prints each players hand once cards dealt
    public void printPlayerHands(String playerHand, int p) throws IOException {
        buffer.write("\n" + "Player " + p + "'s hand:");
        buffer.write(playerHand + "\n");

    }
    //formatting for player hand surround out
    public void playerHandsSurroundOut() throws IOException {
        buffer.write("-----------------------------------------------------------------------" + "\n");
    }
    // prints communal pile each time cards are dealt
    public void printCommunalPile(String communalPile, int round) throws IOException {
        buffer.write("-----------------------------------------------------------------------" + "\n");
        buffer.write("Communal Pile contents in round " + round + "\n");
        buffer.write(communalPile + "\n" + "\n");
        buffer.write("-----------------------------------------------------------------------" + "\n");
    }
    // formatting for top cards testlog output
    public void topCardsSurround(int r) throws IOException {
        buffer.write("-----------------------------------------------------------------------" + "\n");
        buffer.write("ROUND " + r + "\n");
        buffer.write("Player top cards :" + "\n");
    }


    // prints top cards of each player
    public void printTopCards(String topCard, int p) throws IOException {;
        buffer.write("Player " + p + "'s top card:");
        buffer.write(topCard + "\n" + "\n");
    }



    public void printWinner(int winnerNum) throws IOException {
        buffer.write("-----------------------------------------------------------------------" + "\n");
        buffer.write("PLAYER " + winnerNum + " has won the game!" + "\n");
        buffer.write("-----------------------------------------------------------------------" + "\n");
    }

    public void closeBuffer() throws IOException {
        buffer.close();
    }


    public void categoryAndValues(ArrayList<Player> aP, int catChosen) throws IOException {
        buffer.write("-----------------------------------------------------------------------" + "\n");
        if (catChosen == 1) {
            buffer.write("Category chosen Geographic size" + "\n \n" );
        } else if (catChosen == 2) {
            buffer.write("Category chosen Duration" + "\n \n");
        } else if (catChosen == 3) {
            buffer.write("Category chosen Population" + "\n \n");
        } else if (catChosen == 4) {
            buffer.write("Category chosen Antiquity" + "\n \n");
        } else {
            buffer.write("Category chosen Cool Factor" + "\n \n");
        }

        if (catChosen == 1) {
            for (int i = 0; i < aP.size(); i++) {
                buffer.write("Player " + aP.get(i).getPlayerNum() + " has a card with size " + aP.get(i).getGeo() + "\n");
            }
        } else if (catChosen == 2) {
            for (int i = 0; i < aP.size(); i++) {
                buffer.write("Player " + aP.get(i).getPlayerNum() + " has a card with duration " + aP.get(i).getDur() + "\n");
            }
        } else if (catChosen == 3) {
            for (int i = 0; i < aP.size(); i++) {

                buffer.write("Player " + aP.get(i).getPlayerNum() + " has a card with population " + aP.get(i).getPop() + "\n");
            }
        } else if (catChosen == 4) {
            for (int i = 0; i < aP.size(); i++) {
                buffer.write("Player " + aP.get(i).getPlayerNum() + " has a card with antiquity " + aP.get(i).getAnt() + "\n");
            }
        } else {
            for (int i = 0; i < aP.size(); i++) {
                buffer.write("Player " + aP.get(i).getPlayerNum() + " has a card with cool factor " + aP.get(i).getCool() + "\n");
            }
        }

    }

}