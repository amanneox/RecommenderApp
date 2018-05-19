package com.recom.www.recommenderapp.Models;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.recom.www.recommenderapp.BR;

public class Home_Model extends BaseObservable {
    private String title, genre, name,price,imgUrl;
    private int rating;

    public Home_Model() {
    }

    public Home_Model(String title, String genre, String name,String price,int rating,String imgUrl) {
        this.title = title;
        this.genre = genre;
        this.name = name;
        this.price=price;
        this.rating=rating;
        this.imgUrl=imgUrl;
    }

    @BindingAdapter({"imgUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
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