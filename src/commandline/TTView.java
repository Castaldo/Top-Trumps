package commandline;

import java.util.ArrayList;

public class TTView {

    public TTView() {

    }

    public void promptPlayerNum() {
        System.out.println("Please enter an integer between 2 and 5 to select total number of players (including human)");
    }

    public void usersChoice(String pName) {
        System.out.println(pName + "'s choice");
    }

    public void aiTopCard(int pNum, String topCard) {
        System.out.print("Player "+ pNum + "'s top card is: " + "\n" + topCard + "\n \n");
    }

    public void userTopCard(String topCard) {
        System.out.print( "Your top card is: " + "\n" + topCard + "\n \n");
    }

    public void promptCatSelect() {
        System.out.println("Please select an attribute. 1 for Geographic, 2 for Duration, 3 for Population, 4 for Antiquity, 5 for Cool Factor.");
    }

    public void enterPrompt() {
        System.out.println("Press ENTER to continue");
    }

    public void printWinner(int winner) {
        System.out.println("Player " + winner + " has won the game");
    }

    public void printRound(int round) {
        System.out.println("ROUND " + round);
    }


}