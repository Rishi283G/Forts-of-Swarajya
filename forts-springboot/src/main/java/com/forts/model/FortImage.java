package com.forts.model;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class FortImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fort_id")
    private Fort fort;

    @Column(name = "image_path")
    private String imagePath;

    public FortImage() {}

    public FortImage(Fort fort, String imagePath) {
        this.fort = fort;
        this.imagePath = imagePath;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Fort getFort() { return fort; }
    public void setFort(Fort fort) { this.fort = fort; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
}
