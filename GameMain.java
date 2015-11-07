/**
 * Authors: James Dinh and Zachary Berg
 *
 * This game pits three players, one human and two AI, in a battle to reach 100
 * QP the fastest. The game will follow the three players through the first four
 * years of their undergraduate study.
 */
package cecs343_bs_in_cs;

/**
 * The main class, which is responsible for coordinating all the components
 */
public class GameMain {

    // Master location to control the name of the game and the image file
    private static String gameName = "BS in CS";

    //James Image File Location
    private static String imageFileName = "src/cecs343_bs_in_cs/CSULBMap3.png";

   //Zach Image File Location
//   private static String imageFileName = "src/CSULBMap3.png";

    public static void main(String[] args) {

        GameModel model = GameModel.getInstance();
        GameView view = new GameView(gameName, imageFileName, model);

        view.createGameBoard();   // Used to set up the frame
    }
}
