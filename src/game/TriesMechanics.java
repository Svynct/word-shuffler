package game;

public class TriesMechanics implements GameMechanics {
	
	Integer[] tries = new Integer[] {5, 5};
	
	public int getPlayerTries(int player) {
		return tries[player];
	}
	
	public void setPlayerTries(int player) {
		tries[player] -= 1;
	}

	@Override
	public boolean endGame() {
		if (tries[Game.PLAYER_ONE] == 0) {
			return true;
		}
		else if (tries[Game.PLAYER_TWO] == 0) {
			return true;
		}
		return false;
	}
}
