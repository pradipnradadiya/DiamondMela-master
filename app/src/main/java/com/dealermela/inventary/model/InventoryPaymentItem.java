package com.dealermela.inventary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class InventoryPaymentItem {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("total_paid")
    @Expose
    private Float totalPaid;
    @SerializedName("total_remaining")
    @Expose
    private Float totalRemaining;
    @SerializedName("data")
    @Expose
    private ArrayList<Datum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(Float totalPaid) {
        this.totalPaid = totalPaid;
    }

    public Float getTotalRemaining() {
        return totalRemaining;
    }

    public void setTotalRemaining(Float totalRemaining) {
        this.totalRemaining = totalRemaining;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("invoice_number")
        @Expose
        private String invoiceNumber;
        @SerializedName("invoice_amount")
        @Expose
        private Float invoiceAmount;
        @SerializedName("remaining")
        @Expose
        private Float remaining;
        @SerializedName("remaining_amount")
        @Expose
        private Float remainingAmount;
        @SerializedName("payment_form")
        @Expose
        private String paymentForm;
        @SerializedName("customer_name")
        @Expose
        private String customerName;
        @SerializedName("due_date")
        @Expose
        private Object dueDate;
        @SerializedName("paid_amount")
        @Expose
        private Float paidAmount;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("payment_status")
        @Expose
        private String paymentStatus;
        @SerializedName("paid_date_time")
        @Expose
        private String paidDateTime;
        @SerializedName("remaining_amt")
        @Expose
        private Integer remainingAmt;

        public String getInvoiceNumber() {
            return invoiceNumber;
        }

        public void setInvoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
        }

        public Float getInvoiceAmount() {
            return invoiceAmount;
        }

        public void setInvoiceAmount(Float invoiceAmount) {
            this.invoiceAmount = invoiceAmount;
        }

        public Float getRemaining() {
            return remaining;
        }

        public void setRemaining(Float remaining) {
            this.remaining = remaining;
        }

        public Float getRemainingAmount() {
            return remainingAmount;
        }

        public void setRemainingAmount(Float remainingAmount) {
            this.remainingAmount = remainingAmount;
        }

        public String getPaymentForm() {
            return paymentForm;
        }

        public void setPaymentForm(String paymentForm) {
            this.paymentForm = paymentForm;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public Object getDueDate() {
            return dueDate;
        }

        public void setDueDate(Object dueDate) {
            this.dueDate = dueDate;
        }

        public Float getPaidAmount() {
            return paidAmount;
        }

        public void setPaidAmount(Float paidAmount) {
            this.paidAmount = paidAmount;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

        public String getPaidDateTime() {
            return paidDateTime;
        }

        public void setPaidDateTime(String paidDateTime) {
            this.paidDateTime = paidDateTime;
        }

        public Integer getRemainingAmt() {
            return remainingAmt;
        }

        public void setRemainingAmt(Integer remainingAmt) {
            this.remainingAmt = remainingAmt;
        }

    }
}
