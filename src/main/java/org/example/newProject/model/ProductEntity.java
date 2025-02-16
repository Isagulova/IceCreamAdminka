package org.example.newProject.model;

public class ProductEntity {
    private String key;
    private String category;
    private String imageOfCategory;
    private String nameOfProduct;
    private String imageOfProduct;
    private String price;
    private String composition;
    private String nutritionalValue;

    public ProductEntity(String category, String imageOfCategory, String nameOfProduct, String imageOfProduct, String price, String composition, String nutritionalValue) {
        this.category = category;
        this.imageOfCategory = imageOfCategory;
        this.nameOfProduct = nameOfProduct;
        this.imageOfProduct = imageOfProduct;
        this.price = price;
        this.composition = composition;
        this.nutritionalValue = nutritionalValue;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageOfCategory() {
        return imageOfCategory;
    }

    public void setImageOfCategory(String imageOfCategory) {
        this.imageOfCategory = imageOfCategory;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getImageOfProduct() {
        return imageOfProduct;
    }

    public void setImageOfProduct(String imageOfProduct) {
        this.imageOfProduct = imageOfProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getNutritionalValue() {
        return nutritionalValue;
    }

    public void setNutritionalValue(String nutritionalValue) {
        this.nutritionalValue = nutritionalValue;
    }
}