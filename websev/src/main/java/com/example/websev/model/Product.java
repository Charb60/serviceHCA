package com.example.websev.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ImageProduct> images;




    @Column(name = "selected_property_type")
    private String selectedPropertyType;
    @Column(name = "selected_price_range")
    private String selectedPriceRange;
    @Column(name = "selected_room_range")
    private String selectedRoomRange;
    @Column(name = "selected_bath_room_range")
    private String selectedBathRoomRange;
    @Column(name = "selected_location_range")
    private String selectedLocationRange;
    @Column(name = "selected_area_range")
    private String selectedAreaRange;
    @Column(name = "selected_floor_range")
    private String selectedFloorRange;
    @Column(name = "is_checked")
    private boolean isChecked;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_title")
    private String productTitle;
    @Column(name = "latitude")
    private String latitude;
    @Column(name = "longitude")
    private String longitude;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSelectedPropertyType() {
        return selectedPropertyType;
    }

    public void setSelectedPropertyType(String selectedPropertyType) {
        this.selectedPropertyType = selectedPropertyType;
    }

    public String getSelectedPriceRange() {
        return selectedPriceRange;
    }

    public void setSelectedPriceRange(String selectedPriceRange) {
        this.selectedPriceRange = selectedPriceRange;
    }

    public String getSelectedRoomRange() {
        return selectedRoomRange;
    }

    public void setSelectedRoomRange(String selectedRoomRange) {
        this.selectedRoomRange = selectedRoomRange;
    }

    public String getSelectedBathRoomRange() {
        return selectedBathRoomRange;
    }

    public void setSelectedBathRoomRange(String selectedBathRoomRange) {
        this.selectedBathRoomRange = selectedBathRoomRange;
    }

    public String getSelectedLocationRange() {
        return selectedLocationRange;
    }

    public void setSelectedLocationRange(String selectedLocationRange) {
        this.selectedLocationRange = selectedLocationRange;
    }

    public String getSelectedAreaRange() {
        return selectedAreaRange;
    }

    public void setSelectedAreaRange(String selectedAreaRange) {
        this.selectedAreaRange = selectedAreaRange;
    }

    public String getSelectedFloorRange() {
        return selectedFloorRange;
    }

    public void setSelectedFloorRange(String selectedFloorRange) {
        this.selectedFloorRange = selectedFloorRange;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<ImageProduct> getImages() {
        return images;
    }

    public void setImages(List<ImageProduct> images) {
        this.images = images;
    }

}

