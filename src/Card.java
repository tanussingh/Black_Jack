import java.util.ArrayList;
import java.util.Random;

public class Card {
    //Variable Declaration
    private String cardType;        //Heart, Spade, Diamond, Clubs
    private String cardValue;       //Ace,2,3...King
    private boolean cardUse;        //If Card has been played
    private int cardPoint;          //Int value of each card

    //setter functions
    public void setCardType(String i) {
        this.cardType = i;
    }

    public void setCardValue (String i) {
        this.cardValue = i;
    }

    public void setCardUse (boolean i) {
        this.cardUse = i;
    }

    public void setCardPoint(int i){
        this.cardPoint = i;
    }

    //getter functions
    public String getcardType() {
        return this.cardType;
    }

    public String getcardValue() {
        return this.cardValue;
    }

    public boolean getCardUse() {
        return this.cardUse;
    }

    public int getcardPoint(){
        return this.cardPoint;
    }

    //Calculation functions
    public int playValue(Card[] deck, ArrayList<Integer> cardSet){
        int playerPoint = 0;
            for (int i = 0; i < cardSet.size(); i++){
                playerPoint += deck[cardSet.get(i)].getcardPoint();
            }
            if (playerPoint >= 21){
                if (cardSet.contains(1)){
                    deck[1].setCardPoint(1);
                    playerPoint -= 10;
                }else if (cardSet.contains(14)){
                    deck[1].setCardPoint(1);
                    playerPoint -= 10;
                }else if (cardSet.contains(27)){
                    deck[1].setCardPoint(1);
                    playerPoint -= 10;
                }else if (cardSet.contains(40)){
                    deck[1].setCardPoint(1);
                    playerPoint -= 10;
                }
        }
        return playerPoint;
    }

    public int cardGenerator(Card[] deck){
        Random rand = new Random();
        int num = 0;
        do {
            num = (rand.nextInt(52) + 0);
        } while(deck[num].getCardUse() == false);
        return num;
    }

}