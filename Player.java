import java.util.Arrays;
import java.util.List;

//package cecs343_bs_in_cs;

public class Player {

	private String name;
	private String description;
	private String rank;
	private Room currentRoom;
	private int qualityPoint;
	private int learningChip;
	private int integrityChip;
	private int craftChip;
	private Deck handOfCards;
	private int handCount;
	
	// default constructor
	public Player() {
		List<Integer> listOfAdjecentRooms17 = Arrays.asList(15);
		currentRoom = new Room("ECS 308", 17, 1127, 1399, listOfAdjecentRooms17);
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
		return "\n" + name + "\n" + description + "\n" + rank;
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
