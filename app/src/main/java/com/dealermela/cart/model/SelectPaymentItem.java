package com.dealermela.cart.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SelectPaymentItem {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("shipping_charges")
    @Expose
    private List<ShippingCharge> shippingCharges = null;
    @SerializedName("data")
    @Expose
    private List<Date> date = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ShippingCharge> getShippingCharges() {
        return shippingCharges;
    }

    public void setShippingCharges(List<ShippingCharge> shippingCharges) {
        this.shippingCharges = shippingCharges;
    }

    public List<Date> getDate() {
        return date;
    }

    public void setDate(List<Date> date) {
        this.date = date;
    }

    public class Date {
        @SerializedName("label")
        @Expose
        private String label;
        @SerializedName("value")
        @Expose
        private String value;
        @SerializedName("info")
        @Expose
        private Object info;
        @SerializedName("image")
        @Expose
        private String image;

        private boolean isSelected = false;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Object getInfo() {
            return info;
        }

        public void setInfo(Object info) {
            this.info = info;
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
    }

    public class ShippingCharge implements Serializable {

        @SerializedName("rate_id")
        @Expose
        private String rateId;
        @SerializedName("address_id")
        @Expose
        private String addressId;
        @SerializedName("carrier")
        @Expose
        private String carrier;
        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("method")
        @Expose
        private String method;
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("method_title")
        @Expose
        private String methodTitle;
        private boolean isSelected = false;

        public String getRateId() {
            return rateId;
        }

        public void setRateId(String rateId) {
            this.rateId = rateId;
        }

        public String getAddressId() {
            return addressId;
        }

        public void setAddressId(String addressId) {
            this.addressId = addressId;
        }

        public String getCarrier() {
            return carrier;
        }

        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getMethodTitle() {
            return methodTitle;
        }

        public void setMethodTitle(String methodTitle) {
            this.methodTitle = methodTitle;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }
    }

}
