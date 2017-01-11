package com.example.eddy.moviesparser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.eddy.moviesparser.Models.Movie;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    ArrayList<Movie> moviesArrayList;
    JSONLoader jsonLoader;

    @OnClick(R.id.button_movies)
    public void loadJSON() {
        jsonLoader = new JSONLoader(new Callback() {
            @Override
            public void onFinish(ArrayList<Movie> movies) {
                moviesArrayList = movies;
                initRecyclerView(moviesArrayList);
            }
        });
        jsonLoader.execute();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void initRecyclerView(ArrayList<Movie> list) {
        if (list != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(new RecyclerViewAdapter(moviesArrayList));
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (jsonLoader != null) {
            jsonLoader.cancel(true);
        }
    }
}
