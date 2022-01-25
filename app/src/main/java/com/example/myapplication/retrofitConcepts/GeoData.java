package com.example.myapplication.retrofitConcepts;

import com.google.gson.annotations.SerializedName;

public class GeoData {
    @SerializedName("lat")
    private String latitude;

    @SerializedName("lng")
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
