package game;

public class PointMechanics implements GameMechanics{
	
	Integer[] points = new Integer[] {0, 0};
	
	public int getPlayerPoints(int player) {
		return points[player];
	}
	
	public void setPlayerPoints(int player, int point) {
		points[player] += point;
	}
	
	@Override
	public boolean endGame() {
		if (points[Game.PLAYER_ONE] >= 50) {
			return true;
		}
		else if (points[Game.PLAYER_TWO] >= 50) {
			return true;
		}
		return false;
	}
}