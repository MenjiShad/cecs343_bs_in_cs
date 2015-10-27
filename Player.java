//package cecs343_bs_in_cs;

import java.util.ArrayList;
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
    private ArrayList<GameCard> handOfCards;
    private int handCount;

    // default constructor
    public Player() {}

    public Player(String name, int playerNumber, Room startingRoom) {
        this.name = name;
        this.playerNumber = playerNumber;
        currentRoom = startingRoom;
        
        //Create first 5 cards to hand 
        
        
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
    
    public void getHand() {
    	
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
