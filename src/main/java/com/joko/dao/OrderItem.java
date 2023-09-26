package com.joko.dao;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "order_items")
public class OrderItem {
	 	//@Id
		/*
		 * Only one id can be used. You should use either @Id or @EmbeddedId, not both.
		 * If you want to use @EmbeddedId, then delete @Id annotation. You can check it
		 * from Jakarta doc.
		 * "There must be only one EmbeddedId annotation and no Id annotation when the EmbeddedId annotation is used."
		 * Reference:
		 * https://jakarta.ee/specifications/persistence/3.0/apidocs/jakarta.persistence
		 * /jakarta/persistence/embeddedid
		 */	
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "order_item_id")
	    private Long orderItemId;
	 	
	    @EmbeddedId
	    @JsonIgnore
	    private OrderProductPK pk;

	    @Column(name = "quantity")
	    private int quantity;

	    @Column(name = "price_at_purchase")
	    private double priceAtPurchase;

		/**
		 * @return the orderItemId
		 */
		public Long getOrderItemId() {
			return orderItemId;
		}

		/**
		 * @param orderItemId the orderItemId to set
		 */
		public void setOrderItemId(Long orderItemId) {
			this.orderItemId = orderItemId;
		}

		/**
		 * @return the pk
		 */
		public OrderProductPK getPk() {
			return pk;
		}

		/**
		 * @param pk the pk to set
		 */
		public void setPk(OrderProductPK pk) {
			this.pk = pk;
		}

		/**
		 * @return the quantity
		 */
		public int getQuantity() {
			return quantity;
		}

		/**
		 * @param quantity the quantity to set
		 */
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		/**
		 * @return the priceAtPurchase
		 */
		public double getPriceAtPurchase() {
			return priceAtPurchase;
		}

		/**
		 * @param priceAtPurchase the priceAtPurchase to set
		 */
		public void setPriceAtPurchase(double priceAtPurchase) {
			this.priceAtPurchase = priceAtPurchase;
		}

		public OrderItem() {
			super();
			// TODO Auto-generated constructor stub
		}

		public OrderItem(Long orderItemId, Order order, Product product, int quantity, double priceAtPurchase) {
			super();
			this.orderItemId = orderItemId;
	        pk = new OrderProductPK(order, product);
	        pk.setOrder(order);
	        pk.setProduct(product);
			this.quantity = quantity;
			this.priceAtPurchase = priceAtPurchase;
		}
		
	    @Transient
	    public Product getProduct() {
	        return this.pk.getProduct();
	    }
	    
	    @Transient
	    public Double getTotalPrice() {
	        return getProduct().getPrice() * getQuantity();
	    }

	    // Getters and setters
}
