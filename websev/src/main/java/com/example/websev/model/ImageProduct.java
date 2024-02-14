package com.example.websev.model;

import javax.persistence.*;

@Entity
@Table(name = "imageproduct")
public class ImageProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;

    @ManyToOne
//    @JoinColumn(name = "product_id")
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @Lob
    @Column(name = "image")
    private byte[] image;

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
