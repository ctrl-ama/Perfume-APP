package com.example.perfumeapp.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Perfume")
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long Id;
    private String Name;
    private String Brand;
    private String Price;
    private String Company;


    public Perfume(){

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public Perfume(Long id, String name, String brand, String price, String company) {
        Id = id;
        Name = name;
        Brand = brand;
        Price = price;
        Company = company;
    }
}
