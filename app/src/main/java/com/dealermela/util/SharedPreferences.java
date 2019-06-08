package com.dealermela.util;

import android.content.Context;
import android.content.SharedPreferences.Editor;


public class SharedPreferences {
    private final android.content.SharedPreferences sharedPreferences;
    private final Editor editor;
    private static final String SHARED = AppConstants.MY_PREF;
    private static final String LOGIN = AppConstants.PREF_LOGIN;
    private static final String BILLING = AppConstants.PREF_BILLING_ADDRESS;
    private static final String SHIPPING = AppConstants.PREF_SHIPPING_ADDRESS;
    private static final String POPULAR_PRODUCTS = "POPULAR_PRODUCTS";


    public SharedPreferences(Context mContext) {
        sharedPreferences = mContext.getSharedPreferences(SHARED, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    //Get and Save User Id
    public String getLoginData() {
        return sharedPreferences.getString(LOGIN, "");
    }

    public void saveLoginData(String data) {
        editor.putString(LOGIN, data);
        editor.commit();
    }


    //Get and Save Billing Address
    public String getBillingAddress() {
        return sharedPreferences.getString(BILLING, "");
    }

    public void saveBillingAddress(String data) {
        editor.putString(BILLING, data);
        editor.commit();
    }


    //Get and Save Shipping Address
    public String getShippingAddress() {
        return sharedPreferences.getString(SHIPPING, "");
    }

    public void saveShipping(String data) {
        editor.putString(SHIPPING, data);
        editor.commit();
    }

    //Get and Save Shipping Address
    public String getPopularProducts() {
        return sharedPreferences.getString(POPULAR_PRODUCTS, "");
    }

    public void savePopularProducts(String data) {
        editor.putString(POPULAR_PRODUCTS, data);
        editor.commit();
    }




}
