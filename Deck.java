package cecs343_bs_in_cs;
import java.util.*;

public class Deck {
	
	private Stack<GameCard> stackOfCards;
	//private Stack<GameCard> listOfDiscardedCards;
	//private List<GameCard> listOfDisabledCards;
	
	public Deck(List<Room> listOfRooms) {
		
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
				 				 listOfRooms.get(9),listOfRooms.get(10)};
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
				 				 listOfRooms.get(9),listOfRooms.get(10)};
		Room[] validRoomsGC36 = {listOfRooms.get(11)};
		Room[] validRoomsGC37 = {listOfRooms.get(12), listOfRooms.get(15)};
		Room[] validRoomsGC38 = {listOfRooms.get(0), listOfRooms.get(1),
				 				 listOfRooms.get(2), listOfRooms.get(3), 
				 				 listOfRooms.get(4), listOfRooms.get(5),
				 				 listOfRooms.get(7), listOfRooms.get(8), 
				 				 listOfRooms.get(9),listOfRooms.get(10),
				 				 listOfRooms.get(6)};
		Room[] validRoomsGC39 = {listOfRooms.get(2)};
		
		

		//Creates game card images
		GameCard1 gameCard1 = new GameCard1("CECS 105", "src/cecs343_bs_in_cs/picture/1.png", validRoomsGC1);
		GameCard2 gameCard2 = new GameCard2("Research Compilers", "src/cecs343_bs_in_cs/picture/2.png", validRoomsGC2);
		GameCard3 gameCard3 = new GameCard3("Math 122", "src/cecs343_bs_in_cs/picture/3.png", validRoomsGC3);
		GameCard4 gameCard4 = new GameCard4("Professor Murgolo's CECS 174 Class", "src/cecs343_bs_in_cs/picture/4.png", validRoomsGC4);
		GameCard5 gameCard5 = new GameCard5("Lunch at Brawtwurst Hall", "src/cecs343_bs_in_cs/picture/5.png", validRoomsGC5);
		GameCard6 gameCard6 = new GameCard6("CECS 100", "src/cecs343_bs_in_cs/picture/6.png", validRoomsGC6);
		GameCard7 gameCard7 = new GameCard7("Exercising Mind and Body", "src/cecs343_bs_in_cs/picture/7.png", validRoomsGC7);
		GameCard8 gameCard8 = new GameCard8("Parking Violation", "src/cecs343_bs_in_cs/picture/8.png", validRoomsGC8);
		GameCard9 gameCard9 = new GameCard9("Finding the Lab", "src/cecs343_bs_in_cs/picture/9.png", validRoomsGC9);
		GameCard10 gameCard10 = new GameCard10("Goodbye, Professor", "src/cecs343_bs_in_cs/picture/10.png", validRoomsGC10);
		GameCard11 gameCard11 = new GameCard11("Enjoying the Peace", "src/cecs343_bs_in_cs/picture/11.png", validRoomsGC11);
		GameCard12 gameCard12 = new GameCard12("Buddy Up", "src/cecs343_bs_in_cs/picture/12.png", validRoomsGC12);
		GameCard13 gameCard13 = new GameCard13("Late for Class", "src/cecs343_bs_in_cs/picture/13.png", validRoomsGC13);
		GameCard14 gameCard14 = new GameCard14("Physics 151", "src/cecs343_bs_in_cs/picture/14.png", validRoomsGC14);
		GameCard15 gameCard15 = new GameCard15("The Big Game", "src/cecs343_bs_in_cs/picture/15.png", validRoomsGC15);
		GameCard16 gameCard16 = new GameCard16("KIN 253 Learning the Rules of Soccer", "src/cecs343_bs_in_cs/picture/16.png", validRoomsGC16);
		GameCard17 gameCard17 = new GameCard17("Math 123", "src/cecs343_bs_in_cs/picture/17.png", validRoomsGC17);
		GameCard18 gameCard18 = new GameCard18("Learning Netbeans", "src/cecs343_bs_in_cs/picture/18.png", validRoomsGC18);
		GameCard19 gameCard19 = new GameCard19("Choosing a Major", "src/cecs343_bs_in_cs/picture/19.png", validRoomsGC19);
		GameCard20 gameCard20 = new GameCard20("Pass Soccer Class", "src/cecs343_bs_in_cs/picture/20.png", validRoomsGC20);
		GameCard21 gameCard21 = new GameCard21("Score a Goal!", "src/cecs343_bs_in_cs/picture/21.png", validRoomsGC21);
		GameCard22 gameCard22 = new GameCard22("Fall in the Pond", "src/cecs343_bs_in_cs/picture/22.png", validRoomsGC22);
		GameCard23 gameCard23 = new GameCard23("Make the Dean's List", "src/cecs343_bs_in_cs/picture/23.png", validRoomsGC23);
		GameCard24 gameCard24 = new GameCard24("A New Laptop", "src/cecs343_bs_in_cs/picture/24.png", validRoomsGC24);
		GameCard25 gameCard25 = new GameCard25("Meet the Dean", "src/cecs343_bs_in_cs/picture/25.png", validRoomsGC25);
		GameCard26 gameCard26 = new GameCard26("Loud Buzzing", "src/cecs343_bs_in_cs/picture/26.png", validRoomsGC26);
		GameCard27 gameCard27 = new GameCard27("Program Crashes", "src/cecs343_bs_in_cs/picture/27.png", validRoomsGC27);
		GameCard28 gameCard28 = new GameCard28("Professor Englert", "src/cecs343_bs_in_cs/picture/28.png", validRoomsGC28);
		GameCard29 gameCard29 = new GameCard29("Press the Right Floor", "src/cecs343_bs_in_cs/picture/29.png", validRoomsGC29);
		GameCard30 gameCard30 = new GameCard30("Soccer Goalie", "src/cecs343_bs_in_cs/picture/30.png", validRoomsGC30);
		GameCard31 gameCard31 = new GameCard31("Elective Class", "src/cecs343_bs_in_cs/picture/31.png", validRoomsGC31);
		GameCard32 gameCard32 = new GameCard32("Oral Communication", "src/cecs343_bs_in_cs/picture/32.png", validRoomsGC32);
		GameCard33 gameCard33 = new GameCard33("Professor Hoffman", "src/cecs343_bs_in_cs/picture/33.png", validRoomsGC33);
		GameCard34 gameCard34 = new GameCard34("CHEM 111", "src/cecs343_bs_in_cs/picture/34.png", validRoomsGC34);
		GameCard35 gameCard35 = new GameCard35("The Outpost", "src/cecs343_bs_in_cs/picture/35.png", validRoomsGC35);
		GameCard36 gameCard36 = new GameCard36("Learning Linux", "src/cecs343_bs_in_cs/picture/36.png", validRoomsGC36);
		GameCard37 gameCard37 = new GameCard37("Make a Friend", "src/cecs343_bs_in_cs/picture/37.png", validRoomsGC37);
		GameCard38 gameCard38 = new GameCard38("Enjoying Nature", "src/cecs343_bs_in_cs/picture/38.png", validRoomsGC38);
		GameCard39 gameCard39 = new GameCard39("Student Parking", "src/cecs343_bs_in_cs/picture/5.png", validRoomsGC5);
		
		//Adds game card images to list of active cards
		stackOfCards.add(gameCard1);
		stackOfCards.add(gameCard2);
		stackOfCards.add(gameCard3);
		stackOfCards.add(gameCard4);
		stackOfCards.add(gameCard5);
		stackOfCards.add(gameCard6);
		stackOfCards.add(gameCard7);
		stackOfCards.add(gameCard8);
		stackOfCards.add(gameCard9);
		stackOfCards.add(gameCard10);
		stackOfCards.add(gameCard11);
		stackOfCards.add(gameCard12);
		stackOfCards.add(gameCard13);
		stackOfCards.add(gameCard14);
		stackOfCards.add(gameCard15);
		stackOfCards.add(gameCard16);
		stackOfCards.add(gameCard17);
		stackOfCards.add(gameCard18);
		stackOfCards.add(gameCard19);
		stackOfCards.add(gameCard20);
		stackOfCards.add(gameCard21);
		stackOfCards.add(gameCard22);
		stackOfCards.add(gameCard23);
		stackOfCards.add(gameCard25);
		stackOfCards.add(gameCard26);
		stackOfCards.add(gameCard27);
		stackOfCards.add(gameCard28);
		stackOfCards.add(gameCard29);
		stackOfCards.add(gameCard30);
		stackOfCards.add(gameCard31);
		stackOfCards.add(gameCard32);
		stackOfCards.add(gameCard33);
		stackOfCards.add(gameCard34);
		stackOfCards.add(gameCard35);
		stackOfCards.add(gameCard36);
		stackOfCards.add(gameCard37);
		stackOfCards.add(gameCard38);
		stackOfCards.add(gameCard39);
		
	}
	
	public void shuffle() {
		//Shuffle deck 
		long seed = System.nanoTime();
		Collections.shuffle(stackOfCards, new Random(seed));
	}
	
	public GameCard getCard() {
		return stackOfCards.pop();
	}
}
