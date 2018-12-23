package com.example.tornado.searchbydate_classapplication;

import android.widget.Filter;

import java.util.ArrayList;

/**
 * Created by tornado on 12/23/2018.
 */

public class CustomFilter extends Filter {

    MyAdapter adapter;
    ArrayList<ModelPlayer> filterList;

    public CustomFilter(ArrayList<ModelPlayer> filterList, MyAdapter adapter)
    {
        this.adapter=adapter;
        this.filterList=filterList;

    }

    //FILTERING OCURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();

        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<ModelPlayer> filteredModelPlayers =new ArrayList<>();

            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getDate().toUpperCase().contains(constraint))// filter by date or name or...
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredModelPlayers.add(filterList.get(i));
                }
            }

            results.count= filteredModelPlayers.size();
            results.values= filteredModelPlayers;
        }else
        {
            results.count=filterList.size();
            results.values=filterList;

        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.modelPlayers = (ArrayList<ModelPlayer>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();
    }
}
