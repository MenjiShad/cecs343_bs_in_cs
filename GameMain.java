/**
 * Authors: James Dinh
 * 
 * This game pits three players, one human and two AI, in a battle to reach
 * 100 QP the fastest. The game will follow the three players through the first
 * four years of their undergraduate study.
 */
package cecs343_bs_in_cs;

/**
 * The main class, which is responsible for coordinating all the components
 */
public class GameMain {

   // Master location to control the name of the game and the image file
   private static String gameName = "BS in CS";
   private static String imageFileName = "src/cecs343_bs_in_cs/CSULBMap3.png";
   // For the imageFileName, make sure to use your path, which may or may not be
   // the same as mine.
   
   public static void main(String[] args) {
      
      GameView view = new GameView(gameName, imageFileName);
      
      view.createGameBoard();   // Used to set up the frame
      view.updateGameBoard();
   }
}