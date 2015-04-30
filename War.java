/**
Christopher Lopez
Computer Science 110 
Assignment #10
This is the runner for the game War, it will utilize the card class as well as
use nodes to make two different decks of cards. It will be a great challange and an
even more insurmountable defeat
*/
import java.util.ArrayList;

public class War
{
   //this is an array for the cards that remain when war occurs
   public ArrayList<Card> pile = new ArrayList<Card>();
   //this is the deck that will be distributed
   private Deck deck;
   //this is the playehand variables for the playerhand objects
   public PlayerHand playerHand1,playerHand2;
   //these are the card variables to be compared
   public Card card1, card2;
   //this is a boolean to determine whether there is a winner for a round or not
   public boolean winner;
   //this is a final constant for the number 0 where no cards are present
   private final int NO_CARDS = 0;
   //this is a final constant for the value of the ace
   private final int ACE = 1;
  
   /**
   This is an empty constructor for a game of War which will create a deck of cards
   */
   public War()
   {
      //declaring the array of cards that will be used for decks
      deck = new Deck();
      deck.shuffle();
      
      //create two player hands
      playerHand1 = new PlayerHand();
      playerHand2 = new PlayerHand();
      
      //hand out the cards to the players
      passCards();
      
      //declare the war      
   }
  
   /**
   This method will pass the cards out to the players
   */
   public void passCards()
   {
      //make sure deck is not empty
      while(!deck.isEmpty())
      {
        
         playerHand1.addCards(deck.dealCard());
         playerHand2.addCards(deck.dealCard());
            
      }
  
   }
   
   /**
   This is a method that when the button for war is pressed, will acquire the
   first cards from the player decks and then compare them to eachother
   it will not accept any arguements nor will it return anything but it will set
   the card1 and card2 objects
   It will get the sizes of the decks of each user and if the deck size != 0, take the card at 
   the beginning of the deck 
   */
   public void getWarCards()
   {
   
      //get a card and set winner to false because there is no winner yet
      winner = false;
      
      //if the playerHands are not empty, getCards from them
      if(playerHand1.index > NO_CARDS && playerHand2.index > NO_CARDS)
      {
      
         card1 = playerHand1.getCard();
         card2 = playerHand2.getCard();
      }
      
   }
   
   /**
   This is a method to get the first card in the player decks and it will add
   both cards to the winning players
   */
   public void checkWar()
   {
      //this loop will decide what to do depending on whether there is a winner or not
      //this is the option for if there is a winner
      //this loop will get a winner and will account for whether a player gets an ACE or not
      if(getWinner(card1,card2))
      {     
         winner = true;
         
         if(card1.getRank() > card2.getRank())
         {
            //case if card 1 has a greater rank but card 2 is an ace
            if(card2.getRank() == ACE )
            {
               playerHand2.addCards(card1);
               playerHand2.addCards(card2);
            }
            else
            {
               playerHand1.addCards(card1);
               playerHand1.addCards(card2);
            }
            
            //checking to see whether or not pile is empty 
            if(!pile.isEmpty())
            {
               //dispurse the pile to the winner
               while(!pile.isEmpty())
               {  
                  if(card2.getRank() == ACE)
                  {
                     playerHand2.addCards(pile.remove(NO_CARDS));
                  }
                  else
                  {
                     playerHand1.addCards(pile.remove(NO_CARDS));
                  }
               }
            
            }
         }
         //case where player 2 wins  
         else if(card2.getRank() > card1.getRank())
         {
            //this is the case where card2 has a greater rank but card1 is an ace
            if(card1.getRank() == ACE )
            {
               playerHand1.addCards(card1);
               playerHand1.addCards(card2);
            }
            else
            {
               playerHand2.addCards(card1);
               playerHand2.addCards(card2);
            }
            
            //check to see whether or not pile is empty
            if(!pile.isEmpty())
            {
            
               while(!pile.isEmpty())
               {
                  if(card1.getRank() == ACE)
                  {
                     playerHand1.addCards(pile.remove(NO_CARDS));
                  }
                  else
                  { 
                     playerHand2.addCards(pile.remove(NO_CARDS));
                  }
               }
            
            }
         }
         
      }
      else
      {
         //add the cards to the end of the pile of cards
         pile.add(card1);
         pile.add(card2);
         
      }
   
   }
      
   
   /**
   This method will get the winner of the round and dictate whether there is a winner
   or not by return a True value or a False value
   @param c1 is a card that was taken from the first person
   @param c2 is another card that was taken from the second person
   @return is a boolean and it is true if there is a winner, false otherwise
   */
   public boolean getWinner(Card c1, Card c2)
   {
      
      if( c1.getRank() == c2.getRank() )
      {
         winner = false;
         return false;
      }
      else
         return true;
   
   }
   
}
