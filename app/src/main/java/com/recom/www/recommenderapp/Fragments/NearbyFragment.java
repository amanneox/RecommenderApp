package com.recom.www.recommenderapp.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.recom.www.recommenderapp.API.ApiClient;
import com.recom.www.recommenderapp.API.ApiInterface;
import com.recom.www.recommenderapp.Adapters.NearbyAdapter;
import com.recom.www.recommenderapp.Models.Nearby_Model;
import com.recom.www.recommenderapp.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class NearbyFragment extends Fragment {
    private List<Nearby_Model> itemlist = new ArrayList<>();
    List<JsonObject> jsonlist=new ArrayList<>();
    private RecyclerView recyclerView;
    private NearbyAdapter mAdapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.nearby_view, container, false);
        mAdapter = new NearbyAdapter(itemlist);
        final RecyclerView recyclerView = (RecyclerView)rootview.findViewById(R.id.recycler_view_nearby);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<Nearby_Model>> call = apiService.getNearbyItems();
        call.enqueue(new Callback<List<Nearby_Model>>() {
            @Override
            public void onResponse(Call<List<Nearby_Model>>call, Response<List<Nearby_Model>> response) {
                int statusCode = response.code();
                List<Nearby_Model> items = response.body();
                Iterator<Nearby_Model> it=items.iterator();
                Gson gson = new Gson();

                while (it.hasNext()){
                    String x=gson.toJson(it.next());
                    JsonObject jsonObject = gson.fromJson( x, JsonObject.class);
                    jsonlist.add(jsonObject);
                    it.remove();
                }
            }

            @Override
            public void onFailure(Call<List<Nearby_Model>> call, Throwable t) {

            }

        });


        prepareNearbyData();

        return rootview;
    }
    private void prepareNearbyData() {
        Log.i(TAG, "Inside function");
        for (JsonObject jsonObject : jsonlist) {
            String name = String.valueOf(jsonObject.get("name"));
            String address = String.valueOf(jsonObject.get("address"));
            String img_url = String.valueOf(jsonObject.get("img_url"));
            String category = String.valueOf(jsonObject.get("category"));
            String value = String.valueOf(jsonObject.get("value"));
            Float rating = Float.valueOf(String.valueOf(jsonObject.get("rating")));
            Nearby_Model item = new Nearby_Model(name, value, category, rating, "https://www.tropical-islands.de/fileadmin/_processed_/csm_TI_RESTAURANT_TROPICAL-GARDEN1_RGB_2000x860_c3a4238088.jpg");
            itemlist.add(item);
        }


       /* Nearby_Model item=new Nearby_Model("Dominos","9/10","Pizza/Food",3.5f,"https://www.tropical-islands.de/fileadmin/_processed_/csm_TI_RESTAURANT_TROPICAL-GARDEN1_RGB_2000x860_c3a4238088.jpg");
        itemlist.add(item);
        item=new Nearby_Model("Dominos","9/10","Pizza/Food",3.5f,"https://mk0tainsights9mcv7wv.kinstacdn.com/wp-content/uploads/2018/01/premiumforrestaurants_0.jpg");
        itemlist.add(item);
        item=new Nearby_Model("Dominos","9/10","Pizza/Food",3.5f,"https://mk0tainsights9mcv7wv.kinstacdn.com/wp-content/uploads/2018/01/premiumforrestaurants_0.jpg");
        itemlist.add(item);
        item=new Nearby_Model("Dominos","9/10","Pizza/Food",3.5f,"https://www.tropical-islands.de/fileadmin/_processed_/csm_TI_RESTAURANT_TROPICAL-GARDEN1_RGB_2000x860_c3a4238088.jpg");
        itemlist.add(item);
        */
    }
}
