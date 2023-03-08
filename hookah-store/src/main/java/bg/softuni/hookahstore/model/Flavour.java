package bg.softuni.hookahstore.model;

import bg.softuni.hookahstore.enums.Brand;
import bg.softuni.hookahstore.enums.Origin;
import jakarta.persistence.*;

@Entity
@Table(name = "flavours")
public class Flavour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double kg;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Origin origin;

    @Column(nullable = false)
    private String typeFlavour;

    @Column
    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Long getId() {
        return id;
    }

    public Flavour setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Flavour setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Flavour setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getKg() {
        return kg;
    }

    public Flavour setKg(double kg) {
        this.kg = kg;
        return this;
    }

    public Origin getOrigin() {
        return origin;
    }

    public Flavour setOrigin(Origin origin) {
        this.origin = origin;
        return this;
    }

    public String getTypeFlavour() {
        return typeFlavour;
    }

    public Flavour setTypeFlavour(String typeFlavour) {
        this.typeFlavour = typeFlavour;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Flavour setDescription(String description) {
        this.description = description;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public Flavour setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }
}
