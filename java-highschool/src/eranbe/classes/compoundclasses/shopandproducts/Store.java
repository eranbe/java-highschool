package eranbe.classes.compoundclasses.shopandproducts;

/**
 * See https://docs.google.com/document/d/1LiLxmohM8lLnGIcwSpmDDJghYUb71_zWJpjopkKdZsc/edit?usp=sharing
 */
public class Store {
	private String storeName;
	private Product[] inventory;
	
	public Store(String storeName, Product[] inventory) {
		this.storeName = storeName;
		this.inventory = new Product[inventory.length];
		for (int i = 0; i < inventory.length; i++) {
			this.inventory[i] = new Product(inventory[i]);
		}
	}

	public int countSaleItems() {
		int count = 0;
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i].isOnSale()) {
				count++;
			}
		}
		return count;
	}
	
	@Override
	public String toString() {
		String result = "[Store] name: " + storeName + "\n";
		for (int i = 0; i < inventory.length; i++) {
			result += "- " + inventory[i] + "\n";
		}
		return result;
	}
	
	public static void main(String[] args) {
		Product shoe = new Product("Shoe", 100);
		Product shirt = new Product("Shirt", 50);
		Product pants = new Product("pants", 80);
		shoe.applyDiscount(20);
		shirt.applyDiscount(50);
		Product[] inventory = new Product[3];
		inventory[0] = shoe;
		inventory[1] = shirt;
		inventory[2] = pants;
		Store clothes = new Store("Clothes", inventory);
		System.out.println(clothes);
		System.out.println(clothes.countSaleItems());
	}
}
