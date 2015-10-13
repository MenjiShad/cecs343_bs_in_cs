
public class Player {

	private String name;
	private String description;
	private String rank;
	private int qualityPoint;
	private int learningChip;
	private int integrityChip;
	private int craftChip;
	private Deck handOfCards;
	private int handCount;
	
	// default constructor
	public Player() {
		
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
