package databaseoperations.interfaces.gettable;

public interface ProductDetailsGettable {

	/*
	 * public String getProductName(int productId); public String
	 * getProductCategory(int productId); public String getProductDescription(int
	 * productId); public int getProductPrice(int productId);
	 */
	public int getProductId(int customerId, int orderId);
	public String getCustomerFeedback(int productId, int customerId);
	public String getCustomerAnalyzedFeedback(int productId, int customerId);
	public String getProductDetail(String columnName, String input);
	int getProductPrice(int productId);
	String getProductDetail(int productId, String columnName);
}
