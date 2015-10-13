import java.util.*;

public class Room {
	
	private String roomName;
	private int roomNumber;
	int xPosition, yPosition;
	private List<Integer> listOfAdjecentRooms;
	
	public Room() {
		roomName = "";
		roomNumber = 0;
	}
	
	public Room(String name, int number, int x, int y, 
					List<Integer> adjecentRooms) {
		roomName = name;
		roomNumber = number;
		xPosition = x;
		yPosition = y;
		
		listOfAdjecentRooms = adjecentRooms;

	}
	
	public void DisplayAdjectentRoom() {
		
	}
	
	public void setAdjecentRooms() {
		
	}

}
