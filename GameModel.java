package cecs343_bs_in_cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * The model class of the MVC scheme for the BS in CS game Holds instances of
 * the 3 players, the Rooms, and the Deck
 */
public class GameModel {

    private static GameModel model = new GameModel();
    private Player HumanPlayer;
    private Player AIPlayer1;
    private Player AIPlayer2;
    private static List<Room> listOfRooms;
    private Deck cardDeck;

    private GameModel() {
        
        // Initialize Rooms
        listOfRooms = new ArrayList<>();
        createRooms();
        
        // Initalize Deck
    	cardDeck = new Deck(listOfRooms);
    	cardDeck.shuffle();

        // Initialize Players
        createPlayers();
    }

    // Limit GameModel to a single instance
    public static GameModel getInstance() {
        if (model == null) {
            model = new GameModel();
        }
        return model;
    }

    public Player getPlayer(PlayerNumber pNumber) {
        if (pNumber == PlayerNumber.HUMAN) 
            return HumanPlayer;
        else if (pNumber == PlayerNumber.AI1) 
            return AIPlayer1;
        else 
            return AIPlayer2;     
    }

    public static List<Room> getListOfRooms() {
        return listOfRooms;
    }

    private void createRooms() {

        //List of adjacent room numbers for each room
        List<Integer> listOfAdjacentRooms0 = Arrays.asList(1, 3, 4, 5);
        List<Integer> listOfAdjacentRooms1 = Arrays.asList(0, 2, 3);
        List<Integer> listOfAdjacentRooms2 = Arrays.asList(1, 3, 5, 6);
        List<Integer> listOfAdjacentRooms3 = Arrays.asList(0, 1, 2, 4, 5, 6);
        List<Integer> listOfAdjacentRooms4 = Arrays.asList(0, 5, 7, 12);
        List<Integer> listOfAdjacentRooms5 = Arrays.asList(0, 2, 3, 4, 6);
        List<Integer> listOfAdjacentRooms6 = Arrays.asList(2, 5, 10);
        List<Integer> listOfAdjacentRooms7 = Arrays.asList(4, 8);
        List<Integer> listOfAdjacentRooms8 = Arrays.asList(7, 9);
        List<Integer> listOfAdjacentRooms9 = Arrays.asList(8, 10);
        List<Integer> listOfAdjacentRooms10 = Arrays.asList(6, 9, 15);
        List<Integer> listOfAdjacentRooms11 = Arrays.asList(12);
        List<Integer> listOfAdjacentRooms12 = Arrays.asList(4, 11, 13, 14, 15, 16);
        List<Integer> listOfAdjacentRooms13 = Arrays.asList(12);
        List<Integer> listOfAdjacentRooms14 = Arrays.asList(12, 15);
        List<Integer> listOfAdjacentRooms15 = Arrays.asList(10, 12, 14, 17, 18, 19, 20);
        List<Integer> listOfAdjacentRooms16 = Arrays.asList(12);
        List<Integer> listOfAdjacentRooms17 = Arrays.asList(15);
        List<Integer> listOfAdjacentRooms18 = Arrays.asList(15);
        List<Integer> listOfAdjacentRooms19 = Arrays.asList(15);
        List<Integer> listOfAdjacentRooms20 = Arrays.asList(15);

        //Creates each room along with their adjacent rooms
        listOfRooms.add(new Room("Geroge Allen Field", 0, 75, 100, listOfAdjacentRooms0));
        listOfRooms.add(new Room("Japanese Garden", 1, 500, 95, listOfAdjacentRooms1));
        listOfRooms.add(new Room("Student Parking", 2, 1085, 95, listOfAdjacentRooms2));
        listOfRooms.add(new Room("The Pyramid", 3, 470, 310, listOfAdjacentRooms3));
        listOfRooms.add(new Room("West Walkway", 4, 30, 675, listOfAdjacentRooms4));
        listOfRooms.add(new Room("Health/Rec Center", 5, 500, 600, listOfAdjacentRooms5));
        listOfRooms.add(new Room("Forbidden Parking", 6, 1085, 600, listOfAdjacentRooms6));
        listOfRooms.add(new Room("Library", 7, 30, 1745, listOfAdjacentRooms7));
        listOfRooms.add(new Room("LA 5", 8, 515, 1820, listOfAdjacentRooms8));
        listOfRooms.add(new Room("Bratwurst Hall", 9, 1150, 1750, listOfAdjacentRooms9));
        listOfRooms.add(new Room("East Walkway", 10, 1470, 975, listOfAdjacentRooms10));
        listOfRooms.add(new Room("Computer Lab", 11, 175, 910, listOfAdjacentRooms11));
        listOfRooms.add(new Room("North Hall", 12, 227, 1175, listOfAdjacentRooms12));
        listOfRooms.add(new Room("Room of Retirement", 13, 200, 1375, listOfAdjacentRooms13));
        listOfRooms.add(new Room("ECS 302", 14, 600, 910, listOfAdjacentRooms14));
        listOfRooms.add(new Room("South Hall", 15, 850, 1175, listOfAdjacentRooms15));
        listOfRooms.add(new Room("Elevators", 16, 600, 1400, listOfAdjacentRooms16));
        listOfRooms.add(new Room("ECS 308", 17, 850, 1375, listOfAdjacentRooms17));
        listOfRooms.add(new Room("EAT Club", 18, 1050, 910, listOfAdjacentRooms18));
        listOfRooms.add(new Room("CECS Conference Room", 19, 1250, 910, listOfAdjacentRooms19));
        listOfRooms.add(new Room("Lactation Lounge", 20, 1210, 1425, listOfAdjacentRooms20));
    }

    private void createPlayers() {
        // Initialize players
        int initialLearning;
        int initialIntegrity;
        int initialCraft;

        // Initial stats for Player 1
        initialLearning = 2;
        initialIntegrity = 2;
        initialCraft = 2;
        Player Player1 = new Player("Matt", 0, listOfRooms.get(17),
                initialLearning, initialIntegrity, initialCraft);

        // Initial stats for Player 2
        initialLearning = 3;
        initialIntegrity = 1;
        initialCraft = 2;
        Player Player2 = new Player("Tony", 1, listOfRooms.get(17),
                initialLearning, initialIntegrity, initialCraft);

        // Initial stats for Player 3
        initialLearning = 0;
        initialIntegrity = 3;
        initialCraft = 3;
        Player Player3 = new Player("Derek", 2, listOfRooms.get(17),
                initialLearning, initialIntegrity, initialCraft);

        Player[] playerTokenArray = new Player[]{Player1, Player2, Player3};
        shuffleArray(playerTokenArray);   // Randomize the tokens

        // Assign randomized tokens to each player
        HumanPlayer = playerTokenArray[0];
        AIPlayer1 = playerTokenArray[1];
        AIPlayer2 = playerTokenArray[2];
        
        for (int i = 0; i < 5; i++) {
            HumanPlayer.addCardToHand(cardDeck);
        }
    }
    
    public GameCard drawCardFromDeck() {
        return cardDeck.drawCard();
    }
    
    /**
     * Implemented the Knuth Shuffle to shuffle a small array
     *
     * @param arr - Player array to shuffle
     */
    private void shuffleArray(Player[] arr) {

        Random rng = new Random(System.currentTimeMillis());

        for (int i = arr.length - 1; i > 0; i--) {
            int index = rng.nextInt(i + 1);

            // Swap
            Player player = arr[index];
            arr[index] = arr[i];
            arr[i] = player;
        }
    }
    
    public Deck getCardDeck() {
    	return cardDeck;
    }
    
    public GameCard AITurn(Player AIPlayer) {
        AIMove(AIPlayer);
        return AIPlay(AIPlayer);
    }
    
    private void AIMove(Player AIPlayer) {
        Random rng = new Random(System.currentTimeMillis());
        int moveLimit = 3;
        
        // AI will randomly move 0-3 rooms
        int AIMoveCount = rng.nextInt(moveLimit + 1);
        
        // Call the RandomMove function as many times as the AIMoveCount
        for (int i = 0; i < AIMoveCount; i++) {
            AIRandomRoomMove(AIPlayer, rng);
        }
    }
    
    private void AIRandomRoomMove(Player AIPlayer, Random rng) {
        // Randomly select one of the adjacent Rooms
        int randAdjRoomSelect = rng.nextInt(AIPlayer.getCurrentRoom()
                .getListOfAdjacentRooms().size());
        
        // Move AIPlayer to adjacent room
        AIPlayer.setCurrentRoom(listOfRooms.get(AIPlayer.getCurrentRoom()
                .getListOfAdjacentRooms().get(randAdjRoomSelect)));
    }
    
    private GameCard AIPlay(Player AIPlayer) {
        // The first card the AIPlayer encounters,
        // whose valid Room matches the AI's, will be played by the AI
        GameCard AIPlayedCard = null;
        for (int i = cardDeck.getListOfCards().size() - 1; i >= 0; i--) {
            for (Room validRoom : cardDeck.getListOfCards().get(i).getValidRooms()) {
                if (AIPlayer.getCurrentRoom().equals(validRoom)) {
                    AIPlayedCard = cardDeck.getListOfCards().get(i);
                    AIPlayer.playCard(AIPlayedCard);
                    break;
                }
            }
        }
        
        // If there are no GameCards that match the AI's Room,
        // play the top of the deck
        if (AIPlayedCard == null) {
            AIPlayedCard = cardDeck.getListOfCards().get(cardDeck.getListOfCards().size() - 1);
            AIPlayer.playCard(AIPlayedCard);
        }
        return AIPlayedCard;
    }
}
