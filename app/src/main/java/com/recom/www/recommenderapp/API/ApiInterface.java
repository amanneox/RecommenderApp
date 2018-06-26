package com.recom.www.recommenderapp.API;


import com.recom.www.recommenderapp.Models.Home_Model;
import com.recom.www.recommenderapp.Models.Nearby_Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiInterface {
    @GET("api/items")
    Call<List<Nearby_Model>> getNearbyItems();

    @POST("api/items/loc")
    @FormUrlEncoded
    Call<List<Home_Model>> getItems(@Field("category") String category,
                        @Field("lat") int lat,
                        @Field("lng") int lng,
                        @Field("range") Float range);

/*
    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
*/
}