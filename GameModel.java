/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecs343_bs_in_cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author James
 */

public class GameModel {
    
    private Player HumanPlayer;
    private Player AIPlayerOne;
    private Player AIPlayerTwo;
    private List<Room> listOfRooms;

    public GameModel() {
        HumanPlayer = new Player("Matt", 0);
        AIPlayerOne = new Player("Tony", 1);
        AIPlayerTwo = new Player("Derek", 2);
        listOfRooms = new ArrayList<Room>();
        createRooms();
    }
    public Player getPlayer(PlayerNumber pNumber) {
        if (pNumber == PlayerNumber.Human)
            return HumanPlayer;
        else if (pNumber == PlayerNumber.AI1)
            return AIPlayerOne;
        else
            return AIPlayerTwo;
    }
    
    public void createRooms() {

        List<Integer> listOfAdjacentRooms0 = Arrays.asList(1, 3, 4, 5);
        List<Integer> listOfAdjacentRooms1 = Arrays.asList(0, 2, 3);
        List<Integer> listOfAdjacentRooms2 = Arrays.asList(1, 3, 4, 6);
        List<Integer> listOfAdjacentRooms3 = Arrays.asList(0, 1, 2, 4, 5, 6);
        List<Integer> listOfAdjacentRooms4 = Arrays.asList(0, 5, 7, 12);
        List<Integer> listOfAdjacentRooms5 = Arrays.asList(0, 2, 3, 4, 6);
        List<Integer> listOfAdjacentRooms6 = Arrays.asList(2, 3, 5, 10);
        List<Integer> listOfAdjacentRooms7 = Arrays.asList(4, 8);
        List<Integer> listOfAdjacentRooms8 = Arrays.asList(7, 9);
        List<Integer> listOfAdjacentRooms9 = Arrays.asList(8, 10);
        List<Integer> listOfAdjacentRooms10 = Arrays.asList(6, 9, 15);
        List<Integer> listOfAdjacentRooms11 = Arrays.asList(12);
        List<Integer> listOfAdjacentRooms12 = Arrays.asList(4, 11, 13, 14, 15, 16);
        List<Integer> listOfAdjacentRooms13 = Arrays.asList(12);
        List<Integer> listOfAdjacentRooms14 = Arrays.asList(12, 15);
        List<Integer> listOfAdjacentRooms15 = Arrays.asList(10, 12, 14, 17, 18, 19, 20);
        List<Integer> listOfAdjacentRooms16 = Arrays.asList(12);
        List<Integer> listOfAdjacentRooms17 = Arrays.asList(15);
        List<Integer> listOfAdjacentRooms18 = Arrays.asList(15);
        List<Integer> listOfAdjacentRooms19 = Arrays.asList(15);
        List<Integer> listOfAdjacentRooms20 = Arrays.asList(15);

        listOfRooms.add(new Room("Geroge Allen Field", 0, 271, 56, listOfAdjacentRooms0));
        listOfRooms.add(new Room("Japanese Garden", 1, 698, 45, listOfAdjacentRooms1));
        listOfRooms.add(new Room("Student Parking", 2, 1284, 94, listOfAdjacentRooms2));
        listOfRooms.add(new Room("The Pyramid", 3, 669, 292, listOfAdjacentRooms3));
        listOfRooms.add(new Room("West Walkway", 4, 246, 666, listOfAdjacentRooms4));
        listOfRooms.add(new Room("Health/Rec Center", 5, 708, 576, listOfAdjacentRooms5));
        listOfRooms.add(new Room("Forbidden Parking", 6, 1287, 586, listOfAdjacentRooms6));
        listOfRooms.add(new Room("Library", 7, 283, 1729, listOfAdjacentRooms7));
        listOfRooms.add(new Room("LA 5", 8, 712, 1638, listOfAdjacentRooms8));
        listOfRooms.add(new Room("Bratwurst Hall", 9, 1252, 1646, listOfAdjacentRooms9));
        listOfRooms.add(new Room("East Walkway", 10, 1692, 975, listOfAdjacentRooms10));
        listOfRooms.add(new Room("Computer Lab", 11, 422, 897, listOfAdjacentRooms11));
        listOfRooms.add(new Room("North Hall", 12, 427, 1164, listOfAdjacentRooms12));
        listOfRooms.add(new Room("Room of Retirement", 13, 437, 1367, listOfAdjacentRooms13));
        listOfRooms.add(new Room("ECS 302", 14, 853, 869, listOfAdjacentRooms14));
        listOfRooms.add(new Room("South Hall", 15, 1068, 1172, listOfAdjacentRooms15));
        listOfRooms.add(new Room("Elevators", 16, 829, 1385, listOfAdjacentRooms16));
        listOfRooms.add(new Room("ECS 308", 17, 1127, 1399, listOfAdjacentRooms17));
        listOfRooms.add(new Room("EAT Club", 18, 1263, 888, listOfAdjacentRooms18));
        listOfRooms.add(new Room("CECS Conference Room", 19, 1481, 891, listOfAdjacentRooms19));
        listOfRooms.add(new Room("Lactation Lounge", 20, 1447, 1410, listOfAdjacentRooms20));
    }
}
