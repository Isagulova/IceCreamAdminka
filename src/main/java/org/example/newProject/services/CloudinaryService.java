package org.example.newProject.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CloudinaryService {

    private final Cloudinary cloudinary;
    private final Map params = ObjectUtils.asMap(
            "folder", "IceCream",
            "resource_type", "auto"
    );

    public CloudinaryService() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dullrqgcl",
                "api_key", "872948833882381",
                "api_secret", "z49TFTMDWq86YH6n3Dk-Zn-Zs9Q"));
    }

    public String uploadCloudinary(File file) {
        try {
            Map result = cloudinary.uploader().upload(file, params);
            return (String) result.get("url");
        } catch (IOException exception) {
            return "error";
        }
    }
}
