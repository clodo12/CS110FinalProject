/**
Christopher Lopez
Assignment #10
This portion is the GUI for the game of war
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class WarGameGUI extends JFrame
{
   
   private War game;                                        //the guts
   private JPanel leftPanel, rightPanel, middlePanel;       //regions
   private JButton button;                                  //one button
   private JLabel status;                                   //game status
   private JLabel title;                                     //name of title jlabel
   private JLabel pic1, pic2, pic3, pic4, pic5, pic6;        //names of jlabal pics 
   private ImageIcon image1, image2, image3, image4, image5;   //image icons
   private final int ACE = 1;                                  //ace num
   private final int NOCARDS = 0;                              //no cards num
   
   
   
   /**
   Creating the GUI for the game of War
   */
   public WarGameGUI()
   {
      
      //set the layout of the game
      setLayout(new GridLayout(1,2));
      
      //open the game
      game = new War();
      
      //set containers and components
      //left panel
      leftPanel = new JPanel();
      leftPanel.setBackground(Color.red);
      leftPanel.setLayout(new BorderLayout());
      image1 = new ImageIcon("cardpics/back.jpg");
      pic1 = new JLabel("Deck 1",image1,JLabel.CENTER);
      leftPanel.add(pic1,BorderLayout.CENTER);      
      
      //right panel
      rightPanel = new JPanel();
      rightPanel.setBackground(Color.blue);
      rightPanel.setLayout(new BorderLayout());
      pic2 = new JLabel("Deck 2",image1,JLabel.CENTER);
      rightPanel.add(pic2,BorderLayout.CENTER);
      //rightPanel.add(new JLabel("Label C"),BorderLayout.WEST);
      
      //middle panel
      //panel with button
      middlePanel = new JPanel();
      middlePanel.setBackground(Color.green);
      middlePanel.setLayout(new BorderLayout());
      button = new JButton("Declare WAR!");
      middlePanel.add(button,BorderLayout.NORTH);
      button.addActionListener(new ButtonListener());
      
      //adding the panels
      add(leftPanel);
      add(middlePanel);
      add(rightPanel);
      
   }
   //handle button events
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //this if statement will check the game to see if any player is out of cards
         //depending on who is out of cards, the game will reveal the other player as a winner 
         //as well as remove the image of the card back from their respective panel
         if(game.playerHand1.getNumCards()==NOCARDS || game.playerHand2.getNumCards() ==NOCARDS)
         {  
            //case where player 2 wins
            if(game.playerHand1.getNumCards() == NOCARDS)
            {
               status = new JLabel("Player 2 wins!! Start program over to Play again! ");
               middlePanel.removeAll();
         		middlePanel.add(status, BorderLayout.SOUTH);
               leftPanel.removeAll();
               rightPanel.revalidate();
               rightPanel.repaint();
            }
            //case where player 1 wins
            else if(game.playerHand2.getNumCards() == NOCARDS)
            {
            
               status = new JLabel("Player 1 wins!! Start program over to Play again! ");
               middlePanel.removeAll();
         		middlePanel.add(status, BorderLayout.SOUTH);
               rightPanel.removeAll();
               leftPanel.revalidate();
               leftPanel.repaint();
            
            }
            
         }
         //this is the case if there are no cards in the pile to be acquired from a draw
         if(game.pile.isEmpty())
         {
            //removing all in order to reset the panels.
            //also adding the button back into middle panel  
            leftPanel.removeAll();
            middlePanel.removeAll();
            middlePanel.add(button, BorderLayout.NORTH);
            middlePanel.repaint();
            rightPanel.removeAll();
                           
            //this is in order to rese the panels
            leftPanel.revalidate();
            middlePanel.revalidate();
            rightPanel.revalidate();
            
            //here is where the panel will be redisplayed in its original format
            middlePanel.repaint();
            
   			//acquire the cards
   			game.getWarCards();
   		   
            //get the image name for the cards
   			String card1Name = game.card1.cardImageName;
   			String card2Name = game.card2.cardImageName;
   				
   			//create	image	icons	using	the card	names
   			ImageIcon image2 = new ImageIcon(card1Name);
   			ImageIcon image3 = new ImageIcon(card2Name);
   			
   			//jlabels of images	 
   			pic3 = new JLabel(image2);
   			pic4 = new JLabel(image3);
   			
   			//add	the image jlabels	  
   			leftPanel.add(pic3, BorderLayout.WEST);
            leftPanel.add(pic2, BorderLayout.CENTER);
            rightPanel.add(pic1, BorderLayout.CENTER);
   			rightPanel.add(pic4,	BorderLayout.WEST);
   			
   			//check to see	if	anyone has won	  
   			game.checkWar();
   			
            //dispurse cards and show who has won
   			if(game.winner)
   			{  
               //case for if the first player has won but will check to see if the second player has
               //an ace. If the second player has an ace then the first player loses
   				if(game.card1.getRank()	> game.card2.getRank())
   				{
                   if(game.card2.getRank() == ACE)
                   {
                      status = new JLabel("Player 2 wins \n Cards Left: "+ game.playerHand2.getNumCards());
      					 middlePanel.add(status, BorderLayout.EAST);
                      middlePanel.revalidate();
                      middlePanel.repaint();
                   
                   }
                   else
                   {
      					 status = new JLabel("Player 1 wins \n Cards Left: "+ game.playerHand1.getNumCards());
      					 middlePanel.add(status, BorderLayout.WEST);
                      middlePanel.revalidate();
                      middlePanel.repaint();
   					 }
   				}
               //case for if the second player has won but will check to see if the first player
               //has an ace. If the second player has an ace the second player loses
   				else if(game.card1.getRank()<game.card2.getRank())
   				{
   				    if(game.card1.getRank() == ACE)
                   {
                      status = new JLabel("Player 1 wins \n Cards Left: "+ game.playerHand1.getNumCards());
      					 middlePanel.add(status, BorderLayout.WEST);
                      middlePanel.revalidate();
                      middlePanel.repaint();
                   
                   }
                   else
                   {
      					 status = new JLabel("Player 2 wins \n Cards Left: "+ game.playerHand2.getNumCards());
      					 middlePanel.add(status,BorderLayout.EAST);
                      middlePanel.revalidate();
                      middlePanel.repaint();
                   }
   					
   				}

   			}
            //otherwise add the back image of a card to the middle panel as well as a tie messege
   			else
   			{
   			
   				status =	new JLabel("There is a tie! Cards in a pile. Declare WAR!");
   				middlePanel.add(status,BorderLayout.CENTER);
   				image4 =	new ImageIcon("cardpics/back.jpg");
   				pic5 = new JLabel(image4);
   				middlePanel.add(pic5,BorderLayout.SOUTH);
   				
   	      }
         //ending of the case where there are no cards in pile, start of 
         //case for when there are cards in the pile to be acquired 
         }
         else    
         {  
            //reset the middle panel to present back of card and a new messege
            middlePanel.removeAll();
            middlePanel.add(button, BorderLayout.NORTH);
            middlePanel.revalidate();
            middlePanel.repaint();
            status =	new JLabel("There was a tie!");
            middlePanel.add(status,BorderLayout.CENTER);
            image5 =	new ImageIcon("cardpics/back.jpg");
            pic6 = new JLabel(image5);
            middlePanel.add(pic6,BorderLayout.SOUTH);
            
            //prepare the player hands to change cards
            leftPanel.removeAll();
            rightPanel.removeAll();
            leftPanel.revalidate();
            rightPanel.revalidate();
            
            //acquire the cards
   			game.getWarCards();
   		  
   			String card1Name = game.card1.cardImageName;
   			String card2Name = game.card2.cardImageName;
   				
   			//create	image	icons	using	the card	names
   			ImageIcon image2 = new ImageIcon(card1Name);
   			ImageIcon image3 = new ImageIcon(card2Name);
   			
   			//jlabels of images	 
   			pic3 = new JLabel(image2);
   			pic4 = new JLabel(image3);
   			
   			//add	the image jlabels	  
   			leftPanel.add(pic3, BorderLayout.WEST);
   			rightPanel.add(pic4,	BorderLayout.WEST);
   			
   			//check to see	if	anyone has won	  
   			game.checkWar();
            
            //the case if someone has won while there was a pile
            if(game.winner)
   			{
   				if(game.card1.getRank()	> game.card2.getRank())
   				{
                   if(game.card2.getRank() == ACE)
                   {
                      status = new JLabel("Player 2 wins \n Cards Left: "+ game.playerHand2.getNumCards());
      					 middlePanel.add(status, BorderLayout.EAST);
                      middlePanel.revalidate();
                      middlePanel.repaint();
                   
                   }
                   else
                   {
      					 status = new JLabel("Player 1 wins \n Cards Left: "+ game.playerHand1.getNumCards());
      					 middlePanel.add(status, BorderLayout.WEST);
                      middlePanel.revalidate();
                      middlePanel.repaint();
   					 }
   				}
   				else if(game.card1.getRank()<game.card2.getRank())
   				{
   				    if(game.card1.getRank() == ACE)
                   {
                      status = new JLabel("Player 1 wins \n Cards Left: "+ game.playerHand1.getNumCards());
      					 middlePanel.add(status, BorderLayout.WEST);
                      middlePanel.revalidate();
                      middlePanel.repaint();
                   
                   }
                   else
                   {
      					 status = new JLabel("Player 2 wins \n Cards Left: "+ game.playerHand2.getNumCards());
      					 middlePanel.add(status,BorderLayout.EAST);
                      middlePanel.revalidate();
                      middlePanel.repaint();
                   }
   					
   				}
            }
            //otherwise (no game winner) add a new messege to the middle panel
   			else
   			{
   			   
             	status =	new JLabel("There is a tie! Cards are in a pile. Declare WAR!");
   				middlePanel.add(status,BorderLayout.CENTER);
               
            }
         }
            
            
      }
         
         
       
   }
  
}

