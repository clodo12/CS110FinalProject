/**
This is the runner for the game of war
Assignment #10 
Christopher Lopez
*/

import javax.swing.*;


public class WarRunner
{
   public static void main(String[]args)
   {

      WarGameGUI frame = new WarGameGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
      
   }



}