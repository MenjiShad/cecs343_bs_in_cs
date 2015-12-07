package cecs343_bs_in_cs;

import java.util.*;

/**
 * Author: James Dinh and Zachary Berg
 *
 * This class is responsible for reprersenting the game's rooms
 */
public class Room {

	private String roomName;
	private int roomNumber, xPosition, yPosition;
	private List<Integer> listOfAdjacentRooms;

	/**
	 * Default Constructor
	 *
	 * @param None
	 * 				 
	 */
	public Room() {
		roomName = "";
		roomNumber = 0;
	}

	/**
	 * Non-Default Constructor
	 *
	 * @param name - the rooms name
	 * 	 	  number - the rooms number
	 * 		  x - x-position for where the player name is displayed on the Game Board
	 * 		  y - y-position for where the players name is displayed on the Game Board
	 * 				 
	 */
	public Room(String name, int number, int x, int y, List<Integer> adjacentRooms) {
		roomName = name;
		roomNumber = number;
		xPosition = x;
		yPosition = y;
		this.listOfAdjacentRooms = adjacentRooms;
	}

	/**
	 * Returns the rooms number
	 *
	 * @param None
	 * 				 
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * Returns the rooms name
	 *
	 * @param None
	 * 				 
	 */
	public String getRoomName() {
		return roomName;
	}

	/**
	 * Returns the x-position of the players name 
	 *
	 * @param None
	 * 				 
	 */
	public int getRoomX() {
		return xPosition;
	}

	/**
	 * Returns the y-position of the players name 
	 *
	 * @param None
	 * 				 
	 */
	public int getRoomY() {
		return yPosition;
	}

	/**
	 * Returns the list of adjacent rooms
	 *
	 * @param None
	 * 				 
	 */
	public List<Integer> getListOfAdjacentRooms() {
		return listOfAdjacentRooms;
	}

	/**
	 * Sets the list of adjecent rooms
	 *
	 * @param None
	 * 				 
	 */
	public void setListOfAdjacentRooms(List<Integer> listOfAdjacentRooms) {
		this.listOfAdjacentRooms = listOfAdjacentRooms;
	}

	/**
	 * Returns a true or false if an object equals another
	 *
	 * @param other
	 * 				- object being compared to
	 * 				 
	 */
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

	@SuppressWarnings("unused")
	@Override
	public int hashCode() {
		if (this == null)
			return 0;
		int hash = 7;
		hash = 17 * hash + Objects.hashCode(this.roomName);
		hash = 17 * hash + this.roomNumber;
		return hash;
	}
	
	/**
	 * Returns a string of the room name
	 *
	 * @param None
	 * 				 
	 */
	@Override
	public String toString() {
		return getRoomName();
	}
}
