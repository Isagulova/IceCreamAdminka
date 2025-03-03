package org.example.newProject.controller;

import org.example.newProject.model.CategoryEntity;
import org.example.newProject.model.ProductEntity;
import org.example.newProject.services.CloudinaryService;
import org.example.newProject.services.FirebaseServices;
import org.example.newProject.services.modul.FileConverter;
import org.example.newProject.services.modul.ThymleafUIModul;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MainController {
    private FirebaseServices categoryFirebase = new FirebaseServices("ice_cream/categories");
    private FirebaseServices productFirebase = new FirebaseServices("ice_cream/products");
    //    private FirebaseServices categoryFirebase = new FirebaseServices("ice_cream/categories");
//    private FirebaseServices productFirebase = new FirebaseServices("ice_cream/products");
    private ThymleafUIModul thymleafUIModul;

    @GetMapping("/index")
    public String getMain(Model model) {
        thymleafUIModul = new ThymleafUIModul(model);
        thymleafUIModul.showCategories(categoryFirebase);
        return "categoryAdmin";
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        thymleafUIModul = new ThymleafUIModul(model);
        thymleafUIModul.showProducts(productFirebase);
        thymleafUIModul.showCategories(productFirebase);
        return "productAdmin";
    }

    @PostMapping("/index")
    public String postMain(
            @RequestParam(defaultValue = "none") String type,
            @RequestParam("categoryName") String categoryName,
            @RequestParam("categoryImage") MultipartFile categoryImage,
            Model model)
            throws IOException {

        CloudinaryService cloudinaryService = new CloudinaryService();

        String imageLinkOfCategory = cloudinaryService.uploadCloudinary(FileConverter.convertMultipartFileToFile(categoryImage));

        CategoryEntity categoryEntity = new CategoryEntity(categoryName, imageLinkOfCategory);
        System.out.println(type);

        if (type.equals("none")) {
            categoryFirebase.saveCategory(categoryEntity);
        } else {
            categoryFirebase.updateCategoryByKey(type, categoryEntity);
        }

//        categoryFirebase.saveCategory(categoryEntity);

        thymleafUIModul = new ThymleafUIModul(model);
        thymleafUIModul.showCategories(categoryFirebase);
        return "categoryAdmin";
    }

    @PostMapping("/products")
    public String postProducts(
            @RequestParam(defaultValue = "none1") String type,
            @RequestParam("productName") String productName,
            @RequestParam("productCategory") String productCategory,
            @RequestParam("productImage") MultipartFile productImage,
            @RequestParam("productPrice") Double productPrice,
            @RequestParam("productDescription") String productDescription,
            Model model)
            throws IOException {

        CloudinaryService cloudinaryService = new CloudinaryService();

        String imageLinkOfProduct = cloudinaryService.uploadCloudinary(FileConverter.convertMultipartFileToFile(productImage));

        ProductEntity productEntity = new ProductEntity(productName, productCategory, imageLinkOfProduct, productPrice, productDescription);
        System.out.println(type);

        if (type.equals("none1")) {
            productFirebase.saveProduct(productEntity);
        } else {
            productFirebase.updateProductByKey(type, productEntity);
        }

//        productFirebase.saveProduct(productEntity);

        thymleafUIModul = new ThymleafUIModul(model);
        thymleafUIModul.showProducts(productFirebase);
        return "productAdmin";
    }


    @PostMapping("/updateCategory")
    public String updateCategory(@RequestParam("updateCategory_key") String updateKeyCategory, Model model) {
        thymleafUIModul = new ThymleafUIModul(model);
        thymleafUIModul.updateShowCategory(categoryFirebase, updateKeyCategory);
        System.out.println("keyList11");
        return "categoryAdmin";
    }

    @PostMapping("/deleteCategory")
    public String deleteCategory(@RequestParam("deleteCategory_key") String deleteKeyCategory) {
        categoryFirebase.deleteCategoryByKey(deleteKeyCategory);
        return "redirect:/index";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@RequestParam("updateProduct_key") String updateKeyProduct, Model model) {
        thymleafUIModul = new ThymleafUIModul(model);
        thymleafUIModul.showCategories(productFirebase);
        thymleafUIModul.updateShowProduct(productFirebase, updateKeyProduct);
        System.out.println("keyList22");
        return "productAdmin";
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("deleteProduct_key") String delete_key) {
        productFirebase.deleteProductByKey(delete_key);
        return "redirect:/products";
    }
}