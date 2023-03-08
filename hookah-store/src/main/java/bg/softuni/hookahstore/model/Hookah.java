package bg.softuni.hookahstore.model;

import bg.softuni.hookahstore.enums.Material;
import bg.softuni.hookahstore.enums.Origin;
import jakarta.persistence.*;

@Entity
@Table(name = "hookahs")
public class Hookah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column
    private int kg;

    @Column
    private int length;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Origin origin;

    @Column
    private String color;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Material material;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Long getId() {
        return id;
    }

    public Hookah setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Hookah setName(String name) {
        this.name = name;
        return this;
    }

    public int getKg() {
        return kg;
    }

    public Hookah setKg(int kg) {
        this.kg = kg;
        return this;
    }

    public int getLength() {
        return length;
    }

    public Hookah setLength(int length) {
        this.length = length;
        return this;
    }

    public Origin getOrigin() {
        return origin;
    }

    public Hookah setOrigin(Origin origin) {
        this.origin = origin;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Hookah setColor(String color) {
        this.color = color;
        return this;
    }

    public Material getMaterial() {
        return material;
    }

    public Hookah setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Hookah setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Hookah setDescription(String description) {
        this.description = description;
        return this;
    }
}
