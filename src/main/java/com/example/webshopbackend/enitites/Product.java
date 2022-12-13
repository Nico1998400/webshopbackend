package com.example.webshopbackend.enitites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;

    @Column()
    private String productName;

    @Column()
    private String productTitle;

    @Column()
    private String description;

    @Column()
    private String details;

    @Column()
    private String size;

    @Column()
    private Long price;

    @Lob
    @Column() // Måste lägga till i Jpa Repository hela produkt.
    private String photo;


    public Product(String details, String size, int productID, String productName, String productTitle, String description, Long price, String photo) {
        this.productID = productID;
        this.productName = productName;
        this.productTitle = productTitle;
        this.description = description;
        this.price = price;
        this.photo = photo;
        this.details = details;
        this.size = size;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDetails() {
        return details;
    }

    public String getSize() {
        return size;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}



