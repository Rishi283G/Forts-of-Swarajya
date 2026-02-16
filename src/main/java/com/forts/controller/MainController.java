package com.forts.controller;

import com.forts.model.ContactMessage;
import com.forts.model.Fort;
import com.forts.service.ContactService;
import com.forts.service.FortService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private FortService fortService;

    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/forts")
    public String listForts(Model model) {
        List<Fort> forts = fortService.getAllForts();
        model.addAttribute("forts", forts);
        return "forts";
    }

    @GetMapping("/fort/{id}")
    public String fortDetail(@PathVariable Long id, Model model) {
        logger.info("Fetching fort details for ID: {}", id);
        
        try {
            Fort fort = fortService.getFortById(id);
            model.addAttribute("fort", fort);

            List<String> galleryPaths = new ArrayList<>();
            
            // 1. Prioritize galleryImages comma-separated string
            if (fort.getGalleryImages() != null && !fort.getGalleryImages().isEmpty()) {
                String[] images = fort.getGalleryImages().split(",");
                for (String img : images) {
                    String trimmed = img.trim();
                    if (!trimmed.isEmpty()) {
                        // Ensure it has the full path if it's just a filename
                        if (!trimmed.startsWith("/")) {
                            galleryPaths.add("/images/" + trimmed);
                        } else {
                            galleryPaths.add(trimmed);
                        }
                    }
                }
            } 
            
            // 2. Fallback to images collection if galleryPaths is still empty
            if (galleryPaths.isEmpty() && fort.getImages() != null) {
                for (com.forts.model.FortImage fi : fort.getImages()) {
                    galleryPaths.add(fi.getImagePath());
                }
            }

            model.addAttribute("galleryPaths", galleryPaths);
            return "fort-details";
        } catch (RuntimeException e) {
            logger.warn("Fort not found with ID: {}", id);
            return "redirect:/forts";
        }
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "query", required = false) String query, Model model) {
        logger.info("Search request with query: {}", query);
        
        // Validate search query
        if (query == null || query.trim().isEmpty()) {
            logger.warn("Empty search query received");
            return "redirect:/forts";
        }
        
        // Sanitize query (basic XSS prevention)
        String sanitizedQuery = query.trim();
        if (sanitizedQuery.length() > 100) {
            sanitizedQuery = sanitizedQuery.substring(0, 100);
        }
        
        List<Fort> results = fortService.searchForts(sanitizedQuery);
        logger.info("Found {} results for query: {}", results.size(), sanitizedQuery);
        
        model.addAttribute("forts", results);
        model.addAttribute("searchQuery", sanitizedQuery);
        return "forts"; // Reuse the forts list template
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("contactMessage", new ContactMessage());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(@ModelAttribute ContactMessage contactMessage, Model model) {
        logger.info("Contact form submitted by: {}", contactMessage.getName());
        
        try {
            // Basic validation
            if (contactMessage.getName() == null || contactMessage.getName().trim().isEmpty()) {
                model.addAttribute("errorMessage", "Name is required");
                return "contact";
            }
            
            if (contactMessage.getEmail() == null || contactMessage.getEmail().trim().isEmpty()) {
                model.addAttribute("errorMessage", "Email is required");
                return "contact";
            }
            
            contactService.saveMessage(contactMessage);
            logger.info("Contact message saved successfully for: {}", contactMessage.getName());
            model.addAttribute("successMessage", "Thank you for contacting us! We will get back to you shortly.");
        } catch (Exception e) {
            logger.error("Error saving contact message", e);
            model.addAttribute("errorMessage", "An error occurred. Please try again later.");
        }
        
        return "contact";
    }

    @GetMapping("/map")
    public String map() {
        return "map";
    }
}
