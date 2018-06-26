package com.recom.www.recommenderapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.JsonObject;
import com.recom.www.recommenderapp.Models.Nearby_Model;
import com.recom.www.recommenderapp.Models.Recent_Model;
import com.recom.www.recommenderapp.R;

import java.util.List;

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.MyViewHolder> {

    private final List<JsonObject> jsonlist;
    private final Context context;
    private List<Nearby_Model> itemlist;

    public NearbyAdapter(List<JsonObject> jsonlist, int nearby_list, Context context) {
        this.jsonlist = jsonlist;
       // this.rowLayout = rowLayout;
        this.context = context;
    }


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




    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nearby_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        JsonObject item = jsonlist.get(position);
        holder.name.setText(String.valueOf(item.get("name")));
        holder.rating.setRating(Float.valueOf(String.valueOf(item.get("rating"))));
        holder.genre.setText(String.valueOf(item.get("category")));
        holder.value.setText( String.valueOf(item.get("value")));
        Glide.with(holder.img.getContext())
                .load(item.get("img_url"))
                .apply(new RequestOptions()

                        .centerCrop()
                )
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return jsonlist.size();
    }
}