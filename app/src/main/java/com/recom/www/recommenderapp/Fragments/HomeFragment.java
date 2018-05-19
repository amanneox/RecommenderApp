package com.recom.www.recommenderapp.Fragments;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.recom.www.recommenderapp.Adapters.CustomGridViewActivity;
import com.recom.www.recommenderapp.R;

public class HomeFragment extends Fragment {
    GridView androidGridView;

    String[] gridViewString = {
            "Food", "Shopping", "Hot&New", "Delivery", "Bars", "Coffee",
            "Gas Station", "Drug Store", "Deals", "More"
    } ;
    int[] gridViewImageId = {
            R.drawable.ic_cutlery, R.drawable.ic_shopping_cart, R.drawable.ic_hot, R.drawable.ic_delivery_truck, R.drawable.ic_cheers, R.drawable.ic_cutlery,
            R.drawable.ic_cutlery, R.drawable.ic_cutlery, R.drawable.ic_cutlery, R.drawable.ic_cutlery
    };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview=inflater.inflate(R.layout.home_view, container, false);

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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
