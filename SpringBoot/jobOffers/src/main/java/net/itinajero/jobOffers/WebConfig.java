package net.itinajero.jobOffers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String uploadPath = "file:" + System.getProperty("java.io.tmpdir") + "/myapp-uploads/"; // For images
        String uploadPath2 = "file:" + System.getProperty("java.io.tmpdir") + "/myapp-uploads/files/"; // For files
        // Serve files from the myapp-uploads directory
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations(uploadPath,uploadPath2);
            //                                                                          Windows: myapp-uploads/ , Linux :/myapp-uploads/
    }
}
// Map the virtual path "/uploads/**" to actual directories in the temp folder.
//
// When a user accesses a URL like:
//     /uploads/BC64I6IKgit_learning_notes_no_emoji.pdf
//
// Spring will look for the file in this order:
// 1. file:/tmp/myapp-uploads/BC64I6IKgit_learning_notes_no_emoji.pdf
// 2. file:/tmp/myapp-uploads/files/BC64I6IKgit_learning_notes_no_emoji.pdf
//
// This allows serving static files from both base and subdirectories under /myapp-uploads/.
// Subdirectories like "/uploads/files/filename.pdf" or "/uploads/images/photo.jpg" are supported.

