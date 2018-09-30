public class Deck {

    public static Card[] deck(){
        //Variable Declaration
        Card[] deck = new Card[52];
        int num = 0;

        //Initialize Deck with card values
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                Card card = new Card();
                switch (i) {
                    case 1: card.setCardType("Club"); break;
                    case 2: card.setCardType("Diamond"); break;
                    case 3: card.setCardType("Heart"); break;
                    case 4: card.setCardType("Spade"); break;
                    default: break;
                    }

                switch (j) {
                    case 1:
                        card.setCardValue("A");
                        card.setCardPoint(11);
                        break;
                    case 2:
                        card.setCardValue("2");
                        card.setCardPoint(2);
                        break;
                    case 3:
                        card.setCardValue("3");
                        card.setCardPoint(3);
                        break;
                    case 4:
                        card.setCardValue("4");
                        card.setCardPoint(4);
                        break;
                    case 5:
                        card.setCardValue("5");
                        card.setCardPoint(5);
                        break;
                    case 6:
                        card.setCardValue("6");
                        card.setCardPoint(6);
                        break;
                    case 7:
                        card.setCardValue("7");
                        card.setCardPoint(7);
                        break;
                    case 8:
                        card.setCardValue("8");
                        card.setCardPoint(8);
                        break;
                    case 9:
                        card.setCardValue("9");
                        card.setCardPoint(9);
                        break;
                    case 10:
                        card.setCardValue("10");
                        card.setCardPoint(10);
                        break;
                    case 11:
                        card.setCardValue("Jack");
                        card.setCardPoint(10);
                        break;
                    case 12:
                        card.setCardValue("Queen");
                        card.setCardPoint(10);
                        break;
                    case 13:
                        card.setCardValue("King");
                        card.setCardPoint(10);
                        break;
                    default: break;
                }
                card.setCardUse(true);
                deck[num] = card;
                num++;
                }
            }
        return deck;
    }
}
