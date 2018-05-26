package com.recom.www.recommenderapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.recom.www.recommenderapp.Models.Recent_Model;
import com.recom.www.recommenderapp.Models.Result_Model;
import com.recom.www.recommenderapp.R;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.MyViewHolder> {

    private List<Result_Model> itemlist;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,price,location,distance,genre;
        public RatingBar rating;
        ImageView thumb;
        public MyViewHolder(View view) {
            super(view);
            genre=view.findViewById(R.id.genre);
            price=view.findViewById(R.id.price);
            location=view.findViewById(R.id.location);
            distance=view.findViewById(R.id.distance);
            name=view.findViewById(R.id.name);
            rating=view.findViewById(R.id.ratingbar);
            thumb=view.findViewById(R.id.thumb);
        }
    }


    public ResultAdapter(List<Result_Model> itemlist) {
        this.itemlist = itemlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.result_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Result_Model item = itemlist.get(position);
        holder.name.setText(item.getName());
        holder.genre.setText(item.getGenre());
        holder.price.setText(item.getPrice());
        holder.location.setText(item.getLocation());
        holder.distance.setText(item.getDistance());
        holder.rating.setRating(item.getRating());
        Glide.with(holder.thumb.getContext())
                .load(item.getThumb())
                .into(holder.thumb);

    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }
}