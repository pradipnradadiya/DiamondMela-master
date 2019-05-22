package com.dealermela.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BannerSliderItem {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("banner_image")
    @Expose
    private String bannerImage;
    @SerializedName("slider_image")
    @Expose
    private List<SliderImage> sliderImage = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public List<SliderImage> getSliderImage() {
        return sliderImage;
    }

    public void setSliderImage(List<SliderImage> sliderImage) {
        this.sliderImage = sliderImage;
    }

    public class SliderImage {

        @SerializedName("data_attr")
        @Expose
        private String dataAttr;
        @SerializedName("image_url")
        @Expose
        private String imageUrl;

        public String getDataAttr() {
            return dataAttr;
        }

        public void setDataAttr(String dataAttr) {
            this.dataAttr = dataAttr;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

    }

}
