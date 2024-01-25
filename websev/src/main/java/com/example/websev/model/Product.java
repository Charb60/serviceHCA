package com.example.websev.model;

public class Product {
    private Long productId;
    private String selectedPropertyType;
    private String selectedPriceRange;
    private String selectedRoomRange;
    private String selectedBathroomRange;
    private String selectedLocationRange;
    private String selectedAreaRange;
    private String selectedFloorRange;
    private boolean isChecked;
private String productName;
private String productTitle;
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

    public String getSelectedBathroomRange() {
        return selectedBathroomRange;
    }

    public void setSelectedBathroomRange(String selectedBathroomRange) {
        this.selectedBathroomRange = selectedBathroomRange;
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

    public void setSlectedFloorRange(String selectedFloorRange) {
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
}

