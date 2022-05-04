package databaseoperations.interfaces.gettable;

public interface CustomerDetailsGettable {

	public int getCurrentlyLoggedInCustomerId();
	public String getCustomerAddress(int customerId);
	public String getCustomerName(int customerId);
	public long getCustomerPhoneNumber(int customerId);
	public int getCustomerId(int orderId);
}
