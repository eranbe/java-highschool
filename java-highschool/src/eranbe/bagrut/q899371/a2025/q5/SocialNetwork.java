package eranbe.bagrut.q899371.a2025.q5;

public class SocialNetwork {
	private User[] users;
	
	public boolean exactOne(User other) {
		for (int i = 0; i < users.length; i++) {
			if (users[i].mutual(other) == 1) {
				return true;
			}
		}
		return false;
	}
}
