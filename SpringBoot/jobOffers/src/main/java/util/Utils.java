package util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    public static String saveFile(MultipartFile multiPart, String route) {
        String originalName = multiPart.getOriginalFilename();
        File directory = new File(route);

        if (!directory.exists()) {
            directory.mkdirs(); // Create directory if it doesn't exist
        }

        try {
            File imageFile = new File(directory, originalName);
            System.out.println("Saving to: " + imageFile.getAbsolutePath());
            multiPart.transferTo(imageFile);
            return originalName;

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

}
