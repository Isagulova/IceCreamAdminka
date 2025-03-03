package org.example.newProject.model;

public class ProductEntity {
    private String key;
    private String productCategory;
    private String productName;
    private String productImage;
    private Double productPrice;
    private String productDescription;

    public ProductEntity(String productCategory, String productName, String productImage, Double productPrice, String productDescription) {
        this.productCategory = productCategory;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}