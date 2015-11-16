package cecs343_bs_in_cs;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

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
        handOfCards = new ArrayList<>();
            
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

    public int getQualityPoints() {
        return qualityPoint;
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
        card.play(this);
        // Discard card afterwards
        discardGameCard(card);
    }

    public void discardGameCard() {
        //Open dialog box to allow player to discard
    }

    /**
     * Discard a GameCard that has been played
     *
     * @param card - GameCard to be discarded
     */
    public void discardGameCard(GameCard card) {
        // Remove specific card
        GameModel.getInstance().getCardDeck().addToDiscard(card);
        getHandOfCards().remove(card);
    }

    public void chooseChip(Object[] selectionValue, String message) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        Object[] selectionValues = {"Learning", "Craft"};
        String initialSelection = "Learning";
        Object selection = JOptionPane.showInputDialog(null, message,
                "Choice", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        //System.out.println(selection);
        if (selection == "Learning") {
            this.updateSkillChip(1, 0, 0);
        } else if (selection == "Craft") {
            this.updateSkillChip(0, 1, 0);
        } else {
            this.updateSkillChip(0, 0, 1);
        }
    }

    public void addCardToHand(Deck cardDeck) {	
        handOfCards.add(cardDeck.drawCard());
    }

    public ArrayList<GameCard> getHandOfCards() {
        return handOfCards;
    }

}
