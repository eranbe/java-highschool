package eranbe.classes.compoundclasses.teamandplayer;

/**
 * See https://docs.google.com/document/d/1LiLxmohM8lLnGIcwSpmDDJghYUb71_zWJpjopkKdZsc/edit?usp=sharing
 */
public class Player {
	private String name;
	private int jerseyNum;
	private int totalPoints;
	
	public Player(String name, int jerseyNum) {
		this.name = name;
		this.jerseyNum = jerseyNum;
		totalPoints = 0;
	}
	
	public void addPoints(int points) {
		this.totalPoints += points;
	}
	
	public int getTotalPoints() {
		return totalPoints;
	}
}
