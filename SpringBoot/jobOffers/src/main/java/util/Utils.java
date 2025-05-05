package util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    public static String saveFile(MultipartFile multiPart, String route) {
        String originalName = multiPart.getOriginalFilename(); // "photo.png"
        originalName = originalName.replace(" ", "-");//Ensure the file name has no spaces
        originalName = randomAlphaNumeric(8) + originalName; //Do a unique numer for the pho uploaded

        File directory = new File(route);//Create the directory file object with the route to place
        //the image and be able to create the dir and path to place it

        if (!directory.exists()) {
            directory.mkdirs(); // Create directory if it doesn't exist
        }

        try {
            File imageFile = new File(directory, originalName); // "Save the image in that directory" / Get the full path: /tmp/myapp-uploads/photo.png
            System.out.println("Saving to: " + imageFile.getAbsolutePath());// Display the absolute path to place the image
            multiPart.transferTo(imageFile); //  takes the uploaded file (in memory) and writes it to the file system
            return originalName;//"photo.png"

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static String randomAlphaNumeric(int count){
        String CHARACTERES = "ABCDEFJHIJKMLNOPQRSTUVWXYZ123456789";
        StringBuilder builder = new StringBuilder();
        while(count -- !=0){
            int character = (int) (Math.random() * CHARACTERES.length());
            builder.append(CHARACTERES.charAt(character));
        }
        return builder.toString();
    }

}
