package com.dealermela.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MostSellingItem {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("entity_id")
        @Expose
        private String entityId;
        @SerializedName("type_id")
        @Expose
        private String typeId;
        @SerializedName("attribute_set_id")
        @Expose
        private String attributeSetId;
        @SerializedName("custom_price")
        @Expose
        private String customPrice;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("small_image")
        @Expose
        private Object smallImage;
        @SerializedName("thumbnail")
        @Expose
        private Object thumbnail;
        @SerializedName("sku")
        @Expose
        private String sku;
        @SerializedName("indexed_price")
        @Expose
        private String indexedPrice;
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("final_price")
        @Expose
        private String finalPrice;
        @SerializedName("minimal_price")
        @Expose
        private String minimalPrice;
        @SerializedName("min_price")
        @Expose
        private String minPrice;
        @SerializedName("max_price")
        @Expose
        private String maxPrice;
        @SerializedName("tier_price")
        @Expose
        private Object tierPrice;
        @SerializedName("sold_quantity")
        @Expose
        private Object soldQuantity;
        @SerializedName("cat_index_position")
        @Expose
        private String catIndexPosition;

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

        public String getCustomPrice() {
            return customPrice;
        }

        public void setCustomPrice(String customPrice) {
            this.customPrice = customPrice;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getSmallImage() {
            return smallImage;
        }

        public void setSmallImage(Object smallImage) {
            this.smallImage = smallImage;
        }

        public Object getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Object thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public String getIndexedPrice() {
            return indexedPrice;
        }

        public void setIndexedPrice(String indexedPrice) {
            this.indexedPrice = indexedPrice;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getFinalPrice() {
            return finalPrice;
        }

        public void setFinalPrice(String finalPrice) {
            this.finalPrice = finalPrice;
        }

        public String getMinimalPrice() {
            return minimalPrice;
        }

        public void setMinimalPrice(String minimalPrice) {
            this.minimalPrice = minimalPrice;
        }

        public String getMinPrice() {
            return minPrice;
        }

        public void setMinPrice(String minPrice) {
            this.minPrice = minPrice;
        }

        public String getMaxPrice() {
            return maxPrice;
        }

        public void setMaxPrice(String maxPrice) {
            this.maxPrice = maxPrice;
        }

        public Object getTierPrice() {
            return tierPrice;
        }

        public void setTierPrice(Object tierPrice) {
            this.tierPrice = tierPrice;
        }

        public Object getSoldQuantity() {
            return soldQuantity;
        }

        public void setSoldQuantity(Object soldQuantity) {
            this.soldQuantity = soldQuantity;
        }

        public String getCatIndexPosition() {
            return catIndexPosition;
        }

        public void setCatIndexPosition(String catIndexPosition) {
            this.catIndexPosition = catIndexPosition;
        }

    }
}
