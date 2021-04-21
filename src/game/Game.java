package game;

import model.entities.Shuffler;
import model.repositories.WordRepository;
import model.services.GameMechanicsFactory;
import model.services.ShufflerFactory;

public class Game {

	public static final int PLAYER_ONE = 0;
	public static final int PLAYER_TWO = 1;
	
	public static TriesMechanics triesMechanics = GameMechanicsFactory.instantiateTriesMechanics();
	public static PointMechanics pointMechanics = GameMechanicsFactory.instantiatePointMechanics();
	
	private static int currentPlayer = PLAYER_ONE;
	
	public static String drawWord(int player) { 
		Shuffler shuffler = null;
		if (Math.random() <= 0.5) {
			shuffler = ShufflerFactory.instantiateRandomShuffler();
		} else {
			shuffler = ShufflerFactory.instantiateReverseShuffler();
		}
		String word = WordRepository.read();
		
		System.out.println("The word is... " + shuffler.shuffle(word).toUpperCase() + "\n");
		return word;
	}
	
	public static int getCurrentPlayer() {
		return currentPlayer;
	}
	
	public static int getNextPlayer() {
		if (currentPlayer == PLAYER_ONE) {
			return PLAYER_TWO;
		}
		return PLAYER_ONE;
	}
	
	public static void endTurn() { 
		currentPlayer = getNextPlayer();
	}	
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");  
		System.out.flush(); 
	}
	
	public static void printScore() {
		System.out.println("\n===PLAYER 1===");
		System.out.println("Points: " + pointMechanics.getPlayerPoints(PLAYER_ONE));
		System.out.println("Tries: " + triesMechanics.getPlayerTries(PLAYER_ONE) + "\n");	
		System.out.println("===PLAYER 2===");
		System.out.println("Points: " + pointMechanics.getPlayerPoints(PLAYER_TWO));
		System.out.println("Tries: " + triesMechanics.getPlayerTries(PLAYER_TWO) + "\n");
	}
}
