package com.recom.www.recommenderapp.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.recom.www.recommenderapp.R;

public class ProfileFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview = inflater.inflate(R.layout.user_view, container, false);

        return rootview;
    }
}
