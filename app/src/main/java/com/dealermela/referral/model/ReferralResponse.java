package com.dealermela.referral.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReferralResponse {
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
        @SerializedName("entity_type_id")
        @Expose
        private String entityTypeId;
        @SerializedName("attribute_set_id")
        @Expose
        private String attributeSetId;
        @SerializedName("website_id")
        @Expose
        private String websiteId;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("group_id")
        @Expose
        private String groupId;
        @SerializedName("increment_id")
        @Expose
        private Object incrementId;
        @SerializedName("store_id")
        @Expose
        private String storeId;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("is_active")
        @Expose
        private String isActive;
        @SerializedName("disable_auto_group_change")
        @Expose
        private String disableAutoGroupChange;
        @SerializedName("franchise_referral_status")
        @Expose
        private String franchiseReferralStatus;
        @SerializedName("parent_franchise_id")
        @Expose
        private String parentFranchiseId;
        @SerializedName("firstname")
        @Expose
        private String firstname;
        @SerializedName("lastname")
        @Expose
        private String lastname;
        @SerializedName("password_hash")
        @Expose
        private String passwordHash;
        @SerializedName("referral_comission")
        @Expose
        private String referralComission;
        @SerializedName("contact_number")
        @Expose
        private String contactNumber;
        @SerializedName("referral_type")
        @Expose
        private String referralType;
        @SerializedName("created_in")
        @Expose
        private String createdIn;
        @SerializedName("franchisee_status")
        @Expose
        private String franchiseeStatus;
        @SerializedName("_isfranchisee")
        @Expose
        private String isfranchisee;
        @SerializedName("confirmation")
        @Expose
        private String confirmation;

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }

        public String getEntityTypeId() {
            return entityTypeId;
        }

        public void setEntityTypeId(String entityTypeId) {
            this.entityTypeId = entityTypeId;
        }

        public String getAttributeSetId() {
            return attributeSetId;
        }

        public void setAttributeSetId(String attributeSetId) {
            this.attributeSetId = attributeSetId;
        }

        public String getWebsiteId() {
            return websiteId;
        }

        public void setWebsiteId(String websiteId) {
            this.websiteId = websiteId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public Object getIncrementId() {
            return incrementId;
        }

        public void setIncrementId(Object incrementId) {
            this.incrementId = incrementId;
        }

        public String getStoreId() {
            return storeId;
        }

        public void setStoreId(String storeId) {
            this.storeId = storeId;
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

        public String getIsActive() {
            return isActive;
        }

        public void setIsActive(String isActive) {
            this.isActive = isActive;
        }

        public String getDisableAutoGroupChange() {
            return disableAutoGroupChange;
        }

        public void setDisableAutoGroupChange(String disableAutoGroupChange) {
            this.disableAutoGroupChange = disableAutoGroupChange;
        }

        public String getFranchiseReferralStatus() {
            return franchiseReferralStatus;
        }

        public void setFranchiseReferralStatus(String franchiseReferralStatus) {
            this.franchiseReferralStatus = franchiseReferralStatus;
        }

        public String getParentFranchiseId() {
            return parentFranchiseId;
        }

        public void setParentFranchiseId(String parentFranchiseId) {
            this.parentFranchiseId = parentFranchiseId;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getPasswordHash() {
            return passwordHash;
        }

        public void setPasswordHash(String passwordHash) {
            this.passwordHash = passwordHash;
        }

        public String getReferralComission() {
            return referralComission;
        }

        public void setReferralComission(String referralComission) {
            this.referralComission = referralComission;
        }

        public String getContactNumber() {
            return contactNumber;
        }

        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
        }

        public String getReferralType() {
            return referralType;
        }

        public void setReferralType(String referralType) {
            this.referralType = referralType;
        }

        public String getCreatedIn() {
            return createdIn;
        }

        public void setCreatedIn(String createdIn) {
            this.createdIn = createdIn;
        }

        public String getFranchiseeStatus() {
            return franchiseeStatus;
        }

        public void setFranchiseeStatus(String franchiseeStatus) {
            this.franchiseeStatus = franchiseeStatus;
        }

        public String getIsfranchisee() {
            return isfranchisee;
        }

        public void setIsfranchisee(String isfranchisee) {
            this.isfranchisee = isfranchisee;
        }

        public String getConfirmation() {
            return confirmation;
        }

        public void setConfirmation(String confirmation) {
            this.confirmation = confirmation;
        }

    }

}
