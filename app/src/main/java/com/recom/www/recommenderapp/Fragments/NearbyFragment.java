package com.recom.www.recommenderapp.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.recom.www.recommenderapp.Adapters.NearbyAdapter;
import com.recom.www.recommenderapp.Adapters.ReviewAdapter;
import com.recom.www.recommenderapp.Models.Nearby_Model;
import com.recom.www.recommenderapp.Models.Review_Model;
import com.recom.www.recommenderapp.R;

import java.util.ArrayList;
import java.util.List;

public class NearbyFragment extends Fragment {
    private List<Nearby_Model> itemlist = new ArrayList<>();
    private RecyclerView recyclerView;
    private NearbyAdapter mAdapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.nearby_view, container, false);
        mAdapter = new NearbyAdapter(itemlist);
        RecyclerView recyclerView = (RecyclerView)rootview.findViewById(R.id.recycler_view_nearby);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareNearbyData();
        return rootview;
    }

    private void prepareNearbyData() {
        Nearby_Model item=new Nearby_Model("Dominos","9/10","Pizza/Food",3.5f,"https://www.tropical-islands.de/fileadmin/_processed_/csm_TI_RESTAURANT_TROPICAL-GARDEN1_RGB_2000x860_c3a4238088.jpg");
        itemlist.add(item);
        item=new Nearby_Model("Dominos","9/10","Pizza/Food",3.5f,"https://mk0tainsights9mcv7wv.kinstacdn.com/wp-content/uploads/2018/01/premiumforrestaurants_0.jpg");
        itemlist.add(item);
        item=new Nearby_Model("Dominos","9/10","Pizza/Food",3.5f,"https://mk0tainsights9mcv7wv.kinstacdn.com/wp-content/uploads/2018/01/premiumforrestaurants_0.jpg");
        itemlist.add(item);
        item=new Nearby_Model("Dominos","9/10","Pizza/Food",3.5f,"https://www.tropical-islands.de/fileadmin/_processed_/csm_TI_RESTAURANT_TROPICAL-GARDEN1_RGB_2000x860_c3a4238088.jpg");
        itemlist.add(item);
    }
}
