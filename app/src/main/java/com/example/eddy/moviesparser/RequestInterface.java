package com.example.eddy.moviesparser;

import com.example.eddy.moviesparser.Models.Movies;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by eddy on 1/4/2017.
 */

public interface RequestInterface {

    @GET("moviesData.txt")
    Call<Movies> loadMovies();
}
