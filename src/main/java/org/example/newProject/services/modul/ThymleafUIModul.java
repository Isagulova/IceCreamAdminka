package org.example.newProject.services.modul;

import org.example.newProject.services.FirebaseServices;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThymleafUIModul {
    private Model model;

    public ThymleafUIModul(Model model) {
        this.model = model;
    }


    public void showCategories(FirebaseServices firebaseServices) {
        CompletableFuture<List<String>> categoriesFuture = firebaseServices.getCategoriesFromFirebase();

        try {
            List<String> categories = categoriesFuture.get();

            List<String> keyListCategories = new ArrayList<>();
            List<String> categoryList = new ArrayList<>();
            List<String> imageOfCategoryList = new ArrayList<>();

            for (int i = 0; i < categories.size(); i++) {
                switch (i % 3) {
                    case 0:
                        keyListCategories.add(categories.get(i));
                        break;
                    case 1:
                        categoryList.add(categories.get(i));
                        break;
                    case 2:
                        imageOfCategoryList.add(categories.get(i));
                        break;
                }
            }

            model.addAttribute("keyListCategories", keyListCategories);
            model.addAttribute("categoryList", categoryList);
            model.addAttribute("imageOfCategoryList", imageOfCategoryList);

            List<String> uniqueCategoriesList = new ArrayList<>(new HashSet<>(categoryList));
            model.addAttribute("uniqueCategoriesList", uniqueCategoriesList);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void showProducts(FirebaseServices firebaseServices) {
        CompletableFuture<List<String>> productsFuture = firebaseServices.getProductsFromFirebase();

        try {
            List<String> products = productsFuture.get();

            List<String> keyListProducts = new ArrayList<>();
            List<String> nameOfProductList = new ArrayList<>();
            List<String> categoryOfProductList = new ArrayList<>();
            List<String> imageOfProductList = new ArrayList<>();
            List<String> descriptionList = new ArrayList<>();
            List<String> priceList = new ArrayList<>();

            for (int i = 0; i < products.size(); i++) {
                switch (i % 6) {
                    case 0:
                        keyListProducts.add(products.get(i));
                        break;
                    case 1:
                        categoryOfProductList.add(products.get(i));
                        break;
                    case 2:
                        nameOfProductList.add(products.get(i));
                        break;
                    case 3:
                        imageOfProductList.add(products.get(i));
                        break;
                    case 4:
                        descriptionList.add(products.get(i));
                        break;
                    case 5:
                        priceList.add(products.get(i));
                        break;
                }
            }

            model.addAttribute("keyListProducts", keyListProducts);
            model.addAttribute("nameOfProductList", nameOfProductList);
            model.addAttribute("categoryOfProductList", categoryOfProductList);
            model.addAttribute("imageOfProductList", imageOfProductList);
            model.addAttribute("descriptionList", descriptionList);
            model.addAttribute("priceList", priceList);

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateShowCategory(FirebaseServices firebaseServices, String updateKeyCategory) {
        CompletableFuture<List<String>> categoriesFuture = firebaseServices.getCategoriesFromFirebase();

        try {
            List<String> categories = categoriesFuture.get();

            List<String> keyListCategories = new ArrayList<>();
            List<String> categoryList = new ArrayList<>();
            List<String> imageOfCategoryList = new ArrayList<>();

            for (int i = 0; i < categories.size(); i++) {
                switch (i % 3) {
                    case 0:
                        keyListCategories.add(categories.get(i));
                        break;
                    case 1:
                        categoryList.add(categories.get(i));
                        break;
                    case 2:
                        imageOfCategoryList.add(categories.get(i));
                        break;
                }
            }

            for (int i = 0; i < keyListCategories.size(); i++) {
                if (updateKeyCategory.equals(keyListCategories.get(i))) {
                    model.addAttribute("keyCategory", keyListCategories.get(i));
                    model.addAttribute("categoryName", categoryList.get(i));
                    model.addAttribute("categoryImage", imageOfCategoryList.get(i));
                    break;
                }
            }

            model.addAttribute("keyListCategories", keyListCategories);
            model.addAttribute("categoryList", categoryList);
            model.addAttribute("imageOfCategoryList", imageOfCategoryList);

            List<String> uniqueCategoriesList = new ArrayList<>(new HashSet<>(categoryList));
            model.addAttribute("uniqueCategoriesList", uniqueCategoriesList);

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateShowProduct(FirebaseServices firebaseServices, String updateKeyProduct) {
        CompletableFuture<List<String>> productsFuture = firebaseServices.getProductsFromFirebase();

        try {
            List<String> products = productsFuture.get();

            List<String> keyListProducts = new ArrayList<>();
            List<String> nameOfProductList = new ArrayList<>();
            List<String> categoryOfProductList = new ArrayList<>();
            List<String> imageOfProductList = new ArrayList<>();
            List<String> descriptionList = new ArrayList<>();
            List<String> priceList = new ArrayList<>();

            for (int i = 0; i < products.size(); i++) {
                switch (i % 6) {
                    case 0:
                        keyListProducts.add(products.get(i));
                        break;
                    case 1:
                        categoryOfProductList.add(products.get(i));
                        break;
                    case 2:
                        nameOfProductList.add(products.get(i));
                        break;
                    case 3:
                        imageOfProductList.add(products.get(i));
                        break;
                    case 4:
                        descriptionList.add(products.get(i));
                        break;
                    case 5:
                        priceList.add(products.get(i));
                        break;
                }
            }

            for (int i = 0; i < keyListProducts.size(); i++) {
                if (updateKeyProduct.equals(keyListProducts.get(i))) {
                    model.addAttribute("keyProduct", keyListProducts.get(i));
                    model.addAttribute("productName", nameOfProductList.get(i));
                    model.addAttribute("category", categoryOfProductList.get(i));
                    model.addAttribute("productImage", imageOfProductList.get(i));
                    model.addAttribute("productDescription", descriptionList.get(i));
                    model.addAttribute("productPrice", priceList.get(i));
                    break;
                }
            }

            model.addAttribute("keyListProducts", keyListProducts);
            model.addAttribute("nameOfProductList", nameOfProductList);
            model.addAttribute("categoryOfProductList", categoryOfProductList);
            model.addAttribute("imageOfProductList", imageOfProductList);
            model.addAttribute("descriptionList", descriptionList);
            model.addAttribute("priceList", priceList);

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}



//    public void updateShow(FirebaseServices mainFirebase, String updateKey) {
//        CompletableFuture<List<String>> table = mainFirebase.getOptionsFromFirebase();
//        try {
//            List<String> all = table.get();
//
//            List<String> keyList = new ArrayList<>();
//            List<String> categoryList = new ArrayList<>();
//            List<String> imageOfCategoryList = new ArrayList<>();
//            List<String> nameOfProductList = new ArrayList<>();
//            List<String> imageOfProductList = new ArrayList<>();
//            List<String> priceList = new ArrayList<>();
//            List<String> compositionList = new ArrayList<>();
//            List<String> nutritionalValueList = new ArrayList<>();
//
//            for (int i = 0; i < all.size(); i++) {
//                switch (i % 8) {
//                    case 0:
//                        keyList.add(all.get(i));
//                        break;
//                    case 1:
//                        categoryList.add(all.get(i));
//                        break;
//                    case 2:
//                        imageOfCategoryList.add(all.get(i));
//                        break;
//                    case 3:
//                        nameOfProductList.add(all.get(i));
//                        break;
//                    case 4:
//                        imageOfProductList.add(all.get(i));
//                        break;
//                    case 5:
//                        priceList.add(all.get(i));
//                        break;
//                    case 6:
//                        compositionList.add(all.get(i));
//                        break;
//                    case 7:
//                        nutritionalValueList.add(all.get(i));
//                        break;
//                }
//            }
//
//            for (int i = 0; i < keyList.size(); i++) {
//                if (updateKey.equals(keyList.get(i))) {
//                    model.addAttribute("key", keyList.get(i));
//                    model.addAttribute("category", categoryList.get(i));
//                    model.addAttribute("imageOfCategory", imageOfCategoryList.get(i));
//                    model.addAttribute("nameOfProduct", nameOfProductList.get(i));
//                    model.addAttribute("imageOfProduct", imageOfProductList.get(i));
//                    model.addAttribute("imageOfProduct", imageOfProductList.get(i));
//                    model.addAttribute("price", priceList.get(i));
//                    model.addAttribute("composition", compositionList.get(i));
//                    model.addAttribute("nutritionalValue", nutritionalValueList.get(i));
//                    break;
//                }
//            }
//
//            model.addAttribute("keyList", keyList);
//            model.addAttribute("categoryList", categoryList);
//            model.addAttribute("imageOfCategoryList", imageOfCategoryList);
//            model.addAttribute("nameOfProductList", nameOfProductList);
//            model.addAttribute("imageOfProductList", imageOfProductList);
//            model.addAttribute("priceList", priceList);
//            model.addAttribute("compositionList", compositionList);
//            model.addAttribute("nutritionalValueList", nutritionalValueList);
//
//        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//    }