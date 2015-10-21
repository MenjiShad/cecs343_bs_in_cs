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
            List<Integer> adjecentRooms) {
        roomName = name;
        roomNumber = number;
        xPosition = x;
        yPosition = y;

        setListOfAdjacentRooms(adjecentRooms);

    }

    public int GetRoomNumber() {
        return roomNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public void DisplayAdjacentRoom() {

    }

    public List<Integer> getListOfAdjacentRooms() {
        return listOfAdjacentRooms;
    }

    public void setListOfAdjacentRooms(List<Integer> listOfAdjacentRooms) {
        this.listOfAdjacentRooms = listOfAdjacentRooms;
    }

}
