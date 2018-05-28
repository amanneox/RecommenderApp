package com.recom.www.recommenderapp.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.recom.www.recommenderapp.Adapters.CustomPagerAdapter;
import com.recom.www.recommenderapp.R;

public class DisplayFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.display_fragment, container, false);

        CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(getContext());

       ViewPager mViewPager = (ViewPager)rootview.findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);
        return rootview;
    }

    }
