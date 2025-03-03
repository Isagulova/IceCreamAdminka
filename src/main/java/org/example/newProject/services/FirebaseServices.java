package org.example.newProject.services;

import com.google.firebase.database.*;
import org.example.newProject.config.FirebaseConfig;
import org.example.newProject.model.CategoryEntity;
import org.example.newProject.model.ProductEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FirebaseServices extends FirebaseConfig {
    private DatabaseReference database;

    public FirebaseServices(String path) {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        database = firebaseDatabase.getReference(path);
    }

    public void saveProduct(ProductEntity productEntity) {
        productEntity.setKey(database.push().getKey());
        database.child(productEntity.getKey()).setValueAsync(productEntity);
    }

    public void saveCategory(CategoryEntity categoryEntity) {
        categoryEntity.setKey(database.push().getKey());
        database.child(categoryEntity.getKey()).setValueAsync(categoryEntity);
    }

    public CompletableFuture<List<String>> getCategoriesFromFirebase() {
        CompletableFuture<List<String>> future = new CompletableFuture<>();
        List<String> categories = new ArrayList<>();

        DatabaseReference database = FirebaseDatabase.getInstance().getReference("categories");

        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String key = snapshot.child("key").getValue(String.class);
                    String nameOfCategory = snapshot.child("nameOfCategory").getValue(String.class);
                    String imageOfCategory = snapshot.child("imageOfCategory").getValue(String.class);

                    categories.add(key);
                    categories.add(nameOfCategory);
                    categories.add(imageOfCategory);
                }
                future.complete(categories);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                future.completeExceptionally(databaseError.toException());
            }
        });

        return future;
    }

    public CompletableFuture<List<String>> getProductsFromFirebase() {
        CompletableFuture<List<String>> future = new CompletableFuture<>();
        List<String> products = new ArrayList<>();

        DatabaseReference database = FirebaseDatabase.getInstance().getReference("products");

        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String key = snapshot.child("key").getValue(String.class);
                    String productName = snapshot.child("productName").getValue(String.class);
                    String productCategory = snapshot.child("productCategory").getValue(String.class);
                    String productImage = snapshot.child("productImage").getValue(String.class);
                    String productDescription = snapshot.child("productDescription").getValue(String.class);
                    String productPrice = String.valueOf(snapshot.child("productPrice").getValue(Integer.class));

                    products.add(key);
                    products.add(productName);
                    products.add(productCategory);
                    products.add(productImage);
                    products.add(productDescription);
                    products.add(productPrice);
                }
                future.complete(products);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                future.completeExceptionally(databaseError.toException());
            }
        });

        return future;
    }

    public void deleteCategoryByKey(String key) {
        database.child(key).removeValue((databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Error deleting data: " + databaseError.getMessage());
            } else {
                System.out.println("Data deleted successfully.");
            }
        });
    }

    public void updateCategoryByKey(String key, CategoryEntity updatedCategoryEntity) {
        database.child(key).setValue(updatedCategoryEntity, (databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Error updating data: " + databaseError.getMessage());
            } else {
                System.out.println("Data updated successfully.");
            }
        });
    }

    public void deleteProductByKey(String key) {
        database.child(key).removeValue((databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Error deleting data: " + databaseError.getMessage());
            } else {
                System.out.println("Data deleted successfully.");
            }
        });
    }

    public void updateProductByKey(String key, ProductEntity updatedProductEntity) {
        database.child(key).setValue(updatedProductEntity, (databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Error updating data: " + databaseError.getMessage());
            } else {
                System.out.println("Data updated successfully.");
            }
        });
    }
}