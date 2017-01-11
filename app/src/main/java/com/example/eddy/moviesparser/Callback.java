package com.example.eddy.moviesparser;

import com.example.eddy.moviesparser.Models.Movie;

import java.util.ArrayList;

/**
 * Created by eddy on 1/9/2017.
 */

interface Callback {
    void onFinish(ArrayList<Movie> movies);
}
