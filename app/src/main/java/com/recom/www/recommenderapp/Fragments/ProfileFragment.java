package com.recom.www.recommenderapp.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.recom.www.recommenderapp.Adapters.CustomGridViewActivity;
import com.recom.www.recommenderapp.R;

public class ProfileFragment extends Fragment {
    GridView androidGridView;
    String[] gridViewString = {
            "Bookmarks", "My Reviews", "My Check-ins", "Settings", "Bars", "Coffee",
            "Gas Station"
    } ;
    int[] gridViewImageId = {
            R.drawable.ic_bookmark, R.drawable.ic_review, R.drawable.ic_street_map, R.drawable.ic_settings, R.drawable.ic_cheers, R.drawable.ic_coffee,
            R.drawable.ic_gasoline_pump
    };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview = inflater.inflate(R.layout.user_view, container, false);

        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(getContext(), gridViewString, gridViewImageId);
        androidGridView=rootview.findViewById(R.id.options);
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
}
