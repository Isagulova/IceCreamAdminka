package org.example.newProject.services.modul;

import org.example.newProject.services.FirebaseServices;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThymleafUIModul {
    private Model model;

    public ThymleafUIModul(Model model) {
        this.model = model;
    }

    public void showData(FirebaseServices productFirebase){
        CompletableFuture<List<String>> table = productFirebase.getOptionsFromFirebase();
        try {
            List<String> all = table.get();

            List<String> keyList = new ArrayList<>();
            List<String> categoryList = new ArrayList<>();
            List<String> imageOfCategoryList = new ArrayList<>();
            List<String> nameOfProductList = new ArrayList<>();
            List<String> imageOfProductList = new ArrayList<>();
            List<String> price = new ArrayList<>();
            List<String> compositionList = new ArrayList<>();
            List<String> nutritionalValueList = new ArrayList<>();

            for (int i = 0; i < all.size(); i++) {
                switch (i % 8) {
                    case 0:
                        keyList.add(all.get(i));
                        break;
                    case 1:
                        categoryList.add(all.get(i));
                        break;
                    case 2:
                        imageOfCategoryList.add(all.get(i));
                        break;
                    case 3:
                        nameOfProductList.add(all.get(i));
                        break;
                    case 4:
                        imageOfProductList.add(all.get(i));
                        break;
                    case 5:
                        price.add(all.get(i));
                        break;
                    case 6:
                        compositionList.add(all.get(i));
                        break;
                    case 7:
                        nutritionalValueList.add(all.get(i));
                        break;
                }
            }

            model.addAttribute("keyList", keyList);
            model.addAttribute("categoryList", categoryList);
            model.addAttribute("imageOfCategoryList", imageOfCategoryList);
            model.addAttribute("nameOfProductList", nameOfProductList);
            model.addAttribute("imageOfProductList", imageOfProductList);
            model.addAttribute("priceList", price);
            model.addAttribute("compositionList", compositionList);
            model.addAttribute("nutritionalValueList", nutritionalValueList);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateShow(FirebaseServices mainFirebase, String updateKey) {
        CompletableFuture<List<String>> table = mainFirebase.getOptionsFromFirebase();
        try {
            List<String> all = table.get();

            List<String> keyList = new ArrayList<>();
            List<String> categoryList = new ArrayList<>();
            List<String> imageOfCategoryList = new ArrayList<>();
            List<String> nameOfProductList = new ArrayList<>();
            List<String> imageOfProductList = new ArrayList<>();
            List<String> price = new ArrayList<>();
            List<String> compositionList = new ArrayList<>();
            List<String> nutritionalValueList = new ArrayList<>();

            for (int i = 0; i < all.size(); i++) {
                switch (i % 8) {
                    case 0:
                        keyList.add(all.get(i));
                        break;
                    case 1:
                        categoryList.add(all.get(i));
                        break;
                    case 2:
                        imageOfCategoryList.add(all.get(i));
                        break;
                    case 3:
                        nameOfProductList.add(all.get(i));
                        break;
                    case 4:
                        imageOfProductList.add(all.get(i));
                        break;
                    case 5:
                        price.add(all.get(i));
                        break;
                    case 6:
                        compositionList.add(all.get(i));
                        break;
                    case 7:
                        nutritionalValueList.add(all.get(i));
                        break;
                }
            }

            for (int i = 0; i < keyList.size(); i++) {
                if (updateKey.equals(keyList.get(i))) {
                    model.addAttribute("key", keyList.get(i));
                    model.addAttribute("category", categoryList.get(i));
                    model.addAttribute("imageOfCategory", imageOfCategoryList.get(i));
                    model.addAttribute("nameOfProduct", nameOfProductList.get(i));
                    model.addAttribute("imageOfProduct", imageOfProductList.get(i));
                    model.addAttribute("imageOfProduct", imageOfProductList.get(i));
                    model.addAttribute("composition", compositionList.get(i));
                    model.addAttribute("nutritionalValue", nutritionalValueList.get(i));
                    break;
                }
            }

            model.addAttribute("keyList", keyList);
            model.addAttribute("categoryList", categoryList);
            model.addAttribute("imageOfCategoryList", imageOfCategoryList);
            model.addAttribute("nameOfProductList", nameOfProductList);
            model.addAttribute("imageOfProductList", imageOfProductList);
            model.addAttribute("priceList", price);
            model.addAttribute("compositionList", compositionList);
            model.addAttribute("nutritionalValueList", nutritionalValueList);

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}