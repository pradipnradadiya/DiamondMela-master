package com.dealermela.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class HeaderItem {
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

    public class Datum implements Serializable {
        @SerializedName("entity_id")
        @Expose
        private String entityId;
        @SerializedName("level")
        @Expose
        private String level;
        @SerializedName("path")
        @Expose
        private String path;
        @SerializedName("position")
        @Expose
        private String position;
        @SerializedName("is_active")
        @Expose
        private String isActive;
        @SerializedName("is_anchor")
        @Expose
        private String isAnchor;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("icon_img")
        @Expose
        private String iconImg;
        @SerializedName("category_img")
        @Expose
        private String categoryImg;

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getIsActive() {
            return isActive;
        }

        public void setIsActive(String isActive) {
            this.isActive = isActive;
        }

        public String getIsAnchor() {
            return isAnchor;
        }

        public void setIsAnchor(String isAnchor) {
            this.isAnchor = isAnchor;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIconImg() {
            return iconImg;
        }

        public void setIconImg(String iconImg) {
            this.iconImg = iconImg;
        }

        public String getCategoryImg() {
            return categoryImg;
        }

        public void setCategoryImg(String categoryImg) {
            this.categoryImg = categoryImg;
        }
    }

}
