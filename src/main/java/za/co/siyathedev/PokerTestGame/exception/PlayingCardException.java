package za.co.siyathedev.PokerTestGame.exception;

public class PlayingCardException extends Exception {

    /* Constructor to create a PlayingCardException object */
    PlayingCardException (){
        super ();
    }
    public PlayingCardException(String reason){
        super ( reason );
    }
}
