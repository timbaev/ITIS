public interface PayInterfaceExtend extends PayInterface {
	
	public void clearHistoryPurchase();
	public void deleteFromHistoryPurchase(int item);
}