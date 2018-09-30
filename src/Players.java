import java.util.ArrayList;
import java.util.Scanner;

public class Players {

    public static boolean gameBoard(Card[] deck, String pName, Card card){
        //Var Declaration
        int game = 0;
        Scanner scanner = new Scanner(System.in);
        int dealerScore = 0, playerScore = 0;
        int dealerWins = 0, playerWins = 0;

        //Initiate game with Dealer
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("GAMEBOARD MESSAGE: Initiating Game now! Get ready " + pName + "!");

        do {
            //Player gets turn
            playerScore = Players.player(deck, card);

            //Case Player got a Perfect 21
            if (playerScore == 1000){
                playerWins++;
            }
            //Case where player got a score between 1 and 21
            else if (playerScore != 0) {
                //Dealer gets turn
                dealerScore = Players.dealer(deck, card);

                if (playerScore > dealerScore) {
                    playerWins++;
                } else if (dealerScore > playerScore) {
                    dealerWins++;
                } else {
                    playerWins++;
                    dealerWins++;
                }
            //Case Player went over 21
            }else{
                dealerWins++;
            }

            //Print options to user
            printOptions(2, playerWins, dealerWins);
            game = scanner.nextInt();

            if (game == 2) {
                System.out.println();
                System.out.println("GAMEBOARD MESSAGE: Thank you for playing! Come Back soon! ");
            } else {
                System.out.println();
                System.out.println("GAMEBOARD MESSAGE: On to the next round!!");
            }
        }while(playerScore > 0 && game == 1);

        return true;
    }

    public static int dealer(Card[] deck, Card card){
        System.out.println("GAMEBOARD MESSAGE: DEALERS TURN TO PLAY! READY SET GO");
        //Variable Declaration
        boolean playing = true;
        ArrayList<Integer> cardSet = new ArrayList<>();
        int usersPick = 0;

        //Get users pick
        usersPick = Players.roundPlay(deck, cardSet, 0, card);
        int game = gameOver(0, card, deck, cardSet);
        //Case where dealer went over 21
        if (game == 0){
            return 0;
        }
        //case where dealer got a perfect 21
        else if (game == 10){
            return 1000;
        }
        //Case where dealer's turn is not over
        else{
            do {
                //Show player dealers choice
                System.out.println("GAMEBOARD MESSAGE: Dealer chose Option " + usersPick);
                //Case user quits
                if (usersPick == 3) {
                    System.out.println("GAMEBOARD MESSAGE: Dealer Quit!");
                    playing = false;
                    break;
                } //User wants another card
                else if (usersPick == 1) {
                    cardSet.add(hit(deck, card));
                    usersPick = roundPlay(deck, cardSet, 0, card);
                    if (usersPick == 0){
                        return 0;
                    }else if (usersPick == 10){
                        return(card.playValue(deck,cardSet));
                    }
                }//User Shows card and see who won
                else if (usersPick == 2) {
                    playing = false;
                    System.out.println();
                    System.out.println("GAMEBOARD MESSAGE: Dealer's score is -> " + card.playValue(deck, cardSet));
                    //Show Cards
                    return(card.playValue(deck, cardSet));
                }
            } while (playing);
        }
        return 0;
    }

    public static int player(Card[] deck, Card card){
        System.out.println("GAMEBOARD MESSAGE: YOUR TURN TO PLAY! READY SET GO!");

        //Variable Declaration
        boolean playing = true;
        ArrayList<Integer> cardSet = new ArrayList<>();
        int usersPick = 0;

        usersPick = Players.roundPlay(deck, cardSet, 1, card);
        int game = gameOver(1, card, deck, cardSet);
        // Case player goes over 21 points
        if (game == 0){
            return 0;
        }
        // case player has perfect 21 points
        else if (game == 10){
            return 1000;
        }
        // case player continues picking from different options
        else {
            do {
                //Case user quits
                if (usersPick == 3) {
                    System.out.println("GAMEBOARD MESSAGE: Its sad to see you go! Comeback soon, goodbye for now!");
                    playing = false;
                    break;
                }
                //User wants another card
                else if (usersPick == 1) {
                    cardSet.add(hit(deck, card));
                    usersPick = roundPlay(deck, cardSet, 1, card);
                    if (usersPick == 0){
                        return 0;
                    }else if (usersPick == 10){
                        return(card.playValue(deck,cardSet));
                    }
                }
                //User Shows card to see who won
                else if (usersPick == 2) {
                    playing = false;
                    System.out.println();
                    System.out.println("GAMEBOARD MESSAGE: Your score is -> " + card.playValue(deck, cardSet));
                    return(card.playValue(deck, cardSet));
                }
            } while (playing);
        }
        return 0;
    }

    public static int gameOver(int player, Card card, Card[] deck, ArrayList<Integer> cardSet){
        //Case player is winning
        if (player == 1){
            //Case player lost - has over 21 points
            if (card.playValue(deck, cardSet) > 21){
                System.out.println();
                System.out.println("GAMEBOARD MESSAGE: Your score is over 21, Hence this Game is over for you.");
                return 0;
            }
            //Case player won - has a perfect 21
            else if (card.playValue(deck, cardSet) == 21){
                System.out.println();
                System.out.println("GAMEBOARD MESSAGE: Your score is 21, Hence you won!");
                return 10;
            }
        }
        //Case dealer is playing
        else if (player == 0){
            //Case dealer lost - has over 21 points
            if (card.playValue(deck, cardSet) > 21){
                System.out.println();
                System.out.println("GAMEBOARD MESSAGE: Dealer's score is over 21, Hence this Game is over for dealer.");
                return 0;
            }
            //Case dealer won - has a perfect 21
            else if (card.playValue(deck, cardSet) == 21){
                System.out.println();
                System.out.println("GAMEBOARD MESSAGE: Dealer's score is 21, Hence dealer won!");
                return 10;
            }
        }
        return 5;
    }

    public static int roundPlay(Card[] deck, ArrayList<Integer> cardSet, int playing, Card card){
        //Variable Declaration
        int usersPick = 0;

        //Generate 2 cards for user
        if (cardSet.isEmpty()){
            cardSet.add(card.cardGenerator(deck));
            cardSet.add(card.cardGenerator(deck));

            //take those cards "out of the deck"
            for (int i = 0; i < cardSet.size(); i++){
                deck[i].setCardUse(false);
            }
        }

        //Show Card to user and see what they want to do
        if (playing == 1){
            showCard(cardSet, deck);
            int game = gameOver(1, card, deck, cardSet);
            if (game == 0){
                return 0;
            }
            else if (game == 10){
                return 10;
            }
            else{
                usersPick = userChoice();
            }
        }
        //Choices for dealer
        else if (playing == 0){
            int game = gameOver(0, card, deck, cardSet);
            if (game == 0){
                return 0;
            } else if (game == 10){
                return 10;
            } else {
                usersPick = dealerChoice(card, deck, cardSet);
            }
        }
        return usersPick;
    }

    public static int hit(Card[] deck, Card card) {
        //Generate 1 cards for user
        int pCard1 = card.cardGenerator(deck);

        //take those cards "out of the deck"
        deck[pCard1].setCardUse(false);

        return pCard1;
    }

    public static int userChoice(){
        //Variable Declaration
        Scanner scanner = new Scanner(System.in);

        printOptions(1, 0,0);
        int usersPick = scanner.nextInt();
        return usersPick;
    }

    public static int dealerChoice(Card card, Card[] deck, ArrayList<Integer> cardSet){
        printOptions(1, 0,0);

        //Help dealer make the best choice
        int dealerchoice = 0;

        if (card.playValue(deck, cardSet) < 15){
            dealerchoice = 1;
        }else if (card.playValue(deck, cardSet) >= 15){
            dealerchoice = 2;
        }else{
            dealerchoice = 3;
        }
        return dealerchoice;
    }

    public static void printOptions(int num, int playerScore, int dealerScore){
        if (num == 1) {
            //Print options
            System.out.println();
            System.out.println("---------OPTIONS----------");
            System.out.println("1. Hit me with another card!");
            System.out.println("2. Show and see who won!");
            System.out.println("3. Quit.");
        }else if(num == 2) {
            //Display score and print further options
            System.out.println();
            System.out.println("---------CURRENT SCORE----------");
            System.out.println("You won " + playerScore + " rounds");
            System.out.println("Dealer won " + dealerScore + " rounds");
            System.out.println();
            System.out.println("---------OPTIONS----------");
            System.out.println("1. Continue to next round!");
            System.out.println("2. Quit game with dealer.");
        }
    }

    public static void showCard(ArrayList<Integer> cardSet, Card[] deck){
        System.out.println();
        System.out.println("GAMEBOARD MESSAGE: Current player has the following cards -> ");
        for (int i = 0; i < cardSet.size(); i++){
            System.out.println("Card: " + deck[cardSet.get(i)].getcardType() + " - " + deck[cardSet.get(i)].getcardValue());
        }
    }

}
