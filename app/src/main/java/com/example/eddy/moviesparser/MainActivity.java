package com.example.eddy.moviesparser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.eddy.moviesparser.Models.Movie;
import com.example.eddy.moviesparser.Models.Movies;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    ArrayList<Movie> moviesArrayList;

    @OnClick(R.id.button_movies)
    public void loadJSON() {
        RetrofitSingleton.getInstance().getRequestInterface().loadMovies()
                .enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                moviesArrayList = response.body().getMovies();
                initRecyclerView(moviesArrayList);
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void initRecyclerView(ArrayList list) {
        if (list != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(new RecyclerViewAdapter(moviesArrayList));
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }
}
