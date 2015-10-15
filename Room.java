package cecs343_bs_in_cs;
import java.util.*;

public class Room {
	
	private String roomName;
	private int roomNumber;
	int xPosition, yPosition;
	private List<Integer> listOfAdjacentRooms;
	
	public Room() {
		roomName = "";
		roomNumber = 0;
	}
	
	public Room(String name, int number, int x, int y, 
					List<Integer> adjacentRooms) {
		roomName = name;
		roomNumber = number;
		xPosition = x;
		yPosition = y;
		
		listOfAdjacentRooms = adjacentRooms;

	}
	
	public void DisplayAdjacentRoom() {
		
	}
	
	public void setAdjacentRooms() {
		
	}

}
