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
		
		setListOfAdjecentRooms(adjecentRooms);

	}
	
	public int GetRoomNumber() {
		return  roomNumber;
	}
	
	public String getRoomName() {
		return roomName;
	}
	
	public void DisplayAdjectentRoom() {
		
	}

	public List<Integer> getListOfAdjecentRooms() {
		return listOfAdjecentRooms;
	}

	public void setListOfAdjecentRooms(List<Integer> listOfAdjecentRooms) {
		this.listOfAdjecentRooms = listOfAdjecentRooms;
	}

}
