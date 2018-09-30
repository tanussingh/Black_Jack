import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variable Declaration
        Card card = new Card();
        Card[] deck = Deck.deck();
        String playerName;

        //Initiate Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Hello! Welcome to a very simple game of Black Jack, What's your name?");
        playerName = scanner.next();
        System.out.println("Its nice to meet you " + playerName + ", this game is between you and our virutal Dealer!");
        System.out.println("Rules: 1. You will have your turn then dealer gets their turn, results are announced once both players get their turn.");
        System.out.println(" 2. If there is a tie, both player and dealer get a point.");
        System.out.println(" 3. If a player goes over 21, the other player automatically gets a point for that round.");
        System.out.println(" 4. If a player hits 21, that player automatically gets a point for that round");
        System.out.println(" Good luck, may the Ace's be ever in your favor! ");

        //Play the game based on user preference
        boolean done = Players.gameBoard(deck, playerName, card);
        if (done){
            System.out.println("-------------------------");
            System.out.println("Have a nice day! We will be waiting for you to join us soon!");
        }
    }
}
