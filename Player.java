package cecs343_bs_in_cs;

import java.util.ArrayList;

public class Player {

    private String name;
    private int playerNumber;
    private Room currentRoom;
    private int qualityPoint;
    private int learningChip;
    private int integrityChip;
    private int craftChip;
    private ArrayList<GameCard> handOfCards;
    private int handCount;
    private static GameModel model;

    // default constructor
    public Player() {}

    public Player(String name, int playerNumber, Room startingRoom,
            int initialLearning, int initialIntegrity, int initialCraft) {
        this.name = name;
        this.playerNumber = playerNumber;
        currentRoom = startingRoom;
        learningChip = initialLearning;
        integrityChip = initialIntegrity;
        craftChip = initialCraft;
        //Create first 5 cards to hand     
    }

    public String getStudentName() {
        return name;
    }

    @Override
    public String toString() {
        return "\n" + name + " is in " + currentRoom;
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

    public int getLearningChips() {
        return learningChip;
    }
    
    public int getCraftChips() {
        return craftChip;
    }
    
    public int getIntegrityChips() {
        return integrityChip;
    }
    public void updateQP(int pointUpdate) {
        qualityPoint += pointUpdate;
    }

    public void updateSkillChip(int learningUpdate, int craftUpdate,
            int integrityUpdate) {
        learningChip += learningUpdate;
        craftChip += craftUpdate;
        integrityChip += integrityUpdate;
    }

    public void playCard(GameCard card) {
        card.play(this, model);
        // Discard card afterwards
    }

}
