package com.example.eddy.moviesparser.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by eddy on 1/4/2017.
 */

public class Movies implements Parcelable {

    private ArrayList<Movie> movies;


    private Movies(Parcel in) {
        movies = in.createTypedArrayList(Movie.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(movies);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
}

