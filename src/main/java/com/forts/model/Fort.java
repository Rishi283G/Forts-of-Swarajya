package com.forts.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "forts")
public class Fort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 255)
    private String location;

    @Column(length = 50)
    private String type; // e.g., Hill Fort, Sea Fort

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "main_image")
    private String mainImage;

    @OneToMany(mappedBy = "fort", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FortImage> images;

    public Fort() {}

    public Fort(String name, String location, String type, String description, String mainImage) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.description = description;
        this.mainImage = mainImage;
    }

    // Getters and Setters manually if Lombok fails or just to be safe
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getMainImage() { return mainImage; }
    public void setMainImage(String mainImage) { this.mainImage = mainImage; }

    public List<FortImage> getImages() { return images; }
    public void setImages(List<FortImage> images) { this.images = images; }
}
