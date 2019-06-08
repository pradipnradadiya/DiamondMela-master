package com.dealermela.authentication.myaccount.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountryResponse {

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

        @SerializedName("country_id")
        @Expose
        private String countryId;
        @SerializedName("iso2_code")
        @Expose
        private String iso2Code;
        @SerializedName("iso3_code")
        @Expose
        private String iso3Code;
        @SerializedName("name")
        @Expose
        private String name;

        public String getCountryId() {
            return countryId;
        }

        public void setCountryId(String countryId) {
            this.countryId = countryId;
        }

        public String getIso2Code() {
            return iso2Code;
        }

        public void setIso2Code(String iso2Code) {
            this.iso2Code = iso2Code;
        }

        public String getIso3Code() {
            return iso3Code;
        }

        public void setIso3Code(String iso3Code) {
            this.iso3Code = iso3Code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
