package com.recom.www.recommenderapp.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.recom.www.recommenderapp.Adapters.CustomPagerAdapter;
import com.recom.www.recommenderapp.Adapters.HomeAdapter;
import com.recom.www.recommenderapp.Adapters.ResultAdapter;
import com.recom.www.recommenderapp.Adapters.ReviewAdapter;
import com.recom.www.recommenderapp.Models.Home_Model;
import com.recom.www.recommenderapp.Models.Review_Model;
import com.recom.www.recommenderapp.R;

import java.util.ArrayList;
import java.util.List;

public class DisplayFragment extends Fragment {
    private List<Review_Model> itemlist = new ArrayList<>();
    private RecyclerView recyclerView;
    private ReviewAdapter mAdapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.display_fragment, container, false);

        CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(getContext());

       ViewPager mViewPager = (ViewPager)rootview.findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);

        RecyclerView recyclerView = (RecyclerView)rootview.findViewById(R.id.recycler_view_display);

        mAdapter = new ReviewAdapter(itemlist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareReviewData();
        return rootview;
    }

    private void prepareReviewData() {

        Review_Model item=new Review_Model("Aman Adhikari",3.5f,"","Nice Place","110","10");
        itemlist.add(item);
        item=new Review_Model("Aman Adhikari",3.5f,"","Nice Place","110","10");
        itemlist.add(item);
        item=new Review_Model("Aman Adhikari",3.5f,"","Nice Place","110","10");
        itemlist.add(item);
        item=new Review_Model("Aman Adhikari",3.5f,"","Nice Place","110","10");
        itemlist.add(item);
        item=new Review_Model("Aman Adhikari",3.5f,"","Nice Place","110","10");
        itemlist.add(item);
        item=new Review_Model("Aman Adhikari",3.5f,"","Nice Place","110","10");
        itemlist.add(item);

    }

}
