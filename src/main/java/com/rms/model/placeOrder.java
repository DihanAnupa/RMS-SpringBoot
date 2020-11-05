package com.rms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "placeOrder")
public class placeOrder {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @GenericGenerator(
        name = "order_seq", 
        strategy = "com.rms.model.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ORDER_")})
	@Column(name = "pOrderID", updatable = false, nullable = false)
	private String pOrderID;
	
	@Column(name = "orderItem_1") 
	private String orderitem1;
	
	@Column(name = "qty1")
	private int quantity1;
	
	@Column(name = "orderItem_2") 
	private String orderitem2;
	
	@Column(name = "qty2")
	private int quantity2;
	
	@Column(name = "orderItem_3") 
	private String orderitem3;
	
	@Column(name = "qty3")
	private int quantity3;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "Total_Price")
	private double tPrice;

	public placeOrder() {
		//Default Constructor
	}

	public placeOrder(String orderitem1, int quantity1, String orderitem2, int quantity2, String orderitem3,
			int quantity3, String status, double tPrice) {
		super();
		this.orderitem1 = orderitem1;
		this.quantity1 = quantity1;
		this.orderitem2 = orderitem2;
		this.quantity2 = quantity2;
		this.orderitem3 = orderitem3;
		this.quantity3 = quantity3;
		this.status = status;
		this.tPrice = tPrice;
	}

	public String getpOrderID() {
		return pOrderID;
	}

	public void setpOrderID(String pOrderID) {
		this.pOrderID = pOrderID;
	}

	public String getOrderitem1() {
		return orderitem1;
	}

	public void setOrderitem1(String orderitem1) {
		this.orderitem1 = orderitem1;
	}

	public int getQuantity1() {
		return quantity1;
	}

	public void setQuantity1(int quantity1) {
		this.quantity1 = quantity1;
	}

	public String getOrderitem2() {
		return orderitem2;
	}

	public void setOrderitem2(String orderitem2) {
		this.orderitem2 = orderitem2;
	}

	public int getQuantity2() {
		return quantity2;
	}

	public void setQuantity2(int quantity2) {
		this.quantity2 = quantity2;
	}

	public String getOrderitem3() {
		return orderitem3;
	}

	public void setOrderitem3(String orderitem3) {
		this.orderitem3 = orderitem3;
	}

	public int getQuantity3() {
		return quantity3;
	}

	public void setQuantity3(int quantity3) {
		this.quantity3 = quantity3;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double gettPrice() {
		return tPrice;
	}

	public void settPrice(double tPrice) {
		this.tPrice = tPrice;
	}

	
	

	

}

	