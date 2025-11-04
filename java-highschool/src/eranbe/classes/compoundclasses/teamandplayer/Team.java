package eranbe.classes.compoundclasses.teamandplayer;

/**
 * See https://docs.google.com/document/d/1LiLxmohM8lLnGIcwSpmDDJghYUb71_zWJpjopkKdZsc/edit?usp=sharing
 */
public class Team {
	private String teamName;
	private Player[] players;
	
	public int calculateTotalTeamPoints() {
		int result = 0;
		for (int i = 0; i < players.length; i++) {
			result += players[i].getTotalPoints();
		}
		return result;
	}
}
