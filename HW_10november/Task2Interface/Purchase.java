public class Purchase {
	
	private String shop;
	private int price;
	
	public Purchase(String shop, int price) {
		this.shop = shop;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Shop: " + shop + "\n" 
		+ "Price: " + price;
	}
}