package com.dealermela.authentication.myaccount.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BankResponse {
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

        @SerializedName("bank_id")
        @Expose
        private String bankId;
        @SerializedName("customer_id")
        @Expose
        private String customerId;
        @SerializedName("bank_name")
        @Expose
        private String bankName;
        @SerializedName("bank_account_number")
        @Expose
        private String bankAccountNumber;
        @SerializedName("bank_account_holder")
        @Expose
        private String bankAccountHolder;
        @SerializedName("ifsc_code")
        @Expose
        private String ifscCode;
        @SerializedName("branch_name")
        @Expose
        private String branchName;
        @SerializedName("created")
        @Expose
        private String created;
        @SerializedName("modified")
        @Expose
        private String modified;

        public String getBankId() {
            return bankId;
        }

        public void setBankId(String bankId) {
            this.bankId = bankId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getBankAccountNumber() {
            return bankAccountNumber;
        }

        public void setBankAccountNumber(String bankAccountNumber) {
            this.bankAccountNumber = bankAccountNumber;
        }

        public String getBankAccountHolder() {
            return bankAccountHolder;
        }

        public void setBankAccountHolder(String bankAccountHolder) {
            this.bankAccountHolder = bankAccountHolder;
        }

        public String getIfscCode() {
            return ifscCode;
        }

        public void setIfscCode(String ifscCode) {
            this.ifscCode = ifscCode;
        }

        public String getBranchName() {
            return branchName;
        }

        public void setBranchName(String branchName) {
            this.branchName = branchName;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }

    }
}
