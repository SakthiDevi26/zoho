package entities;

import java.sql.Date;

public class Shipment {

	//int shipmentId;
	//int orderId;
	//int customerId;
	int productId;
	public String deliveryStatus;
	public Date deliveryDate;
	
	public Shipment( String deliveryStatus, Date deliveryDate) {
		//this.orderId = orderId;
		//this.customerId = customerId;
		//this.productId = productId;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
	}
	
}
