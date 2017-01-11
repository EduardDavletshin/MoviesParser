package com.example.eddy.moviesparser.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by eddy on 1/4/2017.
 */

public class Movie implements Parcelable {

    private String movie;
    private int year;
    private float rating;
    private String duration;
    private String director;
    private String tagline;
    private ArrayList<Cast> cast;
    private String image;
    private String story;


    protected Movie(Parcel in) {
        movie = in.readString();
        year = in.readInt();
        rating = in.readFloat();
        duration = in.readString();
        director = in.readString();
        tagline = in.readString();
        cast = in.createTypedArrayList(Cast.CREATOR);
        image = in.readString();
        story = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public ArrayList<Cast> getCast() {
        return cast;
    }

    public void setCast(ArrayList<Cast> cast) {
        this.cast = cast;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movie);
        dest.writeInt(year);
        dest.writeFloat(rating);
        dest.writeString(duration);
        dest.writeString(director);
        dest.writeString(tagline);
        dest.writeTypedList(cast);
        dest.writeString(image);
        dest.writeString(story);
    }

}


