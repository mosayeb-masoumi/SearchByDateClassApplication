package com.example.tornado.searchbydate_classapplication;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;

/**
 * Created by tornado on 12/23/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyHolder> implements Filterable {

    Context c;
    ArrayList<ModelPlayer> modelPlayers,filterList;
    CustomFilter filter;

    public MyAdapter(Context ctx,ArrayList<ModelPlayer> modelPlayers)
    {
        this.c=ctx;
        this.modelPlayers = modelPlayers;
        this.filterList= modelPlayers;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //CONVERT XML TO VIEW ONBJ
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,null);

        //HOLDER
        MyHolder holder=new MyHolder(v);

        return holder;
    }

    //DATA BOUND TO VIEWS
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        //BIND DATA
        holder.posTxt.setText(modelPlayers.get(position).getPos());
        holder.nameTxt.setText(modelPlayers.get(position).getName());
        holder.dateText.setText(modelPlayers.get(position).getDate());
        holder.img.setImageResource(modelPlayers.get(position).getImg());

        //IMPLEMENT CLICK LISTENET
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Snackbar.make(v, modelPlayers.get(pos).getName(),Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    //GET TOTAL NUM OF PLAYERS
    @Override
    public int getItemCount() {
        return modelPlayers.size();
    }

    //RETURN FILTER OBJ
    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }

        return filter;
    }
}
