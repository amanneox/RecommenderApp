package com.recom.www.recommenderapp.Fragments;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.recom.www.recommenderapp.Adapters.CustomGridViewActivity;
import com.recom.www.recommenderapp.Adapters.HomeAdapter;
import com.recom.www.recommenderapp.Models.Home_Model;
import com.recom.www.recommenderapp.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    GridView androidGridView;
    private List<Home_Model> itemlist = new ArrayList<>();
    private RecyclerView recyclerView;
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
       RecyclerView recyclerView = (RecyclerView)rootview.findViewById(R.id.recycler_view_home);

        mAdapter = new HomeAdapter(itemlist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
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

        return rootview;
    }

    private void prepareMovieData() {
        Home_Model  item = new Home_Model("Mad Max: Fury Road", "Action & Adventure", "Pizza hut","600",1,"https://i.ytimg.com/vi/1X6OAucemtE/maxresdefault.jpg","15miles");
        itemlist.add(item);
        item = new Home_Model("Mad Max: Fury Road", "Action & Adventure", "Pizza hut","500",1,"https://i.ytimg.com/vi/1X6OAucemtE/maxresdefault.jpg","15miles");
        itemlist.add(item);

        item = new Home_Model("Mad Max: Fury Road", "Action & Adventure", "Pizza hut","",1,"https://i.ytimg.com/vi/1X6OAucemtE/maxresdefault.jpg","15miles");
        itemlist.add(item);

        item = new Home_Model("Mad Max: Fury Road", "Action & Adventure", "Pizza hut","",1,"https://i.ytimg.com/vi/1X6OAucemtE/maxresdefault.jpg","15miles");
        itemlist.add(item);

        item = new Home_Model("Mad Max: Fury Road", "Action & Adventure", "Pizza hut","",1,"https://www.google.co.in/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png","15miles");
        itemlist.add(item);

        item = new Home_Model("Mad Max: Fury Road", "Action & Adventure", "2015","",1,"","");
        itemlist.add(item);

        item = new Home_Model("Mad Max: Fury Road", "Action & Adventure", "Pizza hut","",1,"https://www.google.co.in/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png","15miles");
        itemlist.add(item);

        item = new Home_Model("Mad Max: Fury Road", "Action & Adventure", "Pizza hut","",1,"https://www.google.co.in/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png","15miles");
        itemlist.add(item);
        item = new Home_Model("Mad Max: Fury Road", "Action & Adventure", "Pizza hut","",1,"https://www.google.co.in/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png","15miles");
        itemlist.add(item);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
