package com.recom.www.recommenderapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.recom.www.recommenderapp.Models.Home_Model;
import com.recom.www.recommenderapp.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private List<Home_Model> itemlist;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, mile, genre,name,price;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            mile = (TextView) view.findViewById(R.id.mile);
            name=(TextView)view.findViewById(R.id.name);
            image=view.findViewById(R.id.image);
            price=view.findViewById(R.id.price);
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
        holder.mile.setText(item.getMile());
        holder.name.setText(item.getName());
        holder.price.setText(item.getPrice());
        Glide.with(holder.image.getContext())
                .load(item.getImgUrl())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }
}