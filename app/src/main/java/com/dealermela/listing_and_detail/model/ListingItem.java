package com.dealermela.listing_and_detail.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ListingItem {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<ProductImg> productImg = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ProductImg> getProductImg() {
        return productImg;
    }

    public void setProductImg(List<ProductImg> productImg) {
        this.productImg = productImg;
    }


    public class ProductImg implements Serializable {

        @SerializedName("entity_id")
        @Expose
        private String entityId;
        @SerializedName("type_id")
        @Expose
        private String typeId;
        @SerializedName("attribute_set_id")
        @Expose
        private String attributeSetId;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url_path")
        @Expose
        private String urlPath;
        @SerializedName("thumbnail")
        @Expose
        private String thumbnail;
        @SerializedName("original_sku")
        @Expose
        private String originalSku;
        @SerializedName("sku")
        @Expose
        private String sku;
        @SerializedName("rts_stone_quality")
        @Expose
        private String rtsStoneQuality;
        @SerializedName("is_sold")
        @Expose
        private String isSold;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("franch_product_id")
        @Expose
        private String franchProductId;
        @SerializedName("qty")
        @Expose
        private String qty;
        @SerializedName("dml_only")
        @Expose
        private String dmlOnly;
        @SerializedName("is_salable")
        @Expose
        private String isSalable;
        @SerializedName("custom_price")
        @Expose
        private Float customPrice;
        @SerializedName("stock")
        @Expose
        private String stock;
        @SerializedName("download_flag")
        @Expose
        private Integer download_flag;

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrlPath() {
            return urlPath;
        }

        public void setUrlPath(String urlPath) {
            this.urlPath = urlPath;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getOriginalSku() {
            return originalSku;
        }

        public void setOriginalSku(String originalSku) {
            this.originalSku = originalSku;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public String getRtsStoneQuality() {
            return rtsStoneQuality;
        }

        public void setRtsStoneQuality(String rtsStoneQuality) {
            this.rtsStoneQuality = rtsStoneQuality;
        }

        public String getIsSold() {
            return isSold;
        }

        public void setIsSold(String isSold) {
            this.isSold = isSold;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFranchProductId() {
            return franchProductId;
        }

        public void setFranchProductId(String franchProductId) {
            this.franchProductId = franchProductId;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public String getDmlOnly() {
            return dmlOnly;
        }

        public void setDmlOnly(String dmlOnly) {
            this.dmlOnly = dmlOnly;
        }

        public String getIsSalable() {
            return isSalable;
        }

        public void setIsSalable(String isSalable) {
            this.isSalable = isSalable;
        }


        public Float getCustomPrice() {
            return customPrice;
        }

        public void setCustomPrice(Float customPrice) {
            this.customPrice = customPrice;
        }

        public String getStock() {
            return stock;
        }

        public void setStock(String stock) {
            this.stock = stock;
        }

        public Integer getDownload_flag() {
            return download_flag;
        }

        public void setDownload_flag(Integer download_flag) {
            this.download_flag = download_flag;
        }
    }
}
