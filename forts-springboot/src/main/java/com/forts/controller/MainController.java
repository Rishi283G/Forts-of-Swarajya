package com.forts.controller;

import com.forts.model.ContactMessage;
import com.forts.model.Fort;
import com.forts.service.ContactService;
import com.forts.service.FortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

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
        Optional<Fort> fort = fortService.getFortById(id);
        if (fort.isPresent()) {
            model.addAttribute("fort", fort.get());
            return "fort-detail";
        } else {
            return "redirect:/forts";
        }
    }

    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        List<Fort> results = fortService.searchForts(query);
        model.addAttribute("forts", results);
        model.addAttribute("searchQuery", query);
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
        contactService.saveMessage(contactMessage);
        model.addAttribute("successMessage", "Thank you for contacting us! We will get back to you shortly.");
        return "contact";
    }

    @GetMapping("/map")
    public String map() {
        return "map";
    }
}
