package org.example.newProject.services;

import com.google.firebase.database.*;
import org.example.newProject.config.FirebaseConfig;
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

    // Метод для сохранения AnnouncementsEntity
    public void saveMain(ProductEntity mainEntity) {
        mainEntity.setKey(database.push().getKey());
        database.child(mainEntity.getKey()).setValueAsync(mainEntity);
    }


    public CompletableFuture<List<String>> getOptionsFromFirebase() {

        CompletableFuture<List<String>> future = new CompletableFuture<>();
        List<String> options = new ArrayList<>();

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String key = snapshot.child("key").getValue(String.class);
                    String category = snapshot.child("category").getValue(String.class);
                    String imageOfCategory = snapshot.child("imageOfCategory").getValue(String.class);
                    String nameOfProduct = snapshot.child("nameOfProduct").getValue(String.class);
                    String imageOfProduct = snapshot.child("imageOfProduct").getValue(String.class);
                    String price = snapshot.child("price").getValue(String.class);
                    String composition = snapshot.child("composition").getValue(String.class);
                    String nutritionalValue = snapshot.child("nutritionalValue").getValue(String.class);
                    options.add(key);
                    options.add(category);
                    options.add(imageOfCategory);
                    options.add(nameOfProduct);
                    options.add(imageOfProduct);
                    options.add(price);
                    options.add(composition);
                    options.add(nutritionalValue);
                }
                future.complete(options);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                future.completeExceptionally(databaseError.toException());
            }
        });
        return future;
    }

    public void deleteByKey(String key) {
        database.child(key).removeValue((databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Error deleting data: " + databaseError.getMessage());
            } else {
                System.out.println("Data deleted successfully.");
            }
        });
    }

    public void updateByKey(String key, ProductEntity updatedEntity) {
        database.child(key).setValue(updatedEntity, (databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Error updating data: " + databaseError.getMessage());
            } else {
                System.out.println("Data updated successfully.");
            }
        });
    }
}