package eranbe.bagrut.a2018;

public class Vote {

	int first;
	int second;
	int third;
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public int getThird() {
		return third;
	}
	public void setThird(int third) {
		this.third = third;
	}
	
	public static int theWinner(Vote[] votes) {
		final int firstPlace = 7;
		final int secondPlace = 5;
		final int thirdPlace = 1;
		int[] voteCounts = new int[40];
		for (Vote vote: votes) {
			voteCounts[vote.getFirst()] += firstPlace;
			voteCounts[vote.getSecond()] += secondPlace;
			voteCounts[vote.getThird()] += thirdPlace;
		}
		
		int maxIndex = 0;
		int maxValue = voteCounts[maxIndex];
		for (int i = 1; i < voteCounts.length; i++) {
			if (voteCounts[i] > maxValue) {
				maxIndex = i;
				maxValue = voteCounts[i];
			}
		}
		return maxIndex+1;
	}
}
