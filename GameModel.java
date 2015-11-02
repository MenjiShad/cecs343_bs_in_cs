package cecs343_bs_in_cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The model class of the MVC scheme for the BS in CS game
 * Holds instances of the 3 players and the Rooms
 */
public class GameModel {

    private Player HumanPlayer;
    private Player AIPlayerOne;
    private Player AIPlayerTwo;
    private List<Room> listOfRooms;
    private Deck cardDeck;

    public GameModel() {
        listOfRooms = new ArrayList<>();
        createRooms();
        
        HumanPlayer = new Player("Matt", 0, listOfRooms.get(17));
        AIPlayerOne = new Player("Tony", 1, listOfRooms.get(17));
        AIPlayerTwo = new Player("Derek", 2, listOfRooms.get(17));
    }

    public Player getPlayer(PlayerNumber pNumber) {
        if (pNumber == PlayerNumber.HUMAN) 
            return HumanPlayer;
        else if (pNumber == PlayerNumber.AI1) 
            return AIPlayerOne;
        else 
            return AIPlayerTwo;
        
    }

    public List<Room> getListOfRooms() {
        return listOfRooms;
    }

    private void createRooms() {

    	//List of adjecent room numbers for each room
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

        //Creates each room along with their adjecent rooms
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
    
}
