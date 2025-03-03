package org.example.newProject.model;

public class CategoryEntity {
    private String key;
    private String nameOfCategory;
    private String imageOfCategory;

    public CategoryEntity(String nameOfCategory, String imageOfCategory) {
        this.nameOfCategory = nameOfCategory;
        this.imageOfCategory = imageOfCategory;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public void setNameOfCategory(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }

    public String getImageOfCategory() {
        return imageOfCategory;
    }

    public void setImageOfCategory(String imageOfCategory) {
        this.imageOfCategory = imageOfCategory;
    }
}
