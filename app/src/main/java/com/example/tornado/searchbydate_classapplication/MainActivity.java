package com.example.tornado.searchbydate_classapplication;

//http://camposha.info/source/android-recyclerview-search-filter
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SearchView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        sv= (SearchView) findViewById(R.id.mSearch);
        RecyclerView rv= (RecyclerView) findViewById(R.id.myRecycler);

        //SET ITS PROPETRIES
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());

        //ADAPTER
        final MyAdapter adapter=new MyAdapter(this,getPlayers());
        rv.setAdapter(adapter);

        //SEARCH
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                adapter.getFilter().filter(query);
                return false;
            }
        });

    }

    //ADD PLAYERS TO ARRAYLIST
    private ArrayList<ModelPlayer> getPlayers()
    {
        ArrayList<ModelPlayer> modelPlayers =new ArrayList<>();
        ModelPlayer p=new ModelPlayer();
        p.setName("Ander Herera");
        p.setPos("Midfielder");
        p.setDate("97/10/10");
        p.setImg(R.drawable.ic_launcher_background);
        modelPlayers.add(p);

        p=new ModelPlayer();
        p.setName("David De Geaa");
        p.setPos("Goalkeeper");
        p.setDate("97/10/11");
        p.setImg(R.drawable.ic_launcher_background);
        modelPlayers.add(p);

        p=new ModelPlayer();
        p.setName("Michael Carrick");
        p.setPos("Midfielder");
        p.setDate("97/10/12");
        p.setImg(R.drawable.ic_launcher_background);
        modelPlayers.add(p);

        p=new ModelPlayer();
        p.setName("Juan Mata");
        p.setPos("Playmaker");
        p.setDate("97/10/13");
        p.setImg(R.drawable.ic_launcher_background);
        modelPlayers.add(p);

        p=new ModelPlayer();
        p.setName("Diego Costa");
        p.setPos("Striker");
        p.setDate("97/10/14");
        p.setImg(R.drawable.ic_launcher_background);
        modelPlayers.add(p);

        p=new ModelPlayer();
        p.setName("Oscar");
        p.setPos("Playmaker");
        p.setDate("97/10/15");
        p.setImg(R.drawable.ic_launcher_background);
        modelPlayers.add(p);

        return modelPlayers;
    }

}
