package com.dealermela.download.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DownloadItem {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("customer_id")
    @Expose
    private String customerId;
    @SerializedName("data")
    @Expose
    private List<Detail> detail = null;

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

    public List<Detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }


    public class Detail {

        @SerializedName("product_id")
        @Expose
        private String productId;
        @SerializedName("Sku")
        @Expose
        private String sku;
        @SerializedName("StoneDetail")
        @Expose
        private String stoneDetail;
        @SerializedName("MetalDeatil")
        @Expose
        private String metalDeatil;
        @SerializedName("Carat")
        @Expose
        private String carat;
        @SerializedName("DiamondWeight")
        @Expose
        private String diamondWeight;
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("flag")
        @Expose
        private String flag;

        private boolean isSelected = false;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public String getStoneDetail() {
            return stoneDetail;
        }

        public void setStoneDetail(String stoneDetail) {
            this.stoneDetail = stoneDetail;
        }

        public String getMetalDeatil() {
            return metalDeatil;
        }

        public void setMetalDeatil(String metalDeatil) {
            this.metalDeatil = metalDeatil;
        }

        public String getCarat() {
            return carat;
        }

        public void setCarat(String carat) {
            this.carat = carat;
        }

        public String getDiamondWeight() {
            return diamondWeight;
        }

        public void setDiamondWeight(String diamondWeight) {
            this.diamondWeight = diamondWeight;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }
    }


}
