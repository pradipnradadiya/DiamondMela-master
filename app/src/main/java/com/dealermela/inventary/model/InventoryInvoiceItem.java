package com.dealermela.inventary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class InventoryInvoiceItem {
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
        @SerializedName("customer_firstname")
        @Expose
        private String customerFirstname;
        @SerializedName("customer_lastname")
        @Expose
        private String customerLastname;
        @SerializedName("customer_id")
        @Expose
        private Integer customerId;
        @SerializedName("order_total")
        @Expose
        private String orderTotal;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("invoice_ent_id")
        @Expose
        private Integer invoiceEntId;
        @SerializedName("invoice_number")
        @Expose
        private String invoiceNumber;
        @SerializedName("invoice_created_date")
        @Expose
        private String invoiceCreatedDate;
        @SerializedName("invoice_inc_id")
        @Expose
        private String invoiceIncId;
        @SerializedName("invoice_total")
        @Expose
        private String invoiceTotal;
        @SerializedName("gst_percentage")
        @Expose
        private String gstPercentage;
        @SerializedName("parent_customer_id")
        @Expose
        private Object parentCustomerId;
        @SerializedName("child_customer_name")
        @Expose
        private Object childCustomerName;
        @SerializedName("child_customer_address")
        @Expose
        private Object childCustomerAddress;
        @SerializedName("child_customer_pan")
        @Expose
        private Object childCustomerPan;
        @SerializedName("invoice_id")
        @Expose
        private Object invoiceId;
        @SerializedName("invoice_shipping_charge")
        @Expose
        private String invoiceShippingCharge;
        @SerializedName("grand_total")
        @Expose
        private String grandTotal;

        public Integer getEntityId() {
            return entityId;
        }

        public void setEntityId(Integer entityId) {
            this.entityId = entityId;
        }

        public String getCustomerFirstname() {
            return customerFirstname;
        }

        public void setCustomerFirstname(String customerFirstname) {
            this.customerFirstname = customerFirstname;
        }

        public String getCustomerLastname() {
            return customerLastname;
        }

        public void setCustomerLastname(String customerLastname) {
            this.customerLastname = customerLastname;
        }

        public Integer getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Integer customerId) {
            this.customerId = customerId;
        }

        public String getOrderTotal() {
            return orderTotal;
        }

        public void setOrderTotal(String orderTotal) {
            this.orderTotal = orderTotal;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Integer getInvoiceEntId() {
            return invoiceEntId;
        }

        public void setInvoiceEntId(Integer invoiceEntId) {
            this.invoiceEntId = invoiceEntId;
        }

        public String getInvoiceNumber() {
            return invoiceNumber;
        }

        public void setInvoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
        }

        public String getInvoiceCreatedDate() {
            return invoiceCreatedDate;
        }

        public void setInvoiceCreatedDate(String invoiceCreatedDate) {
            this.invoiceCreatedDate = invoiceCreatedDate;
        }

        public String getInvoiceIncId() {
            return invoiceIncId;
        }

        public void setInvoiceIncId(String invoiceIncId) {
            this.invoiceIncId = invoiceIncId;
        }

        public String getInvoiceTotal() {
            return invoiceTotal;
        }

        public void setInvoiceTotal(String invoiceTotal) {
            this.invoiceTotal = invoiceTotal;
        }

        public String getGstPercentage() {
            return gstPercentage;
        }

        public void setGstPercentage(String gstPercentage) {
            this.gstPercentage = gstPercentage;
        }

        public Object getParentCustomerId() {
            return parentCustomerId;
        }

        public void setParentCustomerId(Object parentCustomerId) {
            this.parentCustomerId = parentCustomerId;
        }

        public Object getChildCustomerName() {
            return childCustomerName;
        }

        public void setChildCustomerName(Object childCustomerName) {
            this.childCustomerName = childCustomerName;
        }

        public Object getChildCustomerAddress() {
            return childCustomerAddress;
        }

        public void setChildCustomerAddress(Object childCustomerAddress) {
            this.childCustomerAddress = childCustomerAddress;
        }

        public Object getChildCustomerPan() {
            return childCustomerPan;
        }

        public void setChildCustomerPan(Object childCustomerPan) {
            this.childCustomerPan = childCustomerPan;
        }

        public Object getInvoiceId() {
            return invoiceId;
        }

        public void setInvoiceId(Object invoiceId) {
            this.invoiceId = invoiceId;
        }

        public String getInvoiceShippingCharge() {
            return invoiceShippingCharge;
        }

        public void setInvoiceShippingCharge(String invoiceShippingCharge) {
            this.invoiceShippingCharge = invoiceShippingCharge;
        }

        public String getGrandTotal() {
            return grandTotal;
        }

        public void setGrandTotal(String grandTotal) {
            this.grandTotal = grandTotal;
        }

    }
}
