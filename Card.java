/**
Christopher Lopez
CS110 
Assignment #10
This is a class that will simulate a deck of cards. It will be used to extend a 
class called deck which will be made up of card item
*/


public class Card
{
   public final static int SPADES = 1;
   public final static int CLUBS = 2;
   public final static int HEARTS = 3;
   public final static int DIAMONDS = 4;
   public final static int ACE = 1;
   public final static int JACK = 11;
   public final static int QUEEN = 12;
   public final static int KING = 13;
   private final static int MINRANK = 2;
   private int rank;
   private int suit;
   public String cardImageName;

   /**
   Consructor to create a copy of a card for the user
   It is preset to create a carde of Spades if the user inputs a number too large or too small
   It also sets rank to 2 if the rank is too large or oo small that was inputted
   @param suit is the suit that the user wants the card to be
   @param rank is the rank that the user want to creat the card
   
   */
   public Card(int suit, int rank)
   {
      if (suit == SPADES)
         this.suit = SPADES;
      else if (suit == CLUBS ) 
         this.suit = CLUBS;
      else if (suit == HEARTS )
         this.suit = HEARTS;
      else if (suit == DIAMONDS )
         this.suit = DIAMONDS;
      else 
         this.suit = SPADES;
      
      if (rank == ACE)
         this.rank = ACE;
      else if(rank == KING)
         this.rank = KING;
      else if(rank == QUEEN)
         this.rank = QUEEN;
      else if(rank == JACK)
         this.rank = JACK;
      else if(rank < ACE || rank >KING)
         this.rank = MINRANK;
      else
         this.rank = rank;  
         
      setImage(suit, rank);
   }
   
   /**
   Method getSuit will return to the user the suit value that was
   assigned to the card. It does not accept any args and returns type
   integer
   @return suit is the suit value that was assigned to the card
   
   */
   
   public int getSuit()
   {
      return suit;
   }
   
   /**
   Method getRank is made to get the rank that the user assigned to the card
   this method will return rank in an integer value
   @return rank is the rank that the user assigned to their card
   
   */
   
   public int getRank()
   {
      return rank;
   }
   
   /**
   This method will return to the user their card in the form of a string. It will
   put the rank and the suit into string form and then return to them the card
   @return cardName is the name of the card made up of rank and suit
   */
   
   public String toString() 
   {
      
      String cardName;
    
          if (rank == ACE)
         cardName = "ACE";
      else if(rank == KING)
         cardName =  "KING" ;
      else if(rank == QUEEN)
         cardName =  "QUEEN";
      else if(rank == JACK)
         cardName =  "JACK";
      else 
         cardName = Integer.toString(rank);
           
      if (suit == SPADES)
         cardName = cardName + " of SPADES ";
      else if ( suit == CLUBS ) 
         cardName = cardName + " of CLUBS ";
      else if (suit == HEARTS )
         cardName = cardName + " of HEARTS ";
      else if (suit == DIAMONDS )
         cardName = cardName + " of DIAMONDS ";
      else
         cardName = cardName + "SPADES ";
        
  
      
      
      return cardName;
   }
   
   /**
   Method equals is created to return a boolean to the user. This boolean should be true
   if the card being sent to it is equal to the card being tested against it
   The method should return false otherwise.
   @param Card c is the card being tested against the initial card
   @return true if the cards are equivalent
   @return false if the cards are not equivalent
   
   */
   public boolean equals( Card c )
   {
      if(rank == c.getRank())
         return true;
      else
         return false;
   }

   /**
   This method is a setter and it will set the image assigned to the card based upon the 
   rank and the suit. It will start with a string called "cardpics/" and add on the name of the 
   card depending on the card
   @param suit is the suit of the card
   @param rank is the rank of the card
   */
   public void setImage(int s, int r)
   {
      this.cardImageName = "cardpics/";
   
      if(suit == SPADES)
      {
         if(rank == ACE)
         {
            this.cardImageName = cardImageName + "aces.jpg";
         } 
         else if(rank == JACK)
         {
            this.cardImageName = cardImageName + "jacks.jpg";
         }
         else if(rank == QUEEN)
         {
            this.cardImageName = cardImageName + "queens.jpg";
         }
         else if(rank == KING)
         {
            this.cardImageName = cardImageName + "kings.jpg";
         }
         else
         {
            this.cardImageName = cardImageName + rank + "s.jpg";
         }
      }
      else if(suit == CLUBS)
      {
         if(rank == ACE)
         {
            this.cardImageName = cardImageName + "acec.jpg";
         } 
         else if(rank == JACK)
         {
            this.cardImageName = cardImageName + "jackc.jpg";
         }
         else if(rank == QUEEN)
         {
            this.cardImageName = cardImageName + "queenc.jpg";
         }
         else if(rank == KING)
         {
            this.cardImageName = cardImageName + "kingc.jpg";
         }
         else
         {
            this.cardImageName = cardImageName + rank + "c.jpg";
         }
      }
      else if(suit == HEARTS)
      {
         if(rank == ACE)
         {
            this.cardImageName = cardImageName + "aceh.jpg";
         } 
         else if(rank == JACK)
         {
            this.cardImageName = cardImageName + "jackh.jpg";
         }
         else if(rank == QUEEN)
         {
            this.cardImageName = cardImageName + "queenh.jpg";
         }
         else if(rank == KING)
         {
            this.cardImageName = cardImageName + "kingh.jpg";
         }
         else
         {
            this.cardImageName = cardImageName + rank + "h.jpg";
         }
      }
      else if(suit == DIAMONDS)
      {
         if(rank == ACE)
         {
            this.cardImageName = cardImageName + "aced.jpg";
         } 
         else if(rank == JACK)
         {
            this.cardImageName = cardImageName + "jackd.jpg";
         }
         else if(rank == QUEEN)
         {
            this.cardImageName = cardImageName + "queend.jpg";
         }
         else if(rank == KING)
         {
            this.cardImageName = cardImageName + "kingd.jpg";
         }
         else
         {
            this.cardImageName = cardImageName + rank + "d.jpg";
         }
      }
   
   }

}

