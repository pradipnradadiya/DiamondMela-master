package com.dealermela.my_stock.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyStockItem {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("customer_id")
    @Expose
    private String customerId;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("product_id")
        @Expose
        private String product_id;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("sku")
        @Expose
        private String sku;
        @SerializedName("price")
        @Expose
        private Float price;
        @SerializedName("metal_quality")
        @Expose
        private String metalQuality;
        @SerializedName("stone_quality")
        @Expose
        private String stoneQuality;
        @SerializedName("size")
        @Expose
        private String size;

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            this.price = price;
        }

        public String getMetalQuality() {
            return metalQuality;
        }

        public void setMetalQuality(String metalQuality) {
            this.metalQuality = metalQuality;
        }

        public String getStoneQuality() {
            return stoneQuality;
        }

        public void setStoneQuality(String stoneQuality) {
            this.stoneQuality = stoneQuality;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

    }


}
