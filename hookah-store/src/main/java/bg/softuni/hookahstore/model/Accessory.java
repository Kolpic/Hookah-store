package bg.softuni.hookahstore.model;

import bg.softuni.hookahstore.enums.Brand;
import bg.softuni.hookahstore.enums.Material;
import bg.softuni.hookahstore.enums.Origin;
import jakarta.persistence.*;

@Entity
@Table(name = "accessories")
public class Accessory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column
    @Enumerated(EnumType.STRING)
    private Origin origin;

    @Column
    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Column
    @Enumerated(EnumType.STRING)
    private Material material;

    @Column
    private String color;

    @Column(nullable = false)
    private String pictureUrl;

    @Column(nullable = false)
    private boolean isAvailable;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Long getId() {
        return id;
    }

    public Accessory setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Accessory setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Accessory setPrice(double price) {
        this.price = price;
        return this;
    }

    public Origin getOrigin() {
        return origin;
    }

    public Accessory setOrigin(Origin origin) {
        this.origin = origin;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public Accessory setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public Material getMaterial() {
        return material;
    }

    public Accessory setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Accessory setColor(String color) {
        this.color = color;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Accessory setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public Accessory setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Accessory setAvailable(boolean available) {
        isAvailable = available;
        return this;
    }
}
