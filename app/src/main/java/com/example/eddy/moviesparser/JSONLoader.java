package com.example.eddy.moviesparser;

import android.os.AsyncTask;

import com.example.eddy.moviesparser.Models.Movie;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by eddy on 1/9/2017.
 */

class JSONLoader extends AsyncTask {

    private ArrayList<Movie> movies;
    private Callback callback;

    JSONLoader(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected ArrayList<Movie> doInBackground(Object[] params) {
        try {
            movies = RetrofitSingleton.getInstance().getRequestInterface().loadMovies()
                    .execute().body().getMovies();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        callback.onFinish(movies);
    }
}
