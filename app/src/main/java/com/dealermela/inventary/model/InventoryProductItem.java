package com.dealermela.inventary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class InventoryProductItem {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private ArrayList<Datum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        private Integer entityId;
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
        private Integer attributeSetId;
        @SerializedName("isreadytoship")
        @Expose
        private Integer isreadytoship;
        @SerializedName("rts_position")
        @Expose
        private Object rtsPosition;
        @SerializedName("rts_stone_quality")
        @Expose
        private String rtsStoneQuality;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("custom_price")
        @Expose
        private String customPrice;
        @SerializedName("inventory_status")
        @Expose
        private Integer inventoryStatus;
        @SerializedName("inventory_status_value")
        @Expose
        private String inventoryStatusValue;
        @SerializedName("pr_name")
        @Expose
        private String prName;
        @SerializedName("category_id")
        @Expose
        private Integer categoryId;
        @SerializedName("metal_quality")
        @Expose
        private Integer metalQuality;
        @SerializedName("virtual_product_manager")
        @Expose
        private Object virtualProductManager;
        @SerializedName("metal_quality_value")
        @Expose
        private String metalQualityValue;
        @SerializedName("total_carat")
        @Expose
        private Double totalCarat;
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
        private Object productImage;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("qrcode_img")
        @Expose
        private String qrcodeImg;
        @SerializedName("diamond_quality")
        @Expose
        private String diamondQuality;

        public Integer getEntityId() {
            return entityId;
        }

        public void setEntityId(Integer entityId) {
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

        public Integer getAttributeSetId() {
            return attributeSetId;
        }

        public void setAttributeSetId(Integer attributeSetId) {
            this.attributeSetId = attributeSetId;
        }

        public Integer getIsreadytoship() {
            return isreadytoship;
        }

        public void setIsreadytoship(Integer isreadytoship) {
            this.isreadytoship = isreadytoship;
        }

        public Object getRtsPosition() {
            return rtsPosition;
        }

        public void setRtsPosition(Object rtsPosition) {
            this.rtsPosition = rtsPosition;
        }

        public String getRtsStoneQuality() {
            return rtsStoneQuality;
        }

        public void setRtsStoneQuality(String rtsStoneQuality) {
            this.rtsStoneQuality = rtsStoneQuality;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getCustomPrice() {
            return customPrice;
        }

        public void setCustomPrice(String customPrice) {
            this.customPrice = customPrice;
        }

        public Integer getInventoryStatus() {
            return inventoryStatus;
        }

        public void setInventoryStatus(Integer inventoryStatus) {
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

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        public Integer getMetalQuality() {
            return metalQuality;
        }

        public void setMetalQuality(Integer metalQuality) {
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

        public Double getTotalCarat() {
            return totalCarat;
        }

        public void setTotalCarat(Double totalCarat) {
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

        public Object getProductImage() {
            return productImage;
        }

        public void setProductImage(Object productImage) {
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

        public String getDiamondQuality() {
            return diamondQuality;
        }

        public void setDiamondQuality(String diamondQuality) {
            this.diamondQuality = diamondQuality;
        }

    }
}
