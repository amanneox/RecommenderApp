package com.recom.www.recommenderapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.recom.www.recommenderapp.Models.Nearby_Model;
import com.recom.www.recommenderapp.Models.Recent_Model;
import com.recom.www.recommenderapp.R;

import java.util.List;

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.MyViewHolder> {

    private List<Nearby_Model> itemlist;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,value,genre;
        public RatingBar rating;
        public ImageView img;

        public MyViewHolder(View view) {
            super(view);
            name=view.findViewById(R.id.name);
            value=view.findViewById(R.id.value);
            genre=view.findViewById(R.id.genre);
            rating=view.findViewById(R.id.ratingbar);
            img=view.findViewById(R.id.pager);
        }
    }


    public NearbyAdapter(List<Nearby_Model> itemlist) {
        this.itemlist = itemlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nearby_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Nearby_Model item = itemlist.get(position);
        holder.name.setText(item.getName());
        holder.rating.setRating(item.getRating());
        holder.genre.setText(item.getGenre());
        holder.value.setText(item.getValue());
        Glide.with(holder.img.getContext())
                .load(item.getImgUrl())
                .apply(new RequestOptions()

                        .centerCrop()
                )
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }
}