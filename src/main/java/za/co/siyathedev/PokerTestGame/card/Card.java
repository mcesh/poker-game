package za.co.siyathedev.PokerTestGame.card;

import za.co.siyathedev.PokerTestGame.exception.PlayingCardException;

public class Card {

    /* constant suits and ranks */
    static final String[] Suit = {"Clubs", "Diamonds", "Hearts", "Spades" };
    static final String[] Rank = {"","A","2","3","4","5","6","7","8","9","10","J","Q","K"};

    /* Data field of a card: rank and suit */
    private int cardRank;  /* values: 1-13 (see Rank[] above) */
    private int cardSuit;  /* values: 0-3  (see Suit[] above) */

    /* Constructor to create a card */
    /* throw PlayingCardException if rank or suit is invalid */
    public Card(int rank, int suit) throws PlayingCardException {
        if ((rank < 1) || (rank > 13))
            throw new PlayingCardException("Invalid rank:"+rank);
        else
            cardRank = rank;
        if ((suit < 0) || (suit > 3))
            throw new PlayingCardException("Invalid suit:"+suit);
        else
            cardSuit = suit;
    }

    /* Accessor and toString */
    /* You may impelemnt equals(), but it will not be used */
    public int getRank() { return cardRank; }
    public int getSuit() { return cardSuit; }
    public String toString() { return Rank[cardRank] + " " + Suit[cardSuit]; }


    // Few quick tests here
    public static void main(String args[])
    {
        try {
            Card c1 = new Card(1,3);    // A Spades
            System.out.println(c1);
            c1 = new Card(10,0);	// 10 Clubs
            System.out.println(c1);
            c1 = new Card(10,5);        // generate exception here
        }
        catch (PlayingCardException e)
        {
            System.out.println("PlayingCardException: "+e.getMessage());
        }
    }
}