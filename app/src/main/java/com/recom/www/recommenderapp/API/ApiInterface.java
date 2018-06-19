package com.recom.www.recommenderapp.API;


import com.recom.www.recommenderapp.Models.Nearby_Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
    @GET("api/items")
    Call<List<Nearby_Model>> getNearbyItems();
/*
    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
*/
}