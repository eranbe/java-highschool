package eranbe.bagrut.q899371.a2026.q4;

public class Order {
    private int productID;
    private double price;
    private int quantity;
    private boolean delivery;

    public int getProductID() {
        return this.productID;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Order(int productID, double price) {
        this.productID = productID;
        this.price = price;
        this.quantity = 1;
        this.delivery = true;
    }

    public double totalPrice() {
        return this.price * this.quantity;
    }

    public double totalCost() {
        double basePrice = this.totalPrice();
        if (!this.delivery) {
        	return basePrice;
        }
        // אם אנחנו כאן, אז התבקש משלוח
        if (this.quantity >= 10 && price > 170) {
            return basePrice;
        }
        return basePrice + 100;
    }

    public static int[] sumQuantity(Order[] allOrders) {
        int[] result = new int[100]; // in Java, all cells initialized to zero.
        for (int i = 0; i < allOrders.length; i++) {
            Order order = allOrders[i];
            result[order.getProductID()] += order.getQuantity();
        }
        return result;
    }
}
