package org.example.newProject.controller;

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

import java.io.File;
import java.io.IOException;

@Controller
public class MainController {
    private FirebaseServices productFirebase = new FirebaseServices("ice_cream");
    //    private final FirebaseServices announcementsFirebase = new FirebaseServices("announcements");
    private ThymleafUIModul thymleafUIModul;

    @GetMapping("/index")
    public String getMain(Model model) {
        thymleafUIModul = new ThymleafUIModul(model);
        thymleafUIModul.showData(productFirebase);
        return "index";
    }

    @PostMapping("/index00")
    public String postMain(
            @RequestParam(defaultValue = "none") String type,
            @RequestParam("category") String category,
            @RequestParam("imageOfCategory") MultipartFile imageOfCategory,
            @RequestParam("nameOfProduct") String nameOfProduct,
            @RequestParam("imageOfProduct") MultipartFile imageOfProduct,
            @RequestParam("price") String price,
            @RequestParam("composition") String composition,
            @RequestParam("nutritionalValue") String nutritionalValue,
            Model model)
            throws IOException {

        CloudinaryService cloudinaryService = new CloudinaryService();

        String imageLinkOfCategory = cloudinaryService.uploadCloudinary(FileConverter.convertMultipartFileToFile(imageOfCategory));
        String imageLinkOfProduct = cloudinaryService.uploadCloudinary(FileConverter.convertMultipartFileToFile(imageOfProduct));

        // Создаем объект AnnouncementsEntity с несколькими изображениями
        ProductEntity productEntity = new ProductEntity(category, imageLinkOfCategory, nameOfProduct, imageLinkOfProduct, price, composition, nutritionalValue);
        System.out.println(type);

        if (type.equals("none")) {
            productFirebase.saveMain(productEntity);
        } else {
            productFirebase.updateByKey(type, productEntity);
        }

        thymleafUIModul = new ThymleafUIModul(model);
        thymleafUIModul.showData(productFirebase);
        return "index";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@RequestParam("update_key") String update_key, Model model) {
        thymleafUIModul = new ThymleafUIModul(model);
        thymleafUIModul.updateShow(productFirebase, update_key);
        System.out.println("keyList");
        return "index";
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("delete_key") String delete_key) {
        productFirebase.deleteByKey(delete_key);
        return "redirect:/index";
    }
}