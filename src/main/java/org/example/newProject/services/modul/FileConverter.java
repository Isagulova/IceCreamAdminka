package org.example.newProject.services.modul;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileConverter {

    public static File convertMultipartFileToFile(MultipartFile multipartFile) {
        try {
            // Create a temporary file
            File file = File.createTempFile("temp", multipartFile.getOriginalFilename());

            try (InputStream inputStream = multipartFile.getInputStream();
                 FileOutputStream outputStream = new FileOutputStream(file)) {

                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }

            return file;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}