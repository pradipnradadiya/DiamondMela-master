package com.dealermela.inventary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class InventoryQuotationItem {
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
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("request_number")
        @Expose
        private Integer requestNumber;
        @SerializedName("customer_id")
        @Expose
        private Integer customerId;
        @SerializedName("category_id")
        @Expose
        private Integer categoryId;
        @SerializedName("price_from")
        @Expose
        private Integer priceFrom;
        @SerializedName("price_to")
        @Expose
        private Integer priceTo;
        @SerializedName("no_of_pieces")
        @Expose
        private Integer noOfPieces;
        @SerializedName("comments")
        @Expose
        private String comments;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getRequestNumber() {
            return requestNumber;
        }

        public void setRequestNumber(Integer requestNumber) {
            this.requestNumber = requestNumber;
        }

        public Integer getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Integer customerId) {
            this.customerId = customerId;
        }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        public Integer getPriceFrom() {
            return priceFrom;
        }

        public void setPriceFrom(Integer priceFrom) {
            this.priceFrom = priceFrom;
        }

        public Integer getPriceTo() {
            return priceTo;
        }

        public void setPriceTo(Integer priceTo) {
            this.priceTo = priceTo;
        }

        public Integer getNoOfPieces() {
            return noOfPieces;
        }

        public void setNoOfPieces(Integer noOfPieces) {
            this.noOfPieces = noOfPieces;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }

}
