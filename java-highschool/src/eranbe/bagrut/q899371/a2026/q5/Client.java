package eranbe.bagrut.q899371.a2026.q5;

public class Client {
    private char firstNameInitial;
    private char lastNameInitial;
    private Birthdate birthdate;

    public char getFirstNameInitial() {
        return this.firstNameInitial;
    }
    
    public boolean sameInitials(Client other) {
        return this.firstNameInitial == other.firstNameInitial 
        		&& this.lastNameInitial == other.lastNameInitial;
    }

    public boolean areSame(Client other) {
        return this.sameInitials(other) && this.birthdate.sameDate(other.birthdate);
    }

    public static void uniques(Client[] clients) {
        for (int i = 0; i < clients.length; i++) {
            Client client = clients[i];
            boolean foundSame = false;
            // מספיק לבדוק את הלקוחות שאחרי הנוכחי
            for (int j = i + 1; j < clients.length; j++) {
                if (client.areSame(clients[j])) {
                    foundSame = true;
                }
            }
            if (!foundSame) {
                System.out.println(client.getFirstNameInitial());
            }
        }
    }

    public static void uniques2(Client[] clients) {
        for (int i = 0; i < clients.length; i++) {
            Client client = clients[i];
            boolean foundSame = false;
            for (int j = 0; j < clients.length; j++) {
                if (i != j && client.areSame(clients[j])) {
                    foundSame = true;
                }
            }
            if (!foundSame) {
                System.out.println(client.getFirstNameInitial());
            }
        }
    }
}
