package com.recom.www.recommenderapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Nearby_Model {
    @SerializedName("name")
    private String name;
    @SerializedName("value")
    private String value;
    @SerializedName("genre")
    private String genre;
    @SerializedName("image")
    private String imgUrl;
    @SerializedName("rating")
    private float rating;
    @SerializedName("results")
    private List<Nearby_Model> results;
    public Nearby_Model() {
    }

    public  Nearby_Model(String name,String value,String genre,float rating,String imgUrl){
        this.name=name;
        this.genre=genre;
        this.value=value;
        this.rating=rating;
        this.imgUrl=imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}