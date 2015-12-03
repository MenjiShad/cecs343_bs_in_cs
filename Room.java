package cecs343_bs_in_cs;

import java.util.*;

public class Room {

	private String roomName;
	private int roomNumber, xPosition, yPosition;
	private List<Integer> listOfAdjacentRooms;

	public Room() {
		roomName = "";
		roomNumber = 0;
	}

	public Room(String name, int number, int x, int y, List<Integer> adjacentRooms) {
		roomName = name;
		roomNumber = number;
		xPosition = x;
		yPosition = y;
		this.listOfAdjacentRooms = adjacentRooms;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public String getRoomName() {
		return roomName;
	}

	public int getRoomX() {
		return xPosition;
	}

	public int getRoomY() {
		return yPosition;
	}

	public List<Integer> getListOfAdjacentRooms() {
		return listOfAdjacentRooms;
	}

	public void setListOfAdjacentRooms(List<Integer> listOfAdjacentRooms) {
		this.listOfAdjacentRooms = listOfAdjacentRooms;
	}

	@Override
	public String toString() {
		return getRoomName();
	}

	@Override
	public boolean equals(Object other) {
		// If the other object is null, not equal
		if (other == null)
			return false;

		// If the objects are two different types, not equal
		if (other.getClass() != this.getClass())
			return false;

		// If the Room Names are the same, it's the same Room
		return this.roomName.equals(((Room) other).roomName);
	}

	@Override
	public int hashCode() {
		if (this == null)
			return 0;
		int hash = 7;
		hash = 17 * hash + Objects.hashCode(this.roomName);
		hash = 17 * hash + this.roomNumber;
		return hash;
	}
}
