package application;

import java.util.Scanner;

import game.Game;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean end = false;
		
		do {
			Game.clearScreen();
			System.out.println("Current Turn: PLAYER " + (Game.getCurrentPlayer()+1));
			System.out.println("Tries: " + Game.triesMechanics.getPlayerTries(Game.getCurrentPlayer()));
			System.out.println("Points: " + Game.pointMechanics.getPlayerPoints(Game.getCurrentPlayer()) + "\n");
			String word = Game.drawWord(Game.getCurrentPlayer());
			
			System.out.print("Enter the original word: ");
			String response = sc.nextLine();
			if (!response.toUpperCase().equals(word.toUpperCase())) {
				System.out.println("\nWRONG ANSWER!");
				System.out.println("Word: " + word);
				System.out.println("Response: " + response);
				Game.triesMechanics.setPlayerTries(Game.getCurrentPlayer());
				end = Game.triesMechanics.endGame();
				if (end) {
					Game.printScore();
					System.out.println("Player " + (Game.getNextPlayer()+1) + " victory!");
				}
			}
			else {
				System.out.println("\nCORRECT ANSWER!");
				Game.pointMechanics.setPlayerPoints(Game.getCurrentPlayer(), word.length());
				end = Game.pointMechanics.endGame();
				if (end) {
					Game.printScore();
					System.out.println("Player " + (Game.getCurrentPlayer()+1) + " victory!");
				}
			}
			System.out.println("\nPress ENTER to continue...");
			sc.nextLine();
			Game.endTurn();
		} while (end != true);
		
		sc.close();
	}
}