package bg.softuni.hookahstore.model;

import bg.softuni.hookahstore.enums.Brand;
import jakarta.persistence.*;

@Entity
@Table(name = "coals")
public class Coal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column
    private double weight;

    @Column
    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Column
    private int size;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Long getId() {
        return id;
    }

    public Coal setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Coal setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Coal setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getWeight() {
        return weight;
    }

    public Coal setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public Coal setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public int getSize() {
        return size;
    }

    public Coal setSize(int size) {
        this.size = size;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Coal setDescription(String description) {
        this.description = description;
        return this;
    }
}
