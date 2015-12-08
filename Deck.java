package cecs343_bs_in_cs;

import java.util.*;

public class Deck {

    private ArrayList<GameCard> listOfCards;
    private ArrayList<GameCard> listOfDiscardedCards;
	//private List<GameCard> listOfDisabledCards;

	/**
	 * Non-Default Constructor
	 * Creates a list of cards and discarded cards
	 *
	 * @param listOfRooms
	 * 					 - a list of all the Rooms 
	 * 				 
	 */
    public Deck(List<Room> listOfRooms) {

    	//Initialize ArrayLists
        listOfCards = new ArrayList<>(40);
        listOfDiscardedCards = new ArrayList<>(40);

        //Initialize the valid rooms for each game card
        Room[] validRoomsGC1 = {listOfRooms.get(14), listOfRooms.get(17)};
        Room[] validRoomsGC2 = {listOfRooms.get(7)};
        Room[] validRoomsGC3 = {listOfRooms.get(7)};
        Room[] validRoomsGC4 = {listOfRooms.get(14)};
        Room[] validRoomsGC5 = {listOfRooms.get(9)};
        Room[] validRoomsGC6 = {listOfRooms.get(17)};
        Room[] validRoomsGC7 = {listOfRooms.get(5)};
        Room[] validRoomsGC8 = {listOfRooms.get(6)};
        Room[] validRoomsGC9 = {listOfRooms.get(16)};
        Room[] validRoomsGC10 = {listOfRooms.get(13)};
        Room[] validRoomsGC11 = {listOfRooms.get(1)};
        Room[] validRoomsGC12 = {listOfRooms.get(18), listOfRooms.get(0)};
        Room[] validRoomsGC13 = {listOfRooms.get(0), listOfRooms.get(1),
            listOfRooms.get(2), listOfRooms.get(3),
            listOfRooms.get(4), listOfRooms.get(5),
            listOfRooms.get(7), listOfRooms.get(8),
            listOfRooms.get(9), listOfRooms.get(10)};
        Room[] validRoomsGC14 = {listOfRooms.get(17)};
        Room[] validRoomsGC15 = {listOfRooms.get(3)};
        Room[] validRoomsGC16 = {listOfRooms.get(0)};
        Room[] validRoomsGC17 = {listOfRooms.get(14), listOfRooms.get(17)};
        Room[] validRoomsGC18 = {listOfRooms.get(20)};
        Room[] validRoomsGC19 = {listOfRooms.get(19)};
        Room[] validRoomsGC20 = {listOfRooms.get(0)};
        Room[] validRoomsGC21 = {listOfRooms.get(0)};
        Room[] validRoomsGC22 = {listOfRooms.get(1)};
        Room[] validRoomsGC23 = {listOfRooms.get(12), listOfRooms.get(15)};
        Room[] validRoomsGC24 = {listOfRooms.get(11)};
        Room[] validRoomsGC25 = {listOfRooms.get(12), listOfRooms.get(15)};
        Room[] validRoomsGC26 = {listOfRooms.get(18)};
        Room[] validRoomsGC27 = {listOfRooms.get(20)};
        Room[] validRoomsGC28 = {listOfRooms.get(19)};
        Room[] validRoomsGC29 = {listOfRooms.get(16)};
        Room[] validRoomsGC30 = {listOfRooms.get(0)};
        Room[] validRoomsGC31 = {listOfRooms.get(7)};
        Room[] validRoomsGC32 = {listOfRooms.get(3), listOfRooms.get(2),
            listOfRooms.get(5), listOfRooms.get(7),
            listOfRooms.get(8), listOfRooms.get(9)};
        Room[] validRoomsGC33 = {listOfRooms.get(11), listOfRooms.get(12),
            listOfRooms.get(13), listOfRooms.get(14),
            listOfRooms.get(15), listOfRooms.get(16),
            listOfRooms.get(17), listOfRooms.get(18),
            listOfRooms.get(19)};
        Room[] validRoomsGC34 = {listOfRooms.get(3), listOfRooms.get(2),
            listOfRooms.get(5), listOfRooms.get(7),
            listOfRooms.get(8), listOfRooms.get(9)};
        Room[] validRoomsGC35 = {listOfRooms.get(0), listOfRooms.get(1),
            listOfRooms.get(2), listOfRooms.get(3),
            listOfRooms.get(4), listOfRooms.get(5),
            listOfRooms.get(7), listOfRooms.get(8),
            listOfRooms.get(9), listOfRooms.get(10)};
        Room[] validRoomsGC36 = {listOfRooms.get(11)};
        Room[] validRoomsGC37 = {listOfRooms.get(12), listOfRooms.get(15)};
        Room[] validRoomsGC38 = {listOfRooms.get(0), listOfRooms.get(1),
            listOfRooms.get(2), listOfRooms.get(3),
            listOfRooms.get(4), listOfRooms.get(5),
            listOfRooms.get(7), listOfRooms.get(8),
            listOfRooms.get(9), listOfRooms.get(10),
            listOfRooms.get(6)};
        Room[] validRoomsGC39 = {listOfRooms.get(2)};

        //Creates game card images
        GameCard gameCard1 = new GameCard1("CECS 105", "src/cecs343_bs_in_cs/pictures/1.png", validRoomsGC1);
        GameCard gameCard2 = new GameCard2("Research Compilers", "src/cecs343_bs_in_cs/pictures/2.png", validRoomsGC2);
        GameCard gameCard3 = new GameCard3("Math 122", "src/cecs343_bs_in_cs/pictures/3.png", validRoomsGC3);
        GameCard gameCard4 = new GameCard4("Professor Murgolo's CECS 174 Class", "src/cecs343_bs_in_cs/pictures/4.png", validRoomsGC4);
        GameCard gameCard5 = new GameCard5("Lunch at Brawtwurst Hall", "src/cecs343_bs_in_cs/pictures/5.png", validRoomsGC5);
        GameCard gameCard6 = new GameCard6("CECS 100", "src/cecs343_bs_in_cs/pictures/6.png", validRoomsGC6);
        GameCard gameCard7 = new GameCard7("Exercising Mind and Body", "src/cecs343_bs_in_cs/pictures/7.png", validRoomsGC7);
        GameCard gameCard8 = new GameCard8("Parking Violation", "src/cecs343_bs_in_cs/pictures/8.png", validRoomsGC8);
        GameCard gameCard9 = new GameCard9("Finding the Lab", "src/cecs343_bs_in_cs/pictures/9.png", validRoomsGC9);
        GameCard gameCard10 = new GameCard10("Goodbye, Professor", "src/cecs343_bs_in_cs/pictures/10.png", validRoomsGC10);
        GameCard gameCard11 = new GameCard11("Enjoying the Peace", "src/cecs343_bs_in_cs/pictures/11.png", validRoomsGC11);
        GameCard gameCard12 = new GameCard12("Buddy Up", "src/cecs343_bs_in_cs/pictures/12.png", validRoomsGC12);
        GameCard gameCard13 = new GameCard13("Late for Class", "src/cecs343_bs_in_cs/pictures/13.png", validRoomsGC13);
        GameCard gameCard14 = new GameCard14("Physics 151", "src/cecs343_bs_in_cs/pictures/14.png", validRoomsGC14);
        GameCard gameCard15 = new GameCard15("The Big Game", "src/cecs343_bs_in_cs/pictures/15.png", validRoomsGC15);
        GameCard gameCard16 = new GameCard16("KIN 253 Learning the Rules of Soccer", "src/cecs343_bs_in_cs/pictures/16.png", validRoomsGC16);
        GameCard gameCard17 = new GameCard17("Math 123", "src/cecs343_bs_in_cs/pictures/17.png", validRoomsGC17);
        GameCard gameCard18 = new GameCard18("Learning Netbeans", "src/cecs343_bs_in_cs/pictures/18.png", validRoomsGC18);
        GameCard gameCard19 = new GameCard19("Choosing a Major", "src/cecs343_bs_in_cs/pictures/19.png", validRoomsGC19);
        GameCard gameCard20 = new GameCard20("Pass Soccer Class", "src/cecs343_bs_in_cs/pictures/20.png", validRoomsGC20);
        GameCard gameCard21 = new GameCard21("Score a Goal!", "src/cecs343_bs_in_cs/pictures/21.png", validRoomsGC21);
        GameCard gameCard22 = new GameCard22("Fall in the Pond", "src/cecs343_bs_in_cs/pictures/22.png", validRoomsGC22);
        GameCard gameCard23 = new GameCard23("Make the Dean's List", "src/cecs343_bs_in_cs/pictures/23.png", validRoomsGC23);
        GameCard gameCard24 = new GameCard24("A New Laptop", "src/cecs343_bs_in_cs/pictures/24.png", validRoomsGC24);
        GameCard gameCard25 = new GameCard25("Meet the Dean", "src/cecs343_bs_in_cs/pictures/25.png", validRoomsGC25);
        GameCard gameCard26 = new GameCard26("Loud Buzzing", "src/cecs343_bs_in_cs/pictures/26.png", validRoomsGC26);
        GameCard gameCard27 = new GameCard27("Program Crashes", "src/cecs343_bs_in_cs/pictures/27.png", validRoomsGC27);
        GameCard gameCard28 = new GameCard28("Professor Englert", "src/cecs343_bs_in_cs/pictures/28.png", validRoomsGC28);
        GameCard gameCard29 = new GameCard29("Press the Right Floor", "src/cecs343_bs_in_cs/pictures/29.png", validRoomsGC29);
        GameCard gameCard30 = new GameCard30("Soccer Goalie", "src/cecs343_bs_in_cs/pictures/30.png", validRoomsGC30);
        GameCard gameCard31 = new GameCard31("Elective Class", "src/cecs343_bs_in_cs/pictures/31.png", validRoomsGC31);
        GameCard gameCard32 = new GameCard32("Oral Communication", "src/cecs343_bs_in_cs/pictures/32.png", validRoomsGC32);
        GameCard gameCard33 = new GameCard33("Professor Hoffman", "src/cecs343_bs_in_cs/pictures/33.png", validRoomsGC33);
        GameCard gameCard34 = new GameCard34("CHEM 111", "src/cecs343_bs_in_cs/pictures/34.png", validRoomsGC34);
        GameCard gameCard35 = new GameCard35("The Outpost", "src/cecs343_bs_in_cs/pictures/35.png", validRoomsGC35);
        GameCard gameCard36 = new GameCard36("Learning Linux", "src/cecs343_bs_in_cs/pictures/36.png", validRoomsGC36);
        GameCard gameCard37 = new GameCard37("Make a Friend", "src/cecs343_bs_in_cs/pictures/37.png", validRoomsGC37);
        GameCard gameCard38 = new GameCard38("Enjoying Nature", "src/cecs343_bs_in_cs/pictures/38.png", validRoomsGC38);
        GameCard gameCard39 = new GameCard39("Student Parking", "src/cecs343_bs_in_cs/pictures/39.png", validRoomsGC39);

        //Adds game card images to list of active cards
        listOfCards.add(gameCard1);
        listOfCards.add(gameCard2);
        listOfCards.add(gameCard3);
        listOfCards.add(gameCard4);
        listOfCards.add(gameCard5);
        listOfCards.add(gameCard6);
        listOfCards.add(gameCard7);
        listOfCards.add(gameCard8);
        listOfCards.add(gameCard9);
        listOfCards.add(gameCard10);
        listOfCards.add(gameCard11);
        listOfCards.add(gameCard12);
        listOfCards.add(gameCard13);
        listOfCards.add(gameCard14);
        listOfCards.add(gameCard15);
        listOfCards.add(gameCard16);
        listOfCards.add(gameCard17);
        listOfCards.add(gameCard18);
        listOfCards.add(gameCard19);
        listOfCards.add(gameCard20);
        listOfCards.add(gameCard21);
        listOfCards.add(gameCard22);
        listOfCards.add(gameCard23);
        listOfCards.add(gameCard24);
        listOfCards.add(gameCard25);
        listOfCards.add(gameCard26);
        listOfCards.add(gameCard27);
        listOfCards.add(gameCard28);
        listOfCards.add(gameCard29);
        listOfCards.add(gameCard30);
        listOfCards.add(gameCard31);
        listOfCards.add(gameCard32);
        listOfCards.add(gameCard33);
        listOfCards.add(gameCard34);
        listOfCards.add(gameCard35);
        listOfCards.add(gameCard36);
        listOfCards.add(gameCard37);
        listOfCards.add(gameCard38);
        listOfCards.add(gameCard39);

    }
    
	/**
	 * Method for adding year 2 cards to deck
	 *
	 * @param None
	 * 				 
	 */
    public void addNewCards(List<Room> listOfRooms) {
    	
    	Room[] validRoomsGC40 = {listOfRooms.get(14), listOfRooms.get(17), listOfRooms.get(11)};
        Room[] validRoomsGC41 = {listOfRooms.get(14), listOfRooms.get(17), listOfRooms.get(11)};
        Room[] validRoomsGC42 = {listOfRooms.get(11), listOfRooms.get(12),
                listOfRooms.get(13), listOfRooms.get(14),
                listOfRooms.get(15), listOfRooms.get(16),
                listOfRooms.get(17), listOfRooms.get(18),
                listOfRooms.get(19)};
        Room[] validRoomsGC43 = {listOfRooms.get(14), listOfRooms.get(17), listOfRooms.get(11)};
        Room[] validRoomsGC44 = {listOfRooms.get(18), listOfRooms.get(1)};
        Room[] validRoomsGC45 = {listOfRooms.get(11), listOfRooms.get(12),
                listOfRooms.get(13), listOfRooms.get(14),
                listOfRooms.get(15), listOfRooms.get(16),
                listOfRooms.get(17), listOfRooms.get(18),
                listOfRooms.get(19)};
        Room[] validRoomsGC46 = {listOfRooms.get(7), listOfRooms.get(8)};
        Room[] validRoomsGC47 = {listOfRooms.get(8)};
        Room[] validRoomsGC48 = {listOfRooms.get(7), listOfRooms.get(8)};
        Room[] validRoomsGC49 = {listOfRooms.get(3)};
        Room[] validRoomsGC50 = {listOfRooms.get(2), listOfRooms.get(6)};
        Room[] validRoomsGC51 = {listOfRooms.get(5)};
    	
    	GameCard gameCard40 = new GameCard40("CECS 274", "src/cecs343_bs_in_cs/pictures/40.png", validRoomsGC40);
        GameCard gameCard41 = new GameCard41("CECS 201", "src/cecs343_bs_in_cs/pictures/41.png", validRoomsGC41);
        GameCard gameCard42 = new GameCard42("CECS 277", "src/cecs343_bs_in_cs/pictures/42.png", validRoomsGC42);
        GameCard gameCard43 = new GameCard43("CECS 228", "src/cecs343_bs_in_cs/pictures/43.png", validRoomsGC43);
        GameCard gameCard44 = new GameCard44("CECS 285", "src/cecs343_bs_in_cs/pictures/44.png", validRoomsGC44);
        GameCard gameCard45 = new GameCard45("CECS 282", "src/cecs343_bs_in_cs/pictures/45.png", validRoomsGC45);
        GameCard gameCard46 = new GameCard46("PHIL 270", "src/cecs343_bs_in_cs/pictures/46.png", validRoomsGC46);
        GameCard gameCard47 = new GameCard47("ENGL 317", "src/cecs343_bs_in_cs/pictures/47.png", validRoomsGC47);
        GameCard gameCard48 = new GameCard48("PHYS 152", "src/cecs343_bs_in_cs/pictures/48.png", validRoomsGC48);
        GameCard gameCard49 = new GameCard42("LBSU vs UCI", "src/cecs343_bs_in_cs/pictures/49.png", validRoomsGC49);
        GameCard gameCard50 = new GameCard50("Car Pool", "src/cecs343_bs_in_cs/pictures/50.png", validRoomsGC50);
        GameCard gameCard51 = new GameCard51("Have a Swim", "src/cecs343_bs_in_cs/pictures/51.png", validRoomsGC51);
    	
    	listOfCards.add(gameCard40);
    	listOfCards.add(gameCard41);
    	listOfCards.add(gameCard42);
    	listOfCards.add(gameCard43);
    	listOfCards.add(gameCard44);
    	listOfCards.add(gameCard45);
    	listOfCards.add(gameCard46);
    	listOfCards.add(gameCard47);
    	listOfCards.add(gameCard48);
    	listOfCards.add(gameCard49);
    	listOfCards.add(gameCard50);
    	listOfCards.add(gameCard51);
    	
    }
    
	/**
	 * Method for deleting some year 1 cards from deck
	 *
	 * @param None
	 * 				 
	 */
    public void removeOldCards() {
    	
        listOfCards.remove(5);
     	listOfCards.remove(2);
     	listOfCards.remove(0);
     	listOfCards.remove(16);
     	listOfCards.remove(13);
     	listOfCards.remove(15);
     	listOfCards.remove(19);   
     	listOfCards.remove(30);
     	listOfCards.remove(31);
     	listOfCards.remove(33);
    }

	/**
	 * Method used to shuffle the deck
	 *
	 * @param None
	 * 				 
	 */
    public void shuffle() {
        //Shuffle deck 
        Collections.shuffle(listOfCards, new Random(System.nanoTime()));
    }

	/**
	 * Returns a GameCard to draw from deck
	 *
	 * @param None
	 * 				 
	 */
    public GameCard drawCard() {
        GameCard card = listOfCards.get(listOfCards.size() - 1);
        listOfCards.remove(listOfCards.size() - 1);
        System.out.println("Adding " + card.getCardName() + " to Hand");
        return card;
    }

	/**
	 * Returs the list of all the cards in the deck
	 *
	 * @param None
	 * 				 
	 */
    public ArrayList<GameCard> getListOfCards() {
        return listOfCards;
    }

	/**
	 * Returns a list of all the discarded cards in the deck
	 *
	 * @param None
	 * 				 
	 */
    public ArrayList<GameCard> getListOfDiscardedCards() {
        return listOfDiscardedCards;
    }
    
	/**
	 * Adds a GameCard to the discarded deck
	 *
	 * @param card
	 * 			  - GameCard being discarded
	 * 				 
	 */
    public void addToDiscard(GameCard card) {
        listOfCards.remove(card);
        listOfDiscardedCards.add(card);
    }
    
	/**
	 * Method used to clear the discarded deck
	 *
	 * @param None
	 * 				 
	 */
    public void clearDiscard() {
    	for(int i = 0; i < listOfDiscardedCards.size(); i++){
    		listOfDiscardedCards.remove(i);
		}
    }
     
	/**
	 * Method used to shuffle the discarded deck
	 * 	when the deck runs out of cards
	 *
	 * @param None
	 * 				 
	 */
    public void shuffleDiscardDeck() {
    	System.out.println("\n\nIn shufflediscardmethod\n\n");
        // Removes discarded cards from the top, going downward
        // and places them in the listOfCards, which will then be shuffled
    	for(int i = listOfDiscardedCards.size() - 1; i >= 0; i--) {
    		listOfCards.add(listOfDiscardedCards.get(i));
    		listOfDiscardedCards.remove(i);
    	}
    	shuffle();
    }
}
