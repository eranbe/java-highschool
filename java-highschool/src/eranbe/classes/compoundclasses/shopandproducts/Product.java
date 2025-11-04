package eranbe.classes.compoundclasses.shopandproducts;

/**
 * See https://docs.google.com/document/d/1LiLxmohM8lLnGIcwSpmDDJghYUb71_zWJpjopkKdZsc/edit?usp=sharing
 */
public class Product {
	private String productName;
	private int price;
	private boolean onSale;
	
	public Product(String productName, int price) {
		this.productName = productName;
		this.price = price;
		this.onSale = false;
	}
	
	public Product(Product otherProduct) {
		this.productName = otherProduct.productName;
		this.price = otherProduct.price;
		this.onSale = otherProduct.onSale;
	}
	
	public boolean isOnSale() {
		return onSale;
	}
	
	public void applyDiscount(int discountPercent) {
		price -= (price * discountPercent / 100);
		onSale = true;
	}
	
	@Override
	public String toString() {
		return "[Product] name: " + productName + ", price: " + price + ", on sale: " + onSale;
	}
	public static void main(String[] args) {
		Product p = new Product("Shoe", 100);
		p.applyDiscount(20);
		System.out.println(p);
	}
}
