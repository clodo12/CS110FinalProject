/**
Christopher Lopez
Computer Science 110
Assignment #10
This is a player hand class which will be used to keep track of the cards in each players 
hands.
*/
import java.util.ArrayList;

public class PlayerHand
{
   //create an array of cards
   public ArrayList<Card> hand = new ArrayList<Card>();
   
   //this is an index integer which will be used to keep count of the amount of cards in the users hand
   public int index;
   
   //this is an integer to represent the amount of cards each person should have in their
   //hands to begin the game
   private final int CARDS_TO_START = 25;
   
   //this is an integer to represent the first card in the persons deck
   private final int FIRST_CARD = 0;
   
   public PlayerHand()
   {
      
      ArrayList<Card> hand = new ArrayList<Card>(CARDS_TO_START);
      
   }

   /**
   This addCards method will be used to add cards to the players hand 
   The players hand is an array that will require more cards to be sent to it
   @param this is the players hand
   */
   public void addCards(Card c)
   {
      //add to the index of the amount of cards the player has in their hand
      index++;
   
      //add a card to the players hand
      hand.add(c);
   
   }
   
   /**
   This constructor is used to show the cards of a players hands
   */
   public int getNumCards()
   {
   
      return index;
      
   }
   
   /**
   This is a getter that will return the first card on top of the deck of the arraylist of cards
   @return is a card object
   */
   public Card getCard()
   {
      index--;
      
      return hand.remove(0);
   
   }
   
//    /**
//    This method will be used to get the card at the specified index's that are being compared
//    @return c is the first card present in the persons array of cards
//    */
//    public Card getCard(int i)
//    {
//       
//       if(i <= index)
//          return playerHand[index];
//       else
//          return playerHand[i];
//    
//    }

}