package com.dealermela.transaction.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransactionItem {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("total_deposite")
    @Expose
    private Integer totalDeposite;
    @SerializedName("total_credit")
    @Expose
    private Integer totalCredit;
    @SerializedName("total_debit")
    @Expose
    private Integer totalDebit;
    @SerializedName("final_totalamount")
    @Expose
    private Integer finalTotalamount;
    @SerializedName("total_tds")
    @Expose
    private Integer totalTds;
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

    public Integer getTotalDeposite() {
        return totalDeposite;
    }

    public void setTotalDeposite(Integer totalDeposite) {
        this.totalDeposite = totalDeposite;
    }

    public Integer getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(Integer totalCredit) {
        this.totalCredit = totalCredit;
    }

    public Integer getTotalDebit() {
        return totalDebit;
    }

    public void setTotalDebit(Integer totalDebit) {
        this.totalDebit = totalDebit;
    }

    public Integer getFinalTotalamount() {
        return finalTotalamount;
    }

    public void setFinalTotalamount(Integer finalTotalamount) {
        this.finalTotalamount = finalTotalamount;
    }

    public Integer getTotalTds() {
        return totalTds;
    }

    public void setTotalTds(Integer totalTds) {
        this.totalTds = totalTds;
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

        @SerializedName("increment_id")
        @Expose
        private String incrementId;
        @SerializedName("create_date")
        @Expose
        private String createDate;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("transction_price")
        @Expose
        private Integer transctionPrice;
        @SerializedName("order_item")
        @Expose
        private List<OrderItem> orderItem = null;

        public String getIncrementId() {
            return incrementId;
        }

        public void setIncrementId(String incrementId) {
            this.incrementId = incrementId;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getTransctionPrice() {
            return transctionPrice;
        }

        public void setTransctionPrice(Integer transctionPrice) {
            this.transctionPrice = transctionPrice;
        }

        public List<OrderItem> getOrderItem() {
            return orderItem;
        }

        public void setOrderItem(List<OrderItem> orderItem) {
            this.orderItem = orderItem;
        }

    }


    public class OrderItem {

        @SerializedName("product_increment_id")
        @Expose
        private String productIncrementId;
        @SerializedName("product_name")
        @Expose
        private String productName;
        @SerializedName("product_sku")
        @Expose
        private String productSku;
        @SerializedName("product_stonequality")
        @Expose
        private String productStonequality;
        @SerializedName("product_stoneweight")
        @Expose
        private String productStoneweight;
        @SerializedName("product_price")
        @Expose
        private String productPrice;
        @SerializedName("product_metalweight")
        @Expose
        private String productMetalweight;

        public String getProductIncrementId() {
            return productIncrementId;
        }

        public void setProductIncrementId(String productIncrementId) {
            this.productIncrementId = productIncrementId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductSku() {
            return productSku;
        }

        public void setProductSku(String productSku) {
            this.productSku = productSku;
        }

        public String getProductStonequality() {
            return productStonequality;
        }

        public void setProductStonequality(String productStonequality) {
            this.productStonequality = productStonequality;
        }

        public String getProductStoneweight() {
            return productStoneweight;
        }

        public void setProductStoneweight(String productStoneweight) {
            this.productStoneweight = productStoneweight;
        }

        public String getProductPrice() {
            return productPrice;
        }

        public void setProductPrice(String productPrice) {
            this.productPrice = productPrice;
        }

        public String getProductMetalweight() {
            return productMetalweight;
        }

        public void setProductMetalweight(String productMetalweight) {
            this.productMetalweight = productMetalweight;
        }

    }
}
