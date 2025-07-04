package eranbe.bagrut.q899371.a2025.q5;

public class User {
	private String name;
	private int id;
	private int[] friends;
	
	// (א)
	public int mutual(User other) {
		int mutualCount = 0;
		int[] otherFriends = other.getFriends();
		for (int i = 0; i < friends.length; i++) {
			for (int j = 0; j < otherFriends.length; j++) {
				if (friends[i] == otherFriends[j]) {
					mutualCount++;
				}
			}
		}
		return mutualCount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int[] getFriends() {
		return friends;
	}
	public void setFriends(int[] friends) {
		this.friends = friends;
	}
}
