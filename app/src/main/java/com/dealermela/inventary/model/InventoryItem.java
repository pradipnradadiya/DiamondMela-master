package com.dealermela.inventary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class InventoryItem {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("min_diamond_weight")
    @Expose
    private String minDiamondWeight;
    @SerializedName("max_diamond_weight")
    @Expose
    private String maxDiamondWeight;
    @SerializedName("min_metal_weight")
    @Expose
    private String minMetalWeight;
    @SerializedName("max_metal_weight")
    @Expose
    private String maxMetalWeight;
    @SerializedName("data")
    @Expose
    private ArrayList<Datum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMinDiamondWeight() {
        return minDiamondWeight;
    }

    public void setMinDiamondWeight(String minDiamondWeight) {
        this.minDiamondWeight = minDiamondWeight;
    }

    public String getMaxDiamondWeight() {
        return maxDiamondWeight;
    }

    public void setMaxDiamondWeight(String maxDiamondWeight) {
        this.maxDiamondWeight = maxDiamondWeight;
    }

    public String getMinMetalWeight() {
        return minMetalWeight;
    }

    public void setMinMetalWeight(String minMetalWeight) {
        this.minMetalWeight = minMetalWeight;
    }

    public String getMaxMetalWeight() {
        return maxMetalWeight;
    }

    public void setMaxMetalWeight(String maxMetalWeight) {
        this.maxMetalWeight = maxMetalWeight;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("entity_id")
        @Expose
        private String entityId;
        @SerializedName("sku")
        @Expose
        private String sku;
        @SerializedName("product_name")
        @Expose
        private String productName;
        @SerializedName("stone_shape")
        @Expose
        private Object stoneShape;
        @SerializedName("certificate_no")
        @Expose
        private String certificateNo;
        @SerializedName("approval_memo_generated")
        @Expose
        private Object approvalMemoGenerated;
        @SerializedName("approval_invoice_generated")
        @Expose
        private Object approvalInvoiceGenerated;
        @SerializedName("return_memo_generated")
        @Expose
        private Object returnMemoGenerated;
        @SerializedName("type_id")
        @Expose
        private String typeId;
        @SerializedName("attribute_set_id")
        @Expose
        private String attributeSetId;
        @SerializedName("isreadytoship")
        @Expose
        private String isreadytoship;
        @SerializedName("rts_stone_quality")
        @Expose
        private String rtsStoneQuality;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("custom_price")
        @Expose
        private String customPrice;
        @SerializedName("inventory_status")
        @Expose
        private String inventoryStatus;
        @SerializedName("inventory_status_value")
        @Expose
        private String inventoryStatusValue;
        @SerializedName("pr_name")
        @Expose
        private String prName;
        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("metal_quality")
        @Expose
        private String metalQuality;
        @SerializedName("virtual_product_manager")
        @Expose
        private Object virtualProductManager;
        @SerializedName("metal_quality_value")
        @Expose
        private String metalQualityValue;
        @SerializedName("total_carat")
        @Expose
        private String totalCarat;
        @SerializedName("diamond_shape")
        @Expose
        private String diamondShape;
        @SerializedName("metal_weight")
        @Expose
        private String metalWeight;
        @SerializedName("is_returned")
        @Expose
        private Object isReturned;
        @SerializedName("product_image")
        @Expose
        private String productImage;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("qrcode_img")
        @Expose
        private String qrcodeImg;
        @SerializedName("availability")
        @Expose
        private String availability;

        private boolean isOpen = false;

        private boolean isSelected = false;

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Object getStoneShape() {
            return stoneShape;
        }

        public void setStoneShape(Object stoneShape) {
            this.stoneShape = stoneShape;
        }

        public String getCertificateNo() {
            return certificateNo;
        }

        public void setCertificateNo(String certificateNo) {
            this.certificateNo = certificateNo;
        }

        public Object getApprovalMemoGenerated() {
            return approvalMemoGenerated;
        }

        public void setApprovalMemoGenerated(Object approvalMemoGenerated) {
            this.approvalMemoGenerated = approvalMemoGenerated;
        }

        public Object getApprovalInvoiceGenerated() {
            return approvalInvoiceGenerated;
        }

        public void setApprovalInvoiceGenerated(Object approvalInvoiceGenerated) {
            this.approvalInvoiceGenerated = approvalInvoiceGenerated;
        }

        public Object getReturnMemoGenerated() {
            return returnMemoGenerated;
        }

        public void setReturnMemoGenerated(Object returnMemoGenerated) {
            this.returnMemoGenerated = returnMemoGenerated;
        }

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public String getAttributeSetId() {
            return attributeSetId;
        }

        public void setAttributeSetId(String attributeSetId) {
            this.attributeSetId = attributeSetId;
        }

        public String getIsreadytoship() {
            return isreadytoship;
        }

        public void setIsreadytoship(String isreadytoship) {
            this.isreadytoship = isreadytoship;
        }

        public String getRtsStoneQuality() {
            return rtsStoneQuality;
        }

        public void setRtsStoneQuality(String rtsStoneQuality) {
            this.rtsStoneQuality = rtsStoneQuality;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCustomPrice() {
            return customPrice;
        }

        public void setCustomPrice(String customPrice) {
            this.customPrice = customPrice;
        }

        public String getInventoryStatus() {
            return inventoryStatus;
        }

        public void setInventoryStatus(String inventoryStatus) {
            this.inventoryStatus = inventoryStatus;
        }

        public String getInventoryStatusValue() {
            return inventoryStatusValue;
        }

        public void setInventoryStatusValue(String inventoryStatusValue) {
            this.inventoryStatusValue = inventoryStatusValue;
        }

        public String getPrName() {
            return prName;
        }

        public void setPrName(String prName) {
            this.prName = prName;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getMetalQuality() {
            return metalQuality;
        }

        public void setMetalQuality(String metalQuality) {
            this.metalQuality = metalQuality;
        }

        public Object getVirtualProductManager() {
            return virtualProductManager;
        }

        public void setVirtualProductManager(Object virtualProductManager) {
            this.virtualProductManager = virtualProductManager;
        }

        public String getMetalQualityValue() {
            return metalQualityValue;
        }

        public void setMetalQualityValue(String metalQualityValue) {
            this.metalQualityValue = metalQualityValue;
        }

        public String getTotalCarat() {
            return totalCarat;
        }

        public void setTotalCarat(String totalCarat) {
            this.totalCarat = totalCarat;
        }

        public String getDiamondShape() {
            return diamondShape;
        }

        public void setDiamondShape(String diamondShape) {
            this.diamondShape = diamondShape;
        }

        public String getMetalWeight() {
            return metalWeight;
        }

        public void setMetalWeight(String metalWeight) {
            this.metalWeight = metalWeight;
        }

        public Object getIsReturned() {
            return isReturned;
        }

        public void setIsReturned(Object isReturned) {
            this.isReturned = isReturned;
        }

        public String getProductImage() {
            return productImage;
        }

        public void setProductImage(String productImage) {
            this.productImage = productImage;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getQrcodeImg() {
            return qrcodeImg;
        }

        public void setQrcodeImg(String qrcodeImg) {
            this.qrcodeImg = qrcodeImg;
        }

        public String getAvailability() {
            return availability;
        }

        public void setAvailability(String availability) {
            this.availability = availability;
        }

        public boolean isOpen() {
            return isOpen;
        }

        public void setOpen(boolean open) {
            isOpen = open;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }
    }

}
