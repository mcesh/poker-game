package za.co.siyathedev.PokerTestGame.decks;

import za.co.siyathedev.PokerTestGame.card.Card;
import za.co.siyathedev.PokerTestGame.exception.PlayingCardException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Decks {

    /* this is used to keep track of original n*52 cards */
    private static List<Card> originalDecks;

    /* this starts with n*52 cards deck from original deck   */
    /* it is used to keep track of remaining cards to deal */
    /* see reset(): it resets dealDecks to a full deck      */
    private static List<Card> dealDecks;

    private static List<Card> newDeal;
    /* number of decks in this object */
    private int numberDecks;


    /*
     * Constructor: Creates default one deck of 52 playing cards in originalDecks and
     * 		    copy them to dealDecks  initialize numberDecks=n
     */
    public Decks(){
        numberDecks=1;
        originalDecks = new ArrayList<>(52);
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < 14; i++) {
                Card nextCard;
                try {
                    nextCard = new Card(i, j);
                    originalDecks.add(nextCard);
                } catch (PlayingCardException e) {
                    e.printStackTrace();
                }
            }// end for(j)
        }// end for(i)

        //clone original deck
        dealDecks = new ArrayList<Card>(originalDecks);

    }


    /**
     * Constructor: Creates n decks (52 cards each deck) of playing cards in
     *              originalDecks and copy them to dealDecks.
     *              initialize numberDecks=n
     */
    public Decks(int n)
    {
        numberDecks=n;
        originalDecks = new ArrayList<Card>(numberDecks*52);
        for (int k=0; k<2; k++){
            for (int j = 0; j < 4; j++) {
                for (int i = 1; i < 14; i++) {
                    Card nextCard;
                    try {
                        nextCard = new Card(i, j);
                        originalDecks.add(nextCard);
                    } catch (PlayingCardException e) {
                        e.printStackTrace();
                    }
                }// end for(j)
            }// end for(i)
        }//end for(k)
        //clone original deck
        dealDecks = new ArrayList<Card>(originalDecks);

    }

    public void shuffle()
    {
        Collections.shuffle(dealDecks);
    }


    public static List<Card> deal(int numberCards) throws PlayingCardException{
        newDeal = new ArrayList<Card>(numberCards);

        for (int i = 0; i < numberCards; i++) {
            newDeal.add(dealDecks.remove(0));
        }

        return newDeal;
    }

    public static void reset()
    {
        dealDecks = new ArrayList<>(originalDecks);
    }


    public static int remain()
    {
        return dealDecks.size();
    }

    public String toString()
    {
        return ""+dealDecks;
    }
    static List<Card> currentHand;


    public static void main(String args[]) {

        System.out.println("*******    Create 2 decks of cards      *********\n\n");
        Decks decks  = new Decks(2);

        for (int j=0; j < 2; j++)
        {
            System.out.println("\n************************************************\n");
            System.out.println("Loop # " + j + "\n");
            System.out.println("Before shuffle:"+decks.remain()+" cards");
            System.out.println("\n\t"+decks);
            System.out.println("\n==============================================\n");

            int numHands = 4;
            int cardsPerHand = 30;

            for (int i=0; i < numHands; i++)
            {
                decks.shuffle();
                System.out.println("After shuffle:"+decks.remain()+" cards");
                System.out.println("\n\t"+decks);
                try {
                    System.out.println("\n\nHand "+i+":"+cardsPerHand+" cards");
                    System.out.println("\n\t"+decks.deal(cardsPerHand));
                    System.out.println("\n\nRemain:"+decks.remain()+" cards");
                    System.out.println("\n\t"+decks);
                    System.out.println("\n==============================================\n");
                }
                catch (PlayingCardException e)
                {
                    System.out.println("*** In catch block : PlayingCardException : Not enough cards to deal "+e.getMessage());
                }
            }
            reset();
        }
    }
}
