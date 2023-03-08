package bg.softuni.hookahstore.model;

import bg.softuni.hookahstore.enums.Material;
import bg.softuni.hookahstore.enums.Origin;
import jakarta.persistence.*;

@Entity
@Table(name = "blows")
public class Blow {

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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Material material;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Long getId() {
        return id;
    }

    public Blow setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Blow setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Blow setPrice(double price) {
        this.price = price;
        return this;
    }

    public Origin getOrigin() {
        return origin;
    }

    public Blow setOrigin(Origin origin) {
        this.origin = origin;
        return this;
    }

    public Material getMaterial() {
        return material;
    }

    public Blow setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Blow setDescription(String description) {
        this.description = description;
        return this;
    }
}
