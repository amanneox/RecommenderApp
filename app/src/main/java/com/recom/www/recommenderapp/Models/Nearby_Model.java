package com.recom.www.recommenderapp.Models;

public class Nearby_Model {
    private String name,value,genre;
    private float rating;

    public Nearby_Model() {
    }

    public  Nearby_Model(String name,String value,String genre,float rating){
        this.name=name;
        this.genre=genre;
        this.value=value;
        this.rating=rating;
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