package com.recom.www.recommenderapp.Models;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.SerializedName;
import com.recom.www.recommenderapp.BR;

import java.util.List;

public class Home_Model extends BaseObservable {
    @SerializedName("title")
    private String title;
    @SerializedName("genre")
    private String genre;
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private String price;
    @SerializedName("imgUrl")
    private String imgUrl;
    @SerializedName("mile")
    private String mile;
    @SerializedName("rating")
    private int rating;
    @SerializedName("results")
    private List<Nearby_Model> results;

    public List<Nearby_Model> getResults() {
        return results;
    }

    public void setResults(List<Nearby_Model> results) {
        this.results = results;
    }

    public Home_Model() {
    }

    public Home_Model(String title, String genre, String name,String price,int rating,String imgUrl,String mile) {
        this.title = title;
        this.genre = genre;
        this.name = name;
        this.price=price;
        this.rating=rating;
        this.imgUrl=imgUrl;
        this.mile=mile;
    }

    @BindingAdapter({"imgUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }

    public String getMile() {
        return mile;
    }

    public void setMile(String mile) {
        this.mile = mile;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}