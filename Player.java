package cecs343_bs_in_cs;

import java.util.Arrays;
import java.util.List;

public class Player {

    private String name;
    private String description;
    private String rank;
    private int playerNumber;
    private Room currentRoom;
    private int qualityPoint;
    private int learningChip;
    private int integrityChip;
    private int craftChip;
    private Deck handOfCards;
    private int handCount;

    // default constructor
    public Player() {
        List<Integer> listOfAdjacentRooms17 = Arrays.asList(15);
        currentRoom = new Room("ECS 308", 17, 1127, 1399, listOfAdjacentRooms17);
    }

    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
        List<Integer> listOfAdjacentRooms17 = Arrays.asList(15);
        currentRoom = new Room("ECS 308", 17, 1127, 1399, listOfAdjacentRooms17);
    }

    public String getStudentName() {
        return name;
    }

    public String getStudentDescription() {
        return description;
    }

    public String getStudentRank() {
        return rank;
    }

    public String toString() {
        return "\n" + name + "\n" + description + "\n" + rank
                + " is in " + currentRoom;
    }

    public void setCurrentRoom(Room newRoom) {
        currentRoom = newRoom;
    }
            
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
    public void move() {

    }

    public void drawCard() {

    }

    public void updateQp() {

    }

    public void updateSkillChip() {

    }

    public void playCard() {

    }

}
