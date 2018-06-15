package com.recom.www.recommenderapp.API;


import com.recom.www.recommenderapp.Models.Nearby_Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("api/items")
    Call<Nearby_Model> getNearbyItems();
/*
    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
*/
}