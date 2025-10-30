package eranbe.classes;

public class Person {

	private String name;
	private Person spouse;
	private Person[] children; // up to 20
	private Person parent1;
	private Person parent2;
	
	public Person(String name) {
		this.name = name;
		children = new Person[20];
	}
	
	public String getName() {
		return name;
	}
	
	public void setSpouse(Person p) {
		this.spouse = p;
	}
	
	public Person getSpouse() {
		return spouse;
	}
	
	public void addChild(Person child) {
		int i = 0;
		while (children[i] != null && i < children.length) {
			i++;
		}
		if (i != children.length) {
			children[i] = child;
		} else {
			System.out.println("Can't add more than 20 children");
		}
	}
	
	public Person getParent1() {
		return parent1;
	}

	public Person getParent2() {
		return parent2;
	}

	public void setParent1(Person p) {
		parent1 = p;
	}

	public void setParent2(Person p) {
		parent2 = p;
	}
	
	public String verifyParentOfChildren() {
		int i = 0;
		while (children[i] != null && i < children.length) {
			Person child = children[i];
			if (!(this.equals(child.getParent1()) || this.equals(child.getParent2()))) {
				return "Child " + child.getName() + " doesn't have " + getName() + " as parent";
			}
			i++;
		}
		return getName() + " OK";
	}
	
	public String getParent1Lineage() {
		if (getParent1() != null) {
			return getName() + " child of " + getParent1().getParent1Lineage();
		} else {
			return getName();
		}
	}

	@Override
	public String toString() {
		String result = name;
		if (parent1 != null || parent2 != null) {
			result += " child of ";
			if (parent1 != null) {
				result += parent1.getName();
				if (parent2 != null) {
					result += " and ";
				}
			}
			if (parent2 != null) {
				result += parent2.getName();
			}
			result += "\n";
		}
		if (spouse != null) {
			result += " spouse of " + spouse.getName() + "\n";
		}
		
		int i = 0;
		while (children[i] != null && i < children.length) {
			result += " child: " + children[i].getName() + "\n";
			i++;
		}
		return result;
	}
	public static void main(String[] args) {
		Person me = new Person("Eran");
		Person spouse = new Person("Ayelet");
		Person parent1 = new Person("Ann");
		Person parent2 = new Person("Yoav"); 
		Person child1 = new Person("Yarden");
		Person child2 = new Person("Yuval");
		me.setSpouse(spouse);
		me.addChild(child1);
		me.addChild(child2);
		//me.setParent1(parent1);
		me.setParent2(parent2);
		spouse.setSpouse(me);
		parent1.setSpouse(parent2);
		parent2.setSpouse(parent1);
		child1.setParent1(me);
		child1.setParent2(spouse);
		child2.setParent1(me);
		child2.setParent2(spouse);
		parent1.addChild(me);
		parent2.addChild(me);
		System.out.println(me.verifyParentOfChildren());
		System.out.println(spouse.verifyParentOfChildren());
		System.out.println(parent1.verifyParentOfChildren());
		me.setParent1(parent1);
		System.out.println(parent1.verifyParentOfChildren());
		System.out.println(child1.getParent1Lineage());
	}

}
