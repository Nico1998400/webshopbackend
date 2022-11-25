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
    private int price;

    @Lob
    @Column(name = "photo") // Måste lägga till i Jpa Repository hela produkt.
    private byte[] photo;


    public Product(int productID, String productName, String productTitle, String description, int price, byte[] photo) {
        this.productID = productID;
        this.productName = productName;
        this.productTitle = productTitle;
        this.description = description;
        this.price = price;
        this.photo = photo;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

}

