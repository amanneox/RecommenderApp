package com.recom.www.recommenderapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("category")
    @Expose
    private
    String category;
    @SerializedName("range")
    @Expose
    private
    int range;
    @SerializedName("lat")
    @Expose
    private
    float lat;
    @SerializedName("lng")
    @Expose
    private
    float lng;

    public Post(String category,int range,float lat,float lng)
    {
        this.lat=lat;
        this.lng=lng;
        this.category=category;
        this.range=range;
    }

    public float getLat() {
        return lat;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    public float getLng() {
        return lng;
    }

    public String getCategory() {
        return category;
    }
}
