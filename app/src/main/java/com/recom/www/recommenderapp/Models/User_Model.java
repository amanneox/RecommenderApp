package com.recom.www.recommenderapp.Models;

import android.databinding.BaseObservable;

public class User_Model extends BaseObservable {
    private String title, genre, name,price,imgUrl,mile;
    private int rating;

    public User_Model() {
    }

    public User_Model(String title, String genre, String name,String price,int rating,String imgUrl,String mile) {
        this.title = title;
        this.genre = genre;
        this.name = name;
        this.price=price;
        this.rating=rating;
        this.imgUrl=imgUrl;
        this.mile=mile;
    }

}