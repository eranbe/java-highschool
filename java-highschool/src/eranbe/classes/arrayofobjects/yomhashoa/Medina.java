package eranbe.classes.arrayofobjects.yomhashoa;

public class Medina {
	private String name;
	private int count;
	
	public Medina(String name, int count) {
		this.name = name;
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "Country: " + this.name + " - Count: " + this.count;
	}
}