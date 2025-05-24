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
