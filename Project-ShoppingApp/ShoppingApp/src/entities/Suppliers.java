package entities;

public class Suppliers {

	public int supplierId;
	public String supplierName;
	public long supplierPhoneNumber;
	String supplierPassword;
	
	public Suppliers(int supplierId, String supplierName, long supplierPhoneNumber) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierPhoneNumber = supplierPhoneNumber;
	}

	public Suppliers() {
		// TODO Auto-generated constructor stub
	}
}
