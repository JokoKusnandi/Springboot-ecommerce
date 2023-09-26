package com.joko.dao;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
	
	@NotNull(message = "Product name is required.")
	@Basic(optional = false)
	@NotBlank
	@Size(max = 120)
    @Column(name = "name")
    private String name;

	@NotBlank
	@Size(max = 255)
    @Column(name = "description")
    private String description;


    @Column(name = "price")
    private double price;
    
	@NotBlank
	@Size(max = 255)
    @Column(name = "pictureUrl")
    private String pictureUrl;

	public Product() {

	}

	public Product(Long productId,
			@NotNull(message = "Product name is required.") @NotBlank @Size(max = 120) String name,
			@NotBlank @Size(max = 255) String description, @NotBlank @Size(max = 120) double price,
			@NotBlank @Size(max = 255) String pictureUrl) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.pictureUrl = pictureUrl;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", pictureUrl=" + pictureUrl + "]";
	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the pictureUrl
	 */
	public String getPictureUrl() {
		return pictureUrl;
	}

	/**
	 * @param pictureUrl the pictureUrl to set
	 */
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

    //@Column(name = "stock_quantity")
    //private int stockQuantity;
	
	
    
}
