package com.recom.www.recommenderapp.Fragments;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.recom.www.recommenderapp.API.ApiClient;
import com.recom.www.recommenderapp.API.ApiInterface;
import com.recom.www.recommenderapp.Adapters.CustomGridViewActivity;
import com.recom.www.recommenderapp.Adapters.HomeAdapter;
import com.recom.www.recommenderapp.Adapters.NearbyAdapter;
import com.recom.www.recommenderapp.Models.Home_Model;
import com.recom.www.recommenderapp.Models.Nearby_Model;
import com.recom.www.recommenderapp.R;
import com.recom.www.recommenderapp.SearchActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class HomeFragment extends Fragment {
    GridView androidGridView;
    private List<Home_Model> itemlist = new ArrayList<>();
    private RecyclerView recyclerView;
    List<JsonObject> jsonlist=new ArrayList<>();
    private HomeAdapter mAdapter;
    String[] gridViewString = {
            "Food", "Shopping", "Hot&New", "Delivery", "Bars", "Coffee",
            "Gas Station", "Drug Store", "Deals", "More"
    } ;
    int[] gridViewImageId = {
            R.drawable.ic_cutlery, R.drawable.ic_shopping_cart, R.drawable.ic_hot, R.drawable.ic_delivery_truck, R.drawable.ic_cheers, R.drawable.ic_coffee,
            R.drawable.ic_gasoline_pump, R.drawable.ic_pill, R.drawable.ic_bill, R.drawable.ic_plus
    };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview=inflater.inflate(R.layout.home_view, container, false);
       final RecyclerView recyclerView = (RecyclerView)rootview.findViewById(R.id.recycler_view_home);

       // mAdapter = new HomeAdapter(itemlist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
       // recyclerView.setAdapter(mAdapter);

        //prepareMovieData();
        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(getContext(), gridViewString, gridViewImageId);
        androidGridView=(GridView)rootview.findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                Toast.makeText(getContext(), "GridView Item: " + gridViewString[+i], Toast.LENGTH_LONG).show();
            }
        });
        EditText search=rootview.findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

/*
        Call<List<Home_Model>> call = apiService.getitemloc("Food",32,78,200.0F);
        call.enqueue(new Callback<List<Home_Model>>() {
            @Override
            public void onResponse(Call<List<Home_Model>>call, Response<List<Home_Model>> response) {
                int statusCode = response.code();
                if (response.isSuccessful()) {
                    List<Home_Model> items = response.body();
                    Iterator<Home_Model> it = items.iterator();
                    Gson gson = new Gson();
                    Log.i(TAG,"Success:"+statusCode);
                    while (it.hasNext()) {
                        String x = gson.toJson(it.next());
                        JsonObject jsonObject = gson.fromJson(x, JsonObject.class);
                        jsonlist.add(jsonObject);
                        it.remove();
                    }
                     Log.i(TAG, ":" + jsonlist);
                     recyclerView.setAdapter(new HomeAdapter(jsonlist));
                }
                else {
                    Log.i(TAG,"Error:"+statusCode);
                }

            }

            @Override
            public void onFailure(Call<List<Home_Model>> call, Throwable t) {

            }

        });
*/
        return rootview;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
