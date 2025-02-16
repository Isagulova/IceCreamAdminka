//package org.example.newProject.services;
//
//import com.cloudinary.Cloudinary;
//import com.cloudinary.utils.ObjectUtils;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Map;
//
//public class CloudinaryService {
//
//    private final Cloudinary cloudinary;
//    private final Map params = ObjectUtils.asMap(
//            "folder", "KTMU_gram",
//            "resource_type", "auto"
//    );
//
//    public CloudinaryService() {
//        cloudinary = new Cloudinary(ObjectUtils.asMap(
//                "cloud_name", "dpkxkjwmy",
//                "api_key", "163832694684664",
//                "api_secret", "YDYzDLzJaQIa4mghVhvX96tLXZk"));
//    }
//
//    public String uploadCloudinary(File file) {
//        try {
//            Map result = cloudinary.uploader().upload(file, params);
//            return (String) result.get("url");
//        } catch (IOException exception) {
//            return "error";
//        }
//    }
//}
