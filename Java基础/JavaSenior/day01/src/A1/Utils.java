package A1;

import java.util.Scanner;

public class Utils
{
    public static void menu()
    {
        System.out.println("please select from the following options");
        System.out.println("press 1 to register a player");
        System.out.println("press 2 to start a new game");
        System.out.println("press 3 to view a help menu");
        System.out.println("press 4 to exit");
    }

    public static void helpMenu()
    {
        System.out.println("Game Requirements");
        System.out.println("1.Players must use the 5 tiles given with the associated values and scores.");
        System.out.println("2.Before each round, each player has the following five squares. Each block has a value and an associated score:");
        System.out.println("3.You cannot play any card value other than the prime number above. This must also be verified when the user selects a block of diagrams. For incorrect selections, an error message should be displayed and the user can re-select。");
        System.out.println("4.Each player has the same five CARDS. Each player can only use one of five files per round。");
        System.out.println("5.Before each round, the game automatically decides whether the human or computer player should go first。");
        System.out.println("6.For each round, each player will play one card, and the card value will increase to the total number of games played in that round。");
        System.out.println("If the total number of games is less than or equal to 21, the player receives points for using the card. However, if the total number of games is greater than 21, no points are allocated");
        System.out.println("Giving the last card to the player causes the score to be greater than 21");
        System.out.println();
    }

    public static int inputNum()
    {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        return num;
    }

}
