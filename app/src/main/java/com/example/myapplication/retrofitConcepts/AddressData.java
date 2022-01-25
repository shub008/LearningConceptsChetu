package com.example.myapplication.retrofitConcepts;

import com.google.gson.annotations.SerializedName;

public class AddressData {
    /**
     *  "street": "Kulas Light",
     *             "suite": "Apt. 556",
     *             "city": "Gwenborough",
     *             "zipcode": "92998-3874",
     */


    @SerializedName("street")
    private String street;

    @SerializedName("suite")
    private String suite;

    @SerializedName("city")
    private String city;

    @SerializedName("zipcode")
    private String zipcode;

    @SerializedName("geo")
    private GeoData latLang;


    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public GeoData getLatLang() {
        return latLang;
    }
}
