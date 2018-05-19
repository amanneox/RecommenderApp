package com.recom.www.recommenderapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.recom.www.recommenderapp.Models.Home_Model;
import com.recom.www.recommenderapp.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private List<Home_Model> itemlist;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public HomeAdapter(List<Home_Model> itemlist) {
        this.itemlist = itemlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Home_Model item = itemlist.get(position);
        holder.title.setText(item.getTitle());
        holder.genre.setText(item.getGenre());
        holder.year.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }
}